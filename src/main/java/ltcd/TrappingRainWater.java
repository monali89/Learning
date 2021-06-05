package ltcd;

import org.junit.Assert;
import org.junit.Test;

/**
 * Date: 6/9/2019
 * @author: https://leetcode.com/problems/trapping-rain-water/discuss/17386/Sharing-my-Java-code%3A-O(n)-time-O(1)-space
 */

public class TrappingRainWater {

    @Test
    public void test01(){
        Assert.assertEquals(1, trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    @Test
    public void test02(){
        Assert.assertEquals(3, trap(new int[]{4,2,3,5}));
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0, maxleft = 0, maxright = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxleft) {
                    maxleft = height[left];
                } else {
                    res += maxleft - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= maxright) {
                    maxright = height[right];
                } else {
                    res += maxright - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
