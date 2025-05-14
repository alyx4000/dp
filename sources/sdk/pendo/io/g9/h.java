package sdk.pendo.io.g9;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public class h {

    public interface a {
        void a(long j);
    }

    public static void a(File file) {
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                randomAccessFile = a(file, "rwd");
                if (randomAccessFile != null) {
                    randomAccessFile.setLength(0L);
                } else {
                    PendoLogger.d("Could not clear buffer file due to an IOException and it being null.", new Object[0]);
                }
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
            }
        } finally {
            a(randomAccessFile);
        }
    }

    public static boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            File file = new File(context.getCacheDir(), str);
            if (file.exists()) {
                return file.delete();
            }
        }
        return false;
    }

    public static synchronized boolean c(Context context, String str) {
        boolean delete;
        synchronized (h.class) {
            if (context != null) {
                try {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            delete = a(context, str).delete();
                            if (delete) {
                                PendoLogger.i("Deleted cache file.", new Object[0]);
                            } else {
                                PendoLogger.w("Could not delete the file!", new Object[0]);
                            }
                        }
                    } catch (Exception e) {
                        PendoLogger.e(e, e.getMessage(), "file: " + str);
                        return false;
                    }
                } catch (IOException e2) {
                    PendoLogger.e(e2, "Could not delete the file!", "file: " + str);
                    return false;
                }
            }
            throw new sdk.pendo.io.i8.i("Could not delete the file! check context/filename ");
        }
        return delete;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b9: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:53:0x00b9 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(android.content.Context r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.g9.h.d(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "FileUtils - Unable to close cache file"
            r1 = 0
            if (r7 == 0) goto L90
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            if (r2 == 0) goto Ld
            goto L90
        Ld:
            java.io.File r2 = new java.io.File
            java.io.File r7 = r7.getCacheDir()
            r2.<init>(r7, r8)
            r7 = 0
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4e java.io.FileNotFoundException -> L62
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4e java.io.FileNotFoundException -> L62
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4e java.io.FileNotFoundException -> L62
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4e java.io.FileNotFoundException -> L62
            java.nio.charset.Charset r5 = java.nio.charset.Charset.defaultCharset()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4e java.io.FileNotFoundException -> L62
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4e java.io.FileNotFoundException -> L62
            r8.<init>(r3)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4e java.io.FileNotFoundException -> L62
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4f java.io.FileNotFoundException -> L63
            r3.<init>()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4f java.io.FileNotFoundException -> L63
        L2f:
            java.lang.String r4 = r8.readLine()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4f java.io.FileNotFoundException -> L63
            if (r4 == 0) goto L39
            r3.append(r4)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4f java.io.FileNotFoundException -> L63
            goto L2f
        L39:
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4f java.io.FileNotFoundException -> L63
            r8.close()     // Catch: java.io.IOException -> L41
            goto L46
        L41:
            java.lang.Object[] r7 = new java.lang.Object[r7]
            sdk.pendo.io.logging.PendoLogger.e(r0, r7)
        L46:
            return r1
        L47:
            r1 = move-exception
            goto L84
        L49:
            r8 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto L84
        L4e:
            r8 = r1
        L4f:
            java.lang.String r2 = "FileUtils - Error occurred while reading cache file"
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L47
            sdk.pendo.io.logging.PendoLogger.e(r2, r3)     // Catch: java.lang.Throwable -> L47
            if (r8 == 0) goto L83
            r8.close()     // Catch: java.io.IOException -> L5c
            goto L83
        L5c:
            java.lang.Object[] r7 = new java.lang.Object[r7]
            sdk.pendo.io.logging.PendoLogger.e(r0, r7)
            goto L83
        L62:
            r8 = r1
        L63:
            boolean r2 = r2.createNewFile()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L71
            if (r2 == 0) goto L78
            java.lang.String r2 = "FileUtils - file has been created"
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L71
            sdk.pendo.io.logging.PendoLogger.i(r2, r3)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L71
            goto L78
        L71:
            java.lang.String r2 = "FileUtils - Error occurred while create cache file"
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L47
            sdk.pendo.io.logging.PendoLogger.e(r2, r3)     // Catch: java.lang.Throwable -> L47
        L78:
            if (r8 == 0) goto L83
            r8.close()     // Catch: java.io.IOException -> L7e
            goto L83
        L7e:
            java.lang.Object[] r7 = new java.lang.Object[r7]
            sdk.pendo.io.logging.PendoLogger.e(r0, r7)
        L83:
            return r1
        L84:
            if (r8 == 0) goto L8f
            r8.close()     // Catch: java.io.IOException -> L8a
            goto L8f
        L8a:
            java.lang.Object[] r7 = new java.lang.Object[r7]
            sdk.pendo.io.logging.PendoLogger.e(r0, r7)
        L8f:
            throw r1
        L90:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.g9.h.e(android.content.Context, java.lang.String):java.lang.String");
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                PendoLogger.w("FileUils->", "closeFile, " + e.getMessage());
            }
        }
    }

    public static File a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new sdk.pendo.io.i8.i("Cannot create cache file check context/filename ");
        }
        File file = new File(context.getFilesDir(), str);
        if (file.exists() || file.createNewFile()) {
            return file;
        }
        throw new sdk.pendo.io.i8.f("Cannot create cache file");
    }

    public static void a(Context context, byte[] bArr, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                a(context, str);
                fileOutputStream = context.openFileOutput(str, 0);
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    PendoLogger.e(e, e.getMessage(), new Object[0]);
                }
            } catch (Exception e2) {
                PendoLogger.e(e2, e2.getMessage(), "file: " + str);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        PendoLogger.e(e3, e3.getMessage(), new Object[0]);
                    }
                }
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    PendoLogger.e(e4, e4.getMessage(), new Object[0]);
                }
            }
            throw th;
        }
    }

    private static RandomAccessFile a(File file, String str) {
        if (file != null) {
            return new RandomAccessFile(file.getPath(), str);
        }
        return null;
    }

    public static String a(File file, long j, a aVar) {
        String str = "";
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                randomAccessFile = a(file, "r");
                if (randomAccessFile == null || j < 0) {
                    PendoLogger.d("Could not read from file because buffer file is null due to an IOException.", new Object[0]);
                } else {
                    byte[] bArr = new byte[(int) (randomAccessFile.length() - j)];
                    randomAccessFile.seek(j);
                    randomAccessFile.readFully(bArr);
                    str = m0.b(bArr);
                    if (j == 0 && aVar != null) {
                        aVar.a(randomAccessFile.getFilePointer());
                    }
                }
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
            }
            return str;
        } finally {
            a(randomAccessFile);
        }
    }

    public static boolean a(Context context, String str, String str2) {
        return a(context, str, str2, context.getCacheDir());
    }

    private static boolean a(Context context, String str, String str2, File file) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file2 = new File(file, str2);
        if (file2.exists() && file2.delete()) {
            PendoLogger.i("Logger", "file is removed");
        }
        try {
            File file3 = new File(file, str2);
            if (!file3.createNewFile()) {
                return true;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file3), Charset.forName("UTF-8"));
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            return true;
        } catch (IOException unused) {
            PendoLogger.e("Logger", "Error occurred while saveString2File log file");
            return true;
        }
    }

    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (Exception e) {
            e = e;
        }
        if (file == null) {
            PendoLogger.d("Could not write to file because of an IOException causing buffer file to be null.", new Object[0]);
            a(fileOutputStream2);
            return false;
        }
        fileOutputStream = new FileOutputStream(file.getPath(), true);
        try {
            fileOutputStream.write(bArr);
            a(fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            PendoLogger.e(e, e.getMessage(), "file: " + file.getAbsolutePath());
            a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            a(fileOutputStream);
            throw th;
        }
    }
}
