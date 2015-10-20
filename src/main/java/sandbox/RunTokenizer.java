package sandbox;

import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author NorThanapon
 * @since 10/20/15
 */
public class RunTokenizer {

    public static void main(String[] args) throws IOException {

        String text = "I want to tokenizer this string.";
        StringReader reader = new StringReader(text);

        // Tokenizer is a TokenStream
        StandardTokenizer tokenizer = new StandardTokenizer();
        tokenizer.setReader(reader);
        tokenizer.reset();

        while(tokenizer.incrementToken()) {
            String token = tokenizer.getAttribute(CharTermAttribute.class).toString();
            OffsetAttribute offset = tokenizer.getAttribute(OffsetAttribute.class);
            System.out.println(token + "@" + offset.startOffset() + ":" + offset.endOffset() );
        }

        tokenizer.close();
    }

}
