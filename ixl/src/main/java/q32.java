/**
 * Created by Yang on 2017/5/17.
 */
import java.util.ArrayList;
public class q32 {

    public static ArrayList<String> chunkWord(String word, int chunkSize) {
        ArrayList<String> chunkedWord = new ArrayList<String>();
        for (int i = 0; i < word.length(); i += chunkSize) {
            if(i + chunkSize > word.length()) chunkedWord.add(word.substring(i));
            else chunkedWord.add(word.substring(i, i + chunkSize));
        }
        return chunkedWord;
    }

    public static String wrapText(String text, int maxCharsPerLine) {
        if(maxCharsPerLine <= 0) throw new IllegalArgumentException("maxCharsPerLine > 0");
        String NEW_LINE = "\n";
        String SPACE = " ";
        String[] setences = text.split(NEW_LINE);
        StringBuilder res = new StringBuilder();
        int currentLen = 0;

        for(String setence: setences) {
            String[] words = setence.split(SPACE);
            for(int i =0; i<words.length; i++){
                String word= words[i];
                if(word.length()==0) continue; //if two consective space

                int potentialLen = currentLen==0 ? word.length():currentLen+1+word.length(); //if not empty,add one space
                if(potentialLen == maxCharsPerLine || potentialLen+1 == maxCharsPerLine)	{ //the same length as maxCharsPerLine or just be able to put one space after
                    if(currentLen > 0) res.append(SPACE);
                    res.append(word);
                    res.append(NEW_LINE);
                    currentLen = 0;
                }
                else if(potentialLen+1 < maxCharsPerLine) { //will be able to add another word after the current word.stay at current linev
                    if(currentLen > 0)res.append(SPACE);
                    res.append(word);
                    currentLen=potentialLen;
                }
                else { //can not append next word
                    if(word.length() <= maxCharsPerLine) { //No need to break word
                        res.append(NEW_LINE);
                        currentLen = 0;
                        i--;//revisit current word
                    }
                    else { //Need to break word
                        if(currentLen > 0) {
                            res.append(SPACE);
                            currentLen++;
                        }
                        res.append(word.substring(0, maxCharsPerLine-currentLen)); //append part of the word
                        res.append(NEW_LINE);
                        String restWord = word.substring(maxCharsPerLine-currentLen);
                        ArrayList<String> chuckedWord = chunkWord(restWord,maxCharsPerLine); // a list of chunked word got from the restWord
                        for(int j = 0;j<chuckedWord.size();j++) {
                            String currentChunk = chuckedWord.get(j);
                            res.append(currentChunk);
                            if(j==chuckedWord.size()-1 && currentChunk.length() < maxCharsPerLine-1){ //last chunk and have space to put more characters
                                currentLen=currentChunk.length();
                            }
                            else{
                                res.append(NEW_LINE);
                                currentLen=0;
                            }
                        }
                    }
                }
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String[] tests = {

                "\n f            d",
                "",
                "this is...\n",
                "\n\n\n",
                "this is a string.\nAnd that is not a string.\n",
                "An assertion is a statement in the JavaTM programming language that enables you to test your assumptions about your program. For example, if you write a method that calculates the speed of a particle, you might assert that the calculated speed is less than the speed of light.\n"
                        + "\n"
                        + "Each assertion contains a boolean expression that you believe will be true when the assertion executes. If it is not true, the system will throw an error. By verifying that the boolean expression is indeed true, the assertion confirms your assumptions about the behavior of your program, increasing your confidence that the program is free of errors."
        };

        int[] testArgs = {
                1,
                0,
                3,
                13,
                15,
                20,
                50,
        };

        boolean[] isResultNull = {
                true,
                true,
                false,
                true,
                false,
                false,
                false
        };

        for (int i = 0; i < tests.length; i++) {
            for (int j = 0; j < tests.length; j++) {
                String output = wrapText(tests[i], testArgs[j]);
                System.out.println("tests[i]" + tests[i]);
                System.out.println("testArgs[i]" + testArgs[j]);
                System.out.println("output" +
                        output);
            }
        }
    }
}
