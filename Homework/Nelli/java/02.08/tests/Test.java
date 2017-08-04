import org.junit.Test;
import static org.junit.Assert.*;
import solder.Solder;
public class TestAssertions {

   @Test
   public void testAssertions() {
      //test data
	Solder solder = new Solder("Solder","ARM",0,5,100);
	assertEquals("Name must be solder", 0, solder.getName());
   }
}
