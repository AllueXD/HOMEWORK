package lab17.GameSeaBattle.source;

import lab17.GameSeaBattle.Cell;
import lab17.GameSeaBattle.GameInterface;

import javax.swing.*;

public class Ship{
    private int sI = 0, sJ = 0, size = 0; //maxSize = 4
    public Cell[] ship;
    private Cell[][] playGround;
    private boolean vert = false, side = false;
    private GameInterface panel;

    void setPrivateTerritory(){
        if (this.size == 1){
            if (ship[0].j-1 >= 0)
            playGround[ship[0].i][ship[0].j-1].setStatus(3);
            if (ship[0].j+1 <= 9)
            playGround[ship[0].i][ship[0].j+1].setStatus(3);
            if (ship[0].i-1 >= 0 && ship[0].j-1 >= 0 )
            playGround[ship[0].i-1][ship[0].j-1].setStatus(3);
            if (ship[0].i+1 <= 9 && ship[0].j-1 >=0)
            playGround[ship[0].i+1][ship[0].j-1].setStatus(3);
            if (ship[0].i+1 <= 9 && ship[0].j+1 <= 9)
            playGround[ship[0].i+1][ship[0].j+1].setStatus(3);
            if (ship[0].i-1 >= 0)
            playGround[ship[0].i-1][ship[0].j].setStatus(3);
            if (ship[0].i+1 <= 9)
            playGround[ship[0].i+1][ship[0].j].setStatus(3);
            if (ship[0].i-1 >= 0 && ship[0].j+1 <= 9 )
            playGround[ship[0].i-1][ship[0].j+1].setStatus(3);

        }

        if (vert){
            for (int i = 0; i < this.size; i++){
                if (i == 0){
                    if (ship[i].j-1 >= 0)
                    playGround[ship[i].i][ship[i].j-1].setStatus(3);
                    if (ship[i].i-1 >= 0 && ship[i].j-1 >= 0 )
                    playGround[ship[i].i-1][ship[i].j-1].setStatus(3);
                    if (ship[i].i-1 >= 0)
                    playGround[ship[i].i-1][ship[i].j].setStatus(3);
                    if (ship[i].i+1 <= 9)
                    playGround[ship[i].i+1][ship[i].j].setStatus(3);
                    if (ship[i].i+1 <= 9 && ship[i].j+1 <= 9)
                    playGround[ship[i].i+1][ship[i].j+1].setStatus(3);
                    if (ship[i].i+1 <= 9 && ship[i].j-1 >= 0 )
                    playGround[ship[i].i+1][ship[i].j-1].setStatus(3);
                }else if (i == this.size-1){
                    if (ship[i].i-1 >= 0)
                    playGround[ship[i].i-1][ship[i].j].setStatus(3);
                    if (ship[i].i-1 >= 0 && ship[i].j+1 <= 9)
                    playGround[ship[i].i-1][ship[i].j+1].setStatus(3);
                    if (ship[i].j+1 <= 9)
                    playGround[ship[i].i][ship[i].j+1].setStatus(3);
                    if(ship[i].i+1 <= 9 && ship[i].j+1 <= 9 )
                    playGround[ship[i].i+1][ship[i].j+1].setStatus(3);
                    if (ship[i].i+1 <= 9)
                    playGround[ship[i].i+1][ship[i].j].setStatus(3);
                } else {
                    if (ship[i].i - 1 >= 0)
                    playGround[ship[i].i - 1][ship[i].j].setStatus(3);
                    if (ship[i].i + 1 <= 9)
                    playGround[ship[i].i + 1][ship[i].j].setStatus(3);
                }
            }
        }
         else if (side){
             for (int i = 0; i < this.size; i++){
                 if (i == 0){
                     if (ship[i].i-1 >= 0)
                     playGround[ship[i].i-1][ship[i].j].setStatus(3);
                     if (ship[i].i-1 >= 0 && ship[i].j-1 >= 0 )
                     playGround[ship[i].i-1][ship[i].j-1].setStatus(3);
                     if (ship[i].i-1 >= 0 && ship[i].j+1 <= 9 )
                     playGround[ship[i].i-1][ship[i].j+1].setStatus(3);
                     if (ship[i].j-1 >= 0)
                     playGround[ship[i].i][ship[i].j-1].setStatus(3);
                     if (ship[i].j+1 <= 9)
                     playGround[ship[i].i][ship[i].j+1].setStatus(3);
                 } else if (i == this.size - 1){
                     if (ship[i].j+1 <= 9)
                     playGround[ship[i].i][ship[i].j+1].setStatus(3);
                     if (ship[i].j-1 >= 0)
                     playGround[ship[i].i][ship[i].j-1].setStatus(3);
                     if (ship[i].i+1 <= 9 && ship[i].j+1 <= 9 )
                     playGround[ship[i].i+1][ship[i].j+1].setStatus(3);
                     if (ship[i].i+1 <= 9)
                     playGround[ship[i].i+1][ship[i].j].setStatus(3);
                     if (ship[i].j-1 >= 0)
                     playGround[ship[i].i][ship[i].j-1].setStatus(3);
                     if (ship[i].i+1 <= 9 && ship[i].j-1 >= 0)
                         playGround[ship[i].i+1][ship[i].j-1].setStatus(3);
                 } else {
                     if (ship[i].j+1 <= 9)
                     playGround[ship[i].i][ship[i].j+1].setStatus(3);
                     if (ship[i].j-1 >= 0)
                     playGround[ship[i].i][ship[i].j-1].setStatus(3);
                 }
             }
        }
    }

