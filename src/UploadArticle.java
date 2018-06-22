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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UploadArticle extends JFrame {
	public File file1; 
	public File l;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadArticle frame = new UploadArticle();
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
	public UploadArticle() {
		setTitle("\uD310\uB9E4 \uAE00 \uC62C\uB9AC\uAE30");
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
				CarSearch cs1 = new CarSearch();
				cs1.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(12, 10, 239, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uCC28\uB7C9 \uC2DC\uC138 \uAC80\uC0C9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//차량시세검색
				SearchCarPrice scp1 = new SearchCarPrice();
				scp1.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(251, 10, 222, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\uD310\uB9E4 \uAE00 \uAC8C\uC2DC");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//판매 글 게시
				UploadArticle ua1 = new UploadArticle();
				ua1.setVisible(true);
				setVisible(false);
			}
		});
		button_2.setBounds(471, 10, 222, 23);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("\uD310\uB9E4 \uAE00 \uC62C\uB9AC\uAE30");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(54, 30, 461, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC0AC\uC9C4 \uCCA8\uBD80");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();		// 파일 선택기를 사용
				File file;
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					file = fc.getSelectedFile();
					
					File dir = new File("C:/Users/SOS_LAB/workspace/SE/article/");
					File[] fileList = dir.listFiles();
					
					File d = new File("C:/Users/SOS_LAB/workspace/SE/article/0");
					int cnt=0;

					for(int j = 0; j<fileList.length; j++)
					{
						if(fileList[j].equals(d))
						{
							cnt++;
						}	
					}
					if(cnt>0)
					{
						cnt=0;
						int n=1;
						while(true)
						{
							d = new File("C:/Users/SOS_LAB/workspace/SE/article/"+n);
							for(int j = 0; j<fileList.length; j++)
							{
								if(fileList[j].equals(d))
									cnt++;				
							}
							if(cnt>0)
								n++;
							else
							{
								d.mkdirs();
								break;
							}
							cnt=0;
						}
					}
					else
					{
						d.mkdirs();
					}
					file1 = d;
					//여기까지 폴더생성
			        String a = file.toString();
			        String b = null;
			        for(int i = a.length()-1; i>=0; i--)
			        {
			        	if(a.charAt(i) == '.')
			        	{
			        		b = a.substring(i, a.length());
			        		break;
			        	}
			        }
			        FileInputStream input = null;
			        FileOutputStream output = null;
			        try {
						input = new FileInputStream(file);
						output = new FileOutputStream(new File(d+"/picture"+b));
						l = new File(d+"/picture"+b);
						int readBuffer = 0;
			            byte [] buffer = new byte[512];
			            while((readBuffer = input.read(buffer)) != -1) {
			                output.write(buffer, 0, readBuffer);
			            }
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
			            try{
			                // 생성된 InputStream Object를 닫아준다.
			                input.close();
			                // 생성된 OutputStream Object를 닫아준다.
			                output.close();
			            } catch(IOException io) {}
					}

				}
				else  {
						JOptionPane.showMessageDialog(null, "파일을 선택하세요.", "오류", JOptionPane.ERROR_MESSAGE);
						return;
				}

			}
		});
		btnNewButton.setBounds(12, 82, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\uC81C\uC870\uC0AC");
		label.setBounds(12, 128, 57, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uC774\uB984");
		label_1.setBounds(12, 153, 57, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uCC28\uC885");
		lblNewLabel_1.setBounds(12, 178, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC5F0\uC2DD");
		lblNewLabel_2.setBounds(12, 203, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC5F0\uB8CC \uBC29\uC2DD");
		lblNewLabel_3.setBounds(12, 228, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uBC30\uAE30\uB7C9");
		lblNewLabel_4.setBounds(12, 253, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uD0A4\uB85C\uC218");
		lblNewLabel_5.setBounds(12, 278, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uD310\uB9E4\uC9C0\uC5ED");
		lblNewLabel_6.setBounds(12, 303, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uAC00\uACA9");
		lblNewLabel_7.setBounds(12, 328, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\uD310\uB9E4\uC790 \uC774\uB984");
		lblNewLabel_8.setBounds(12, 353, 72, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\uD310\uB9E4\uC790 \uC5F0\uB77D\uCC98");
		lblNewLabel_9.setBounds(12, 378, 84, 15);
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(137, 125, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 150, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 175, 116, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(137, 200, 116, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(137, 225, 116, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(137, 250, 116, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(137, 275, 116, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(137, 300, 116, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(137, 325, 116, 21);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(137, 350, 116, 21);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(137, 375, 116, 21);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uD310\uB9E4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//판매버튼
				File sessiondir = new File("C:/Users/SOS_LAB/workspace/SE/session.txt");
				try {
					BufferedReader in = new BufferedReader(new FileReader(sessiondir));
					String line = null;
					line = in.readLine();
					line = in.readLine();
					line = in.readLine();
					
					if(line.equals("true"))
					{
						String input1 = textField.getText();
						String input2 = textField_1.getText();
						String input3 = textField_2.getText();
						String input4 = textField_3.getText();
						String input5 = textField_4.getText();
						String input6 = textField_5.getText();
						String input7 = textField_6.getText();
						String input8 = textField_7.getText();
						String input9 = textField_8.getText();
						String input10 = textField_9.getText();
						String input11 = textField_10.getText();					
							
						File k = new File(file1+"/info.txt");
						BufferedWriter s;
						try {
							s = new BufferedWriter(new FileWriter(k));
							
							s.write(input1);
							s.newLine();
										
							s.write(input2);
							s.newLine();
										
							s.write(input3);
							s.newLine();
								
							s.write(input4);
							s.newLine();
								
							s.write(input5);
							s.newLine();
								
							s.write(input6);
							s.newLine();
								
							s.write(input7);
							s.newLine();
								
							s.write(input8);
							s.newLine();
								
							s.write(input9);
							s.newLine();
								
							s.write(input10);
							s.newLine();
								
							s.write(input11);
							s.flush();
								
							JOptionPane.showMessageDialog(contentPane, "글올리기가 완료되었습니다! Main화면으로 이동합니다.");
							s.close();
							Main ma = new Main();
							ma.setVisible(true);
							setVisible(false);
						} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						in.close();
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane, "권한이 없습니다");
						l.delete();
						file1.delete();
					}
						

				} catch (IOException e1) {
						// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnNewButton_1.setBounds(12, 417, 239, 52);
		contentPane.add(btnNewButton_1);
	}

}
