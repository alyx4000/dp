package external.sdk.pendo.io.mozilla.javascript;

import androidx.webkit.ProxyConfig;
import external.sdk.pendo.io.mozilla.javascript.Token;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayComprehension;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.Assignment;
import external.sdk.pendo.io.mozilla.javascript.ast.AstNode;
import external.sdk.pendo.io.mozilla.javascript.ast.AstRoot;
import external.sdk.pendo.io.mozilla.javascript.ast.Block;
import external.sdk.pendo.io.mozilla.javascript.ast.BreakStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.CatchClause;
import external.sdk.pendo.io.mozilla.javascript.ast.Comment;
import external.sdk.pendo.io.mozilla.javascript.ast.ConditionalExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.ContinueStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.DestructuringForm;
import external.sdk.pendo.io.mozilla.javascript.ast.DoLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.ElementGet;
import external.sdk.pendo.io.mozilla.javascript.ast.EmptyExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.EmptyStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.ErrorNode;
import external.sdk.pendo.io.mozilla.javascript.ast.ExpressionStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionCall;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.GeneratorExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.GeneratorExpressionLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.IdeErrorReporter;
import external.sdk.pendo.io.mozilla.javascript.ast.IfStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.InfixExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.Jump;
import external.sdk.pendo.io.mozilla.javascript.ast.KeywordLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.Label;
import external.sdk.pendo.io.mozilla.javascript.ast.LabeledStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.LetNode;
import external.sdk.pendo.io.mozilla.javascript.ast.Loop;
import external.sdk.pendo.io.mozilla.javascript.ast.Name;
import external.sdk.pendo.io.mozilla.javascript.ast.NewExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.NumberLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.ObjectLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.ObjectProperty;
import external.sdk.pendo.io.mozilla.javascript.ast.ParenthesizedExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.PropertyGet;
import external.sdk.pendo.io.mozilla.javascript.ast.RegExpLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.ReturnStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.Scope;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import external.sdk.pendo.io.mozilla.javascript.ast.StringLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.SwitchCase;
import external.sdk.pendo.io.mozilla.javascript.ast.SwitchStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.ThrowStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.TryStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.UnaryExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.VariableDeclaration;
import external.sdk.pendo.io.mozilla.javascript.ast.VariableInitializer;
import external.sdk.pendo.io.mozilla.javascript.ast.WhileLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.WithStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlDotQuery;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlElemRef;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlPropRef;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlString;
import external.sdk.pendo.io.mozilla.javascript.ast.Yield;
import io.sentry.SentryEnvelopeItemHeader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class Parser {
    public static final int ARGC_LIMIT = 65536;
    static final int CLEAR_TI_MASK = 65535;
    private static final int GET_ENTRY = 2;
    private static final int METHOD_ENTRY = 8;
    private static final int PROP_ENTRY = 1;
    private static final int SET_ENTRY = 4;
    static final int TI_AFTER_EOL = 65536;
    static final int TI_CHECK_LABEL = 131072;
    boolean calledByCompileFunction;
    CompilerEnvirons compilerEnv;
    private int currentFlaggedToken;
    private Comment currentJsDocComment;
    private LabeledStatement currentLabel;
    Scope currentScope;
    ScriptNode currentScriptOrFn;
    private int currentToken;
    private boolean defaultUseStrictDirective;
    private int endFlags;
    private IdeErrorReporter errorCollector;
    private ErrorReporter errorReporter;
    private boolean inDestructuringAssignment;
    private boolean inForInit;
    protected boolean inUseStrictDirective;
    private Map<String, LabeledStatement> labelSet;
    private List<Jump> loopAndSwitchSet;
    private List<Loop> loopSet;
    protected int nestingOfFunction;
    private boolean parseFinished;
    private int prevNameTokenLineno;
    private int prevNameTokenStart;
    private String prevNameTokenString;
    private List<Comment> scannedComments;
    private char[] sourceChars;
    private String sourceURI;
    private int syntaxErrorCount;
    private TokenStream ts;

    private static class ConditionData {
        AstNode condition;
        int lp;
        int rp;

        private ConditionData() {
            this.lp = -1;
            this.rp = -1;
        }
    }

    private static class ParserException extends RuntimeException {
        private static final long serialVersionUID = 5882582646773765630L;

        private ParserException() {
        }
    }

    protected class PerFunctionVariables {
        private Scope savedCurrentScope;
        private ScriptNode savedCurrentScriptOrFn;
        private int savedEndFlags;
        private boolean savedInForInit;
        private Map<String, LabeledStatement> savedLabelSet;
        private List<Jump> savedLoopAndSwitchSet;
        private List<Loop> savedLoopSet;

        PerFunctionVariables(FunctionNode functionNode) {
            this.savedCurrentScriptOrFn = Parser.this.currentScriptOrFn;
            Parser.this.currentScriptOrFn = functionNode;
            this.savedCurrentScope = Parser.this.currentScope;
            Parser.this.currentScope = functionNode;
            this.savedLabelSet = Parser.this.labelSet;
            Parser.this.labelSet = null;
            this.savedLoopSet = Parser.this.loopSet;
            Parser.this.loopSet = null;
            this.savedLoopAndSwitchSet = Parser.this.loopAndSwitchSet;
            Parser.this.loopAndSwitchSet = null;
            this.savedEndFlags = Parser.this.endFlags;
            Parser.this.endFlags = 0;
            this.savedInForInit = Parser.this.inForInit;
            Parser.this.inForInit = false;
        }

        void restore() {
            Parser parser = Parser.this;
            parser.currentScriptOrFn = this.savedCurrentScriptOrFn;
            parser.currentScope = this.savedCurrentScope;
            parser.labelSet = this.savedLabelSet;
            Parser.this.loopSet = this.savedLoopSet;
            Parser.this.loopAndSwitchSet = this.savedLoopAndSwitchSet;
            Parser.this.endFlags = this.savedEndFlags;
            Parser.this.inForInit = this.savedInForInit;
        }
    }

    public Parser() {
        this(new CompilerEnvirons());
    }

    private AstNode addExpr() {
        AstNode mulExpr = mulExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (peekToken != 21 && peekToken != 22) {
                return mulExpr;
            }
            consumeToken();
            mulExpr = new InfixExpression(peekToken, mulExpr, mulExpr(), i);
        }
    }

    private AstNode andExpr() {
        AstNode bitOrExpr = bitOrExpr();
        if (!matchToken(106, true)) {
            return bitOrExpr;
        }
        return new InfixExpression(106, bitOrExpr, andExpr(), this.ts.tokenBeg);
    }

    private List<AstNode> argumentList() {
        if (matchToken(89, true)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.inForInit;
        this.inForInit = false;
        do {
            try {
                if (peekToken() == 89) {
                    break;
                }
                if (peekToken() == 73) {
                    reportError("msg.yield.parenthesized");
                }
                AstNode assignExpr = assignExpr();
                if (peekToken() == 120) {
                    try {
                        arrayList.add(generatorExpression(assignExpr, 0, true));
                    } catch (IOException unused) {
                    }
                } else {
                    arrayList.add(assignExpr);
                }
            } catch (Throwable th) {
                this.inForInit = z;
                throw th;
            }
        } while (matchToken(90, true));
        this.inForInit = z;
        mustMatchToken(89, "msg.no.paren.arg", true);
        return arrayList;
    }

    private AstNode arrayComprehension(AstNode astNode, int i) {
        int i2;
        ConditionData conditionData;
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 120) {
            arrayList.add(arrayComprehensionLoop());
        }
        if (peekToken() == 113) {
            consumeToken();
            i2 = this.ts.tokenBeg - i;
            conditionData = condition();
        } else {
            i2 = -1;
            conditionData = null;
        }
        mustMatchToken(85, "msg.no.bracket.arg", true);
        ArrayComprehension arrayComprehension = new ArrayComprehension(i, this.ts.tokenEnd - i);
        arrayComprehension.setResult(astNode);
        arrayComprehension.setLoops(arrayList);
        if (conditionData != null) {
            arrayComprehension.setIfPosition(i2);
            arrayComprehension.setFilter(conditionData.condition);
            arrayComprehension.setFilterLp(conditionData.lp - i);
            arrayComprehension.setFilterRp(conditionData.rp - i);
        }
        return arrayComprehension;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[Catch: all -> 0x00ef, TryCatch #0 {all -> 0x00ef, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:12:0x003b, B:14:0x0043, B:15:0x004a, B:21:0x0058, B:22:0x006e, B:24:0x0074, B:25:0x007f, B:30:0x00ae, B:32:0x00b5, B:34:0x00c3, B:35:0x00ca, B:38:0x00e2, B:45:0x008b, B:46:0x0092, B:49:0x00a2, B:50:0x00a7, B:51:0x005f, B:52:0x0067, B:54:0x0037), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0074 A[Catch: all -> 0x00ef, TryCatch #0 {all -> 0x00ef, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:12:0x003b, B:14:0x0043, B:15:0x004a, B:21:0x0058, B:22:0x006e, B:24:0x0074, B:25:0x007f, B:30:0x00ae, B:32:0x00b5, B:34:0x00c3, B:35:0x00ca, B:38:0x00e2, B:45:0x008b, B:46:0x0092, B:49:0x00a2, B:50:0x00a7, B:51:0x005f, B:52:0x0067, B:54:0x0037), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3 A[Catch: all -> 0x00ef, TryCatch #0 {all -> 0x00ef, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:12:0x003b, B:14:0x0043, B:15:0x004a, B:21:0x0058, B:22:0x006e, B:24:0x0074, B:25:0x007f, B:30:0x00ae, B:32:0x00b5, B:34:0x00c3, B:35:0x00ca, B:38:0x00e2, B:45:0x008b, B:46:0x0092, B:49:0x00a2, B:50:0x00a7, B:51:0x005f, B:52:0x0067, B:54:0x0037), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092 A[Catch: all -> 0x00ef, TryCatch #0 {all -> 0x00ef, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:12:0x003b, B:14:0x0043, B:15:0x004a, B:21:0x0058, B:22:0x006e, B:24:0x0074, B:25:0x007f, B:30:0x00ae, B:32:0x00b5, B:34:0x00c3, B:35:0x00ca, B:38:0x00e2, B:45:0x008b, B:46:0x0092, B:49:0x00a2, B:50:0x00a7, B:51:0x005f, B:52:0x0067, B:54:0x0037), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0067 A[Catch: all -> 0x00ef, TryCatch #0 {all -> 0x00ef, blocks: (B:6:0x001a, B:9:0x0023, B:11:0x0031, B:12:0x003b, B:14:0x0043, B:15:0x004a, B:21:0x0058, B:22:0x006e, B:24:0x0074, B:25:0x007f, B:30:0x00ae, B:32:0x00b5, B:34:0x00c3, B:35:0x00ca, B:38:0x00e2, B:45:0x008b, B:46:0x0092, B:49:0x00a2, B:50:0x00a7, B:51:0x005f, B:52:0x0067, B:54:0x0037), top: B:5:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.ast.ArrayComprehensionLoop arrayComprehensionLoop() {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Parser.arrayComprehensionLoop():external.sdk.pendo.io.mozilla.javascript.ast.ArrayComprehensionLoop");
    }

    private AstNode arrayLiteral() {
        if (this.currentToken != 84) {
            codeBug();
        }
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.tokenEnd;
        ArrayList arrayList = new ArrayList();
        ArrayLiteral arrayLiteral = new ArrayLiteral(i);
        int i3 = 0;
        int i4 = -1;
        loop0: while (true) {
            int i5 = 1;
            while (true) {
                int peekToken = peekToken();
                if (peekToken == 90) {
                    consumeToken();
                    i4 = this.ts.tokenEnd;
                    if (i5 == 0) {
                        break;
                    }
                    arrayList.add(new EmptyExpression(this.ts.tokenBeg, 1));
                    i3++;
                } else if (peekToken == 162) {
                    consumeToken();
                } else if (peekToken == 85) {
                    consumeToken();
                    i2 = this.ts.tokenEnd;
                    arrayLiteral.setDestructuringLength(arrayList.size() + i5);
                    arrayLiteral.setSkipCount(i3);
                    if (i4 != -1) {
                        warnTrailingComma(i, arrayList, i4);
                    }
                } else {
                    if (peekToken == 120 && i5 == 0 && arrayList.size() == 1) {
                        return arrayComprehension((AstNode) arrayList.get(0), i);
                    }
                    if (peekToken == 0) {
                        reportError("msg.no.bracket.arg");
                        break loop0;
                    }
                    if (i5 == 0) {
                        reportError("msg.no.bracket.arg");
                    }
                    arrayList.add(assignExpr());
                    i5 = 0;
                    i4 = -1;
                }
            }
        }
        Iterator<?> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayLiteral.addElement((AstNode) it.next());
        }
        arrayLiteral.setLength(i2 - i);
        return arrayLiteral;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
    
        if ((r10 instanceof external.sdk.pendo.io.mozilla.javascript.ast.EmptyExpression) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.ast.AstNode arrowFunction(external.sdk.pendo.io.mozilla.javascript.ast.AstNode r10) {
        /*
            r9 = this;
            external.sdk.pendo.io.mozilla.javascript.TokenStream r0 = r9.ts
            int r0 = r0.lineno
            if (r10 == 0) goto Lb
            int r1 = r10.getPosition()
            goto Lc
        Lb:
            r1 = -1
        Lc:
            external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode r2 = new external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode
            r2.<init>(r1)
            r3 = 4
            r2.setFunctionType(r3)
            external.sdk.pendo.io.mozilla.javascript.ast.Comment r4 = r9.getAndResetJsDoc()
            r2.setJsDocNode(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            external.sdk.pendo.io.mozilla.javascript.Parser$PerFunctionVariables r6 = new external.sdk.pendo.io.mozilla.javascript.Parser$PerFunctionVariables
            r6.<init>(r2)
            boolean r7 = r10 instanceof external.sdk.pendo.io.mozilla.javascript.ast.ParenthesizedExpression     // Catch: java.lang.Throwable -> Lbd
            if (r7 == 0) goto L41
            int r7 = r10.getLength()     // Catch: java.lang.Throwable -> Lbd
            r8 = 0
            r2.setParens(r8, r7)     // Catch: java.lang.Throwable -> Lbd
            external.sdk.pendo.io.mozilla.javascript.ast.ParenthesizedExpression r10 = (external.sdk.pendo.io.mozilla.javascript.ast.ParenthesizedExpression) r10     // Catch: java.lang.Throwable -> Lbd
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r10 = r10.getExpression()     // Catch: java.lang.Throwable -> Lbd
            boolean r7 = r10 instanceof external.sdk.pendo.io.mozilla.javascript.ast.EmptyExpression     // Catch: java.lang.Throwable -> Lbd
            if (r7 != 0) goto L44
        L41:
            r9.arrowFunctionParams(r2, r10, r4, r5)     // Catch: java.lang.Throwable -> Lbd
        L44:
            boolean r10 = r4.isEmpty()     // Catch: java.lang.Throwable -> Lbd
            if (r10 != 0) goto L84
            external.sdk.pendo.io.mozilla.javascript.Node r10 = new external.sdk.pendo.io.mozilla.javascript.Node     // Catch: java.lang.Throwable -> Lbd
            r5 = 90
            r10.<init>(r5)     // Catch: java.lang.Throwable -> Lbd
            java.util.Set r4 = r4.entrySet()     // Catch: java.lang.Throwable -> Lbd
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> Lbd
        L59:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> Lbd
            if (r5 == 0) goto L7f
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> Lbd
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r7 = r5.getValue()     // Catch: java.lang.Throwable -> Lbd
            external.sdk.pendo.io.mozilla.javascript.Node r7 = (external.sdk.pendo.io.mozilla.javascript.Node) r7     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r5 = r5.getKey()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> Lbd
            external.sdk.pendo.io.mozilla.javascript.Node r5 = r9.createName(r5)     // Catch: java.lang.Throwable -> Lbd
            r8 = 123(0x7b, float:1.72E-43)
            external.sdk.pendo.io.mozilla.javascript.Node r5 = r9.createDestructuringAssignment(r8, r7, r5)     // Catch: java.lang.Throwable -> Lbd
            r10.addChildToBack(r5)     // Catch: java.lang.Throwable -> Lbd
            goto L59
        L7f:
            r4 = 23
            r2.putProp(r4, r10)     // Catch: java.lang.Throwable -> Lbd
        L84:
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r10 = r9.parseFunctionBody(r3, r2)     // Catch: java.lang.Throwable -> Lbd
            r2.setBody(r10)     // Catch: java.lang.Throwable -> Lbd
            external.sdk.pendo.io.mozilla.javascript.TokenStream r10 = r9.ts     // Catch: java.lang.Throwable -> Lbd
            int r10 = r10.tokenEnd     // Catch: java.lang.Throwable -> Lbd
            r2.setEncodedSourceBounds(r1, r10)     // Catch: java.lang.Throwable -> Lbd
            external.sdk.pendo.io.mozilla.javascript.TokenStream r10 = r9.ts     // Catch: java.lang.Throwable -> Lbd
            int r10 = r10.tokenEnd     // Catch: java.lang.Throwable -> Lbd
            int r10 = r10 - r1
            r2.setLength(r10)     // Catch: java.lang.Throwable -> Lbd
            r6.restore()
            boolean r10 = r2.isGenerator()
            if (r10 == 0) goto Lad
            java.lang.String r10 = "msg.arrowfunction.generator"
            r9.reportError(r10)
            external.sdk.pendo.io.mozilla.javascript.ast.ErrorNode r10 = r9.makeErrorNode()
            return r10
        Lad:
            java.lang.String r10 = r9.sourceURI
            r2.setSourceName(r10)
            r2.setBaseLineno(r0)
            external.sdk.pendo.io.mozilla.javascript.TokenStream r10 = r9.ts
            int r10 = r10.lineno
            r2.setEndLineno(r10)
            return r2
        Lbd:
            r10 = move-exception
            r6.restore()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Parser.arrowFunction(external.sdk.pendo.io.mozilla.javascript.ast.AstNode):external.sdk.pendo.io.mozilla.javascript.ast.AstNode");
    }

    private void arrowFunctionParams(FunctionNode functionNode, AstNode astNode, Map<String, Node> map, Set<String> set) {
        if ((astNode instanceof ArrayLiteral) || (astNode instanceof ObjectLiteral)) {
            markDestructuring(astNode);
            functionNode.addParam(astNode);
            String nextTempName = this.currentScriptOrFn.getNextTempName();
            defineSymbol(88, nextTempName, false);
            map.put(nextTempName, astNode);
            return;
        }
        if ((astNode instanceof InfixExpression) && astNode.getType() == 90) {
            InfixExpression infixExpression = (InfixExpression) astNode;
            arrowFunctionParams(functionNode, infixExpression.getLeft(), map, set);
            arrowFunctionParams(functionNode, infixExpression.getRight(), map, set);
            return;
        }
        if (!(astNode instanceof Name)) {
            reportError("msg.no.parm", astNode.getPosition(), astNode.getLength());
            functionNode.addParam(makeErrorNode());
            return;
        }
        functionNode.addParam(astNode);
        String identifier = ((Name) astNode).getIdentifier();
        defineSymbol(88, identifier);
        if (this.inUseStrictDirective) {
            if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                reportError("msg.bad.id.strict", identifier);
            }
            if (set.contains(identifier)) {
                addError("msg.dup.param.strict", identifier);
            }
            set.add(identifier);
        }
    }

    private AstNode assignExpr() {
        int peekToken = peekToken();
        boolean z = true;
        if (peekToken == 73) {
            return returnOrYield(peekToken, true);
        }
        AstNode condExpr = condExpr();
        int peekTokenOrEOL = peekTokenOrEOL();
        if (peekTokenOrEOL == 1) {
            peekTokenOrEOL = peekToken();
        } else {
            z = false;
        }
        if (91 > peekTokenOrEOL || peekTokenOrEOL > 102) {
            if (peekTokenOrEOL == 83) {
                if (this.currentJsDocComment == null) {
                    return condExpr;
                }
                condExpr.setJsDocNode(getAndResetJsDoc());
                return condExpr;
            }
            if (z || peekTokenOrEOL != 165) {
                return condExpr;
            }
            consumeToken();
            return arrowFunction(condExpr);
        }
        if (this.inDestructuringAssignment) {
            reportError("msg.destruct.default.vals");
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        markDestructuring(condExpr);
        Assignment assignment = new Assignment(peekTokenOrEOL, condExpr, assignExpr(), this.ts.tokenBeg);
        if (andResetJsDoc != null) {
            assignment.setJsDocNode(andResetJsDoc);
        }
        return assignment;
    }

    private AstNode attributeAccess() {
        int nextToken = nextToken();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        if (nextToken == 23) {
            saveNameTokenData(i, ProxyConfig.MATCH_ALL_SCHEMES, tokenStream.lineno);
            return propertyName(i, 0);
        }
        if (nextToken == 39) {
            return propertyName(i, 0);
        }
        if (nextToken == 84) {
            return xmlElemRef(i, null, -1);
        }
        reportError("msg.no.name.after.xmlAttr");
        return makeErrorNode();
    }

    private void autoInsertSemicolon(AstNode astNode) {
        int max;
        int peekFlaggedToken = peekFlaggedToken();
        int position = astNode.getPosition();
        int i = 65535 & peekFlaggedToken;
        if (i != -1 && i != 0) {
            if (i == 83) {
                consumeToken();
                astNode.setLength(this.ts.tokenEnd - position);
                return;
            } else if (i != 87) {
                if ((peekFlaggedToken & 65536) == 0) {
                    reportError("msg.no.semi.stmt");
                    return;
                } else {
                    max = nodeEnd(astNode);
                    warnMissingSemi(position, max);
                }
            }
        }
        max = Math.max(position + 1, nodeEnd(astNode));
        warnMissingSemi(position, max);
    }

    private AstNode bitAndExpr() {
        AstNode eqExpr = eqExpr();
        while (matchToken(11, true)) {
            eqExpr = new InfixExpression(11, eqExpr, eqExpr(), this.ts.tokenBeg);
        }
        return eqExpr;
    }

    private AstNode bitOrExpr() {
        AstNode bitXorExpr = bitXorExpr();
        while (matchToken(9, true)) {
            bitXorExpr = new InfixExpression(9, bitXorExpr, bitXorExpr(), this.ts.tokenBeg);
        }
        return bitXorExpr;
    }

    private AstNode bitXorExpr() {
        AstNode bitAndExpr = bitAndExpr();
        while (matchToken(10, true)) {
            bitAndExpr = new InfixExpression(10, bitAndExpr, bitAndExpr(), this.ts.tokenBeg);
        }
        return bitAndExpr;
    }

    private AstNode block() {
        if (this.currentToken != 86) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        Scope scope = new Scope(i);
        scope.setLineno(this.ts.lineno);
        pushScope(scope);
        try {
            statements(scope);
            mustMatchToken(87, "msg.no.brace.block", true);
            scope.setLength(this.ts.tokenEnd - i);
            return scope;
        } finally {
            popScope();
        }
    }

    private BreakStatement breakStatement() {
        int i;
        Name name;
        if (this.currentToken != 121) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.tokenEnd;
        if (peekTokenOrEOL() == 39) {
            name = createNameNode();
            i = getNodeEnd(name);
        } else {
            i = i4;
            name = null;
        }
        LabeledStatement matchJumpLabelName = matchJumpLabelName();
        Jump firstLabel = matchJumpLabelName != null ? matchJumpLabelName.getFirstLabel() : null;
        if (firstLabel == null && name == null) {
            List<Jump> list = this.loopAndSwitchSet;
            if (list == null || list.size() == 0) {
                reportError("msg.bad.break", i3, i - i3);
            } else {
                firstLabel = this.loopAndSwitchSet.get(r4.size() - 1);
            }
        }
        BreakStatement breakStatement = new BreakStatement(i3, i - i3);
        breakStatement.setBreakLabel(name);
        if (firstLabel != null) {
            breakStatement.setBreakTarget(firstLabel);
        }
        breakStatement.setLineno(i2);
        return breakStatement;
    }

    private void checkBadIncDec(UnaryExpression unaryExpression) {
        int type = removeParens(unaryExpression.getOperand()).getType();
        if (type == 39 || type == 33 || type == 36 || type == 68 || type == 38) {
            return;
        }
        reportError(unaryExpression.getType() == 107 ? "msg.bad.incr" : "msg.bad.decr");
    }

    private void checkCallRequiresActivation(AstNode astNode) {
        if ((astNode.getType() == 39 && "eval".equals(((Name) astNode).getIdentifier())) || (astNode.getType() == 33 && "eval".equals(((PropertyGet) astNode).getProperty().getIdentifier()))) {
            setRequiresActivation();
        }
    }

    private RuntimeException codeBug() {
        throw Kit.codeBug("ts.cursor=" + this.ts.cursor + ", ts.tokenBeg=" + this.ts.tokenBeg + ", currentToken=" + this.currentToken);
    }

    private AstNode condExpr() {
        AstNode orExpr = orExpr();
        if (!matchToken(103, true)) {
            return orExpr;
        }
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            AstNode assignExpr = assignExpr();
            this.inForInit = z;
            int i3 = mustMatchToken(104, "msg.no.colon.cond", true) ? this.ts.tokenBeg : -1;
            AstNode assignExpr2 = assignExpr();
            int position = orExpr.getPosition();
            ConditionalExpression conditionalExpression = new ConditionalExpression(position, getNodeEnd(assignExpr2) - position);
            conditionalExpression.setLineno(i);
            conditionalExpression.setTestExpression(orExpr);
            conditionalExpression.setTrueExpression(assignExpr);
            conditionalExpression.setFalseExpression(assignExpr2);
            conditionalExpression.setQuestionMarkPosition(i2 - position);
            conditionalExpression.setColonPosition(i3 - position);
            return conditionalExpression;
        } catch (Throwable th) {
            this.inForInit = z;
            throw th;
        }
    }

    private ConditionData condition() {
        ConditionData conditionData = new ConditionData();
        if (mustMatchToken(88, "msg.no.paren.cond", true)) {
            conditionData.lp = this.ts.tokenBeg;
        }
        conditionData.condition = expr();
        if (mustMatchToken(89, "msg.no.paren.after.cond", true)) {
            conditionData.rp = this.ts.tokenBeg;
        }
        AstNode astNode = conditionData.condition;
        if (astNode instanceof Assignment) {
            addStrictWarning("msg.equal.as.assign", "", astNode.getPosition(), conditionData.condition.getLength());
        }
        return conditionData;
    }

    private void consumeToken() {
        this.currentFlaggedToken = 0;
    }

    private ContinueStatement continueStatement() {
        int i;
        Name name;
        Object statement;
        if (this.currentToken != 122) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.lineno;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.tokenEnd;
        Loop loop = null;
        if (peekTokenOrEOL() == 39) {
            name = createNameNode();
            i = getNodeEnd(name);
        } else {
            i = i4;
            name = null;
        }
        LabeledStatement matchJumpLabelName = matchJumpLabelName();
        if (matchJumpLabelName == null && name == null) {
            List<Loop> list = this.loopSet;
            if (list == null || list.size() == 0) {
                reportError("msg.continue.outside");
            } else {
                statement = this.loopSet.get(r4.size() - 1);
                loop = (Loop) statement;
            }
        } else {
            if (matchJumpLabelName == null || !(matchJumpLabelName.getStatement() instanceof Loop)) {
                reportError("msg.continue.nonloop", i3, i - i3);
            }
            if (matchJumpLabelName != null) {
                statement = matchJumpLabelName.getStatement();
                loop = (Loop) statement;
            }
        }
        ContinueStatement continueStatement = new ContinueStatement(i3, i - i3);
        if (loop != null) {
            continueStatement.setTarget(loop);
        }
        continueStatement.setLabel(name);
        continueStatement.setLineno(i2);
        return continueStatement;
    }

    private Name createNameNode() {
        return createNameNode(false, 39);
    }

    private StringLiteral createStringLiteral() {
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        StringLiteral stringLiteral = new StringLiteral(i, tokenStream.tokenEnd - i);
        stringLiteral.setLineno(this.ts.lineno);
        stringLiteral.setValue(this.ts.getString());
        stringLiteral.setQuoteCharacter(this.ts.getQuoteChar());
        return stringLiteral;
    }

    private AstNode defaultXmlNamespace() {
        if (this.currentToken != 117) {
            codeBug();
        }
        consumeToken();
        mustHaveXML();
        setRequiresActivation();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        if (!matchToken(39, true) || !"xml".equals(this.ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(39, true) || !"namespace".equals(this.ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(91, true)) {
            reportError("msg.bad.namespace");
        }
        AstNode expr = expr();
        UnaryExpression unaryExpression = new UnaryExpression(i2, getNodeEnd(expr) - i2);
        unaryExpression.setOperator(75);
        unaryExpression.setOperand(expr);
        unaryExpression.setLineno(i);
        return new ExpressionStatement((AstNode) unaryExpression, true);
    }

    private AstNode destructuringPrimaryExpr() {
        try {
            this.inDestructuringAssignment = true;
            return primaryExpr();
        } finally {
            this.inDestructuringAssignment = false;
        }
    }

    private DoLoop doLoop() {
        if (this.currentToken != 119) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        DoLoop doLoop = new DoLoop(i);
        doLoop.setLineno(this.ts.lineno);
        enterLoop(doLoop);
        try {
            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(doLoop);
            mustMatchToken(118, "msg.no.while.do", true);
            doLoop.setWhilePosition(this.ts.tokenBeg - i);
            ConditionData condition = condition();
            doLoop.setCondition(condition.condition);
            doLoop.setParens(condition.lp - i, condition.rp - i);
            int nodeEnd = getNodeEnd(nextStatementAfterInlineComments);
            doLoop.setBody(nextStatementAfterInlineComments);
            exitLoop();
            if (matchToken(83, true)) {
                nodeEnd = this.ts.tokenEnd;
            }
            doLoop.setLength(nodeEnd - i);
            return doLoop;
        } catch (Throwable th) {
            exitLoop();
            throw th;
        }
    }

    private void enterLoop(Loop loop) {
        if (this.loopSet == null) {
            this.loopSet = new ArrayList();
        }
        this.loopSet.add(loop);
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(loop);
        pushScope(loop);
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null) {
            labeledStatement.setStatement(loop);
            this.currentLabel.getFirstLabel().setLoop(loop);
            loop.setRelative(-this.currentLabel.getPosition());
        }
    }

    private void enterSwitch(SwitchStatement switchStatement) {
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(switchStatement);
    }

    private AstNode eqExpr() {
        AstNode relExpr = relExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (peekToken != 12 && peekToken != 13 && peekToken != 46 && peekToken != 47) {
                return relExpr;
            }
            consumeToken();
            if (this.compilerEnv.getLanguageVersion() == 120) {
                if (peekToken == 12) {
                    peekToken = 46;
                } else if (peekToken == 13) {
                    peekToken = 47;
                }
            }
            relExpr = new InfixExpression(peekToken, relExpr, relExpr(), i);
        }
    }

    private void exitLoop() {
        Loop remove = this.loopSet.remove(r0.size() - 1);
        this.loopAndSwitchSet.remove(r1.size() - 1);
        if (remove.getParent() != null) {
            remove.setRelative(remove.getParent().getPosition());
        }
        popScope();
    }

    private void exitSwitch() {
        this.loopAndSwitchSet.remove(r0.size() - 1);
    }

    private AstNode expr() {
        AstNode assignExpr = assignExpr();
        int position = assignExpr.getPosition();
        while (matchToken(90, true)) {
            int i = this.ts.tokenBeg;
            if (this.compilerEnv.isStrictMode() && !assignExpr.hasSideEffects()) {
                addStrictWarning("msg.no.side.effects", "", position, nodeEnd(assignExpr) - position);
            }
            if (peekToken() == 73) {
                reportError("msg.yield.parenthesized");
            }
            assignExpr = new InfixExpression(90, assignExpr, assignExpr(), i);
        }
        return assignExpr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:6:0x001f, B:9:0x0028, B:11:0x0036, B:12:0x0042, B:14:0x004a, B:15:0x0051, B:17:0x0063, B:18:0x008f, B:19:0x00da, B:21:0x00e2, B:25:0x00ee, B:26:0x0134, B:29:0x014e, B:38:0x0160, B:39:0x0163, B:40:0x00fd, B:42:0x0106, B:44:0x0113, B:47:0x011c, B:48:0x0121, B:50:0x006b, B:52:0x0075, B:54:0x007b, B:56:0x0089, B:57:0x0095, B:59:0x00a2, B:60:0x00b7, B:62:0x00c7, B:64:0x00d4, B:65:0x00b3, B:67:0x003d, B:28:0x013f), top: B:5:0x001f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063 A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:6:0x001f, B:9:0x0028, B:11:0x0036, B:12:0x0042, B:14:0x004a, B:15:0x0051, B:17:0x0063, B:18:0x008f, B:19:0x00da, B:21:0x00e2, B:25:0x00ee, B:26:0x0134, B:29:0x014e, B:38:0x0160, B:39:0x0163, B:40:0x00fd, B:42:0x0106, B:44:0x0113, B:47:0x011c, B:48:0x0121, B:50:0x006b, B:52:0x0075, B:54:0x007b, B:56:0x0089, B:57:0x0095, B:59:0x00a2, B:60:0x00b7, B:62:0x00c7, B:64:0x00d4, B:65:0x00b3, B:67:0x003d, B:28:0x013f), top: B:5:0x001f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e2 A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:6:0x001f, B:9:0x0028, B:11:0x0036, B:12:0x0042, B:14:0x004a, B:15:0x0051, B:17:0x0063, B:18:0x008f, B:19:0x00da, B:21:0x00e2, B:25:0x00ee, B:26:0x0134, B:29:0x014e, B:38:0x0160, B:39:0x0163, B:40:0x00fd, B:42:0x0106, B:44:0x0113, B:47:0x011c, B:48:0x0121, B:50:0x006b, B:52:0x0075, B:54:0x007b, B:56:0x0089, B:57:0x0095, B:59:0x00a2, B:60:0x00b7, B:62:0x00c7, B:64:0x00d4, B:65:0x00b3, B:67:0x003d, B:28:0x013f), top: B:5:0x001f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00eb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0155 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106 A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:6:0x001f, B:9:0x0028, B:11:0x0036, B:12:0x0042, B:14:0x004a, B:15:0x0051, B:17:0x0063, B:18:0x008f, B:19:0x00da, B:21:0x00e2, B:25:0x00ee, B:26:0x0134, B:29:0x014e, B:38:0x0160, B:39:0x0163, B:40:0x00fd, B:42:0x0106, B:44:0x0113, B:47:0x011c, B:48:0x0121, B:50:0x006b, B:52:0x0075, B:54:0x007b, B:56:0x0089, B:57:0x0095, B:59:0x00a2, B:60:0x00b7, B:62:0x00c7, B:64:0x00d4, B:65:0x00b3, B:67:0x003d, B:28:0x013f), top: B:5:0x001f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x006b A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:6:0x001f, B:9:0x0028, B:11:0x0036, B:12:0x0042, B:14:0x004a, B:15:0x0051, B:17:0x0063, B:18:0x008f, B:19:0x00da, B:21:0x00e2, B:25:0x00ee, B:26:0x0134, B:29:0x014e, B:38:0x0160, B:39:0x0163, B:40:0x00fd, B:42:0x0106, B:44:0x0113, B:47:0x011c, B:48:0x0121, B:50:0x006b, B:52:0x0075, B:54:0x007b, B:56:0x0089, B:57:0x0095, B:59:0x00a2, B:60:0x00b7, B:62:0x00c7, B:64:0x00d4, B:65:0x00b3, B:67:0x003d, B:28:0x013f), top: B:5:0x001f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.ast.Loop forLoop() {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Parser.forLoop():external.sdk.pendo.io.mozilla.javascript.ast.Loop");
    }

    private AstNode forLoopInit(int i) {
        AstNode variables;
        try {
            this.inForInit = true;
            if (i == 83) {
                variables = new EmptyExpression(this.ts.tokenBeg, 1);
                variables.setLineno(this.ts.lineno);
            } else {
                if (i != 123 && i != 154) {
                    variables = expr();
                    markDestructuring(variables);
                }
                consumeToken();
                variables = variables(i, this.ts.tokenBeg, false);
            }
            return variables;
        } finally {
            this.inForInit = false;
        }
    }

    private FunctionNode function(int i) {
        return function(i, false);
    }

    private AstNode generatorExpression(AstNode astNode, int i) {
        return generatorExpression(astNode, i, false);
    }

    private GeneratorExpressionLoop generatorExpressionLoop() {
        AstNode createNameNode;
        if (nextToken() != 120) {
            codeBug();
        }
        int i = this.ts.tokenBeg;
        GeneratorExpressionLoop generatorExpressionLoop = new GeneratorExpressionLoop(i);
        pushScope(generatorExpressionLoop);
        try {
            int i2 = mustMatchToken(88, "msg.no.paren.for", true) ? this.ts.tokenBeg - i : -1;
            int peekToken = peekToken();
            if (peekToken == 39) {
                consumeToken();
                createNameNode = createNameNode();
            } else if (peekToken == 84 || peekToken == 86) {
                createNameNode = destructuringPrimaryExpr();
                markDestructuring(createNameNode);
            } else {
                reportError("msg.bad.var");
                createNameNode = null;
            }
            if (createNameNode.getType() == 39) {
                defineSymbol(154, this.ts.getString(), true);
            }
            int i3 = mustMatchToken(52, "msg.in.after.for.name", true) ? this.ts.tokenBeg - i : -1;
            AstNode expr = expr();
            int i4 = mustMatchToken(89, "msg.no.paren.for.ctrl", true) ? this.ts.tokenBeg - i : -1;
            generatorExpressionLoop.setLength(this.ts.tokenEnd - i);
            generatorExpressionLoop.setIterator(createNameNode);
            generatorExpressionLoop.setIteratedObject(expr);
            generatorExpressionLoop.setInPosition(i3);
            generatorExpressionLoop.setParens(i2, i4);
            return generatorExpressionLoop;
        } finally {
            popScope();
        }
    }

    private Comment getAndResetJsDoc() {
        Comment comment = this.currentJsDocComment;
        this.currentJsDocComment = null;
        return comment;
    }

    private static String getDirective(AstNode astNode) {
        if (!(astNode instanceof ExpressionStatement)) {
            return null;
        }
        AstNode expression = ((ExpressionStatement) astNode).getExpression();
        if (expression instanceof StringLiteral) {
            return ((StringLiteral) expression).getValue();
        }
        return null;
    }

    private AstNode getNextStatementAfterInlineComments(AstNode astNode) {
        AstNode statement = statement();
        if (162 != statement.getType()) {
            return statement;
        }
        AstNode statement2 = statement();
        if (astNode != null) {
            astNode.setInlineComment(statement);
        } else {
            statement2.setInlineComment(statement);
        }
        return statement2;
    }

    private static int getNodeEnd(AstNode astNode) {
        return astNode.getPosition() + astNode.getLength();
    }

    private IfStatement ifStatement() {
        int i;
        AstNode astNode;
        if (this.currentToken != 113) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        int i3 = tokenStream.lineno;
        IfStatement ifStatement = new IfStatement(i2);
        ConditionData condition = condition();
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(ifStatement);
        if (matchToken(114, true)) {
            if (peekToken() == 162) {
                List<Comment> list = this.scannedComments;
                ifStatement.setElseKeyWordInlineComment(list.get(list.size() - 1));
                consumeToken();
            }
            i = this.ts.tokenBeg - i2;
            astNode = statement();
        } else {
            i = -1;
            astNode = null;
        }
        ifStatement.setLength(getNodeEnd(astNode != null ? astNode : nextStatementAfterInlineComments) - i2);
        ifStatement.setCondition(condition.condition);
        ifStatement.setParens(condition.lp - i2, condition.rp - i2);
        ifStatement.setThenPart(nextStatementAfterInlineComments);
        ifStatement.setElsePart(astNode);
        ifStatement.setElsePosition(i);
        ifStatement.setLineno(i3);
        return ifStatement;
    }

    private AstNode let(boolean z, int i) {
        LetNode letNode = new LetNode(i);
        letNode.setLineno(this.ts.lineno);
        if (mustMatchToken(88, "msg.no.paren.after.let", true)) {
            letNode.setLp(this.ts.tokenBeg - i);
        }
        pushScope(letNode);
        try {
            letNode.setVariables(variables(154, this.ts.tokenBeg, z));
            if (mustMatchToken(89, "msg.no.paren.let", true)) {
                letNode.setRp(this.ts.tokenBeg - i);
            }
            if (z && peekToken() == 86) {
                consumeToken();
                int i2 = this.ts.tokenBeg;
                AstNode statements = statements();
                mustMatchToken(87, "msg.no.curly.let", true);
                statements.setLength(this.ts.tokenEnd - i2);
                letNode.setLength(this.ts.tokenEnd - i);
                letNode.setBody(statements);
                letNode.setType(154);
            } else {
                AstNode expr = expr();
                letNode.setLength(getNodeEnd(expr) - i);
                letNode.setBody(expr);
                if (z) {
                    ExpressionStatement expressionStatement = new ExpressionStatement(letNode, !insideFunction());
                    expressionStatement.setLineno(letNode.getLineno());
                    return expressionStatement;
                }
            }
            return letNode;
        } finally {
            popScope();
        }
    }

    private AstNode letStatement() {
        if (this.currentToken != 154) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        AstNode let = peekToken() == 88 ? let(true, i2) : variables(154, i2, true);
        let.setLineno(i);
        return let;
    }

    private int lineBeginningFor(int i) {
        char[] cArr = this.sourceChars;
        if (cArr == null) {
            return -1;
        }
        if (i <= 0) {
            return 0;
        }
        if (i >= cArr.length) {
            i = cArr.length - 1;
        }
        do {
            i--;
            if (i < 0) {
                return 0;
            }
        } while (!ScriptRuntime.isJSLineTerminator(cArr[i]));
        return i + 1;
    }

    private ErrorNode makeErrorNode() {
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        ErrorNode errorNode = new ErrorNode(i, tokenStream.tokenEnd - i);
        errorNode.setLineno(this.ts.lineno);
        return errorNode;
    }

    private LabeledStatement matchJumpLabelName() {
        if (peekTokenOrEOL() == 39) {
            consumeToken();
            Map<String, LabeledStatement> map = this.labelSet;
            r2 = map != null ? map.get(this.ts.getString()) : null;
            if (r2 == null) {
                reportError("msg.undef.label");
            }
        }
        return r2;
    }

    private boolean matchToken(int i, boolean z) {
        int peekToken;
        while (true) {
            peekToken = peekToken();
            if (peekToken != 162 || !z) {
                break;
            }
            consumeToken();
        }
        if (peekToken != i) {
            return false;
        }
        consumeToken();
        return true;
    }

    private AstNode memberExpr(boolean z) {
        AstNode astNode;
        int peekToken = peekToken();
        int i = this.ts.lineno;
        if (peekToken != 30) {
            astNode = primaryExpr();
        } else {
            consumeToken();
            int i2 = this.ts.tokenBeg;
            NewExpression newExpression = new NewExpression(i2);
            AstNode memberExpr = memberExpr(false);
            int nodeEnd = getNodeEnd(memberExpr);
            newExpression.setTarget(memberExpr);
            if (matchToken(88, true)) {
                int i3 = this.ts.tokenBeg;
                List<AstNode> argumentList = argumentList();
                if (argumentList != null && argumentList.size() > 65536) {
                    reportError("msg.too.many.constructor.args");
                }
                TokenStream tokenStream = this.ts;
                int i4 = tokenStream.tokenBeg;
                int i5 = tokenStream.tokenEnd;
                if (argumentList != null) {
                    newExpression.setArguments(argumentList);
                }
                newExpression.setParens(i3 - i2, i4 - i2);
                nodeEnd = i5;
            }
            if (matchToken(86, true)) {
                ObjectLiteral objectLiteral = objectLiteral();
                nodeEnd = getNodeEnd(objectLiteral);
                newExpression.setInitializer(objectLiteral);
            }
            newExpression.setLength(nodeEnd - i2);
            astNode = newExpression;
        }
        astNode.setLineno(i);
        return memberExprTail(z, astNode);
    }

    private AstNode memberExprTail(boolean z, AstNode astNode) {
        int i;
        AstNode astNode2;
        if (astNode == null) {
            codeBug();
        }
        int position = astNode.getPosition();
        while (true) {
            int peekToken = peekToken();
            int i2 = -1;
            if (peekToken == 84) {
                consumeToken();
                TokenStream tokenStream = this.ts;
                int i3 = tokenStream.tokenBeg;
                i = tokenStream.lineno;
                AstNode expr = expr();
                int nodeEnd = getNodeEnd(expr);
                if (mustMatchToken(85, "msg.no.bracket.index", true)) {
                    TokenStream tokenStream2 = this.ts;
                    i2 = tokenStream2.tokenBeg;
                    nodeEnd = tokenStream2.tokenEnd;
                }
                ElementGet elementGet = new ElementGet(position, nodeEnd - position);
                elementGet.setTarget(astNode);
                elementGet.setElement(expr);
                elementGet.setParens(i3, i2);
                astNode2 = elementGet;
            } else if (peekToken != 88) {
                if (peekToken == 109 || peekToken == 144) {
                    int i4 = this.ts.lineno;
                    astNode = propertyAccess(peekToken, astNode);
                    astNode.setLineno(i4);
                } else if (peekToken == 147) {
                    consumeToken();
                    TokenStream tokenStream3 = this.ts;
                    int i5 = tokenStream3.tokenBeg;
                    i = tokenStream3.lineno;
                    mustHaveXML();
                    setRequiresActivation();
                    AstNode expr2 = expr();
                    int nodeEnd2 = getNodeEnd(expr2);
                    if (mustMatchToken(89, "msg.no.paren", true)) {
                        TokenStream tokenStream4 = this.ts;
                        i2 = tokenStream4.tokenBeg;
                        nodeEnd2 = tokenStream4.tokenEnd;
                    }
                    XmlDotQuery xmlDotQuery = new XmlDotQuery(position, nodeEnd2 - position);
                    xmlDotQuery.setLeft(astNode);
                    xmlDotQuery.setRight(expr2);
                    xmlDotQuery.setOperatorPosition(i5);
                    xmlDotQuery.setRp(i2 - position);
                    astNode2 = xmlDotQuery;
                } else {
                    if (peekToken != 162) {
                        break;
                    }
                    int i6 = this.currentFlaggedToken;
                    peekUntilNonComment(peekToken);
                    int i7 = this.currentFlaggedToken;
                    if ((i7 & 65536) != 0) {
                        i6 = i7;
                    }
                    this.currentFlaggedToken = i6;
                }
            } else {
                if (!z) {
                    break;
                }
                int i8 = this.ts.lineno;
                consumeToken();
                checkCallRequiresActivation(astNode);
                FunctionCall functionCall = new FunctionCall(position);
                functionCall.setTarget(astNode);
                functionCall.setLineno(i8);
                functionCall.setLp(this.ts.tokenBeg - position);
                List<AstNode> argumentList = argumentList();
                if (argumentList != null && argumentList.size() > 65536) {
                    reportError("msg.too.many.function.args");
                }
                functionCall.setArguments(argumentList);
                functionCall.setRp(this.ts.tokenBeg - position);
                functionCall.setLength(this.ts.tokenEnd - position);
                astNode = functionCall;
            }
            astNode2.setLineno(i);
            astNode = astNode2;
        }
        return astNode;
    }

    private ObjectProperty methodDefinition(int i, AstNode astNode, int i2) {
        FunctionNode function = function(2);
        Name functionName = function.getFunctionName();
        if (functionName != null && functionName.length() != 0) {
            reportError("msg.bad.prop");
        }
        ObjectProperty objectProperty = new ObjectProperty(i);
        if (i2 == 2) {
            objectProperty.setIsGetterMethod();
            function.setFunctionIsGetterMethod();
        } else if (i2 == 4) {
            objectProperty.setIsSetterMethod();
            function.setFunctionIsSetterMethod();
        } else if (i2 == 8) {
            objectProperty.setIsNormalMethod();
            function.setFunctionIsNormalMethod();
        }
        int nodeEnd = getNodeEnd(function);
        objectProperty.setLeft(astNode);
        objectProperty.setRight(function);
        objectProperty.setLength(nodeEnd - i);
        return objectProperty;
    }

    private AstNode mulExpr() {
        AstNode unaryExpr = unaryExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.ts.tokenBeg;
            switch (peekToken) {
                case 23:
                case 24:
                case 25:
                    consumeToken();
                    unaryExpr = new InfixExpression(peekToken, unaryExpr, unaryExpr(), i);
                default:
                    return unaryExpr;
            }
        }
    }

    private void mustHaveXML() {
        if (this.compilerEnv.isXmlAvailable()) {
            return;
        }
        reportError("msg.XML.not.available");
    }

    private boolean mustMatchToken(int i, String str, int i2, int i3, boolean z) {
        if (matchToken(i, z)) {
            return true;
        }
        reportError(str, i2, i3);
        return false;
    }

    private AstNode name(int i, int i2) {
        String string = this.ts.getString();
        TokenStream tokenStream = this.ts;
        int i3 = tokenStream.tokenBeg;
        int i4 = tokenStream.lineno;
        if ((i & 131072) == 0 || peekToken() != 104) {
            saveNameTokenData(i3, string, i4);
            return this.compilerEnv.isXmlAvailable() ? propertyName(-1, 0) : createNameNode(true, 39);
        }
        Label label = new Label(i3, this.ts.tokenEnd - i3);
        label.setName(string);
        label.setLineno(this.ts.lineno);
        return label;
    }

    private AstNode nameOrLabel() {
        AstNode astNode;
        if (this.currentToken != 39) {
            throw codeBug();
        }
        int i = this.ts.tokenBeg;
        this.currentFlaggedToken |= 131072;
        AstNode expr = expr();
        if (expr.getType() != 131) {
            ExpressionStatement expressionStatement = new ExpressionStatement(expr, !insideFunction());
            expressionStatement.lineno = expr.lineno;
            return expressionStatement;
        }
        LabeledStatement labeledStatement = new LabeledStatement(i);
        recordLabel((Label) expr, labeledStatement);
        labeledStatement.setLineno(this.ts.lineno);
        while (true) {
            if (peekToken() != 39) {
                astNode = null;
                break;
            }
            this.currentFlaggedToken |= 131072;
            AstNode expr2 = expr();
            if (expr2.getType() != 131) {
                astNode = new ExpressionStatement(expr2, !insideFunction());
                autoInsertSemicolon(astNode);
                break;
            }
            recordLabel((Label) expr2, labeledStatement);
        }
        try {
            this.currentLabel = labeledStatement;
            if (astNode == null) {
                astNode = statementHelper();
                if (peekToken() == 162) {
                    if (astNode.getLineno() == this.scannedComments.get(r3.size() - 1).getLineno()) {
                        astNode.setInlineComment(this.scannedComments.get(r2.size() - 1));
                        consumeToken();
                    }
                }
            }
            labeledStatement.setLength(astNode.getParent() == null ? getNodeEnd(astNode) - i : getNodeEnd(astNode));
            labeledStatement.setStatement(astNode);
            return labeledStatement;
        } finally {
            this.currentLabel = null;
            Iterator<Label> it = labeledStatement.getLabels().iterator();
            while (it.hasNext()) {
                this.labelSet.remove(it.next().getName());
            }
        }
    }

    private int nextToken() {
        int peekToken = peekToken();
        consumeToken();
        return peekToken;
    }

    private static int nodeEnd(AstNode astNode) {
        return astNode.getPosition() + astNode.getLength();
    }

    private static final boolean nowAllSet(int i, int i2, int i3) {
        return (i & i3) != i3 && (i2 & i3) == i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d5, code lost:
    
        if (r5 != 8) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0110 A[LOOP:0: B:5:0x0024->B:41:0x0110, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0117 A[EDGE_INSN: B:42:0x0117->B:43:0x0117 BREAK  A[LOOP:0: B:5:0x0024->B:41:0x0110], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.ast.ObjectLiteral objectLiteral() {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Parser.objectLiteral():external.sdk.pendo.io.mozilla.javascript.ast.ObjectLiteral");
    }

    private AstNode objliteralProperty() {
        switch (peekToken()) {
            case 39:
                break;
            case 40:
                TokenStream tokenStream = this.ts;
                return new NumberLiteral(tokenStream.tokenBeg, tokenStream.getString(), this.ts.getNumber());
            case 41:
                return createStringLiteral();
            default:
                if (!this.compilerEnv.isReservedKeywordAsIdentifier() || !TokenStream.isKeyword(this.ts.getString(), this.compilerEnv.getLanguageVersion(), this.inUseStrictDirective)) {
                    return null;
                }
                break;
        }
        return createNameNode();
    }

    private AstNode orExpr() {
        AstNode andExpr = andExpr();
        if (!matchToken(105, true)) {
            return andExpr;
        }
        return new InfixExpression(105, andExpr, orExpr(), this.ts.tokenBeg);
    }

    private AstNode parenExpr() {
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            Comment andResetJsDoc = getAndResetJsDoc();
            TokenStream tokenStream = this.ts;
            int i = tokenStream.lineno;
            int i2 = tokenStream.tokenBeg;
            AstNode emptyExpression = peekToken() == 89 ? new EmptyExpression(i2) : expr();
            if (peekToken() == 120) {
                return generatorExpression(emptyExpression, i2);
            }
            mustMatchToken(89, "msg.no.paren", true);
            if (emptyExpression.getType() == 129 && peekToken() != 165) {
                reportError("msg.syntax");
                return makeErrorNode();
            }
            ParenthesizedExpression parenthesizedExpression = new ParenthesizedExpression(i2, this.ts.tokenEnd - i2, emptyExpression);
            parenthesizedExpression.setLineno(i);
            if (andResetJsDoc == null) {
                andResetJsDoc = getAndResetJsDoc();
            }
            if (andResetJsDoc != null) {
                parenthesizedExpression.setJsDocNode(andResetJsDoc);
            }
            return parenthesizedExpression;
        } finally {
            this.inForInit = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.ast.AstRoot parse() {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Parser.parse():external.sdk.pendo.io.mozilla.javascript.ast.AstRoot");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(2:3|(9:7|(1:9)(1:61)|10|11|(3:13|(1:15)|16)(2:25|(2:26|(3:30|(2:32|(2:34|(1:49)(2:36|(2:38|39)(2:41|(2:43|(2:45|46)(1:47))(1:48))))(2:50|51))(2:52|53)|40)(3:56|55|54)))|17|(1:21)|22|23)(1:6))|62|(0)(0)|10|11|(0)(0)|17|(2:19|21)|22|23|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b9, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ba, code lost:
    
        r10.nestingOfFunction--;
        r10.inUseStrictDirective = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c1, code lost:
    
        throw r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042 A[Catch: all -> 0x00b9, ParserException -> 0x00c2, TRY_ENTER, TryCatch #2 {ParserException -> 0x00c2, all -> 0x00b9, blocks: (B:13:0x0042, B:15:0x005f, B:16:0x0064, B:26:0x0069, B:34:0x007c, B:36:0x0082, B:41:0x008a, B:43:0x0092, B:45:0x0099, B:40:0x00b5, B:50:0x009d, B:52:0x00ae), top: B:11:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.ast.AstNode parseFunctionBody(int r11, external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode r12) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Parser.parseFunctionBody(int, external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode):external.sdk.pendo.io.mozilla.javascript.ast.AstNode");
    }

    private void parseFunctionParams(FunctionNode functionNode) {
        if (matchToken(89, true)) {
            functionNode.setRp(this.ts.tokenBeg - functionNode.getPosition());
            return;
        }
        HashSet hashSet = new HashSet();
        HashMap hashMap = null;
        do {
            int peekToken = peekToken();
            if (peekToken == 84 || peekToken == 86) {
                AstNode destructuringPrimaryExpr = destructuringPrimaryExpr();
                markDestructuring(destructuringPrimaryExpr);
                functionNode.addParam(destructuringPrimaryExpr);
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(88, nextTempName, false);
                hashMap.put(nextTempName, destructuringPrimaryExpr);
            } else if (mustMatchToken(39, "msg.no.parm", true)) {
                AstNode createNameNode = createNameNode();
                Comment andResetJsDoc = getAndResetJsDoc();
                if (andResetJsDoc != null) {
                    createNameNode.setJsDocNode(andResetJsDoc);
                }
                functionNode.addParam(createNameNode);
                String string = this.ts.getString();
                defineSymbol(88, string);
                if (this.inUseStrictDirective) {
                    if ("eval".equals(string) || "arguments".equals(string)) {
                        reportError("msg.bad.id.strict", string);
                    }
                    if (hashSet.contains(string)) {
                        addError("msg.dup.param.strict", string);
                    }
                    hashSet.add(string);
                }
            } else {
                functionNode.addParam(makeErrorNode());
            }
        } while (matchToken(90, true));
        if (hashMap != null) {
            Node node = new Node(90);
            for (Map.Entry entry : hashMap.entrySet()) {
                node.addChildToBack(createDestructuringAssignment(123, (Node) entry.getValue(), createName((String) entry.getKey())));
            }
            functionNode.putProp(23, node);
        }
        if (mustMatchToken(89, "msg.no.paren.after.parms", true)) {
            functionNode.setRp(this.ts.tokenBeg - functionNode.getPosition());
        }
    }

    private int peekFlaggedToken() {
        peekToken();
        return this.currentFlaggedToken;
    }

    private int peekToken() {
        if (this.currentFlaggedToken != 0) {
            return this.currentToken;
        }
        int lineno = this.ts.getLineno();
        int token = this.ts.getToken();
        boolean z = false;
        while (true) {
            if (token != 1 && token != 162) {
                break;
            }
            if (token == 1) {
                lineno++;
                token = this.ts.getToken();
                z = true;
            } else {
                if (this.compilerEnv.isRecordingComments()) {
                    recordComment(lineno, this.ts.getAndResetCurrentComment());
                    break;
                }
                token = this.ts.getToken();
            }
        }
        this.currentToken = token;
        this.currentFlaggedToken = token | (z ? 65536 : 0);
        return token;
    }

    private int peekTokenOrEOL() {
        int peekToken = peekToken();
        if ((this.currentFlaggedToken & 65536) != 0) {
            return 1;
        }
        return peekToken;
    }

    private int peekUntilNonComment(int i) {
        while (i == 162) {
            consumeToken();
            i = peekToken();
        }
        return i;
    }

    private ObjectProperty plainProperty(AstNode astNode, int i) {
        int peekToken = peekToken();
        if ((peekToken != 90 && peekToken != 87) || i != 39 || this.compilerEnv.getLanguageVersion() < 180) {
            mustMatchToken(104, "msg.no.colon.prop", true);
            ObjectProperty objectProperty = new ObjectProperty();
            objectProperty.setOperatorPosition(this.ts.tokenBeg);
            objectProperty.setLeftAndRight(astNode, assignExpr());
            return objectProperty;
        }
        if (!this.inDestructuringAssignment) {
            reportError("msg.bad.object.init");
        }
        Name name = new Name(astNode.getPosition(), astNode.getString());
        ObjectProperty objectProperty2 = new ObjectProperty();
        objectProperty2.putProp(26, Boolean.TRUE);
        objectProperty2.setLeftAndRight(astNode, name);
        return objectProperty2;
    }

    private AstNode primaryExpr() {
        String str;
        int peekFlaggedToken = peekFlaggedToken();
        int i = 65535 & peekFlaggedToken;
        if (i != -1) {
            if (i != 0) {
                if (i != 24) {
                    if (i == 84) {
                        consumeToken();
                        return arrayLiteral();
                    }
                    if (i == 86) {
                        consumeToken();
                        return objectLiteral();
                    }
                    if (i == 88) {
                        consumeToken();
                        return parenExpr();
                    }
                    if (i != 101) {
                        if (i == 110) {
                            consumeToken();
                            return function(2);
                        }
                        if (i == 128) {
                            consumeToken();
                            reportError("msg.reserved.id", this.ts.getString());
                        } else {
                            if (i == 148) {
                                consumeToken();
                                mustHaveXML();
                                return attributeAccess();
                            }
                            consumeToken();
                            if (i == 154) {
                                return let(false, this.ts.tokenBeg);
                            }
                            switch (i) {
                                case 39:
                                    return name(peekFlaggedToken, i);
                                case 40:
                                    String string = this.ts.getString();
                                    if (this.inUseStrictDirective && this.ts.isNumberOldOctal()) {
                                        reportError("msg.no.old.octal.strict");
                                    }
                                    if (this.ts.isNumberBinary()) {
                                        string = "0b" + string;
                                    }
                                    if (this.ts.isNumberOldOctal()) {
                                        string = "0" + string;
                                    }
                                    if (this.ts.isNumberOctal()) {
                                        string = "0o" + string;
                                    }
                                    if (this.ts.isNumberHex()) {
                                        string = "0x" + string;
                                    }
                                    TokenStream tokenStream = this.ts;
                                    return new NumberLiteral(tokenStream.tokenBeg, string, tokenStream.getNumber());
                                case 41:
                                    return createStringLiteral();
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                    TokenStream tokenStream2 = this.ts;
                                    int i2 = tokenStream2.tokenBeg;
                                    return new KeywordLiteral(i2, tokenStream2.tokenEnd - i2, i);
                                default:
                                    str = "msg.syntax";
                                    break;
                            }
                        }
                    }
                }
                consumeToken();
                this.ts.readRegExp(i);
                TokenStream tokenStream3 = this.ts;
                int i3 = tokenStream3.tokenBeg;
                RegExpLiteral regExpLiteral = new RegExpLiteral(i3, tokenStream3.tokenEnd - i3);
                regExpLiteral.setValue(this.ts.getString());
                regExpLiteral.setFlags(this.ts.readAndClearRegExpFlags());
                return regExpLiteral;
            }
            consumeToken();
            str = "msg.unexpected.eof";
            reportError(str);
        } else {
            consumeToken();
        }
        consumeToken();
        return makeErrorNode();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.ast.AstNode propertyAccess(int r8, external.sdk.pendo.io.mozilla.javascript.ast.AstNode r9) {
        /*
            r7 = this;
            if (r9 != 0) goto L5
            r7.codeBug()
        L5:
            external.sdk.pendo.io.mozilla.javascript.TokenStream r0 = r7.ts
            int r1 = r0.lineno
            int r0 = r0.tokenBeg
            r7.consumeToken()
            r2 = 144(0x90, float:2.02E-43)
            if (r8 != r2) goto L17
            r7.mustHaveXML()
            r2 = 4
            goto L18
        L17:
            r2 = 0
        L18:
            external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons r3 = r7.compilerEnv
            boolean r3 = r3.isXmlAvailable()
            java.lang.String r4 = "msg.no.name.after.dot"
            r5 = 39
            if (r3 != 0) goto L59
            int r8 = r7.nextToken()
            if (r8 == r5) goto L49
            external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons r8 = r7.compilerEnv
            boolean r8 = r8.isReservedKeywordAsIdentifier()
            if (r8 == 0) goto L46
            external.sdk.pendo.io.mozilla.javascript.TokenStream r8 = r7.ts
            java.lang.String r8 = r8.getString()
            external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons r2 = r7.compilerEnv
            int r2 = r2.getLanguageVersion()
            boolean r3 = r7.inUseStrictDirective
            boolean r8 = external.sdk.pendo.io.mozilla.javascript.TokenStream.isKeyword(r8, r2, r3)
            if (r8 != 0) goto L49
        L46:
            r7.reportError(r4)
        L49:
            r8 = 1
            r2 = 33
            external.sdk.pendo.io.mozilla.javascript.ast.Name r8 = r7.createNameNode(r8, r2)
            external.sdk.pendo.io.mozilla.javascript.ast.PropertyGet r2 = new external.sdk.pendo.io.mozilla.javascript.ast.PropertyGet
            r2.<init>(r9, r8, r0)
            r2.setLineno(r1)
            return r2
        L59:
            int r1 = r7.nextToken()
            r3 = 23
            r6 = -1
            if (r1 == r3) goto La5
            if (r1 == r5) goto Lb0
            r3 = 50
            if (r1 == r3) goto L9c
            r3 = 128(0x80, float:1.8E-43)
            if (r1 == r3) goto L8c
            r3 = 148(0x94, float:2.07E-43)
            if (r1 == r3) goto L87
            external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons r3 = r7.compilerEnv
            boolean r3 = r3.isReservedKeywordAsIdentifier()
            if (r3 == 0) goto L7f
            java.lang.String r1 = external.sdk.pendo.io.mozilla.javascript.Token.keywordToName(r1)
            if (r1 == 0) goto L7f
            goto L92
        L7f:
            r7.reportError(r4)
            external.sdk.pendo.io.mozilla.javascript.ast.ErrorNode r8 = r7.makeErrorNode()
            return r8
        L87:
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r1 = r7.attributeAccess()
            goto Lb4
        L8c:
            external.sdk.pendo.io.mozilla.javascript.TokenStream r1 = r7.ts
            java.lang.String r1 = r1.getString()
        L92:
            external.sdk.pendo.io.mozilla.javascript.TokenStream r3 = r7.ts
            int r4 = r3.tokenBeg
            int r3 = r3.lineno
            r7.saveNameTokenData(r4, r1, r3)
            goto Lb0
        L9c:
            external.sdk.pendo.io.mozilla.javascript.TokenStream r1 = r7.ts
            int r3 = r1.tokenBeg
            int r1 = r1.lineno
            java.lang.String r4 = "throw"
            goto Lad
        La5:
            external.sdk.pendo.io.mozilla.javascript.TokenStream r1 = r7.ts
            int r3 = r1.tokenBeg
            int r1 = r1.lineno
            java.lang.String r4 = "*"
        Lad:
            r7.saveNameTokenData(r3, r4, r1)
        Lb0:
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r1 = r7.propertyName(r6, r2)
        Lb4:
            boolean r2 = r1 instanceof external.sdk.pendo.io.mozilla.javascript.ast.XmlRef
            if (r2 == 0) goto Lbe
            external.sdk.pendo.io.mozilla.javascript.ast.XmlMemberGet r3 = new external.sdk.pendo.io.mozilla.javascript.ast.XmlMemberGet
            r3.<init>()
            goto Lc3
        Lbe:
            external.sdk.pendo.io.mozilla.javascript.ast.PropertyGet r3 = new external.sdk.pendo.io.mozilla.javascript.ast.PropertyGet
            r3.<init>()
        Lc3:
            if (r2 == 0) goto Lcc
            r2 = 109(0x6d, float:1.53E-43)
            if (r8 != r2) goto Lcc
            r3.setType(r2)
        Lcc:
            int r8 = r9.getPosition()
            r3.setPosition(r8)
            int r2 = getNodeEnd(r1)
            int r2 = r2 - r8
            r3.setLength(r2)
            int r0 = r0 - r8
            r3.setOperatorPosition(r0)
            int r8 = r9.getLineno()
            r3.setLineno(r8)
            r3.setLeft(r9)
            r3.setRight(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Parser.propertyAccess(int, external.sdk.pendo.io.mozilla.javascript.ast.AstNode):external.sdk.pendo.io.mozilla.javascript.ast.AstNode");
    }

    private AstNode propertyName(int i, int i2) {
        Name name;
        int i3;
        int i4 = i != -1 ? i : this.ts.tokenBeg;
        int i5 = this.ts.lineno;
        Name createNameNode = createNameNode(true, this.currentToken);
        if (matchToken(145, true)) {
            i3 = this.ts.tokenBeg;
            int nextToken = nextToken();
            if (nextToken == 23) {
                TokenStream tokenStream = this.ts;
                saveNameTokenData(tokenStream.tokenBeg, ProxyConfig.MATCH_ALL_SCHEMES, tokenStream.lineno);
                name = createNameNode(false, -1);
            } else {
                if (nextToken != 39) {
                    if (nextToken == 84) {
                        return xmlElemRef(i, createNameNode, i3);
                    }
                    reportError("msg.no.name.after.coloncolon");
                    return makeErrorNode();
                }
                name = createNameNode();
            }
        } else {
            name = createNameNode;
            createNameNode = null;
            i3 = -1;
        }
        if (createNameNode == null && i2 == 0 && i == -1) {
            return name;
        }
        XmlPropRef xmlPropRef = new XmlPropRef(i4, getNodeEnd(name) - i4);
        xmlPropRef.setAtPos(i);
        xmlPropRef.setNamespace(createNameNode);
        xmlPropRef.setColonPos(i3);
        xmlPropRef.setPropName(name);
        xmlPropRef.setLineno(i5);
        return xmlPropRef;
    }

    private void recordComment(int i, String str) {
        if (this.scannedComments == null) {
            this.scannedComments = new ArrayList();
        }
        TokenStream tokenStream = this.ts;
        Comment comment = new Comment(tokenStream.tokenBeg, tokenStream.getTokenLength(), this.ts.commentType, str);
        if (this.ts.commentType == Token.CommentType.JSDOC && this.compilerEnv.isRecordingLocalJsDocComments()) {
            TokenStream tokenStream2 = this.ts;
            Comment comment2 = new Comment(tokenStream2.tokenBeg, tokenStream2.getTokenLength(), this.ts.commentType, str);
            this.currentJsDocComment = comment2;
            comment2.setLineno(i);
        }
        comment.setLineno(i);
        this.scannedComments.add(comment);
    }

    private void recordLabel(Label label, LabeledStatement labeledStatement) {
        if (peekToken() != 104) {
            codeBug();
        }
        consumeToken();
        String name = label.getName();
        Map<String, LabeledStatement> map = this.labelSet;
        if (map == null) {
            this.labelSet = new HashMap();
        } else {
            LabeledStatement labeledStatement2 = map.get(name);
            if (labeledStatement2 != null) {
                if (this.compilerEnv.isIdeMode()) {
                    Label labelByName = labeledStatement2.getLabelByName(name);
                    reportError("msg.dup.label", labelByName.getAbsolutePosition(), labelByName.getLength());
                }
                reportError("msg.dup.label", label.getPosition(), label.getLength());
            }
        }
        labeledStatement.addLabel(label);
        this.labelSet.put(name, labeledStatement);
    }

    private AstNode relExpr() {
        AstNode shiftExpr = shiftExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.ts.tokenBeg;
            if (peekToken != 52) {
                if (peekToken != 53) {
                    switch (peekToken) {
                    }
                } else {
                    continue;
                }
                consumeToken();
                shiftExpr = new InfixExpression(peekToken, shiftExpr, shiftExpr(), i);
            } else if (!this.inForInit) {
                consumeToken();
                shiftExpr = new InfixExpression(peekToken, shiftExpr, shiftExpr(), i);
            }
        }
        return shiftExpr;
    }

    private AstNode returnOrYield(int i, boolean z) {
        boolean z2;
        int i2;
        AstNode astNode;
        AstNode yield;
        if (!insideFunction()) {
            reportError(i == 4 ? "msg.bad.return" : "msg.bad.yield");
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i3 = tokenStream.lineno;
        int i4 = tokenStream.tokenBeg;
        int i5 = tokenStream.tokenEnd;
        if (i == 73 && this.compilerEnv.getLanguageVersion() >= 200 && peekToken() == 23) {
            consumeToken();
            z2 = true;
        } else {
            z2 = false;
        }
        int peekTokenOrEOL = peekTokenOrEOL();
        if (peekTokenOrEOL == -1 || peekTokenOrEOL == 0 || peekTokenOrEOL == 1 || (peekTokenOrEOL == 73 ? this.compilerEnv.getLanguageVersion() < 200 : peekTokenOrEOL == 83 || peekTokenOrEOL == 85 || peekTokenOrEOL == 87 || peekTokenOrEOL == 89)) {
            i2 = i5;
            astNode = null;
        } else {
            astNode = expr();
            i2 = getNodeEnd(astNode);
        }
        int i6 = this.endFlags;
        if (i == 4) {
            this.endFlags = i6 | (astNode == null ? 2 : 4);
            int i7 = i2 - i4;
            yield = new ReturnStatement(i4, i7, astNode);
            if (nowAllSet(i6, this.endFlags, 6)) {
                addStrictWarning("msg.return.inconsistent", "", i4, i7);
            }
        } else {
            if (!insideFunction()) {
                reportError("msg.bad.yield");
            }
            this.endFlags |= 8;
            yield = new Yield(i4, i2 - i4, astNode, z2);
            setRequiresActivation();
            setIsGenerator();
            if (!z) {
                yield = new ExpressionStatement(yield);
            }
        }
        if (insideFunction() && nowAllSet(i6, this.endFlags, 12) && !((FunctionNode) this.currentScriptOrFn).isES6Generator()) {
            Name functionName = ((FunctionNode) this.currentScriptOrFn).getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                addError("msg.anon.generator.returns", "");
            } else {
                addError("msg.generator.returns", functionName.getIdentifier());
            }
        }
        yield.setLineno(i3);
        return yield;
    }

    private void saveNameTokenData(int i, String str, int i2) {
        this.prevNameTokenStart = i;
        this.prevNameTokenString = str;
        this.prevNameTokenLineno = i2;
    }

    private AstNode shiftExpr() {
        AstNode addExpr = addExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.ts.tokenBeg;
            switch (peekToken) {
                case 18:
                case 19:
                case 20:
                    consumeToken();
                    addExpr = new InfixExpression(peekToken, addExpr, addExpr(), i);
                default:
                    return addExpr;
            }
        }
    }

    private AstNode statement() {
        int peekTokenOrEOL;
        int i = this.ts.tokenBeg;
        try {
            AstNode statementHelper = statementHelper();
            if (statementHelper != null) {
                if (this.compilerEnv.isStrictMode() && !statementHelper.hasSideEffects()) {
                    int position = statementHelper.getPosition();
                    int max = Math.max(position, lineBeginningFor(position));
                    addStrictWarning(statementHelper instanceof EmptyStatement ? "msg.extra.trailing.semi" : "msg.no.side.effects", "", max, nodeEnd(statementHelper) - max);
                }
                if (peekToken() == 162) {
                    int lineno = statementHelper.getLineno();
                    List<Comment> list = this.scannedComments;
                    if (lineno == list.get(list.size() - 1).getLineno()) {
                        List<Comment> list2 = this.scannedComments;
                        statementHelper.setInlineComment(list2.get(list2.size() - 1));
                        consumeToken();
                    }
                }
                return statementHelper;
            }
        } catch (ParserException unused) {
        }
        do {
            peekTokenOrEOL = peekTokenOrEOL();
            consumeToken();
            if (peekTokenOrEOL == -1 || peekTokenOrEOL == 0 || peekTokenOrEOL == 1) {
                break;
            }
        } while (peekTokenOrEOL != 83);
        return new EmptyStatement(i, this.ts.tokenBeg - i);
    }

    private AstNode statementHelper() {
        AstNode returnOrYield;
        AstNode keywordLiteral;
        int i;
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null && labeledStatement.getStatement() != null) {
            this.currentLabel = null;
        }
        int peekToken = peekToken();
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        if (peekToken == -1) {
            consumeToken();
            return makeErrorNode();
        }
        if (peekToken != 4) {
            if (peekToken == 39) {
                returnOrYield = nameOrLabel();
                if (!(returnOrYield instanceof ExpressionStatement)) {
                    return returnOrYield;
                }
            } else if (peekToken == 50) {
                returnOrYield = throwStatement();
            } else if (peekToken != 73) {
                if (peekToken == 86) {
                    return block();
                }
                if (peekToken == 110) {
                    consumeToken();
                    return function(3);
                }
                if (peekToken == 113) {
                    return ifStatement();
                }
                if (peekToken == 115) {
                    return switchStatement();
                }
                if (peekToken == 82) {
                    return tryStatement();
                }
                if (peekToken == 83) {
                    consumeToken();
                    int i3 = this.ts.tokenBeg;
                    EmptyStatement emptyStatement = new EmptyStatement(i3, this.ts.tokenEnd - i3);
                    emptyStatement.setLineno(this.ts.lineno);
                    return emptyStatement;
                }
                if (peekToken != 154) {
                    if (peekToken != 155) {
                        if (peekToken == 161) {
                            consumeToken();
                            TokenStream tokenStream2 = this.ts;
                            int i4 = tokenStream2.tokenBeg;
                            keywordLiteral = new KeywordLiteral(i4, tokenStream2.tokenEnd - i4, peekToken);
                            i = this.ts.lineno;
                        } else {
                            if (peekToken == 162) {
                                List<Comment> list = this.scannedComments;
                                return list.get(list.size() - 1);
                            }
                            switch (peekToken) {
                                case 117:
                                    returnOrYield = defaultXmlNamespace();
                                    break;
                                case 118:
                                    return whileLoop();
                                case 119:
                                    return doLoop();
                                case 120:
                                    return forLoop();
                                case 121:
                                    returnOrYield = breakStatement();
                                    break;
                                case 122:
                                    returnOrYield = continueStatement();
                                    break;
                                case 123:
                                    break;
                                case 124:
                                    if (this.inUseStrictDirective) {
                                        reportError("msg.no.with.strict");
                                    }
                                    return withStatement();
                                default:
                                    i = tokenStream.lineno;
                                    keywordLiteral = new ExpressionStatement(expr(), true ^ insideFunction());
                                    break;
                            }
                        }
                        keywordLiteral.setLineno(i);
                        returnOrYield = keywordLiteral;
                    }
                    consumeToken();
                    TokenStream tokenStream3 = this.ts;
                    int i5 = tokenStream3.lineno;
                    returnOrYield = variables(this.currentToken, tokenStream3.tokenBeg, true);
                    returnOrYield.setLineno(i5);
                } else {
                    returnOrYield = letStatement();
                    if (!(returnOrYield instanceof VariableDeclaration) || peekToken() != 83) {
                        return returnOrYield;
                    }
                }
            }
            autoInsertSemicolon(returnOrYield);
            return returnOrYield;
        }
        returnOrYield = returnOrYield(peekToken, false);
        autoInsertSemicolon(returnOrYield);
        return returnOrYield;
    }

    private AstNode statements() {
        return statements(null);
    }

    private SwitchStatement switchStatement() {
        boolean z;
        AstNode expr;
        if (this.currentToken != 115) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        SwitchStatement switchStatement = new SwitchStatement(i);
        if (mustMatchToken(88, "msg.no.paren.switch", true)) {
            switchStatement.setLp(this.ts.tokenBeg - i);
        }
        switchStatement.setLineno(this.ts.lineno);
        switchStatement.setExpression(expr());
        enterSwitch(switchStatement);
        try {
            if (mustMatchToken(89, "msg.no.paren.after.switch", true)) {
                switchStatement.setRp(this.ts.tokenBeg - i);
            }
            mustMatchToken(86, "msg.no.brace.switch", true);
            boolean z2 = false;
            while (true) {
                int nextToken = nextToken();
                TokenStream tokenStream = this.ts;
                int i2 = tokenStream.tokenBeg;
                int i3 = tokenStream.lineno;
                if (nextToken == 87) {
                    switchStatement.setLength(tokenStream.tokenEnd - i);
                    break;
                }
                if (nextToken != 162) {
                    if (nextToken == 116) {
                        z = z2;
                        expr = expr();
                    } else {
                        if (nextToken != 117) {
                            reportError("msg.bad.switch");
                            break;
                        }
                        if (z2) {
                            reportError("msg.double.switch.default");
                        }
                        expr = null;
                        z = true;
                    }
                    mustMatchToken(104, "msg.no.colon.case", true);
                    SwitchCase switchCase = new SwitchCase(i2);
                    switchCase.setExpression(expr);
                    switchCase.setLength(this.ts.tokenEnd - i);
                    switchCase.setLineno(i3);
                    while (true) {
                        int peekToken = peekToken();
                        if (peekToken == 87 || peekToken == 116 || peekToken == 117 || peekToken == 0) {
                            break;
                        }
                        if (peekToken == 162) {
                            List<Comment> list = this.scannedComments;
                            Comment comment = list.get(list.size() - 1);
                            if (switchCase.getInlineComment() == null && comment.getLineno() == switchCase.getLineno()) {
                                switchCase.setInlineComment(comment);
                            } else {
                                switchCase.addStatement(comment);
                            }
                            consumeToken();
                        } else {
                            switchCase.addStatement(statement());
                        }
                    }
                    switchStatement.addCase(switchCase);
                    z2 = z;
                } else {
                    List<Comment> list2 = this.scannedComments;
                    switchStatement.addChild(list2.get(list2.size() - 1));
                }
            }
            return switchStatement;
        } finally {
            exitSwitch();
        }
    }

    private ThrowStatement throwStatement() {
        if (this.currentToken != 50) {
            codeBug();
        }
        consumeToken();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int i2 = tokenStream.lineno;
        if (peekTokenOrEOL() == 1) {
            reportError("msg.bad.throw.eol");
        }
        ThrowStatement throwStatement = new ThrowStatement(i, expr());
        throwStatement.setLineno(i2);
        return throwStatement;
    }

    private TryStatement tryStatement() {
        Comment comment;
        int i;
        ArrayList arrayList;
        int i2;
        AstNode astNode;
        boolean z;
        int i3;
        AstNode astNode2;
        if (this.currentToken != 82) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        TokenStream tokenStream = this.ts;
        int i4 = tokenStream.tokenBeg;
        int i5 = tokenStream.lineno;
        TryStatement tryStatement = new TryStatement(i4);
        int peekToken = peekToken();
        if (peekToken == 162) {
            List<Comment> list = this.scannedComments;
            tryStatement.setInlineComment(list.get(list.size() - 1));
            consumeToken();
            peekToken = peekToken();
        }
        if (peekToken != 86) {
            reportError("msg.no.brace.try");
        }
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(tryStatement);
        int nodeEnd = getNodeEnd(nextStatementAfterInlineComments);
        int peekToken2 = peekToken();
        if (peekToken2 == 125) {
            boolean z2 = false;
            arrayList = null;
            for (int i6 = 125; matchToken(i6, true); i6 = 125) {
                int i7 = this.ts.lineno;
                if (z2) {
                    reportError("msg.catch.unreachable");
                }
                int i8 = this.ts.tokenBeg;
                int i9 = mustMatchToken(88, "msg.no.paren.catch", true) ? this.ts.tokenBeg : -1;
                mustMatchToken(39, "msg.bad.catchcond", true);
                Name createNameNode = createNameNode();
                Comment andResetJsDoc2 = getAndResetJsDoc();
                if (andResetJsDoc2 != null) {
                    createNameNode.setJsDocNode(andResetJsDoc2);
                }
                String identifier = createNameNode.getIdentifier();
                if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                    reportError("msg.bad.id.strict", identifier);
                }
                if (matchToken(113, true)) {
                    i3 = this.ts.tokenBeg;
                    astNode2 = expr();
                    z = z2;
                } else {
                    z = true;
                    i3 = -1;
                    astNode2 = null;
                }
                int i10 = mustMatchToken(89, "msg.bad.catchcond", true) ? this.ts.tokenBeg : -1;
                Comment comment2 = andResetJsDoc;
                mustMatchToken(86, "msg.no.brace.catchblock", true);
                Block block = (Block) statements();
                int nodeEnd2 = getNodeEnd(block);
                CatchClause catchClause = new CatchClause(i8);
                catchClause.setVarName(createNameNode);
                catchClause.setCatchCondition(astNode2);
                catchClause.setBody(block);
                if (i3 != -1) {
                    catchClause.setIfPosition(i3 - i8);
                }
                catchClause.setParens(i9, i10);
                catchClause.setLineno(i7);
                nodeEnd = mustMatchToken(87, "msg.no.brace.after.body", true) ? this.ts.tokenEnd : nodeEnd2;
                catchClause.setLength(nodeEnd - i8);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(catchClause);
                z2 = z;
                andResetJsDoc = comment2;
            }
            comment = andResetJsDoc;
            i = 126;
        } else {
            comment = andResetJsDoc;
            i = 126;
            if (peekToken2 != 126) {
                mustMatchToken(126, "msg.try.no.catchfinally", true);
            }
            arrayList = null;
        }
        if (matchToken(i, true)) {
            i2 = this.ts.tokenBeg;
            astNode = statement();
            nodeEnd = getNodeEnd(astNode);
        } else {
            i2 = -1;
            astNode = null;
        }
        tryStatement.setLength(nodeEnd - i4);
        tryStatement.setTryBlock(nextStatementAfterInlineComments);
        tryStatement.setCatchClauses(arrayList);
        tryStatement.setFinallyBlock(astNode);
        if (i2 != -1) {
            tryStatement.setFinallyPosition(i2 - i4);
        }
        tryStatement.setLineno(i5);
        if (comment != null) {
            tryStatement.setJsDocNode(comment);
        }
        return tryStatement;
    }

    private AstNode unaryExpr() {
        int peekToken = peekToken();
        if (peekToken == 162) {
            consumeToken();
            peekToken = peekUntilNonComment(peekToken);
        }
        int i = this.ts.lineno;
        if (peekToken == -1) {
            consumeToken();
            return makeErrorNode();
        }
        if (peekToken != 14) {
            if (peekToken != 127) {
                if (peekToken == 21) {
                    consumeToken();
                    UnaryExpression unaryExpression = new UnaryExpression(28, this.ts.tokenBeg, unaryExpr());
                    unaryExpression.setLineno(i);
                    return unaryExpression;
                }
                if (peekToken == 22) {
                    consumeToken();
                    UnaryExpression unaryExpression2 = new UnaryExpression(29, this.ts.tokenBeg, unaryExpr());
                    unaryExpression2.setLineno(i);
                    return unaryExpression2;
                }
                if (peekToken != 26 && peekToken != 27) {
                    if (peekToken == 31) {
                        consumeToken();
                        UnaryExpression unaryExpression3 = new UnaryExpression(peekToken, this.ts.tokenBeg, unaryExpr());
                        unaryExpression3.setLineno(i);
                        return unaryExpression3;
                    }
                    if (peekToken != 32) {
                        if (peekToken == 107 || peekToken == 108) {
                            consumeToken();
                            UnaryExpression unaryExpression4 = new UnaryExpression(peekToken, this.ts.tokenBeg, memberExpr(true));
                            unaryExpression4.setLineno(i);
                            checkBadIncDec(unaryExpression4);
                            return unaryExpression4;
                        }
                    }
                }
            }
            consumeToken();
            UnaryExpression unaryExpression5 = new UnaryExpression(peekToken, this.ts.tokenBeg, unaryExpr());
            unaryExpression5.setLineno(i);
            return unaryExpression5;
        }
        if (this.compilerEnv.isXmlAvailable()) {
            consumeToken();
            return memberExprTail(true, xmlInitializer());
        }
        AstNode memberExpr = memberExpr(true);
        int peekTokenOrEOL = peekTokenOrEOL();
        if (peekTokenOrEOL != 107 && peekTokenOrEOL != 108) {
            return memberExpr;
        }
        consumeToken();
        UnaryExpression unaryExpression6 = new UnaryExpression(peekTokenOrEOL, this.ts.tokenBeg, memberExpr, true);
        unaryExpression6.setLineno(i);
        checkBadIncDec(unaryExpression6);
        return unaryExpression6;
    }

    private VariableDeclaration variables(int i, int i2, boolean z) {
        AstNode destructuringPrimaryExpr;
        int i3;
        Name name;
        VariableDeclaration variableDeclaration = new VariableDeclaration(i2);
        variableDeclaration.setType(i);
        variableDeclaration.setLineno(this.ts.lineno);
        Comment andResetJsDoc = getAndResetJsDoc();
        if (andResetJsDoc != null) {
            variableDeclaration.setJsDocNode(andResetJsDoc);
        }
        do {
            int peekToken = peekToken();
            TokenStream tokenStream = this.ts;
            int i4 = tokenStream.tokenBeg;
            int i5 = tokenStream.tokenEnd;
            AstNode astNode = null;
            if (peekToken == 84 || peekToken == 86) {
                destructuringPrimaryExpr = destructuringPrimaryExpr();
                int nodeEnd = getNodeEnd(destructuringPrimaryExpr);
                if (!(destructuringPrimaryExpr instanceof DestructuringForm)) {
                    reportError("msg.bad.assign.left", i4, nodeEnd - i4);
                }
                markDestructuring(destructuringPrimaryExpr);
                i3 = nodeEnd;
                name = null;
            } else {
                mustMatchToken(39, "msg.bad.var", true);
                Name createNameNode = createNameNode();
                createNameNode.setLineno(this.ts.getLineno());
                if (this.inUseStrictDirective) {
                    String string = this.ts.getString();
                    if ("eval".equals(string) || "arguments".equals(this.ts.getString())) {
                        reportError("msg.bad.id.strict", string);
                    }
                }
                defineSymbol(i, this.ts.getString(), this.inForInit);
                i3 = i5;
                name = createNameNode;
                destructuringPrimaryExpr = null;
            }
            int i6 = this.ts.lineno;
            Comment andResetJsDoc2 = getAndResetJsDoc();
            if (matchToken(91, true)) {
                astNode = assignExpr();
                i3 = getNodeEnd(astNode);
            }
            VariableInitializer variableInitializer = new VariableInitializer(i4, i3 - i4);
            if (destructuringPrimaryExpr != null) {
                if (astNode == null && !this.inForInit) {
                    reportError("msg.destruct.assign.no.init");
                }
                variableInitializer.setTarget(destructuringPrimaryExpr);
            } else {
                variableInitializer.setTarget(name);
            }
            variableInitializer.setInitializer(astNode);
            variableInitializer.setType(i);
            variableInitializer.setJsDocNode(andResetJsDoc2);
            variableInitializer.setLineno(i6);
            variableDeclaration.addVariable(variableInitializer);
        } while (matchToken(90, true));
        variableDeclaration.setLength(i3 - i2);
        variableDeclaration.setIsStatement(z);
        return variableDeclaration;
    }

    private void warnMissingSemi(int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            int[] iArr = new int[2];
            String line = this.ts.getLine(i2, iArr);
            if (this.compilerEnv.isIdeMode()) {
                i = Math.max(i, i2 - iArr[1]);
            }
            int i3 = i;
            if (line != null) {
                addStrictWarning("msg.missing.semi", "", i3, i2 - i3, iArr[0], line, iArr[1]);
            } else {
                addStrictWarning("msg.missing.semi", "", i3, i2 - i3);
            }
        }
    }

    private void warnTrailingComma(int i, List<?> list, int i2) {
        if (this.compilerEnv.getWarnTrailingComma()) {
            if (!list.isEmpty()) {
                i = ((AstNode) list.get(0)).getPosition();
            }
            int max = Math.max(i, lineBeginningFor(i2));
            addWarning("msg.extra.trailing.comma", max, i2 - max);
        }
    }

    private WhileLoop whileLoop() {
        if (this.currentToken != 118) {
            codeBug();
        }
        consumeToken();
        int i = this.ts.tokenBeg;
        WhileLoop whileLoop = new WhileLoop(i);
        whileLoop.setLineno(this.ts.lineno);
        enterLoop(whileLoop);
        try {
            ConditionData condition = condition();
            whileLoop.setCondition(condition.condition);
            whileLoop.setParens(condition.lp - i, condition.rp - i);
            AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(whileLoop);
            whileLoop.setLength(getNodeEnd(nextStatementAfterInlineComments) - i);
            whileLoop.setBody(nextStatementAfterInlineComments);
            return whileLoop;
        } finally {
            exitLoop();
        }
    }

    private WithStatement withStatement() {
        if (this.currentToken != 124) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        TokenStream tokenStream = this.ts;
        int i = tokenStream.lineno;
        int i2 = tokenStream.tokenBeg;
        int i3 = mustMatchToken(88, "msg.no.paren.with", true) ? this.ts.tokenBeg : -1;
        AstNode expr = expr();
        int i4 = mustMatchToken(89, "msg.no.paren.after.with", true) ? this.ts.tokenBeg : -1;
        WithStatement withStatement = new WithStatement(i2);
        AstNode nextStatementAfterInlineComments = getNextStatementAfterInlineComments(withStatement);
        withStatement.setLength(getNodeEnd(nextStatementAfterInlineComments) - i2);
        withStatement.setJsDocNode(andResetJsDoc);
        withStatement.setExpression(expr);
        withStatement.setStatement(nextStatementAfterInlineComments);
        withStatement.setParens(i3, i4);
        withStatement.setLineno(i);
        return withStatement;
    }

    private XmlElemRef xmlElemRef(int i, Name name, int i2) {
        int i3 = this.ts.tokenBeg;
        int i4 = -1;
        int i5 = i != -1 ? i : i3;
        AstNode expr = expr();
        int nodeEnd = getNodeEnd(expr);
        if (mustMatchToken(85, "msg.no.bracket.index", true)) {
            TokenStream tokenStream = this.ts;
            int i6 = tokenStream.tokenBeg;
            nodeEnd = tokenStream.tokenEnd;
            i4 = i6;
        }
        XmlElemRef xmlElemRef = new XmlElemRef(i5, nodeEnd - i5);
        xmlElemRef.setNamespace(name);
        xmlElemRef.setColonPos(i2);
        xmlElemRef.setAtPos(i);
        xmlElemRef.setExpression(expr);
        xmlElemRef.setBrackets(i3, i4);
        return xmlElemRef;
    }

    private AstNode xmlInitializer() {
        if (this.currentToken != 14) {
            codeBug();
        }
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        int firstXMLToken = tokenStream.getFirstXMLToken();
        if (firstXMLToken == 146 || firstXMLToken == 149) {
            XmlLiteral xmlLiteral = new XmlLiteral(i);
            xmlLiteral.setLineno(this.ts.lineno);
            while (firstXMLToken == 146) {
                TokenStream tokenStream2 = this.ts;
                xmlLiteral.addFragment(new XmlString(tokenStream2.tokenBeg, tokenStream2.getString()));
                mustMatchToken(86, "msg.syntax", true);
                int i2 = this.ts.tokenBeg;
                AstNode emptyExpression = peekToken() == 87 ? new EmptyExpression(i2, this.ts.tokenEnd - i2) : expr();
                mustMatchToken(87, "msg.syntax", true);
                XmlExpression xmlExpression = new XmlExpression(i2, emptyExpression);
                xmlExpression.setIsXmlAttribute(this.ts.isXMLAttribute());
                xmlExpression.setLength(this.ts.tokenEnd - i2);
                xmlLiteral.addFragment(xmlExpression);
                firstXMLToken = this.ts.getNextXMLToken();
            }
            if (firstXMLToken == 149) {
                TokenStream tokenStream3 = this.ts;
                xmlLiteral.addFragment(new XmlString(tokenStream3.tokenBeg, tokenStream3.getString()));
                return xmlLiteral;
            }
        }
        reportError("msg.syntax");
        return makeErrorNode();
    }

    void addError(String str) {
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        addError(str, i, tokenStream.tokenEnd - i);
    }

    void addStrictWarning(String str, String str2) {
        int i;
        int i2;
        TokenStream tokenStream = this.ts;
        if (tokenStream != null) {
            i = tokenStream.tokenBeg;
            i2 = tokenStream.tokenEnd - i;
        } else {
            i = -1;
            i2 = -1;
        }
        addStrictWarning(str, str2, i, i2);
    }

    void addWarning(String str, int i, int i2) {
        addWarning(str, null, i, i2);
    }

    protected void checkActivationName(String str, int i) {
        if (insideFunction()) {
            if (("arguments".equals(str) && ((FunctionNode) this.currentScriptOrFn).getFunctionType() != 4) || (this.compilerEnv.getActivationNames() != null && this.compilerEnv.getActivationNames().contains(str)) || (SentryEnvelopeItemHeader.JsonKeys.LENGTH.equals(str) && i == 33 && this.compilerEnv.getLanguageVersion() == 120)) {
                setRequiresActivation();
            }
        }
    }

    protected void checkMutableReference(Node node) {
        if ((node.getIntProp(16, 0) & 4) != 0) {
            reportError("msg.bad.assign.left");
        }
    }

    Node createDestructuringAssignment(int i, Node node, Node node2) {
        String nextTempName = this.currentScriptOrFn.getNextTempName();
        Node destructuringAssignmentHelper = destructuringAssignmentHelper(i, node, node2, nextTempName);
        destructuringAssignmentHelper.getLastChild().addChildToBack(createName(nextTempName));
        return destructuringAssignmentHelper;
    }

    protected Node createName(int i, String str, Node node) {
        Node createName = createName(str);
        createName.setType(i);
        if (node != null) {
            createName.addChildToBack(node);
        }
        return createName;
    }

    protected Node createNumber(double d) {
        return Node.newNumber(d);
    }

    protected Scope createScopeNode(int i, int i2) {
        Scope scope = new Scope();
        scope.setType(i);
        scope.setLineno(i2);
        return scope;
    }

    void defineSymbol(int i, String str) {
        defineSymbol(i, str, false);
    }

    boolean destructuringArray(ArrayLiteral arrayLiteral, int i, String str, Node node, List<String> list) {
        int i2 = i == 155 ? 156 : 8;
        int i3 = 0;
        boolean z = true;
        for (AstNode astNode : arrayLiteral.getElements()) {
            if (astNode.getType() == 129) {
                i3++;
            } else {
                Node node2 = new Node(36, createName(str), createNumber(i3));
                if (astNode.getType() == 39) {
                    String string = astNode.getString();
                    node.addChildToBack(new Node(i2, createName(49, string, null), node2));
                    if (i != -1) {
                        defineSymbol(i, string, true);
                        list.add(string);
                    }
                } else {
                    node.addChildToBack(destructuringAssignmentHelper(i, astNode, node2, this.currentScriptOrFn.getNextTempName()));
                }
                i3++;
                z = false;
            }
        }
        return z;
    }

    Node destructuringAssignmentHelper(int i, Node node, Node node2, String str) {
        Scope createScopeNode = createScopeNode(Token.LETEXPR, node.getLineno());
        createScopeNode.addChildToFront(new Node(154, createName(39, str, node2)));
        try {
            pushScope(createScopeNode);
            boolean z = true;
            defineSymbol(154, str, true);
            popScope();
            Node node3 = new Node(90);
            createScopeNode.addChildToBack(node3);
            List<String> arrayList = new ArrayList<>();
            int type = node.getType();
            if (type == 33 || type == 36) {
                if (i == 123 || i == 154 || i == 155) {
                    reportError("msg.bad.assign.left");
                }
                node3.addChildToBack(simpleAssignment(node, createName(str)));
            } else if (type == 66) {
                z = destructuringArray((ArrayLiteral) node, i, str, node3, arrayList);
            } else if (type != 67) {
                reportError("msg.bad.assign.left");
            } else {
                z = destructuringObject((ObjectLiteral) node, i, str, node3, arrayList);
            }
            if (z) {
                node3.addChildToBack(createNumber(0.0d));
            }
            createScopeNode.putProp(22, arrayList);
            return createScopeNode;
        } catch (Throwable th) {
            popScope();
            throw th;
        }
    }

    boolean destructuringObject(ObjectLiteral objectLiteral, int i, String str, Node node, List<String> list) {
        Node node2;
        int i2 = i == 155 ? 156 : 8;
        boolean z = true;
        for (ObjectProperty objectProperty : objectLiteral.getElements()) {
            TokenStream tokenStream = this.ts;
            int i3 = tokenStream != null ? tokenStream.lineno : 0;
            AstNode left = objectProperty.getLeft();
            if (left instanceof Name) {
                node2 = new Node(33, createName(str), Node.newString(((Name) left).getIdentifier()));
            } else if (left instanceof StringLiteral) {
                node2 = new Node(33, createName(str), Node.newString(((StringLiteral) left).getValue()));
            } else {
                if (!(left instanceof NumberLiteral)) {
                    throw codeBug();
                }
                node2 = new Node(36, createName(str), createNumber((int) ((NumberLiteral) left).getNumber()));
            }
            node2.setLineno(i3);
            AstNode right = objectProperty.getRight();
            if (right.getType() == 39) {
                String identifier = ((Name) right).getIdentifier();
                node.addChildToBack(new Node(i2, createName(49, identifier, null), node2));
                if (i != -1) {
                    defineSymbol(i, identifier, true);
                    list.add(identifier);
                }
            } else {
                node.addChildToBack(destructuringAssignmentHelper(i, right, node2, this.currentScriptOrFn.getNextTempName()));
            }
            z = false;
        }
        return z;
    }

    public boolean eof() {
        return this.ts.eof();
    }

    public boolean inUseStrictDirective() {
        return this.inUseStrictDirective;
    }

    boolean insideFunction() {
        return this.nestingOfFunction != 0;
    }

    String lookupMessage(String str) {
        return lookupMessage(str, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void markDestructuring(AstNode astNode) {
        if (astNode instanceof DestructuringForm) {
            ((DestructuringForm) astNode).setIsDestructuring(true);
        } else if (astNode instanceof ParenthesizedExpression) {
            markDestructuring(((ParenthesizedExpression) astNode).getExpression());
        }
    }

    void popScope() {
        this.currentScope = this.currentScope.getParentScope();
    }

    void pushScope(Scope scope) {
        Scope parentScope = scope.getParentScope();
        if (parentScope == null) {
            this.currentScope.addChildScope(scope);
        } else if (parentScope != this.currentScope) {
            codeBug();
        }
        this.currentScope = scope;
    }

    protected AstNode removeParens(AstNode astNode) {
        while (astNode instanceof ParenthesizedExpression) {
            astNode = ((ParenthesizedExpression) astNode).getExpression();
        }
        return astNode;
    }

    void reportError(String str) {
        reportError(str, null);
    }

    public void setDefaultUseStrictDirective(boolean z) {
        this.defaultUseStrictDirective = z;
    }

    protected void setIsGenerator() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setIsGenerator();
        }
    }

    protected void setRequiresActivation() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setRequiresActivation();
        }
    }

    protected Node simpleAssignment(Node node, Node node2) {
        Node firstChild;
        Node lastChild;
        int i;
        int type = node.getType();
        if (type != 33 && type != 36) {
            if (type != 39) {
                if (type != 68) {
                    throw codeBug();
                }
                Node firstChild2 = node.getFirstChild();
                checkMutableReference(firstChild2);
                return new Node(69, firstChild2, node2);
            }
            String identifier = ((Name) node).getIdentifier();
            if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                reportError("msg.bad.id.strict", identifier);
            }
            node.setType(49);
            return new Node(8, node, node2);
        }
        if (node instanceof PropertyGet) {
            PropertyGet propertyGet = (PropertyGet) node;
            firstChild = propertyGet.getTarget();
            lastChild = propertyGet.getProperty();
        } else if (node instanceof ElementGet) {
            ElementGet elementGet = (ElementGet) node;
            firstChild = elementGet.getTarget();
            lastChild = elementGet.getElement();
        } else {
            firstChild = node.getFirstChild();
            lastChild = node.getLastChild();
        }
        if (type == 33) {
            lastChild.setType(41);
            i = 35;
        } else {
            i = 37;
        }
        return new Node(i, firstChild, lastChild, node2);
    }

    public Parser(CompilerEnvirons compilerEnvirons) {
        this(compilerEnvirons, compilerEnvirons.getErrorReporter());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.ast.Name createNameNode(boolean r6, int r7) {
        /*
            r5 = this;
            external.sdk.pendo.io.mozilla.javascript.TokenStream r0 = r5.ts
            int r1 = r0.tokenBeg
            java.lang.String r0 = r0.getString()
            external.sdk.pendo.io.mozilla.javascript.TokenStream r2 = r5.ts
            int r2 = r2.lineno
            java.lang.String r3 = r5.prevNameTokenString
            java.lang.String r4 = ""
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L23
            int r1 = r5.prevNameTokenStart
            java.lang.String r0 = r5.prevNameTokenString
            int r2 = r5.prevNameTokenLineno
            r3 = 0
            r5.prevNameTokenStart = r3
            r5.prevNameTokenString = r4
            r5.prevNameTokenLineno = r3
        L23:
            if (r0 != 0) goto L31
            external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons r3 = r5.compilerEnv
            boolean r3 = r3.isIdeMode()
            if (r3 == 0) goto L2e
            goto L32
        L2e:
            r5.codeBug()
        L31:
            r4 = r0
        L32:
            external.sdk.pendo.io.mozilla.javascript.ast.Name r0 = new external.sdk.pendo.io.mozilla.javascript.ast.Name
            r0.<init>(r1, r4)
            r0.setLineno(r2)
            if (r6 == 0) goto L3f
            r5.checkActivationName(r4, r7)
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Parser.createNameNode(boolean, int):external.sdk.pendo.io.mozilla.javascript.ast.Name");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0 A[Catch: all -> 0x012b, TryCatch #0 {all -> 0x012b, blocks: (B:35:0x00bf, B:37:0x00e0, B:40:0x00ec, B:45:0x0100, B:47:0x00fc), top: B:34:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc A[Catch: all -> 0x012b, TryCatch #0 {all -> 0x012b, blocks: (B:35:0x00bf, B:37:0x00e0, B:40:0x00ec, B:45:0x0100, B:47:0x00fc), top: B:34:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode function(int r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Parser.function(int, boolean):external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode");
    }

    private AstNode generatorExpression(AstNode astNode, int i, boolean z) {
        int i2;
        ConditionData conditionData;
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 120) {
            arrayList.add(generatorExpressionLoop());
        }
        if (peekToken() == 113) {
            consumeToken();
            i2 = this.ts.tokenBeg - i;
            conditionData = condition();
        } else {
            i2 = -1;
            conditionData = null;
        }
        if (!z) {
            mustMatchToken(89, "msg.no.paren.let", true);
        }
        GeneratorExpression generatorExpression = new GeneratorExpression(i, this.ts.tokenEnd - i);
        generatorExpression.setResult(astNode);
        generatorExpression.setLoops(arrayList);
        if (conditionData != null) {
            generatorExpression.setIfPosition(i2);
            generatorExpression.setFilter(conditionData.condition);
            generatorExpression.setFilterLp(conditionData.lp - i);
            generatorExpression.setFilterRp(conditionData.rp - i);
        }
        return generatorExpression;
    }

    private boolean mustMatchToken(int i, String str, boolean z) {
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        return mustMatchToken(i, str, i2, tokenStream.tokenEnd - i2, z);
    }

    private AstNode statements(AstNode astNode) {
        if (this.currentToken != 86 && !this.compilerEnv.isIdeMode()) {
            codeBug();
        }
        int i = this.ts.tokenBeg;
        if (astNode == null) {
            astNode = new Block(i);
        }
        astNode.setLineno(this.ts.lineno);
        while (true) {
            int peekToken = peekToken();
            if (peekToken <= 0 || peekToken == 87) {
                break;
            }
            astNode.addChild(statement());
        }
        astNode.setLength(this.ts.tokenBeg - i);
        return astNode;
    }

    void addError(String str, int i) {
        String ch = Character.toString((char) i);
        TokenStream tokenStream = this.ts;
        int i2 = tokenStream.tokenBeg;
        addError(str, ch, i2, tokenStream.tokenEnd - i2);
    }

    void addStrictWarning(String str, String str2, int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2);
        }
    }

    void addWarning(String str, String str2) {
        int i;
        int i2;
        TokenStream tokenStream = this.ts;
        if (tokenStream != null) {
            i = tokenStream.tokenBeg;
            i2 = tokenStream.tokenEnd - i;
        } else {
            i = -1;
            i2 = -1;
        }
        addWarning(str, str2, i, i2);
    }

    protected Node createName(String str) {
        checkActivationName(str, 39);
        return Node.newString(39, str);
    }

    void defineSymbol(int i, String str, boolean z) {
        if (str == null) {
            if (this.compilerEnv.isIdeMode()) {
                return;
            } else {
                codeBug();
            }
        }
        Scope definingScope = this.currentScope.getDefiningScope(str);
        external.sdk.pendo.io.mozilla.javascript.ast.Symbol symbol = definingScope != null ? definingScope.getSymbol(str) : null;
        int declType = symbol != null ? symbol.getDeclType() : -1;
        String str2 = "msg.var.redecl";
        if (symbol != null && (declType == 155 || i == 155 || (definingScope == this.currentScope && declType == 154))) {
            if (declType == 155) {
                str2 = "msg.const.redecl";
            } else if (declType == 154) {
                str2 = "msg.let.redecl";
            } else if (declType != 123) {
                str2 = declType == 110 ? "msg.fn.redecl" : "msg.parm.redecl";
            }
            addError(str2, str);
            return;
        }
        if (i == 88) {
            if (symbol != null) {
                addWarning("msg.dup.parms", str);
            }
            this.currentScriptOrFn.putSymbol(new external.sdk.pendo.io.mozilla.javascript.ast.Symbol(i, str));
            return;
        }
        if (i != 110 && i != 123) {
            if (i == 154) {
                if (z || !(this.currentScope.getType() == 113 || (this.currentScope instanceof Loop))) {
                    this.currentScope.putSymbol(new external.sdk.pendo.io.mozilla.javascript.ast.Symbol(i, str));
                    return;
                } else {
                    addError("msg.let.decl.not.in.block");
                    return;
                }
            }
            if (i != 155) {
                throw codeBug();
            }
        }
        if (symbol == null) {
            this.currentScriptOrFn.putSymbol(new external.sdk.pendo.io.mozilla.javascript.ast.Symbol(i, str));
        } else if (declType == 123) {
            addStrictWarning("msg.var.redecl", str);
        } else if (declType == 88) {
            addStrictWarning("msg.var.hides.arg", str);
        }
    }

    String lookupMessage(String str, String str2) {
        return str2 == null ? ScriptRuntime.getMessage0(str) : ScriptRuntime.getMessage1(str, str2);
    }

    @Deprecated
    public AstRoot parse(Reader reader, String str, int i) {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        if (this.compilerEnv.isIdeMode()) {
            return parse(Kit.readReader(reader), str, i);
        }
        try {
            this.sourceURI = str;
            this.ts = new TokenStream(this, reader, null, i);
            return parse();
        } finally {
            this.parseFinished = true;
        }
    }

    void reportError(String str, int i, int i2) {
        reportError(str, null, i, i2);
    }

    public Parser(CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter) {
        this.currentFlaggedToken = 0;
        this.prevNameTokenString = "";
        this.compilerEnv = compilerEnvirons;
        this.errorReporter = errorReporter;
        if (errorReporter instanceof IdeErrorReporter) {
            this.errorCollector = (IdeErrorReporter) errorReporter;
        }
    }

    private void addStrictWarning(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2, i3, str3, i4);
        }
    }

    void addError(String str, int i, int i2) {
        addError(str, null, i, i2);
    }

    void addWarning(String str, String str2, int i, int i2) {
        String lookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(lookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(lookupMessage, this.sourceURI, this.ts.getLineno(), this.ts.getLine(), this.ts.getOffset());
        }
    }

    public AstRoot parse(String str, String str2, int i) {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        this.sourceURI = str2;
        if (this.compilerEnv.isIdeMode()) {
            this.sourceChars = str.toCharArray();
        }
        this.ts = new TokenStream(this, null, str, i);
        try {
            try {
                return parse();
            } catch (IOException unused) {
                throw new IllegalStateException();
            }
        } finally {
            this.parseFinished = true;
        }
    }

    void reportError(String str, String str2) {
        TokenStream tokenStream = this.ts;
        if (tokenStream == null) {
            reportError(str, str2, 1, 1);
        } else {
            int i = tokenStream.tokenBeg;
            reportError(str, str2, i, tokenStream.tokenEnd - i);
        }
    }

    private void addWarning(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        String lookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2, i3, str3, i4);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(lookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(lookupMessage, this.sourceURI, i3, str3, i4);
        }
    }

    void addError(String str, String str2) {
        TokenStream tokenStream = this.ts;
        int i = tokenStream.tokenBeg;
        addError(str, str2, i, tokenStream.tokenEnd - i);
    }

    void reportError(String str, String str2, int i, int i2) {
        addError(str, str2, i, i2);
        if (!this.compilerEnv.recoverFromErrors()) {
            throw new ParserException();
        }
    }

    void addError(String str, String str2, int i, int i2) {
        String str3;
        int i3;
        int i4;
        this.syntaxErrorCount++;
        String lookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(lookupMessage, this.sourceURI, i, i2);
            return;
        }
        TokenStream tokenStream = this.ts;
        if (tokenStream != null) {
            int lineno = tokenStream.getLineno();
            str3 = this.ts.getLine();
            i4 = this.ts.getOffset();
            i3 = lineno;
        } else {
            str3 = "";
            i3 = 1;
            i4 = 1;
        }
        this.errorReporter.error(lookupMessage, this.sourceURI, i3, str3, i4);
    }

    private void addError(String str, String str2, int i, int i2, int i3, String str3, int i4) {
        this.syntaxErrorCount++;
        String lookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(lookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.error(lookupMessage, this.sourceURI, i3, str3, i4);
        }
    }
}
