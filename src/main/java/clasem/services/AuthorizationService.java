package clasem.services;

import clasem.wrappers.TokenWrapper;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthorizationService {

    public abstract TokenWrapper getToken(UserDetails userDetails,Device device);
}
