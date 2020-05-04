package com.cinema.system.config;

import com.cinema.system.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InitializingPermissionBean implements InitializingBean {

    private final PermissionService permissionService;

    @Override
    public void afterPropertiesSet() throws Exception {
        permissionService.saveUserPermission();
        permissionService.saveAdminPermission();
    }
}
