package ilia.nemankov.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1222575332301852844L;

    @NotNull
    @Size(min=6, max=16)
    private String login;

    @NotNull
    @Size(min=6, max=16)
    private String password;

}
