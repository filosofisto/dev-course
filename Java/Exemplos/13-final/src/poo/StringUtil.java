package poo;

public final class StringUtil {

	private StringUtil() {
		
	}
	
	public static boolean isEmpty(String text) {
		return text == null || text.isEmpty();
	}
	
	public static boolean hasContent(String text) {
		return !isEmpty(text);
	}
	
	public static int asInt(String text) {
		if (hasContent(text)) {
			return Integer.parseInt(text);
		}
		
		return 0;
	}
	
	public static String asString(int value) {
		return String.valueOf(value);
	}
}
