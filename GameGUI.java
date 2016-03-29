import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.CardLayout;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextPane;


public class GameGUI {

	
	private JFrame frame;
	private JPanel ChoiceScreen;
	private JPanel Armory;
	private JPanel BattleScreen;
	private Game newGame = new Game();
	private JTextField txtEnterName;
	private JLabel lblCurrentGold;
	private JLabel lblHeroImage;
	private JLabel lblHeroWeaponImage;
	private JLabel lblHeroName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI window = new GameGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 598, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel EnterScreen = new JPanel();
		frame.getContentPane().add(EnterScreen, "name_104103002518154");
		EnterScreen.setLayout(null);
		
		txtEnterName = new JTextField();
		txtEnterName.setText("Enter Name");
		txtEnterName.setBounds(220, 265, 142, 20);
		EnterScreen.add(txtEnterName);
		txtEnterName.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String heroName = txtEnterName.getText();
				newGame.setHero(heroName);
				ChoiceScreen.setVisible(true);
				EnterScreen.setVisible(false);
			}
		});
		btnStart.setBounds(246, 296, 89, 23);
		EnterScreen.add(btnStart);
		
		ChoiceScreen = new JPanel();
		frame.getContentPane().add(ChoiceScreen, "name_104103009321002");
		ChoiceScreen.setLayout(null);
		
		JButton btnBattle = new JButton("Battle!");
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BattleScreen.setVisible(true);
				ChoiceScreen.setVisible(false);
				lblHeroImage.setIcon(newGame.hero.image);
				lblHeroWeaponImage.setIcon(newGame.hero.equippedWeapon.image);
				lblHeroName.setText(newGame.hero.name);
			}
		});
		btnBattle.setBounds(66, 87, 153, 110);
		ChoiceScreen.add(btnBattle);
		
		JButton btnArmory = new JButton("Armory");
		btnArmory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Armory.setVisible(true);
				ChoiceScreen.setVisible(false);
				lblCurrentGold.setText("Current Gold: " + newGame.hero.gold);
			}
		});
		btnArmory.setBounds(373, 87, 153, 110);
		ChoiceScreen.add(btnArmory);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(420, 484, 138, 49);
		ChoiceScreen.add(btnExitGame);
		
		Armory = new JPanel();
		frame.getContentPane().add(Armory, "name_104188541027094");
		Armory.setLayout(null);
		
		JLabel lblWeaponImage = new JLabel("");
		lblWeaponImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblWeaponImage.setForeground(new Color(0, 0, 0));
		lblWeaponImage.setBounds(444, 138, 96, 96);
		Armory.add(lblWeaponImage);
		
		JLabel lblWeaponInfo = new JLabel("");
		lblWeaponInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblWeaponInfo.setBounds(410, 280, 130, 50);
		Armory.add(lblWeaponInfo);
		
		lblCurrentGold = new JLabel("");
		lblCurrentGold.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCurrentGold.setBounds(258, 280, 130, 50);
		Armory.add(lblCurrentGold);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblWeaponImage.setIcon(newGame.armory.weapons.get(comboBox.getSelectedIndex()).image);
				lblWeaponInfo.setText("Attack: " + newGame.armory.weapons.get(comboBox.getSelectedIndex()).attack + 
										" Cost: " + newGame.armory.weapons.get(comboBox.getSelectedIndex()).cost);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[]{newGame.armory.weapons.get(0).name, newGame.armory.weapons.get(1).name, 
				newGame.armory.weapons.get(2).name, newGame.armory.weapons.get(3).name}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(50, 112, 200, 50);
		Armory.add(comboBox);
		
		JButton btnBuyEquip = new JButton("Buy / Equip");
		btnBuyEquip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newGame.armory.buyWeapon(comboBox.getSelectedIndex(), newGame.hero);
				
				lblCurrentGold.setText("Current Gold: " + newGame.hero.gold);
			}
		});
		btnBuyEquip.setBounds(33, 461, 114, 49);
		Armory.add(btnBuyEquip);

		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChoiceScreen.setVisible(true);
				Armory.setVisible(false);
			}
		});
		btnBack.setBounds(432, 461, 108, 49);
		Armory.add(btnBack);

		
		BattleScreen = new JPanel();
		frame.getContentPane().add(BattleScreen, "name_104893204133579");
		BattleScreen.setLayout(null);
		
		lblHeroImage = new JLabel("");
		lblHeroImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHeroImage.setBounds(40, 81, 96, 96);
		BattleScreen.add(lblHeroImage);
		
		JLabel lblEnemyImage = new JLabel("");
		lblEnemyImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEnemyImage.setBounds(448, 81, 96, 96);
		BattleScreen.add(lblEnemyImage);
		
		lblHeroWeaponImage = new JLabel("");
		lblHeroWeaponImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHeroWeaponImage.setBounds(146, 81, 96, 96);
		BattleScreen.add(lblHeroWeaponImage);
		
		JLabel lblEnemyWeaponImage = new JLabel("");
		lblEnemyWeaponImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEnemyWeaponImage.setBounds(342, 81, 96, 96);
		BattleScreen.add(lblEnemyWeaponImage);
		
		lblHeroName = new JLabel("");
		lblHeroName.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblHeroName.setBounds(40, 188, 202, 21);
		BattleScreen.add(lblHeroName);
		
		JLabel lblEnemyName = new JLabel("");
		lblEnemyName.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEnemyName.setBounds(342, 188, 202, 21);
		BattleScreen.add(lblEnemyName);
		
		JTextPane battleTextPane = new JTextPane();
		battleTextPane.setBounds(40, 220, 504, 280);
		BattleScreen.add(battleTextPane);
		
		JButton btnFight = new JButton("Fight");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				battleTextPane.setText(newGame.battle());
				lblEnemyImage.setIcon(newGame.enemy.image);
				lblEnemyWeaponImage.setIcon(newGame.enemy.equippedWeapon.image);
				lblEnemyName.setText(newGame.enemy.name);
				if(newGame.hero.isDead()){
					JOptionPane.showMessageDialog(null, "You Died :(");
					System.exit(0);
				}
			}
		});
		btnFight.setBounds(36, 511, 100, 35);
		BattleScreen.add(btnFight);
		
		JButton btnBck = new JButton("Back");
		btnBck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChoiceScreen.setVisible(true);
				BattleScreen.setVisible(false);
			}
		});
		btnBck.setBounds(444, 511, 100, 35);
		BattleScreen.add(btnBck);
	}
}
