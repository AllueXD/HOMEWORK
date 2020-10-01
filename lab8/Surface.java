package lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

class Surface extends JPanel {

    public void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        Random random = new Random();
        int x = 10; int y = 10;

        for (int i = 0; i < 20; i++){
            int shape = random.nextInt(6);
            Color color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());

            switch(shape){
                case 0:
                    g2d.setColor(color);
                    g2d.fillRect(x, y, 20, 20);
                    break;
                case 1:
                    g2d.setColor(color);
                    g2d.fillRoundRect(x, y, 20, 20, 5, 5);
                    break;
                case 2:
                    g2d.setColor(color);
                    g2d.fillArc(x, y,20, 20,45,180);
                    break;
                case 3:
                    g2d.setColor(color);
                    g2d.fillOval(x, y, 20, 20);
                    break;
                case 4:
                    g2d.setColor(color);
                    g2d.fillRect(x, y, 20, 40);
                    break;
                case 5:
                    g2d.setColor(color);
                    g2d.fill(new Ellipse2D.Double(x, y, 20, 20));
                    break;
            }
            if (i != 4 || i != 9 || i != 14 || i != 19){
                x += 40;
            } else {
                x = 10;
                y += 40;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}