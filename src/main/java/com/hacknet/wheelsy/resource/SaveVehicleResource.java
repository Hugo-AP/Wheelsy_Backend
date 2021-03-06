package com.hacknet.wheelsy.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveVehicleResource {


    @NotNull
    @NotBlank
    @Size(max = 30)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String description;

    public String getName() {
        return name;
    }

    public SaveVehicleResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveVehicleResource setDescription(String description) {
        this.description = description;
        return this;
    }

}