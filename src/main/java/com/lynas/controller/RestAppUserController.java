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
    public String postAppUser(@RequestBody AppUser appUser) {
        int newUserId = appUserService.insertAppUser(appUser);
        return gson.toJson(appUserService.readAppUserById(newUserId));
    }


    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateAppUser(@PathVariable int id, @RequestBody AppUser appUser) {
        AppUser updateAppUser = appUserService.readAppUserById(id);
        updateAppUser.setUserName(appUser.getUserName());
        updateAppUser.setPassword(appUser.getPassword());
        appUserService.updateAppUser(updateAppUser);
        System.out.println("test");
        return gson.toJson(updateAppUser);
    }

    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAppUser(@PathVariable int id) {
        appUserService.deleteAppUser(id);
        return "{\"delete\":true}";
    }


}


















