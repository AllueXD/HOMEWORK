package lab17.GameSnake;

import javax.swing.*;
import java.awt.*;




public class Cell {
    ////////////////{images}\\\\\\\\\\\\\\\\\
    public Image mainImage;
    static Image cellTexture = new ImageIcon("lab17/GameSnake/src/Cell.png").getImage();
    static Image foodTexture = new ImageIcon("lab17/GameSnake/src/Food.png").getImage();
    public static Image snakeTexture = new ImageIcon("lab17/GameSnake/src/Snake.png").getImage();

    ///////////////{vars}\\\\\\\\\\\\\\\\\\\\\\
    private int status; // 0 - cell, 1 - snake, '-1' - food
    private int  sI, sJ;   //i, j - position on playground

    /////////////{Sets}///////////////////
    public void setIJ(int sI, int sJ){
        this.sI = sI;
        this.sJ = sJ;
    }
    public void setsI(int sI) {
        this.sI = sI;
    }
    public void setsJ(int sJ) {
        this.sJ = sJ;
    }

    //changing picture by status
    public void setStatus(int status) {
        switch(status){
            case -1:
                this.mainImage = foodTexture;
                break;
            case 0:
                this.mainImage = cellTexture;
                break;
            case 1:
                this.mainImage = snakeTexture;
                break;
        }
        System.out.println(status);
        this.status = status;
    }

    ////////////{Gets}///////////////////
    public int getsI() {
        return sI;
    }
    public int getsJ() {
        return sJ;
    }
    public int getStatus() {
        return status;
    }
    public Image getMainImage() {
        return mainImage;
    }

    //////////{Constructors}/////////////////
    public Cell(int i, int j, int status){
        this.sI = i;
        this.sJ = j;
        this.status = status;
    }
    public Cell(){
        this.mainImage = cellTexture;
        this.status = 0;
    }
}
