

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameInfo {
	
	JFrame frameinfo;
	Player player;
	Image img;

	/**
	 * Create the application.
	 */
	public FrameInfo(Player p) {
		player = p;
		initialize();
	}

	/**
	 * Initialize the contents of the frameinfo.
	 */

	private void initialize() {
		
		frameinfo = new JFrame();
		frameinfo.setBounds(100, 100, 1035, 611);
		frameinfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameinfo.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 565, 550);
		frameinfo.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(20, 21, 524, 330);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("NAME: " + player.getName());
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblName.setBounds(32, 85, 442, 30);
		panel_2.add(lblName);
		
		JLabel lblFame = new JLabel("FAME :" + player.getFame());
		lblFame.setHorizontalAlignment(SwingConstants.LEFT);
		lblFame.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblFame.setBounds(32, 140, 442, 30);
		panel_2.add(lblFame);
		
		JLabel lblMoney = new JLabel("MONEY: " + player.getMoney());
		lblMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoney.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblMoney.setBounds(32, 193, 442, 30);
		panel_2.add(lblMoney);
		
		JLabel lblId = new JLabel("IDNo. 11612096");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblId.setBounds(299, 30, 175, 30);
		panel_2.add(lblId);
		
		JLabel lblTrainerCard = new JLabel("TRAINER CARD");
		lblTrainerCard.setForeground(new Color(0, 0, 153));
		lblTrainerCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrainerCard.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 27));
		lblTrainerCard.setBounds(10, 11, 279, 63);
		panel_2.add(lblTrainerCard);
		
		JLabel lblPokemon = new JLabel("POKEMON : "+ player.getPokemon().size()); // NUMBER OF POKEMON
		lblPokemon.setHorizontalAlignment(SwingConstants.LEFT);
		lblPokemon.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblPokemon.setBounds(32, 253, 442, 30);
		panel_2.add(lblPokemon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(20, 362, 524, 177);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBadge = new JLabel("Badges"); // BADGES HAVE
		lblBadge.setHorizontalAlignment(SwingConstants.CENTER);
		lblBadge.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblBadge.setBounds(10, 11, 76, 30);
		panel_1.add(lblBadge);
		
		JButton btnNewButton = new JButton("DONE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameinfo.dispose();
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnNewButton.setBounds(757, 57, 114, 54);
		frameinfo.getContentPane().add(btnNewButton);
		
		JLabel lblBackground = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/background_info.png")).getImage();
		lblBackground.setIcon(new ImageIcon(img));
		lblBackground.setBounds(0, 0, 1024, 576);
		frameinfo.getContentPane().add(lblBackground);
	}
}
