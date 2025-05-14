package org.tensorflow.lite.support.metadata.schema;

/* loaded from: classes6.dex */
public class RegexTokenizerOptionsT {
    private String delimRegexPattern = null;
    private AssociatedFileT[] vocabFile = null;

    public String getDelimRegexPattern() {
        return this.delimRegexPattern;
    }

    public void setDelimRegexPattern(String str) {
        this.delimRegexPattern = str;
    }

    public AssociatedFileT[] getVocabFile() {
        return this.vocabFile;
    }

    public void setVocabFile(AssociatedFileT[] associatedFileTArr) {
        this.vocabFile = associatedFileTArr;
    }
}
