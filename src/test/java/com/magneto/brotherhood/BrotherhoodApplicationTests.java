package com.magneto.brotherhood;

import com.magneto.brotherhood.services.MutantService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrotherhoodApplicationTests {

	@Autowired
	private MutantService mutantService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void  testIsMutantOfAMutant(){
		//Given
		String[] dnaMutant = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		//When
		Boolean isMutant = mutantService.isMutant(dnaMutant);
		//Then
		assert isMutant;
	}

	@Test
	public void  testMutantRightDNA(){
		/*
			A A A A G A
			T C C C C G
			T T A T G T
			A G A A G G
			G C C C T A
			T C C C C G"
		 */
		//Given
		String[] dnaMutant = {"AAAAGA","TCCCCG","TTATGT","AGAAGG","GCCCTA","TCCCCG"};
		//When
		Boolean isMutant = mutantService.isMutant(dnaMutant);
		//Then
		assert isMutant;
	}

	@Test
	public void  testMutantDownDNA(){
		/*
			A A A G G A
			T A C C C G
			T A A C G T
			A A T C G G
			G C C C T A
			T C C T C G"
		 */
		//Given
		String[] dnaMutant = {"AAAGGA","TACCCG","TAACGT","AATCGG","GCCCTA","TCCTCG"};
		//When
		Boolean isMutant = mutantService.isMutant(dnaMutant);
		//Then
		assert isMutant;
	}

	@Test
	public void  testMutantRightDiagonalDNA(){
		/*
			T A C G G A
			T T C C C G
			T A T C C T
			A A T T G C
			G C C C T A
			T C C T C G"
		 */
		//Given
		String[] dnaMutant = {"TACGGA","TTCCCG","TATCCT","AATTGC","GCCCTA","TCCTCG"};
		//When
		Boolean isMutant = mutantService.isMutant(dnaMutant);
		//Then
		assert isMutant;
	}

	@Test
	public void  testMutantLeftDiagonalDNA(){
		/*
			T A C C G A
			T T C C G G
			T C T G T T
			C A G A G C
			G G C C T A
			T C C T C G"
		 */
		//Given
		String[] dnaMutant = {"TACCGA","TTCCGG","TCTGTT","CAGAGC","GGCCTA","TCCTCG"};
		//When
		Boolean isMutant = mutantService.isMutant(dnaMutant);
		//Then
		assert isMutant;
	}

	@Test
	public void  testIsMutantOfAHuman(){
		/*
			A C G T A C
			T G C A T G
			A C G T A C
			T G C A T G
			A C G T A C
			T G C A T G"
		*/

		//Given
		String[] dnaMutant = {"ATGCGA", "CCGTGC", "TTATGT", "AGAAGG", "CCTCTA", "TCACTG"};
		//When
		Boolean isHuman = !mutantService.isMutant(dnaMutant);
		//Then
		assert isHuman;
	}

	@Test
	public void  testIsMutantOfAAlmostMutant(){
		/*
			A T G C G A
			C C G T G C
			T T G T G T
			A G A G G G
			C C T C C A
			T C A C T G"
		 */
		//Given
		String[] dnaMutant = {"ATGCGA", "CCGTGC", "TTGTGT", "AGAGGG", "CCTCCA", "TCACTG"};
		//When
		Boolean isHuman = !mutantService.isMutant(dnaMutant);
		//Then
		assert isHuman;
	}


}
