package edu.homeCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
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
        initGame();
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(inGame){
            g.drawImage(apple,appleX,appleY,this);
            for(int i=0; i<dots; i++){
                g.drawImage(dot,x[i],y[i],this);
            }
        }
    }

    // движение змейки
public void move(){
    for (int i = dots; i >0 ; i--) {
        x[i] = x[i-1];
        y[i] = y[i-1];
    }
    if(right){
        x[0] -= DOT_SIZE;
    }
    if(right){
        x[0] += DOT_SIZE;
    }
    if(up){
        y[0] -= DOT_SIZE;
    }
    if(down){
        y[0] += DOT_SIZE;
    }
}

    @Override // метод который срабатывает каждые 250 сек
    public void actionPerformed(ActionEvent e) {
        if (inGame){
            move();

        }
        repaint(); // метод перерисовывает поле
    }
}
