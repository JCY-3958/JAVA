package chapter11.sec04;
//AutoCloseable은 인터페이스이기 때문에 MyResource에서 구현을 한다.
public class MyResource implements AutoCloseable{
	private String name;
	
	public MyResource(String name) {
		this.name = name;
		System.out.println("[MyResource(" + name + ") 열기]");
	}
	
	public String read1() {
		System.out.println("[MyResource(" + name + ") 읽기]");
		return "100";
	}
	
	public String read2() {
		System.out.println("[MyResource(" + name + ") 읽기]");
		return "abc";
	}

	@Override
	public void close() throws Exception { //예외 발생 시 자동 리소스 닫기
		System.out.println("[MyResource(" + name + ") 닫기]");
	}
}
