/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;


/**
 *
 * @author Felipe
 */
public class VerificaSudoku {
    
    public VerificaSudoku(){
        
    };
    
    //Testa as 9 linhas do sudoku
    public static boolean linhas(String sudoku){
        int lineStart = 0;
        int lineEnd = 8;
        boolean falha = true;
        char[] sudokuArray = sudoku.toCharArray();
        for(int i=0; i<9; i++){
            //Teste das linhas buscando por valores repetidos
            for(int j=lineStart; j<=lineEnd; j++){
                for(int h=j; h<lineEnd; h++){
                    if(sudokuArray[h]!='.')
                        if(sudokuArray[h] == sudokuArray[h+1]){
                            falha = false;
                        }
                }                
            }
            lineStart += 9;
            lineEnd += 9;
        }
        return falha;
    }
    
    //Testa as 9 colunas do sudoku
    public static boolean colunas(String sudoku){
        int columnStart = 0;
        int columnEnd = 81;
        int lineEnd = 8;
        boolean falha = true;
        char[] sudokuArray = sudoku.toCharArray();
        for(int i=0; i<9; i++){
            //Teste das colunas buscando por valores repetidos
            for(int j=columnStart; j<=columnEnd; j+=9){
                for(int h=j; h<lineEnd; h+=9){
                    if(sudokuArray[h]!='.'){
                        if(sudokuArray[h] == sudokuArray[h+9]){
                            falha = false;
                        }
                    }
                }                
            }
            lineEnd += 9;
            columnStart++;
            columnEnd++;
        }
        return falha;
    }
    
    //Testa os 9 quadrados de 3x3 do Sudoku
    public static boolean quadrados(String sudoku){
        boolean falha = true;
        char[] sudokuArray = sudoku.toCharArray();
        int[] q1 = {0, 1, 2, 9, 10, 11, 18, 19, 20};
        int[] q2 = {27,28,29,36,37,38,45,46,47};
        int[] q3 = {54,55,56,63,64,65,72,73,74};
        for(int a = 0; a<3; a++){
            for(int i=0; i<8; i++){
               for(int j = i+1; j<9; j++){
                   if(sudokuArray[q1[i]] != '.' && sudokuArray[q1[i]] == sudokuArray[q1[j]])
                        falha = false;
                }
            }
            for(int i=0; i<q1.length; i++){
                q1[i] += 3;
            }
            for(int i=0; i<8; i++){
               for(int j = i+1; j<9; j++){
                    if(sudokuArray[q2[i]] != '.' && sudokuArray[q2[i]] == sudokuArray[q2[j]])
                        falha = false;
                }
            }
            for(int i=0; i<q2.length; i++){
                q2[i] += 3;
            }
            for(int i=0; i<8; i++){
               for(int j = i+1; j<9; j++){
                    if(sudokuArray[q3[i]] != '.' && sudokuArray[q3[i]] == sudokuArray[q3[j]])
                        falha = false;
                }
            }
            for(int i=0; i<q3.length; i++){
                q3[i] += 3;
            }
        
        }
        return falha;
    }
    
    
}
