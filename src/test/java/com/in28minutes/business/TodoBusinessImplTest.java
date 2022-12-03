package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class TodoBusinessImplTest{

    @Test
    public void TodoBusinessImplTest() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> filteredTodos =  todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertArrayEquals(new String[] {"Learn Spring MVC", "Learning Spring"}, filteredTodos.toArray());
    }

}
