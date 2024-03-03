package pl.michalboguski.HMS.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("INSIDE USER DETAILS SERVICE: LOAD USER BY NAME");

        if(!"Michal".equals(username)) throw new UsernameNotFoundException("NIE MA TEKIEGO URZYTKOWNIKA");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("USER"));
        return new ApplicationUser("Michal",passwordEncoder.encode("1234"),roles);
    }
}
