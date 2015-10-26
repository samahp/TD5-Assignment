package com.jking31cs.jerseyexample.stores;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.jking31cs.jerseyexample.objects.TodoList;

import javax.inject.Inject;
import java.util.List;

/**
 * This is where we do all the saving to/from the datastore using Objectify.
 */
public class TodoListStore {

    private final Objectify objectify;

    @Inject
    public TodoListStore(Objectify objectify) {
        this.objectify = objectify;
    }

    public List<TodoList> getAll() {
        return objectify.load().type(TodoList.class).list();
    }

    public TodoList get(Long id) {
        return objectify.load().type(TodoList.class).id(id).now();
    }

    public TodoList save(TodoList todoList) {

        Key<TodoList> key = objectify.save().entity(todoList).now();
        return objectify.load().key(key).now();
    }
}
