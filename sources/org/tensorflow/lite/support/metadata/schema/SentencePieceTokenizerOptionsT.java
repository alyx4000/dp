package org.tensorflow.lite.support.metadata.schema;

/* loaded from: classes6.dex */
public class SentencePieceTokenizerOptionsT {
    private AssociatedFileT[] sentencePieceModel = null;
    private AssociatedFileT[] vocabFile = null;

    public AssociatedFileT[] getSentencePieceModel() {
        return this.sentencePieceModel;
    }

    public void setSentencePieceModel(AssociatedFileT[] associatedFileTArr) {
        this.sentencePieceModel = associatedFileTArr;
    }

    public AssociatedFileT[] getVocabFile() {
        return this.vocabFile;
    }

    public void setVocabFile(AssociatedFileT[] associatedFileTArr) {
        this.vocabFile = associatedFileTArr;
    }
}
