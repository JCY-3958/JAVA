package chapter12.sec03.exam02;

public class HashCodeExample {

	public static void main(String[] args) {
		Student s1 = new Student(1, "홍홍홍");
		Student s2 = new Student(1, "홍홍홍");
		
		if(s1.hashCode() == s2.hashCode()) { //해시 코드가 같은지
			if(s1.equals(s2)) {				//데이터가 같은지
				System.out.println("동등 객체");
			} else {
				System.out.println("노 동등 객체(데이터가 다름)");
			}
		} else {
			System.out.println("노 동등 객체(해시코드 다름)");
		}
	}

}
