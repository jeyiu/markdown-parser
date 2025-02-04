import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class MarkdownParseTest {
    @Test
    public void TestFile1()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("https://something.com");
        list.add("some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestFile2()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("https://something.com");
        list.add("some-page.html");
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestFile3()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestFile4()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestFile5()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestFile6()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestFile7()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestFile8()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a link on the first line");
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestFile9()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        Path fileName = Path.of("test-file9.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestSnippet1()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("`google.com");
        list.add("google.com");
        list.add("ucsd.edu");
        Path fileName = Path.of("snippet-1.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestSnippet2()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a.com");
        list.add("a.com(())");
        list.add("example.com");
        Path fileName = Path.of("snippet-2.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
    @Test
    public void TestSnippet3()  throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        Path fileName = Path.of("snippet-3.md");
        String content = Files.readString(fileName);
        assertEquals(list, MarkdownParse.getLinks(content));
    }
}