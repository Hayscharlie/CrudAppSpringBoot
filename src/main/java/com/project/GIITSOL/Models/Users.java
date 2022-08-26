package com.project.GIITSOL.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tbl_users")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
}
