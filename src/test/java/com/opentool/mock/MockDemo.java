package com.opentool.mock;

import org.junit.Test;

import java.util.LinkedList;
import static org.mockito.Mockito.*;

public class MockDemo {
    @Test
    public void test(){
        LinkedList mockedList = mock(LinkedList.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("two");
        verify(mockedList).clear();
        //System.out.println(verify(mockedList,times(1)).size());
    }

    @Test
    public void testStubbing(){
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
        //System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(100));

    }
}
