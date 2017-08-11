package customannotations;

/**
 *
 * @author student
 */

@TestMeta(
        name = "unit",
        priority = TestMeta.Priority.HIGH
)
public class Unittest {
    @Test
    public void testA() {
        if(TestClass.A()) {
            throw new RuntimeException("This test always failed");
        }
    }

    @Test(enabled = false)
    public void testB() {
        throw new RuntimeException("This test always passed");
    }

    @Test(enabled = true)
    public void testC() {
        // OK
    }
}