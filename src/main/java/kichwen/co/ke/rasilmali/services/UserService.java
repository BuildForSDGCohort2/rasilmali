package kichwen.co.ke.rasilmali.services;

import kichwen.co.ke.rasilmali.models.Role;
import kichwen.co.ke.rasilmali.models.User;
import kichwen.co.ke.rasilmali.repositories.RoleRepository;
import kichwen.co.ke.rasilmali.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service("userService")

public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    Date nowDate = new Date();

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email){return userRepository.findByEmail(email);}

    public List<User> getAllUsers(){return  userRepository.findAll();}

    public User saveUser(User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User logggeduser = findUserByEmail(auth.getName());
        user.setPassword((user.getPassword()));
        user.setActive(1);
        user.setCreated_by(1);
        user.setModified_by(1);
        user.setModified_on(nowDate);
        user.setCreated_on(nowDate);

        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public Role findByRole(String role){return roleRepository.findByRole(role);}


    public  Role saveRole(Role role){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = findUserByEmail(auth.getName());
        role.setCreated_by(user.getId());
        role.setModified_by(user.getId());
        role.setModified_on(nowDate);
        role.setCreated_on(nowDate);
        return roleRepository.save(role);
    }


}
