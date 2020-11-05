package lab11;

//

import lab1.random.RandomArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

public class Main extends JComponent {
    int secretNumber = 0, iteration = 0;
    public void setSecretNumber(){
        Random random = new Random();
        secretNumber = random.nextInt(21);
    }
    public boolean checkGame(int userNumber){
        if (userNumber == secretNumber){
            return true;
        } else {
            return false;
        }
    }

    public void playGame(int i, String txt){
        int userNumber;
        try {
            userNumber = Integer.parseInt(txt);
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(Main.this, "Ошибка ввода. Введите число от 0 до 20");
            return;
        }
        System.out.println("Converted int: " + userNumber);
        if (userNumber == secretNumber ){
            JOptionPane.showMessageDialog(Main.this, "Вы угадали число!\nЗагаданное число - " + secretNumber);
            this.setVisible(false);
            System.exit(0);
            return;
        } else if (i < 3){
            int t = 3 - i;
            JOptionPane.showMessageDialog(Main.this, "Вы ошиблись.\nПопытки: " + t);
            return;
        } else if (i == 3){
            JOptionPane.showMessageDialog(Main.this, "Вы ошиблись.\nИгра окончена.\nЗагаданное число - " + secretNumber);
            System.exit(0);
            return;
        }
        return;
    }

    public void startGame(){
        iteration = 0;
        setSecretNumber();
        System.out.println(secretNumber);
    }

    public JTextField setTextField() {
        JTextField text = new JTextField("Введите число от 0 до 20",25);
        text.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                text.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                text.setText("Введите число от 0 до 20");
            }
        });
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = text.getText();
                System.out.println("Recieved string: "+ txt);
                iteration++;
                playGame(iteration,txt);
            }
        });
        return text;
    }
    public JFrame setFrameWindow(){
        JFrame frame = new JFrame("Угадайка");
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setSize(310, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return frame;
    }

    public static void main(String[] args) {
        Main main = new Main();
        JFrame frame = main.setFrameWindow();
        JTextField text = main.setTextField();
        frame.add(text);
        main.startGame(); // Начало игры
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //JOptionPane.showMessageDialog(main, "У вас есть 3 попытки чтобы угадать случайное число");

    }
}
