package chapter17.sec04.exam04;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) throws Exception{
		//StreanExample 클레스가 있는 위치를 기준으로 data.txt를 찾겠다.
		Path path = Paths.get(StreamExample.class.getResource("data.txt").toURI());
		//data.txt 파일을 한줄씩 stream으로 저장        기본 캐릭터셋 : UTF-8
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(line -> System.out.println(line));
		//파일을 열었으면 닫아줘야함
		stream.close();	
	}

}
