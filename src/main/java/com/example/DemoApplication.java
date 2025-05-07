package com.example;

import com.example.demo.domain.BaseContent;
import com.example.demo.domain.ReplaceContent;
import com.example.demo.service.IConvetContentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.stream.Collectors;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		String input = "aaabbcddd";
		String result = input.chars()
				.mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.joining()) // 先将字符转换为字符串流，然后合并为单个字符串
				.chars()
				.mapToObj(c -> String.valueOf((char) c))
				.distinct() // 去重
				.collect(Collectors.joining()); // 合并回字符串
		System.out.println(result); // 输出 abcde

	}

}
