import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("\uC911\uACE0\uCC28 \uAC70\uB798 \uC2DC\uC2A4\uD15C");
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"JBC"}));
		comboBox.setBounds(45, 56, 30, 21);
		getContentPane().add(comboBox);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 557);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Menu");
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\uD310\uB9E4 \uAE00 \uAC8C\uC2DC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//판매글게시
				UploadArticle ua = new UploadArticle();
				ua.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(471, 10, 222, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\uCC28\uB7C9 \uC2DC\uC138 \uAC80\uC0C9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//차량시세검색
				SearchCarPrice scp = new SearchCarPrice();
				scp.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(251, 10, 222, 23);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("\uCC28\uB7C9 \uAC80\uC0C9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//차량검색
				CarSearch cs = new CarSearch();
				cs.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(12, 10, 239, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SOS_LAB\\workspace\\SE\\mainpicture.jpg"));
		lblNewLabel.setBounds(50, 58, 610, 311);
		contentPane.add(lblNewLabel);

	}
}
