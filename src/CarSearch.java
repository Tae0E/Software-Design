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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CarSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarSearch frame = new CarSearch();
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
	public CarSearch() {
		setTitle("\uCC28\uB7C9 \uAC80\uC0C9");
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
				CarSearch cs3 = new CarSearch();
				cs3.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(12, 10, 239, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uCC28\uB7C9 \uC2DC\uC138 \uAC80\uC0C9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//차량시세검색
				SearchCarPrice scp3 = new SearchCarPrice();
				scp3.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(251, 10, 222, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\uD310\uB9E4 \uAE00 \uAC8C\uC2DC");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//판매 글 게시
				UploadArticle ua3 = new UploadArticle();
				ua3.setVisible(true);
				setVisible(false);
			}
		});
		button_2.setBounds(471, 10, 222, 23);
		contentPane.add(button_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC120\uD0DD \uC5C6\uC74C", "\uCC28\uB7C9 \uD68C\uC0AC", "\uC774\uB984", "\uCC28\uC885", "\uC5F0\uC2DD", "\uC5F0\uB8CC \uBC29\uC2DD", "\uBC30\uAE30\uB7C9", "\uD0A4\uB85C\uC218", "\uC9C0\uC5ED"}));
		comboBox.setBounds(186, 142, 200, 28);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(187, 192, 199, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\uD56D\uBAA9 \uC120\uD0DD");
		label.setBounds(83, 142, 91, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uD56D\uBAA9 \uC785\uB825");
		label_1.setBounds(84, 191, 91, 28);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt=null;
				int index=0;
				if(comboBox.getSelectedItem().toString().equals("선택 없음"))
					JOptionPane.showMessageDialog(contentPane, "항목을 선택해 주세요");
				else if(comboBox.getSelectedItem().toString().equals("차량 회사"))
				{
					if(textField.getText().length() != 0)
					{
						txt = textField.getText();
						index=1;
					}
					else
						JOptionPane.showMessageDialog(contentPane, "항목을 입력해 주세요");
				}
				else if(comboBox.getSelectedItem().toString().equals("이름"))
				{
					if(textField.getText().length() != 0)
					{
						txt = textField.getText();
						index=2;
					}
					else
						JOptionPane.showMessageDialog(contentPane, "항목을 입력해 주세요");
				}
				else if(comboBox.getSelectedItem().toString().equals("차종"))
				{
					if(textField.getText().length() != 0)
					{
						txt = textField.getText();
						index=3;
					}
					else
						JOptionPane.showMessageDialog(contentPane, "항목을 입력해 주세요");
				}
				else if(comboBox.getSelectedItem().toString().equals("연식"))
				{
					if(textField.getText().length() != 0)
					{
						txt = textField.getText();
						index=4;
					}
					else
						JOptionPane.showMessageDialog(contentPane, "항목을 입력해 주세요");
				}
				else if(comboBox.getSelectedItem().toString().equals("연료 방식"))
				{
					if(textField.getText().length() != 0)
					{
						txt = textField.getText();
						index=5;
					}
					else
						JOptionPane.showMessageDialog(contentPane, "항목을 입력해 주세요");
				}
				else if(comboBox.getSelectedItem().toString().equals("배기량"))
				{
					if(textField.getText().length() != 0)
					{
						txt = textField.getText();
						index=6;
					}
					else
						JOptionPane.showMessageDialog(contentPane, "항목을 입력해 주세요");
				}
				else if(comboBox.getSelectedItem().toString().equals("키로수"))
				{
					if(textField.getText().length() != 0)
					{
						txt = textField.getText();
						index=7;
					}
					else
						JOptionPane.showMessageDialog(contentPane, "항목을 입력해 주세요");
				}
				else
				{
					if(textField.getText().length() != 0)
					{
						txt = textField.getText();
						index=8;
					}
					else
						JOptionPane.showMessageDialog(contentPane, "항목을 입력해 주세요");
				}
				String line = null;
				if(index != 0){
					File di = new File("C:/Users/SOS_LAB/workspace/SE/article/");
					File[] fileList = di.listFiles();
					int[] checklist = new int[fileList.length];
					for(int i = 0; i<fileList.length; i++)
						checklist[i] = 0;
					for(int i = 0; i<fileList.length; i++)
					{
						String fl = fileList[i].toString();
						File d = new File(fl+"/info.txt");
						BufferedReader in;
						try {
							in = new BufferedReader(new FileReader(d));
							for(int j = 0; j<index; j++)
							{
								line = in.readLine();
								if(line.equals(txt))
									checklist[i]++;
							}
							in.close();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
					File di1 = new File("C:/Users/SOS_LAB/workspace/SE/CarSearchResult.txt");
					try {
						BufferedWriter inn = new BufferedWriter(new FileWriter(di1));
						for(int i = 0; i<checklist.length; i++)
						{
							if(checklist[i]==0)
								inn.write("0");
							else
								inn.write("1");
							if(i != checklist.length-1)
								inn.newLine();
							else
								inn.flush();
						}
						inn.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					CarSearchResult csr;
						try {
							csr = new CarSearchResult();
							csr.setVisible(true);
							setVisible(false);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					
					
				}
				
				
			}
		});
		btnNewButton.setBounds(424, 142, 83, 75);
		contentPane.add(btnNewButton);
		
		JLabel label_2 = new JLabel("\uCC28\uB7C9 \uAC80\uC0C9");
		label_2.setFont(new Font("굴림", Font.BOLD, 18));
		label_2.setBounds(230, 63, 255, 47);
		contentPane.add(label_2);
	}
}
