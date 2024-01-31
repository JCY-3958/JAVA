package sec10.exam03_eventhandling;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public class JTreeExample extends JFrame{
	private JTree jTree;
	
	public JTreeExample() {
		this.setTitle("JTreeExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTree()), BorderLayout.CENTER);
		this.setSize(200, 150);
	}
	
	//JTree 생성
	public JTree getJTree() {
		if(jTree == null) {
			//트리 객체 생성 전에 트리 구조에 대한 데이터 (DefaultMutableTreeNode)
			 DefaultMutableTreeNode root = new  DefaultMutableTreeNode("블랙리스트");
			 DefaultMutableTreeNode node1 = new  DefaultMutableTreeNode("친구");
			 node1.add(new  DefaultMutableTreeNode("진호"));
			 node1.add(new  DefaultMutableTreeNode("종현"));
			 root.add(node1);
			 
			 DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("코딩동료");
			 node2.add(new DefaultMutableTreeNode("오유리"));
			 node2.add(new DefaultMutableTreeNode("황은지"));
			 root.add(node2);
			 
			 //트리 객체 생성
			 jTree = new JTree(root);
			 //노드 표현 방법 변경
			 jTree.setCellRenderer(new MyTreeCellRenderer());
			 
//-----------------------추가 부분------------------------------------------------------
			 
			 //이벤트 리스너 추가
			 jTree.addTreeSelectionListener(treeSelectionListener);
			 jTree.addMouseListener(mouseListener);
			 
		}
		return jTree;
	}
	
	//TreeSelectionListener 필드 선언
	private TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
		@Override
		public void valueChanged(TreeSelectionEvent e) {
			TreePath treePath = e.getPath();
			DefaultMutableTreeNode treeNode = 
					(DefaultMutableTreeNode) treePath.getLastPathComponent();
			String nodeText = (String) treeNode.getUserObject();
			JOptionPane.showMessageDialog(JTreeExample.this, "노드 변경: " + nodeText);
		}
	};
	
	//MouseListener 필드 선언
	private MouseListener mouseListener = new MouseAdapter() {
		//여기서 바로 import 가능
		public void mouseClicked(java.awt.event.MouseEvent e) {
			//더블 클릭이 되었을 경우에만 실행
			if(e.getClickCount() == 2) {
				TreePath treePath = jTree.getPathForLocation(e.getX(), e.getY());
				DefaultMutableTreeNode treeNode = 
						(DefaultMutableTreeNode) treePath.getLastPathComponent();
				String nodeText = (String) treeNode.getUserObject();
				JOptionPane.showMessageDialog(JTreeExample.this, "더블 클릭: " + nodeText);
			}
		}
	};
	
//----------------------------------------------------------------------------------
	
	//TreeCellRender 정의
	public class MyTreeCellRenderer implements TreeCellRenderer {
		public Component getTreeCellRendererComponent(
				JTree tree, Object value, boolean sel, boolean expanded,
				boolean leaf, int row, boolean hasFocus) {
			if(!leaf) { //리프가 아니라면 (하위 경로가 있는 경우 : root나 부모노드 일 때)
				JLabel jLabel = new JLabel();
				//노드 간 상하 간격									(북, 동, 남, 서)
				jLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
				jLabel.setIcon(new ImageIcon(getClass().getResource("parentnode.gif")));
				jLabel.setText(value.toString());
				return jLabel;
			} else {
				JPanel jPanel = new JPanel();
				jPanel.setBackground(Color.WHITE);
				jPanel.setLayout(new BorderLayout());
				jPanel.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
				
				JLabel lblWest = new JLabel(new ImageIcon(getClass().
						getResource("logon.gif")));
				JLabel lblCenter = new JLabel(" " + value.toString() + " ");
				JLabel lblEast = new JLabel(new ImageIcon(getClass().
						getResource("time.gif")));
				jPanel.add(lblWest, BorderLayout.WEST);
				jPanel.add(lblCenter, BorderLayout.CENTER);
				jPanel.add(lblEast, BorderLayout.EAST);
				
				if(sel) {
					//노드 선택 시 오렌지 배경색 설정
					jPanel.setBackground(Color.ORANGE);
				}
				return jPanel;
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JTreeExample jFrame = new JTreeExample();
				jFrame.setVisible(true);
			}
		});
	}

}