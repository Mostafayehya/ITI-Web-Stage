package spring.security.services.impls;

import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import spring.security.models.User;

import java.util.Collection;
import java.util.List;

public class AuthinticationServiceImpl {
    public static void authinticate(ApplicationContext applicationContext, User user) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        AuthenticationManager authenticationManager = applicationContext.getBean(AuthenticationManager.class);
        Authentication authenticatedToken = authenticationManager.authenticate(authenticationToken);

        SecurityContext securityContext = new SecurityContextImpl();
        securityContext.setAuthentication(authenticatedToken);
        SecurityContextHolder.setContext(securityContext);
    }
}
