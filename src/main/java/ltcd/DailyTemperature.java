package ltcd;

import org.junit.Assert;
import org.junit.Test;

/**
 * Date: 5/13/2019
 * @author: Monali
 */

public class DailyTemperature {

    @Test
    public void test01(){
        Assert.assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, dailyTemperature(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));}

    @Test
    public void test02(){
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0}, dailyTemperature(new int[]{60, 60, 60, 60}));}

    @Test
    public void test03(){
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0}, dailyTemperature(new int[]{95, 90, 85, 80, 75}));}

    @Test
    public void test04(){
        Assert.assertArrayEquals(new int[]{1, 1, 1, 1}, dailyTemperature(new int[]{60, 65, 70, 75}));}


    public int[] dailyTemperature(int[] temps){
        
        int[] rslt = new int[temps.length];

        for (int i = 0; i < temps.length; i++) {
            int days = 1;
            int j = i+1;
            while(j < temps.length && temps[i] > temps[j]){
                days++;
                j++;
            }
            if(j == temps.length) rslt[i] = 0;
            else rslt[i] = days;
        }

        return rslt;
    }

}
