import com.revature.app.Solution;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SolutionTest {

    @Test
    public void testBrackets1() {
        String s = "abc.abc";
        Solution sl = new Solution();

        assertEquals(sl.brackets(s), "abc[.]abc");
    }

    @Test
    public void testBrackets2() {
        String s = "a.bc.ab.c";
        Solution sl = new Solution();

        assertEquals(sl.brackets(s), "a[.]bc[.]ab[.]c");
    }

    @Test
    public void testBrackets3() {
        String s = ".";
        Solution sl = new Solution();

        assertEquals(sl.brackets(s), "[.]");
    }

    @Test
    public void testBrackets4() {
        String s = "";
        Solution sl = new Solution();

        assertEquals(sl.brackets(s), "");
    }

    @Test
    public void testBrackets5() {
        String s = "abc";
        Solution sl = new Solution();

        assertEquals(sl.brackets(s), "abc");
    }
}