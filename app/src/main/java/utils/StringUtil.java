package utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class StringUtil {
	private static final char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f', };

	public static String asHex(byte hash[]) {
		char buf[] = new char[hash.length * 2];
		for (int i = 0, x = 0; i < hash.length; i++) {
			buf[x++] = HEX_CHARS[(hash[i] >>> 4) & 0xf];
			buf[x++] = HEX_CHARS[hash[i] & 0xf];
		}
		return new String(buf);
	}

	/**
	 * Return the string content from an InputStream
	 * 
	 * @param is
	 * @return stringContent
	 */
	public static String convertStreamToString(InputStream is) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	/**
	 * Convert JSONArray to comma separated string.
	 * 
	 * @param jsonArry
	 * @return commaSeparatedString
	 */
	public static String getCommaStringFromArray(JSONArray jsonArry) throws JSONException {
		int lenghtTms = jsonArry.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lenghtTms; i++) {
			if (sb.length() > 0) {
				sb.append(',');
			}
			sb.append(jsonArry.getString(i));
		}
		return sb.toString();
	}
	
	/**
	 * Convert a List of Strings to comma separated single String
	 * @param list
	 */
	public static String convertStringListToCommaSeparatedString(List<String> list){
		if(list == null || list.size() < 1)return "";
		int max = list.size();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < max; i++) {
			sb.append(list.get(i)).append(", ");
		}
		
		return sb.substring(0, sb.length() -2);
	}

    /**
     * Determines whether the provided string is null or empty.
     * @param string
     * @return true if it is null or empty.
     */
    public static boolean isNullOrEmpty(String string){
        if(string == null || string.trim().length() <= 0)
            return true;
        return false;
    }

    /**
     * Iterative version of {@linkplain #isNullOrEmpty(String)}.
     * @param strings
     * @return true if at least one of the strings is null or empty.
     */
    public static boolean isNullOrEmpty(String ...strings) {
        if(strings == null || strings.length <= 0)
            return true;
        for (String string : strings) {
            if(isNullOrEmpty(string))
                return true;
        }
        return false;
    }
}
