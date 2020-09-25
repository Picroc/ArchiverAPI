package org.team404.archiver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public interface ArchiverAPI {
    class Features {
        enum CompressingMode {
            // TODO: Add more formats (rar, tar.gz)
            DEFAULT;
            enum ZipFormat {
                // TODO: Add more compressing modes
                MP3,
                WAVPACK,
                XZ
            }
        }

        enum EncryptionMode {
            // TODO: Add more modes
            NONE,
            AES,
            DES,
            RC2
        }

        CompressingMode compressingMode;
        EncryptionMode encryptionMode;
        Long chunkSize;

        public Features(CompressingMode compressingMode, EncryptionMode encryptionMode, Long chunkSize) {
            this.compressingMode = compressingMode;
            this.encryptionMode = encryptionMode;
            this.chunkSize = chunkSize;
        }
    }

    /**
     * Compress input bytes
     * @param uncompressed Uncompressed data
     * @return Compressed data
     */
    public ByteArrayOutputStream compress(ByteArrayInputStream uncompressed);
    public List<Byte> compress(List<Byte> uncompressed);

    /**
     * Compress input bytes with advanced options
     * @param uncompressed Uncompressed data
     * @param features Config
     * @return Compressed data
     */
    public ByteArrayOutputStream compress(ByteArrayInputStream uncompressed, Features features);
    public List<Byte> compress(List<Byte> uncompressed, Features features);

    /**
     * Uncompress input bytes
     * @param compressed Compressed data
     * @return Uncompressed data
     */
    public ByteArrayOutputStream uncompress(ByteArrayInputStream compressed); // with magic detecting compressing algorithm - https://pkware.cachefly.net/webdocs/casestudies/APPNOTE.TXT
    public List<Byte> uncompress(List<Byte> compressed);

    /**
     * Uncompress input bytes with advanced options
     * @param compressed Compressed data
     * @param features Config
     * @return Uncompressed data
     */
    public ByteArrayOutputStream uncompress(ByteArrayInputStream compressed, Features features);
    public List<Byte> uncompress(List<Byte> compressed, Features features);

}
