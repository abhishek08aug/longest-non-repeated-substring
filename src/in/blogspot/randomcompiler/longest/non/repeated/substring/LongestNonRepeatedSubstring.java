package in.blogspot.randomcompiler.longest.non.repeated.substring;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatedSubstring {
    public static String longestNonRepeatedSubstring(String input) {
        if(input == null) {
            return null;
        }
        

        int lnrsStartIndex = 0;
        int lnrsEndIndex = 0;
        Map<Character, Integer> occurrenceMap = new HashMap<Character, Integer>();
        occurrenceMap.put(input.charAt(0), 0);
        int longest = 1;
        int finalStartIndex = 0;
        int finalEndIndex = 0;
        for(int i=1; i<input.length(); i++) {
            if(occurrenceMap.get(input.charAt(i)) == null) {
                lnrsEndIndex = i;
                if(lnrsEndIndex - lnrsStartIndex +1 > longest) {
                    longest = lnrsEndIndex - lnrsStartIndex +1;
                    finalStartIndex = lnrsStartIndex;
                    finalEndIndex = lnrsEndIndex;
                }
            } else {
                if(occurrenceMap.get(input.charAt(i)) < lnrsStartIndex) {
                    lnrsEndIndex = i;
                    if(lnrsEndIndex - lnrsStartIndex +1 > longest) {
                        longest = lnrsEndIndex - lnrsStartIndex +1;
                        finalStartIndex = lnrsStartIndex;
                        finalEndIndex = lnrsEndIndex;
                    }
                } else {
                    lnrsStartIndex = occurrenceMap.get(input.charAt(i)) + 1;
                    lnrsEndIndex = i;
                    if(lnrsEndIndex - lnrsStartIndex +1 > longest) {
                        longest = lnrsEndIndex - lnrsStartIndex +1;
                        finalStartIndex = lnrsStartIndex;
                        finalEndIndex = lnrsEndIndex;
                    }
                }
            }
            occurrenceMap.put(input.charAt(i), i);
        }
        return input.substring(finalStartIndex, finalEndIndex+1);
    }
}
