package androidx.camera.core.imagecapture;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes.dex */
class JpegBytes2Disk implements Operation<In, ImageCapture.OutputFileResults> {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";

    JpegBytes2Disk() {
    }

    @Override // androidx.camera.core.processing.Operation
    public ImageCapture.OutputFileResults apply(In in) throws ImageCaptureException {
        Packet<byte[]> packet = in.getPacket();
        ImageCapture.OutputFileOptions outputFileOptions = in.getOutputFileOptions();
        File createTempFile = createTempFile(outputFileOptions);
        writeBytesToFile(createTempFile, packet.getData());
        updateFileExif(createTempFile, (Exif) Objects.requireNonNull(packet.getExif()), outputFileOptions, packet.getRotationDegrees());
        return new ImageCapture.OutputFileResults(copyFileToTarget(createTempFile, outputFileOptions));
    }

    private static File createTempFile(ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        try {
            File file = outputFileOptions.getFile();
            if (file != null) {
                return new File(file.getParent(), TEMP_FILE_PREFIX + UUID.randomUUID().toString() + ".tmp");
            }
            return File.createTempFile(TEMP_FILE_PREFIX, ".tmp");
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to create temp file.", e);
        }
    }

    private static void writeBytesToFile(File file, byte[] bArr) throws ImageCaptureException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to write to temp file", e);
        }
    }

    private static void updateFileExif(File file, Exif exif, ImageCapture.OutputFileOptions outputFileOptions, int i) throws ImageCaptureException {
        try {
            Exif createFromFile = Exif.createFromFile(file);
            exif.copyToCroppedImage(createFromFile);
            if (createFromFile.getRotation() == 0 && i != 0) {
                createFromFile.rotate(i);
            }
            ImageCapture.Metadata metadata = outputFileOptions.getMetadata();
            if (metadata.isReversedHorizontal()) {
                createFromFile.flipHorizontally();
            }
            if (metadata.isReversedVertical()) {
                createFromFile.flipVertically();
            }
            if (metadata.getLocation() != null) {
                createFromFile.attachLocation(metadata.getLocation());
            }
            createFromFile.save();
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to update Exif data", e);
        }
    }

    private static Uri copyFileToTarget(File file, ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        if (isSaveToMediaStore(outputFileOptions)) {
            return copyFileToMediaStore(file, outputFileOptions);
        }
        if (isSaveToOutputStream(outputFileOptions)) {
            try {
                copyFileToOutputStream(file, (OutputStream) Objects.requireNonNull(outputFileOptions.getOutputStream()));
                return null;
            } catch (IOException unused) {
                throw new ImageCaptureException(1, "Failed to write to OutputStream.", null);
            }
        }
        if (isSaveToFile(outputFileOptions)) {
            return copyFileToFile(file, (File) Objects.requireNonNull(outputFileOptions.getFile()));
        }
        throw new ImageCaptureException(0, "Invalid OutputFileOptions", null);
    }

    private static Uri copyFileToMediaStore(File file, ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        ContentValues contentValues;
        ContentResolver contentResolver = (ContentResolver) Objects.requireNonNull(outputFileOptions.getContentResolver());
        if (outputFileOptions.getContentValues() != null) {
            contentValues = new ContentValues(outputFileOptions.getContentValues());
        } else {
            contentValues = new ContentValues();
        }
        setContentValuePendingFlag(contentValues, 1);
        Uri insert = contentResolver.insert(outputFileOptions.getSaveCollection(), contentValues);
        if (insert == null) {
            throw new ImageCaptureException(1, "Failed to insert a MediaStore URI.", null);
        }
        try {
            try {
                copyTempFileToUri(file, insert, contentResolver);
                return insert;
            } catch (IOException e) {
                throw new ImageCaptureException(1, "Failed to write to MediaStore URI: " + insert, e);
            }
        } finally {
            updateUriPendingStatus(insert, contentResolver, 0);
        }
    }

    private static Uri copyFileToFile(File file, File file2) throws ImageCaptureException {
        if (file2.exists()) {
            file2.delete();
        }
        if (!file.renameTo(file2)) {
            throw new ImageCaptureException(1, "Failed to overwrite the file: " + file2.getAbsolutePath(), null);
        }
        return Uri.fromFile(file2);
    }

    private static void copyTempFileToUri(File file, Uri uri, ContentResolver contentResolver) throws IOException {
        OutputStream openOutputStream = contentResolver.openOutputStream(uri);
        try {
            if (openOutputStream == null) {
                throw new FileNotFoundException(uri + " cannot be resolved.");
            }
            copyFileToOutputStream(file, openOutputStream);
            if (openOutputStream != null) {
                openOutputStream.close();
            }
        } catch (Throwable th) {
            if (openOutputStream != null) {
                try {
                    openOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static void copyFileToOutputStream(File file, OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void updateUriPendingStatus(Uri uri, ContentResolver contentResolver, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            setContentValuePendingFlag(contentValues, i);
            contentResolver.update(uri, contentValues, null, null);
        }
    }

    private static void setContentValuePendingFlag(ContentValues contentValues, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i));
        }
    }

    private static boolean isSaveToMediaStore(ImageCapture.OutputFileOptions outputFileOptions) {
        return (outputFileOptions.getSaveCollection() == null || outputFileOptions.getContentResolver() == null || outputFileOptions.getContentValues() == null) ? false : true;
    }

    private static boolean isSaveToFile(ImageCapture.OutputFileOptions outputFileOptions) {
        return outputFileOptions.getFile() != null;
    }

    private static boolean isSaveToOutputStream(ImageCapture.OutputFileOptions outputFileOptions) {
        return outputFileOptions.getOutputStream() != null;
    }

    static abstract class In {
        abstract ImageCapture.OutputFileOptions getOutputFileOptions();

        abstract Packet<byte[]> getPacket();

        In() {
        }

        static In of(Packet<byte[]> packet, ImageCapture.OutputFileOptions outputFileOptions) {
            return new AutoValue_JpegBytes2Disk_In(packet, outputFileOptions);
        }
    }
}
