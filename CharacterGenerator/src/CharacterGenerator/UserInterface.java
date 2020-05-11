package CharacterGenerator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;



public class UserInterface extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mainPanel;
	JButton generateButton;
	JTextArea textArea;
	JMenu menu;
	JMenuBar menuBar;
	JMenuItem source, alignment;
	
	String guiTitle = "D&D Character Generator";
	Database db = null;
	
	
	
	public UserInterface() {
		
		Container pane = getContentPane();
		mainPanel = new JPanel( new GridLayout(3,1));
		
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		source = new JMenuItem("Owned Sources");
		alignment = new JMenuItem("Alignments");
		
		textArea = new JTextArea();
		textArea.setEditable(false);
				
		generateButton = new JButton("Generate Character");
		generateButton.addActionListener(new UserInterface.generateButtonListener());
		
		menu.add(source);
		menu.add(alignment);
		menuBar.add(menu);
		mainPanel.add(menu);
		setJMenuBar(menuBar);
		
		mainPanel.add(textArea);
		mainPanel.add(generateButton);
		
		
		
		pane.add(mainPanel);
		
		setTitle(guiTitle);
	    setSize(500, 190);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	private class generateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
           
        	try {
     				db = new Database();
     				
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
        		 } catch (SQLException a) {
     				// TODO Auto-generated catch block
     				a.printStackTrace();
     			}
        		
        	
        	   	
        	
        	
        	
            
            
			
        }
        
        }
    
	
	
	 public static void main(String args[]) {
	        new UserInterface();
	        
	    }
	
}
