import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class MainFrame {

	private JFrame frmEbms;


	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
		frmEbms.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEbms = new JFrame();
		frmEbms.setTitle("EBMS");
		frmEbms.setBounds(100, 100, 800, 600);
		frmEbms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmEbms.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmServerStart = new JMenuItem("Server Start");
		mnFile.add(mntmServerStart);
		
		JMenuItem mntmServerStop = new JMenuItem("Server Stop");
		mnFile.add(mntmServerStop);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		frmEbms.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelFrame = new JPanel();
		frmEbms.getContentPane().add(panelFrame, BorderLayout.CENTER);
		panelFrame.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel label = new JLabel("1");
		label.setVerticalAlignment(SwingConstants.TOP);
		panelFrame.add(label);
		
		JLabel label_1 = new JLabel("2");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		panelFrame.add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		panelFrame.add(label_2);
		
		JLabel label_3 = new JLabel("4");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		panelFrame.add(label_3);
		
		JLabel label_4 = new JLabel("5");
		label_4.setVerticalAlignment(SwingConstants.TOP);
		panelFrame.add(label_4);
		
		JLabel label_5 = new JLabel("6");
		label_5.setVerticalAlignment(SwingConstants.TOP);
		panelFrame.add(label_5);
		
		JLabel label_6 = new JLabel("7");
		label_6.setVerticalAlignment(SwingConstants.TOP);
		panelFrame.add(label_6);
		
		JLabel label_7 = new JLabel("8");
		label_7.setVerticalAlignment(SwingConstants.TOP);
		panelFrame.add(label_7);
		
		JLabel label_8 = new JLabel("9");
		label_8.setVerticalAlignment(SwingConstants.TOP);
		panelFrame.add(label_8);
		
		JPanel panelControl = new JPanel();
		frmEbms.getContentPane().add(panelControl, BorderLayout.SOUTH);
		
		JButton btnStartstop = new JButton("Start/Stop");
		panelControl.add(btnStartstop);
		
		JButton btnPicontrol = new JButton("PiControl");
		panelControl.add(btnPicontrol);
		
		JButton btnDivisionFrame = new JButton("Division Frame");
		panelControl.add(btnDivisionFrame);
	}

}
