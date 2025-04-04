package at.technikum.InClassStuff;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.regex.*;

public class Apr3 {
    private final String input;

    public Apr3(String input) {
        this.input = input;
    }

    public void extractContent() {
        TokenizedString ts = new TokenizedString(input);
        ArrayList<String> lines = cleanTags(ts.getTokenArr());

        boolean isReady = false;
        Pattern pattern = Pattern.compile(".*<[^>]+>.*");
        Matcher matcher;
        while (!isReady) {
            ArrayList<String> tempArr = new ArrayList<>();
            isReady = true;
            for (String l : lines) {
                matcher = pattern.matcher(l);
                if (matcher.find()) {
                    isReady = false;
                    TokenizedString ts2 = new TokenizedString(l);
                    tempArr.addAll(cleanTags(ts2.getTokenArr()));
                } else {
                    tempArr.add(l);
                }
            }
            lines = tempArr;
        }

        System.out.println("Full string:");
        System.out.println(ts.getFullString());
        System.out.println("-------------------------");
        System.out.println("Content between the tags:");
        for (String ab : lines) {
            System.out.println(ab);
        }
    }


    private static @NotNull ArrayList<String> cleanTags(ArrayList<String> arr) {
        // returns an arraylist of strings, extracted material and invalid parts
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

            // non-tag content found
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

        return newArray;
    }


    private static boolean isAStartingTag(@NotNull String s) {
        return s.matches("<[A-Za-z]+[A-Za-z0-9]*>");
    }

    private static boolean isAClosingTag(@NotNull String s) {
        return s.matches("</[A-Za-z]+[A-Za-z0-9]*>");
    }

    private static @NotNull String returnClosingTag(@NotNull String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 1) {
                sb.append("/");
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


    // Test Helpers
    public static boolean isATagTestHelper(String s) {
        return isAStartingTag(s);
    }

    public static boolean isAStringTestHelper(String a) {
        return isAStartingTag(a);
    }
}


// Tokenized String class. Stores full and tokenized string...
class TokenizedString {
    private final String fullString;
    private final ArrayList<String> tokenArr;

    public TokenizedString(String input) {
        this.fullString = input;
        tokenArr = tokenizeString(input);
    }

    private @NotNull ArrayList<String> tokenizeString(String s) {
        ArrayList<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile(("(<[^>]+>)|([^<]+)"));
            /*
            Outer parenthesis are for extracting the pattern data later
            [^>] any character but >
            second part is for the text between the tags
            */
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                // group(0) = the whole expression
                // group(1) = the first parenthesis
                // group(2) = the second parenthesis
                tokens.add(matcher.group(1));
            } else if (matcher.group(2) != null) {
                String text = matcher.group(2).trim();
                if (!text.isEmpty()) {
                    tokens.add(text);
                }
            }
        }
        return tokens;
    }

    public String getFullString() {
        return fullString;
    }

    public ArrayList<String> getTokenArr() {
        return tokenArr;
    }
}
