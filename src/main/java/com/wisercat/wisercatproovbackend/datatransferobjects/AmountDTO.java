package com.wisercat.wisercatproovbackend.datatransferobjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmountDTO {

    private Long id;
    private String compareCondition;
    private Long filterId;
}
