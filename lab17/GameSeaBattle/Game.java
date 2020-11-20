package lab17.GameSeaBattle;


import javax.swing.*;
import java.awt.*;

public class Game{
    public  Game(){
       // GameInterface player = new GameInterface(10, 50);
       // GameInterface bot = new GameInterface(10, 50);
       // bot.generateRandomShips();
    }
    public GameInterface player, bot;
    public int iter = 0;

    public void startGame(Game game){

    }

    public static void main(String[] args) {
        Game game = new Game();

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.LINE_AXIS));

        GameInterface player = new GameInterface(10, 50);
        player.setVisible();
        player.setShips = true;

        GameInterface bot = new GameInterface(10, 50);
        bot.generateRandomShips();
        bot.clearPlayGroundOfRed();
        //bot.setVisible();

        JPanel sep = new JPanel();
        sep.setLayout(new BoxLayout(sep, BoxLayout.PAGE_AXIS));




        main.add(player);
        main.add(sep);
        main.add(bot);
        main.setOpaque(true);


        JFrame frame = new JFrame("game");
       // frame.setSize(1440, 1000);
        frame.setContentPane(main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
        JOptionPane.showMessageDialog(player, "В начале игры вам будет предложено разместить свои корабли.\n" +
                " Всего 10 кораблей: 1 четырехпалубный, 2 трехпалубных,\n 3 двухпалубных и 4 однопалубных.\n" +
                "Для размещения корабля разместите на игровом поле начало и конец корабля нажатием ЛКМ по клетке\n" +
                "Для размещения однопалубного корабля кликните дважды по клетке.\n" +
                "Уничтожайте корабли соперника(бота) нажатием по клетке игрового поля.\n" +
                "Игра закончится после уничтожения всех кораблей одного из игроков.");

        JOptionPane.showMessageDialog(player, "Установите корабли");
        while (player.getTotalShips() != 10){
            System.out.println("1");
            System.out.println(player.getTotalShips());
            player.setShips = true;
        }
        player.setShips = false;
        player.clearPlayGroundOfRed();
        JOptionPane.showMessageDialog(player, "Ваш ход первый.\nСтреляйте по клеткам врага.");

        player.setBot(bot);player.setGame(game);
        bot.setPlayer(player);bot.setGame(game);

        // player.shoot = true;
        game.iter = 0; // Количество выстрелов (не в сумме)\закрытых клеток на одной панеле
        while ((player.totalShipCells > 0 && bot.totalShipCells > 0) && (game.iter < 100)){
            player.shoot = true;
        }
        player.shoot = false;
        JOptionPane.showMessageDialog(player, "123");

    }
}