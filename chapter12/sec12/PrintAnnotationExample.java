package chapter12.sec12;

import java.lang.reflect.Method;

public class PrintAnnotationExample {

	public static void main(String[] args) throws Exception {
		//메서드 가져오기 (가져오는건 랜덤)
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		
		//메서드 안에 있는 Annotation 가져오기
		for (Method method : declaredMethods) {
			PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

			// 설정 정보를 이용해서 선 출력
			printLine(printAnnotation);

			// 매서드 호출
			method.invoke(new Service());

			// 설정 정보를 이용해서 선 출력
			printLine(printAnnotation);
		}
	}

	public static void printLine(PrintAnnotation printAnnotation) {
		if (printAnnotation != null) {
			// number 속성값 얻기 : for문에 적용
			int number = printAnnotation.number(); // printAnnotation 안에 있는 number 가져오기
			for (int i = 0; i < number; i++) {
				// value 값 가져와서 value를 number만큼 출력
				String value = printAnnotation.value();
				System.out.print(value);
			}
			System.out.println();
		}
	}

}
