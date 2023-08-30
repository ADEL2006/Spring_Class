package org.zerock.guestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GuestbookApplication {
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext =
			SpringApplication.run(GuestbookApplication.class, args);
	}

}
