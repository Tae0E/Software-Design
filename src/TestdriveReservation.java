import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TestdriveReservation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestdriveReservation frame = new TestdriveReservation();
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
	public TestdriveReservation() {
		setTitle("\uC2DC\uC2B9 \uC608\uC57D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\uCC28\uB7C9 \uAC80\uC0C9");
		button.setBounds(12, 10, 239, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uCC28\uB7C9 \uC2DC\uC138 \uAC80\uC0C9");
		button_1.setBounds(251, 10, 222, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\uD310\uB9E4 \uAE00 \uAC8C\uC2DC");
		button_2.setBounds(471, 10, 222, 23);
		contentPane.add(button_2);
		
		JLabel label = new JLabel("\uC2DC\uC2B9 \uC608\uC57D");
		label.setFont(new Font("±¼¸²", Font.BOLD, 18));
		label.setBounds(146, 32, 337, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uC2DC\uC2B9\uD560 \uB0A0\uC9DC\uB97C \uC785\uB825\uD574 \uC8FC\uC138\uC694.  (ex. 2017-03-21-15:00~17:00)");
		label_1.setBounds(143, 100, 391, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(146, 125, 347, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button_3 = new JButton("\uC608\uC57D");
		button_3.setBounds(396, 156, 97, 23);
		contentPane.add(button_3);
	}

}
