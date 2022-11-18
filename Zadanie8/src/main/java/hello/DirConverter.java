package hello;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirConverter {
    private final FileConverter fileConverter = new FileConverter();

    void convert(String path, String extension) {
        try {
            Files.walk(Paths.get(path)).forEach(filePath -> {
                if (filePath.toString().endsWith(extension)) {
                    fileConverter.convert(filePath.toString());
                }
            });
        } catch (IOException ignored) {
        }
    }
}
