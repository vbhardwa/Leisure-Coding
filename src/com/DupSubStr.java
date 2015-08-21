package com;

import java.util.HashMap;

// O(n) solution for longest substring without any duplicates
public class DupSubStr {

	public static void main(String[] args) {
		System.out.println(getDupSubStr("abcd"));
		System.out.println(getDupSubStr("sffa"));
		System.out.println(getDupSubStr("a"));
		System.out.println(getDupSubStr("aa"));
		System.out.println(getDupSubStr("ab"));
		System.out.println(getDupSubStr("sfhsdjfklsflkjsdlfjsldfj")); // bad ass test case
		System.out.println(getDupSubStr("sfsfjklsdajfsdjafkljsadlasdfa"));
		System.out.println(getDupSubStr("GEEKSFORGEEKS"));	
	}
	
	public static String getDupSubStr(String str) {
		char[] charArr = str.toCharArray();
		
		int start = 0, end = 0, longestStart = 0, longestEnd = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < charArr.length; i++) {
			if (!map.containsKey(charArr[i])) {
				map.put(charArr[i], 1);
				end = i;
				if (end-start > longestEnd - longestStart) {
					longestStart = start;
					longestEnd = end;
				}
			} else { // encountered a duplicate in string
				if (end-start > longestEnd - longestStart) {
					longestStart = start;
					longestEnd = end;
				}
				// reset the pointers, clear older hashmap entries
				start = i;
				end   = i;
				map.clear();
				map.put(charArr[i], 1);
			}
		}
		return str.substring(longestStart, longestEnd+1);
	}		
}
