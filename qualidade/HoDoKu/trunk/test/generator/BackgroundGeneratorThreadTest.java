/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import java.awt.Color;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.DifficultyLevel;
import sudoku.DifficultyType;
import sudoku.GameMode;

/**
 *
 * @author Felipe
 */
public class BackgroundGeneratorThreadTest {
    
    public BackgroundGeneratorThreadTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class BackgroundGeneratorThread.
     */
    /*
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        BackgroundGeneratorThread expResult = null;
        BackgroundGeneratorThread result = BackgroundGeneratorThread.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of getSudoku method, of class BackgroundGeneratorThread.
     */
    @Test
    public void testGetSudoku() {
        System.out.println("getSudoku");
        DifficultyLevel level = new DifficultyLevel(DifficultyType.MEDIUM, 1000, java.util.ResourceBundle.getBundle("intl/MainFrame").getString("MainFrame.medium"), new Color(100, 255, 100), Color.BLACK);
        GameMode mode = GameMode.PLAYING;
        BackgroundGeneratorThread instance = BackgroundGeneratorThread.getInstance();
        String result = instance.getSudoku(level, mode);
        System.out.println(result);
        char cells[] = result.toCharArray();
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

    /*
     * Test of resetAll method, of class BackgroundGeneratorThread.
    
   /* @Test
    public void testResetAll() {
        System.out.println("resetAll");
        BackgroundGeneratorThread instance = null;
        instance.resetAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetTrainingPractising method, of class BackgroundGeneratorThread.
     *//*
    @Test
    public void testResetTrainingPractising() {
        System.out.println("resetTrainingPractising");
        BackgroundGeneratorThread instance = null;
        instance.resetTrainingPractising();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewLevel method, of class BackgroundGeneratorThread.
     */
    //@Test/*
    
}
