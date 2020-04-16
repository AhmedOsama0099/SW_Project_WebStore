package com.example.webstore.security.services;


import com.example.webstore.dao.User.UserDaoImpl;
import com.example.webstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    UserDaoImpl userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUserName(username);
        if(user==null)
        	throw new UsernameNotFoundException("User Not Found with username: " + username);

        return UserDetailsImpl.build(user,userDao);
    }

}
