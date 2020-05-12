package misc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Monali L on 4/20/2020
 */
public class BitManipulationTest {

    BitManipulation obj;

    @Before
    public void beforeTest() {
        obj = new BitManipulation();
    }

    @Test
    public void test_getXorSubArray_01() {
        int[] arr = {1, 2, 3, 4};
        Assert.assertEquals(7, obj.getXorSubArray(arr));
    }

    @Test
    public void test_getBitDifferences_01() {
        int[] input = {1, 2};
        Assert.assertEquals(4, obj.getBitDifferences(input));
    }

    @Test
    public void test_getUniqueNumber_01() {
        int[] input = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
        Assert.assertEquals(2, obj.getUniqueNumber(input));
    }

    @Test
    public void test_getUniqueNumber2_01() {
        int[] input = {1, 1, 2, 2, 3, 4, 4};
        Assert.assertEquals(3, obj.getUniqueNumber2(input));
    }

    @Test
    public void test_getBinaryString_01() {
        Assert.assertEquals("10000011", obj.getBinaryString(131));
        Assert.assertEquals("110", obj.getBinaryString(3));
    }

    @Test
    public void test_getFlipCount_01() {
        Assert.assertEquals(4, obj.getFlipCount(10, 20));
        Assert.assertEquals(3, obj.getFlipCount(7, 10));
    }

    @Test
    public void test_bitConversion() {
        Assert.assertEquals(Integer.toBinaryString(12), obj.getBinaryString(12));
        System.out.println(123.456/123);
    }

}
