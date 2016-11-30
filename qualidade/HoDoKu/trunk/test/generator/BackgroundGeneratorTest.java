/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import java.awt.Color;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.DifficultyLevel;
import sudoku.DifficultyType;
import sudoku.GameMode;
import sudoku.VerificaSudoku;

/**
 *
 * @author Felipe
 */
public class BackgroundGeneratorTest {
    
        
    public BackgroundGeneratorTest() {
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
     * Test of generate method, of class BackgroundGenerator.
     * Testa se não há colunas ou linhas com números repetidos tornando o sudoku gerado impossivel de ser resolvido.
     */
    @Test
    public void testGenerate_DifficultyLevel_GameMode() {
        System.out.println("generate");
        DifficultyLevel level = new DifficultyLevel(DifficultyType.MEDIUM, 1000, java.util.ResourceBundle.getBundle("intl/MainFrame").getString("MainFrame.medium"), new Color(100, 255, 100), Color.BLACK);
        GameMode mode = GameMode.PLAYING;
        //Diferentes jogos são gerados em background para cada tipo de jogo e nivel de dificuldade
        //Nesse teste foi usado a dificuldade "Medium" e o modo de jogo "playing"
        BackgroundGenerator instance = new BackgroundGenerator();
        String result = instance.generate(level, mode);
        assertThat(VerificaSudoku.linhas(result) && VerificaSudoku.colunas(result) && VerificaSudoku.quadrados(result), is(true));
    }
    
}
