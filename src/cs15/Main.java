package cs15;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * **************
 *
 * copyright Macky Broido 2012
 *
 * v1.6
 *
 * renamed to CardShark
 * .
 **************
 */
public class Main implements ActionListener {
    //feilds

    private int turn;
    private int counter;
    private int firstCardMnumonic;
    private int secondCardMnumonic;
    private Random random;
    private int r;
    private int pickedNumbers;
    private ImageIcon tempIcon;
    private int randoNumber;
    private int randoNumber52;
    private JButton tempButton;
    private ArrayList<Integer> list52;
    private ArrayList<Integer> list20;
    private ArrayList<Integer> randomList;
    private int width = Toolkit.getDefaultToolkit().getScreenSize().width;//fits findow to width of screen
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;//fits window to height of screen    public static void main(String[] args)
    private JFrame window;
    private JButton[] buttonArray;
    private ImageIcon coverIcon;

    public static void main(String[] args) {
        new Main().getGoing();//makes getGoing
    }

    private void getGoing()//getGoing
    {
        random = new Random();//makes it real
        list52 = new ArrayList<Integer>();
        for (int i = 0; i < 52; i++) {
            list52.add(i);
        }
        list20 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            randoNumber52 = (int) (Math.random() * list52.size());
            list20.add(list52.get(randoNumber52));
            list20.add(list52.get(randoNumber52));
            list52.remove(randoNumber52);
        }
        //knuth shuffle method
        randomList = new ArrayList<Integer>(20);
        for (int i = 0; i < 20; i++) {
            r = random.nextInt(list20.size());
            randomList.add(list20.get(r));
            list20.remove(r);
        }
        buttonArray = new JButton[20];
        coverIcon = new ImageIcon("/Users/macky/NetBeansProjects/CS15/src/cs15/CardCover_2.jpg");
        window = new JFrame("Card Game                                                                                     v1.6");//window
        window.setSize(512, 512);//makes window 512x512
        window.setLocationRelativeTo(null);// location of window on screen
        window.setBackground(Color.lightGray);// background color of window is black
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes on X button
        window.setLayout(new GridLayout(4, 5, 11, 11));//grid is 4 by 5, gaps are 5
        for (int i = 0; i < 20; i++)//keeps making JButtons until there are 4 rows
        {
            buttonArray[i] = new JButton(coverIcon);//buttonArray is all the JButtons
            window.add(buttonArray[i]);//adds the buttonArray to the background
            buttonArray[i].addActionListener(this);//adds actionListner (see bottom)
            buttonArray[i].setForeground(Color.white);
            buttonArray[i].setBackground(Color.black);
            buttonArray[i].setMnemonic(i);
        }
        window.setVisible(true);// jPane visible
    }

    @Override
    public void actionPerformed(ActionEvent euc)//actionPerformed
    {
        counter += 1;
        turn = counter % 2;
        if (turn == 1) {
            firstCardMnumonic = tempButton.getMnemonic();
        }
        if (turn == 0) {
            secondCardMnumonic = tempButton.getMnemonic();
            if (firstCardMnumonic == secondCardMnumonic) {
                System.out.println("match");
            }
        }
        tempButton = (JButton) euc.getSource();
        randoNumber = (int) (Math.random() * 51);
        tempIcon = new ImageIcon("/Users/macky/NetBeansProjects/CS15/src/cs15/Card" + randomList.get(tempButton.getMnemonic()) + ".jpg");
        tempButton.setIcon(tempIcon);
        System.out.println("its " + turn + "'s turn :D and the counter is equal to " + counter);
    }
}