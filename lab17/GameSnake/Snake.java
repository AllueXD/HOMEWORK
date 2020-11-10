package lab17.GameSnake;

import lab17.GameSnake.Cell;
import lab17.GameSnake.Game;

import java.awt.event.KeyEvent;
import java.util.*;

public class Snake {
    //{Var}\\
    public Vector<Cell> snake = new Vector<Cell>();
    public Cell[][] playGround;
    private Game frame;
    public int LastMoveKey = KeyEvent.VK_RIGHT;

    ///////////{Gets}//////////////
    int getOppositeMoveKey(){
        switch (LastMoveKey){
            case KeyEvent.VK_LEFT:
                return KeyEvent.VK_RIGHT;
            case KeyEvent.VK_RIGHT:
                return KeyEvent.VK_LEFT;
            case KeyEvent.VK_UP:
                return KeyEvent.VK_DOWN;
            case KeyEvent.VK_DOWN:
                return KeyEvent.VK_UP;

        }
        return KeyEvent.VK_SPACE;
    }
    private Cell getSnakeHead(){
        return snake.elementAt(snake.size()-1);
    }

    //////////{Sets}///////////////
    public void setFrame(Game frame){
        this.frame = frame;
    }

    ////////////{Snake works}////////
    private void renderSnake(){
        /*for (int i = 0; i < snake.size(); i++){
            snake.elementAt(i).setStatus(1);
        }*/
        snake.elementAt(0).setStatus(1);
        snake.elementAt(snake.size()-1).setStatus(1);
    }
    public void moveSnake(int direction){
        if (getOppositeMoveKey() == direction){
            return;
        }
        LastMoveKey = direction;
        Cell head = getSnakeHead();
        Cell last = snake.elementAt(0);
        int nextX = -1, nextY = -1;
        switch (direction){
            case KeyEvent.VK_UP:
                nextX = head.getsI();
                nextY = head.getsJ() -1;
                System.out.println("U-> " + nextX +" "+ nextY);
                break;
            case KeyEvent.VK_RIGHT:
                nextX = head.getsI()+1;
                nextY = head.getsJ();
                System.out.println("R-> " + nextX + " "+nextY);
                break;
            case KeyEvent.VK_DOWN:
                nextX = head.getsI();
                nextY = head.getsJ()+1;
                System.out.println("D-> " + nextX + " "+nextY);
                break;
            case KeyEvent.VK_LEFT:
                nextX = head.getsI()-1;
                nextY = head.getsJ();
                System.out.println("R-> " + nextX + " "+nextY);
                break;
            case KeyEvent.VK_SPACE:
                return;
        }
        if (nextX == -1){
           nextX = frame.sSize-1;
       }
        if (nextX == frame.sSize){
           nextX = 0;
       }
        if (nextY == -1){
           nextY = frame.sSize-1;
       }
        if (nextY == frame.sSize){
           nextY = 0;
       }
        Cell newCell = playGround[nextX][nextY];
        if (newCell.getStatus() != -1){
            last.setStatus(0);
            snake.removeElementAt(0);
        } else{
            frame.generateSingleFood();
        }
        if (newCell.getStatus() == 1){
            System.exit(10);
        }
        newCell.setStatus(1);
        if (newCell == head){
            System.out.println("!!head!!");
            return;}

       
        snake.addElement(newCell);
        renderSnake();
    }

    ///////////{Constructor}//////////
    Snake(int sI, int sJ, Cell[][] playGround){
        this.playGround = playGround;
        Cell body = playGround[sI][sJ];
        Cell head = playGround[sI+1][sJ];
        Cell body2 = playGround[sI-1][sJ];
        snake.addElement(body);
        snake.addElement(head);
        System.out.println(snake.size());
        renderSnake();
    }
}
