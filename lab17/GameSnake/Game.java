package lab17.GameSnake;

//Menu


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Random;


public class Game extends JComponent implements KeyListener, ActionListener{
    /////////////////{Vars}//////////////////
    public Cell playGround[][];
    public Snake snake;
    Timer timer = new Timer(150, this);
    public int sSize = 0, imageSize = 0;

    //////////////////{sets}/////////////////
    public void setSnake(){
        Snake snake = new Snake(1, sSize-1, playGround);
        this.snake = snake;
    }

    //////////////////{playGround}//////////////////////
    private void drawPlayground(Graphics2D gr){
        for (int i = 0; i < sSize; i++){
            for (int j = 0; j < sSize; j++){
                gr.drawImage(playGround[i][j].getMainImage(), i*imageSize, j*imageSize, imageSize, imageSize, null);
            }
        }
    }
    private void fillPlayGround(){
        this.playGround = new Cell[sSize][sSize];
        for (int i = 0; i < sSize; i++){
            for (int j = 0; j < sSize; j++){
                playGround[i][j] = new Cell();
                playGround[i][j].setIJ(i, j);
            }
        }
    }
    public void generateSingleFood(){
        Random random = new Random();
        int x = random.nextInt(sSize);
        int y = random.nextInt(sSize);
        while (snake.snake.contains(playGround[x][y])){
            x = random.nextInt(sSize);
            y = random.nextInt(sSize);

        }
        playGround[x][y].setStatus(-1);
    }
    private void generateRandomFood(){
        Random random = new Random();

        for (int i = 0; i < sSize/2; i++){
            int x = random.nextInt(sSize);
            int y = random.nextInt(sSize);
            playGround[x][y].setStatus(-1);
        }

    }

    //////////////{Constructor}/////
    public Game(int sSize, int imageSize){
        this.imageSize = imageSize;
        this.sSize = sSize;
    }
    public final void startGame(){
        this.fillPlayGround();
        this.setSnake();
        this.generateRandomFood();
        this.snake.setFrame(this);
    }

    /////paint /////
    public void paint(Graphics g){
        Graphics2D gr = (Graphics2D)g;
        drawPlayground(gr);
        snake.moveSnake(snake.LastMoveKey);
        timer.start();
    }

    //////////////////main/////////////////////////
    public static void main(String[] args) {
        Game game = new Game(10, 50);
        game.startGame();

        Game game2 = new Game(20, 25);
        game.startGame();

        JFrame frame = new JFrame("GAME");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        //frame.add(new Game());
        frame.add(game);
     //   frame.add(game2);
        frame.pack();
        frame.addKeyListener(game);
        frame.setVisible(true);
     }

    /////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        snake.moveSnake(KeyEvent.VK_SPACE);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        snake.moveSnake(e.getKeyCode());
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
