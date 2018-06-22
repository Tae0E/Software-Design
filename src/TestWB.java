import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TestWB extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
	public TestWB() {
		setTitle("\uB85C\uADF8\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 286);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(52, 100, 73, 15);
		contentPane.add(lblNewLabel);
		textField = new JTextField();
		textField.setBounds(137, 97, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPw = new JLabel("Password");
		lblPw.setBounds(52, 125, 63, 15);
		contentPane.add(lblPw);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 122, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String uname = textField.getText();
				String psd = textField_1.getText();
				String lineid=null;
				String linepw=null;
				String linepermit;
				try
				{
					File file = new File("C:/Users/SOS_LAB/workspace/SE/identification.txt");
					BufferedReader in = new BufferedReader(new FileReader(file));
					String line = null;
					
					while((line = in.readLine()) != null)
					{
						if(line == "*")
							line = in.readLine();
						if(line.equals(uname))
						{
								lineid = line;
								linepw = in.readLine();
								linepermit = in.readLine();
								
								File session = new File("C:/Users/SOS_LAB/workspace/SE/session.txt");
								BufferedWriter s = new BufferedWriter(new FileWriter(session));
								
								s.write(lineid);
								s.newLine();
								
								s.write(linepw);
								s.newLine();
								
								s.write(linepermit);
								s.flush();
								
								break;
							
						}

							
					}
					in.close();
				}
				catch(FileNotFoundException e)
				{
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				if(uname.equals(lineid) && psd.equals(linepw) && !uname.equals("admin"))
				{
					JOptionPane.showMessageDialog(contentPane, "you are successfully logined");
					Main mainbox = new Main();
					mainbox.setVisible(true);
					setVisible(false);
				}
				else if(uname.equals(lineid) && psd.equals(linepw) && uname.equals("admin"))
				{
					JOptionPane.showMessageDialog(contentPane, "you are successfully logined as ADMINISTRATOR!!!");
					ADMINLOGIN admin = new ADMINLOGIN();
					admin.setVisible(true);
					setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(contentPane, "invalid id or password!!!");
				
			}
		});
		btnNewButton.setBounds(263, 100, 97, 44);
		contentPane.add(btnNewButton);
		
		lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("±¼¸²", Font.BOLD, 18));
		lblLogIn.setBounds(153, 41, 130, 35);
		contentPane.add(lblLogIn);
	}
}
