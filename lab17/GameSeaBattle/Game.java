package lab17.GameSeaBattle;

import javax.swing.*;
import java.awt.*;

public class Game extends JComponent {

    public void paint(Graphics g){
        Graphics2D gr = (Graphics2D)g;

    }

    public Game(){}


    public static void main(String[] args) {
        Game game = new Game();

        JFrame frame = new JFrame("2047");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(game);

        frame.setVisible(true);
    }
}
