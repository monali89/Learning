package misc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Monali L on 4/20/2020
 */

public class ArrayProblemsTest {

    ArrayProblems obj;

    @Before
    public void beforeTest() {
        obj = new ArrayProblems();
    }

    @Test
    public void test_getTripletCount_01() {
        int[] arr = {-2, 0, 1, 3};
        Assert.assertEquals(2, obj.getTripletCount(arr, 2));
    }

    @Test
    public void test_getTripletCount_02() {
        int[] arr = {5, 1, 3, 4, 7};
        Assert.assertEquals(4, obj.getTripletCount(arr, 12));
    }

}
