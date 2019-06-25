package com.griftt.server.algorithm.categorytree;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Data
public class CategoryDto {
    private Integer id;
    private String name;
    private Integer parentId;
    private List<CategoryDto> list;

    public CategoryDto(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
   public CategoryDto() {

    }
}
