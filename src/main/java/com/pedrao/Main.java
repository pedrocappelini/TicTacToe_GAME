package com.pedrao;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main extends Canvas implements Runnable, KeyListener{

    Gameplay game = new Gameplay();

    public static int WIDTH = 620;
    public static int HEIGHT = 620;

    public static BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    public static BufferedImage SpriteSheet;
    public static BufferedImage Background;
    public static BufferedImage SelectedButton;
    public static BufferedImage Xbutton;
    public static BufferedImage Obutton;
    public static BufferedImage WinX;
    public static BufferedImage WinO;
    public static BufferedImage SelectX;
    public static BufferedImage SelectO;
    public static BufferedImage DrawX;
    public static BufferedImage DrawO;
    

    static{
        try {
            SpriteSheet = ImageIO.read((Main.class.getResource("/Sprite-0006.png")));
            Background = SpriteSheet.getSubimage(0, 0, 62, 62);
            SelectedButton = SpriteSheet.getSubimage(0, 64, 20, 20);
            Xbutton = SpriteSheet.getSubimage(21, 64, 20, 20);
            Obutton = SpriteSheet.getSubimage(42, 64, 20, 20);
            WinO = SpriteSheet.getSubimage(63, 64, 20, 20);
            WinX = SpriteSheet.getSubimage(63, 85, 20, 20);
            SelectX = SpriteSheet.getSubimage(21, 85, 20, 20);
            SelectO = SpriteSheet.getSubimage(42, 85, 20, 20);
            DrawX = SpriteSheet.getSubimage(84, 85, 20, 20);
            DrawO = SpriteSheet.getSubimage(84, 64, 20, 20);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.setupFrame();
        new Thread(main).start();
    }
    
    public Main(){
        setPreferredSize(new Dimension(WIDTH + 16,HEIGHT+ 38));  //636 x 658 because of upper bar
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener(this);
        setFocusable(true);
    }

    public void setupFrame(){
        JFrame frame = new JFrame("foda");
        frame.setUndecorated(false);
        frame.setMinimumSize(getMinimumSize());
        frame.setSize(getPreferredSize());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
    }

    int row = 0;
    int col = 0;

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(getBufferStrategy() == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g;
        g = bs.getDrawGraphics();
        if(Background != null){
            g.drawImage(Background, 0, 0, WIDTH, HEIGHT, null);
        }else{
            g.drawImage(layer, 0, 0, WIDTH, HEIGHT, null);
        }
        game.render(g,row,col,SelectedButton,Xbutton,Obutton,WinX,WinO,SelectX,SelectO,DrawX,DrawO);

        g.dispose();
        bs.show();
    }

    public void run() {
        while (true) {
            render();
            try {
                Thread.sleep(16); //60 fps
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            if (col < 2) {
                col++;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            if (col > 0) {
                col--;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            if (row < 2) {
                row++;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            if (row > 0) {
                row--;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            Gameplay.enter = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            Gameplay.reset = true;
        }
    }
}