package com.cninfo.demo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {
    private Long id;
    private Date createAt;

    @NotNull
    @Size(min=5,message="Name mast be at least 5 charset")
    private String name;
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;


}
