package com.example.bakery.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
public class Users {

    @Id
    private Integer user_connection_id;

    @Column
    private String name;

    @Column
    private Integer user_type_id;

    @Column
    private String login;

    @Column
    private String email;

}
