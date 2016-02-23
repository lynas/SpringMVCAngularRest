package com.lynas.service;

import com.lynas.model.AppUser;

import java.util.List;

/**
 * Created by sazzad on 2/11/16
 */
public interface AppUserService {
    int insertAppUser(AppUser appUser);

    AppUser readAppUserByUserName(String userName);

    AppUser readAppUserById(int id);

    void updateAppUser(AppUser appUser);

    void deleteAppUser(int id);

    List<AppUser> getAllAppUsers();
}
