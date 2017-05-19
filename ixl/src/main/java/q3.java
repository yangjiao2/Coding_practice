///**
// * Created by Yang on 2017/5/17.
// */
//import java.util.*;
//
//public class q3 {
//
//    public static StringBuilder breakWord(String word, int maxChars){
//        StringBuilder wordResult = new StringBuilder();
//        int start  = 0, end = 0;
//        for (int i = 0; i <= word.length() / maxChars; i++) {
//            start = i * maxChars;
//            end = Math.min((i + 1) * maxChars, word.length());
//            if (word.substring(end - 1, end)).equals("\n"){
//                wordResult.append(word.substring(start, end));
//            }
//            wordResult.append("\n").append(word.substring(start, end));
//        }
//
//        return wordResult;
//    }
//
//    public static String wrapText(String text, int maxCharsPerLine){
//
//        if (text == null || maxCharsPerLine <= 0) return "";
//        StringBuilder textResult = new StringBuilder();
//        text = text.replaceAll("( )+", " ");
//        text = text.replaceAll(" \n", "\n");
//        text = text.replaceAll("\n ", "\n");
//        String[] strings = text.split(" ");
//
//
//        int lengthCur = 0;
//        boolean singleword = true;
//        for(String word: strings) {
//            if (word.length() < lengthCur + maxCharsPerLine) {
//                textResult.append(" ").append(word);
//                lengthCur += word.length() + 1;
//            }else{
//                if (singleword) {
//                    textResult.append(breakWord(word, maxCharsPerLine));
//                    singleword = false;
//                    lengthCur = (1+word.length()) % (maxCharsPerLine);
//                } else{
//                    textResult.append(breakWord(word, maxCharsPerLine));
//                    lengthCur = (1+word.length()) % (maxCharsPerLine);
//
//                }
//            }
////                lengthProjection += word.length();
////                int start = 0;
////
////                if (!singleword && (lengthProjection + 1 > maxCharsPerLine)){
////                    textResult.append("\n");
////                    lengthProjection = word.length();
////                    singleword = true;
////                }
////
////                else if(!singleword && (lengthProjection + 1 <= maxCharsPerLine)){
////                    if (word.equals("")){
////                        textResult.append("\n");
////                        lengthProjection = 0;
////                        singleword = true;
////                    }else {
////                        textResult.append(" " + word);
////                        lengthProjection += 1;
////                    }
////                }
////
////                else if(singleword && (lengthProjection + 1 <= maxCharsPerLine)){
////                    textResult.append(word);
////                    lengthProjection += 1;
////                    singleword = false;
////                }
////
////                if (singleword  && (lengthProjection + 1 > maxCharsPerLine)) {
////                    while (lengthProjection + 1 > maxCharsPerLine) {
////                        textResult.append(word.substring(start, start + maxCharsPerLine - 1) + "\n");
////                        singleword = true;
////                        start += maxCharsPerLine - 1;
////                        lengthProjection -= maxCharsPerLine + 1;
////                        word = word.substring(start + maxCharsPerLine - 1);
////                    }
////                    textResult.append(word);
////                    lengthProjection += word.length() + 1;
////                    singleword = false;
////                }
////                else {
////                    if (lengthProjection + 1 > maxCharsPerLine){
////                        textResult.append("\n");
////
////                    }
////                }
////            }
//        }
//        return textResult.toString();
//    }
//
//    public static void main(String[] args) {
//        String[] tests = {
//
//                "\n f            d\n \n",
//                "",
//                "this is...\n",
//                "\n\n\n",
//                "this is a string.\nAnd that is not a string.\n",
//                "An assertion is a statement in the JavaTM programming language that enables you to test your assumptions about your program. For example, if you write a method that calculates the speed of a particle, you might assert that the calculated speed is less than the speed of light.\n"
//                        + "\n"
//                        + "Each assertion contains a boolean expression that you believe will be true when the assertion executes. If it is not true, the system will throw an error. By verifying that the boolean expression is indeed true, the assertion confirms your assumptions about the behavior of your program, increasing your confidence that the program is free of errors."
//        };
//
//        int[] testArgs = {
//                1,
//                0,
//                3,
//                13,
//                15,
//                20,
//                50,
//        };
//
//        boolean[] isResultNull = {
//                true,
//                true,
//                false,
//                true,
//                false,
//                false,
//                false
//        };
//
//        for (int i = 0; i < tests.length; i++) {
//            for (int j = 0; j < tests.length; j++) {
//                String output = wrapText(tests[i], testArgs[j]);
//                System.out.println("tests[i]" + tests[i]);
//                System.out.println("testArgs[i]" + testArgs[j]);
//                System.out.println("output" +
//                        output);
//            }
//        }
//    }
//}
