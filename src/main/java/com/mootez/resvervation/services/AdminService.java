package com.mootez.resvervation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mootez.resvervation.model.Admin;
import com.mootez.resvervation.repository.AdminRepository;



@Service
public class AdminService {
    @Autowired

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }

    public Admin getAdminById(String id){
        return adminRepository.findById(id).orElse(null);
    }

    public Admin updateAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public void deleteAdminById(String id){
        adminRepository.deleteById(id);
    }
    public Admin getAdminByEmailAndPassword(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }
}
