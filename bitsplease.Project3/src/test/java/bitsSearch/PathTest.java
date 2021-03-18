package bitsSearch;
import static org.junit.Assert.*;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//This will test that the file path exists.
public class PathTest {
    @Test
    public void path_exists() throws Exception {
        Path filePath = Paths.get("D:\\InteliJ\\bitsplease\\bitsplease.Project3\\src\\test\\TestResource\\PathTesting");
        assertTrue(Files.exists(filePath));
    }
}