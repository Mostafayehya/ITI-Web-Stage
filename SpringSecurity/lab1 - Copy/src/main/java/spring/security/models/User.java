package spring.security.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 2)
    @Setter
    @Getter
    private String username;
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 2)
    @Setter
    @Getter
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                "}: " + this.hashCode();
    }
}
