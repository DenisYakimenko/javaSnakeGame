package edu.homeCourse;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameField extends JPanel {
    private final int SIZE = 320;// макс размер поля
    private final int DOT_SIZE = 16;// размер ячейки
    private final int ALL_DOTS = 400;
    private Image dot;
    private Image apple;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;

    public GameField(){
        setBackground(Color.black);
        loadImages();
    }

    public void initGame(){
        dots =3;
        for(int i =0; i<dots; i++){
            x[i]=48 - i*DOT_SIZE; //начальные значения змейки
            y[i]=48;
        }
        timer = new Timer(250,this);
        timer.start();
        createApple();

    }

    public void createApple(){
        appleX = new Random().nextInt(20)*DOT_SIZE;
        appleY = new Random().nextInt(20)*DOT_SIZE;
    }

public void loadImages(){
    ImageIcon iia = new ImageIcon("apple.png");
    apple = iia.getImage();

    ImageIcon iid = new ImageIcon("dot.png");
    apple = iid.getImage();

}

}
