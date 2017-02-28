package brackets;

import org.junit.Assert;
import org.junit.Test;

import static brackets.BracketsVerifier.isBracketsBalanced;

/**
 * Created by Egor on 28-Feb-17.
 */
public class BracketsVerifierTest {

    @Test
    public void test() {
        Assert.assertTrue(isBracketsBalanced("<[()]>"));
        Assert.assertTrue(isBracketsBalanced("<[(awdawdawdawdawd)]>"));
        Assert.assertFalse(isBracketsBalanced("<[([[[[)]>"));
        Assert.assertFalse(isBracketsBalanced("((("));
        Assert.assertFalse(isBracketsBalanced(")))"));
    }
}
