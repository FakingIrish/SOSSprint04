import junit.framework.TestCase;
import org.junit.After;


import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;


public class MakeMoveTest extends SOS {


    @Before
    public void setup() throws Exception {

        createGame(5);

    }

//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void testMove() {
        makeMove(1, 1, "S");
        assertEquals("S", getCell(1, 1), "S");
    }

    @Test
    public void testThrowsIndexOutOfBoundsException() {
        try {
            makeMove(6, 6, "O");
            getCell(6, 6);
            fail("expected exception was not occured.");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    public void testBlueWin() {
        makeMove(0, 0, "S");
        makeMove(0, 1, "O");
        makeMove(0, 2, "S");

        getCell(0, 2);
        checkS(0, 2);
    }
    @Test
    public void testRedWin() {
        makeMove(0, 0, "S");
        makeMove(0, 1, "O");
        makeMove(0, 2, "S");

        getCell(0, 2);
        checkS(0, 2);
    }
}