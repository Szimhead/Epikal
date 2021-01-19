package Copy;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Parameter;

public class DefaultCBActionListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		Parameters.defaultPath=Main.defaultCB.getState();
		Main.info2.setVisible(!Parameters.defaultPath);
		Main.outPathText.setVisible(!Parameters.defaultPath);
		//Main.nameText.setEnabled(Parameters.defaultPath);
		Main.chooseout.setVisible(!Parameters.defaultPath);
		System.out.println(Parameters.inPath);
		Parameters.file=new File(Parameters.inPath);
		Create_copy.defaultPath(Parameters.file);
		Main.outPathText.setText(Parameters.outPath);
	}
}
