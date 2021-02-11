package com.tt.util;

import org.apache.commons.lang3.math.NumberUtils;

public class StringUtil {
	public static String getNumberFromString(String Inputmsg,int n) {
		{
			String output=Inputmsg;
			int currInt=0;
			String[] words=Inputmsg.split(" ");
			for(int i=0;i<words.length;i++) {
				if(NumberUtils.isNumber(words[i])) {
					currInt++;
					if(currInt==n) {
						output=words[i];
						break;
					}
					

				}
				
			}
			
			return output;
		}
	}
	public static String getStringBetween(String input, String before, String after)
	{
		String output="";
		int StartIndex = input.indexOf(before)+before.length();
		int EndIndex = input.indexOf(after);
		/*int temp=0;
		if(StartIndex>EndIndex)
		{
			EndIndex = EndIndex + after.length();
			temp=StartIndex;
			StartIndex=EndIndex;
			EndIndex=temp;
		}
		else {
			StartIndex = StartIndex + before.length();
		}*/
		System.out.println("Before Index:"+StartIndex);
		System.out.println("After Index"+EndIndex);
		output=input.substring(StartIndex, EndIndex).trim();
		return output;
	}
	public static String getRandomString(int size) {
		String output="";
		
		String random="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456946844646";
		int len=random.length();
		for(int i=0;i<size;i++) {
			int index=(int) (Math.random()*len);
			output=output+random.charAt(index);   //charAt() method returns the character at the specified index in a string.
			
		}
		
		return output;
	}
	public static void main(String [] args) {
		System.out.println("Number Extracted is: "+StringUtil.getNumberFromString("Your Order number is 7865"
				+ "  and has 4 items in total",2));
		
		System.out.println("String between One and Three is: "+StringUtil.getStringBetween("one two three four five","one","three"));
		
		System.out.println("Random String: "+StringUtil.getRandomString(12));
	}
}