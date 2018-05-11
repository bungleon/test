package com.test.repository;

import com.test.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User save(User user);

    User findByUserNameAndPassword(String userName, String password);

    User findById(UUID Id);

    List<User> findByStatusTrue(Pageable pageable);

    List<User> findByStatusTrueAndNoBetweenAndId(Integer start, Integer end, UUID id, Pageable pageable);
}
