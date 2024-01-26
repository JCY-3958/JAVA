package chapter20.mysql.sec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import chapter20.mysql.sec11.Board;

public class BoardExample9 {
	//field
	private Scanner scanner = new Scanner(System.in);
	private Connection conn;
	
	//constructor
	public BoardExample9() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.111.200:3306/thisisjava",
					"java",
					"mysql"
					);
			
		} catch(Exception e) {
			e.printStackTrace();
			exit();
		}
	}
	
	//method
	public void list() {
		//메인 실행시 list()를 먼저 실행
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("-------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-------------------------------------------------------");
		
		//board 테이블에서 게시물 정보를 가져와서 출력하기
		try {
			String sql = "" +
					"select bno, btitle, bcontent, bwriter, bdate " +
					"from boards " +
					"order by bno desc";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.printf("%-6s%-12s%-16s%-40s \n",
						board.getBno(),
						board.getBwriter(),
						board.getBdate(),
						board.getBtitle());
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		
		mainMenu();
	}
	
	public void mainMenu() {
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.login | 5.sign |6.exit()");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		
		switch(menuNo) {
		case "1" -> create();
		case "2" -> read();
		case "3" -> clear();
		case "4" -> login();
		case "5" -> sign();
		case "6" -> exit();
		}
	}
	
	public void create() {
		//입력 받기
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.printf("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.printf("내용: ");
		board.setBcontent(scanner.nextLine());
		System.out.printf("작성자: ");
		board.setBwriter(scanner.nextLine());
		
		//보조 메뉴 출력
		System.out.println("----------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if(menuNo.equals("1")) {
			//boards 테이블에 게시물 정보 저장
			try {
				String sql = "" +
						"insert into boards (btitle, bcontent, bwriter, bdate)" +
						"values(?, ?, ?, now())";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}
	
	public void read() {
		//입력 받기
		System.out.println("[게시물 읽기]");
		System.out.print("bno: ");
		int bno = Integer.parseInt(scanner.nextLine());
		
		//boards 테이블에서 해당 게시물을 가져와 출력
		try {
			String sql = "" + 
					"select bno, btitle, bcontent, bwriter, bdate " +
					"from boards " +
					"where bno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno); //setInt(1, bno)에서 1은 ?에 대한 index
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println("#################");
				System.out.println("번호 " + board.getBno());
				System.out.println("제목 " + board.getBtitle());
				System.out.println("내용 " + board.getBcontent());
				System.out.println("작성자 " + board.getBwriter());
				System.out.println("날짜 " + board.getBdate());
				
				//보조 메뉴 출력
				System.out.println("------------------------");
				System.out.println("보조 메뉴 : 1.Update | 2.Delete | 3.List");
				System.out.print("메뉴 선택: ");
				String menuNo = scanner.nextLine();
				System.out.println();
				
				if(menuNo.equals("1")) {
					update(board);
				} else if(menuNo.equals("2")) {
					delete(board);
				}
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		
		list();
		
	}
	
	public void update(Board board) {
		//수정 내용 입력 받기
		System.out.println("[수정 내용 입력]");
		System.out.printf("제목: ");
		board.setBtitle(scanner.nextLine());
		System.out.printf("내용: ");
		board.setBcontent(scanner.nextLine());
		System.out.printf("작성자: ");
		board.setBwriter(scanner.nextLine());
		
		//보조 메뉴 출력
		System.out.println("----------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if(menuNo.equals("1")) {
			//boards 테이블에 게시물 정보 수정
			try {
				String sql = "" +
						"update boards set btitle=?, bcontent=?, bwriter=? " +
						"where bno=?";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setInt(4, board.getBno());
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}
	
	public void delete(Board board) {
		//게시물 정보 삭제
		try {
			String sql = "delete from boards where bno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		list();
	}
	
	
	public void clear() {
		System.out.println("[게시물 전체 삭제]");
		System.out.println("----------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if(menuNo.equals("1")) {
			//boards 테이블에 게시물 정보 전체 삭제
			try {
				String sql = "truncate table boards";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				pstmt.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}
	
	public void exit() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
		System.out.println("**게시판 종료**");
		System.exit(0);
	}
	
	public void login() {
		String userId;
		String passWord;
		String dbPassword = null;
		String dbUsername = null;
		//아이디 비밀번호 입력 받기
		System.out.println("|*******게시판 프로그램*******");
		while(true) {
			System.out.print("|	아아디: ");
			userId = scanner.nextLine();
			System.out.print("|	비밀번호: ");
			passWord = scanner.nextLine();
		
			//DB에 있는 user 정보 가져오기
			try {
				String sql = "" +
					"select userid, userpassword , username " +
					"from users " +
					"where userid = ?";
			
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId); //1은 sql에 ?에 대한 인덱스
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					dbPassword = rs.getString("userpassword");
					dbUsername = rs.getString("username");
				
					if(passWord.equals(dbPassword)) {
						System.out.println("-----로그인 성공-----");
						System.out.println(dbUsername + "님 환영합니다.");
						list();					
						break;
					} else {
						System.out.println("-----로그인 실패-----");					
					}
				} else {
					System.out.println("해당 사용자가 없습니다.");
				}
				
				rs.close();
				pstmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void sign() {
		/*
		//회원가입하는 사용자의 아이디, 패스워드 받기
		String userId;
		String passWord;
		String dbUserid = null;
		System.out.println("***회원가입을 환영합니다.***");
		
		System.out.print("|	비밀번호: ");
		passWord = scanner.nextLine();
		
		//db에 동일한 사용자가 있는지, 있으면 다시 아이디 입력
		while(true) {
			System.out.print("|	아아디: ");
			userId = scanner.nextLine();
			
			try {
				String sql ="" + 
						"select userid " +
						"from users " +
						"where userid=?";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					dbUserid = rs.getString("userid");
					
					if(userId.equals(dbUserid)) {
						System.out.println("아이디가 중복되었습니다.");
					} else {
						sql = "" +
								"insert into users values(?, ?, ?, ?, ?) ";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, userId);
						System.out.print("|	이름: ");
						pstmt.setString(2, scanner.nextLine());
						System.out.print("|	비밀번호: ");
						pstmt.setString(3, scanner.nextLine());
						System.out.print("|	나이: ");
						pstmt.setInt(4, Integer.parseInt(scanner.nextLine()));
						System.out.print("|	이메일: ");
						pstmt.setString(5, scanner.nextLine());
						rs = pstmt.executeQuery();
						System.out.print("회원가입이 되었습니다.");
						login();
						break;
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		*/
		//login에 1. 로그인, 2.회원가입 만들어야함
	}
	
	public static void main(String[] args) {
		BoardExample9 boardExample = new BoardExample9();
		boardExample.login();
	}
}