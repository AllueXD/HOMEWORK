package lab17.GameSeaBattle;

import javax.swing.*;
import java.awt.*;

public class Cell {
    Image currentImage;
    Image cellImage = new ImageIcon("lab17/GameSeaBattle/source/Cell.png").getImage();
    Image shipImage = new ImageIcon("lab17/GameSeaBattle/source/Ship.png").getImage();
    Image busyCell = new ImageIcon("lab17/GameSeaBattle/source/Busy.png").getImage();
    Image activeCell = new ImageIcon("lab17/GameSeaBattle/source/ChosenCell.png").getImage();
    Image waterCell = new ImageIcon("lab17/GameSeaBattle/source/Water.png").getImage();
    Image missedShot = new ImageIcon("lab17/GameSeaBattle/source/Missed.png").getImage();
    Image beatShip = new ImageIcon("lab17/GameSeaBattle/source/BurningShip.png").getImage();
    public int i,j;
    public int status = 0; //0 - Cell, 1 - ship, 2 when focused on, 3 - already taken
    public int visible = 0; // 0-invis, 1 - vis

    public void setStatus(int stat){
        switch (stat){
            case 0:
                this.currentImage = cellImage;
                break;
            case 1:
                this.currentImage = shipImage;
                break;
            case 2:
                this.currentImage = activeCell;
                break;
            case 3:
                this.currentImage = busyCell;
                break;
            case 4:
                this.currentImage = missedShot;
                break;
            case 5:
                this.currentImage = beatShip;
        }
        this.status = stat;
    }

    public Cell(){}
    public Cell(int i, int j){
        this.i = i;
        this.j = j;
        this.currentImage = cellImage;
    }
}
