import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Purchase extends JFrame {

	private JPanel contentPane;
	public static String arr[];
	public static String path;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Purchase frame = new Purchase(arr, path);
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
	public Purchase(String []a, String p) {
		setTitle("\uAD6C\uB9E4");
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
		JTextArea textArea = new JTextArea();
		textArea.setText("������ : "+a[0] + "\n�̸� : " + a[1] + "\n���� : " + a[2] + "\n���� : " + a[3] + "\n���� : " + a[4] + "\n��ⷮ : " + a[5] + "\nŰ�μ� : " + a[6] + "\n�Ǹ����� : " + a[7] + "\n���� : " + a[8] + "\n�Ǹ��� : " + a[9] + "\n�Ǹ��� ����ó : " + a[10] + "\n");
		textArea.setBounds(12, 43, 664, 235);
		contentPane.add(textArea);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uC608");
		rdbtnNewRadioButton.setBounds(16, 312, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uC544\uB2C8\uC624");
		rdbtnNewRadioButton_1.setBounds(141, 312, 121, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel label = new JLabel("\uC0C1\uAE30 \uB0B4\uC6A9\uC740 \uBCF8\uC778\uC774 \uAD6C\uB9E4\uD558\uB824\uB294 \uCC28\uB7C9\uC758 \uC815\uBCF4\uAC00 \uB9DE\uC2B5\uB2C8\uAE4C?");
		label.setBounds(12, 288, 664, 15);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\uAD6C\uB9E4\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected())
				{
					JOptionPane.showMessageDialog(contentPane, "���Ű� �Ϸ�Ǿ����ϴ�.");
					File file1 = new File(path+"/info.txt");
					File file2 = new File(path+"/picture.jpg");
					File dir = new File(path);
					file1.delete();
					file2.delete();
					dir.delete();
					
				}
				else if(rdbtnNewRadioButton_1.isSelected())
				{
					JOptionPane.showMessageDialog(contentPane, "���Ű� ��ҵǾ����ϴ�.");
					Main mn = new Main();
					mn.setVisible(true);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "������ ������ ������������ Ȯ���Ͽ� �ּ���.");
				}
			}
		});
		btnNewButton.setBounds(12, 341, 97, 23);
		contentPane.add(btnNewButton);
	}
}
