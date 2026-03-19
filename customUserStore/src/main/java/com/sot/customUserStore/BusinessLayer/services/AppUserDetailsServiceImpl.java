package com.sot.customUserStore.BusinessLayer.services;

import com.sot.customUserStore.BusinessLayer.adapters.AppUserAdapter;
import com.sot.customUserStore.BusinessLayer.entities.AppUser;
import com.sot.customUserStore.persitence.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService{
    private final AppUserRepository repository;

    public AppUserDetailsServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repository.findAppUserByUsername(username).orElseThrow(() ->new UsernameNotFoundException("Not found"));
        return new AppUserAdapter(user);
    }
}
