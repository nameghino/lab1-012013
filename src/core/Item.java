package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item {
	private String tagName;
	private String textValue;
	private Map<String, String> attributes;
	private List<Item> children;
	private Item parent;

	public Item(String tagName, Item parent) {
		this.tagName = tagName;
		attributes = new HashMap<String, String>();
		children = new ArrayList<Item>();
		if (parent != null) {
			parent.addChild(this);
		}
	}

	public Item(String tagName) {
		this(tagName, null);
	}

	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTextValue() {
		return textValue;
	}
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public List<Item> getChildren() {
		return children;
	}
	public void setParent(Item parent) {
		this.parent = parent;
	}
	public Item getParent() {
		return parent;
	}

	public void addChild(Item child) {
		child.setParent(this);
		this.children.add(child); 
	}
	public void setAttribute(String attribute, String value) { this.attributes.put(attribute, value); }

	@Override
	public String toString() {
		String s = "";

		// Start with the <
		s = "<";

		// Append the tag name
		s += tagName;

		// Make attributes string
		int index = 0;
		List<String> attributesList = new ArrayList<String>();
		String attributesString = "";
		for (String attributeName : attributes.keySet()) {
			String as = attributeName + "=\"" + attributes.get(attributeName) + "\"";
			attributesList.add(as);
			attributesString += (index > 0 ? " " : "") + as;
			index++;
		}

		// Append attributes string if exists
		if (attributesString.length() > 0) {
			s += " " + attributesString;
		}

		// Finalize tag if it doesn't have any children
		if (this.children.size() == 0 && textValue == null) {
			s += "/>";
			return s; // Early return, 2.12 AM and lazy
		}

		// Close tag
		s += ">";

		// If the tag has a text value, add it
		if (textValue != null) {
			s += textValue;
		} else {
			// Else, add children if any
			s += "\n";
			for (Item child : children) { s += child.toString() + "\n"; }
		}

		// Add finalization tag
		s += "</" + tagName + ">";

		return s;
	}

}
