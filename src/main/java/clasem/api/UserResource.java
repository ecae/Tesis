package clasem.api;

import javax.servlet.http.HttpServletRequest;

import clasem.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import clasem.security.JwtTokenUtil;
import clasem.wrappers.JwtUserWrapper;

@RestController
public class UserResource {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private UserController userController;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUserWrapper getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        return userController.deatilsUserAthenticated(token);
    }

}
