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
    Image wallBrickStone = new ImageIcon("lab17/game/src/Brick.png").getImage();
    Image stairsImage = new ImageIcon("lab17/game/src/Stair.png").getImage();
    Image antImage = new ImageIcon("lab17/game/src/Ant.png").getImage();

    Image playGround[][] = new Image[25][11];
    /////////////////////////////////////////////////////

    //vars
    Timer timer = new Timer(60, this);
    //////////////////////////////////////////////////////

    //Personage movement
    private int cX = 100, cY = 0, cI = 2, cJ = 0, cW = 40, cH = 40; //x, y - Положение на экране, i,j - Положение на массиве playGround
    ////////////////////////////////////////////////////////


    public void fillPlayGround(){
        for (int i = 0; i < 25; i++){
          //Заполнение ход. полей
          for (int j = 1; j <= 9; j+=2){
            playGround[i][j] = wallBrickStone;
          }
            //Заполняем границы и этажи
            for (int j = 0; j <=10; j+=2){
                playGround[i][j] = wallBlackStone;
            }
            if (i < 11){
                playGround[0][i] = wallBlackStone;
                playGround[24][i] = wallBlackStone;
            }
        }

        playGround[2][0] = stairsImage;
        playGround[16][2] = stairsImage;
        playGround[9][4] = stairsImage;
        playGround[10][6] = stairsImage;
        playGround[21][8] = stairsImage;
    }

    public void paint(Graphics g){
        Graphics2D gr = (Graphics2D)g;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 11; j++) {
                gr.drawImage(playGround[i][j], i * 50, j*50, 50, 50, null);
            }
        }
        gr.drawImage(antImage, cX, cY, cW,cH, null);

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
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
          if ((cX + 100 != 1250) && (playGround[cI+1][cJ] != wallBlackStone)){
            cX += 10;
            System.out.println("Right->cX = " + cX);
            if (cX % 50 == 0){
              cI++;
              System.out.println("Right->cI = " +cI);
            }
          }
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
          if ((cX - 50 != 0) && (playGround[cI-1][cJ] != wallBlackStone)){
            cX -=10;
            System.out.println("Left->cX = " + cX);
            if (cX % 50 == 0){
              cI--;
              System.out.println("Left->cI = " + cI);
            }
          }
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            if ((playGround[cI][cJ] == stairsImage) || (playGround[cI][cJ-1] == stairsImage)){
              cY+=10;
              System.out.println("Down->cY = " + cY);
              if (cY % 50 == 0){
                cJ++;
                System.out.println("Down->cJ = " + cJ);
              }
            }
        }
        if (e.getKeyCode()==KeyEvent.VK_UP){
          if ((playGround[cI][cJ] == stairsImage) || (playGround[cI][cJ-1] == stairsImage)){
            cY -= 10;
            System.out.println("Up->cY = " + cY);
            if (cY % 50 == 0){
              cJ--;
              System.out.println("Up->cJ = " + cJ);
            }
          }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
