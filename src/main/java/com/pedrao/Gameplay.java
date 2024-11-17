package com.pedrao;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Gameplay {
    
    public static boolean draw = false;
    public static boolean enter = false;
    public static boolean reset = false;
    public int drawSet = 0;
    public int turn = 0;
    public int[][] map = new int[3][3];
    private final int[][] winningCombinations = {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6}
    };

    public boolean gameWon = false; 
    public int winner = -1;

    public Gameplay() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = 1;
            }
        }
    }

    public void changeTile(int i, int j, int turn) {
        if (map[i][j] == 1 && !gameWon) {
            if (turn % 2 == 0) {
                map[i][j] = 0;  // X
            } else {
                map[i][j] = 2;  // O
            }
        }
    }

    public void resetGame(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = 1;
            }
        }
        turn = 0;
        reset = false;
        gameWon = false;
    }
    
    public void drawGame(Graphics g, BufferedImage Dx, BufferedImage Do) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (map[row][col] == 0) {
                    g.drawImage(Dx, col * 210, row * 210, 200, 200, null);
                } else if (map[row][col] == 2) {
                    g.drawImage(Do, col * 210, row * 210, 200, 200, null);
                }
            }
        }
    }

    public void checkWinner() {
        for (int[] comb : winningCombinations) {
            int a = comb[0];
            int b = comb[1];
            int c = comb[2];

            int rowA = a / 3, colA = a % 3;
            int rowB = b / 3, colB = b % 3;
            int rowC = c / 3, colC = c % 3;

            if (map[rowA][colA] == map[rowB][colB] && map[rowB][colB] == map[rowC][colC] && map[rowA][colA] != 1) {
                gameWon = true;
                winner = map[rowA][colA]; 
            }
        }
    }

    public void render(Graphics g, int row, int col, BufferedImage SelectedButton, BufferedImage Xb, BufferedImage Ob,
                        BufferedImage WinX, BufferedImage WinO, BufferedImage SX, BufferedImage SO, BufferedImage DX, BufferedImage DO) {
        if(reset){
            resetGame();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 0) {
                    g.drawImage(Xb, i * 210, j * 210, 200, 200, null);
                } else if (map[i][j] == 2) {
                    g.drawImage(Ob, i * 210, j * 210, 200, 200, null);
                }
        
                if (i == row && j == col) {
                    if (map[i][j] == 1) {
                        g.drawImage(SelectedButton, i * 210, j * 210, 200, 200, null);
                    } else if (map[i][j] == 0) {
                        g.drawImage(SX, i * 210, j * 210, 200, 200, null);
                    } else {
                        g.drawImage(SO, i * 210, j * 210, 200, 200, null);
                    }
        
                    if (enter) {
                        if (map[i][j] == 1) {
                            changeTile(i, j, turn);
                            turn++;
                            checkWinner();
                        }
                        enter = false;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(map[i][j] != 1){
                    drawSet ++;
                }
            }
        }
        
        if(drawSet == 9){
            draw = true;
        }
        
        drawSet = 0;

        if(draw){
            drawGame(g, DX, DO);
        }

        if (gameWon) {
            for (int[] comb : winningCombinations) {
                int a = comb[0];
                int b = comb[1];
                int c = comb[2];
                int rowA = a / 3, colA = a % 3;
                int rowB = b / 3, colB = b % 3;
                int rowC = c / 3, colC = c % 3;

                if (map[rowA][colA] == map[rowB][colB] && map[rowB][colB] == map[rowC][colC] && map[rowA][colA] != 1) {
                    if (winner == 0) {
                        g.drawImage(WinX, rowA * 210, colA * 210, 200, 200, null);
                        g.drawImage(WinX, rowB * 210, colB * 210, 200, 200, null);
                        g.drawImage(WinX, rowC * 210, colC * 210, 200, 200, null);
                    } else if (winner == 2) {
                        g.drawImage(WinO, rowA * 210, colA * 210, 200, 200, null);
                        g.drawImage(WinO, rowB * 210, colB * 210, 200, 200, null);
                        g.drawImage(WinO, rowC * 210, colC * 210, 200, 200, null);
                    }
                    break;
                }
            }
        }
    }
}