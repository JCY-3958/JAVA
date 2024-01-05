package chapter7.sec07.exam03;

public class ChildExample {

	public static void main(String[] args) {
		//객체 생성 및 자동 타입 변환
		Parent parent = new Child();
		
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		System.out.println("parent.field1 : " + parent.field1);
		
		//자동형 변환으로 field2와 method3이 삭제되어 사용불가
		/*
		parent.field2 = "data2";
		parent.method3();
		*/
		
		//강제 타입 변환
		Child child = (Child) parent;
		
		//Child 타입으로 필드와 메서드 사용 가능
		child.field2 = "data2";
		child.method3();
		System.out.println("child.field2 : " + child.field2);
	}

}