    boolean checkForLvl(){
        switch (this.size){
            case 4:
                if (panel.count4lvl == 1) {
                    JOptionPane.showMessageDialog(panel, "Четырехпалубный корабль уже установлен");
                    return true;
                }
                panel.count4lvl++;
                break;
            case 3:
                if (panel.count3lvl == 2){
                    JOptionPane.showMessageDialog(panel, "Все трехпалубные корабли установленны");
                    return true;
                }
                panel.count3lvl++;
                break;
            case 2:
                if (panel.count2lvl == 3){
                    JOptionPane.showMessageDialog(panel, "Все двухпалубные корабли установленны");
                    return true;
                }
                panel.count2lvl++;
                break;
            case 1:
                if (panel.count1lvl == 4){
                    JOptionPane.showMessageDialog(panel, "Все однопалубные корабли установленны");
                    return true;
                }
                panel.count1lvl++;
                break;
        }
        return false;
    }

    boolean checkForLvlR(){
        switch (this.size){
            case 4:
                if (panel.count4lvl == 1) {
                   // JOptionPane.showMessageDialog(panel, "Четырехпалубный корабль уже установлен");
                    return true;
                }
                panel.count4lvl++;
                break;
            case 3:
                if (panel.count3lvl == 2){
                    //JOptionPane.showMessageDialog(panel, "Все трехпалубные корабли установленны");
                    return true;
                }
                panel.count3lvl++;
                break;
            case 2:
                if (panel.count2lvl == 3){
                    //JOptionPane.showMessageDialog(panel, "Все двухпалубные корабли установленны");
                    return true;
                }
                panel.count2lvl++;
                break;
            case 1:
                if (panel.count1lvl == 4){
                    //JOptionPane.showMessageDialog(panel, "Все однопалубные корабли установленны");
                    return true;
                }
                panel.count1lvl++;
                break;
        }
        return false;
    }

    //Constructor for 4, 3, 2-level ships
    public Ship(int xTop, int yTop, int xLast, int yLast, Cell[][] playGround, GameInterface panel){
        this.panel = panel;
        this.playGround = playGround;

        if (xTop == xLast && yTop == yLast){
            this.size = 1;
            if (checkForLvl()){
                playGround[xTop][yTop].setStatus(0);
                playGround[xLast][yLast].setStatus(0);
                return;
            }
            ship = new Cell[1];
            ship[0] = playGround[xTop][yTop];
            ship[0].setStatus(1);
            setPrivateTerritory();
            return;
        }


        if (xTop == xLast){
            int biggest, lowest;
            this.side = false;
            this.vert = true;
            if (yTop - yLast < 4 && yTop - yLast >0){
                this.size = yTop - yLast + 1;
                if (checkForLvl()) {
                    playGround[xTop][yTop].setStatus(0);
                    playGround[xLast][yLast].setStatus(0);
                    return;
                }
                biggest = yTop;
                lowest = yLast;
            } else if (yLast - yTop < 4 && yLast - yTop > 0){
                this.size = yLast-yTop  + 1;
                if (checkForLvl()) {
                    playGround[xTop][yTop].setStatus(0);
                    playGround[xLast][yLast].setStatus(0);
                    return;
                }
                biggest = yLast;
                lowest = yTop;
            } else {
                JOptionPane.showMessageDialog(panel,"Неверно расставленны точки");
                playGround[xTop][yTop].setStatus(0);
                playGround[xLast][yLast].setStatus(0);
                return;
            }
            ship = new Cell[this.size];
            for (int i = 0; i < this.size; i++){
                ship[i] = playGround[xTop][lowest + i];
                ship[i].setStatus(1);
            }
            setPrivateTerritory();


        } else if (yTop == yLast){
            this.vert = false;
            this.side = true;
            int biggest = -1, lowest = -1;
            if (xTop - xLast <4 && xTop - xLast > 0){
                this.size = xTop - xLast  +1;
                if (checkForLvl()) {
                    playGround[xTop][yTop].setStatus(0);
                    playGround[xLast][yLast].setStatus(0);
                    return;
                }
                biggest = xTop;
                lowest = xLast;
            } else if (xLast - xTop < 4 && xLast - xTop >0){
                this.size = xLast-xTop  + 1;
                if (checkForLvl()) {
                    playGround[xTop][yTop].setStatus(0);
                    playGround[xLast][yLast].setStatus(0);
                    return;
                }
                biggest = xLast;
                lowest = xTop;
            } else {
                JOptionPane.showMessageDialog(panel,"Неверно расставленны точки");
                playGround[xTop][yTop].setStatus(0);
                playGround[xLast][yLast].setStatus(0);
                return;
            }
            ship = new Cell[this.size];
            for (int i = 0; i < this.size; i++){
                ship[i] = playGround[lowest + i][yLast];
                ship[i].setStatus(1);
            }
            setPrivateTerritory();
        } else {
            playGround[xTop][yTop].setStatus(0);
            playGround[xLast][yLast].setStatus(0);
            JOptionPane.showMessageDialog(panel,"Неверно расставленны точки");
            return;
        }
    }

