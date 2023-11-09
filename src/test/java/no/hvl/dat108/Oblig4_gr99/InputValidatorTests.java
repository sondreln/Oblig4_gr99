package no.hvl.dat108.Oblig4_gr99;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InputValidatorTests {

	// VALIDERKJOENN //
	@Test
	void erMann(){
		assertTrue(InputValidator.erMann("mann"));
	}
	void erKvinne(){
		assertTrue(InputValidator.erKvinne("kvinne"));
	}


	// VALIDERMOTREGEX - MOBILNUMMER //
	@Test
	void forLangtMobilnummer(){
		assertFalse(InputValidator.validerMobilnummer("123456789"));
	}

	@Test 
	void riktigLengdeMobilnummerGirTrue(){
		assertTrue(InputValidator.validerMobilnummer("12345678"));
	}
	@Test
	void forKortMobilnummer(){
		assertFalse(InputValidator.validerMobilnummer("1234567"));
	}
	
	//FORNAVN
	@Test
	void forLangtFornavn(){
		assertFalse(InputValidator.validerFornavn("Karlerikjorgenfredrikpettersen"));
	}

	@Test
	void riktigLengdeFornavnGirTrue(){
		assertTrue(InputValidator.validerFornavn("Karl"));
	}
	//ETTERNAVN
	@Test
	void forLangtEtternavn(){
		assertFalse(InputValidator.validerEtternavn("Karlerikjorgenfredrikpettersen"));
	}

	@Test
	void riktigLengdeEtternavnGirTrue(){
		assertTrue(InputValidator.validerEtternavn("Karl"));
	}
	// VALIDERLENGDE - FORNAVN OG ETTERNAVN //
	
	// FORNAVN //
	
	// ETTERNAVN //
	
}
