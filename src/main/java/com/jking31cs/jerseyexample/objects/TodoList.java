package com.jking31cs.jerseyexample.objects;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * This object holds the data for a TodoList.  A TodoList contains a list of items and an optional id.  The id is
 * optional so that we can allow the client to only pass us a list of items to serialize this object correctly.
 */
@Entity
public class TodoList {

    @Id
    private Long id;

    private List<Item> items;

    @JsonCreator
    public TodoList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoList todoList = (TodoList) o;
        return Objects.equals(id, todoList.id) &&
            Objects.equals(items, todoList.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items);
    }
}
