package com.carmel.executor.api;

import com.carmel.executor.api.greeting.GreetingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ControllerTests {

	@Autowired
	private GreetingController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
