package io.castle.android.queue;

import com.squareup.tape2.ObjectQueue;
import io.castle.android.Utils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;

/* loaded from: classes2.dex */
class GsonConverter<T> implements ObjectQueue.Converter<T> {
    private final Class<T> type;

    GsonConverter(Class<T> cls) {
        this.type = cls;
    }

    @Override // com.squareup.tape2.ObjectQueue.Converter
    public T from(byte[] bArr) {
        try {
            return (T) Utils.getGsonInstance().fromJson((Reader) new InputStreamReader(new ByteArrayInputStream(bArr)), (Class) this.type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.squareup.tape2.ObjectQueue.Converter
    public void toStream(T t, OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        Utils.getGsonInstance().toJson(t, outputStreamWriter);
        outputStreamWriter.close();
    }
}
