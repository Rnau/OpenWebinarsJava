package minessweeper;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Денис
 */
public class MainForm extends JFrame implements ActionListener
{
    JMenuBar MenuBar;
    JMenu GameMenu;
    JMenuItem newGameItem;
    JMenuItem resetGameItem;
    JMenuItem exitItem;
    JMenu FiledMenu;
    JMenu filedSizeMenu;
    JMenu filedTypeMenu;
    JMenuItem noviceItem;
    JMenuItem amateurItem;
    JMenuItem expertItem;
    JMenuItem octFiledItem;
    JMenuItem hexFiledItem;
    MinesSweeperBoard board;
    int w = 9;
    int h = 9;
    int b = 10;
    public MainForm()
    {
        super();
        MenuBar = new JMenuBar();
            GameMenu = new JMenu("Joc");
            FiledMenu = new JMenu("Tipus de Camp");
                newGameItem = new JMenuItem("Nova partida");
                resetGameItem = new JMenuItem("Reiniciar");
                exitItem = new JMenuItem("Sortir");
                newGameItem.addActionListener(this);
                resetGameItem.addActionListener(this);
                exitItem.addActionListener(this);

                filedSizeMenu = new JMenu("Mida del Camp");
                filedTypeMenu = new JMenu("Tipus de Camp");
                    noviceItem = new JMenuItem("Principiant 9x9 10 minuts");
                    amateurItem = new JMenuItem("Aficionat 16x16 40 minuts");
                    expertItem = new JMenuItem("Expert 16x30 99 minuts");
                    noviceItem.addActionListener(this);
                    amateurItem.addActionListener(this);
                    expertItem.addActionListener(this);
                filedSizeMenu.add(noviceItem);
                filedSizeMenu.add(amateurItem);
                filedSizeMenu.add(expertItem);
                    octFiledItem = new JMenuItem("Quadrat, 8 min");
                    octFiledItem.addActionListener(this);
                    hexFiledItem = new JMenuItem("Hexagonal, 6 min");
                    hexFiledItem.addActionListener(this);
                filedTypeMenu.add(octFiledItem);
                filedTypeMenu.add(hexFiledItem);
        GameMenu.add(newGameItem);
        GameMenu.add(resetGameItem);
        GameMenu.add(exitItem);
        FiledMenu.add(filedSizeMenu);
        FiledMenu.add(filedTypeMenu);
        MenuBar.add(GameMenu);
        MenuBar.add(FiledMenu);
        setJMenuBar(MenuBar);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);
        board = new OctMinesSweeperBoard();
        getContentPane().add(board);
        board.setSize(getSize());
        board.GetGame().LoadGame(w,h,b);
        board.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == exitItem)
            System.exit(0);
        if(source == newGameItem)
            board.GetGame().LoadGame(w,h,b);
        if(source == resetGameItem)
            board.GetGame().RestartGame();
        if(source == noviceItem)
        {
            w = 9; h = 9;b = 10;
            board.GetGame().LoadGame(w, h,b);
            board.resized(null);
        }
        if(source == amateurItem)
        {
            w = 16; h = 16;b = 40;
            board.GetGame().LoadGame(w, h,b);
            board.resized(null);
        }
        if(source == expertItem)
        {
            w = 30; h = 16;b = 99;
            board.GetGame().LoadGame(w, h,b);
            board.resized(null);
        }
        if(source == octFiledItem)
        {
            board = new OctMinesSweeperBoard();
            getContentPane().removeAll();
            getContentPane().add(board);
            board.setSize(getContentPane().getSize());
            board.GetGame().LoadGame(w,h,b);
        }
        if(source == hexFiledItem)
        {
            board = new HexMinesSweeperBoard();
            getContentPane().removeAll();
            getContentPane().add(board);
            board.setSize(getContentPane().getSize());
            board.GetGame().LoadGame(w,h,b);
        }
    }
}
