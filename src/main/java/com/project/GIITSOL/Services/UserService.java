package com.project.GIITSOL.Services;

import com.project.GIITSOL.Models.Users;
import com.project.GIITSOL.Repository.IAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IAuthRepo repo;

    public ResponseEntity<?> createUser(Users users){
        try{
            Users existinguser = repo.findByUsername(users.getUsername());
            if(existinguser!=null){
                return ResponseEntity.badRequest().body("User has already exist");
            }
            else {
              return ResponseEntity.ok( repo.save(users));
            }
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    public void deleteUser(int id){
        try{
            repo.deleteById(id);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public ResponseEntity<?> EditUser(int id,Users users){
        try{
            Optional<Users> existinguser = repo.findById(id);
            existinguser.get().setUsername(users.getUsername());
            existinguser.get().setPassword(users.getPassword());
            return ResponseEntity.ok(repo.save(existinguser.get()));
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    public ResponseEntity<?> GetAllUser(){
        try{
                return ResponseEntity.ok(repo.findAll());

        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    public ResponseEntity<?> GetByIdUser(int id){
        try{
            Optional<Users> existinguser = repo.findById(id);
                return ResponseEntity.ok(existinguser.get());

        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
