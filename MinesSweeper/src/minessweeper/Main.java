package minessweeper;

import javax.swing.JFrame;

/**
 *
 * @author Денис
 */
public class Main// extends JFrame
{
    public Main() 
    {
//        MinesSweeperBoard b = new OctMinesSweeperBoard();
//        add(b);
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(900, 480);
//        setLocationRelativeTo(null);
//        setTitle("Сапер восмьерка");
//        setResizable(true);
//        setVisible(true);
//        b.GetGame().LoadGame(30,16,99);
    }
    public static void main(String[] args)
    {
        new MainForm().setVisible(true);//Main();
    }

}
