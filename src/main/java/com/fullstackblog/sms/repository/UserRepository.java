package com.fullstackblog.sms.repository;

import com.fullstackblog.sms.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findAllByEmail(String email);

    Optional<User> findAllByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}
