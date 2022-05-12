package com.amith.springcloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:/product-service-test.properties")
class ProductserviceApplicationTests {

	@Test
	void contextLoads() {
	}

}
