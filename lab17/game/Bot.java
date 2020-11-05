package lab17.game;

//Добавить картинки ботов

public class Bot{
  Image botImage = new ImageIcon("lab17/game/src/Bot.png").getImage();
  private int bX = 0, bY = 0, bW = 30, bH = 30;
  private int bI = 0, bJ = 0;

  public int getX(){return this.bX;}
  public int getY(){return this.bY;}
  public int getI(){return this.bI;}
  public int getJ(){return this.bJ;}

  public abstract void drawPath();

  public void Bot(int bX, bY, bI, bJ){
    this.bX = bX;
    this.bY = bY;
    this.bI = bI;
    this.bJ = bJ;
  }
}
