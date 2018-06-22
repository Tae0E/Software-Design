import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class SearchCarPrice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCarPrice frame = new SearchCarPrice();
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
	public SearchCarPrice() {
		setTitle("\uCC28\uB7C9 \uC2DC\uC138 \uAC80\uC0C9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\uCC28\uB7C9 \uAC80\uC0C9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//차량검색
				CarSearch cs2 = new CarSearch();
				cs2.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(12, 10, 239, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uCC28\uB7C9 \uC2DC\uC138 \uAC80\uC0C9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//차량시세검색
				SearchCarPrice scp2 = new SearchCarPrice();
				scp2.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(251, 10, 222, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\uD310\uB9E4 \uAE00 \uAC8C\uC2DC");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//판매 글 게시
				UploadArticle ua2 = new UploadArticle();
				ua2.setVisible(true);
				setVisible(false);
			}
		});
		button_2.setBounds(471, 10, 222, 23);
		contentPane.add(button_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\SOS_LAB\\workspace\\SE\\차량시세.jpg"));
		label.setBounds(12, 43, 681, 475);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(label);
		scrollPane.setSize(640, 801);
		scrollPane.setBounds(12, 43, 681, 475);
		scrollPane.setVisible(true);
		contentPane.add(scrollPane);
		

	}
}
