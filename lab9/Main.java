package lab9;

import lab9.Surface;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {

    public Main() {
        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Colours");
        setSize(360, 300);
       // setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Main ex = new Main();
                ex.setVisible(true);
            }
        });
    }
}