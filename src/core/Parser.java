package core;

import java.util.Stack;

enum ParserState {
	ParserStateVirgin,
	ParserStateTagOpened,
	ParserStateTagValue,
	ParserStateTagAttribute,
	ParserStateTagClosed
}

@SuppressWarnings("unused")
public class Parser {
	private static final char TAG_OPENER = '<';
	private static final char TAG_CLOSER = '>';
	private static final char TAG_FINALIZER = '/';
	private static final String VALID_ENTITY_CHARACTERS_REGEXP_STRING = "[a-zA-Z0-9-_]+"; 
	private static final String TAG_NAME_REGEXP_STRING = VALID_ENTITY_CHARACTERS_REGEXP_STRING;
	private static final String SINGLE_TAG_REGEXP_STRING = TAG_OPENER + TAG_NAME_REGEXP_STRING + TAG_FINALIZER + TAG_CLOSER;
	private static final String VALUED_TAG_REGEXP_STRING = 
			TAG_OPENER + 
			TAG_NAME_REGEXP_STRING + 
			TAG_CLOSER + 
			VALID_ENTITY_CHARACTERS_REGEXP_STRING + 
			TAG_OPENER + 
			TAG_FINALIZER + 
			TAG_NAME_REGEXP_STRING + 
			TAG_CLOSER;
		
	private Stack<String> tagStack = new Stack<String>();
	
	public void parse(String s) {
		this.parse(s, 0, s.length());
	}
	
	public void parse(String s, int start) {
		this.parse(s, start, s.length());
	}

	private void parse(String s, int start, int end) {		
		if (end - start < 1) return;		
		int tag_start = s.indexOf(TAG_OPENER, start);
		int tag_end = s.indexOf(TAG_CLOSER, tag_start+1);
	
		String tag = s.substring(tag_start+1, tag_end);
		if (tag.charAt(0) == TAG_FINALIZER) {
			tagStack.pop();
		} else {
			tagStack.push(tag);
		}
		
		System.out.println("Tag stack: " + tagStack);
		
		System.out.println(tag);
		this.parse(s, tag_end+1);
	}
}
