package dev.iagof.lootbox.controllers;


import dev.iagof.lootbox.models.RequestModel;
import dev.iagof.lootbox.models.User;
import dev.iagof.lootbox.services.UsersServices;
import dev.iagof.lootbox.helpers.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private final UsersServices usersServices;

    public UsersController(UsersServices usersServices) {
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
