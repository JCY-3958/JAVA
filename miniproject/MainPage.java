package miniproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setTitle("자동 발주 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 330);
		setLocationRelativeTo(null); // 화면 중앙에 표시
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 240, 240));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//재고메인화면 띄우는 버튼 구현
		JButton btnNewButton = new JButton("재고관리");
		btnNewButton.setBounds(37, 101, 136, 75);
		btnNewButton.setFont(new Font("HY중고딕", Font.BOLD, 14));
		btnNewButton.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton.setBackground(Color.GRAY); // 배경 color
		btnNewButton.setForeground(Color.WHITE); // 글자색 흰색
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				InventoryPage inventoryPage = new InventoryPage();
				inventoryPage.setVisible(true); //메인화면 띄우기
				setVisible(false); //원래 있던 창 닫기
				dispose();
			}
		});
		//---------------------------------------------------------
		
		//발주 내역 메인화면 띄우는 버튼 구현
		JButton btnNewButton_1 = new JButton("발주내역");
		btnNewButton_1.setBounds(204, 101, 136, 75);
		btnNewButton_1.setFont(new Font("HY중고딕", Font.BOLD, 14));
		btnNewButton_1.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton_1.setBackground(Color.GRAY); // 배경 color
		btnNewButton_1.setForeground(Color.WHITE); // 글자색 흰색
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				OrderListPage orderListPage= new OrderListPage();
				orderListPage.setVisible(true); //메인화면 띄우기
				setVisible(false); //원래 있던 창 닫기
				dispose();
			}
		});
		//---------------------------------------------------------

		//거래처 관리 메인화면 띄우는 버튼 구현
		JButton btnNewButton_2 = new JButton("거래처 관리");
		btnNewButton_2.setBounds(373, 101, 136, 75);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("HY중고딕", Font.BOLD, 14));
		btnNewButton_2.setBorderPainted(false); // 버튼 테두리 제거
		btnNewButton_2.setBackground(Color.GRAY); // 배경 color
		btnNewButton_2.setForeground(Color.WHITE); // 글자색 흰색
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //버튼 클릭 시
				CompanyPage companyPage= new CompanyPage();
				companyPage.setVisible(true); //메인화면 띄우기
				setVisible(false); //원래 있던 창 닫기
				dispose();
			}
		});
		//---------------------------------------------------------
	}
}
