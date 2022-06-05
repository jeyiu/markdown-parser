import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TryCommonMark {
    public static void main(String[] args) throws IOException{
        Parser parser = Parser.builder().build();

        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);

        Node document = parser.parse(content);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        System.out.println(renderer.render(document));  // "<p>This is <em>Sparta</em></p>\n"

        // this part actually does the computation
        LinkVisitor visitor = new LinkVisitor();
        document.accept(visitor);
        System.out.println(visitor.links);  // 4
    }
    
}

// this class can be defined anywhere in the file
class WordCountVisitor extends AbstractVisitor {
    public int wordCount = 0;

    @Override
    public void visit(Text text) {
        // This is called for all Text nodes. Override other visit methods for other node types.

        // Count words (this is just an example, don't actually do it this way for various reasons).
        wordCount += text.getLiteral().split("\\W+").length;

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        visitChildren(text);
    }
}

class LinkVisitor extends AbstractVisitor {
    public ArrayList<String> links = new ArrayList<String>();
    @Override
    public void visit(Link text){
        links.add(text.getDestination());
        visitChildren(text);
    }
}