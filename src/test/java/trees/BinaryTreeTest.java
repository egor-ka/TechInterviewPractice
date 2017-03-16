package trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Egor on 8-Mar-17.
 */
public class BinaryTreeTest {

    private BinaryTree tree;

    @Before
    public void setUp() {
        tree = new BinaryTree();

        tree.add("H");
        tree.add("F");
        tree.add("M");
        tree.add("E");
        tree.add("G");
        tree.add("L");
        tree.add("Q");
    }

    @Test
    public void test() {
        tree.bfsRead();
        tree.dfsPreOrderRead();
        tree.dfsInOrderRead();
        tree.dfsPostOrderRead();

        assertEquals(7, tree.size());

        assertEquals(0, BinaryTree.rank(tree.find("Q")));
        assertEquals(0, BinaryTree.rank(tree.find("L")));
        assertEquals(2, BinaryTree.rank(tree.find("F")));
        assertEquals(2, BinaryTree.rank(tree.find("M")));
        assertEquals(6, BinaryTree.rank(tree.find("H")));

        assertEquals(2, tree.height());
        tree.add("A");
        assertEquals(3, tree.height());

        assertEquals(0, BinaryTree.depth(tree.find("H")));
        assertEquals(1, BinaryTree.depth(tree.find("F")));
        assertEquals(2, BinaryTree.depth(tree.find("G")));
        assertEquals(2, BinaryTree.depth(tree.find("L")));
    }
}