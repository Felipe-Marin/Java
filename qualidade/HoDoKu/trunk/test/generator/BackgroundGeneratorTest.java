/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.DifficultyLevel;
import sudoku.DifficultyType;
import sudoku.GameMode;
import sudoku.GenerateSudokuProgressDialog;
import sudoku.Sudoku2;

/**
 *
 * @author Felipe
 */
public class BackgroundGeneratorTest {
    
    boolean falha;
    
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
        falha = false;
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
        char cells[] = result.toCharArray();
        int lineStart = 0;
        int lineEnd = 8;
        int columnStart = 0;
        int columnEnd = 81;
        //Testa as 9 linhas e 9 colunas do jogo
        for(int i=0; i<9; i++){
            //Teste das linhas buscando por valores repetidos
            for(int j=lineStart; j<=lineEnd; j++){
                for(int h=j; h<lineEnd; h++){
                    if(cells[h]!='.')
                        if(cells[h] == cells[h+1]){
                            falha = true;
                        }
                }                
            }
            //Teste das colunas buscando por valores repetidos
            for(int j=columnStart; j<=columnEnd; j+=9){
                for(int h=j; h<lineEnd; h+=9){
                    if(cells[h]!='.'){
                        if(cells[h] == cells[h+9]){
                            falha = true;
                        }
                    }
                }                
            }
            lineStart += 9;
            lineEnd += 9;
            columnStart++;
            columnEnd++;
        }
        //Caso algum valor repetido seja encontrado a variável falha passa a ser verdadeira indicando um erro na tabela de sudoku gerada
        assertFalse(falha);
    }
    
}
