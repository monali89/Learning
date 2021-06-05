package ltcd;

import org.junit.Assert;
import org.junit.Test;

/**
 * Date: 5/13/2019
 * @author: Monali
 */

public class NumberOfIslands {

    @Test
    public void test01(){
        Assert.assertEquals(3, numberOfIslands(new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}}));
    }

    @Test
    public void test02(){
        Assert.assertEquals(1, numberOfIslands(new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}}));
    }

    @Test
    public void test03(){
        Assert.assertEquals(1, numberOfIslands(new char[][]{{'1','1','1','1','0'}}));
    }

    @Test
    public void test04(){
        Assert.assertEquals(1, numberOfIslands(new char[][]{{'1'}, {'1'}, {'1'}, {'0'}}));
    }

    @Test
    public void test05(){
        Assert.assertEquals(0, numberOfIslands(new char[][]{{}}));
    }

    public int numberOfIslands(char[][] grid){
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    System.out.println("For i, j: " + i + ", " + j);
                    helper(i, j, grid);
                    count++;
                    for (int a = 0; a < grid.length; a++) {
                        for (int b = 0; b < grid[0].length; b++) {
                            System.out.print(grid[a][b] + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
        return count;
    }

    public void helper(int i, int j, char[][] grid){
        System.out.println("Helper for i, j: " + i + ", " + j);
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        grid[i][j] = '0';
        /*for (int x = i-1; x <= i+1; x++) {
            for (int y = j-1; y <= j+1; y++) {
                if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;
                if(x == i && y == j) continue;
                if((x == i-1 && y == j-1) || (x == i+1 && y == j+1) || (x == i-1 && y == j+1) || (x == i+1 && y == j-1)) continue;
                if(grid[x][y] != '0') helper(x, y, grid);
            }
        }*/
        if(i-1 > -1 && grid[i-1][j] != '0') helper(i-1, j, grid);
        if(i+1 < grid.length && grid[i+1][j] != '0') helper(i+1, j, grid);
        if(j-1 > -1 && grid[i][j-1] != '0') helper(i, j-1, grid);
        if(j+1 < grid[0].length && grid[i][j+1] != '0') helper(i, j+1, grid);
    }

}
