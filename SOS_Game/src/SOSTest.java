import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class SOSTest {


    private SOS testFrame;

    @Before
    public void setUp() throws Exception {
        testFrame = new SOS();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEmptyFrame() {
        testFrame = new SOS();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}