package spring.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.security.models.User;
import spring.security.services.HelloService;
import spring.security.services.impls.AuthinticationServiceImpl;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/app/security")
public class SecurityController {
    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
    private static User user = new User();

    @Autowired
    private ApplicationContext appContext;

    @GetMapping()
    public String sayHello(Model model, Map<String, String> map) throws IOException {
        model.addAttribute("msg", "ModelHello security world");
        logger.debug("debug-map = " + map);
        return "HelloWorld";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String processSubmit(@RequestParam(value = "error", required = false) String error, Map<String, User> map) {
        map.put("user", user);
        return "Form";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String processSubmit(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, String> map) {
        if (result.hasErrors())
            return "Form";
        this.user = user;
        map.put("msg", "MapHello \n" + " User:" + user);
        return "HelloWorld";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String processUser(Model model) {
        model.addAttribute("msg", "ModelHello User\n" + " User:" + user + " \nPass : " + new BCryptPasswordEncoder().encode("admin"));
//        AuthinticationServiceImpl.authinticate(appContext, user);
        HelloService helloService = appContext.getBean("helloService", HelloService.class);
        helloService.userAccess("user here");
        return "HelloWorld";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String processAdmin(Model model) {
        model.addAttribute("msg", "ModelHello Admin\n" + " User:" + user);
//        AuthinticationServiceImpl.authinticate(appContext, user);
        HelloService helloService = appContext.getBean("helloService", HelloService.class);
        helloService.adminAccess("admin here");
        return "HelloWorld";
    }
}
