package ltcd_2;

public class AddStrings_415 {

    public String addStrings(String num1, String num2) {

        StringBuilder result = new StringBuilder();

        int i = num1.length()-1, j = num2.length()-1;

        int total = 0;
        int rem = 0;

        while (i >= 0 && j >= 0) {

            total = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j)) + rem;
            result.append(total % 10);
            rem = total / 10;
            i--; j--;
        }

        while (i >= 0) {
            total = Character.getNumericValue(num1.charAt(i)) + rem;
            result.append(total % 10);
            rem = total / 10;
            i--;
        }

        while (j >= 0) {
            total = Character.getNumericValue(num2.charAt(j)) + rem;
            result.append(total % 10);
            rem = total / 10;
            j--;
        }

        if (rem > 0) result.append(rem);

        result.reverse();

        return result.toString();
    }

    public static void main(String[] args) {

        AddStrings_415 object = new AddStrings_415();
        String input1 = "";
        String input2 = "";

        // test 1
        input1 = "11";
        input2 = "22";
        System.out.println(object.addStrings(input1, input2));

        // test 2
        input1 = "11";
        input2 = "89";
        System.out.println(object.addStrings(input1, input2));

    }

}
