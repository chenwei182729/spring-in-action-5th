package com.cninfo.demo.vo;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "name")
    private String name;

    private String email;

    private String gender;

    private String address;
}