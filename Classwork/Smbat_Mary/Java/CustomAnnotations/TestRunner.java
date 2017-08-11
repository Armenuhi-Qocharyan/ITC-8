package customannotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *
 * @author student
 */
public class TestRunner {
    public void run() {
        System.out.println("Testing...");
	int passed = 0, failed = 0, count = 0, ignore = 0;

        Class<Unittest> obj = Unittest.class;
        // Process @TestMeta
        if (obj.isAnnotationPresent (TestMeta.class)) {
            Annotation annotation = obj.getAnnotation(TestMeta.class);
            TestMeta testMeta = (TestMeta) annotation;

            System.out.println("Priority: " + testMeta.priority());
            System.out.println("Name: " + testMeta.name() + "\n");
        }

        // Process @Test
        for (Method method : obj.getDeclaredMethods ()) {
            // if method is annotated with @Test
            if (method.isAnnotationPresent(Test.class)) {
                Annotation annotation = method.getAnnotation(Test.class);
                Test test = (Test) annotation;

                // if enabled = true (default)
                if (test.enabled()) {
                    try {
                        method.invoke(obj.newInstance());
                        System.out.println((++count) + " - Test '" + method.getName() + "' - passed");
                        passed++;
                    } catch (Throwable ex) {
                        System.out.println((++count) + " - Test '" + method.getName() + "' - failed: " + ex.getCause());
                        failed++;
                    }
                } else {
                    System.out.println((++count) + " - Test '" + method.getName() + "' - ignored");
                    ignore++;
                }
            }
        }
        System.out.printf ("\nResult : Total : "  + count + " Passed: " + passed + " Failed: " + failed + " Ignore: " + ignore + "\n");
    }
}