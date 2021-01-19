package Copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(Parameters.defaultPath+"\n"+Parameters.format+"\n"+Parameters.outPath+"\n"+Parameters.amount);
		Create_copy.copy();
		Main.bar.setVisible(true);
	}
}
