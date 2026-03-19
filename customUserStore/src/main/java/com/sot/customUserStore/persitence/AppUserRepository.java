package com.sot.customUserStore.persitence;

import com.sot.customUserStore.BusinessLayer.entities.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository <AppUser, Integer> {
    Optional<AppUser> findAppUserByUsername(String username);
}
