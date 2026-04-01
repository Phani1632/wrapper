package com.example.wrapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.wrapper.Entity.Request;

@SpringBootTest
@AutoConfigureMockMvc
class WrapperApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;


	// ====== ADDITION TESTS ======
	@Test
	void testAdditionPositiveNumbers() throws Exception {
		Request request = new Request(5, 3);
		mockMvc.perform(post("/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("8"));
	}

	@Test
	void testAdditionNegativeNumbers() throws Exception {
		Request request = new Request(-5, -3);
		mockMvc.perform(post("/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("-8"));
	}

	@Test
	void testAdditionMixedNumbers() throws Exception {
		Request request = new Request(10, -4);
		mockMvc.perform(post("/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("6"));
	}

	@Test
	void testAdditionWithZero() throws Exception {
		Request request = new Request(5, 0);
		mockMvc.perform(post("/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("5"));
	}

	@Test
	void testAdditionBothZeros() throws Exception {
		Request request = new Request(0, 0);
		mockMvc.perform(post("/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("0"));
	}

	// ====== SUBTRACTION TESTS ======
	@Test
	void testSubtractionPositiveNumbers() throws Exception {
		Request request = new Request(10, 4);
		mockMvc.perform(post("/substract")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("6"));
	}

	@Test
	void testSubtractionNegativeResult() throws Exception {
		Request request = new Request(4, 10);
		mockMvc.perform(post("/substract")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("-6"));
	}

	@Test
	void testSubtractionNegativeNumbers() throws Exception {
		Request request = new Request(-5, -3);
		mockMvc.perform(post("/substract")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("-2"));
	}

	@Test
	void testSubtractionWithZero() throws Exception {
		Request request = new Request(5, 0);
		mockMvc.perform(post("/substract")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("5"));
	}

	@Test
	void testSubtractionBothZeros() throws Exception {
		Request request = new Request(0, 0);
		mockMvc.perform(post("/substract")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("0"));
	}

	// ====== MULTIPLICATION TESTS ======
	@Test
	void testMultiplicationPositiveNumbers() throws Exception {
		Request request = new Request(5, 4);
		mockMvc.perform(post("/multiply")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("20"));
	}

	@Test
	void testMultiplicationNegativeNumbers() throws Exception {
		Request request = new Request(-5, -4);
		mockMvc.perform(post("/multiply")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("20"));
	}

	@Test
	void testMultiplicationMixedNumbers() throws Exception {
		Request request = new Request(-5, 4);
		mockMvc.perform(post("/multiply")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("-20"));
	}

	@Test
	void testMultiplicationWithZero() throws Exception {
		Request request = new Request(5, 0);
		mockMvc.perform(post("/multiply")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("0"));
	}

	@Test
	void testMultiplicationBothZeros() throws Exception {
		Request request = new Request(0, 0);
		mockMvc.perform(post("/multiply")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("0"));
	}

	// ====== DIVISION TESTS ======
	@Test
	void testDivisionPositiveNumbers() throws Exception {
		Request request = new Request(20, 4);
		mockMvc.perform(post("/division")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("5"));
	}

	@Test
	void testDivisionNegativeNumbers() throws Exception {
		Request request = new Request(-20, -4);
		mockMvc.perform(post("/division")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("5"));
	}

	@Test
	void testDivisionMixedNumbers() throws Exception {
		Request request = new Request(-20, 4);
		mockMvc.perform(post("/division")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("-5"));
	}

	@Test
	void testDivisionWithRemainder() throws Exception {
		Request request = new Request(10, 3);
		mockMvc.perform(post("/division")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("3"));
	}

	@Test
	void testDivisionByOne() throws Exception {
		Request request = new Request(5, 1);
		mockMvc.perform(post("/division")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("5"));
	}

	@Test
	void testDivisionZeroByNumber() throws Exception {
		Request request = new Request(0, 5);
		mockMvc.perform(post("/division")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(content().string("0"));
	}

	@Test
	void testDivisionByZeroThrowsException() throws Exception {
		Request request = new Request(5, 0);
		mockMvc.perform(post("/division")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isInternalServerError());
	}

}
