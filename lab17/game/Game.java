package lab17.game;

//39 - размер шапки окна фрейма


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JComponent implements KeyListener, ActionListener {
    //Images
    Image wallBlackStone = new ImageIcon("lab17/game/src/Stone.jpg").getImage();
    Image playGround[][] = new Image[25][11];
    //Images//
    //vars
    Timer timer = new Timer(60, this);

    //Movable
    private int cX = 0, cY = 0, cI = 0, cJ = 0, cW = 50, cH = 50; //x, y - Положение на экране, i,j - Положение на массиве playGround



    public void fillPlayGround(){
        for (int i = 0; i < 25; i++){
            //Заполняем границы и этажи
            for (int j = 0; j <=10; j+=2){
                playGround[i][j] = wallBlackStone;
            }
            if (i < 11){
                playGround[0][i] = wallBlackStone;
                playGround[24][i] = wallBlackStone;
            }


        }

        

    }

    public void paint(Graphics g){
        Graphics2D gr = (Graphics2D)g;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 11; j++) {
                gr.drawImage(playGround[i][j], i * 50, j*50, 50, 50, null);
            }
        }

        //gr.drawImage(car, cX, cY, cW,cH,null);
        gr.drawImage(wallBlackStone,0,0,50,50,null);
        timer.start();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.fillPlayGround();

        JFrame jframe = new JFrame("Game"); //Создаем окно
        jframe.setSize(1250, 39+50*11);   //Размер окна //Отредактировать размер позже под меню (начало, пауза и т.п.) ...
        jframe.setLocationRelativeTo(null);     //Размещаем окно по центру экрана
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Выход из программы по закрытию окна
        jframe.addKeyListener(game); //Добавляем слушатель нажатий клавиш
        jframe.add(new Game());      //Добавляем класс
        jframe.add(game);           //Добавляем сам обьект


        jframe.setVisible(true);    //Отображаем окно
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       /* if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            //playGround[5][5] = new ImageIcon("C:/Users/COMPUTER/Documents/GitHub/HOMEWORK/lab17/game/src/Grass2.jpg").getImage();
            playGround[cI][cJ] = grass1;
            playGround[cI][cJ+1] = grass1;
            cX+=25;
            cI++;
        }
        if (e.getKeyCode()==KeyEvent.VK_UP){
            //playGround[5][5] = new ImageIcon("C:/Users/COMPUTER/Documents/GitHub/HOMEWORK/lab17/game/src/Grass2.jpg").getImage();
            playGround[cI][cJ+1] = grass1;
            playGround[cI+1][cJ+1] = grass1;
            cY-=25;
            cJ--;
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            //playGround[5][5] = new ImageIcon("C:/Users/COMPUTER/Documents/GitHub/HOMEWORK/lab17/game/src/Grass2.jpg").getImage();
            playGround[cI+1][cJ] = grass1;
            playGround[cI+1][cJ+1] = grass1;
            cX-=25;
            cI--;
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            //playGround[5][5] = new ImageIcon("C:/Users/COMPUTER/Documents/GitHub/HOMEWORK/lab17/game/src/Grass2.jpg").getImage();
            playGround[cI][cJ] = grass1;
            playGround[cI+1][cJ] = grass1;
            cY+=25;
            cJ++;
        }*/

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
