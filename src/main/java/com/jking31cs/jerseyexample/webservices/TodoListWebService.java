package com.jking31cs.jerseyexample.webservices;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jking31cs.jerseyexample.objects.TodoList;
import com.jking31cs.jerseyexample.stores.TodoListStore;

/**
 * This web service handles all the different http calls from a client to create, read, update, and delete TodoLists.
 * This is done using Jersey/JAX-RS (Java Application Rest Service API).
 */
@Path("api/todo-lists")
public class TodoListWebService {

    private final TodoListStore store;

    @Inject
    public TodoListWebService(TodoListStore store) {
        this.store = store;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TodoList> getAllLists() {
        return store.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TodoList getList(@PathParam("id") Long id) {
        return store.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TodoList saveNewList(TodoList todoList) {
        return store.save(todoList);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TodoList updateList(@PathParam("id") Long id, TodoList todoList) {
        return store.save(todoList);
    }


}
