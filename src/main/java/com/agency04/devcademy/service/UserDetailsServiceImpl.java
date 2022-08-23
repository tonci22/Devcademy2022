package com.agency04.devcademy.service;

import com.agency04.devcademy.domain.Privilege;
import com.agency04.devcademy.domain.Role;
import com.agency04.devcademy.domain.User;
import com.agency04.devcademy.dto.request.UserCreateDto;
import com.agency04.devcademy.dto.request.UserDtoLogin;
import com.agency04.devcademy.enums.RoleType;
import com.agency04.devcademy.mapper.RoleMapper;
import com.agency04.devcademy.mapper.UserMapper;
import com.agency04.devcademy.repositories.RoleRepository;
import com.agency04.devcademy.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsServiceImpl")
@Transactional
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    private RoleRepository roleRepository;
    private UserMapper userMapper;
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username:" + email);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
    }

    public UserCreateDto save(UserDtoLogin userDtoLogin) {
        UserCreateDto user = new UserCreateDto();
        user.setEmail(userDtoLogin.getUsername());
        user.setEnabled(true);
        user.setFirstName(userDtoLogin.getFirstName());
        user.setLastName(userDtoLogin.getLastName());
        user.setPassword(BCrypt.hashpw(userDtoLogin.getPassword(), BCrypt.gensalt()));
        user.setRoles(List.of(roleMapper.mapToDto(roleRepository.findByName(RoleType.ROLE_USER.toString()))));
        userRepository.save(userMapper.mapToDto(user));

        return user;
    }

    public void initAdminUser() {
        UserCreateDto user = new UserCreateDto();
        user.setEmail("admin");
        user.setEnabled(true);
        user.setFirstName("name");
        user.setLastName("last_name");
        user.setPassword(BCrypt.hashpw("admin", BCrypt.gensalt()));
        user.setRoles(List.of(roleMapper.mapToDto(roleRepository.findByName(RoleType.ROLE_ADMIN.toString()))));
        userRepository.save(userMapper.mapToDto(user));
    }

    public void initUser() {
        UserCreateDto user = new UserCreateDto();
        user.setEmail("user");
        user.setEnabled(true);
        user.setFirstName("name");
        user.setLastName("last_name");
        user.setPassword(BCrypt.hashpw("user", BCrypt.gensalt()));
        user.setRoles(List.of(roleMapper.mapToDto(roleRepository.findByName(RoleType.ROLE_USER.toString()))));
        userRepository.save(userMapper.mapToDto(user));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();

        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    public List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
