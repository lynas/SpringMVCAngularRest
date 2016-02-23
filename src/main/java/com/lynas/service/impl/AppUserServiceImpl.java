package com.lynas.service.impl;

import com.lynas.model.AppUser;
import com.lynas.service.AppUserService;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sazzad on 2/11/16
 */
@SuppressWarnings("unchecked")
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public int insertAppUser(AppUser appUser) {
        return (Integer) sessionFactory
                .getCurrentSession()
                .save(appUser);
    }

    @Transactional
    public AppUser readAppUserById(int id) {
        return (AppUser) sessionFactory
                .getCurrentSession()
                .createCriteria(AppUser.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Transactional
    public void updateAppUser(AppUser appUser) {
        sessionFactory
                .getCurrentSession()
                .update(appUser);
    }

    @Transactional
    public void deleteAppUser(int id) {
        sessionFactory
                .getCurrentSession()
                .delete(readAppUserById(id));
    }

    @Transactional
    public List<AppUser> getAllAppUsers() {
        return sessionFactory
                .getCurrentSession()
                .createCriteria(AppUser.class)
                .list();
    }
}
