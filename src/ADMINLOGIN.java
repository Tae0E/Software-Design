import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ADMINLOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblLogIn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWB frame = new TestWB();
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
	public ADMINLOGIN() {
		setTitle("\uB85C\uADF8\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 286);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(94, 115, 42, 15);
		contentPane.add(lblNewLabel);
		textField = new JTextField();
		textField.setBounds(133, 112, 150, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Give Permission");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String uname = textField.getText();
				try
				{
					File file = new File("C:/Users/SOS_LAB/workspace/SE/identification.txt");
					File file2 = new File("C:/Users/SOS_LAB/workspace/SE/identification2.txt");
					FileInputStream fis = new FileInputStream(file);
					FileOutputStream fos = new FileOutputStream(file2);
					BufferedReader in = new BufferedReader(new InputStreamReader(fis));
					BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
					String line = null;
					String delData = null;
					int cnt = 0;
					String dummy = "";
					while((line = in.readLine()) != null)
					{
						dummy += (line + "\r\n");
						if(line == "*")
						{
							line = in.readLine();
							dummy += (line + "\r\n");
						}
							
						if(line.equals(uname))
						{
							cnt++;
							line = in.readLine();
							dummy += (line + "\r\n");
							
							line = in.readLine();
							delData = line;
							
							if(line.equals("true"))
							{
								JOptionPane.showMessageDialog(contentPane, "이미 권한이 부여된 상태입니다.");	
								break;
							}
							else if(line.equals("false"))
							{
								cnt++;
								dummy += "true\r\n";
								while((line=in.readLine()) != null)
								{
									dummy += (line + "\r\n");
								}
								FileWriter fw = new FileWriter("C:/Users/SOS_LAB/workspace/SE/identification.txt");
								fw.write(dummy);
								JOptionPane.showMessageDialog(contentPane, "권한 부여 완료");	
								in.close();
								fw.close();
								break;
							}
							
						}
						
					}
					in.close();
					if(cnt == 0 )
						JOptionPane.showMessageDialog(contentPane, "존재하지 않는 id입니다.");		
				}
				catch(FileNotFoundException e)
				{
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(133, 140, 150, 35);
		contentPane.add(btnNewButton);
		
		lblLogIn = new JLabel("  ADMIN MODE");
		lblLogIn.setFont(new Font("굴림", Font.BOLD, 18));
		lblLogIn.setBounds(133, 41, 150, 35);
		contentPane.add(lblLogIn);
		
		JButton btnReturnToLogin = new JButton("Return to Login");
		btnReturnToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//main
				TestWB login = new TestWB();
				login.setVisible(true);
				setVisible(false);
			}
		});
		btnReturnToLogin.setBounds(133, 177, 150, 35);
		contentPane.add(btnReturnToLogin);
	}
}
