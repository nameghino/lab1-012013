package core.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.*;

@SuppressWarnings("unused")
public class ParserCoreTesting {
	
	private String testString = "" +
			"<xml>" +
			"<Person>" +
			"<Name>Nicolas</Name>" +
			"<Last>Ameghino</Last>" +
			"</Person>" +
			"</xml>";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testEmptyItemToString() {
		Item emptyElement = new Item("empty");
		assertEquals("<empty/>", emptyElement.toString());
	}
	
	@Test
	public void testAttributedElementToString() {
		Item item = new Item("attributed");
		item.setAttribute("color", "red");
		assertEquals(
				"<attributed color=\"red\"/>",
				item.toString()
				);
	}
	
	@Test
	public void testMultiAttributedElementToString() {
		Item item = new Item("attributed");
		item.setAttribute("color", "red");
		item.setAttribute("shape", "circle");
		assertEquals(
				"<attributed color=\"red\" shape=\"circle\"/>",
				item.toString()
				);
		
	}
	
	@Test
	public void testSimpleItemToString() {
		Item personElement = new Item("Person");
		Item personNameElement = new Item("FirstName", personElement);
		personNameElement.setTextValue("Nicolas");
		Item personLastNameElement = new Item("LastName", personElement);
		personLastNameElement.setTextValue("Ameghino");		
		
		assertEquals(
				"<Person>\n<FirstName>Nicolas</FirstName>\n<LastName>Ameghino</LastName>\n</Person>",
				personElement.toString()
				);
	}
	
	@Test
	public void testComplexAttributedItemToString() {
		Item addressBook = new Item("AddressBook");
		
		Item personA = new Item("Person", addressBook);
		personA.setAttribute("firstName", "Nicolas");
		personA.setAttribute("lastName", "Ameghino");
		personA.setAttribute("phoneNumber", "+541155551234");
		
		Item personB = new Item("Person", addressBook);
		personB.setAttribute("firstName", "Martin");
		personB.setAttribute("lastName", "Ameghino");
		personB.setAttribute("phoneNumber", "+541155556666");		
	}
	
	@Test
	public void simpleParseTest() {
		Item i = new Item("tag1");
		Parser p = new Parser();
		Item parsed = p.parse("<tag1/>");
		assertEquals(i, parsed);
	}
	
	/*
	@Test
	public void valuedParseTest() {
		Item i = new Item("tag1");
		i.setTextValue("value1");
		Parser p = new Parser();
		Item parsed = p.parse("<tag1>value1</tag1>");
		assertEquals(i, parsed);
	}
	
	@Test
	public void nestedTagParseTest() {
		Item root = new Item("tag1");
		Item i = new Item("tag2", root);
		i.setTextValue("value1");		
		Parser p = new Parser();
		Item parsed = p.parse("<tag1><tag2>value1</tag2></tag1>");
		assertEquals(i, parsed);
	}
	*/
	

}
