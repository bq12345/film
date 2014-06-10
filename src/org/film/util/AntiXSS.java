/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.film.util;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * @author 白强
 * @version 1.0
 */
public class AntiXSS {
	private static String EmptyString = "";

	public static String EncodeHtml(String strInput) {
		if (strInput.length() == 0) {
			return EmptyString;
		}
		StringBuilder builder = new StringBuilder(strInput.length() * 2);
		CharacterIterator it = new StringCharacterIterator(strInput);
		for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
			if ((((ch > '`') && (ch < '{')) || ((ch > '@') && (ch < '[')))
					|| (((ch == ' ') || ((ch > '/') && (ch < ':'))) || (((ch == '.') || (ch == ',')) || ((ch == '-') || (ch == '_'))))) {
				builder.append(ch);
			} else {
				builder.append("&#" + (int) ch + ";");
			}
		}
		return builder.toString();
	}

	public static String EncodeHtmlAttribute(String strInput) {
		if (strInput.length() == 0) {
			return EmptyString;
		}
		StringBuilder builder = new StringBuilder(strInput.length() * 2);
		CharacterIterator it = new StringCharacterIterator(strInput);
		for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
			if ((((ch > '`') && (ch < '{')) || ((ch > '@') && (ch < '[')))
					|| (((ch > '/') && (ch < ':')) || (((ch == '.') || (ch == ',')) || ((ch == '-') || (ch == '_'))))) {
				builder.append(ch);
			} else {
				builder.append("&#" + (int) ch + ";");
			}
		}
		return builder.toString();
	}
}
