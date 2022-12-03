package com.in28minutes.junit.helper;

import junit.framework.TestCase;
import org.junit.Test;

public class StringHelperTest extends TestCase {

    StringHelper helper = new StringHelper();

    @Test
    public void testTruncateAInFirst2Positions_Ainfirst2Positions() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
//        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
//        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
//        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
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

}
