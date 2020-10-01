package lab8_2;

import java.applet.Applet;
import java.awt.*;
import java.net.URL;

public class Main extends Applet {
    Image img;

    @Override
    public void init() {
        super.init();
        img=getImage(getCodeBase(),"file:image.jpg");
        System.out.println(getCodeBase());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img,0,0,this);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }
}