package com.alhussain.demo;

import com.alhussain.demo.controller.BasicController;
import com.alhussain.demo.service.BasicService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class TestingTrainingApplicationTests {

	@MockBean
	private BasicService service ;

	@Autowired
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

	@Test
	public void testTrial3()
	{
		assertThrows(NullPointerException.class , ()-> { controller.getBasicMessage1(); });
	}

	@Test
	public void testTrial4()
	{
		when(controller.getBasicMessage()).thenThrow(new NullPointerException()) ;
		//when(service.basicServiceTest()).thenReturn(100) ; // will fail the test
		assertThrows(NullPointerException.class , ()-> { controller.getBasicMessage(); });
	}



}
