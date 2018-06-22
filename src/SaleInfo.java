import java.awt.EventQueue;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaleInfo extends JFrame {

	private JPanel contentPane;
	public static File f;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleInfo frame = new SaleInfo(f);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public SaleInfo(File f) throws IOException {
		setTitle("\uD310\uB9E4 \uC815\uBCF4");
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
				CarSearch cs = new CarSearch();
				cs.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(12, 10, 239, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uCC28\uB7C9 \uC2DC\uC138 \uAC80\uC0C9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//차량 시세 검색
				SearchCarPrice scp = new SearchCarPrice();
				scp.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(251, 10, 222, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\uD310\uB9E4 \uAE00 \uAC8C\uC2DC");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//판매 글 게시
				UploadArticle ua = new UploadArticle();
				ua.setVisible(true);
				setVisible(false);
			}
		});
		button_2.setBounds(471, 10, 222, 23);
		contentPane.add(button_2);
		
		String path = f.toString();
		BufferedReader in = new BufferedReader(new FileReader(path+"/info.txt"));
		String arr[] = new String[11];
		for(int i = 0; i<11; i++)
		{
			arr[i] = in.readLine();
		}
		
		ImageIcon icon = new ImageIcon(path+"/picture.jpg");
		Image before = icon.getImage();
		Image after = before.getScaledInstance(600, 200, java.awt.Image.SCALE_SMOOTH);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 243, 600, 200);
		contentPane.add(textArea);
		
		textArea.setText("제조사 : "+arr[0] + "\n이름 : " + arr[1] + "\n차종 : " + arr[2] + "\n연식 : " + arr[3] + "\n연료 : " + arr[4] + "\n배기량 : " + arr[5] + "\n키로수 : " + arr[6] + "\n판매지역 : " + arr[7] + "\n가격 : " + arr[8] + "\n판매자 : " + arr[9] + "\n판매자 연락처 : " + arr[10] + "\n");
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 43, 600, 300);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(after));

		JButton button_3 = new JButton("\uAD6C\uB9E4\uD558\uAE30");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//구매하기
				Purchase pc = new Purchase(arr, path);
				pc.setVisible(true);
				setVisible(false);
			}
		});
		button_3.setBounds(272, 453, 138, 54);
		contentPane.add(button_3);
	}
}
