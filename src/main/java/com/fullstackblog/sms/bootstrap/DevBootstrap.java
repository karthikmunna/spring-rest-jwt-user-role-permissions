package com.fullstackblog.sms.bootstrap;

import com.fullstackblog.sms.models.Role;
import com.fullstackblog.sms.models.User;
import com.fullstackblog.sms.repository.RoleRepository;
import com.fullstackblog.sms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initRoles();
        initUsers();
    }

    private void initRoles(){
        if (!roleRepository.findByName("Administrator").isPresent()){
            Role role = new Role();
            role.setName("Administrator");
            role.setDescription("Most privileged User");
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
}
