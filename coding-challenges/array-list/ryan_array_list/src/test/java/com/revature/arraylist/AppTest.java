package com.revature.arraylist;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
//    @Test
   // public void shouldAnswerWithTrue()
   // {
   //    assertTrue( true );
   // }



	@Test
	public void testingEverythingApparently() {
		ArrayList<String> anArrayList = new ArrayList();
		assertEquals(anArrayList.isEmpty(), true);

		anArrayList.add("did it work");

		assertEquals(anArrayList.isEmpty(), false);
	}

		
}
