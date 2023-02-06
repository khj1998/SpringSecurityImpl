package springsecurity.service;

import springsecurity.Vo.User;
import springsecurity.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
