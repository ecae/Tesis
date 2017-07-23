package clasem.controllers;

import clasem.security.JwtTokenUtil;
import clasem.services.AuthorizationService;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationController {

    private static final Log log = LogFactory.getLog(AuthenticationController.class);

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public TokenWrapper login(String username, String password, Device device)  {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        return authorizationService.getToken(userDetails,device);

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
