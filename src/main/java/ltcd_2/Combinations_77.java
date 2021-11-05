package ltcd_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {

        if (k > n) return null;

        if (k == n || k == 0) {

            List<List<Integer>> ll = new ArrayList<>();
            List<Integer> l = new ArrayList<>();

            for (int i = 1; i <= k; i++) {
                l.add(i);
            }

            ll.add(l);
            return ll;
        }

        List<List<Integer>> first = combine(n-1, k-1);
        for (List l: first) l.add(n);
        List<List<Integer>> second = combine(n-1, k);
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(first);
        result.addAll(second);
        return result;
    }

    public static void main(String[] args) {
        Combinations_77 object = new Combinations_77();
        System.out.println(object.combine(4, 2));
    }
}

/*
* Combinations: selection of items from a collection,
*            such that the order of selection does not matter
*
* C(n, k) = C(n-1, k-1) + C(n-1, k)
*
* There are various algorithms to pick out a random
* combination from a given set or list. (Ex. Reservoir sampling)
*
* Related: Rejection sampling
*
* */
