package com.example.BajajAPIRound;

import com.example.BajajAPIRound.dto.BFHLRequestDTO;
import com.example.BajajAPIRound.dto.BFHLResponseDTO;
import com.example.BajajAPIRound.service.BFHLService;
import com.example.BajajAPIRound.service.impl.BFHLServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BfhlServiceTest {

	private final BFHLService service = new BFHLServiceImpl();

	@Test
	void exampleATest() {

		BFHLRequestDTO request =
				new BFHLRequestDTO();

		request.setData(
				List.of("a","1","334","4","R","$")
		);

		BFHLResponseDTO response =
				service.process(request);

		assertTrue(response.isIs_success());
		assertEquals("339", response.getSum());
		assertEquals("Ra", response.getConcat_string());

		assertEquals(List.of("1"), response.getOdd_numbers());
		assertEquals(List.of("334", "4"), response.getEven_numbers());
		assertEquals(List.of("A", "R"), response.getAlphabets());
		assertEquals(List.of("$"), response.getSpecial_characters());
	}

	@Test
	void exampleBTest() {

		BFHLRequestDTO request =
				new BFHLRequestDTO();

		request.setData(
				List.of("2", "a", "y", "4", "&", "-", "*", "5", "92", "b")
		);

		BFHLResponseDTO response =
				service.process(request);

		assertTrue(response.isIs_success());
		assertEquals("103", response.getSum());
		assertEquals("ByA", response.getConcat_string());

		assertEquals(List.of("5"), response.getOdd_numbers());
		assertEquals(List.of("2", "4", "92"), response.getEven_numbers());
		assertEquals(List.of("A", "Y", "B"), response.getAlphabets());
		assertEquals(List.of("&", "-", "*"), response.getSpecial_characters());
	}

	@Test
	void exampleCTest() {

		BFHLRequestDTO request =
				new BFHLRequestDTO();

		request.setData(
				List.of("A","ABCD","DOE")
		);

		BFHLResponseDTO response =
				service.process(request);

		assertTrue(response.isIs_success());
		assertEquals("0", response.getSum());
		assertEquals("EoDdCbAa", response.getConcat_string());

		assertTrue(response.getOdd_numbers().isEmpty());
		assertTrue(response.getEven_numbers().isEmpty());
		assertEquals(List.of("A", "ABCD", "DOE"), response.getAlphabets());
		assertTrue(response.getSpecial_characters().isEmpty());
	}

	@Test
	void nullDataTest() {

		BFHLRequestDTO request =
				new BFHLRequestDTO();
		// data is null

		BFHLResponseDTO response =
				service.process(request);

		assertTrue(response.isIs_success());
		assertNotNull(response.getUser_id());
		assertNotNull(response.getEmail());
		assertNotNull(response.getRoll_number());
		assertEquals("0", response.getSum());
		assertEquals("", response.getConcat_string());
	}
}