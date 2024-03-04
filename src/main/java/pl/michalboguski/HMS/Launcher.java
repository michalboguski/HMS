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
            System.out.println("1");
            Role adminRole = roleRepository.save(new Role("ADMIN"));
            System.out.println("2");
            roleRepository.save(new Role("USER"));
            System.out.println("3");
            Set<Role> roles = new HashSet<>();
            System.out.println("4");
            roles.add(adminRole);
            ApplicationUser admin = new ApplicationUser("admin", passwordEncoder.encode("123qwe"), roles);
            userRepository.save(admin);
            System.out.println("END OF LAUNCHER RUN");
        }
    }
}
