package graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Monali L on 4/18/2020
 */

public class DfsApplicationsTest {

    private DfsApplications dfsApplications;

    @Before
    public void beforeTest() {
        dfsApplications = new DfsApplications();
    }

    @Test
    public void test_getNumberOfIslands_01() {
        int[][] mat = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        Assert.assertEquals(5, dfsApplications.getNumberOfIslands(mat));
    }

    @Test
    public void test_hasCycle() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        Assert.assertEquals(true, dfsApplications.hasCycle(g));
    }

    @Test
    public void test_topologicalOrder() {
        Digraph dg = new Digraph(6);
        dg.addEdge(2, 3);
        dg.addEdge(3, 1);
        dg.addEdge(4, 0);
        dg.addEdge(4, 1);
        dg.addEdge(5, 0);
        dg.addEdge(5, 2);
        int[] expected = {5, 4, 2, 3, 1, 0};
        Assert.assertArrayEquals(expected, dfsApplications.topologicalOrder(dg));
    }

    @Test
    public void test_longestPath() {
        WeightedDigraph wdg = new WeightedDigraph(6);
        wdg.addEdge(0, 1, 3);
        wdg.addEdge(1, 2, 4);
        wdg.addEdge(1, 5, 2);
        wdg.addEdge(5, 3, 6);
        wdg.addEdge(5, 4, 5);
        Assert.assertEquals(12, dfsApplications.longestPath(wdg));
    }
}
