package sec09.exam04_eventhandling;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter; //왜 어뎁터 씀? 몰루
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

public class JTableExample extends JFrame{
	private JTable jTable;
	private JPanel pSouth;
	private JTextField txtName;
	private JTextField txtAge;
	private Object[][] rowData;
	
	public JTableExample() {
		this.setTitle("JTableExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTable()),
				BorderLayout.CENTER);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
		this.setSize(200, 230);
	}
	
	//JTable 생성
	public JTable getJTable() {
		if(jTable == null) {
			String[] columnNames = new String[] {"이름", "나이"};
			rowData = new Object[][] {
				{"춘삼월", 25},
				{"하여름", 23},
				{"추가을", 22},
				{"동겨울", 27}
			};
			jTable = new JTable(rowData, columnNames);
			
			//MouseEvent 처리
			jTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int rowIndex = jTable.getSelectedRow();
					//없는 행을 클릭할 수 없는데 이게 왜 필요할까 -> 일종의 디펜스 코드라고 생각
					if(rowIndex != -1) {
						//클릭된 행의 셀값 읽기
						TableModel tableModel = jTable.getModel();
						//원래 값이 Object라서 형 변환 필요
						String name = (String) tableModel.getValueAt(rowIndex, 0);
						Integer age = (Integer) tableModel.getValueAt(rowIndex, 1);
						//읽은 값을 아래쪽에 있는 JPanel에서 보여주기
						getTxtName().setText(name);
						getTxtAge().setText(String.valueOf(age.intValue())); //String으로 바꿔서 넘겨줌
					}
				}
			});
		}
		return jTable;
	}
	
	//하단에 위치할 JPanel 생성
	public JPanel getPSouth() {
		if(pSouth == null) {
			pSouth = new JPanel();
			pSouth.setLayout(new GridLayout(4, 2));
			pSouth.add(new JLabel("[선택한 행 정보]"));
			pSouth.add(new JLabel("")); //이름 옆에 공백
			pSouth.add(new JLabel("이름", JLabel.CENTER));
			pSouth.add(getTxtName());
			pSouth.add(new JLabel("나이", JLabel.CENTER));
			pSouth.add(getTxtAge());
			//4행은 공백으로 아래쪽과 붙지 않게 패딩
		}
		return pSouth;
	}
	
	public JTextField getTxtName() {
		if(txtName == null) {
			txtName = new JTextField();
		}
		return txtName;
	}
	
	public JTextField getTxtAge() {
		if(txtAge == null) {
			txtAge = new JTextField();
		}
		return txtAge;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JTableExample jFrame = new JTableExample();
				jFrame.setVisible(true);
			}
		});
	}

}
