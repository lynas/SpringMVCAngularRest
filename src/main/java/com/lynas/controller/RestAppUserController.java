package com.lynas.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    ObjectMapper mapper = new ObjectMapper();


    @RequestMapping(value = "/appUser", method = RequestMethod.GET)
    @ResponseBody
    public String get() throws JsonProcessingException {
        return mapper.writeValueAsString(appUserService.getAllAppUsers());
    }


    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getByID(@PathVariable int id) throws JsonProcessingException {
        return mapper.writeValueAsString(appUserService.readAppUserById(id));
    }

    @RequestMapping(value = "/appUser", method = RequestMethod.POST)
    @ResponseBody
    public String postAppUser(@RequestBody AppUser appUser) throws JsonProcessingException {
        int newUserId = appUserService.insertAppUser(appUser);
        return mapper.writeValueAsString(appUserService.readAppUserById(newUserId));
    }


    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateAppUser(@PathVariable int id, @RequestBody AppUser appUser) throws JsonProcessingException {
        AppUser updateAppUser = appUserService.readAppUserById(id);
        updateAppUser.setUserName(appUser.getUserName());
        updateAppUser.setPassword(appUser.getPassword());
        appUserService.updateAppUser(updateAppUser);
        System.out.println("test");
        return mapper.writeValueAsString(updateAppUser);
    }

    @RequestMapping(value = "/appUser/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAppUser(@PathVariable int id) {
        appUserService.deleteAppUser(id);
        return "{\"delete\":true}";
    }


}


















