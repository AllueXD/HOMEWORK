package lab8_3;

import javax.swing.*;

public class Main extends Animation{
    public static void main(String[] args) {

        Animation animImg = new Animation();
        animImg.framlist.add(new ImageIcon("C:/Users/Computer/Documents/GitHub/HOMEWORK/lab8_3/1.png").getImage());
        animImg.framlist.add(new ImageIcon("C:/Users/Computer/Documents/GitHub/HOMEWORK/lab8_3/2.png").getImage());
        animImg.framlist.add(new ImageIcon("C:/Users/Computer/Documents/GitHub/HOMEWORK/lab8_3/3.png").getImage());

        while (true) {
            for (int i = 0; i < 3; i++) {
                image = animImg.framlist.get(i);
                animImg.repaint();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}