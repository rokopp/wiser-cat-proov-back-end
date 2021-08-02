package com.wisercat.wisercatproovbackend.datatransferobjects;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DateDTO {

    private Long id;
    private String type;
    private String compareCondition;
    private Date date;
    private Long filterId;
}
