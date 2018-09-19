import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class FrameGame {

	JFrame frmPokemonFishing;
	FrameInfo frinfo;
	FrameShop frshop;
	FrameBag frbag;
	Player player;
	Map m = new LakeofRage();
	Encounter e;
	ArrayList<Item> shop;
	Image img;
	String name_map;
	/**
	 * Create the application.
	 */ 
	public FrameGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void resetAll(String name_map,JLabel pic_player) {
		if(name_map.equals("Lake of Rage")) {
			m = new LakeofRage(); 
			pic_player.setBounds(243, 243 , 48,48);
			m.setXpos(243);
			m.setYpos(243);
		}
		else if(name_map.equals("Union Cave")) {
			m = new UnionCave();
			pic_player.setBounds(243, 483, 48,48);
			m.setXpos(243);
			m.setYpos(483);
		}
		else if(name_map.equals("Route199")) {
			m = new Route199();
			pic_player.setBounds(3, 3, 48,48);
			m.setXpos(3);
			m.setYpos(3);
		}
		else if(name_map.equals("Fiore's Sea")) {
			m = new FioreSea();
			pic_player.setBounds(3, 483, 48,48);
			m.setXpos(3);
			m.setYpos(483);
		}
		else if(name_map.equals("Marine Cave")) {
			m = new MarineCave();
			pic_player.setBounds(243, 483, 48,48);
			m.setXpos(243);
			m.setYpos(483);
		}
		player.resetPos(name_map);
		player.setFace(2);
	 	img = new ImageIcon(this.getClass().getResource("/GIF_DOWN.gif")).getImage();
		pic_player.setIcon(new ImageIcon(img));
	}
	
	private void initialize() {
		player = new Player();
		frshop = new FrameShop(player);
		String name_map = "Lake of Rage";
		frmPokemonFishing = new JFrame();
		frmPokemonFishing.setBackground(Color.ORANGE);
		frmPokemonFishing.setTitle("POKEMON FISHING");
		frmPokemonFishing.setBounds(100, 100, 570, 790);
		frmPokemonFishing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokemonFishing.getContentPane().setLayout(null);
		
		JPanel panelforbuttons = new JPanel();
		panelforbuttons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelforbuttons.setBackground(Color.GRAY);
		panelforbuttons.setBounds(0, 640, 554, 111);
		frmPokemonFishing.getContentPane().add(panelforbuttons);
		panelforbuttons.setLayout(null);
		
		JPanel panel_name_map = new JPanel();						// MAP.
		panel_name_map.setBackground(new Color(255, 255, 240));
		panel_name_map.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_name_map.setBounds(10, 27, 534, 534);
		frmPokemonFishing.getContentPane().add(panel_name_map);
		panel_name_map.setLayout(null);
		
		JLabel pic_player = new JLabel();
		pic_player.setHorizontalAlignment(SwingConstants.CENTER);
		img = new ImageIcon(this.getClass().getResource("/GIF_DOWN.gif")).getImage();
		pic_player.setIcon(new ImageIcon(img));
		pic_player.setBounds(243, 243, 48, 48);
		panel_name_map.add(pic_player);
		resetAll(name_map, pic_player);
		
		JLabel backgroundname_map = new JLabel("MAP");
		img = new ImageIcon(this.getClass().getResource("/map_rage.png")).getImage();
		backgroundname_map.setIcon(new ImageIcon(img));
		backgroundname_map.setBounds(0, 0, 534, 534);
		panel_name_map.add(backgroundname_map);
		
		JPanel panel_text = new JPanel();						// FOR TEXT STUFF
		panel_text.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
		panel_text.setBackground(Color.WHITE);
		panel_text.setBounds(10, 561, 534, 77);
		frmPokemonFishing.getContentPane().add(panel_text);
		panel_text.setLayout(null);
		
		JTextPane txtpnWelcome = new JTextPane();
		txtpnWelcome.setBackground(Color.WHITE);
		txtpnWelcome.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtpnWelcome.setText("Welcome to the world of Pokemon Fishing, " + player.getName()+"!");
		txtpnWelcome.setBounds(24, 11, 481, 28);
		panel_text.add(txtpnWelcome);
		
		JTextPane txtpnWelcome2 = new JTextPane();
		txtpnWelcome2.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtpnWelcome2.setBackground(Color.WHITE);
		txtpnWelcome2.setBounds(24, 43, 481, 28);
		panel_text.add(txtpnWelcome2);
		
		JTextPane txtpnMoves = new JTextPane();								//MOVE
		txtpnMoves.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnMoves.setBounds(10, 81, 56, 20);
		panelforbuttons.add(txtpnMoves);
		txtpnMoves.setBackground(Color.GRAY);
		txtpnMoves.setText("Moves: " + player.getMoves());
		
		JTextPane txtpnCasts = new JTextPane();								//CAST
		txtpnCasts.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnCasts.setBounds(62, 81, 56, 20);
		panelforbuttons.add(txtpnCasts);
		txtpnCasts.setText("Casts: " + player.getCasts());
		txtpnCasts.setBackground(Color.GRAY);
		
		JButton btnUP = new JButton("UP");										// UP BUTTON
		btnUP.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(player.getFace() == 1 && player.getMoves() > 0) {
					if(m.getMap()[player.getXPos() - 1][player.getYPos()] != 'U') {
						player.setXpos(player.getXPos() - 1);
						pic_player.setBounds(m.getXpos(), m.getYpos() - 48, 48,48);
						m.setYpos(m.getYpos() - 48);
						if(m.getMap()[player.getXPos()][player.getYPos()] == 'P') {
        	          		resetAll(name_map, pic_player);
        	 			}
						txtpnMoves.setText("Moves: " + player.getMoves());
					}
				}
        	 	else {
        	 		player.setFace(1);
        	 		img = new ImageIcon(this.getClass().getResource("/GIF_UP.gif")).getImage();
        			pic_player.setIcon(new ImageIcon(img));
        	 	}
			}
		});
		btnUP.setBackground(Color.LIGHT_GRAY);
		btnUP.setBounds(128, 12, 80, 23);
		panelforbuttons.add(btnUP);
		
		JButton btnDown = new JButton("DOWN");									// DOWN BUTTON
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				
				if(player.getFace() == 2 && player.getMoves() > 0) {
        	 		if(m.getMap()[player.getXPos() + 1][player.getYPos()] != 'U') {
        	 			player.setXpos(player.getXPos() + 1);
        	 			pic_player.setBounds(m.getXpos(), m.getYpos() + 48, 48,48);
        	 			m.setYpos(m.getYpos() + 48);
						if(m.getMap()[player.getXPos()][player.getYPos()] == 'P') {
        	          		resetAll(name_map, pic_player);
        	 			}
        	 			txtpnMoves.setText("Moves: " + player.getMoves());
        	 		}
				}
        	 	else {
        	 		player.setFace(2);
        	 		img = new ImageIcon(this.getClass().getResource("/GIF_DOWN.gif")).getImage();
        			pic_player.setIcon(new ImageIcon(img));
        	 	}
			}
		});
		btnDown.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnDown.setBackground(Color.LIGHT_GRAY);
		btnDown.setBounds(128, 78, 80, 23);
		panelforbuttons.add(btnDown);
		
		JButton btnLeft = new JButton("LEFT");									// LEFT BUTTON
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(player.getFace() == 3 && player.getMoves() > 0) {
        	 		if(m.getMap()[player.getXPos()][player.getYPos() - 1] != 'U') {
        	 			player.setYpos(player.getYPos() - 1);
        	 			pic_player.setBounds(m.getXpos() - 48, m.getYpos() , 48,48);
        	 			m.setXpos(m.getXpos() - 48);
						if(m.getMap()[player.getXPos()][player.getYPos()] == 'P') {
        	          		resetAll(name_map, pic_player);
        	 			}
        	 			txtpnMoves.setText("Moves: " + player.getMoves());
        	 		}
				}
        	 	else {
        	 		player.setFace(3);
        	 		img = new ImageIcon(this.getClass().getResource("/GIF_LEFT.gif")).getImage();
        			pic_player.setIcon(new ImageIcon(img));
        	 	}
			}
		});
		btnLeft.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnLeft.setBackground(Color.LIGHT_GRAY);
		btnLeft.setBounds(33, 46, 80, 23);
		panelforbuttons.add(btnLeft);
		
		
		
		JButton btnRight = new JButton("RIGHT");								// RIGHT BUTTON
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(player.getFace() == 4 && player.getMoves() > 0) {
        	 		if(m.getMap()[player.getXPos()][player.getYPos() + 1] != 'U') {
        	 			player.setYpos(player.getYPos() + 1);
        	 			pic_player.setBounds(m.getXpos() + 48, m.getYpos() , 48,48);
        	 			m.setXpos(m.getXpos() + 48);
						if(m.getMap()[player.getXPos()][player.getYPos()] == 'P') {
        	          		resetAll(name_map, pic_player);
        	 			}
        	 			txtpnMoves.setText("Moves: " + player.getMoves());
        	 		}
				}
        	 	else {
        	 		player.setFace(4);
        	 		img = new ImageIcon(this.getClass().getResource("/GIF_RIGHT.gif")).getImage();
        			pic_player.setIcon(new ImageIcon(img));
        	 	}
			}
		});
		btnRight.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnRight.setBackground(Color.LIGHT_GRAY);
		btnRight.setBounds(223, 46, 80, 23);
		panelforbuttons.add(btnRight);
		
		JButton btnUp = new JButton("ACTION");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				e = new Encounter(m, player);
				player.setCasts(player.getCasts() - 1);
				txtpnCasts.setText("Casts: " + player.getCasts());
           	 if(m.getMap()[player.getXPos()][player.getYPos()] == 'P') {
           		 frshop.frmShop.setVisible(true);
        	 }
        	 else { //normal water fishing. 
        		 if (e.getEncounter() == null) {
        			 txtpnWelcome.setText("Nothing happened.");
					 txtpnWelcome2.setText("");
        		 } 
        		 else if (e.getEncounter() instanceof Pokemon) {
        			 txtpnWelcome.setText("A wild " + e.getEncounter().getName() + " appeared.");
        			 if (e.gotAway) {
        				 txtpnWelcome2.setText("It got away.");
        			 } 
        			 else {
        				 txtpnWelcome2.setText("You caught it.");
        				 player.catchPokemon((Pokemon)e.getEncounter());
        			 }
        		 } 
        		 else {
        			 txtpnWelcome.setText("You found some treasure.");
        			 txtpnWelcome2.setText("It is a " + e.getEncounter().getName());
        			 player.give(e.getEncounter());
        		 }
        		 
        	 }
           	 
           	if(player.getCasts() == 0) {
          		 resetAll(name_map, pic_player);
          		 txtpnWelcome2.setText(txtpnWelcome2.getText() + " You also returned to port.");
				 txtpnMoves.setText("Moves: " + player.getMoves());
				 txtpnCasts.setText("Casts: " + player.getCasts());
				 e = new Encounter(m, player);
          	 }
           	 	
			}
		});
		btnUp.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnUp.setBackground(Color.LIGHT_GRAY);
		btnUp.setBounds(337, 45, 87, 23);
		panelforbuttons.add(btnUp);
		
		JButton btnBag = new JButton("BAG");
		btnBag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frbag = new FrameBag(player);
				frbag.framebag.setVisible(true);
			}
		});
		btnBag.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnBag.setBackground(Color.LIGHT_GRAY);
		btnBag.setBounds(452, 12, 72, 23);
		panelforbuttons.add(btnBag);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnInfo = new JButton("INFO");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frinfo = new FrameInfo(player);
				frinfo.frameinfo.setVisible(true);
			}
		});
		btnInfo.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnInfo.setBackground(Color.LIGHT_GRAY);
		btnInfo.setBounds(452, 46, 72, 23);
		panelforbuttons.add(btnInfo);
		btnExit.setFont(new Font("Monospaced", Font.BOLD, 14));
		btnExit.setBackground(Color.LIGHT_GRAY);
		btnExit.setBounds(452, 77, 72, 23);
		panelforbuttons.add(btnExit);
		
		
		JButton btnLakeofRage = new JButton("Rage Lake");
		btnLakeofRage.setFont(new Font("Monospaced", Font.PLAIN, 10));
		btnLakeofRage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnWelcome.setText("You arrived at Lake of Rage");
				txtpnWelcome2.setText("");
				player.setLocation(new LakeofRage());
				m = new LakeofRage(); 
				pic_player.setBounds(243, 243 , 48,48);
				m.setXpos(243);
				m.setYpos(243);
				String name_map = "Lake of Rage";
				resetAll(name_map, pic_player);
				txtpnMoves.setText("Moves: " + player.getMoves());
				txtpnCasts.setText("Casts: " + player.getCasts());
				
				img = new ImageIcon(this.getClass().getResource("/map_rage.png")).getImage();
				backgroundname_map.setIcon(new ImageIcon(img));
				player.setFace(2);
        	 	img = new ImageIcon(this.getClass().getResource("/GIF_DOWN.gif")).getImage();
        		pic_player.setIcon(new ImageIcon(img));
			}
		});
		btnLakeofRage.setBounds(32, 0, 89, 23);
		frmPokemonFishing.getContentPane().add(btnLakeofRage);
		
		JButton btnUnionCave = new JButton("Union C.");
		btnUnionCave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpnWelcome.setText("You arrived at Union Cave");
				txtpnWelcome2.setText("");
				player.setLocation(new UnionCave());
				m = new UnionCave();
				pic_player.setBounds(243, 483, 48,48);
				m.setXpos(243);
				m.setYpos(283);
				String name_map = "Union Cave";
				resetAll(name_map, pic_player);
				txtpnMoves.setText("Moves: " + player.getMoves());
				txtpnCasts.setText("Casts: " + player.getCasts());
				img = new ImageIcon(this.getClass().getResource("/map_ucave.png")).getImage();
				backgroundname_map.setIcon(new ImageIcon(img));
				player.setFace(2);
        	 	img = new ImageIcon(this.getClass().getResource("/GIF_DOWN.gif")).getImage();
        		pic_player.setIcon(new ImageIcon(img));
			}
		});
		btnUnionCave.setFont(new Font("Monospaced", Font.PLAIN, 10));
		btnUnionCave.setBounds(131, 0, 89, 23);
		frmPokemonFishing.getContentPane().add(btnUnionCave);
		
		JButton btnRoute = new JButton("Route199");
		btnRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!player.getBadges().contains("Scale Badge")) {
					txtpnWelcome.setText("Can't go there yet.");
					txtpnWelcome2.setText("");
					return;
				}
				txtpnWelcome.setText("You arrived at Route199");
				txtpnWelcome2.setText("");
				player.setLocation(new Route199());
				m = new Route199();
				pic_player.setBounds(3, 3, 48,48);
				m.setXpos(3);
				m.setYpos(3);
				String name_map = "Route199";
				resetAll(name_map, pic_player);
				txtpnMoves.setText("Moves: " + player.getMoves());
				txtpnCasts.setText("Casts: " + player.getCasts());
				
				img = new ImageIcon(this.getClass().getResource("/map_route.png")).getImage();
				backgroundname_map.setIcon(new ImageIcon(img));
				player.setFace(2);
        	 	img = new ImageIcon(this.getClass().getResource("/GIF_DOWN.gif")).getImage();
        		pic_player.setIcon(new ImageIcon(img));
			}
		});
		btnRoute.setFont(new Font("Monospaced", Font.PLAIN, 10));
		btnRoute.setBounds(230, 0, 89, 23);
		frmPokemonFishing.getContentPane().add(btnRoute);
		
		JButton btnFioresSea = new JButton("Fiores S.");
		btnFioresSea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!player.getBadges().contains("Shell Badge")) {
					txtpnWelcome.setText("Can't go there yet.");
					txtpnWelcome2.setText("");
					return;
				}
				player.setLocation(new FioreSea());
				txtpnWelcome.setText("You arrived at Fiore's Sea");
				txtpnWelcome2.setText("");
				m = new FioreSea();
				m.setXpos(3);
				m.setYpos(483);
				pic_player.setBounds(m.getXpos(), m.getYpos(), 48,48);
				String name_map = "Fiore's Sea";
				resetAll(name_map, pic_player);
				txtpnMoves.setText("Moves: " + player.getMoves());
				txtpnCasts.setText("Casts: " + player.getCasts());
				img = new ImageIcon(this.getClass().getResource("/map_sea.png")).getImage();
				backgroundname_map.setIcon(new ImageIcon(img));
				player.setFace(2);
        	 	img = new ImageIcon(this.getClass().getResource("/GIF_DOWN.gif")).getImage();
        		pic_player.setIcon(new ImageIcon(img));
			}
		});
		btnFioresSea.setFont(new Font("Monospaced", Font.PLAIN, 10));
		btnFioresSea.setBounds(327, 0, 89, 23);
		frmPokemonFishing.getContentPane().add(btnFioresSea);
		
		JButton btnMarineCave = new JButton("Marine C.");
		btnMarineCave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!player.getBadges().contains("Scale Badge")) {
					txtpnWelcome.setText("Can't go there yet.");
					txtpnWelcome2.setText("");
					return;
				}
				player.setLocation(new MarineCave());
				txtpnWelcome.setText("You arrived at Marine Cave");
				txtpnWelcome2.setText("");
				m = new MarineCave();
				pic_player.setBounds(243, 483, 48,48);
				m.setXpos(243);
				m.setYpos(483);
				String name_map = "Marine Cave";
				resetAll(name_map, pic_player);
				txtpnMoves.setText("Moves: " + player.getMoves());
				txtpnCasts.setText("Casts: " + player.getCasts());
				img = new ImageIcon(this.getClass().getResource("/map_mcave.png")).getImage();
				backgroundname_map.setIcon(new ImageIcon(img));
				player.setFace(2);
        	 	img = new ImageIcon(this.getClass().getResource("/GIF_DOWN.gif")).getImage();
        		pic_player.setIcon(new ImageIcon(img));
			}
		});
		btnMarineCave.setFont(new Font("Monospaced", Font.PLAIN, 10));
		btnMarineCave.setBounds(426, 0, 89, 23);
		frmPokemonFishing.getContentPane().add(btnMarineCave);
	
	}
}
