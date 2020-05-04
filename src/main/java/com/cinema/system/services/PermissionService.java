package com.cinema.system.services;

import com.cinema.system.domain.entities.PermissionEntity;
import com.cinema.system.domain.type.Permission;
import com.cinema.system.repositories.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    @Transactional
    public PermissionEntity saveUserPermission() {
        return permissionRepository.save(PermissionEntity.builder().permission(Permission.USER).build());
    }

    @Transactional
    public PermissionEntity saveAdminPermission() {
        return permissionRepository.save(PermissionEntity.builder().permission(Permission.ADMIN).build());
    }
}
