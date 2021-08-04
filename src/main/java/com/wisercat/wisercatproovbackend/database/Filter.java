package com.wisercat.wisercatproovbackend.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String filterName;

    @Column
    private Long selectedFilter;

    @OneToMany(mappedBy = "filter")
    private List<Amount> amounts;

    @OneToMany(mappedBy = "filter")
    private List<Title> titles;

    @OneToMany(mappedBy = "filter")
    private List<Date> dates;
}
