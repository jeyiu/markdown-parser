import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", Math.max(currentIndex, openBracket));
            int openParen = markdown.indexOf("(", Math.max(currentIndex, closeBracket));
            int closeParen = markdown.indexOf(")", Math.max(currentIndex, openParen));
            if(openBracket == -1 && closeBracket == -1 && openParen == -1 && closeParen == -1){break;}
            if(openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1){
                int max1 = Math.max(openBracket, closeBracket);
                int max2 = Math.max(openParen, closeParen);
                currentIndex = Math.max(max1, max2) +1;
            }else{
                String s = markdown.substring(openParen+1, closeParen);
                if(!(s.contains("(") || s.contains("["))){
                    if(openParen == closeBracket + 1){
                        try{
                            if(markdown.charAt(openBracket-1) != '!'){
                                toReturn.add(s);
                            }
                        }catch(IndexOutOfBoundsException e){
                            toReturn.add(s);
                        }
                    }
                }
                currentIndex = closeParen + 1;   
            }

        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Parser parser = Parser.builder().build();
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        Node document = parser.parse(content);
        LinkVisitor visitor = new LinkVisitor();
        document.accept(visitor);
        System.out.println(visitor.links);
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