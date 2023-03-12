package mate.academy.service.mapper;

import mate.academy.model.User;
import mate.academy.model.dto.UserRequestDto;
import mate.academy.model.dto.UserResponseDto;
import mate.academy.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    private final UserService userService;

    public UserDtoMapper(UserService userService) {
        this.userService = userService;
    }

    public UserResponseDto parse(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setUsername(user.getUsername());
        responseDto.setPassword(user.getPassword());
        return responseDto;
    }

    public User toModel(UserRequestDto requestDto) {
        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setPassword(requestDto.getPassword());
        return user;
    }
}
