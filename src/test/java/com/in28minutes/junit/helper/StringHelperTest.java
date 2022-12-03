package com.in28minutes.junit.helper;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;

public class StringHelperTest extends TestCase {

    private StringHelper helper;

    public void setUp() {
        helper = new StringHelper();
    }

    @Test
    public void testTruncateAInFirst2Positions_Ainfirst2Positions() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AinFirstPosition() {
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AinAfter2Positions() {
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
    }

    @Test
    public void testTruncateAInFirst2Positions_NoA() {
        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_SingleCharacter() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
    }

    @After
    public void tearDown() {
        System.out.println("Test finished");
    }
}
