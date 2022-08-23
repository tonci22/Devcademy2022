package com.agency04.devcademy.domain;

import com.agency04.devcademy.enums.PrivilegeType;
import com.agency04.devcademy.enums.RoleType;
import com.agency04.devcademy.repositories.PrivilegeRepository;
import com.agency04.devcademy.repositories.RoleRepository;
import com.agency04.devcademy.repositories.UserRepository;
import com.agency04.devcademy.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        Privilege readPrivilege = createPrivilegeIfNotFound(PrivilegeType.READ_PRIVILEGE.toString());
        Privilege writePrivilege = createPrivilegeIfNotFound(PrivilegeType.WRITE_PRIVILEGE.toString());

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);

        createRoleIfNotFound(RoleType.ROLE_ADMIN.toString(), adminPrivileges);
        createRoleIfNotFound(RoleType.ROLE_USER.toString(), Arrays.asList(readPrivilege));

        userDetailsService.initAdminUser();
        userDetailsService.initUser();

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);

        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);

        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}

