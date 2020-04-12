import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Customer_App {

	protected static final String DefaultTableModel = null;
	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private JTextField name;
	private JTextField phone;
	private JTextField email;
	private JTextField idx;
	private JTextField searchInput;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TableData td = new TableData();
		frame = new JFrame();
		frame.setSize(805, 533);
		frame.getContentPane().setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 800, 483);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);

		JLabel lblNewLabel_3 = new JLabel("이 름");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 21));
		lblNewLabel_3.setBounds(10, 53, 63, 25);
		mainPanel.add(lblNewLabel_3);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("굴림", Font.BOLD, 21));
		lblEmail.setBounds(10, 88, 63, 25);
		mainPanel.add(lblEmail);

		JLabel lblGender = new JLabel("성 별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.BOLD, 21));
		lblGender.setBounds(10, 158, 63, 25);
		mainPanel.add(lblGender);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("굴림", Font.BOLD, 21));
		lblPhone.setBounds(0, 122, 97, 25);
		mainPanel.add(lblPhone);

		JLabel lblIdx = new JLabel("번 호");
		lblIdx.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdx.setFont(new Font("굴림", Font.BOLD, 21));
		lblIdx.setBounds(10, 18, 63, 25);
		mainPanel.add(lblIdx);

		JLabel lblNote = new JLabel("메 모");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("굴림", Font.BOLD, 21));
		lblNote.setBounds(10, 193, 63, 25);
		mainPanel.add(lblNote);

		name = new JTextField();
		name.setFont(new Font("굴림", Font.PLAIN, 18));
		name.setBounds(103, 53, 85, 25);
		mainPanel.add(name);
		name.setColumns(10);

		phone = new JTextField();
		phone.setFont(new Font("굴림", Font.PLAIN, 10));
		phone.setColumns(10);
		phone.setBounds(103, 123, 85, 25);
		mainPanel.add(phone);

		email = new JTextField();
		email.setFont(new Font("굴림", Font.PLAIN, 10));
		email.setColumns(10);
		email.setBounds(103, 87, 85, 25);
		mainPanel.add(email);

		idx = new JTextField();
		idx.setFont(new Font("굴림", Font.PLAIN, 18));
		idx.setColumns(10);
		idx.setBounds(103, 18, 85, 25);
		mainPanel.add(idx);

		JComboBox gender = new JComboBox(new String[] { "남", "여" });
		gender.setModel(new DefaultComboBoxModel(new String[] { "남", "여" }));
		gender.setBackground(Color.WHITE);
		gender.setFont(new Font("굴림", Font.PLAIN, 18));
		gender.setBounds(103, 157, 85, 25);
		mainPanel.add(gender);

		JTextArea note = new JTextArea();
		note.setBackground(new Color(255, 255, 204));
		note.setBounds(22, 221, 150, 186);
		mainPanel.add(note);

		JButton btnNewButton = new JButton("추   가");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean fileExists = new File("C:\\java\\workspace\\cm_program\\data.csv").exists();
					FileWriter fw = new FileWriter("C:\\java\\workspace\\cm_program\\data.csv", true);

					if (!fileExists) {
						fw.append("번호, 이름, 이메일, 전화번호, 성별, 메모\n");
					}
					String idxTxt = idx.getText();
					String nameTxt = name.getText();
					String emailTxt = email.getText();
					String phoneTxt = phone.getText();
					String genderTxt = gender.getSelectedItem().toString();
					String noteTxt = note.getText();
					if (nameTxt.equals("") || emailTxt.equals("") || phoneTxt.equals("") || idxTxt.equals("")
							|| genderTxt.equals("")) {
						JOptionPane.showMessageDialog(null, "모든 데이터를 입력하시오(메모는 선택)");
					} else {

						fw.append(idxTxt + "," + nameTxt + "," + emailTxt + "," + phoneTxt + "," + genderTxt + ","
								+ noteTxt + "\n");
						JOptionPane.showMessageDialog(null, "추가 되었습니다!");
					}
					name.setText("");
					email.setText("");
					phone.setText("");
					idx.setText("");
					gender.setSelectedIndex(0);
					note.setText("");
					fw.close();
					td.refresh();
				} catch (Exception ec) {
					JOptionPane.showMessageDialog(null, "에러 발생!");
				}

			}
		});
		btnNewButton.setBounds(46, 417, 153, 45);
		mainPanel.add(btnNewButton);

		JLabel searchlbl = new JLabel("검   색:");
		searchlbl.setFont(new Font("굴림", Font.BOLD, 25));
		searchlbl.setBounds(440, 417, 97, 45);
		mainPanel.add(searchlbl);

		searchInput = new JTextField();
		searchInput.setFont(new Font("굴림", Font.BOLD, 25));
		searchInput.setBounds(538, 417, 237, 45);
		mainPanel.add(searchInput);
		searchInput.setColumns(10);

		JPanel tp = new JPanel();
		tp.setBounds(200, 10, 588, 366);
		mainPanel.add(tp);
		table = new JTable(td);
		table.setBounds(12, 10, 564, 346);
		table.setRowHeight(30);

		table.setFont(new Font("Sansserif", Font.BOLD, 15));
		table.setPreferredScrollableViewportSize(new Dimension(560, 330));
		tp.add(new JScrollPane(table));
		tp.setOpaque(false);

		JButton deleteBtn = new JButton("삭   제");
		deleteBtn.setFont(new Font("굴림", Font.BOLD, 25));
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow();
				if (rowIndex == -1)
					return;
				td.deleteList(rowIndex);
				// String deleteName = td.list.get(rowIndex).getName();
				// System.out.println(deleteName);

