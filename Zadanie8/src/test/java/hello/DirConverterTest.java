package hello;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirConverterTest {

    private final DirConverter dirConverter = new DirConverter();

    @Test
    void test(@TempDir Path tempDir) throws IOException {
        Path path = Files.createTempFile(tempDir, "", ".txt");
        String lines = "aabbbcc  12421 aa;,.";
        Files.write(path, lines.getBytes(StandardCharsets.UTF_8));
        Path path2 = Files.createTempFile(tempDir, "", ".txt");
        String lines2 = "xyz";
        Files.write(path2, lines2.getBytes(StandardCharsets.UTF_8));
        Path path3 = Files.createTempFile(tempDir, "", ".xml");
        String lines3 = "Dont touch";
        Files.write(path3, lines3.getBytes(StandardCharsets.UTF_8));

        dirConverter.convert(tempDir.toString(), ".txt");

        assertEquals("AABBBCC  12421 AA;,.", Files.readAllLines(path).get(0));
        assertEquals("XYZ", Files.readAllLines(path2).get(0));
        assertEquals("Dont touch", Files.readAllLines(path3).get(0));

    }


}
