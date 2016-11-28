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
import static org.hamcrest.CoreMatchers.not;
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
        //mf = new MainFrame(file);
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
        MainFrame mf = new MainFrame(null);
        SudokuPanel instance = new SudokuPanel(mf);
        SudokuPanel instance2 = new SudokuPanel(mf);
        instance.setSudoku("...31.6.......8....54.9...147.......192...587.......148...6.39....2.......7.51...");
        instance2.setSudoku("...31.6.......8....54.9...147.......192...587.......148...6.39....2.......7.51...");
        instance2.setCellFromCellZoomPanel(5);
        instance2.undo();
        //instance2.setSudoku(".........4.....98.79..23.....65..1.8.2.1.6.3.1.7..84.....21..54.82.....7.........");
        System.out.println(instance2.getSudokuString(ClipboardMode.PM_GRID));
        assertEquals(instance.getSudokuString(ClipboardMode.PM_GRID), instance2.getSudokuString(ClipboardMode.PM_GRID));
    }

    /**
     * Test of redo method, of class SudokuPanel.
     */
    @Test
    public void testRedo() {
        MainFrame mf = new MainFrame(null);
        SudokuPanel instance = new SudokuPanel(mf);
        SudokuPanel instance2 = new SudokuPanel(mf);
        
        instance2.setSudoku("...31.6.......8....54.9...147.......192...587.......148...6.39....2.......7.51...");
        instance2.setCellFromCellZoomPanel(5);
        instance.setSudoku(instance2.getSudokuString(ClipboardMode.PM_GRID));
        instance2.undo();
        instance2.redo();
        //instance2.setSudoku(".........4.....98.79..23.....65..1.8.2.1.6.3.1.7..84.....21..54.82.....7.........");
        System.out.println(instance2.getSudokuString(ClipboardMode.VALUES_ONLY));
        assertEquals(instance.getSudokuString(ClipboardMode.PM_GRID), instance2.getSudokuString(ClipboardMode.PM_GRID));
    }
    
    @Test
    public void testSolveUpTo() {
        MainFrame mf = new MainFrame(null);
        SudokuPanel instance = new SudokuPanel(mf);        
        instance.setSudoku("...31.6.......8....54.9...147.......192...587.......148...6.39....2.......7.51...");
        instance.solveUpTo();
        //instance2.setSudoku(".........4.....98.79..23.....65..1.8.2.1.6.3.1.7..84.....21..54.82.....7.........");
        String grid = instance.getSudokuString(ClipboardMode.VALUES_ONLY);
        System.out.println(grid);
        char cells[] = grid.toCharArray();
        int lineStart = 0;
        int lineEnd = 8;
        int columnStart = 0;
        int columnEnd = 81;
        for(int i=0; i<9; i++){
            for(int j=lineStart; j<=lineEnd; j++){
                for(int h=j; h<lineEnd; h++){
                    if(cells[h]!='.')
                        assertThat(cells[h], not(cells[h+1]));
                }                
            }
            for(int j=columnStart; j<=columnEnd; j+=9){
                for(int h=j; h<lineEnd; h+=9){
                    if(cells[h]!='.')
                        assertThat(cells[h], not(cells[h+9]));
                }                
            }
            lineStart += 9;
            lineEnd += 9;
            columnStart++;
            columnEnd++;
        }
        
        
    }
    
}
