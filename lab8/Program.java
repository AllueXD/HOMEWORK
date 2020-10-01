package lab8;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Program extends JFrame {

    public Program() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Colours");
        setSize(360, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Program ex = new Program();
                ex.setVisible(true);
            }
        });
    }
}