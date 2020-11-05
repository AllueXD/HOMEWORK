package lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JComponent implements ActionListener {
    private static Planet[] planets;

    //default array sets
    void setGravitation(Planet[] planets){
        planets[0].gravitation = 3.7;
        planets[1].gravitation = 8.9;
        planets[2].gravitation = 9.8;
        planets[3].gravitation = 1.6;
        planets[4].gravitation = 3.7;
        planets[5].gravitation = 23.1;
        planets[6].gravitation = 9.0;
        planets[7].gravitation = 8.7;
        planets[8].gravitation = 11.0;
        planets[9].gravitation = 0.6;
    }
    void setPlanets(Planet[] planet){
        planet[0] = new Planet(2439,0.330, "Меркурий");
        planet[1] = new Planet(6502,4.87,"Венера");
        planet[2] = new Planet(6378,5.97, "Земля");
        planet[3] = new Planet(1738,0.073,"Луна");
        planet[4] = new Planet(3390,0.642,"Марс");
        planet[5] = new Planet(71492, 1899, "Юпитер");
        planet[6] = new Planet(60250,568,"Сатурн");
        planet[7] = new Planet(25530,86.8, "Уран");
        planet[8] = new Planet(24700,102,"Нептун");
        planet[9] = new Planet(1195,0.0125,"Плутон");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++){
            if (planets[i].name == e.getActionCommand()){
                JOptionPane.showMessageDialog(new Main(), "Планета - " + planets[i].name +"\nМасса: " + planets[i].weight + "* 10^24 КГ\n" +
                                                                   "Радиус - " + planets[i].radius + " км\n" + "Гравитация на поверхности: " + planets[i].gravitation + "м/с^2");
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        planets = new Planet[10];
        //Planet[] planets = new Planet[10];
        main.setPlanets(planets);
        main.setGravitation(planets);

        //jframe sets
        JFrame jframe = new JFrame();
        jframe.setSize(900, 100);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.add(new Main());
        jframe.add(main);

        JToolBar menu = new JToolBar();
        for (int i = 0; i < 10; i++){
            Button button = new Button(planets[i].name);
            button.addActionListener(main);
            menu.add(button);

        }
        jframe.add(menu);

        jframe.setVisible(true);
    }
}
