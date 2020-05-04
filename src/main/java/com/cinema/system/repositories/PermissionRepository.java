package com.cinema.system.repositories;

import com.cinema.system.domain.entities.PermissionEntity;
import com.cinema.system.domain.type.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {
    PermissionEntity findByPermission(Permission permission);
}
