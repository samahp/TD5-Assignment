package com.jking31cs.jerseyexample.objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * This represents an item in a TodoList.  An item contains a message and a boolean that declares if it has been done
 * or not.
 */
public class Item {
    private boolean done;
    private String message;

    @JsonCreator
    public Item(
            @JsonProperty("done") boolean done,
            @JsonProperty("message") String message) {
        this.done = done;
        this.message = message;

    }

    public boolean isDone() {
        return done;
    }

    public String getMessage() {
        return message;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equal(done, item.done) &&
            Objects.equal(message, item.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(done, message);
    }
}
