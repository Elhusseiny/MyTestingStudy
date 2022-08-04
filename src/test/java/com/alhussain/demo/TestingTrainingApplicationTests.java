package com.alhussain.demo;

import com.alhussain.demo.controller.BasicController;
import com.alhussain.demo.service.BasicService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class TestingTrainingApplicationTests {

	@Mock
	private BasicService service ;

	@InjectMocks
	private BasicController controller ;

	@Test
	public void testTrial() {
		log.info("testing ....");
	}

	@Test
	public void testTrial2() {
		when(service.basicServiceTest()).thenReturn(100) ; // 200 is the actual return
		assertEquals(100 , controller.getBasicMessage());
	}



}
