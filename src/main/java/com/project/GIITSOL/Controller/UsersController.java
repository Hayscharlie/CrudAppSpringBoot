package com.project.GIITSOL.Controller;

import com.project.GIITSOL.Models.Users;
import com.project.GIITSOL.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UsersController {
    @Autowired
    private UserService userService;
    @PostMapping("save")
    public ResponseEntity<?> CreateUser(@RequestBody Users users){
        try{
            return ResponseEntity.ok(userService.createUser(users));
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    @GetMapping("find")
    public ResponseEntity<?> findAllUser(){
        try{
            return ResponseEntity.ok(userService.GetAllUser());
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    @GetMapping("find/{id}")
    public ResponseEntity<?> findByIdUser(@PathVariable("id") int id){
        try{
            return ResponseEntity.ok(userService.GetByIdUser(id));
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    @GetMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok("Deleted is Successfully");
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    @PutMapping("edit/{id}")
    public ResponseEntity<?> editUser(@PathVariable("id") int id,@RequestBody Users users){
        try{
            return ResponseEntity.ok(userService.EditUser(id,users));
        }
        catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
