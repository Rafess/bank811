package com.santander.banco811.repository;

import com.santander.banco811.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByName(String name, Pageable pageable);

    Optional<User> findById(Integer id);

}
