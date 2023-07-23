package com.ashu.prop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String ownerName;
    @NotNull(message =" Owner Email is mandatory!")
    @NotEmpty(message = "Please provide email id!")
    @Size(min=7,max = 50, message = "Email should be between 7 to 50 characters!")
    @Email(message = "Invalid email")
    private String ownerEmail;
    private String phoneNo;
    @NotNull(message = "Please provide password!")
    @NotEmpty(message = "Please provide password!")
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
