package misc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Monali L on 4/22/2020
 */

public class NumberTheoryTest {

    NumberTheory obj;

    @Before
    public void beforeTest() {
        obj = new NumberTheory();
    }

    @Test
    public void test_getModExpo_01() {
        //Assert.assertEquals(3, obj.getModExpo(3, 2, 5));
        Assert.assertEquals(6, obj.getModExpo(2, 5, 13));
        //Assert.assertEquals(8, obj.getModExpo(50, 100, 13));
    }

}
