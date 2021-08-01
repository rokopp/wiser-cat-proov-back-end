package com.wisercat.wisercatproovbackend.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String compareCondition;

    @ManyToOne
    @JoinColumn(name = "filter_id")
    private Filter filter;
}
