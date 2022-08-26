package com.project.GIITSOL.Repository;

import com.project.GIITSOL.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
