package study.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@ComponentScan(basePackages = "study.homework.week1")
@SpringBootApplication
public class HomeworkApplication {
	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}
}
