package external.sdk.pendo.io.mozilla.javascript.tools.jsc;

import external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons;
import external.sdk.pendo.io.mozilla.javascript.optimizer.ClassCompiler;
import external.sdk.pendo.io.mozilla.javascript.tools.SourceReader;
import external.sdk.pendo.io.mozilla.javascript.tools.ToolErrorReporter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import sdk.pendo.io.models.SessionDataKt;

/* loaded from: classes2.dex */
public class Main {
    private String characterEncoding;
    private ClassCompiler compiler;
    private CompilerEnvirons compilerEnv;
    private String destinationDir;
    private boolean printHelp;
    private ToolErrorReporter reporter = new ToolErrorReporter(true);
    private String targetName;
    private String targetPackage;

    public Main() {
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        this.compilerEnv = compilerEnvirons;
        compilerEnvirons.setErrorReporter(this.reporter);
        this.compiler = new ClassCompiler(this.compilerEnv);
    }

    private void addError(String str, String str2) {
        addFormatedError(str2 == null ? ToolErrorReporter.getMessage(str) : ToolErrorReporter.getMessage(str, str2));
    }

    private void addFormatedError(String str) {
        this.reporter.error(str, null, -1, null, -1);
    }

    private static void badUsage(String str) {
        System.err.println(ToolErrorReporter.getMessage("msg.jsc.bad.usage", Main.class.getName(), str));
    }

    private File getOutputFile(File file, String str) {
        File file2 = new File(file, str.replace('.', File.separatorChar).concat(".class"));
        String parent = file2.getParent();
        if (parent != null) {
            File file3 = new File(parent);
            if (!file3.exists() && !file3.mkdirs()) {
                throw new IOException("Error making output directory " + parent);
            }
        }
        return file2;
    }

    public static void main(String[] strArr) {
        Main main = new Main();
        String[] processOptions = main.processOptions(strArr);
        if (processOptions == null) {
            if (main.printHelp) {
                System.out.println(ToolErrorReporter.getMessage("msg.jsc.usage", Main.class.getName()));
                System.exit(0);
            }
            System.exit(1);
        }
        if (main.reporter.hasReportedError()) {
            return;
        }
        main.processSource(processOptions);
    }

    private static void p(String str) {
        System.out.println(str);
    }

    private String readSource(File file) {
        String absolutePath = file.getAbsolutePath();
        if (!file.isFile()) {
            addError("msg.jsfile.not.found", absolutePath);
            return null;
        }
        try {
            return (String) SourceReader.readFileOrUrl(absolutePath, true, this.characterEncoding);
        } catch (FileNotFoundException unused) {
            addError("msg.couldnt.open", absolutePath);
            return null;
        } catch (IOException e) {
            addFormatedError(e.toString());
            return null;
        }
    }

