package ltcd_2;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII_264 {

    public int nthUglyNumber(int n) {

        if (n == 1) return 1;
        List<Integer> dp = new ArrayList<>();
        dp.add(1);


        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp.add(i);
            } else if (i % 3 == 0) {
                dp.add(i);
            } else if (i % 5 == 0) {
                dp.add(i);
            }
        }

        return dp.get(dp.size() - 1);
    }
}
