package md.utm.testgenerator.config;

import lombok.AllArgsConstructor;
import md.utm.testgenerator.db.AdminRepository;
import md.utm.testgenerator.entity.Admin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Objects;

@AllArgsConstructor
@Service
public class AdminDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(s);
        if (!Objects.nonNull(admin)) {
            throw new UsernameNotFoundException("User not found");
        }
        return new Principal(admin);
    }
}
