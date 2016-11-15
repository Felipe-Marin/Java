/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import solver.SudokuSolver;

/**
 *
 * @author Felipe
 */
public class SudokuPanelTest {
    private MainFrame mf;
    public SudokuPanelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String file = new String("IniFile");
        mf = new MainFrame(file);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of undo method, of class SudokuPanel.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        SudokuPanel instance = new SudokuPanel(mf);
        SudokuPanel instance2 = new SudokuPanel(mf);
        //Alterar instance
        //
        instance.undo();
        assertEquals(instance, instance2);
    }

    /**
     * Test of redo method, of class SudokuPanel.
     */
    @Test
    public void testRedo() {
        System.out.println("redo");
        SudokuPanel instance = null;
        instance.redo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
}
