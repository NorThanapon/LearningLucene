package sandbox;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import java.io.IOException;

/**
 * @author NorThanapon
 * @since 10/20/15
 */
public class RunAnalyzer {
    public static void main(String[] args) throws IOException {
        EnglishAnalyzer analyzer = new EnglishAnalyzer();

        // Analyzer returns TokenStream
        TokenStream stream = analyzer.tokenStream(null, "I want to analyzer this string.");
        stream.reset();

        while(stream.incrementToken()){
            String token = stream.getAttribute(CharTermAttribute.class).toString();
            OffsetAttribute offset = stream.getAttribute(OffsetAttribute.class);
            System.out.println(token + "@" + offset.startOffset() + ":" + offset.endOffset() );
        }

        stream.close();
    }
}
