package com.expenses.app.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "user")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDate created;

    private LocalDate updated;

    @OneToOne(fetch = FetchType.LAZY,
            optional = false)
    @JoinColumn(name = "id_user",
            nullable=false)
    private User user;



}
