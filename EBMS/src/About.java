import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class About {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public About() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);

		/* 화면을 중앙으로 정렬 */
		Dimension frameSize = frame.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("/Users/oming/Desktop/ebms_logo.png"));
		panel.add(lblLogo);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JLabel lblAbout = new JLabel(
				"<html>\n<pre>E.B.M.S 시스템입니다.<br>\n&copy EBMS. All Right Reserved.\n</pre>\n</html>");
		panel_1.add(lblAbout);
	}

}
