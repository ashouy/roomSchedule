package com.jsoft.roomschedule.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemUserRepository  extends JpaRepository<SystemUser, Long> {
    Optional<SystemUser> findByEmail();
}
