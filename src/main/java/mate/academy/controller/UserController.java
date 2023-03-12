package mate.academy.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.model.User;
import mate.academy.model.dto.UserRequestDto;
import mate.academy.model.dto.UserResponseDto;
import mate.academy.service.UserService;
import mate.academy.service.mapper.UserDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserDtoMapper userDtoMapper;

    public UserController(UserService userService, UserDtoMapper userDtoMapper) {
        this.userService = userService;
        this.userDtoMapper = userDtoMapper;
    }

    @GetMapping("/")
    public List<UserResponseDto> getAllProducts() {
        return userService.findAll()
                .stream()
                .map(userDtoMapper::parse)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@RequestBody @Valid UserRequestDto user) {
        return userDtoMapper.parse(userService.save(userDtoMapper.toModel(user)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable Long id,
                                     @RequestBody UserRequestDto requestDto) {
        User user = userDtoMapper.toModel(requestDto);
        user.setId(id);
        User updatedUser = userService.update(user);
        return userDtoMapper.parse(updatedUser);
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return userDtoMapper.parse(userService.get(id));
    }

    @GetMapping("/inject")
    public String injectMockData() {
        User alice = new User();
        alice.setUsername("alice@gmail.com");
        alice.setPassword("zxasqw123456");
        User bob = new User();
        bob.setUsername("bob@gmail.com");
        bob.setPassword("Zxasqw123456");
        User clark = new User();
        clark.setUsername("clark@gmail.com");
        clark.setPassword("!!xasqw123456");
        userService.save(alice);
        userService.save(bob);
        userService.save(clark);

        return "Done!";
    }
}
