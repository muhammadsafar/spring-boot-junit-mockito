package com.msbahrddin.springbootjunittest.mocking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockitoTest {

	@Test
	void simpleMockTest() {
		List<String> families = Mockito.mock(List.class);

		Mockito.when(families.get(0)).thenReturn("Muhammad");
		
		assertThat(families.get(0)).isEqualTo("Muhammad");

//		Mockito.verify(families, times(1)).get(0);

	}

}
