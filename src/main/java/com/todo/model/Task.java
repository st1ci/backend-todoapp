package com.todo.model;

import jakarta.persistence.*;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    private String title;
    private String description;
    private String status;
    private Integer position;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
}