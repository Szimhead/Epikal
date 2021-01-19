package Copy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChooseoutListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser choose=new JFileChooser();
		JPanel panel=new JPanel();
		panel.add(choose);
		int returnVal = choose.showOpenDialog(panel);
		 choose.setCurrentDirectory(new java.io.File("."));
		 choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		 choose.setAcceptAllFileFilterUsed(false);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("getSelectedFile() : " + choose.getSelectedFile());
	       Create_copy.defaultPath(choose.getSelectedFile());
	       Main.outPathText.setText(Parameters.outPath);
	    }
	}

}
