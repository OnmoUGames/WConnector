package com.onmo.wgames.sdk;

/**
 * Created by Srini on 14/02/2018.
 * Comment
 */

public class Utils {

	public static boolean isStringEmpty(String str) {
		return (str == null || str.trim().length() == 0
				|| str.trim().equalsIgnoreCase("[]"));
	}

}
