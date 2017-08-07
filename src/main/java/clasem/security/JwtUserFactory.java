package clasem.security;

import java.util.List;
import java.util.stream.Collectors;

import clasem.wrappers.user.JwtUserWrapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import clasem.entities.user.Authority;
import clasem.entities.user.User;;

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
                user.getDni(),
                user.getCellphone(),
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
