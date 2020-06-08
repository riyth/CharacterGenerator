package CharacterGenerator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
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
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnSource = new JMenu("Owned Source Material");
		mnFile.add(mnSource);
		
		JCheckBox chckbxPlayersHandbook = new JCheckBox("Player's Handbook",true);
		mnSource.add(chckbxPlayersHandbook);
		
		JCheckBox chckbxDungeonMastersGuide = new JCheckBox("Dungeon Master's Guide",true);
		mnSource.add(chckbxDungeonMastersGuide);
		
		JCheckBox chckbxEberronRisingFrom = new JCheckBox("Eberron: Rising from the Last War",false);
		mnSource.add(chckbxEberronRisingFrom);
		
		JCheckBox chckbxExplorersGuideTo = new JCheckBox("Explorer's Guide to Wildemount",false);
		mnSource.add(chckbxExplorersGuideTo);
		
		JCheckBox chckbxGuildmasterGuideTo = new JCheckBox("Guildmaster' Guide to Eberron",false);
		mnSource.add(chckbxGuildmasterGuideTo);
		
		JCheckBox chckbxSwordCoastAdventurers = new JCheckBox("Sword Coast Adventurer's Guide",false);
		mnSource.add(chckbxSwordCoastAdventurers);
		
		JCheckBox chckbxWayfindersGuideTo = new JCheckBox("Wayfinder's Guide to Eberron",false);
		mnSource.add(chckbxWayfindersGuideTo);
		
		JCheckBox chckbxXanatharsGuideTo = new JCheckBox("Xanathar's Guide to Everything",false);
		mnSource.add(chckbxXanatharsGuideTo);
		
		JCheckBox chckbxCurseofStrahd = new JCheckBox("Curse of Strahd",false);
		mnSource.add(chckbxCurseofStrahd);
		
		JCheckBox chckbxExplorersGuideWildmount = new JCheckBox("Explorer's Guide to Wildemount",false);
		mnSource.add(chckbxExplorersGuideWildmount);
		
		JMenu mnAlignment = new JMenu("Alignment");
		mnFile.add(mnAlignment);
		
		JCheckBox chckbxLawfulGood = new JCheckBox("Lawful Good",true);
		mnAlignment.add(chckbxLawfulGood);
		
		
		JCheckBox chckbxLawfulNeutral = new JCheckBox("Lawful Neutral",true);
		mnAlignment.add(chckbxLawfulNeutral);
		
		JCheckBox chckbxLawfulEvil = new JCheckBox("Lawful Evil",true);
		mnAlignment.add(chckbxLawfulEvil);
		
		JCheckBox chckbxTrueNeutral = new JCheckBox("True Neutral",true);
		mnAlignment.add(chckbxTrueNeutral);
		
		JCheckBox chckbxChaoticGood = new JCheckBox("Chaotic Good",true);
		mnAlignment.add(chckbxChaoticGood);
		
		JCheckBox chckbxChaoticNeutral = new JCheckBox("Chaotic Neutral",true);
		mnAlignment.add(chckbxChaoticNeutral);
		
		JCheckBox chckbxChaoticEvil = new JCheckBox("Chaotic Evil",true);
		mnAlignment.add(chckbxChaoticEvil);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 135);
		frame.getContentPane().add(textArea);
		
		JButton btnGenerateCharacter = new JButton("Generate");
		btnGenerateCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String alignmentIn = "";
				
				if(chckbxChaoticEvil.isSelected()) {
					alignmentIn = alignmentIn + "'Chaotic Evil',";
				}
				if(chckbxChaoticNeutral.isSelected()) {
					alignmentIn = alignmentIn + "'Chaotic Neutral',";
				}
				if(chckbxChaoticGood.isSelected()) {
					alignmentIn = alignmentIn + "'Chaotic Good',";
				}
				if(chckbxTrueNeutral.isSelected()) {
					alignmentIn = alignmentIn + "'True Neutral',";
				}
				if(chckbxLawfulGood.isSelected()) {
					alignmentIn = alignmentIn + "'Lawful Good',";
				}
				if(chckbxLawfulNeutral.isSelected()) {
					alignmentIn = alignmentIn + "'Lawful Neutral',";
				}
				if(chckbxLawfulEvil.isSelected()) {
					alignmentIn = alignmentIn + "'Lawful Evil',";
				}
				
				alignmentIn= alignmentIn.substring(0,alignmentIn.length()-1);
				
				
				Database db = null;
				try {
					String source = null;
					
					db = new Database(source, alignmentIn);
				
 				
 				String opening = "You are a ";
				String alignment = db.getAlignment();
				String race = db.getRace();
				String classX = db.getClassX();
				String subclass = db.getSubClass(classX);
				String background = db.getBackground();
				String middle = null;
				
				switch(classX) {
				case "Artificer" :     middle = "You specialize as a ";
				break;
				case "Barbarian" :  middle = "You have started walking down the ";
				break;
				case "Bard" :       middle = "You are associated with the ";
				break;
				case "Cleric" :     middle = "Your deity grants you power from the ";
				break;
				case "Druid" :      middle = "You are a member of the ";
				break;
				case "Fighter" :    middle = "You are training to become a ";
				break;
				case "Monk" :       middle = "You training at the monastery was to master the ";
				break;
				case "Paladin" :    middle = "You have sworn an ";
				break;
				case "Ranger" :     middle = "You specialize as a ";
				break;
				case "Rogue" :      middle = "Your are a trained ";
				break;
				case "Sorcerer" :   middle = "You power comes from ";
				break;
				case "Warlock" :    middle = "To gain the power you sought, you brokered a deal with ";
				break;
				case "Wizard" :     middle = "You have spent some time studying at the ";
				break;
							}
				
			
				textArea.setText(opening + alignment + ' ' + race + ' ' + classX + ". " + "\n" + middle + subclass + ".\nYou come from a " + background + "background." );
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGenerateCharacter.setBounds(153, 157, 129, 23);
		frame.getContentPane().add(btnGenerateCharacter);
	}
}
