package springsecurity.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import springsecurity.validator.PasswordMatcher;
import springsecurity.validator.ValidEmail;

@Getter
@Setter
@PasswordMatcher
public class UserDto {

    private Long id;

    @NotNull
    @NotBlank(message = "이름을 입력해주세요!")
    private String username;

    @NotNull
    @NotBlank(message = "이메일을 입력해주세요!")
    @ValidEmail
    private String email;

    @NotNull
    @NotBlank(message = "비밀번호를 입력해주세요!")
    private String password;
    private String matchingPassword;
}