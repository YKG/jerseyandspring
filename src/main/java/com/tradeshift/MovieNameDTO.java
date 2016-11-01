package com.tradeshift;

import java.util.UUID;

/**
 * Created by ykg on 01/11/16.
 */
public class MovieNameDTO {
    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MovieNameDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
