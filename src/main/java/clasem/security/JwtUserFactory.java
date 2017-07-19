package clasem.security;

import java.util.List;
import java.util.stream.Collectors;

import clasem.wrappers.JwtUserWrapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import clasem.entities.Authority;
import clasem.entities.User;;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUserWrapper create(User user) {
        return new JwtUserWrapper(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.getEnabled(),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
