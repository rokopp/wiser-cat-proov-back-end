package com.wisercat.wisercatproovbackend.datatransferobjects;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilterDTO {

    private Long id;
    private String filterName;
    private Long selectedFilter;
    private List<AmountDTO> amounts;
    private List<TitleDTO> titles;
    private List<DateDTO> dates;

}
