package Copy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChooseinListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser choose=new JFileChooser();
		JPanel panel=new JPanel();
		panel.add(choose);
		int returnVal = choose.showOpenDialog(panel);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            choose.getSelectedFile().getAbsolutePath());
	       Parameters.inPath=choose.getSelectedFile().getAbsolutePath();
	       Main.pathText.setText(Parameters.inPath);
	    }
		
	}

}
