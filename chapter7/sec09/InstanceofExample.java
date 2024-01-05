package chapter7.sec09;

public class InstanceofExample {

	public static void personInfo(Person person) {
		System.out.println("name : " + person.name);
		person.walk();
		
		/*//Java 11로 하던거
		if(person instanceof Student) {
			Student student = (Student) person;
			System.out.println("studentNo : " + student.studentNo);
			student.study();
		}
		*/
		
		//Java 12 버전 부터 가능
		if(person instanceof Student student) {
			System.out.println("studentNo : " + student.studentNo);
			student.study();
		}
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("횽길동");
		personInfo(p1);
		
		System.out.println();
		
		Person p2 = new Student("잉잉잉", 10);
		personInfo(p2);
	}

}
