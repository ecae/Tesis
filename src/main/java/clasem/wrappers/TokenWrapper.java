package clasem.wrappers;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class TokenWrapper {

    String token;
    Collection<? extends GrantedAuthority> authorities;

    public TokenWrapper(String token, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.authorities = authorities;
    }

    public TokenWrapper() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "TokenWrapper{" +
                "token='" + token + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
