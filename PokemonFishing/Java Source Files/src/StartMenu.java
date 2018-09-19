import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class StartMenu {

	JFrame frmStartUp;
	Player player = new Player();
	FrameGame game = new FrameGame();

	/**
	 * Create the application.
	 */
	
	public StartMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartUp = new JFrame();
		frmStartUp.setTitle("Start Up");
		frmStartUp.setBounds(100, 100, 761, 552);
		frmStartUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStartUp.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmStartUp.dispose();
				game.frmPokemonFishing.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 12));
		btnNewButton.setBounds(152, 326, 89, 23);
		frmStartUp.getContentPane().add(btnNewButton);
		
		JTextField lblName = new JTextField(50);
		lblName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = lblName.getText();
				lblName.setText(name);
				player.setName(name);
			}
		});
		lblName.setBackground(Color.WHITE);
		lblName.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblName.setBounds(54, 275, 290, 23);
		frmStartUp.getContentPane().add(lblName);
		
		
		JLabel lblBackground = new JLabel("Background");
		lblBackground.setFont(new Font("Monospaced", Font.BOLD, 14));
		Image img = new ImageIcon(this.getClass().getResource("/Start_menu.jpg")).getImage();
		lblBackground.setIcon(new ImageIcon(img));
		lblBackground.setBounds(0, 0, 745, 513);
		frmStartUp.getContentPane().add(lblBackground);
	}
}
