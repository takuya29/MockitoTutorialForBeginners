package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockInjectMocksTest {

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;


    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learning Spring", "Learn to dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertArrayEquals(new String[]{"Learn Spring MVC", "Learning Spring"}, filteredTodos.toArray());
    }

    @Test
    public void testRetrieveTodosNotRelatedToSpring_usingBDD() {
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        then(todoServiceMock).should().deleteTodo("Learn to Dance");
        verify(todoServiceMock).deleteTodo("Learn to Dance");
    }

    @Test
    public void testRetrieveTodosNotRelatedToSpring_usingBDD_argumentCapture() {
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
    }

    @Test
    public void testRetrieveTodosNotRelatedToSpring_usingBDD_argumentCapture_multipleTimes() {
        List<String> todos = Arrays.asList("Learn to Dance", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }
}
