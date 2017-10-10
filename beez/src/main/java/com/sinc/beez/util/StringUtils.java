package com.sinc.beez.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtils {

	public static final String EMPTY = ""; //$NON-NLS-1$
	public static final String NULL = "null"; //$NON-NLS-1$
	public static final char[] WORD_SEPARATORS = {'_', '-', '@', '$', '#', ' '};
	public static final int INDEX_NOT_FOUND = -1;

	
	private StringUtils() {
	}
	
	/**
	 * <p>문자(char)가 단어 구분자('_', '-', '@', '$', '#', ' ')인지 판단한다.</p>
	 * 
	 * @param c 문자(char)
	 * @return 단어 구분자이면 true, 아니면 false를 반환한다.
	 */
	public static boolean isWordSeparator(char c) {
		for (int i = 0; i < WORD_SEPARATORS.length; i++) {
			if (WORD_SEPARATORS[i] == c) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <p>문자(char)가 단어 구분자(wordSeparators)인지 판단한다.</p>
	 * <p>단어 구분자가 <code>null</code>이면 false를 반환한다.</p>
	 * 
	 * @param c 문자(char)
	 * @param wordSeparators 단어 구분자
	 * @return 단어 구분자이면 true, 아니면 false를 반환한다.
	 */
	public static boolean isWordSeparator(char c, char[] wordSeparators) {
		if (wordSeparators == null) {
			return false;
		}
		for (int i = 0; i < wordSeparators.length; i++) {
			if (wordSeparators[i] == c) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <p>문자열(String)을 카멜표기법으로 표현한다.</p>
	 * 
	 * <pre>
	 * StringUtils.camelString("ITEM_CODE", true)  = "ItemCode"
	 * StringUtils.camelString("ITEM_CODE", false) = "itemCode"
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param firstCharacterUppercase 첫문자열을 대문자로 할지 여부
	 * @return 카멜표기법으로 표현환 문자열
	 */
	public static String camelString(String str, boolean firstCharacterUppercase) {
		if (str == null) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		
		boolean nextUpperCase = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (isWordSeparator(c)) {
				if (sb.length() > 0) {
					nextUpperCase = true;
				}
			} else {
				if (nextUpperCase) {
					sb.append(Character.toUpperCase(c));
					nextUpperCase = false;
				} else {
					sb.append(Character.toLowerCase(c));
				}
			}
		}
		
		if (firstCharacterUppercase) {
			sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		}
		return sb.toString();
	}
	
	/**
	 * <p>입력 받은 문자를 반복숫자만큼 붙여서 만든다.</p>
	 * 
	 * <pre>
	 * StringUtils.repeat(null, *)   = null
	 * StringUtils.repeat("", -1)    = ""
	 * StringUtils.repeat("", 2)     = ""
	 * StringUtils.repeat("han", -1) = ""
	 * StringUtils.repeat("han", 0)  = ""
	 * StringUtils.repeat("han", 2)  = "hanhan"
	 * </pre>
	 * 
	 * @param str
	 * @param repeat 반복숫자
	 * @return
	 */
	public static String repeat(String str, int repeat) {
		if (str == null) {
			return null;
		}
		if (repeat < 1) {
			return EMPTY;
		}
		int inputLen = str.length();
		if (inputLen == 0 || repeat == 1) {
			return str;
		}
		int outputLen = inputLen * repeat;
		if (inputLen == 1) {
			char ch = str.charAt(0);
			char[] output = new char[outputLen];
			for (int i = 0; i < outputLen; i++) {
				output[i] = ch;
			}
			return new String(output);
		} else {
			StringBuilder output = new StringBuilder((int) Math.min((outputLen*110L)/100, Integer.MAX_VALUE));
			for (int i = 0; i < repeat; i++) {
				output.append(str);
			}
			return output.toString();
		}
	}
	
	// ----------------------------------------------------------------------
	// 공백/여백문자  검사, 제거, 치환
	// ----------------------------------------------------------------------
	
	/**
	 * <p>문자열(String)의 좌우 여백문자(white space)를 제거한후, 공백("")이거나 <code>null</code>인 검사한다.</p>
	 * 
	 * <pre>
	 * StringUtils.isBlank(null)    = true
	 * StringUtils.isBlank("")      = true
	 * StringUtils.isBlank("   ")   = true
	 * StringUtils.isBlank("han")   = false
	 * StringUtils.isBlank(" han ") = false
	 * </pre> 
	 * 
	 * @param str 문자열
	 * @return
	 */
	public static boolean isBlank(String str) {
		if (str == null) {
			return true;
		}
		int strLen = str.length();
		if (strLen > 0) {
			for (int i = 0; i < strLen; i++) {
				if (Character.isWhitespace(str.charAt(i)) == false) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * <p>문자열(String)의 좌우 여백문자(white space)를 제거한후, 공백("")이 아니거나 <code>null</code>이 아닌지 검사한다.</p>
	 * 
	 * <pre>
	 * StringUtils.isNotBlank(null)    = false
	 * StringUtils.isNotBlank("")      = false
	 * StringUtils.isNotBlank("   ")   = false
	 * StringUtils.isNotBlank("han")   = true
	 * StringUtils.isNotBlank(" han ") = true
	 * </pre> 
	 * 
	 * @param str 문자열
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	/**
	 * <p>문자열(String)이 공백("")이거나 <code>null</code>인 검사한다.</p>
	 * 
	 * <pre>
	 * StringUtils.isEmpty(null)    = true
	 * StringUtils.isEmpty("")      = true
	 * StringUtils.isEmpty("   ")   = false
	 * StringUtils.isEmpty("han")   = false
	 * StringUtils.isEmpty(" han ") = false
	 * </pre>
	 * 
	 * 
	 * @param str 검사할 문자열
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
	/**
	 * <p>문자열(String)이 공백("")이 아니거나 <code>null</code>이 아닌지 검사한다.</p>
	 * 
	 * <pre>
	 * StringUtils.isNotEmpty(null)    = false
	 * StringUtils.isNotEmpty("")      = false
	 * StringUtils.isNotEmpty("   ")   = true
	 * StringUtils.isNotEmpty("han")   = true
	 * StringUtils.isNotEmpty(" han ") = true
	 * </pre>
	 * 
	 * @param str 검사할 문자열
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * <p>문자열(String)의 좌우 여백문자(white space)를 제거한다.</p>
	 * 
	 * <pre>
	 * StringUtils.trim(null)    = null
	 * StringUtils.trim("")      = ""
	 * StringUtils.trim("   ")   = ""
	 * StringUtils.trim("han")   = "han"
	 * StringUtils.trim(" han ") = "han"
	 * </pre>
	 * 
	 * @param str 문자열
	 * @return
	 */
	public static String trim(String str) {
		return str == null ? null : str.trim();
	}
	
	/**
	 * <p>문자열(String)의 좌우 여백문자(white space)를 제거한 후 공백("")이거나 <code>null</code>이면 <code>null</code>을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.trimToNull(null)    = null
	 * StringUtils.trimToNull("")      = null
	 * StringUtils.trimToNull("   ")   = null
	 * StringUtils.trimToNull("han")   = "han"
	 * StringUtils.trimToNull(" han ") = "han"
	 * </pre>
	 *
	 * @param str 문자열
	 * @return
	 */
	public static String trimToNull(String str) {
		return isBlank(str) ? null : trim(str);
	}
	
	/**
	 * <p>문자열(String)의 좌우 여백문자(white space)를 제거한 후 공백("")이거나 <code>null</code>이면 공백("")을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.trimToEmpty(null)    = ""
	 * StringUtils.trimToEmpty("")      = ""
	 * StringUtils.trimToEmpty("   ")   = ""
	 * StringUtils.trimToEmpty("han")   = "han"
	 * StringUtils.trimToEmpty(" han ") = "han"
	 * </pre>
	 *
	 * @param str 문자열
	 * @return
	 */
	public static String trimToEmpty(String str) {
		return isBlank(str) ? EMPTY : trim(str);
	}
	
	/**
	 * <p>문자열(String)이 <code>null</code>이면 기본문자열을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.defaultIfNull(null, "")    = ""
	 * StringUtils.defaultIfNull("", "")      = ""
	 * StringUtils.defaultIfNull("   ", "")   = "   "
	 * StringUtils.defaultIfNull("han", "")   = "han"
	 * StringUtils.defaultIfNull(" han ", "") = " han "
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param defaultStr 기본문자열
	 * @return
	 */
	public static String defaultIfNull(String str, String defaultStr) {
		return str == null ? defaultStr : str;
	}
	
	/**
	 * <p>문자열(String)이 <code>null</code>이면 공백문자열을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.defaultIfNull(null)    = ""
	 * StringUtils.defaultIfNull("")      = ""
	 * StringUtils.defaultIfNull("   ")   = "   "
	 * StringUtils.defaultIfNull("han")   = "han"
	 * StringUtils.defaultIfNull(" han ") = " han "
	 * </pre>
	 * 
	 * @param str 문자열
	 * @return
	 */
	public static String defaultIfNull(String str) {
		return defaultIfNull(str, EMPTY);
	}
	
	/**
	 * <p>문자열(String)의 좌우 여백문자(white space)를 제거한후, 공백("")이거나 <code>null</code>이면, 기본문자열을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.defaultIfBlank(null, "")    = ""
	 * StringUtils.defaultIfBlank("", "")      = ""
	 * StringUtils.defaultIfBlank("   ", "")   = ""
	 * StringUtils.defaultIfBlank("han", "")   = "han"
	 * StringUtils.defaultIfBlank(" han ", "") = " han "
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param defaultStr 기본문자열
	 * @return
	 */
	public static String defaultIfBlank(String str, String defaultStr) {
		return isBlank(str) ? defaultStr : str;
	}
	
	/**
	 * <p>문자열(String)의 좌우 여백문자(white space)를 제거한후, 공백("")이거나 <code>null</code>이면, 공백문자열을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.defaultIfBlank(null)    = ""
	 * StringUtils.defaultIfBlank("")      = ""
	 * StringUtils.defaultIfBlank("   ")   = ""
	 * StringUtils.defaultIfBlank("han")   = "han"
	 * StringUtils.defaultIfBlank(" han ") = " han "
	 * </pre>
	 * 
	 * @param str 문자열
	 * @return
	 */
	public static String defaultIfBlank(String str) {
		return defaultIfBlank(str, EMPTY);
	}
	
	
	// ----------------------------------------------------------------------
	// 문자열 비교
	// ----------------------------------------------------------------------
	/**
	 * <p>두 문자열(String)이 일치하면 <code>true</code>을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.equals(null, null)   = true
	 * StringUtils.equals(null, "")     = false
	 * StringUtils.equals("", null)     = false
	 * StringUtils.equals(null, "han")  = false
	 * StringUtils.equals("han", null)  = false
	 * StringUtils.equals("han", "han") = true
	 * StringUtils.equals("han", "HAN") = false
	 * </pre>
	 * 
	 * @see java.lang.String#equals(Object)
	 * @param str1 첫번째 문자열
	 * @param str2 두번째 문자열
	 * @return 문자열(String)이 일치하면 <code>true</code>
	 */
	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}
	
	/**
	 * <p>대소문자를 무시한, 두 문자열(String)이 일치하면 <code>true</code>을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.equalsIgnoreCase(null, null)   = true
	 * StringUtils.equalsIgnoreCase(null, "")     = false
	 * StringUtils.equalsIgnoreCase("", null)     = false
	 * StringUtils.equalsIgnoreCase(null, "han")  = false
	 * StringUtils.equalsIgnoreCase("han", null)  = false
	 * StringUtils.equalsIgnoreCase("han", "han") = true
	 * StringUtils.equalsIgnoreCase("han", "HAN") = true
	 * </pre>
	 * 
	 * @see java.lang.String#equalsIgnoreCase(String)
	 * @param str1 첫번째 문자열
	 * @param str2 두번째 문자열
	 * @return 대소문자를 무시한 문자열(String)이 일치하면 <code>true</code>
	 */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
	}
	
	/**
	 * <p>문자열이 접두사로 시작하는지를 판단한다.</p>
	 * 
	 * <pre>
	 * StringUtils.startsWith(null, *)    = false
	 * StringUtils.startsWith(*, null)    = false
	 * StringUtils.startsWith("han", "h") = true
	 * StringUtils.startsWith("han", "a") = false
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param prefix 접두사
	 * @return
	 */
	public static boolean startsWith(String str, String prefix) {
		if (str == null || prefix == null) {
			return false;
		}
		return str.startsWith(prefix);
	}
	
	/**
	 * <p>문자열 offset 위치부터 접두사로 시작하는지를 판단한다.</p>
	 * 
	 * <pre>
	 * StringUtils.startsWith(null, *, 0)    = false
	 * StringUtils.startsWith(*, null, 0)    = false
	 * StringUtils.startsWith("han", "h", 0) = true
	 * StringUtils.startsWith("han", "a", 0) = false
	 * StringUtils.startsWith("han", "a", 1) = true
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param prefix 접두사
	 * @param offset 비교 시작 위치
	 * @return
	 */
	public static boolean startsWith(String str, String prefix, int offset) {
		if (str == null || prefix == null) {
			return false;
		}
		return str.startsWith(prefix, offset);
	}
	
	/**
	 * <p>문자열이 접미사로 끝나는지를 판단한다.</p>
	 * 
	 * <pre>
	 * StringUtils.endsWith(null, *)    = false
	 * StringUtils.endsWith(*, null)    = false
	 * StringUtils.endsWith("han", "h") = false
	 * StringUtils.endsWith("han", "n") = true
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param prefix 접두사
	 * @return
	 */
	public static boolean endsWith(String str, String suffix) {
		if (str == null || suffix == null) {
			return false;
		}
		return str.endsWith(suffix);
	}

	/**
	 * <p>문자열(String)에 검색문자열(String)이 포함되어 있는지 검사한다.</p>
	 * 
	 * <pre>
	 * StringUtils.contains(null, *)    = false
	 * StringUtils.contains(*, null)    = false
	 * StringUtils.contains("han", "")  = true
	 * StringUtils.contains("han", "h") = true
	 * StringUtils.contains("han", "H") = false
	 * </pre>
	 * 
	 * @see java.lang.String#indexOf(String)
	 * @param str 문자열
	 * @param searchStr 검색문자열
	 * @return 문자열(String)에 검색 문자열이 포함되어 있을때 <code>true</code>,
	 *  문자열(String)에 검색 문자열이 포함되어 있지 않을때나, 문자열 또는 검색문자열이 <code>null</code>일때 <code>false</code>
	 */
	public static boolean contains(String str, String searchStr) {
		if (str == null || searchStr == null) {
			return false;
		}
		return str.indexOf(searchStr) > INDEX_NOT_FOUND;
	}
	
	
	
	// ----------------------------------------------------------------------
	// 대/소문자 변환
	// ----------------------------------------------------------------------
	/**
	 * <p>문자열(String)을 대문자로 변환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.toUpperCase(null)  = null
	 * StringUtils.toUpperCase("han") = "HAN"
	 * StringUtils.toUpperCase("hAn") = "HAN"
	 * </pre>
	 * 
	 * @param str 문자열
	 * @return 대문자로 변환한 문자열
	 */
	public static String toUpperCase(String str) {
		if (str == null) {
			return null;
		}
		return str.toUpperCase();
	}
	
	/**
	 * <p>시작 인덱스부터 종료 인덱스까지 대문자로 변환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.toUpperCase(null, *, *)  = null
	 * StringUtils.toUpperCase("han", 0, 1) = "Han"
	 * StringUtils.toUpperCase("han", 0, 2) = "HAn"
	 * StringUtils.toUpperCase("han", 0, 3) = "HAN"
	 * </pre>
	 * 
	 * @param str
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public static String toUpperCase(String str, int beginIndex, int endIndex) {
		if (str == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		if (beginIndex < 0) {
			beginIndex = 0;
		}
		if (endIndex > str.length()) {
			endIndex = str.length();
		}
		if (beginIndex > 0) {
			sb.append(str.substring(0, beginIndex));
		}
		sb.append(str.substring(beginIndex, endIndex).toUpperCase());
		if (endIndex < str.length()) {
			sb.append(str.substring(endIndex));	
		}
		return sb.toString();
	}
	
	/**
	 * <p>문자열(String)을 소문자로 변환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.toLowerCase(null)  = null
	 * StringUtils.toLowerCase("han") = "han"
	 * StringUtils.toLowerCase("hAn") = "han"
	 * </pre>
	 * 
	 * @param str 문자열
	 * @return 소문자로 변환한 문자열
	 */
	public static String toLowerCase(String str) {
		if (str == null) {
			return null;
		}
		return str.toLowerCase();
	}
	
	/**
	 * <p>시작 인덱스부터 종료 인덱스까지 소문자로 변환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.toLowerCase(null, *, *)  = null
	 * StringUtils.toLowerCase("HAN", 0, 1) = "hAN"
	 * StringUtils.toLowerCase("HAN", 0, 2) = "haN"
	 * StringUtils.toLowerCase("HAN", 0, 3) = "han"
	 * </pre>
	 * 
	 * @param str
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public static String toLowerCase(String str, int beginIndex, int endIndex) {
		if (str == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		if (beginIndex < 0) {
			beginIndex = 0;
		}
		if (endIndex > str.length()) {
			endIndex = str.length();
		}
		if (beginIndex > 0) {
			sb.append(str.substring(0, beginIndex));
		}
		sb.append(str.substring(beginIndex, endIndex).toLowerCase());
		if (endIndex < str.length()) {
			sb.append(str.substring(endIndex));	
		}
		return sb.toString();
	}
	
	/**
	 * <p>대문자는 소문자로 변환하고 소문자는 대문자로 변환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.swapCase(null)  = null
	 * StringUtils.swapCase("Han") = "hAN"
	 * StringUtils.swapCase("hAn") = "HaN"
	 * </pre>
	 * 
	 * @param str 문자열
	 * @return
	 */
	public static String swapCase(String str) {
		if (str == null) {
			return null;
		}
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLowerCase(charArray[i])) {
				charArray[i] = Character.toUpperCase(charArray[i]);
			} else {
				charArray[i] = Character.toLowerCase(charArray[i]);
			}
		}
		
		return new String(charArray);
	}

	/**
	 * 문자열(String)의 첫번째 문자를 대문자로 변환한다.
	 * 
	 * <pre>
	 * StringUtils.capitalize(null)  = null
	 * StringUtils.capitalize("Han") = "Han"
	 * StringUtils.capitalize("han") = "Han"
	 * </pre>
	 * 
	 * @param str 문자열
	 * @return 첫번째 문자를 대문자로 변환한 문자열
	 */
	public static String capitalize(String str) {
		if (str == null) {
			return null;
		}
		char[] charArray = str.toCharArray();
		if (charArray.length > 0) {
			charArray[0] = Character.toUpperCase(charArray[0]);
		}
		return new String(charArray);
	}
	
	/**
	 * 문자열(String)의 첫번째 문자를 소문자로 변환한다.
	 * 
	 * <pre>
	 * StringUtils.uncapitalize(null)  = null
	 * StringUtils.uncapitalize("han") = "han"
	 * StringUtils.uncapitalize("HAN") = "hAN"
	 * </pre>
	 * 
	 * @param str 문자열
	 * @return 첫번째 문자를 대문자로 변환한 문자열
	 */
	public static String uncapitalize(String str) {
		if (str == null) {
			return null;
		}
		char[] charArray = str.toCharArray();
		if (charArray.length > 0) {
			charArray[0] = Character.toLowerCase(charArray[0]);
		}
		return new String(charArray);
	}
	
	// ----------------------------------------------------------------------
	// 문자열 배열 결합/분리
	// ----------------------------------------------------------------------
	/**
	 * <p>문자열 배열을 하나의 문자열로 결합시킨다.</p>
	 * <p>배열의 문자열 중에 <code>null</code>과 공백("")은 무시한다.</p>
	 * 
	 * <pre>
	 * StringUtils.compose(null, *)               = ""
	 * StringUtils.compose(["h", "a", "n"], ".")  = "h.a.n"
	 * StringUtils.compose([null, "a", "n"], ".") = "a.n"
	 * StringUtils.compose(["", "a", "n"], ".")   = "a.n"
	 * StringUtils.compose(["h", "", "n"], ".")   = "h.n"
	 * StringUtils.compose(["  ", "a", "n"], ".") = "  .a.n"
	 * </pre>
	 * 
	 * @param strArray 문자열 배열
	 * @param separator 구분자
	 * @return 구분자로 결합한 문자열
	 */
	public static String compose(String[] strArray, char separator) {
		StringBuilder sb = new StringBuilder();
		if (strArray != null) {
			for (int i = 0; i < strArray.length; i++) {
				if (StringUtils.isEmpty(strArray[i])) {
					sb.append(EMPTY);
				} else {
					if (sb.length() > 0) {
						sb.append(separator);
					}
					sb.append(strArray[i]);
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * <p>문자열 배열을 하나의 문자열로 결합시킨다.</p>
	 * <p>배열의 문자열 중에 <code>null</code>과 공백("")은 무시한다.</p>
	 * 
	 * <pre>
	 * StringUtils.compose(null, *)               = ""
	 * StringUtils.compose(["h", "a", "n"], ".")  = "h.a.n"
	 * StringUtils.compose([null, "a", "n"], ".") = "a.n"
	 * StringUtils.compose(["", "a", "n"], ".")   = "a.n"
	 * StringUtils.compose(["h", "", "n"], ".")   = "h.n"
	 * StringUtils.compose(["  ", "a", "n"], ".") = "  .a.n"
	 * </pre>
	 * 
	 * @param strArray 문자열 배열
	 * @param separator 구분자
	 * @return 구분자로 결합한 문자열
	 */
	public static String compose(String[] strArray, String separator) {
		StringBuilder sb = new StringBuilder();
		if (strArray != null) {
			for (int i = 0; i < strArray.length; i++) {
				if (StringUtils.isEmpty(strArray[i])) {
					sb.append(EMPTY);
				} else {
					if (sb.length() > 0) {
						sb.append(separator);
					}
					sb.append(strArray[i]);
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * <p>문자열 배열을 하나의 문자열로 결합시킨다.</p>
	 * <p>배열의 문자열 중에 <code>null</code>과 공백("")도 포함한다.</p>
	 * 
	 * <pre>
	 * StringUtils.join(null, *)               = ""
	 * StringUtils.join(["h", "a", "n"], '-')  = "h-a-n"
	 * StringUtils.join([null, "a", "n"], '-') = "-a-n"
	 * StringUtils.join(["", "a", "n"], '-')   = "-a-n"
	 * StringUtils.join(["h", "", "n"], '-')   = "h--n"
	 * StringUtils.join(["  ", "a", "n"], '-') = "  -a-n"
	 * </pre>
	 * 
	 * @param strArray 문자열 배열
	 * @param separator 구분자
	 * @return 구분자로 결합한 문자열
	 */
	public static String join(String[] strArray, char separator) {
		StringBuilder sb = new StringBuilder();
		if (strArray != null) {
			boolean isFirst = true;
			for (int i = 0; i < strArray.length; i++) {
				if (isFirst) {
					isFirst = false;
				} else {
					sb.append(separator);
				}
				if (StringUtils.isEmpty(strArray[i])) {
					sb.append(EMPTY);
				} else {
					sb.append(strArray[i]);
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * <p>문자열 배열을 하나의 문자열로 결합시킨다.</p>
	 * <p>배열의 문자열 중에 <code>null</code>과 공백("")도 포함한다.</p>
	 * 
	 * <pre>
	 * StringUtils.join(null, *)               = ""
	 * StringUtils.join(["h", "a", "n"], "-")  = "h-a-n"
	 * StringUtils.join([null, "a", "n"], "-") = "-a-n"
	 * StringUtils.join(["", "a", "n"], "-")   = "-a-n"
	 * StringUtils.join(["h", "", "n"], "-")   = "h--n"
	 * StringUtils.join(["  ", "a", "n"], "-") = "  -a-n"
	 * </pre>
	 * 
	 * @param strArray 문자열 배열
	 * @param separator 구분자
	 * @return 구분자로 결합한 문자열
	 */
	public static String join(String[] strArray, String separator) {
		StringBuilder sb = new StringBuilder();
		if (strArray != null) {
			boolean isFirst = true;
			for (int i = 0; i < strArray.length; i++) {
				if (isFirst) {
					isFirst = false;
				} else {
					sb.append(separator);
				}
				if (StringUtils.isEmpty(strArray[i])) {
					sb.append(EMPTY);
				} else {
					sb.append(strArray[i]);
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * <p>문자열을 구분자로 나누어서, 문자열 배열로 만든다.</p>
	 * <p>배열의 문자열 중에 <code>null</code>과 공백("")도 포함한다.</p>
	 * 
	 * <pre>
	 * StringUtils.split("h-a-n", '-') = ["h", "a", "n"]
	 * StringUtils.split("h--n", '-')  = ["h", "", "n"]
	 * StringUtils.split(null, *)      = null
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param separator 구분자
	 * @return 구분자로 나누어진 문자열 배열
	 */
	public static String[] split(String str, char separator) {
		return split(str, new String(new char[]{separator}));
	}
	
	/**
	 * <p>문자열을 구분자로 나누어서, 문자열 배열로 만든다.</p>
	 * <p>배열의 문자열 중에 <code>null</code>과 공백("")도 포함한다.</p>
	 * 
	 * <pre>
	 * StringUtils.split("h-a-n", "-") = ["h", "a", "n"]
	 * StringUtils.split("h--n", "-")  = ["h", "", "n"]
	 * StringUtils.split(null, *)      = null
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param separator 구분자
	 * @return 구분자로 나누어진 문자열 배열
	 */
	public static String[] split(String str, String separator) {
		if (str == null) {
			return null;
		}
		StrTokenizer tokenizer = new StrTokenizer(str, separator);
		return tokenizer.toArray();
	}
	
	// ----------------------------------------------------------------------
	// 문자열 자르기
	// ----------------------------------------------------------------------
	/**
	 * <p>문자열(String)을 해당 길이(<code>length</code>) 만큼, 왼쪽부터 자른다.</p>
	 * 
	 * <pre>
	 * StringUtils.left(null, *)    = null
	 * StringUtils.left(*, -length) = ""
	 * StringUtils.left("", *)      = *
	 * StringUtils.left("han", 0)   = ""
	 * StringUtils.left("han", 1)   = "h"
	 * StringUtils.left("han", 11)  = "han"
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param length 길이
	 * @return
	 */
	public static String left(String str, int length) {
		if (str == null) {
			return null;
		}
		if (length < 0) {
			return EMPTY;
		}
		if (str.length() <= length) {
			return str;
		}
		return str.substring(0, length);
	}
	
	/**
	 * <p>문자열(String)을 해당 길이(<code>length</code>) 만큼, 오른쪽부터 자른다.</p>
	 * 
	 * <pre>
	 * StringUtils.right(null, *)    = null
	 * StringUtils.right(*, -length) = ""
	 * StringUtils.right("", *)      = *
	 * StringUtils.right("han", 0)   = ""
	 * StringUtils.right("han", 1)   = "n"
	 * StringUtils.right("han", 11)  = "han"
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param length 길이
	 * @return
	 */
	public static String right(String str, int length) {
		if (str == null) {
			return null;
		}
		if (length < 0) {
			return EMPTY;
		}
		if (str.length() <= length) {
			return str;
		}
		return str.substring(str.length() - length);
	}
	
	/**
	 * <p>문자열(String)을 시작 위치(<code>beginIndex</code>)부터 길이( <code>length</code>) 만큼 자른다.</p>
	 * 
	 * <p>시작 위치(<code>beginIndex</code>)가 음수일 경우는 0으로 자동 변환된다.</p>
	 * 
	 * <pre>
	 * StringUtils.mid(null, *, *)    = null
	 * StringUtils.mid(*, *, -length) = ""
	 * StringUtils.mid("han", 0, 1)   = "h"
	 * StringUtils.mid("han", 0, 11)  = "han"
	 * StringUtils.mid("han", 2, 3)   = "n"
	 * StringUtils.mid("han", -2, 3)  = "han"
	 * </pre> 
	 * 
	 * @param str 문자열
	 * @param beginIndex 위치(음수일 경우는 0으로 자동 변환된다.)
	 * @param length 길이
	 * @return
	 */
	public static String mid(String str, int beginIndex, int length) {
		if (str == null) {
			return null;
		}
		if (length < 0 || beginIndex > str.length()) {
			return EMPTY;
		}
		if (beginIndex < 0) {
			beginIndex = 0;
		}
		if (str.length() <= (beginIndex + length)) {
			return str.substring(beginIndex);
		}
		return str.substring(beginIndex, beginIndex + length);
	}
	
	/**
	 * <p>시작 인덱스부터 문자열을 자는다.</p>
	 * <p>시작 인덱스가 0보다 작거나, 문자열의 총길이보다 크면 공백("")을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.substring(null, *)    = null
	 * StringUtils.substring("", *)      = ""
	 * StringUtils.substring("han", 1)   = "an"
	 * StringUtils.substring("han", 615) = ""
	 * StringUtils.substring("han", -1)  = ""
	 * </pre> 
	 * 
	 * @param str
	 * @param beginIndex 시작 인덱스(0부터 시작)
	 * @return
	 */
	public static String substring(String str, int beginIndex) {
		if (str == null){
			return null;
		}
		
		if (beginIndex < 0) {
			return EMPTY;
		}
		
		if (beginIndex > str.length()) {
			return EMPTY;
		}
		
		return str.substring(beginIndex);
	}


	/**
	 * <p>시작 인덱스부터 끝 인덱스까지 문자열을 자는다.</p>
	 * <p>시작 인덱스또는 끝 인덱스가  0보다 작으면 공백("")을 반환한다.</p>
	 * 
	 * <pre>
	 * StringUtils.substring(null, *, *)    = null
	 * StringUtils.substring("", *, *)      = ""
	 * StringUtils.substring("han", 1, 2)   = "a"
	 * StringUtils.substring("han", 1, 3)   = "an"
	 * StringUtils.substring("han", 1, 615) = "an"
	 * StringUtils.substring("han", -1, *)  = ""
	 * StringUtils.substring("han", *, -1)  = ""
	 * </pre> 
	 * 
	 * @param str
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public static String substring(String str, int beginIndex, int endIndex) {
		if (str == null){
			return null;
		}
		
		if (beginIndex < 0 || endIndex < 0) {
			return EMPTY;
		}
		
		if (endIndex > str.length()) {
			endIndex = str.length();
		}
		
		if (beginIndex > endIndex || beginIndex > str.length()) {
			return EMPTY;
		}
		
		return str.substring(beginIndex, endIndex);
	}
	
	
	/**
	 * <p>처음 발견한 구분자의 위치까지 문자열을 자른다.</p>
	 * 
	 * <pre>
	 * StringUtils.substringBefore(null, *)       = null
	 * StringUtils.substringBefore("", *)         = ""
	 * StringUtils.substringBefore("han", null)   = "han"
	 * StringUtils.substringBefore("han", "")     = ""
	 * StringUtils.substringBefore("hanhan", "a") = "h"
	 * StringUtils.substringBefore("hanhan", "g") = "hanhan"
	 * </pre> 
	 * 
	 * @param str 문자열
	 * @param separator 구분자
	 * @return
	 */
	public static String substringBefore(String str, String separator) {
		if (isEmpty(str) || separator == null) {
			return str;
		}
        if (separator.length() == 0) {
            return EMPTY;
        }
		int endIndex = str.indexOf(separator);
		if (endIndex == INDEX_NOT_FOUND) {
			return str;
		}
		return str.substring(0, endIndex);
	}
	
	
	/**
	 * <p>마지막으로 발견한 구분자의 위치까지 문자열을 자른다.</p>
	 * 
	 * <pre>
	 * StringUtils.substringBeforeLast(null, *)       = null
	 * StringUtils.substringBeforeLast("", *)         = ""
	 * StringUtils.substringBeforeLast("han", null)   = "han"
	 * StringUtils.substringBeforeLast("han", "")     = "han"
	 * StringUtils.substringBeforeLast("hanhan", "a") = "hanh"
	 * StringUtils.substringBeforeLast("hanhan", "g") = "hanhan"
	 * </pre> 
	 * 
	 * @param str 문자열
	 * @param separator 구분자
	 * @return
	 */
	public static String substringBeforeLast(String str, String separator) {
		if (isEmpty(str) || isEmpty(separator)) {
			return str;
		}
		int endIndex = str.lastIndexOf(separator);
		if (endIndex == INDEX_NOT_FOUND) {
			return str;
		}
		return str.substring(0, endIndex);
	}

	
	/**
	 * <p>처음 발견한 구분자의 위치 다음부터 문자열을 자른다.</p>
	 * 
	 * <pre>
	 * StringUtils.substringAfter(null, *)       = null
	 * StringUtils.substringAfter("", *)         = ""
	 * StringUtils.substringAfter("han", null)   = ""
	 * StringUtils.substringAfter("han", "")     = "han"
	 * StringUtils.substringAfter("hanhan", "a") = "nhan"
	 * StringUtils.substringAfter("hanhan", "g") = ""
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param separator 구분자
	 * @return
	 */
	public static String substringAfter(String str, String separator) {
		if (isEmpty(str)) {
			return str;
		}
		if (separator == null) {
			return EMPTY;
		}
		int beginIndex = str.indexOf(separator);
		if (beginIndex == INDEX_NOT_FOUND) {
			return EMPTY;
		}
		beginIndex = beginIndex + separator.length();
		if (beginIndex == str.length()) {
			return EMPTY;
		}
		return str.substring(beginIndex);
	}
	
	/**
	 * <p>마지막으로 발견한 구분자의 위치 다음부터 문자열을 자른다.</p>
	 * 
	 * <pre>
	 * StringUtils.substringAfterLast(null, *)       = null
	 * StringUtils.substringAfterLast("", *)         = ""
	 * StringUtils.substringAfterLast("han", null)   = ""
	 * StringUtils.substringAfterLast("han",     "") = ""
	 * StringUtils.substringAfterLast("hanhan", "a") = "n"
	 * StringUtils.substringAfterLast("hanhan", "g") = ""
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param separator 구분자
	 * @return
	 */
	public static String substringAfterLast(String str, String separator) {
		if (isEmpty(str)) {
			return str;
		}
		if (isEmpty(separator)) {
			return EMPTY;
		}
		int beginIndex = str.lastIndexOf(separator);
		if (beginIndex == INDEX_NOT_FOUND) {
			return EMPTY;
		}
		beginIndex = beginIndex + separator.length();
		if (beginIndex == str.length()) {
			return EMPTY;
		}
		return str.substring(beginIndex);
	}
	
	/**
	 * <p>시작 문자부터 끝 문자열까지 자른다.</p>
	 * 
	 * <pre>
	 * StringUtils.substringBetween(null, *, *)       = null
	 * StringUtils.substringBetween(*, null, *)       = null
	 * StringUtils.substringBetween(*, *, null)       = null
	 * StringUtils.substringBetween("h<a>n", "<", ">") = "a"
	 * StringUtils.substringBetween("h<a><b>n", "<", ">") = "a"
	 * </pre>
	 * 
	 * @param str 문자열
	 * @param separator 구분자
	 * @return
	 * @since 1.1
	 */
    public static String substringBetween(String str, String open, String close) {
		if (str == null || open == null || close == null) {
			return null;
		}
		
		int start = str.indexOf(open);
		if (start != INDEX_NOT_FOUND) {
			int end = str.indexOf(close, start + open.length());
			if (end != INDEX_NOT_FOUND) {
				return str.substring(start + open.length(), end);
			} else {
				// 끝이 없으면 null이 좋을까, 끝까지가 좋을까...
			}
		}
		return null;
	}
    
    /**
     * <p>입력한 문자열을 한줄의 최대 길이만큼, 여러 줄로 나누어 반환한다.</p>
     * <p>공백(" ")을 기준으로 줄 바꿈을 시도한다.</p>
     * 
     * @param str
     * @param maxLineLength 한줄의 최대 길이
     * @return
     */
    public static List<String> wrap(String str, int maxLineLength) {
    	if (str == null) {
    		return null;
    	}
    	List<String> lines = new ArrayList<String>();
        if (str.length() <= maxLineLength || str.indexOf(' ') == INDEX_NOT_FOUND) {
        	// 전체 길이가 최대 길이보다 짧거나, 구분할수 있는 조건이 안되면 그대로 반환한다.
        	lines.add(str);
            return lines;
        }
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenzier = new StringTokenizer(str, " ");
        sb.append(tokenzier.nextToken());
        while (tokenzier.hasMoreTokens()) {
            String token = tokenzier.nextToken();
            if ( (sb.length() + token.length() + 1) > maxLineLength) {
                lines.add(sb.toString());
                sb.setLength(0);
                sb.append(token);
            } else {
                sb.append(" ");
                sb.append(token);
            }
        }

        if (sb.toString().trim().length() > 0) {
            lines.add(sb.toString());
        }
        return lines;
    }
	
	/**
	 * <p>문자열이 해당 길이보다 크면, 자른 후 줄임말을 붙여준다.</p>
	 * <p>길이는 기본문자들(영어/숫자등)이 1으로, 다국어(한글등)이면 2로 계산한다.</p>
	 * 
	 * <pre>
	 * StringUtils.curtail(null, *, *) = null
	 * StringUtils.curtail("abcdefghijklmnopqr", 10, null) = "abcdefghij"
	 * StringUtils.curtail("abcdefghijklmnopqr", 10, "..") = "abcdefgh.."
	 * StringUtils.curtail("한글을 사랑합시다.", 10, null)   = "한글을 사랑"
	 * StringUtils.curtail("한글을 사랑합시다.", 10, "..")   = "한글을 사.."
	 * </pre>
	 * 
	 * 
	 * @param str 문자열
	 * @param size 길이(byte 길이)
	 * @param tail 줄임말
	 * @return
	 */
	public static String curtail(String str, int size, String tail) {
		if (str == null) {
			return null;
		}
		int strLen = str.length();
		int tailLen = (tail != null) ? tail.length() : 0;
		int maxLen = size - tailLen;
		int curLen = 0;
		int index = 0;
		for (; index < strLen && curLen < maxLen; index++) {
			if (Character.getType(str.charAt(index)) == Character.OTHER_LETTER) {
				curLen++;
			}
			curLen++;
		}
		
		if (index == strLen) {
			return str;
		} else {
			StringBuilder result = new StringBuilder();
			result.append(str.substring(0, index));
			if (tail != null) {
				result.append(tail);	
			}
			return result.toString();
		}
	}
	
	// ----------------------------------------------------------------------
	// 패딩
	// ----------------------------------------------------------------------
	/**
	 * <p>왼쪽부터 크기만큼 패딩문자로 채운다.</p>
	 * 
	 * <pre>
	 * StringUtils.leftPad("han", 5, " ")    = "  han"
	 * StringUtils.leftPad("han", 5, "123")  = "12han"
	 * StringUtils.leftPad("han", 10, "123") = "1231231han"
	 * StringUtils.leftPad("han", -1, " ")   = "han"
	 * </pre>
	 * 
	 * @param str
	 * @param size 크기
	 * @param padStr 패딩문자
	 * @return
	 */
	public static String leftPad(String str, int size, String padStr) {
		if (str == null) {
			return null;
		}
		if (isEmpty(padStr)) {
			padStr = " "; //$NON-NLS-1$
		}
		int strLen = str.length();
		int padStrLen = padStr.length();
		int padLen = size - strLen;
		if (padLen <= 0) {
			// 패딩할 필요가 없음
			return str;
		}
		
		StringBuilder result = new StringBuilder();
		if (padLen == padStrLen) {
			result.append(padStr);
			result.append(str);
		} else if (padLen < padStrLen) {
			result.append(padStr.substring(0, padLen));
			result.append(str);
		} else {
			char[] padding = padStr.toCharArray();
			for (int i = 0; i < padLen; i++) {
				result.append(padding[ i % padStrLen]);
			}
			result.append(str);
		}
		return result.toString();
	}
	
	/**
	 * <p>오른쪽부터 크기만큼 패딩문자로 채운다.</p>
	 * 
	 * <pre>
	 * StringUtils.rightPad("han", 5, " ")    = "han  "
	 * StringUtils.rightPad("han", 5, "123")  = "han12"
	 * StringUtils.rightPad("han", 10, "123") = "han1231231"
	 * StringUtils.rightPad("han", -1, " ")   = "han"
	 * </pre>
	 * 
	 * @param str
	 * @param size 크기
	 * @param padStr 패딩문자
	 * @return
	 */
	public static String rightPad(String str, int size, String padStr) {
		if (str == null) {
			return null;
		}
		if (isEmpty(padStr)) {
			padStr = " "; //$NON-NLS-1$
		}
		int strLen = str.length();
		int padStrLen = padStr.length();
		int padLen = size - strLen;
		if (padLen <= 0) {
			// 패딩할 필요가 없음
			return str;
		}
		
		StringBuilder result = new StringBuilder();
		if (padLen == padStrLen) {
			result.append(str);
			result.append(padStr);
		} else if (padLen < padStrLen) {
			result.append(str);
			result.append(padStr.substring(0, padLen));
		} else {
			result.append(str);
			char[] padding = padStr.toCharArray();
			for (int i = 0; i < padLen; i++) {
				result.append(padding[ i % padStrLen]);
			}
		}
		return result.toString();
	}
}
