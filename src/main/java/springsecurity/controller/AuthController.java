package springsecurity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springsecurity.Vo.User;
import springsecurity.dto.UserDto;
import springsecurity.service.UserService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/")
    public String HomeView() {
        return "/home";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/user/registration")
    public String registrationView(Model model) {
        log.info("registrationView!!!");
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "/registration";
    }

    @PostMapping("/user/registration")
    public String registrationSubmit(@ModelAttribute("userDto") @Validated UserDto userDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("검증 과정중 에러를 발견하였습니다!!");
            return "redirect:/user/registration";
        }

        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null) {
            bindingResult.rejectValue("email", null, "Email already exists!!");
            log.info("Existed user: {}",existingUser);
            return "redirect:/user/registration";
        }

        log.info("registration success!!");
        userService.saveUser(userDto);

        return "redirect:/login";
    }

    @GetMapping("/users")
    public String registeredUsersView(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users",users);
        return "/users";
    }
}
