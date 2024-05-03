package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Pruebas de la calculadora")
class PruebasCalculadoraTest {
	Calculadora calculadora;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculadora = new Calculadora();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("Método: Add")
	class Add {
		@RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
		void testAdd() {
//		Calculadora calculadora = new Calculadora();

//		double result = calculadora.suma(1, 3);
//			calculadora = mock(Calculadora.class);
//			when(calculadora.suma(1, 3)).thenReturn(3.0);
			assertEquals(4, calculadora.suma(1, 3));
		}

		@Test
		@Tag("smoke")
		void testAddKO() {
//		Calculadora calculadora = new Calculadora();

			double result = calculadora.suma(0.1, 0.2);

			assertEquals(0.3, result);
		}

		@Test
		void testBad() {
			Calculadora calculadora = new Calculadora();
			assertNotNull(calculadora);
			assertEquals(4, calculadora.add(1, 3));
			assertEquals(0.3, calculadora.suma(0.1, 0.2), "la del 0.1, 0.2");
			assertEquals(0.1, calculadora.suma(1, -0.9), "la del 1, -0.9");
		}

	}

	@Test
//	@Disabled
	void testRestaKO() {
		Calculadora calculadora = new Calculadora();

		double result = calculadora.suma(1, -0.9);

		assertEquals(0.1, result);
		assumeFalse(true, "Queda pendiente");
	}

	@Nested
	@DisplayName("Método: Div")
	class Divide {
		@Nested
		class OK {	
			@DisplayName("Division entera")
			@ParameterizedTest(name = "{index} => ''{0}'' / ''{1} –> {2}")
			@CsvSource(value = {"1,3,0", "4,2,2", "-4,-2,2","0,2,0"})
			void testDivIntInt(int op1, int op2, int result) {
				assertEquals(result, calculadora.div(op1, op2));
			}
			@Test
			@DisplayName("Division real")
			void testDivDoubleDouble() {
				assertEquals(0.3333, calculadora.div(1.0, 3), 4);
			}
			
		}
		@Nested
		class KO {	
			@Test
			@DisplayName("Division por 0")
			void testDivIntInt() {
				assertThrows(ArithmeticException.class, () -> calculadora.div(1, 0));
			}
			@Tag("smoke")
			@Test
			@DisplayName("Division real por 0")
			void testDivDoubleDouble() {
				assertThrows(ArithmeticException.class, () -> calculadora.div(1.0, 0));
			}
			
		}

	@Test
	void asercionMultiple() {
		Item item = new Item("Queso", 1, 2);
		
		assertNotNull(item);
		assertAll("Proiedades", 
			() -> assertEquals("Queso", item.getName(), "name"),
			() -> assertEquals(1, item.getSellIn(), "SellIn"),
			() -> assertEquals(2, item.getQuality(), "Quality")
			);
	}

	}
}