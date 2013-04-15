package core;

public class ParserConstants {
	public static final char TAG_OPENER = '<';
	public static final char TAG_CLOSER = '>';
	public static final char TAG_FINALIZER = '/';
	public static final String VALID_ENTITY_CHARACTERS_REGEXP_STRING = "[a-zA-Z0-9-_]+"; 
	public static final String TAG_NAME_REGEXP_STRING = VALID_ENTITY_CHARACTERS_REGEXP_STRING;
	public static final String SINGLE_TAG_REGEXP_STRING = TAG_OPENER + TAG_NAME_REGEXP_STRING + TAG_FINALIZER + TAG_CLOSER;
	public static final String VALUED_TAG_REGEXP_STRING = 
			TAG_OPENER + 
			TAG_NAME_REGEXP_STRING + 
			TAG_CLOSER + 
			VALID_ENTITY_CHARACTERS_REGEXP_STRING + 
			TAG_OPENER + 
			TAG_FINALIZER + 
			TAG_NAME_REGEXP_STRING + 
			TAG_CLOSER;

}
