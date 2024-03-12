package pl.michalboguski.HMS.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AutenticationService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password) {
        Role userRole = roleRepository.findByAuthority("USER")
                .orElse(roleRepository.save(new Role("USER")));
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        userRepository.save(new ApplicationUser(username, passwordEncoder.encode(password), roles));
    }
}
