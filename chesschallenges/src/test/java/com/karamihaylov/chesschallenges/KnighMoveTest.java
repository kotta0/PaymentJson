package com.karamihaylov.chesschallenges;

import java.util.List;

import com.karamihaylov.chesschallenges.KnightMoveInLimitBoard.KnightOnMove;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class KnighMoveTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KnighMoveTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( KnighMoveTest.class );
    }

    /**
     * Test Max Element equality should return 60 as Max Element whene Input 8x8;
     */

    public void testApp()
    {
    	KnightOnMove test = new KnightOnMove();
    	int maxNumber = test.getMaxMoveNumber();
        assertEquals( maxNumber ,60 );
    }

	private void assertEqual(boolean b) {
		// TODO Auto-generated method stub
		
	}
    
}
