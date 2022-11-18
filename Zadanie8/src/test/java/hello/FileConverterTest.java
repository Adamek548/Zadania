package hello;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileConverterTest{
    private final FileConverter fileConverter = new FileConverter();

    @Test
    void ShouldConvertLowToUp(@TempDir Path tempDir) throws IOException {
        Path path = Files.createTempFile(tempDir, "", ".txt");
        String lines = "aabbbcc  12421 aa;,.";
        Files.write(path, lines.getBytes(StandardCharsets.UTF_8));

        fileConverter.convert(path.toString());

        assertEquals("AABBBCC  12421 AA;,.", Files.readAllLines(path).get(0));
    }
}