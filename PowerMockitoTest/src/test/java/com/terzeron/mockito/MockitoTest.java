package com.terzeron.mockito;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class MockitoTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    //@Before
    //public void init() {
    //    MockitoAnnotations.initMocks(this);
    //}

    @Test
    public void whenUsingMockito_thenCorrect() {
        // List 클래스와 비슷한 mock 생성
        List<String> mockedList = mock(List.class);

        // mock 객체 사용 - 실제로는 호출되었다는 기록만 남고 아무런 동작을 하지 않음
        mockedList.add("one");
        mockedList.add("two");
        mockedList.clear();

        // mock에 대해서 add("one")이 호출되었는지 확인
        verify(mockedList).add("one");
        verify(mockedList).add("two");
        verify(mockedList).clear();
    }

    @Test
    public void givenStubbing_whenUsingMockito_thenCorrect() {
        // concrete 클래스도 사용 가능
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing - 가짜 메소드를 만드는 것
        // get()에 대해 0을 파라미터로 받으면 "first"를 return하고 1을 파라미터로 받으면 예외를 던짐
        // stubbing이라고 하더라도 원래 클래스의 메소드가 가지고 있던 signature(파라미터나 return type의 형상)는 일치해야 함
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        assertEquals("first", mockedList.get(0));
        // (junit4의 표현력 부족으로 인해 직관적이진 않지만)
        // exception이 발생할 것을 기대하면서 메소드를 호출
        exceptionRule.expect(RuntimeException.class);
        mockedList.get(1);
    }

    @Test
    public void givenArgMatcher_whenUsingMockito_thenCorrect() {
        LinkedList mockedList = mock(LinkedList.class);
        // get()에 대해 임의의 정수값을 파라미터로 받으면 "element"를 return
        when(mockedList.get(anyInt())).thenReturn("element");
        // mockedList.get(999)를 호출하면 "element"가 반환되는지 검사
        assertEquals("element", mockedList.get(999));
        // mockedList에 대해 get(anyInt())로 호출되었는가 확인
        verify(mockedList).get(anyInt());

        // contains()가 사용자가 정의한 사용자가 정의한 matcher에 일치하는 파라미터를 받으면 true를 return
        // 이 matcher는 파라미터가 1부터 10 사이의 문자열인지를 확인해주는 hamcrest matcher임
        class NumberStringArgumentMatcher implements ArgumentMatcher<String> {
            @Override
            public boolean matches(String arg) {
                return arg.equals("one") || arg.equals("two") || arg.equals("three") || arg.equals("four") || arg.equals("five") || arg.equals("six") || arg.equals("seven") || arg.equals("eight") || arg.equals("nine") || arg.equals("ten");
            }
        }
        when(mockedList.contains(argThat(new NumberStringArgumentMatcher()))).thenReturn(true);
        assertTrue(mockedList.contains("one"));
        verify(mockedList).contains(anyString());
        assertFalse(mockedList.contains("twelve"));
        verify(mockedList).contains("twelve");
    }
}
