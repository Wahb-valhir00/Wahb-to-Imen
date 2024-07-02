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

import org.springframework.web.bind.annotation.RestController;

import com.mootez.resvervation.model.Menu;
import com.mootez.resvervation.services.MenuNotFoundException;
import com.mootez.resvervation.services.MenuService;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    @Autowired

    private final MenuService menuService;
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @PostMapping("/create")
        public ResponseEntity<Menu> createMenu(@RequestBody Menu menu){
            Menu createUser= menuService.createMenu(menu);
            return new ResponseEntity<>(createUser,HttpStatus.CREATED);
        }
        @GetMapping("/find/{id}")
        public ResponseEntity<Menu> getMenuById(@PathVariable String id){
            Menu user=menuService.getMenuById(id);
            if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.FOUND);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        @GetMapping("/all")
        public ResponseEntity<List<Menu>> getAllMenu(){
            List<Menu> users=menuService.getAllMenus();
            return new ResponseEntity<>(users,HttpStatus.OK);
        }
        @PutMapping("/update/{id}")
        public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu,@PathVariable String id){
        menu.setId(id);
                Menu updateduser=menuService.updateMenu(menu);
                return new ResponseEntity<>(updateduser,HttpStatus.OK);
        }
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteMenuById(@PathVariable String id){
            menuService.deleteMenuById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

       @GetMapping("/price/{id}")
   public ResponseEntity<Double> calculateTotalPrice(@PathVariable String id) {
        try {
            double totalPrice = menuService.calculateTotalPrice(id);
            return ResponseEntity.ok(totalPrice);
        } catch (MenuNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    
}
