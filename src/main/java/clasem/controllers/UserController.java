package clasem.controllers;

import clasem.security.JwtTokenUtil;
import clasem.wrappers.JwtUserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    public JwtUserWrapper deatilsUserAthenticated(String token) {

        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserWrapper user = (JwtUserWrapper) userDetailsService.loadUserByUsername(username);
        return user;
    }
}
