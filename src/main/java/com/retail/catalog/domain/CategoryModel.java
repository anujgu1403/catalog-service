package com.retail.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
public class CategoryModel {
    private Integer categoryId;
    private String name;

}