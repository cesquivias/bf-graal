package cesquivias.bf;

import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;

public class BFFileDetector extends FileTypeDetector {
    @Override
    public String probeContentType(Path path) {
        if (path.getFileName().toString().endsWith(".bf")) {
            return BFLanguage.MIME_TYPE;
        }
        return null;
    }
}
