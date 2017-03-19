package trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoThreeTreeTest {

    @Test
    public void test() {
        TwoThreeTree tree = new TwoThreeTree();

        tree.add("JJJ");
        tree.add("FFF");
        tree.add("PPP");
        tree.add("QQQ");
        tree.add("AAA");
        tree.add("CCC");
        tree.add("LLL");
        tree.add("UUU");
        tree.add("OOO");
        tree.add("DDD");
        tree.add("BBB");
        tree.add("WWW");
        tree.add("NNN");
        tree.add("HHH");
        tree.add("SSS");
        tree.add("BAU");

        tree.printTree();

        assertEquals("LLL", tree.getDataLeft(tree.find("LLL")));
    }
}