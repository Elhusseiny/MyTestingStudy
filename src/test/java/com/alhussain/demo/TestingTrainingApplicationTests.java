package com.alhussain.demo;

import com.alhussain.demo.controller.BasicController;
import com.alhussain.demo.service.BasicService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@Slf4j
@SpringBootTest
class TestingTrainingApplicationTests {

	@Mock
	private BasicService service ;

	@Autowired // used for testing controlelrs
	MockMvc mockMvc ;

	@InjectMocks
	private BasicController controller ;

	private String name ;

	@BeforeEach
	public void setUp()
	{
		this.name = "hussein" ;
	}

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

	@Test
	public void testTrial5() throws Exception {
		mockMvc.perform(get("/demo/basic_2/{name}" , name)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("hussein"))
				.andExpect(status().isOk());
	}

	@Test
	public void testTrial6() {
		 ReflectionTestUtils.setField(service, "age",15);
		 log.info("age is: " + service.basicServiceTest2().toString());
	}



}
