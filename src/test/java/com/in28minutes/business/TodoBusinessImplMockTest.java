package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {
        TodoService mockTodoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learning Spring", "Learn to dance");
        when(mockTodoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoServiceMock);
        List<String> filteredTodos =  todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertArrayEquals(new String[] {"Learn Spring MVC", "Learning Spring"}, filteredTodos.toArray());
    }

    @Test
    public void testRetrieveTodosNotRelatedToSpring_usingBDD() {
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        then(todoServiceMock).should().deleteTodo("Learn to Dance");
        verify(todoServiceMock).deleteTodo("Learn to Dance");
    }

    @Test
    public void testRetrieveTodosNotRelatedToSpring_usingBDD_argumentCapture() {
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
    }

    @Test
    public void testRetrieveTodosNotRelatedToSpring_usingBDD_argumentCapture_multipleTimes() {
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn to Dance", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }
}
