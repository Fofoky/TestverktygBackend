
package com.mycompany.testverktygbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue
    private int courseId;
    private String name;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Test> tests = new ArrayList<>();

    public Course() {
    }

    public Course(int courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
