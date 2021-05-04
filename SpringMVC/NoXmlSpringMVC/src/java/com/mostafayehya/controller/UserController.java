/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.controller;

import com.mostafayehya.domain.User;
import com.mostafayehya.service.UserService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author moust
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/displayall", method = RequestMethod.GET)
    public String displayAllUsers(Model data) {
        List<User> users = userService.getAllUsers();

        data.addAttribute("users", users);

        return "displayAll";
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public String displayUser(@RequestParam("userid") Integer id, Model data) {
        User user = userService.getUser(id);

        data.addAttribute("user", user);

        return "displayuser";
    }

    @RequestMapping(value = "{userid}", method = RequestMethod.GET)
    public String displayUserUsingPathVariables(@PathVariable("userid") Integer id, Model data) {
        User user = userService.getUser(id);

        data.addAttribute("user", user);

        return "displayuser";
    }

    @RequestMapping(value = "/cookies", method = RequestMethod.GET)
    public String displayCookies(@CookieValue("JSESSIONID") String cookie, Model data) {

        data.addAttribute("cookie", cookie);

        return "cookiesinfo";
    }

    //=================Form processing=======================
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String cteateNewUser(Model data) {
        data.addAttribute(new User());

        return "formView";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "formView";
        } else {
            userService.addUser(user);
            return "successView";
        }

    }

    @RequestMapping(value = "/uploadfile", method = RequestMethod.GET)
    public String gotoUpload(Model data) {
        return "upload";
    }

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFileHandler(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {

            System.out.println("Fetching file.......");

            try {
                // Now do something with file...
                FileCopyUtils.copy(file.getBytes(), new File("E:\\ITI 2020\\ITI-Web-Stage\\SpringMVC/" + file.getOriginalFilename()));
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            String fileName = file.getOriginalFilename();
            //model.addAttribute("fileName", fileName);
            return "You uploadded file= " + file.getOriginalFilename();
        } else {
            
            System.out.println("File uploading Failed.....");

            return "You failed to upload file= " + file.getOriginalFilename() + " because the file was empty ";

        }

    }

}
