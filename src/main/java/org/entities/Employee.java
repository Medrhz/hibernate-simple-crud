package org.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "em_first", nullable = false)
    private String firstName;
    @Column(name = "em_last", nullable = false)
    private String lastName;
    @Column(name = "em_salary", nullable = false)
    private double salary;
    @Column(name = "em_dept", nullable = false)
    private String dept;


}
