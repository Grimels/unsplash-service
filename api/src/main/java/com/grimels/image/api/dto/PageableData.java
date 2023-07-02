package com.grimels.image.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableData<T> {

    private String query;
    private Integer page;
    private Integer pageSize;
    private Integer totalElements;
    private Integer totalPages;
    private List<T> elements;

}
