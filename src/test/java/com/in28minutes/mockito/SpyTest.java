package com.in28minutes.mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void test() {
        List<String> arrayListSpy = spy(ArrayList.class);
        assertEquals(0, arrayListSpy.size());
        arrayListSpy.add("Dummy");

        verify(arrayListSpy).add("Dummy");
        verify(arrayListSpy, never()).clear();
        assertEquals(1, arrayListSpy.size());

        when(arrayListSpy.size()).thenReturn(5);
        assertEquals(5, arrayListSpy.size());
        arrayListSpy.add("Dummy");
        assertEquals(5, arrayListSpy.size());
    }
}
