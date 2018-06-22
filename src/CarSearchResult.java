import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class CarSearchResult extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarSearchResult frame = new CarSearchResult();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public int selected;
	public int f=0;
	public File di = new File("C:/Users/SOS_LAB/workspace/SE/article/");
	public File dir = new File("C:/Users/SOS_LAB/workspace/SE/CarSearchResult.txt");
	public File[] fileList = di.listFiles();
	int count[] = new int[fileList.length];
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public CarSearchResult() throws IOException {
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
				//차량 검색
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
		
		JList list = new JList();
		DefaultListModel listModel = new DefaultListModel();
		
		BufferedReader ini = new BufferedReader(new FileReader(dir));
		String manufacture;
		String name;
		String year;
		String gastype;
		
		for(int i = 0; i<fileList.length; i++)
			count[i] = -1;
		int c = 0;
		for(int i = 0; i<fileList.length; i++)
		{
			if(ini.readLine().equals("1"))
			{
				di = new File(fileList[i]+"/info.txt");
				BufferedReader in = new BufferedReader(new FileReader(di));
				manufacture = in.readLine();
				name= in.readLine();
				in.readLine();
				year = in.readLine();
				gastype = in.readLine();
				listModel.addElement(manufacture+" "+name+" "+year+" "+gastype);
				count[i] = c;
				c++;
			}
			
		}
		list.setModel(listModel);
		list.setBounds(12, 62, 443, 406);
		contentPane.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setSize(456, 406);
		scrollPane.setBounds(10, 60, 406, 406);
		scrollPane.setVisible(true);
		contentPane.add(scrollPane);

		
		
		JButton button_3 = new JButton("\uBD88\uB7EC\uC624\uAE30");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//불러오기 버튼
				if(list.getSelectedIndex() >= 0)
				{
					for(int i = 0; i<fileList.length; i++)
					{
						if(list.getSelectedIndex() == count[i])
						{
							f=i;
						}
					}
					SaleInfo si;
					try {
						si = new SaleInfo(fileList[f]);
						si.setVisible(true);
						setVisible(false);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else
					JOptionPane.showMessageDialog(contentPane, "선택해주세요");
				
			}
		});
		button_3.setBounds(519, 153, 97, 23);
		contentPane.add(button_3);
		
		JLabel lblNewLabel = new JLabel("\uD310\uB9E4 \uBAA9\uB85D");
		lblNewLabel.setBounds(12, 43, 443, 15);
		contentPane.add(lblNewLabel);
	}
}
