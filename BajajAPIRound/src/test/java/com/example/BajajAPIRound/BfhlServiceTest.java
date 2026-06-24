package com.example.BajajAPIRound;

import com.example.BajajAPIRound.dto.BFHLRequestDTO;
import com.example.BajajAPIRound.dto.BFHLResponseDTO;
import com.example.BajajAPIRound.service.BFHLService;
import com.example.BajajAPIRound.service.impl.BFHLServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BfhlServiceTest {

	@Test
	void exampleATest() {

		BFHLRequestDTO request =
				new BFHLRequestDTO();

		request.setData(
				List.of("a","1","334","4","R","$")
		);

		BFHLService service =
				new BFHLServiceImpl();

		BFHLResponseDTO response =
				service.process(request);

		assertEquals("339",
				response.getSum());

		assertEquals("Ra",
				response.getConcat_string());

		assertEquals(1,
				response.getOdd_numbers().size());

		assertEquals(2,
				response.getEven_numbers().size());
	}

	@Test
	void exampleCTest() {

		BFHLRequestDTO request =
				new BFHLRequestDTO();

		request.setData(
				List.of("A","ABCD","DOE")
		);

		BFHLService service =
				new BFHLServiceImpl();

		BFHLResponseDTO response =
				service.process(request);

		assertEquals("0",
				response.getSum());

		assertEquals(
				"EoDdCbAa",
				response.getConcat_string()
		);
	}
}