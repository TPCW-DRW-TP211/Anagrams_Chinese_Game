package com.toy.anagrams.lib;

import java.util.Arrays;
import junit.framework.TestCase;

public class WordLibraryTest extends TestCase {
    WordLibrary wordLibrary;

    public WordLibraryTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
        wordLibrary = WordLibrary.getDefault();
    }
    
    public void testIsCorrect() {
        for (int i = 0; i < wordLibrary.getSize(); i++) {
            String clearWord = wordLibrary.getWord(i);
            String scrambledWord = wordLibrary.getScrambledWord(i);
            assertTrue("Scrambled word \"" + scrambledWord +
                       "\" at index: " + i +
                       " does not represent the word \"" + clearWord + "\"",
                       isAnagram(clearWord, scrambledWord));
        }
    }

    private boolean isAnagram(String clearWord, String scrambledWord) {
        char[] clearArray = clearWord.toCharArray();
        char[] scrambledArray = scrambledWord.toCharArray();
        Arrays.sort(clearArray);
        Arrays.sort(scrambledArray);
        return Arrays.equals(clearArray, scrambledArray);
    }

}
