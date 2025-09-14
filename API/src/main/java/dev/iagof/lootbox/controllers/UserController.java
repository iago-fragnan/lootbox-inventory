package dev.iagof.lootbox.controllers;


import dev.iagof.lootbox.models.RequestModel;
import dev.iagof.lootbox.models.User;
import dev.iagof.lootbox.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UsersServices usersServices;

    public UserController(UsersServices usersServices) {
        this.usersServices = usersServices;
    }

    @GetMapping
    public RequestModel getAll(){
        return usersServices.ListAll();
    }

    @PostMapping("/create")
    public RequestModel Create(@RequestBody User model){
        return usersServices.Create(model);
    }

    @PostMapping("/authenticate")
    public RequestModel Authenticate(@RequestBody User model){
        return usersServices.Authenticate(model);
    }

    @GetMapping("/validate")
    public RequestModel validate(@RequestParam String token){
        return usersServices.validateToken(token);
    }

}
