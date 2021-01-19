package Copy;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.channels.NetworkChannel;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Main {
	public static JFrame frame;

	
	public static JLabel info;
	public static JLabel info1;
	public static JLabel info2;
	public static JLabel info3;
	public static Checkbox defaultCB;
	public static JTextField pathText;
	public static JTextField amountText;
	public static JTextField outPathText;
	public static JTextField nameText;
	//JFileChooser browse=new JFileChooser();
	public static JButton apply;
	public static JButton close;
	public static JButton choosein;
	public static JButton chooseout;
	public static JProgressBar bar;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createWindow();
	}

	
	public static void createWindow() {
		frame=new JFrame();
		ImageIcon img = new ImageIcon("icon.png");
		frame.setIconImage(img.getImage());
		
		JPanel centPanel=new JPanel();
		JPanel fPanel=new JPanel();
		JPanel exPanel=new JPanel();
		JPanel downPanel=new JPanel();
		JPanel textPanel=new JPanel();
		JPanel outPanel=new JPanel();
		JPanel namePanel=new JPanel();
		JPanel amountPanel=new JPanel();
		JPanel mainPanel=new JPanel();
		
		info=new JLabel("Wprowadz œcie¿kê dostêpu lub odnajdz plik, który chcesz skopiowaæ");
		info1=new JLabel("Ile razy chcesz skopiowaæ plik?");
		info2=new JLabel("Wprowadz lub odnajdz folder docelowy");
		info3=new JLabel("Jak¹ nazwê maj¹ mieæ kolejne kopie?");
		defaultCB=new Checkbox("Umieœæ gotowe pliki w folderze zród³owym");
		pathText=new JTextField("œcie¿ka");
		amountText=new JTextField(Integer.toString(Parameters.amount));
		outPathText=new JTextField("œcie¿ka");
		nameText=new JTextField("kopia");
		apply=new JButton("Wykonaj");
		close=new JButton("Zamknij");
		choosein=new JButton("Szukaj");
		chooseout=new JButton("Szukaj");
		bar=new JProgressBar();
		
		Font font=new Font(null, 0, 16);
		Font font1=new Font(null,0,15);
		info.setFont(font);
		info1.setFont(font);
		info2.setFont(font);
		info3.setFont(font);
		defaultCB.setFont(new Font(null,0,13));
		pathText.setFont(font1);
		amountText.setFont(font1);
		outPathText.setFont(font1);
		nameText.setFont(font1);
		apply.setFont(font1);
		close.setFont(font1);
		choosein.setFont(font1);
		chooseout.setFont(font1);

		bar.setVisible(true);
		bar.setMinimum(0);
		bar.setMaximum(4);

		//		outPathText.setEnabled(false);
//		nameText.setEnabled(false);
//		amountText.setEnabled(false);
//		defaultCB.setEnabled(false);
		
		Action pathAction=new AbstractAction() {
				/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					Parameters.inPath=pathText.getText();
					Create_copy.getFormat(Parameters.inPath);
					Parameters.file=new File(Parameters.inPath);
					System.out.println(Parameters.inPath);
				//	outPathText.setEnabled(true);
				//	defaultCB.setEnabled(true);
				}
		};
		
		Action outPathAction=new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				Parameters.outPath=outPathText.getText();
				outPathText.setText(Parameters.outPath);
			//	nameText.setEnabled(true);
			}
		};
		
		Action nameAction=new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent e) {
				Parameters.name=Main.nameText.getText();
				//amountText.setEnabled(true);
			}
		};
		
		Action amountAction=new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Parameters.amount=Integer.parseInt(Main.amountText.getText());	
				bar.setMaximum(Parameters.amount);
			}
		};
		
		pathText.addActionListener(pathAction);
		defaultCB.addItemListener(new DefaultCBActionListener());
		close.addActionListener(new CloseActionListener());
		outPathText.addActionListener(outPathAction);
		amountText.addActionListener(amountAction);
		nameText.addActionListener(nameAction);
		apply.addActionListener(new ApplyListener());
		choosein.addActionListener(new ChooseinListener());
		chooseout.addActionListener(new ChooseoutListener());
		apply.addActionListener(pathAction);
		apply.addActionListener(outPathAction);
		apply.addActionListener(nameAction);
		apply.addActionListener(amountAction);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER,centPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, downPanel);
		centPanel.setLayout(new BoxLayout(centPanel, BoxLayout.Y_AXIS));
		textPanel.setLayout(new FlowLayout());
		exPanel.setLayout(new BoxLayout(exPanel, BoxLayout.Y_AXIS));
		fPanel.setLayout(new BoxLayout(fPanel, BoxLayout.Y_AXIS));
		outPanel.setLayout(new FlowLayout());
		namePanel.setLayout(new FlowLayout());
		amountPanel.setLayout(new FlowLayout());
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		
		
		pathText.setPreferredSize(new Dimension(450,27));
		pathText.setMaximumSize(new Dimension(450,30));
		amountText.setPreferredSize(new Dimension(40,27));
		amountText.setMaximumSize(new Dimension(40,30));
		outPathText.setPreferredSize(new Dimension(450,27));
		outPathText.setMaximumSize(new Dimension(450, 30));
		nameText.setPreferredSize(new Dimension(520,27));
		nameText.setMaximumSize(new Dimension(520, 30));
		
//		info.setAlignmentX(Component.CENTER_ALIGNMENT);
//		info1.setAlignmentX(Component.CENTER_ALIGNMENT);
//		info2.setAlignmentX(Component.CENTER_ALIGNMENT);
//		info3.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		fPanel.add(info);
		
		textPanel.add(pathText);
		textPanel.add(choosein);
	
		outPanel.add(outPathText);
		outPanel.add(chooseout);
		
		namePanel.add(nameText);
		
		amountPanel.add(amountText);
		
		exPanel.add(defaultCB);
		exPanel.add(info2);
		exPanel.add(outPanel);
		
		amountText.setHorizontalAlignment(JTextField.LEFT);
		
		mainPanel.add(fPanel);
		mainPanel.add(textPanel);
		mainPanel.add(exPanel);
		mainPanel.add(info3);
		mainPanel.add(namePanel);
		mainPanel.add(info1);
		mainPanel.add(amountPanel);
		mainPanel.add(bar);
		
		centPanel.add(mainPanel);
		
//		info.setAlignmentX(Component.CENTER_ALIGNMENT);
//		textPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
//		fPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		
		downPanel.add(apply);
		downPanel.add(close);
		
		Color color=new Color(240,240,240);
		mainPanel.setBackground(color);
		centPanel.setBackground(color);
		exPanel.setBackground(color);
		amountPanel.setBackground(color);
		namePanel.setBackground(color);
		outPanel.setBackground(color);
		textPanel.setBackground(color);
		fPanel.setBackground(color);
		downPanel.setBackground(color);		


		textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		exPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		frame.setSize(700,500);
		frame.setTitle("Epikal");
		frame.setMaximumSize(new Dimension(600, 400));
		frame.setPreferredSize(new Dimension(600, 400));
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(500, 300);
	}
}
