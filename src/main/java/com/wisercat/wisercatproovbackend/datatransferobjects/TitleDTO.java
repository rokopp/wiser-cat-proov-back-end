package com.wisercat.wisercatproovbackend.datatransferobjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TitleDTO {

    private Long id;
    private String type;
    private String compareCondition;
    private String text;
    private Long filterId;
}
