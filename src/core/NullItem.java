package core;

public class NullItem extends Item {

	private static NullItem instance;
	
	public static NullItem getInstance() {
		if (instance == null) {
			instance = new NullItem("NULL ITEM");
		}
		return instance;
	}
	
	private NullItem(String tagName) {
		super(tagName);
	}

}
