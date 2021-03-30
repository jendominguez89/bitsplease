package bitsSearch;
import static org.junit.Assert.*;
import org.junit.Test;

/*  Much like a Hobbsian Leviathan, this test may appear to have power
    where there is in fact none. I think a programmer should appreciate
    examples of symbols and references.
 */

public class GUITest {
    @Test
    public void testRun() {
        assertTrue( true );
    }

    /*
     * These test functions (briefly) make an instance of each window.
     * This is important becuase we have a lot of dependencies in the
     * project now and I don't want to manually add everything to the
     * classpath and manually compile everything for every change. In
     * particular, the Gson jar will be a pain.
     *
     * Instead, we use test methods and let Maven automate all that.
     *
     * When we add new features later on, we can (and should) write more
     * tests to make sure everything works right. I may look into Jenkins
     * or something.
     */
    @Test
    public void testSearchWindow() {
        GUI testGui = new GUI();
        assertTrue(testGui != null);
        }

    @Test
    public void testAdminWindow() {
        AdminGUI adminTest = new AdminGUI();
        assertTrue(adminTest != null);
    }

}


