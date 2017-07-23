package clasem.services.impl;

import clasem.security.JwtTokenUtil;
import clasem.services.AuthorizationService;
import clasem.wrappers.TokenWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService{

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public TokenWrapper getToken(UserDetails userDetails, Device device) {

        final String token = jwtTokenUtil.generateToken(userDetails, device);

        if(userDetails.getAuthorities().size() < 2) {
            return new TokenWrapper(token,"ROLE_USER");
        }else {
            return new TokenWrapper(token,"ROLE_ADMIN");
        }
    }
}
