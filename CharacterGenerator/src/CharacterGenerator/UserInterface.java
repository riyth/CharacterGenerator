package CharacterGenerator;

import java.awt.*;
import javax.swing.*;

public class UserInterface extends JFrame{

	JPanel mainPanel;
	JButton generateButton;
	JTextArea textArea;
	
	String guiTitle = "D&D Character Generator";
	Database db = null;
	
	
	
	public UserInterface() {
		
		Container pane = getContentPane();
		mainPanel = new JPanel( new GridLayout(2,1));
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("Test123");
		
		generateButton = new JButton("Generate Character");
		
		
		
		mainPanel.add(textArea);
		mainPanel.add(generateButton);
		
		
		
		pane.add(mainPanel);
		
		setTitle(guiTitle);
	    setSize(500, 190);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	
	 public static void main(String args[]) {
	        new UserInterface();
	        
	    }
	
}
