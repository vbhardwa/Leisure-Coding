package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DupSubStrWorking {

	public static void main(String[] args) {
		System.out.println(getSubStr("abcd"));
		System.out.println(getSubStr("sffa"));
		System.out.println(getSubStr("a"));
		System.out.println(getSubStr("aa"));
		System.out.println(getSubStr("ab"));
		System.out.println(getSubStr("sfhsdjfklsflkjsdlfjsldfj"));
	}
	
	public static String getSubStr (String str) {
		char[] charArr = str.toCharArray();
		
		// Get list of substrings
		List<String> substrs = new ArrayList<String>();
		for (int i=0; i<charArr.length; i++) {
			for (int j=i; j<charArr.length; j++) {
				substrs.add(str.substring(i,j+1));
			}
		}
		
		for (String s: substrs) {
			System.out.println(s);
		}
		
		// For each substr, see which of them are unique (no dups)
		// Store the largest unique substr
		int max = 0;
		String uniqueSubStr = str.substring(0,1);
		for (String s: substrs) {
			if (isUnique(s)) {
				if (s.length() > max) {
					max = s.length();
					uniqueSubStr = s;
				}
			}
		}
		
		return uniqueSubStr;
		
	}
	
	// Returns true if str has no repeated characters, false otherwise
	public static boolean isUnique (String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		char[] str = s.toCharArray();
		for (char c : str) {
			Character C = new Character(c);
			if (map.containsKey(C)) {
				return false;
			} else {
				map.put(C, 1);
			}
		}
		return true;
	} 

}
