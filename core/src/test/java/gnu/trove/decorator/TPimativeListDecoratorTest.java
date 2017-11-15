package gnu.trove.decorator;

import gnu.trove.TDecorators;
import gnu.trove.list.TIntList;
import junit.framework.TestCase;

/**
 * @author Jim Davies
 */
public class TPimativeListDecoratorTest extends TestCase{
    public void testConstructorWithNull() {
        boolean expectionThrown = false;
        try {
            TDecorators.wrap((TIntList) null);
        } catch(NullPointerException ignored) {
            expectionThrown = true;
        }

        assertTrue("Wrapping a null value should result in an expection being thrown.", expectionThrown);
    }
}
