package com.chetan.em_project;

import jakarta.persistence.*;

@Entity
@Table(name = "emp_db_pr")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email; // ✅ FIXED

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() { // ✅ FIXED
        return email;
    }

    public void setEmail(String email) { // ✅ FIXED
        this.email = email;
    }
}
