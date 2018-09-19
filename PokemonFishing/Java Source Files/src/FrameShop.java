import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;

public class FrameShop {

	JFrame frmShop;
	ArrayList<Item> shop;
	Player player;
	/**
	 * Create the application.
	 */
	public FrameShop(Player p) {
		player = p;
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	public ArrayList<Item> restock() {
        ArrayList<Item> shop = new ArrayList<>();
        shop.add(new Boat("Speed Boat", 3500, 10));
        shop.add(new Boat("Sharpedo Boat", 5000, 15));
        shop.add(new Rod("Good Rod", 3000, 5, 10));
        shop.add(new Rod("Super Rod", 8000, 20, 15));
        shop.add(new Rod("Master Rod", 20000, 40, 20));
        shop.add(new Item("Great Lure", 500));
        shop.add(new Item("Ultra Lure", 700));
        shop.add(new Item("Master Lure", 900));
        shop.add(new Item("Great Line", 700));
        shop.add(new Item("Ultra Line", 800));
        shop.add(new Item("Master Line", 900));
        shop.add(new Item("Great Reel", 800));
        shop.add(new Item("Ultra Reel", 950));
        shop.add(new Item("Master Reel", 1000));
        shop.add(new Item("Team Aqua Engine", 1000));
        shop.add(new Tacklebox("Good Tacklebox", 1500, 8));
        shop.add(new Tacklebox("Super Tacklebox", 2000, 10));
        shop.add(new Tacklebox("Master Tacklebox", 2500, 15));
        return shop;
    }
    
	private void initialize() {
		shop = restock();
		frmShop = new JFrame();
		frmShop.setTitle("SHOP");
		frmShop.getContentPane().setBackground(Color.DARK_GRAY);
		frmShop.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(34, 349, 221, 80);
		frmShop.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnWelcomeToShop = new JTextPane();
		txtpnWelcomeToShop.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtpnWelcomeToShop.setText("Welcome to Shop!");
		txtpnWelcomeToShop.setBounds(6, 21, 209, 48);
		panel_1.add(txtpnWelcomeToShop);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(279, 11, 399, 503);
		frmShop.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSpeedBoat = new JButton(" Speed Boat ( moves 10 )            P 3500");
		btnSpeedBoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnSpeedBoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( shop.size() < 0 || shop.get(0).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(0);
					player.buy(shop.get(0));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
				}
				
			}
		});
		btnSpeedBoat.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnSpeedBoat.setBounds(10, 11, 379, 28);
		panel.add(btnSpeedBoat);
		
		JButton btnSharpedoBoat = new JButton(" Sharpedo Boat ( moves 15 )         P 5000");
		btnSharpedoBoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 1 || shop.get(1).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(1);
					player.buy(shop.get(1));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
				}
			}
		});
		btnSharpedoBoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnSharpedoBoat.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnSharpedoBoat.setBounds(10, 37, 379, 28);
		panel.add(btnSharpedoBoat);
		
		JButton btnGoodRod = new JButton(" Good Rod ( +10% enc , +5% cap )    P 3000");
		btnGoodRod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 2 || shop.get(2).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(2);
					player.buy(shop.get(2));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
				}
			}
		});
		
		JButton btnGoodTackleBox = new JButton(" Good Tackle Box ( casts 8 )        P 1500");
		btnGoodTackleBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 15 || shop.get(15).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(15);
					player.buy(shop.get(15));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
				}
			}
		});
		btnGoodTackleBox.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoodTackleBox.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnGoodTackleBox.setBounds(10, 63, 379, 28);
		panel.add(btnGoodTackleBox);
		
		JButton btnSuperTackleBox = new JButton(" Super Tackle Box ( casts 10 )      P 2000");
		btnSuperTackleBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( shop.size() < 16 || shop.get(16).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(16);
					player.buy(shop.get(16));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
				}
			}
		});
		btnSuperTackleBox.setHorizontalAlignment(SwingConstants.LEFT);
		btnSuperTackleBox.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnSuperTackleBox.setBounds(10, 91, 379, 28);
		panel.add(btnSuperTackleBox);
		
		JButton btnMasterTackleBox = new JButton(" Master Tackle Box ( moves 15 )     P 2500");
		btnMasterTackleBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 17 || shop.get(17).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(17);
					player.buy(shop.get(14));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
				}
			}
		});
		btnMasterTackleBox.setHorizontalAlignment(SwingConstants.LEFT);
		btnMasterTackleBox.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnMasterTackleBox.setBounds(10, 118, 379, 28);
		panel.add(btnMasterTackleBox);
		
		btnGoodRod.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoodRod.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnGoodRod.setBounds(10, 145, 379, 28);
		panel.add(btnGoodRod);
		
		JButton btnSuperRod = new JButton(" Super Rod( +5% enc , +20% cap )    P 8000");
		btnSuperRod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 3 || shop.get(3).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(3);
					player.buy(shop.get(3));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
				}
			}
		});
		btnSuperRod.setHorizontalAlignment(SwingConstants.LEFT);
		btnSuperRod.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnSuperRod.setBounds(10, 171, 379, 28);
		panel.add(btnSuperRod);
		
		JButton btnMasterRod = new JButton(" Master Rod( +20% enc , +40% cap )  P 20000");
		btnMasterRod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 4 || shop.get(4).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(4);
					player.buy(shop.get(4));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
				}
			}
		});
		btnMasterRod.setHorizontalAlignment(SwingConstants.LEFT);
		btnMasterRod.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnMasterRod.setBounds(10, 198, 379, 28);
		panel.add(btnMasterRod);
		
		JButton btnGreatLure = new JButton(" Great Lure ( +5% enc, +5% )        P 500");
		btnGreatLure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 5 || shop.get(5).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(5);
					player.buy(shop.get(5));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
					player.getRod().attachLure(item);
				}
			}
		});
		btnGreatLure.setHorizontalAlignment(SwingConstants.LEFT);
		btnGreatLure.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnGreatLure.setBounds(10, 225, 379, 28);
		panel.add(btnGreatLure);
		
		JButton btnUltraLure = new JButton(" Ultra Lure( +10% enc , +5% cap )   P 700");
		btnUltraLure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 6 || shop.get(6).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(6);
					player.buy(shop.get(6));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
					player.getRod().attachLure(item);
				}
			}
		});
		btnUltraLure.setHorizontalAlignment(SwingConstants.LEFT);
		btnUltraLure.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnUltraLure.setBounds(10, 251, 379, 28);
		panel.add(btnUltraLure);
		
		JButton btnMasterLure = new JButton(" Master Lure( +30% enc , +7% cap )  P 900");
		btnMasterLure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 7 || shop.get(7).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(7);
					player.buy(shop.get(7));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
					player.getRod().attachLure(item);
				}
			}
		});
		btnMasterLure.setHorizontalAlignment(SwingConstants.LEFT);
		btnMasterLure.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnMasterLure.setBounds(10, 278, 379, 28);
		panel.add(btnMasterLure);
		
		JButton btnGreatLine = new JButton(" Great Line( +0% enc , +10% cap )   P 700");
		btnGreatLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 8 || shop.get(8).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(8);
					player.buy(shop.get(8));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
					player.getRod().attachLine(item);
				}
			}
		});
		btnGreatLine.setHorizontalAlignment(SwingConstants.LEFT);
		btnGreatLine.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnGreatLine.setBounds(10, 304, 379, 28);
		panel.add(btnGreatLine);
		
		JButton btnUltraLine = new JButton(" Ultra Line( +0% enc , +15% cap )   P 800");
		btnUltraLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 9 || shop.get(9).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(9);
					player.buy(shop.get(9));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
					player.getRod().attachLine(item);
				}
			}
		});
		btnUltraLine.setHorizontalAlignment(SwingConstants.LEFT);
		btnUltraLine.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnUltraLine.setBounds(10, 330, 379, 28);
		panel.add(btnUltraLine);
		
		JButton btnMasterLine = new JButton(" Master Line( +0% enc , +25% cap )  P 900");
		btnMasterLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 10 || shop.get(10).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(10);
					player.buy(shop.get(10));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
					player.getRod().attachLine(item);
				}
			}
		});
		btnMasterLine.setHorizontalAlignment(SwingConstants.LEFT);
		btnMasterLine.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnMasterLine.setBounds(10, 356, 379, 28);
		panel.add(btnMasterLine);
		
		JButton btnGreatReel = new JButton(" Great Reel( +10% enc , +10% cap )  P 800");
		btnGreatReel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 11 || shop.get(11).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(11);
					player.buy(shop.get(11));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
					player.getRod().attachReel(item);
				}
			}
		});
		btnGreatReel.setHorizontalAlignment(SwingConstants.LEFT);
		btnGreatReel.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnGreatReel.setBounds(10, 383, 379, 28);
		panel.add(btnGreatReel);
		
		JButton btnUltraReel = new JButton(" Ultra Reel( +18% enc , +18% cap )  P 950");
		btnUltraReel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 12 || shop.get(12).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(12);
					player.buy(shop.get(12));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
					player.getRod().attachReel(item);
				}
			}
		});
		btnUltraReel.setHorizontalAlignment(SwingConstants.LEFT);
		btnUltraReel.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnUltraReel.setBounds(10, 410, 379, 28);
		panel.add(btnUltraReel);
		
		JButton button_14 = new JButton(" Master Reel( +21% enc , +21% cap ) P 1000");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 13 || shop.get(13).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(13);
					player.buy(shop.get(13));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
					player.getRod().attachReel(item);
				}
			}
		});
		button_14.setHorizontalAlignment(SwingConstants.LEFT);
		button_14.setFont(new Font("Monospaced", Font.BOLD, 14));
		button_14.setBounds(10, 438, 379, 28);
		panel.add(button_14);
		
		JButton btnTeamAquaEngine = new JButton(" Team Aqua Engine( moves cost half )P 1000");
		btnTeamAquaEngine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( shop.size() < 14 || shop.get(14).getCost() > player.getMoney()) {
					txtpnWelcomeToShop.setText("Can't do that.");
				}
				else {
					Item item = shop.get(14);
					player.buy(shop.get(14));
					txtpnWelcomeToShop.setText("You bought a  " + item.getName());
				}
			}
		});
		btnTeamAquaEngine.setHorizontalAlignment(SwingConstants.LEFT);
		btnTeamAquaEngine.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnTeamAquaEngine.setBounds(10, 464, 379, 28);
		panel.add(btnTeamAquaEngine);
		
		JButton btnNewButton = new JButton("DONE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmShop.dispose();
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 13));
		btnNewButton.setBounds(315, 544, 90, 28);
		frmShop.getContentPane().add(btnNewButton);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/background_shop.png")).getImage();
		lblBackground.setIcon(new ImageIcon(img));
		lblBackground.setBounds(0, 26, 722, 566);
		frmShop.getContentPane().add(lblBackground);
		frmShop.setBounds(100, 100, 738, 633);
		frmShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
