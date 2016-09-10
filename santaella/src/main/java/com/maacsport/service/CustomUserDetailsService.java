package com.maacsport.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.maacsport.dao.PersonDao;
import com.maacsport.model.Person;
 
@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {
     
    @Autowired
    private PersonDao personDao;    
 
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
         
        Person domainUser = personDao.getUser(login);
         
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        return new User(
                domainUser.getPersonId(), 
                domainUser.getDni(), 
                enabled, 
                accountNonExpired, 
                credentialsNonExpired, 
                accountNonLocked,
                getAuthorities(domainUser.getCategory().getId())
        );
    }
     
    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getCategories(role));
        return authList;
    }
     
    public List<String> getCategories(Integer role) {
 
        List<String> roles = new ArrayList<String>();
 
        if (role.longValue() == 1) {
            roles.add("ROLE_USER");
            roles.add("ROLE_ADMIN");
        } else if (role.intValue() == 2) {
            roles.add("ROLE_USER");
        }
        return roles;
    }
     
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
 
}