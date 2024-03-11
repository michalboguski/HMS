package pl.michalboguski.HMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.michalboguski.HMS.Security.ApplicationUser;
import pl.michalboguski.HMS.Security.Role;
import pl.michalboguski.HMS.Security.RoleRepository;
import pl.michalboguski.HMS.Security.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class Launcher implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Optional<Role> adm = roleRepository.findByAuthority("ADMIN");

        if (adm.isEmpty()) {

            Role adminRole = roleRepository.save(new Role("ADMIN"));
            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);
            ApplicationUser admin = new ApplicationUser("admin", passwordEncoder.encode("123qwe"), roles);
            userRepository.save(admin);

        }
    }
}
