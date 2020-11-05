package lab8_2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Main extends JComponent{
   static String imagePath; // = "C:/Users/Computer/Documents/GitHub/HOMEWORK/lab8_2/image.jpg";


    public void paint(Graphics g){
        Graphics2D gr = (Graphics2D)g;
        Image image = new ImageIcon(imagePath).getImage();
        gr.drawImage(image,0,0, null);
    }

    public static void main(String[] args) throws IOException {
        if (args.length > 0){
            imagePath = args[0];
        } else {
            imagePath = "C:/Users/Computer/Documents/GitHub/HOMEWORK/lab8_2/image.jpg";
        }
        Main t = new Main();
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.add(t);
        frame.setVisible(true);
    }
    Main(){}
}
