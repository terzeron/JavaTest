package com.terzeron.powermockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CollaboratorWithFinalMethods.class, CollaboratorWithStaticMethods.class})
public class PowerMockitoIntegrationTest {
    @Test
    public void givenFinalMethods_whenUsingPowerMockito_thenCorrect() throws Exception {
        // 원하는 클래스용 powermockito 객체를 만들고 그 클래스의 no-arg 생성자가 호출되면 powermockito 인스턴스가 반환되도록 선언함
        CollaboratorWithFinalMethods mock = mock(CollaboratorWithFinalMethods.class);
        whenNew(CollaboratorWithFinalMethods.class).withNoArguments().thenReturn(mock);

        // 기본 생성자를 가지고 클래스를 생성하면 mock이 no-arg 생성자를 이용해서 생성되었는지 확인함
        CollaboratorWithFinalMethods collaborator = new CollaboratorWithFinalMethods();
        verifyNew(CollaboratorWithFinalMethods.class).withNoArguments();

        // collaborator는 helloMethod() 호출 시에 특정 문자열을 반환하게 함
        when(collaborator.helloMethod()).thenReturn("hello world");
        String welcome = collaborator.helloMethod();
        // helloMethod()가 collaborator에 대해 호출되었는지 확인함
        verify(collaborator).helloMethod();
        // 값이 동일한지 확인함
        assertEquals("hello world", welcome);
    }

    @Test
    public void givenStaticMethods_whenUsingPowerMockito_thenCorrect() throws Exception {
        // 다음 클래스를 static method를 가지는 mock으로 만듬
        mockStatic(CollaboratorWithStaticMethods.class);

        // mock의 method들을 가짜로 만듬
        // firstMethod(): arg로 무엇이 들어오든 "hello baeldung!"을 반환하도록 선언함
        when(CollaboratorWithStaticMethods.firstMethod(Mockito.anyString())).thenReturn("hello baeldung!");
        // secondMethod(): "Nothing special"을 반환하도록 선언함
        when(CollaboratorWithStaticMethods.secondMethod()).thenReturn("Nothing special");
        // thirdMethod(): 호출하면 예외 발생하도록 선언함
        doThrow(new RuntimeException()).when(CollaboratorWithStaticMethods.class);
        CollaboratorWithStaticMethods.thirdMethod();

        // mock에게 firstMethod를 호출함 - 어떤 arg를 사용하더라도 정해진 리턴값이 반환됨
        String firstWelcome = CollaboratorWithStaticMethods.firstMethod("Whoever");
        String secondWelcome = CollaboratorWithStaticMethods.firstMethod("Whatever");
        assertEquals("hello baeldung!", firstWelcome);
        assertEquals("hello baeldung!", secondWelcome);


    }
}
