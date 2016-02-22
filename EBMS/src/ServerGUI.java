import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 리스트 목록 프레임
class ServerGUIList extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;

	// 생성자
	ServerGUIList() {
		super("Chat Server");
		setTitle("List");
		// need to be informed when the user click the close button on the frame
		setSize(300, 400);
		// 화면 사이즈 구하기 및 화면 중앙에 출력
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension f_size = this.getSize();

		int xpos = (int) ((screen.getWidth() / 2) - (f_size.getWidth() / 2));
		int ypos = (int) ((screen.getHeight() / 2) - (f_size.getHeight() / 2));

		this.setLocation(xpos, ypos);
		// 화면 중앙에 뿌리기 종료
		setVisible(false);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

}

/*
 * The server as a GUI
 */
public class ServerGUI extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	// 서버 시작 및 중지 버튼.
	private JButton stopStart;
	// 포트 넘버 필드.
	private JTextField tPortNumber;
	
	// my server
	private Server server;
	private JPanel menuBar;
	private JPanel sidebar;

	private JButton post;
	private JButton upload;
	private JButton selectPublic;
	private JButton allPublic;
	private JButton link;
	private JButton btn1;
	private JButton btn3;
	private JButton btn4;
	private JButton btn2;
	private JButton btn5;
	private JButton btn6;

	// JTextArea 챗팅과 이벤트.
	private JTextArea chat, event;

	// GUI 꾸미기.
	ServerGUI(int port) {
		super("Chat Server");
		setTitle("Server");
		server = null;
		
		JPanel north = new JPanel();
		north.add(new JLabel("Port number: "));
		tPortNumber = new JTextField("  " + port);
		north.add(tPortNumber);
		// to stop or start the server, we start with "Start"
		stopStart = new JButton("Start");
		stopStart.setActionCommand("stopStart");
		stopStart.addActionListener(this);
		north.add(stopStart);
		getContentPane().add(north, BorderLayout.NORTH);

		// 각 게시판 연결.
		JPanel center = new JPanel(new GridLayout(0, 3));
		getContentPane().add(center);

		btn1 = new JButton("연결 없음");
		btn1.setActionCommand("non");
		btn1.addActionListener(this);
		center.add(btn1);

		btn2 = new JButton("연결 없음");
		btn2.setActionCommand("non");
		btn2.addActionListener(this);
		center.add(btn2);

		btn3 = new JButton("연결 없음");
		btn3.setActionCommand("non");
		btn3.addActionListener(this);
		center.add(btn3);

		btn4 = new JButton("연결 없음");
		btn4.setActionCommand("non");
		btn4.addActionListener(this);
		center.add(btn4);

		btn5 = new JButton("연결 없음");
		btn5.setActionCommand("non");
		btn5.addActionListener(this);
		center.add(btn5);

		btn6 = new JButton("연결 없음");
		btn6.setActionCommand("non");
		btn6.addActionListener(this);
		center.add(btn6);

		// 메뉴 목록.
		menuBar = new JPanel();
		getContentPane().add(menuBar, BorderLayout.SOUTH);

		link = new JButton("연결 목록");
		link.setActionCommand("link");
		link.addActionListener(this);
		menuBar.add(link);

		post = new JButton("게시 목록");
		post.setActionCommand("post");
		post.addActionListener(this);
		menuBar.add(post);

		upload = new JButton("자료 업로드");
		upload.setActionCommand("upload");
		upload.addActionListener(this);
		menuBar.add(upload);

		selectPublic = new JButton("선택 게시");
		selectPublic.setActionCommand("selectPublic");
		selectPublic.addActionListener(this);
		menuBar.add(selectPublic);

		allPublic = new JButton("전체 게시");
		allPublic.setActionCommand("allPublic");
		allPublic.addActionListener(this);
		menuBar.add(allPublic);

		// the event room
		sidebar = new JPanel();
		event = new JTextArea(0, 20);
		event.setLineWrap(true);
		event.setEditable(false);
		
		appendEvent("Events log.\n");
		sidebar.setLayout(new GridLayout(0, 1, 0, 0));
		sidebar.add(new JScrollPane(event));
		getContentPane().add(sidebar, BorderLayout.EAST);

		addWindowListener(this);
		setSize(600, 600);
		
		// 화면을 중앙에 표시
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension f_size = this.getSize();

		int xpos = (int) ((screen.getWidth() / 2) - (f_size.getWidth() / 2));
		int ypos = (int) ((screen.getHeight() / 2) - (f_size.getHeight() / 2));

		this.setLocation(xpos, ypos);

		// 화면 출력.
		setVisible(true);
	}

	// JTextArea에 메시지 추가.
	void appendRoom(String str) {
		event.append(str);
		event.setCaretPosition(event.getText().length() - 1);
	}

	void appendEvent(String str) {
		event.append(str);
		event.setCaretPosition(event.getText().length() - 1);
	}

	// start or stop where clicked
	public void actionPerformed(ActionEvent e) {

		if ((e.getActionCommand().equals("stopStart"))) {
			// if running we have to stop
			if (server != null) {
				server.stop();
				server = null;
				tPortNumber.setEditable(true);
				stopStart.setText("Start");
				return;
			}
			// OK start the server
			int port;
			try {
				port = Integer.parseInt(tPortNumber.getText().trim());
			} catch (Exception er) {
				appendEvent("Invalid port number");
				return;
			}
			// ceate a new Server
			server = new Server(port, this);
			// and start it as a thread
			new ServerRunning().start();
			stopStart.setText("Stop");
			tPortNumber.setEditable(false);
		}

		else {
			ServerGUIList b = new ServerGUIList();
			b.setVisible(true);
		}

	}

	// 서버 시작 진입점.
	public static void main(String[] arg) {
		// 서버를 기본 1500 포트로 시작.
		new ServerGUI(1500);
	}

	/*
	 * 사용자가 서버 닫기 버튼을 누르면 서버와 포트를 닫는다.
	 */
	public void windowClosing(WindowEvent e) {
		// 만약 서버가 종료 되면 서버를 닫는다.
		if (server != null) {
			try {
				server.stop(); // 연결을 종료하도록 서버에 통보한다.
			} catch (Exception eClose) {
			}
			server = null;
		}
		
		dispose();
		System.exit(0);
	}

	// I can ignore the other WindowListener method
	public void windowClosed(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	/*
	 * A thread to run the Server
	 */
	class ServerRunning extends Thread {
		public void run() {
			server.start(); // 서버를 시작시킨다.

			// 충돌이 일어나는 경우.
			stopStart.setText("Start");
			tPortNumber.setEditable(true);
			appendEvent("Server crashed\n");
			server = null;
		}
	}

}
