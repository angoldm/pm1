package ru.angoldm.pm1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.angoldm.pm1.dto.UserDto;
import ru.angoldm.pm1.entity.User;
import ru.angoldm.pm1.exception.UserIdNotFoundException;
import ru.angoldm.pm1.repository.UserRepository;
import ru.angoldm.pm1.service.UserService;
import ru.angoldm.pm1.service.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map((userMapper::toDto))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        if (!userRepository.existsById(id)) throw new UserIdNotFoundException(id);
        User user = userMapper.toEntity(userDto);
        user.setId(id);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserIdNotFoundException(id));
        userRepository.delete(user);
    }
}