    public Ship(int xTop, int yTop, int xLast, int yLast, Cell[][] playGround, GameInterface panel, int kk){
        this.panel = panel;
        this.playGround = playGround;

        if (xTop == xLast && yTop == yLast){
            this.size = 1;
            if (checkForLvlR()){
                playGround[xTop][yTop].setStatus(0);
                playGround[xLast][yLast].setStatus(0);
                return;
            }
            ship = new Cell[1];
            ship[0] = playGround[xTop][yTop];
            ship[0].setStatus(1);
            setPrivateTerritory();
            return;
        }


        if (xTop == xLast){
            int biggest, lowest;
            this.side = false;
            this.vert = true;
            if (yTop - yLast < 4 && yTop - yLast >0){
                this.size = yTop - yLast + 1;
                if (checkForLvlR()) {
                    playGround[xTop][yTop].setStatus(0);
                    playGround[xLast][yLast].setStatus(0);
                    return;
                }
                biggest = yTop;
                lowest = yLast;
            } else if (yLast - yTop < 4 && yLast - yTop > 0){
                this.size = yLast-yTop  + 1;
                if (checkForLvlR()) {
                    playGround[xTop][yTop].setStatus(0);
                    playGround[xLast][yLast].setStatus(0);
                    return;
                }
                biggest = yLast;
                lowest = yTop;
            } else {
               // JOptionPane.showMessageDialog(panel,"Неверно расставленны точки");
                playGround[xTop][yTop].setStatus(0);
                playGround[xLast][yLast].setStatus(0);
                return;
            }
            ship = new Cell[this.size];
            for (int i = 0; i < this.size; i++){
                ship[i] = playGround[xTop][lowest + i];
                ship[i].setStatus(1);
            }
            setPrivateTerritory();


        } else if (yTop == yLast){
            this.vert = false;
            this.side = true;
            int biggest = -1, lowest = -1;
            if (xTop - xLast <4 && xTop - xLast > 0){
                this.size = xTop - xLast  +1;
                if (checkForLvlR()) {
                    playGround[xTop][yTop].setStatus(0);
                    playGround[xLast][yLast].setStatus(0);
                    return;
                }
                biggest = xTop;
                lowest = xLast;
            } else if (xLast - xTop < 4 && xLast - xTop >0){
                this.size = xLast-xTop  + 1;
                if (checkForLvlR()) {
                    playGround[xTop][yTop].setStatus(0);
                    playGround[xLast][yLast].setStatus(0);
                    return;
                }
                biggest = xLast;
                lowest = xTop;
            } else {
               // JOptionPane.showMessageDialog(panel,"Неверно расставленны точки");
                playGround[xTop][yTop].setStatus(0);
                playGround[xLast][yLast].setStatus(0);
                return;
            }
            ship = new Cell[this.size];
            for (int i = 0; i < this.size; i++){
                ship[i] = playGround[lowest + i][yLast];
                ship[i].setStatus(1);
            }
            setPrivateTerritory();
        } else {
            playGround[xTop][yTop].setStatus(0);
            playGround[xLast][yLast].setStatus(0);
            //JOptionPane.showMessageDialog(panel,"Неверно расставленны точки");
            return;
        }
    }
}
