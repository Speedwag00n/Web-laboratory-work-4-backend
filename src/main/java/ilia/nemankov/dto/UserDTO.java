package ilia.nemankov.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDTO {

    @NotNull
    @Size(min=6, max=16)
    private String login;

    @NotNull
    @Size(min=6, max=16)
    private String password;

}
