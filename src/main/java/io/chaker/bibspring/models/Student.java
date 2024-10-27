package io.chaker.bibspring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean activeSubscription;
    private  String email;

    public Student(String name, Boolean activeSubscription, String email, Long id) {
        this.name = name;
        this.activeSubscription = activeSubscription;
        this.email = email;
        this.id = id;
    }

    public Student() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActiveSubscription() {
        return activeSubscription;
    }

    public void setActiveSubscription(Boolean activeSubscription) {
        this.activeSubscription = activeSubscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return name.equals(student.name) && activeSubscription.equals(student.activeSubscription) && email.equals(student.email) && id.equals(student.id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activeSubscription=" + activeSubscription +
                ", email='" + email + '\'' +
                '}';
    }
    
}
