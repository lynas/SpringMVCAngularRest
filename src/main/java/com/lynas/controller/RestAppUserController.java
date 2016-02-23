package com.lynas.controller;

import com.google.gson.Gson;
import com.lynas.model.AppUser;
import com.lynas.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sazzad on 2/23/16
 */
@RestController
public class RestAppUserController {

    @Autowired
    AppUserService appUserService;
    Gson gson = new Gson();


    @RequestMapping(value = "/appUser", method = RequestMethod.GET)
    @ResponseBody
    public String get() {

        return gson.toJson(appUserService.getAllAppUsers());
    }


    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getByID(@PathVariable int id) {
        return gson.toJson(appUserService.readAppUserById(id));
    }


    @RequestMapping(value = "/appUser", method = RequestMethod.POST)
    @ResponseBody
    public String postAppUser(@RequestParam String userName, @RequestParam String password) {
        int newUserId = appUserService.insertAppUser(new AppUser(userName, password));
        return gson.toJson(appUserService.readAppUserById(newUserId));
    }


    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateAppUser(@PathVariable int id, @RequestParam String userName, @RequestParam String password) {
        AppUser appUser = appUserService.readAppUserById(id);
        appUser.setUserName(userName);
        appUser.setPassword(password);
        appUserService.updateAppUser(appUser);
        return gson.toJson(appUserService.readAppUserById(id));
    }

    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAppUser(@PathVariable int id) {
        appUserService.deleteAppUser(id);
        return "{\"delete\":true}";
    }


}


















