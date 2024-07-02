package com.mootez.resvervation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mootez.resvervation.authentication.auth.AuthenticationRequest;
import com.mootez.resvervation.model.Admin;
import com.mootez.resvervation.services.AdminService;


@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin(origins = "http://localhost:4200")




public class AdminController {
    @Autowired
    private final AdminService adminService;

    
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> admins = adminService.getAllAdmin();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    } 
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest request) {
        Admin admin = adminService.getAdminByEmailAndPassword(request.getEmail(), request.getPassword());
        if (admin != null) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }
    
    @PostMapping("/create")
   public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
    Admin createAdmin = adminService.createAdmin(admin);
    return new ResponseEntity<>(createAdmin,HttpStatus.CREATED);
   }

   @GetMapping("/find/{id}")
   public ResponseEntity<Admin> getAdminById(@PathVariable String id){
    Admin admin= adminService.getAdminById(id);
    if (admin != null) {
        return new ResponseEntity<>(admin, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   }
   @PutMapping("/update/{id}")
   public ResponseEntity <Admin> updateAdmin(@RequestBody Admin admin,@PathVariable String id){
    admin.setId(id);
    Admin updatedAdmin = adminService.updateAdmin(admin);
    return new ResponseEntity<>(updatedAdmin,HttpStatus.OK);
   }
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Void> deleteAdminById(@PathVariable String id){
    adminService.deleteAdminById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
   }

