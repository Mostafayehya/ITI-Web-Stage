package spring.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.security.models.User;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/app/welcome5")
public class HelloWorldController5
// extends AbstractController
// implements Controller
{
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController5.class);

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(Model model, Map<String, String> map) throws IOException {
        model.addAttribute("msg", "ModelHello mvc world");
        logger.debug("A DEBUG Message");
        logger.debug("debug-map = " + map);
        logger.info("debug-map = " + map);
//        map.put("msg", "MapHello mvc world");
//        writer.write("Spongebooooooob\n");
        return "HelloWorld";
//        return "debug-map = " + map;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String sayHelloToName(@PathVariable String name, Model model, Map<String, String> map) {
        map.put("msg", "MapHello " + name);
        model.addAttribute("msg", "ModelHello " + name);
        return "HelloWorld";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String sayHelloToBody(@RequestBody String body, Map<String, String> map) {
        map.put("msg", "MapHello " + body);
        return "HelloWorld";
    }

    @ResponseBody
    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
    public String sayJson(Map<String, String> map) {
        map.put("msg", "MapHello " + "body");
        return "{\"status\":\"all is good\"}";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String processSubmit(Map<String, User> map) {
        map.put("user", new User());
        return "Form";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String processSubmit(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, String> map) {
        if (result.hasErrors())
            return "Form";

        map.put("msg", "MapHello " + user.getUsername() + " Errors:" + result.getAllErrors() + " User:" + user);
        return "HelloWorld";
    }

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String processUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            return "File received " + file.getOriginalFilename();
        } else {
            return "File empty " + file.getOriginalFilename();
        }
    }

}
