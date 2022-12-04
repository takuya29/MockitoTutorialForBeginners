package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

}
