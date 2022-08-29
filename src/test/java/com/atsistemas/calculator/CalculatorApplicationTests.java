package com.atsistemas.calculator;



import com.atsistemas.calculator.api.AddApiDelegate;
import com.atsistemas.calculator.api.SubtractApiDelegate;
import com.atsistemas.calculator.mother.DataMother;
import com.atsistemas.calculator.service.OperationService;
import io.corp.calculator.TracerAPI;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CalculatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TracerAPI tracerAPI;

	@Autowired
	private OperationService operationService;

	@Autowired
	private AddApiDelegate addApiDelegate;

	@Autowired
	private SubtractApiDelegate subtractApiDelegate;




	@Test
	@SneakyThrows
	void addWorksThroughAllLayers() {
		var mvcResult = mockMvc.perform(get("/add")
				.queryParam("firstTerm", "1")
				.queryParam("secondTerm", "2")
		).andReturn();
		Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
		Assertions.assertEquals("{\"result\":3}", mvcResult.getResponse().getContentAsString());
	}

	@Test
	@SneakyThrows
	void subtractWorksThroughAllLayers() {
		var mvcResult = mockMvc.perform(get("/subtract")
				.queryParam("firstTerm", "1")
				.queryParam("secondTerm", "2")
		).andReturn();
		Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
		Assertions.assertEquals("{\"result\":-1}", mvcResult.getResponse().getContentAsString());
	}


}
