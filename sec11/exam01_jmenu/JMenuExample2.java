package sec11.exam01_jmenu;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class JMenuExample2 extends JFrame{
	private JMenuBar jMenuBar;
	private JMenu menuProject, menuPage, menuEdit, menuOrder, menuEffect, menuDelete;
	private JMenuItem menuChangeName, menuCreate, menuDeleteProject,
		menuProjectInfoSet, menuDefaultSize, menuOption, menuClose;
	
	public JMenuExample2() {
		this.setTitle("JMenuExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(getJMenuBar());
		this.setSize(300, 200);
	}
	
	//JMenuBar 생성
	public JMenuBar getJMenuBar() {
		if(jMenuBar == null) {
			jMenuBar = new JMenuBar();
			//메뉴 추가
			jMenuBar.add(getMenuProject());
			jMenuBar.add(getMenuPage());
			jMenuBar.add(getMenuEdit());
			jMenuBar.add(getMenuOrder());
			jMenuBar.add(getMenuEffect());
		}
		return jMenuBar;
	}
	/*
	 * add 안에 바로 객체를 생성해서 넣어줘도 되지만 나중에 기능을 추가할 때는 힘들다.
	 * 그래서 add에 메서드를 넣어서 하는데 그 메서드들의 정의가 다 필요하다.
	 * 기능을 다 넣을거면 메서드를 넣고 텍스트 출력만 할거면 객체 바로 생성해서 넣어준다.*/
	
	//파일 메뉴 생성
	public JMenu getMenuProject() {
		if(menuProject == null) {
			menuProject = new JMenu("프로젝트");
			//서브 메뉴와 메뉴 아이템 추가
			menuProject.add(getMenuChangeName());
			menuProject.add(getMenuCreate());
			menuProject.add(getMenuDelete());
			menuProject.add(new JSeparator());
			menuProject.add(getMenuProjectInfoSet());
			menuProject.add(getMenuDefaultSize());
			menuProject.add(getMenuOption());
			menuProject.add(new JSeparator());
			menuProject.add(getMenuClose());
		}
		return menuProject;
	}
	
	public JMenu getMenuPage() {
		if(menuPage == null) {
			menuPage = new JMenu("페이지");
			
			/*
			//서브 메뉴와 메뉴 아이템 추가
			menuPage.add(getMenuNewPageInsert());
			menuProject.add(new JSeparator());
			menuPage.add(getMenuSaveAll());
			menuProject.add(new JSeparator());
			menuPage.add(getMenuDuplPage());
			menuPage.add(getMenuDeletePage());
			menuPage.add(getMenuRenamePage());
			menuProject.add(new JSeparator());
			menuPage.add(getMenuDownloadPage());
			menuPage.add(getMenuDownloadAllPage());
			menuProject.add(new JSeparator());
			menuPage.add(getMenuWebTest());
			*/
			
			//서브 메뉴와 메뉴 아이템 추가
			menuPage.add(new JMenuItem("새 페이지 삽입"));
			menuPage.add(new JSeparator());
			menuPage.add(new JMenuItem("모두 저장하기"));
			menuPage.add(new JSeparator());
			menuPage.add(new JMenuItem("페이지 복제"));
			menuPage.add(new JMenuItem("페이지 삭제"));
			menuPage.add(new JMenuItem("페이지 이름 바꾸기"));
			menuPage.add(new JSeparator());
			menuPage.add(new JMenuItem("페이지 내려받기.."));
			menuPage.add(new JMenuItem("전체페이지 내려받기"));
			menuPage.add(new JSeparator());
			menuPage.add(new JMenuItem("웹 테스트"));
			
		}
		return menuPage;
	}
	
	public JMenu getMenuEdit() {
		if(menuEdit == null) {
			menuEdit = new JMenu("편집");
		}
		return menuEdit;
	}
	
	public JMenu getMenuOrder() {
		if(menuOrder == null) {
			menuOrder = new JMenu("정렬");
		}
		return menuOrder;
	}
	
	public JMenu getMenuEffect() {
		if(menuEffect == null) {
			menuEffect = new JMenu("효과");
		}
		return menuEffect;
	}

//---------------------------------------------------
	
	//이름 바꾸기 서브 메뉴 생성
	public JMenuItem getMenuChangeName() {
		if(menuChangeName == null) {
			menuChangeName = new JMenuItem("이름 바꾸기");
		}
		return menuChangeName;
	}
	
	//사본 만들기 서브 메뉴 생성
	public JMenuItem getMenuCreate() {
		if(menuCreate == null) {
			menuCreate = new JMenuItem("사본 만들기");
		}
		return menuCreate;
	}
	
	//삭제하기 서브 메뉴 생성
	public JMenu getMenuDelete() {
		if(menuDelete == null) {
			menuDelete = new JMenu("삭제하기..");
			menuDelete.add(getMenuDeleteProject());
		}
		return menuDelete;
	}
	
	public JMenuItem getMenuDeleteProject() {
		if(menuDeleteProject == null) {
			menuDeleteProject = new JMenuItem("이 프로젝트를 삭제");
		}
		return menuDeleteProject;
	}
	
	//프로젝트 정보 설정
	public JMenuItem getMenuProjectInfoSet() {
		if(menuProjectInfoSet == null) {
			menuProjectInfoSet = new JMenuItem("프로젝트 정보 설정");
		}
		return menuProjectInfoSet;
	}
	
	//기본 화면사이즈
	public JMenuItem getMenuDefaultSize() {
		if(menuDefaultSize == null) {
			menuDefaultSize = new JMenuItem("기본 화면사이즈");
		}
		return menuDefaultSize;
	}
	
	//공유 옵션
	public JMenuItem getMenuOption() {
		if(menuOption == null) {
			menuOption = new JMenuItem("공유 옵션");
		}
		return menuOption;
	}
	
	//닫기
	public JMenuItem getMenuClose() {
		if(menuClose == null) {
			menuClose = new JMenuItem("닫기");
		}
		return menuClose;
	}
//---------------------------------------------------

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JMenuExample2 jFrame = new JMenuExample2();
				jFrame.setVisible(true);
			}
		});
	}

}