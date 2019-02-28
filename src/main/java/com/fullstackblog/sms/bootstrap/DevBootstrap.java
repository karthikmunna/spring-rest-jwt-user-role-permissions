package com.fullstackblog.sms.bootstrap;

import com.fullstackblog.sms.models.Permission;
import com.fullstackblog.sms.models.Role;
import com.fullstackblog.sms.models.User;
import com.fullstackblog.sms.repository.PermissionRepository;
import com.fullstackblog.sms.repository.RoleRepository;
import com.fullstackblog.sms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initPermissions();
        initRoles();
        initUsers();
    }

    private void initRoles(){
        if (!roleRepository.findByName("Administrator").isPresent()){
            List<Permission> permissions = permissionRepository.findAll();
            Role role = new Role();
            role.setName("Administrator");
            role.setDescription("Most privileged User");
            role.setPermissions(permissions);
            roleRepository.save(role);
        }
    }

    private void initUsers(){
        if (!userRepository.findByUsername("admin").isPresent()){
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRole(roleRepository.findByName("Administrator").get());
            userRepository.save(user);
        }
    }

    private void initPermissions(){
        String permissions[] = {"CREATE_STUDENT","VIEW_STUDENT"};

        for (String permissionName : permissions){
            Permission permission = new Permission();
            permission.setName(permissionName);
            permissionRepository.save(permission);
        }
    }
}
