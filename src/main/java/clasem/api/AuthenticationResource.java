package clasem.api;

import clasem.controllers.AuthenticationController;
import clasem.security.JwtAuthenticationRequest;
import clasem.wrappers.TokenWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationResource {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationController authenticationController;

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public TokenWrapper createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {
        return authenticationController.login(authenticationRequest.getUsername(),authenticationRequest.getPassword(),device);
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public TokenWrapper refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        return authenticationController.refreshToken(token);
    }

}
