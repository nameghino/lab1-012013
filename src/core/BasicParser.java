package core;
import java.util.Stack;

enum ParserState {
	ParserStateCreated,
	ParserStateReadingTagName,
	ParserStateReadingValue,
	ParserStateReadingAttributeName,
	ParserStateReadingAttributeValue
}


public class BasicParser implements Parser {

	Stack<Item> itemStack = new Stack<Item>();
	
	
	@Override
	public Item parse(String s) {
		for (int i=0; i < s.length(); ++i) {
			char c = s.charAt(i);
			
			
		}
		return null;
		
	}

}
