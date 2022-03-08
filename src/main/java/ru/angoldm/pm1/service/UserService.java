package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto createUser (UserDto userDto);

    List<UserDto> findAll();

    UserDto updateUser (UserDto userDto, Long id);

    void delete(Long id);
}
