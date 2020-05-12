package graphs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Monali L on 4/18/2020
 */

public class BfsApplicationsTest {

    private BfsApplications bfsApp;

    @Before
    public void beforeTest() {
        bfsApp = new BfsApplications();
    }

    @Test
    public void test_bfs() {
        Digraph g = new Digraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(0);
        expected.add(3);
        expected.add(1);
        Assert.assertEquals(expected, bfsApp.bfs(2, g));

    }

    @Test
    public void test_snakesAndLadder() {

        int moves[] = new int[30];
        for (int i = 0; i<30; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        Assert.assertEquals(3, bfsApp.snakesAndLadders(moves));
    }
}
