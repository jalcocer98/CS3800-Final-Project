import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * MessageClient
 */
public class MessageClient implements ActionListener {

    private JTextField messageField;
    private JTextArea messageHistory;

    public MessageClient(){
        JFrame frame = new JFrame("Messenger");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        messageField = new JTextField(30);
        messageField.addActionListener(this);
        messageField.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        frame.add(messageField, BorderLayout.SOUTH);

        messageHistory = new JTextArea("");
        messageHistory.setLineWrap(true);
        messageHistory.setEditable(false);
        frame.add(messageHistory, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu action = new JMenu("Action");
        action.setMnemonic('a');
        menuBar.add(action);

        JMenuItem seeUsers = new JMenuItem("See Current Messengers");
        seeUsers.setMnemonic('s');
        action.add(seeUsers);
        
        action.addSeparator();
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic('x');
        action.add(exit);

        JMenu help = new JMenu("Help");
        help.setMnemonic('h');
        menuBar.add(help);

        JMenuItem viewHelp = new JMenuItem("View Help");
        viewHelp.setMnemonic('h');
        help.add(viewHelp);

        JMenuItem about = new JMenuItem("About");
        about.setMnemonic('a');
        help.add(about);


        frame.setJMenuBar(menuBar);        
        frame.setVisible(true);
        String test = null;
        while(test == null){
            test = JOptionPane.showInputDialog(frame, "Please enter your user name", "Username");
        }
        messageHistory.append(test);
    }
    public void actionPerformed(ActionEvent ae){
        messageHistory.append(messageField.getText() + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new MessageClient();
            }
        });
    }
}