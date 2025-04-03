package at.technikum.InClassStuff;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Apr3 {
    private static final String input = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";

    public Apr3() {


    }

    // THIS PART IS NOT DONE...
    public static void extractContent() {

        // turning input string into String[] of its elements:
        String[] tokenizedArray = returnTokenizedInput(input);

        // clean the headers:
        boolean finishedCleaning = false;

        String[] initialArray = cleanTags(tokenizedArray);
        /*
        while (!finishedCleaning) {

        }*/

        for (String ab : initialArray) {
            System.out.println(ab);
        }
    }

    private static String[] cleanTags(String[] arr) {
        // returns an array of strings, extracted material and invalid parts
        String tag = null;
        String closingTag = null;
        StringBuilder sb = new StringBuilder();
        int numOfNestedTagWithSameName = 0;
        ArrayList<String> newArray = new ArrayList<>();

        for (String element : arr) {

            // starting tag found
            if (isAStartingTag(element)) {
                // first starting tag found
                if (tag == null) {
                    tag = element;
                    closingTag = returnClosingTag(element);
                } else if (element.equals(tag)) {
                    // nested starting tag, same as the current one
                    numOfNestedTagWithSameName++;
                    sb.append(element);
                } else {
                    // other starting tag found
                    sb.append(element);
                }
                continue;
            }

            // closing tag found
            if (element.equals(closingTag)) {
                if (numOfNestedTagWithSameName == 0) {
                    // closing tag for parent tag found
                    tag = null;
                    closingTag = null;
                    newArray.add(sb.toString());
                    sb = new StringBuilder();
                } else {
                    // closing tag for nested tag found
                    numOfNestedTagWithSameName--;
                    sb.append(element);
                }
                continue;
            }

            // content found
            if (tag != null) {
                sb.append(element);
            } else {
                // found content outside the tag
                newArray.add("Invalid");
            }
        }

        // found content at the end, without the closing tag
        if (tag != null) {
            newArray.add("Invalid");
        }

        return newArray.toArray(new String[0]);
    }

/*    public void testRun() {
        String[] a = returnTokenizedInput("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>");
        String[] arr = tagContentExtractor(a);
        for (String ab : arr) {
            System.out.println(ab);
        }
    }*/


    private static boolean isAStartingTag(String s) {
        // can't be tag if it is shorter than 3 characters
        if (s.length() < 3) return false;
        if (s.charAt(1) == '/') return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 &&
                    s.charAt(i) != '<') return false;
            if (i > 0 &&
                    i < s.length() - 1 &&
                    (s.charAt(i) == '<' || s.charAt(i) == '>')) return false;
            if (i == (s.length() - 1) &&
                    s.charAt(i) != '>') return false;
        }
        return true;
    }

    private static String[] returnTokenizedInput(String input) {
        ArrayList<String> inputElements = new ArrayList<>();

        char[] charArr = input.toCharArray();
        int currentIndex = 0;

        StringBuilder sb = new StringBuilder();

        while (currentIndex < charArr.length) {
            if (charArr[currentIndex] == '<') {
                if (!sb.isEmpty()) {
                    inputElements.add(sb.toString());
                    sb = new StringBuilder();
                }
                sb.append('<');
            } else if (charArr[currentIndex] == '>') {
                sb.append('>');
                inputElements.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(charArr[currentIndex]);
            }
            currentIndex++;
        }
        if (!sb.isEmpty()) {
            inputElements.add(sb.toString());
        }
        // convert arraylist to arr
        return inputElements.toArray(new String[0]);
    }

    private static String returnClosingTag(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 1) {
                sb.append("/");
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // delete later
    private static void testFunc(String[] arr) {
        System.out.println("****");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println("****");
    }

    // Test Helpers
    public static boolean isATagTestHelper(String s) {
        return isAStartingTag(s);
    }


}
