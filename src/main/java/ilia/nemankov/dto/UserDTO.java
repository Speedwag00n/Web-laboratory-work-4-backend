package ilia.nemankov.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDTO {

    @NotNull
    private String login;

    @NotNull
    private String password;

}
