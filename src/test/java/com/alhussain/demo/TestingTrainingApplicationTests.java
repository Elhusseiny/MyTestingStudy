package com.alhussain.demo;

import com.alhussain.demo.dto.PersonDTO;
import com.alhussain.demo.service.BasicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@Slf4j
@SpringBootTest
class TestingTrainingApplicationTests {

	@MockBean
	BasicService pesronServiceTest ;

	@Autowired
	MockMvc mockMvc ;

	@SpyBean // a spy bean is similar to @mockbean but in spy we call the real object with real behaviour..
	// in mock we create a fake object to create custom mocking behaviour.
	private ObjectMapper objectMapper;

	@Test
	public void shouldGetPerson() throws Exception {

		PersonDTO dto = new PersonDTO().setId(1L).setName("hussein");
		when(pesronServiceTest.fetchPerson(any())).thenReturn(dto);

		mockMvc.perform(get(
				"/demo/person/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(1L))
				.andExpect(jsonPath("$.name").value("hussein"))
				.andExpect(status().isOk());
	}


	@Test
	public void shouldPostPerson() throws Exception {

		PersonDTO dto = new PersonDTO().setId(1L).setName("hussein");
		when(pesronServiceTest.createPerson(any())).thenReturn(dto);

		mockMvc.perform(post("/demo/person")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(dto)))
				.andExpect(jsonPath("$.id").value(1L))
				.andExpect(jsonPath("$.name").value("hussein"))
				.andExpect(status().isOk());
	}
}
