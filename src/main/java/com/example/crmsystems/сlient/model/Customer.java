package com.example.crmsystems.сlient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String address;

    private String city;

    private String country;

    /**
     * Почтовый индекс
     */
    private String postalCode;

    private String phoneNumber;

    /**
     * Название компании
     */

    private String company;

    /**
     * Идентификационный номер налогоплательщика
     */
    private String taxpayerIdentificationNumber;

    /**
     * Не всегда есть возможность получить данные ДР, поэтому в данном поле нет жесткой привязки
     */

    private String birthday;

    /**
     * Должность в компании
     */

    private String post;

    /**
     * Отдел в котором работает клинет
     */

    private String department;

}
