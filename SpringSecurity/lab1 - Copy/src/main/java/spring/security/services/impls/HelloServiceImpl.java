package spring.security.services.impls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import spring.security.controllers.SecurityController;
import spring.security.services.HelloService;

import javax.annotation.security.RolesAllowed;

@Component("helloService")
public class HelloServiceImpl implements HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String userAccess(String msg) {
        return msg;
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public String adminAccess(String msg) {
        return msg;
    }
}
