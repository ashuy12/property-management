package com.ashu.prop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class PmsApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertAll();
		Assert.isTrue(true,"OK");
		//To be implemented
	}

}
