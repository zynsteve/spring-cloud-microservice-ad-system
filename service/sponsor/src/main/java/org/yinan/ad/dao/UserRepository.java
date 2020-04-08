package org.yinan.ad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yinan.ad.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
