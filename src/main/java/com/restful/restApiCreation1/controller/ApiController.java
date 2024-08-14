package com.restful.restApiCreation1.controller;

import com.restful.restApiCreation1.model.Address;
import com.restful.restApiCreation1.model.User;
import com.restful.restApiCreation1.repo.AddressRepo;
import com.restful.restApiCreation1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AddressRepo addressRepo;

    @GetMapping(value = "/address/{userId}")
    public String getAddressById(@PathVariable Long userId) {
        return addressRepo.findAllByUserId(userId).toString();
    }

    @PostMapping(value = "address")
    public String createAddress(@RequestBody Address address) {
        Optional<User> user = userRepo.findById(address.getUser().getId());
        Address savedAddress = addressRepo.save(address);
        return "address saved - "+savedAddress.getId();

    }
    //Creating the user address

    @GetMapping(value = "/")
    public String getPage() {
        return "Hello there!";
    }
    //Getting the message that restapi is up

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }
    //Listing the users

    @GetMapping(value = "/users/{id}")
    public String getUsersByIds(@PathVariable Long id) {
        try {
            Optional<User> user = userRepo.findById(id);

            if (user.isPresent()) {
                return user.get().toString();
            }
        } catch (Exception e) {
            //TODO - to remove after testing
            System.out.println("Error while fetching user-" + id);
            System.out.println("Exception: " + e);
        }
        return "User Not found with id-" + id;
    }
    // listing the user based on id

    @PostMapping(value = "/save")
    public String saveUsers(@RequestBody User user) {
        userRepo.save(user);
        return "saved user id - " + user.getId();
    }
    // Saving the user
    @PutMapping(value = "update/{id}")
    public String updateUsers(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "updated...";
    }
    //updating the user based on id
}
