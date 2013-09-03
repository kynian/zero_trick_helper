package zero_trick;

/*
 * Zero Trick Helper created by Dipndawtz
 */

import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private static boolean running = false;;
	private JButton start_button;
	private JButton stop_button;
	private JLabel tl;
	private static int i = 0;
	private static JTextArea textArea;
	private static int confirm_key;
	private static BufferedReader reader;
	Robot robot;

	void start() {

		JFrame frame = new JFrame("Zero Trick Helper");
		tl = new JLabel("Running: " + running);
		start_button = new JButton("Start");
		stop_button = new JButton("Stop");
		stop_button.setEnabled(false);
		textArea = new JTextArea(10, 20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		frame.add(tl);
		frame.add(start_button);
		frame.add(stop_button);
		frame.add(scrollPane);
		frame.setSize(300, 250);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocation(400, 400);

		String file = "conf/zero_trick_helper.conf";

		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		String line = null;

		ArrayList<String> lineStore = new ArrayList<String>();

		try {
			while ((line = reader.readLine()) != null) {

				lineStore.add(line);

			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < lineStore.size(); i++) {
			if (lineStore.get(i).contains("confirm key=") || lineStore.get(i).contains("confirm key =") || lineStore.get(i).contains("confirm key= ") || lineStore.get(i).contains("confirm key = ")) {
				String[] res = lineStore.get(i).split("\\=");
				char c = '=';
				int count = countOccurrences(lineStore.get(i), c);
				String key = res[1];
				confirm_key = type(key.replaceAll("\\s", ""));
				if (count > 2 || confirm_key == -999) {
					frame.getContentPane().removeAll();
					JLabel lab = new JLabel("Error in config file! please see readme.txt");
					JButton ok = new JButton("OK");
					frame.add(lab);
					frame.add(ok);
					frame.setSize(300, 100);

					ok.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							running = false;
							System.exit(1);
						}
					});
				}

			}
		}

		try {
			robot = new Robot();
		} catch (AWTException e2) {
			e2.printStackTrace();
		}
		robot.setAutoDelay(200);

		start_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start_button.setEnabled(false);
				stop_button.setEnabled(true);
				running = true;
				tl.setText("Running: " + running);
				Executors.newSingleThreadExecutor().submit(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						while (running) {
							robot_loop(robot);
						}
					}
				});
			}
		});
		stop_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start_button.setEnabled(true);
				stop_button.setEnabled(false);
				running = false;
				tl.setText("Running: " + running);

			}
		});

	}

	public static void main(String[] args) {
		new Main().start();

	}

	private static void robot_loop(Robot robot) {

		robot.keyPress(confirm_key);
		robot.keyRelease(confirm_key);

		textArea.append("Key pressed! - " + i + "\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
		i++;

	}

	public int type(String character) {
		int ke;
		switch (character) {
		case "num0":
			ke = KeyEvent.VK_NUMPAD0;
			break;
		case "num1":
			ke = KeyEvent.VK_NUMPAD1;
			break;
		case "num2":
			ke = KeyEvent.VK_NUMPAD2;
			break;
		case "num3":
			ke = KeyEvent.VK_NUMPAD3;
			break;
		case "num4":
			ke = KeyEvent.VK_NUMPAD4;
			break;
		case "num5":
			ke = KeyEvent.VK_NUMPAD5;
			break;
		case "num6":
			ke = KeyEvent.VK_NUMPAD6;
			break;
		case "num7":
			ke = KeyEvent.VK_NUMPAD7;
			break;
		case "num8":
			ke = KeyEvent.VK_NUMPAD8;
			break;
		case "num9":
			ke = KeyEvent.VK_NUMPAD9;
			break;
		case "a":
			ke = KeyEvent.VK_A;
			break;
		case "b":
			ke = KeyEvent.VK_B;
			break;
		case "c":
			ke = KeyEvent.VK_C;
			break;
		case "d":
			ke = KeyEvent.VK_D;
			break;
		case "e":
			ke = KeyEvent.VK_E;
			break;
		case "f":
			ke = KeyEvent.VK_F;
			break;
		case "g":
			ke = KeyEvent.VK_G;
			break;
		case "h":
			ke = KeyEvent.VK_H;
			break;
		case "i":
			ke = KeyEvent.VK_I;
			break;
		case "j":
			ke = KeyEvent.VK_J;
			break;
		case "k":
			ke = KeyEvent.VK_K;
			break;
		case "l":
			ke = KeyEvent.VK_L;
			break;
		case "m":
			ke = KeyEvent.VK_M;
			break;
		case "n":
			ke = KeyEvent.VK_N;
			break;
		case "o":
			ke = KeyEvent.VK_O;
			break;
		case "p":
			ke = KeyEvent.VK_P;
			break;
		case "q":
			ke = KeyEvent.VK_Q;
			break;
		case "r":
			ke = KeyEvent.VK_R;
			break;
		case "s":
			ke = KeyEvent.VK_S;
			break;
		case "t":
			ke = KeyEvent.VK_T;
			break;
		case "u":
			ke = KeyEvent.VK_U;
			break;
		case "v":
			ke = KeyEvent.VK_V;
			break;
		case "w":
			ke = KeyEvent.VK_W;
			break;
		case "x":
			ke = KeyEvent.VK_X;
			break;
		case "y":
			ke = KeyEvent.VK_Y;
			break;
		case "z":
			ke = KeyEvent.VK_Z;
			break;
		case "`":
			ke = KeyEvent.VK_BACK_QUOTE;
			break;
		case "0":
			ke = KeyEvent.VK_0;
			break;
		case "1":
			ke = KeyEvent.VK_1;
			break;
		case "2":
			ke = KeyEvent.VK_2;
			break;
		case "3":
			ke = KeyEvent.VK_3;
			break;
		case "4":
			ke = KeyEvent.VK_4;
			break;
		case "5":
			ke = KeyEvent.VK_5;
			break;
		case "6":
			ke = KeyEvent.VK_6;
			break;
		case "7":
			ke = KeyEvent.VK_7;
			break;
		case "8":
			ke = KeyEvent.VK_8;
			break;
		case "9":
			ke = KeyEvent.VK_9;
			break;
		case "-":
			ke = KeyEvent.VK_MINUS;
			break;
		case "=":
			ke = KeyEvent.VK_EQUALS;
			break;
		case "!":
			ke = KeyEvent.VK_EXCLAMATION_MARK;
			break;
		case "@":
			ke = KeyEvent.VK_AT;
			break;
		case "#":
			ke = KeyEvent.VK_NUMBER_SIGN;
			break;
		case "$":
			ke = KeyEvent.VK_DOLLAR;
			break;
		case "^":
			ke = KeyEvent.VK_CIRCUMFLEX;
			break;
		case "&":
			ke = KeyEvent.VK_AMPERSAND;
			break;
		case "*":
			ke = KeyEvent.VK_ASTERISK;
			break;
		case "(":
			ke = KeyEvent.VK_LEFT_PARENTHESIS;
			break;
		case ")":
			ke = KeyEvent.VK_RIGHT_PARENTHESIS;
			break;
		case "_":
			ke = KeyEvent.VK_UNDERSCORE;
			break;
		case "+":
			ke = KeyEvent.VK_PLUS;
			break;
		case "\t":
			ke = KeyEvent.VK_TAB;
			break;
		case "\n":
			ke = KeyEvent.VK_ENTER;
			break;
		case "[":
			ke = KeyEvent.VK_OPEN_BRACKET;
			break;
		case "]":
			ke = KeyEvent.VK_CLOSE_BRACKET;
			break;
		case "\\":
			ke = KeyEvent.VK_BACK_SLASH;
			break;
		case ";":
			ke = KeyEvent.VK_SEMICOLON;
			break;
		case ":":
			ke = KeyEvent.VK_COLON;
			break;
		case "\'":
			ke = KeyEvent.VK_QUOTE;
			break;
		case "\"":
			ke = KeyEvent.VK_QUOTEDBL;
			break;
		case ",":
			ke = KeyEvent.VK_COMMA;
			break;
		case "<":
			ke = KeyEvent.VK_LESS;
			break;
		case ".":
			ke = KeyEvent.VK_PERIOD;
			break;
		case ">":
			ke = KeyEvent.VK_GREATER;
			break;
		case "/":
			ke = KeyEvent.VK_SLASH;
			break;
		case " ":
			ke = KeyEvent.VK_SPACE;
			break;
		default:
			ke = -999;
		}
		return ke;
	}

	public static int countOccurrences(String haystack, char needle) {
		int count = 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle) {
				count++;
			}
		}
		return count;
	}
}