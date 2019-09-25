package com.efg.clientbackend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class User implements IUser {

    @Id private String id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Group id is mandatory")
    private String groupId;

    public User() {setId();}

    public User(final String name, final String groupId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.groupId = groupId;
    }

    private void setId() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGroupId() {
        return groupId;
    }

    @Override
    public String toString() {
        return String.join(" - ", id, name, groupId);
    }
}