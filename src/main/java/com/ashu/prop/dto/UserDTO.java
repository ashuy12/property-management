package com.ashu.prop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String ownerName;
    private String ownerEmail;
    private String phoneNo;
    private String password;

    @Override
    public String toString() {
        return "PropertyDTO [id = " + id +
                ", owner name = " + ownerName +
                ", owner email = " + ownerEmail +
                ", phone no = " + phoneNo +
                "]";
    }



}
