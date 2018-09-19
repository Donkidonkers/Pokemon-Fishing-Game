import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameBag {

    JFrame framebag;
    Player player;
    /**
     * Launch the application.
     */

    /**
     * Create the application.
     */
    /**
     * @param p
     */
    public FrameBag(Player p) {
        player = p;
        initialize();
    }

    /**
     * Initialize the contents of the framebag.
     */
    private void initialize() {
        framebag = new JFrame();
        framebag.setBounds(100, 100, 562, 419);
        framebag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framebag.getContentPane().setLayout(null);

        JTextArea txtrAsd = new JTextArea();
        txtrAsd.setText("Pokemon: ");
        for(Pokemon p: player.getPokemon()) {
            txtrAsd.append(p.getName() + " (" + p.getOwned() + "), ");
        }
        txtrAsd.setLineWrap(true);


        txtrAsd.setBounds(31, 94, 474, 133);
        framebag.getContentPane().add(txtrAsd);

        JTextArea textArea = new JTextArea();
        textArea.setText("Items: ");
        textArea.setBounds(31, 236, 474, 133);
        textArea.setLineWrap(true);
        for(Item i: player.getBackpack().getBag()) {
            textArea.append(i.getName() + ", ");
        }
        framebag.getContentPane().add(textArea);

        JButton btnDone = new JButton("DONE");
        btnDone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                framebag.setVisible(false);
            }
        });
        btnDone.setBounds(416, 11, 89, 23);
        framebag.getContentPane().add(btnDone);

        JLabel lblBag = new JLabel("BAG");
        lblBag.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 23));
        lblBag.setBounds(31, 23, 82, 45);
        framebag.getContentPane().add(lblBag);

    }
}