    String getClassName(String str) {
        int i = 1;
        char[] cArr = new char[str.length() + 1];
        int i2 = 0;
        if (Character.isJavaIdentifierStart(str.charAt(0))) {
            i = 0;
        } else {
            cArr[0] = SessionDataKt.UNDERSCORE;
        }
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (Character.isJavaIdentifierPart(charAt)) {
                cArr[i] = charAt;
            } else {
                cArr[i] = SessionDataKt.UNDERSCORE;
            }
            i2++;
            i++;
        }
        return new String(cArr).trim();
    }

    public String[] processOptions(String[] strArr) {
        this.targetPackage = "";
        this.compilerEnv.setGenerateDebugInfo(false);
        int i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            if (!str.startsWith("-")) {
                int length = strArr.length - i;
                String str2 = this.targetName;
                if (str2 != null && length > 1) {
                    addError("msg.multiple.js.to.file", str2);
                    return null;
                }
                String[] strArr2 = new String[length];
                for (int i2 = 0; i2 != length; i2++) {
                    strArr2[i2] = strArr[i + i2];
                }
                return strArr2;
            }
            if (str.equals("-help") || str.equals("-h") || str.equals("--help")) {
                this.printHelp = true;
                return null;
            }
            try {
                if (str.equals("-version") && (i = i + 1) < strArr.length) {
                    this.compilerEnv.setLanguageVersion(Integer.parseInt(strArr[i]));
                } else if ((str.equals("-opt") || str.equals("-O")) && (i = i + 1) < strArr.length) {
                    this.compilerEnv.setOptimizationLevel(Integer.parseInt(strArr[i]));
                } else if (str.equals("-nosource")) {
                    this.compilerEnv.setGeneratingSource(false);
                } else if (str.equals("-debug") || str.equals("-g")) {
                    this.compilerEnv.setGenerateDebugInfo(true);
                } else if (str.equals("-main-method-class") && (i = i + 1) < strArr.length) {
                    this.compiler.setMainMethodClass(strArr[i]);
                } else if (str.equals("-encoding") && (i = i + 1) < strArr.length) {
                    this.characterEncoding = strArr[i];
                } else if (!str.equals("-o") || (i = i + 1) >= strArr.length) {
                    if (str.equals("-observe-instruction-count")) {
                        this.compilerEnv.setGenerateObserverCount(true);
                    }
                    if (str.equals("-package") && (i = i + 1) < strArr.length) {
                        String str3 = strArr[i];
                        int length2 = str3.length();
                        int i3 = 0;
                        while (i3 != length2) {
                            char charAt = str3.charAt(i3);
                            if (Character.isJavaIdentifierStart(charAt)) {
                                do {
                                    i3++;
                                    if (i3 == length2) {
                                        break;
                                    }
                                    charAt = str3.charAt(i3);
                                } while (Character.isJavaIdentifierPart(charAt));
                                if (i3 == length2) {
                                    break;
                                }
                                if (charAt == '.' && i3 != length2 - 1) {
                                    i3++;
                                }
                            }
                            addError("msg.package.name", this.targetPackage);
                            return null;
                        }
                        this.targetPackage = str3;
                    } else if (str.equals("-extends") && (i = i + 1) < strArr.length) {
                        try {
                            this.compiler.setTargetExtends(Class.forName(strArr[i]));
                        } catch (ClassNotFoundException e) {
                            throw new Error(e.toString());
                        }
                    } else if (str.equals("-implements") && (i = i + 1) < strArr.length) {
                        StringTokenizer stringTokenizer = new StringTokenizer(strArr[i], ",");
                        ArrayList arrayList = new ArrayList();
                        while (stringTokenizer.hasMoreTokens()) {
                            try {
                                arrayList.add(Class.forName(stringTokenizer.nextToken()));
                            } catch (ClassNotFoundException e2) {
                                throw new Error(e2.toString());
                            }
                        }
                        this.compiler.setTargetImplements((Class[]) arrayList.toArray(new Class[arrayList.size()]));
                    } else {
                        if (!str.equals("-d") || (i = i + 1) >= strArr.length) {
                            badUsage(str);
                            return null;
                        }
                        this.destinationDir = strArr[i];
                    }
                } else {
                    String str4 = strArr[i];
                    int length3 = str4.length();
                    if (length3 == 0 || !Character.isJavaIdentifierStart(str4.charAt(0))) {
                        addError("msg.invalid.classfile.name", str4);
                    } else {
                        int i4 = 1;
                        while (true) {
                            if (i4 >= length3) {
                                break;
                            }
                            char charAt2 = str4.charAt(i4);
                            if (Character.isJavaIdentifierPart(charAt2)) {
                                i4++;
                            } else if (charAt2 == '.' && i4 == length3 - 6 && str4.endsWith(".class")) {
                                str4 = str4.substring(0, i4);
                            } else {
                                addError("msg.invalid.classfile.name", str4);
                            }
                        }
                        this.targetName = str4;
                    }
                }
                i++;
            } catch (NumberFormatException unused) {
                badUsage(strArr[i]);
                return null;
            }
        }
        p(ToolErrorReporter.getMessage("msg.no.file"));
        return null;
    }

    public void processSource(String[] strArr) {
        File file;
        for (int i = 0; i != strArr.length; i++) {
            String str = strArr[i];
            if (!str.endsWith(".js")) {
                addError("msg.extension.not.js", str);
                return;
            }
            File file2 = new File(str);
            String readSource = readSource(file2);
            if (readSource == null) {
                return;
            }
            String str2 = this.targetName;
            if (str2 == null) {
                str2 = getClassName(file2.getName().substring(0, r5.length() - 3));
            }
            if (this.targetPackage.length() != 0) {
                str2 = this.targetPackage + "." + str2;
            }
            Object[] compileToClassFiles = this.compiler.compileToClassFiles(readSource, str, 1, str2);
            if (compileToClassFiles == null || compileToClassFiles.length == 0) {
                return;
            }
            if (this.destinationDir != null) {
                file = new File(this.destinationDir);
            } else {
                String parent = file2.getParent();
                file = parent != null ? new File(parent) : null;
            }
            for (int i2 = 0; i2 != compileToClassFiles.length; i2 += 2) {
                String str3 = (String) compileToClassFiles[i2];
                byte[] bArr = (byte[]) compileToClassFiles[i2 + 1];
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(getOutputFile(file, str3));
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (IOException e) {
                    addFormatedError(e.toString());
                }
            }
        }
    }
}
