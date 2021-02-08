package com.kotoki.stud.test_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.kotoki.stud.test_project.entity.Users;
import com.kotoki.stud.test_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TestProjectApplication {


		@Autowired
		private UserService userService;

		public static void main(String[]args){
			SpringApplication.run(TestProjectApplication.class, args);
		}

		@EventListener(ApplicationReadyEvent.class)
		private void testJpaMethods() {
			Users users = new Users();
			users.setEmail("someEmail@gmail.com");
			users.setName("Smith");
			users.setPhone("1234");
			userService.createUsers(users);
			Users users1 = new Users();
			users1.setName("Jon Dorian");
			users1.setEmail("gmailEmail@gmail.com");
			users1.setPhone("4321");
			userService.createUsers(users1);
			System.out.println();
			userService.findAll().forEach(it -> System.out.println(it));
			System.out.println();
			userService.findAllByName("Smith").forEach(it -> System.out.println(it));
			System.out.println();
			userService.findWhereEmailIsGmail().forEach(it -> System.out.println(it));
			System.out.println();
			userService.findWhereNameStartsFromSmith().forEach(it -> System.out.println(it));
			System.out.println();
		}
	}
