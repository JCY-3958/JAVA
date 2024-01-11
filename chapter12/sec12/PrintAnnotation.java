package chapter12.sec12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD}) //적용 대상은 메서드
@Retention(RetentionPolicy.RUNTIME) // 유지 정책은 실행 동안
public @interface PrintAnnotation {
	String value() default "-"; //기본적인 값들 전달
	int number() default 15;
}