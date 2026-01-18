package com.retail.catalog.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
public class Category {
    private Integer categoryId;
    private String name;
}