package com.cinema.system.services;

import com.cinema.system.domain.entities.UserEntity;
import com.cinema.system.domain.type.Permission;
import com.cinema.system.dto.RegistrationDTO;
import com.cinema.system.repositories.PermissionRepository;
import com.cinema.system.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;

    public UserEntity save(final UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> findByLogin(final String login) {
        return userRepository.findByLogin(login);
    }

    public boolean loginExists(final String login) {
        return userRepository.existsAllByLogin(login);
    }

    public UserEntity registerAsUser(final RegistrationDTO user) {

        return save(UserEntity.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .permissions(Collections.singletonList(permissionRepository.findByPermission(Permission.USER)))
                .build());
    }

    public UserEntity registerAsAdmin(final RegistrationDTO user) {

        return save(UserEntity.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .permissions(Collections.singletonList(permissionRepository.findByPermission(Permission.ADMIN)))
                .build());
    }
}
