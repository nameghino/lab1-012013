package core;

import java.util.Stack;

import java.util.regex.*;

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
	
	public Item parse(String s) {
		return this.parse(s, 0, s.length(), null);
	}
	
	private Item parse(String s, int start) {
		return this.parse(s, start, s.length(), null);
	}
	
	
	// Assuming as simplest possible tag:
	// TAG_OPENER + TAG_FINALIZER + VALID_ENTITY_CHARACTERS_REGEXP_STRING{1} + TAG_CLOSER
	private Item parse(String s, int start, int end, Item parent) {
		return null;
	}
}
