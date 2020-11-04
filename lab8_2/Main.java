package lab8_2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException {
        String imagePath = "C:/Users/Computer/Documents/GitHub/HOMEWORK/lab8_2/image.jpg";
        BufferedImage image = ImageIO.read(new File(imagePath));
        JLabel picLabel = new JLabel(new ImageIcon(image));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);
        JFrame f = new JFrame();
        f.setSize(new Dimension(image.getWidth(), image.getHeight()));
        f.add(jPanel);
        f.setVisible(true);
    }
}
