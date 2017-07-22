package clasem.controllers;

import clasem.converter.UserConverter;
import clasem.entities.Authority;
import clasem.entities.AuthorityName;
import clasem.security.JwtTokenUtil;
import clasem.wrappers.JwtUserWrapper;
import clasem.wrappers.TokenWrapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;

@Controller
public class AuthenticationController {

    private static final Log log = LogFactory.getLog(AuthenticationController.class);

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    public TokenWrapper login(String username, String password, Device device) {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails, device);

        // Return the token
        if(userDetails.getAuthorities().size() < 2) {
            return new TokenWrapper(token,"ROLE_USER");
        }else {
            return new TokenWrapper(token,"ROLE_ADMIN");
        }
    }

    public TokenWrapper refreshToken(String token) {

        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserWrapper user = (JwtUserWrapper) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
                if(user.getAuthorities().size() < 2) {
                    return new TokenWrapper(refreshedToken,"ROLE_USER");
                }else {
                    return new TokenWrapper(refreshedToken,"ROLE_ADMIN");
                }
        } else {
            return new TokenWrapper(null,null);
        }
    }
}
