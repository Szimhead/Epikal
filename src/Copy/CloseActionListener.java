package Copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class CloseActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Main.frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
	}

}
