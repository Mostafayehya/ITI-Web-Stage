package spring.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.security.models.User;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class AppController {
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);
    private static User user = new User();

    @Autowired
    private ApplicationContext appContext;

    @GetMapping("/admin")
    public String goAdmin(Model model, Map<String, String> map) throws IOException {
        model.addAttribute("msg", "ModelHello Admin");
        logger.debug("debug-map = " + map);
        return "Admin";
    }

    @GetMapping("/user")
    public String goUser(Model model, Map<String, String> map) throws IOException {
        model.addAttribute("msg", "ModelHello Admin");
        logger.debug("debug-map = " + map);
        return "User";
    }

}
