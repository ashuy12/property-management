package com.ashu.prop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;
    private Long userId;

    @Override
    public String toString() {
        return "PropertyDTO [id = " + id +
                ", title = " + title +
                ", description = " + description +
                ", owner name = " + ownerName +
                ", owner email = " + ownerEmail +
                ", price = " + price +
                ", address = " + address +
                "]";
    }
}
