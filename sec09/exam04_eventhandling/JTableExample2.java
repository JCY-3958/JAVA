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

public class JTableExample2 extends JFrame{
	private JTable jTable;
	private JPanel pSouth;
	private JTextField txtName;
	//private JTextField txtAge;
	private Object[][] rowData;
	
	public JTableExample2() {
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
				{"오유리", 20},
				{"방재혁", 21},
				{"황은지", 22},
				{"전찬용", 23}
			};
			jTable = new JTable(rowData, columnNames);
			
			//MouseEvent 처리
			jTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int rowIndex = jTable.getSelectedRow();
					int columnIndex = jTable.getSelectedColumn();
					//없는 행을 클릭할 수 없는데 이게 왜 필요할까 -> 일종의 디펜스 코드라고 생각
					if(rowIndex != -1 || columnIndex != -1) {
						//클릭된 행의 셀값 읽기
						TableModel tableModel = jTable.getModel();
						//원래 값이 Object라서 형 변환 필요
						//name과 age의 rowIndex, columnIndex 값이 같아서 이중 if안에 getValueAt이 있어야함
						//String name = (String) tableModel.getValueAt(rowIndex, columnIndex);
						//Integer age = (Integer) tableModel.getValueAt(rowIndex, columnIndex);
						
						//읽은 값을 아래쪽에 있는 JPanel에서 보여주기
						if(columnIndex == 0) {
							String name = (String) tableModel.getValueAt(rowIndex, columnIndex);
							getTxtInfo().setText(name);
						} else {
							Integer age = (Integer) tableModel.getValueAt(rowIndex, columnIndex);
							getTxtInfo().setText(String.valueOf(age.intValue())); //String으로 바꿔서 넘겨줌
						}
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
			pSouth.setLayout(new GridLayout(3, 2));
			pSouth.add(new JLabel("[선택한 행 정보]"));
			pSouth.add(new JLabel("")); //이름 옆에 공백
			pSouth.add(new JLabel("정보", JLabel.CENTER));
			pSouth.add(getTxtInfo());
			pSouth.remove(new JLabel("정보", JLabel.CENTER));
			//3행은 공백으로 아래쪽과 붙지 않게 패딩
		}
		
		return pSouth;
	}
	
	public JTextField getTxtInfo() {
		if(txtName == null) {
			txtName = new JTextField();
		}
		return txtName;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JTableExample2 jFrame = new JTableExample2();
				jFrame.setVisible(true);
			}
		});
	}

}
