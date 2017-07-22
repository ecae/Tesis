package clasem.wrappers;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class TokenWrapper {

    String token;
    String rol;

    public TokenWrapper() {
    }

    public TokenWrapper(String token, String rol) {
        this.token = token;
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "TokenWrapper{" +
                "token='" + token + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
