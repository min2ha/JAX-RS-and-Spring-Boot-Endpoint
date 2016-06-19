package net.droidPla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;


/**
 * Created by Mindaugas Vidmantas on 2016-06-19.
 * email: minvidm@gmail.com, minvidm@ktu.lt
 */

@SpringBootApplication
public class RobotRsWsApplication extends SpringBootServletInitializer {
	public static void main(String... args) {
		SpringApplication.run(RobotRsWsApplication.class, args);
	}
}

/*
@SpringBootApplication
public class RestJaxrsApplication extends SpringBootServletInitializer {
	public static void main(String... args) {
		SpringApplication.run(RestJaxrsApplication.class, args);
	}
}
*/
