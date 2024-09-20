
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;



public class Chat 
{
    
    public static void main(String[] args) 
    {
       JFrame frame = new JFrame ("Chat Frame");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400, 400);

       JMenuBar mb = new JMenuBar();

       JMenu fJMenu = new JMenu("File");
       JMenu hMenu = new JMenu("Help");

       JMenuItem oItem = new JMenuItem("Open");
       JMenuItem sItem = new JMenuItem("Save as");

       fJMenu.add(oItem);
       fJMenu.add(sItem);

       mb.add(fJMenu);
       mb.add(hMenu);

       JTextArea txtF = new JTextArea()

       JPanel pnl - new JPanel();

       JLabel lbl = new JLabel ("Type");
       JTextField  txt = new JTextField(10);
       JButton send = new JButton("Send");
       JButton reset = new JButton("Reset");

       pnl.add(lbl);
       pnl.add(txt);
       pnl.add(send);
       pnl.add(reset);

       frame.add(mb,BorderLayout.NORTH);
       frame.add(txtF,BorderLayout.CENTER);
       frame.add(pnl,BorderLayout.SOUTH);

       frame.setVisible(true);

    }
}
