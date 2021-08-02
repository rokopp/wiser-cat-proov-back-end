package com.wisercat.wisercatproovbackend.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Amount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String type;

    @Column(length = 20)
    private String compareCondition;

    @Column
    private Long number;

    @ManyToOne
    @JoinColumn(name = "filter_id")
    private Filter filter;
}
