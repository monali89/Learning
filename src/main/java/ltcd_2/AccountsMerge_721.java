package ltcd_2;

import java.util.ArrayList;
import java.util.List;

public class AccountsMerge_721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        return null;
    }

    public static void main(String[] args) {
        AccountsMerge_721 object = new AccountsMerge_721();
        List<List<String>> input;
        String[][] stringArray;

        // example 1
        stringArray = new String[][] {{"John","johnsmith@mail.com","john_newyork@mail.com"},
                {"John","johnsmith@mail.com","john00@mail.com"},
                {"Mary","mary@mail.com"},
                {"John","johnnybravo@mail.com"}};
        input = object.formatInput(stringArray);
        System.out.println(object.accountsMerge(input));


    }

    private List<List<String>> formatInput(String[][] str) {
        List<List<String>> ll = new ArrayList<List<String>>();

        for (int i = 0; i < str.length; i++) {
            List<String> l = new ArrayList<String>();
            for (int j = 0; j < str[0].length; j++) {
                l.add(str[i][j]);
            }
            ll.add(l);
        }
        return ll;
    }
}
