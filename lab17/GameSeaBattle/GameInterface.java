package lab17.GameSeaBattle;

import lab17.GameSeaBattle.source.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameInterface extends JPanel implements MouseListener, ActionListener {
    private int pgSize = 0, imgSize = 0;
    private Cell[][] playGround;
    private int shipTopX2 = -1, shipTopY2 = -1;
    private int shipTopX = -1, shipTopY = -1;
    public int count4lvl = 0, count3lvl = 0, count2lvl=0, count1lvl=0;
    private Timer timer = new Timer(5, this);
    public boolean shoot = false, setShips = false;
    public GameInterface bot, player;
    public int totalShipCells =  20;
    public Game game;

    void setBot(GameInterface bot){
        this.bot = bot;
    }
    void setPlayer(GameInterface player){
        this.player = player;
    }

    void fillPlayGround(){
        this.playGround = new Cell[pgSize][pgSize];
        for (int i = 0; i < pgSize; i++){
            for (int j = 0; j <pgSize; j++){
                playGround[i][j] = new Cell(i, j);
            }
        }
    }

    void setVisible(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                playGround[i][j].visible = 1;
            }
        }
        repaint();
    }

    void recieveShot(int x, int y){
         x /= 50; y /=50;

         if (playGround[x][y].status != 1 && playGround[x][y].status != 5){
             playGround[x][y].setStatus(4);
             playGround[x][y].visible = 1;
         }
         if (playGround[x][y].status == 1){
             playGround[x][y].setStatus(5);
             this.totalShipCells--;
             System.out.println(this.totalShipCells +" - left");
             playGround[x][y].visible = 1;
         }
    }

    void setNewShipR(int x, int y){
        if (shipTopX == -1 && shipTopY == -1 && (playGround[x/50][y/50].status != 1) && (playGround[x/50][y/50].status != 3) ){
            shipTopX = x;
            shipTopY = y;
            playGround[x/50][y/50].setStatus(2);
            repaint();
        }
        else  if (shipTopX2 == -1 &&  shipTopY2 == -1 && (playGround[x/50][y/50].status != 1) && (playGround[x/50][y/50].status != 3)){
            shipTopX2 = x;
            shipTopY2 = y;
            playGround[x/50][y/50].setStatus(2);
           // repaint();
           // JOptionPane.showMessageDialog(this, "Установить корабль");
            int newX1 = shipTopX / imgSize;
            int newY1 = shipTopY / imgSize;
            int newX2 = shipTopX2 / imgSize;
            int newY2 = shipTopY2 / imgSize;
            Ship ship = new Ship(newX1, newY1, newX2, newY2, playGround, this, 1);
            shipTopX2 = -1;
            shipTopY2 = -1;
            shipTopX = -1;
            shipTopY = -1;
            repaint();
        } else {
            playGround[shipTopX/imgSize][shipTopY/50].setStatus(0);
            playGround[shipTopX2/50][shipTopY2/50].setStatus(0);
            shipTopX2 = -1;
            shipTopY2 = -1;
            shipTopX = -1;
            shipTopY = -1;
            return;
        }
    }

    void setNewShip(int x, int y){
        if (shipTopX == -1 && shipTopY == -1 && (playGround[x/50][y/50].status != 1) && (playGround[x/50][y/50].status != 3) ){
            shipTopX = x;
            shipTopY = y;
            playGround[x/50][y/50].setStatus(2);
            repaint();
        }
        else  if (shipTopX2 == -1 &&  shipTopY2 == -1 && (playGround[x/50][y/50].status != 1) && (playGround[x/50][y/50].status != 3)){
            shipTopX2 = x;
            shipTopY2 = y;
            playGround[x/50][y/50].setStatus(2);
            repaint();
            JOptionPane.showMessageDialog(this, "Установить корабль");
            int newX1 = shipTopX / imgSize;
            int newY1 = shipTopY / imgSize;
            int newX2 = shipTopX2 / imgSize;
            int newY2 = shipTopY2 / imgSize;
            Ship ship = new Ship(newX1, newY1, newX2, newY2, playGround, this);
            shipTopX2 = -1;
            shipTopY2 = -1;
            shipTopX = -1;
            shipTopY = -1;
            repaint();
        } else {
            playGround[shipTopX/imgSize][shipTopY/50].setStatus(0);
            playGround[shipTopX2/50][shipTopY2/50].setStatus(0);
            shipTopX2 = -1;
            shipTopY2 = -1;
            shipTopX = -1;
            shipTopY = -1;
            JOptionPane.showMessageDialog(this, "Корабль не может быть установлен в заданных координатах");
            return;
        }
    }

    void drawPlayGround(Graphics2D gr){
        for (int i = 0; i < pgSize; i++){
            for (int j = 0; j <pgSize; j++){
                if (playGround[i][j].visible == 1) {
                    gr.drawImage(playGround[i][j].currentImage, i * imgSize, j * imgSize, imgSize, imgSize, null);
                } else {
                    gr.drawImage(playGround[i][j].waterCell, i * imgSize, j * imgSize, imgSize, imgSize, null);
                }
            }
        }
    }

    void clearPlayGroundOfRed(){
        for (int i = 0 ; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (playGround[i][j].status == 3){
                    playGround[i][j].setStatus(0);
                }
            }
        }
    }

    void generateRandomShips(){
        Random random = new Random();
        while (this.getTotalShips() != 10){
            int x = random.nextInt(500);
            int y = random.nextInt(500);
            setNewShipR(x, y);
        }
    }

    void randomShoot(){
        Random random = new Random();
        int x = random.nextInt(500);
        int y = random.nextInt(500);
        while (player.playGround[x/50][y/50].status == 4){
            x = random.nextInt(500);
            y = random.nextInt(500);
        }
        player.recieveShot(x, y);
    }

    int getTotalShips(){
        return (count1lvl + count3lvl + count4lvl + count2lvl);
    }

    public void paint(Graphics g){
        Graphics2D gr = (Graphics2D)g;
        drawPlayGround(gr);
        timer.start();
       // Ship ship = new Ship(0,0,250/50,0,playGround);
    }

    public GameInterface(int pgSize, int imgSize){
        this.pgSize = pgSize;
        this.imgSize = imgSize;
        fillPlayGround();
        setMinimumSize(new Dimension(500, 500));
        setPreferredSize(new Dimension(500, 500));
        setMaximumSize(new Dimension(500, 500));
        addMouseListener(this);
    }

    public void setGame(Game game){
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
        if (this.setShips) {
            setNewShip(e.getX(), e.getY());
        }
        if (player.shoot) {
                this.recieveShot(e.getX(), e.getY());
                player.shoot = false;
                this.randomShoot();
                game.iter += 1;
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
