package chapter19.sec06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonExample {

	public static void main(String[] args) throws IOException {
		JSONObject root = new JSONObject();
		
		root.put("id", "winter");
		root.put("name", "한겨울");
		root.put("age", 25);
		root.put("student", true);
		
		JSONObject tel = new JSONObject();
		tel.put("home", "02-123-1234");
		tel.put("mobile", "010-8619-3958");
		root.put("tel", tel);
		
		JSONArray skill = new JSONArray();
		skill.put("java");
		skill.put("c");
		skill.put("c++");
		root.put("skill", skill);
		
		/*
		 * root
		 * 필드 ->
		 * 		id
		 * 		name
		 * 		age
		 * 		student
		 * 		tel
		 * 		필드 ->
		 * 			home
		 * 			mobile
		 * 		skill -> java, c, c++
		 */
		
		//JSON 열기
		String json = root.toString();
		
		//콘솔에 출력
		System.out.println(json);
		
		//파일로 저장
		Writer writer = new FileWriter("C:/Temp/member.json", 
				Charset.forName("UTF-8"));
		writer.write(json);
		writer.flush();
		writer.close();
	}

}
