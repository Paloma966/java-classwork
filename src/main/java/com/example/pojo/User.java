package com.example.pojo;

public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter 和 Setter (VS Code 可以右键 Source Action -> Generate Getters/Setters 自动生成)
    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}