//				try {
//					FileWriter fw = new FileWriter("./data.csv", true);
//					System.out.println(td.list.get(rowIndex));
//					
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}

				// td.list.remove(rowIndex);
				// td.refresh();
			}
		});
		deleteBtn.setBounds(241, 417, 153, 45);
		mainPanel.add(deleteBtn);

		ImagePanel welcomePanel = new ImagePanel(
				new ImageIcon("C:\\java\\workspace\\java_swing/image/welcome.jpg").getImage());
		welcomePanel.setBounds(0, 0, 800, 483);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("고객 관리 시스템");
		lblNewLabel.setBounds(251, 163, 248, 61);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		welcomePanel.add(lblNewLabel);

		id = new JTextField();
		id.setBounds(318, 219, 146, 36);
		id.setFont(new Font("굴림", Font.BOLD, 25));
		id.setToolTipText("Enter ID");
		welcomePanel.add(id);
		id.setColumns(10);

		password = new JPasswordField();
		password.setBounds(318, 263, 146, 36);
		welcomePanel.add(password);

		JLabel lblNewLabel_1 = new JLabel("ID  : ");
		lblNewLabel_1.setBounds(255, 222, 58, 30);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 25));
		welcomePanel.add(lblNewLabel_1);

		JLabel lblPs = new JLabel("PW :");
		lblPs.setBounds(251, 263, 62, 30);
		lblPs.setFont(new Font("굴림", Font.PLAIN, 25));
		welcomePanel.add(lblPs);

		JButton btnLogIn = new JButton("");
		btnLogIn.setBounds(318, 309, 146, 36);
		btnLogIn.setIcon(new ImageIcon("C:\\java\\workspace\\java_swing\\image\\login.JPG"));
		btnLogIn.setPressedIcon(new ImageIcon("C:\\java\\workspace\\java_swing\\image\\login_clicked.JPG"));
		btnLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (id.getText().equals("admin") && Arrays.equals(password.getPassword(), "1234".toCharArray())) {
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패!");
				}
			}
		});

		welcomePanel.add(btnLogIn);

		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(212, 37, 186));
		header.setForeground(new Color(255, 255, 255));
		header.setFont(new Font("Sansserif", Font.BOLD, 15));

		searchInput.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String search = searchInput.getText();
				TableRowSorter<AbstractTableModel> trs = new TableRowSorter<>(td);
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");

		bar.add(fileMenu);
		bar.add(aboutMenu);

		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		return bar;
	}
}

class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public int getWidth() {
		return img.getWidth(null);
	}

	public int getHeight() {
		return img.getHeight(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
