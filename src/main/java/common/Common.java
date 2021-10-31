package common;

public class Common {

    public static String arrayToString(int[] a) {
        StringBuilder str = new StringBuilder();
        for (int v: a) {
            str.append(v);
            str.append(',');
        }
        if (str.length() > 1) str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    public static void printStringArray(String[] arr) {
        for (String str: arr) {
            System.out.println(str);
        }
    }

    public static void print2DIntArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printResult(String input, String output, String expected) {
        System.out.println("Input: " + input +
                " | Output: " + output +
                " | Expected: " + expected +
                " | Result: " + (output.equals(expected) ? "TRUE" : "^^FALSE^^"));
        System.out.println();
    }

    public static void printResult(String input, int output, int expected) {
        System.out.println("Input: " + input +
                " | Output: " + output +
                " | Expected: " + expected +
                " | Result: " + (output == expected ? "TRUE" : "^^FALSE^^"));
        System.out.println();
    }

    public static void printResult(String input, boolean output, boolean expected) {
        System.out.println("Input: " + input +
                " | Output: " + output +
                " | Expected: " + expected +
                " | Result: " + (output == expected ? "TRUE" : "^^FALSE^^"));
        System.out.println();
    }
}
