package lab8_3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Animation extends JFrame {
    protected static Image image;
    private static JFrame jFrame;
    private static String text;
    protected static ArrayList<Image> framlist = new ArrayList<>();

    Animation(){
        super("Test");
        setLayout(new FlowLayout());
        setSize(1280,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gr2d = (Graphics2D) g;
        gr2d.drawImage(image,0,0, 1280, 800, null);
    }
}
