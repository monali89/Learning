package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 7/31/2019
 * @author: Monali
 */


public class FindInMountainArray {

    @Test
    public void test01(){
        Integer[] inputArray = new Integer[]{1,2,3,4,5,3,1};
        MountainArray mountainArray = new MountainArray();
        mountainArray.add(inputArray);
        Assert.assertEquals(2, findInMountainArray(3, mountainArray));
    }

    @Test
    public void test02(){
        Integer[] inputArray = new Integer[]{0,1,2,4,2,1};
        MountainArray mountainArray = new MountainArray();
        mountainArray.add(inputArray);
        Assert.assertEquals(-1, findInMountainArray(3, mountainArray));
    }

    @Test
    public void test03(){
        Integer[] inputArray = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,
                23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,
                52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,
                81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,100,99,98,97,96,95,94,
                93,92,91,90,89,88,87,86,85,84,83,82};
        MountainArray mountainArray = new MountainArray();
        mountainArray.add(inputArray);
        Assert.assertEquals(100, findInMountainArray(101, mountainArray));
    }

    int t;
    public int findInMountainArray(int target, MountainArray mountainArr) {
        t = target;
        return helper(0, mountainArr.length()-1, mountainArr);
    }

    public int helper(int s, int e, MountainArray mArr){

        System.out.println("Searching between " + s + " and " + e);

        if(s == e){
            if(mArr.get(s) == t) return s;
            else return -1;
        }

        int m = (s+e)/2;
        int index = helper(s, m, mArr);

        if(index != -1) return index;
        return helper(m+1, e, mArr);

    }

    class MountainArray {

        List<Integer> a;

        MountainArray(){
            a = new ArrayList<Integer>();
        }

        public void add(Integer[] arr){
            a.addAll(Arrays.asList(arr));
        }

        public int get(int index){
            return a.get(index);
        }
        public int length(){
            return a.size();
        }
    }
}
