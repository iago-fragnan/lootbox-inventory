package dev.iagof.lootbox.services;

import dev.iagof.lootbox.enumerables.Roles;
import dev.iagof.lootbox.helpers.RequestResponse;
import dev.iagof.lootbox.models.Inventory;
import dev.iagof.lootbox.models.RequestModel;
import dev.iagof.lootbox.models.User;
import dev.iagof.lootbox.repositories.UsersRepository;
import dev.iagof.lootbox.helpers.JWTHelper;
import dev.iagof.lootbox.helpers.MD5Helper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServices {

    private final UsersRepository usersRepository;
    private final InventoryServices inventoryServices;

    public UsersServices(UsersRepository usersRepository, InventoryServices inventoryServices) {
        this.usersRepository = usersRepository;
        this.inventoryServices = inventoryServices;
    }


    public RequestModel ListAll() {
        RequestResponse response = new RequestResponse();
        try {
            List<User> allUsers = usersRepository.findAll();
            return response.SetSuccess("SE-0002", allUsers);
        } catch (Exception e) {
            return response.SetFailed("SE-0001", e.getMessage());
        }
    }

    public RequestModel Create(User model){
        RequestResponse response = new RequestResponse();
        try{

            model.setPassword(MD5Helper.generate(model.getPassword()));
            usersRepository.save(model);

            inventoryServices.create(new Inventory(model.getId()));
            return response.SetSuccess("SE-0002", "");
        }
        catch (Exception e){
            return response.SetFailed("SE-0001", e.getMessage());
        }
    }

    public RequestModel Authenticate(User model){
        RequestResponse response = new RequestResponse();
        try{
            User userLogin = usersRepository.findByEmail(model.getEmail());

            if(userLogin == null){
                throw new Exception("User not found!");
            }

            if(userLogin.getPassword().equals(MD5Helper.generate(model.getPassword()))){


                userLogin.setSessionId(JWTHelper.authSigning(userLogin));

                usersRepository.save(userLogin);
                return response.SetSuccess("SE-0002", userLogin);
            }

            throw new Exception("Invalid email/pass");

        }
        catch(Exception e){
            return response.SetFailed("SE-0001", e.getMessage());
        }
    }

    public RequestModel validateToken(String token){
        RequestResponse response = new RequestResponse();
        try{
            return response.SetSuccess("SE-0002", JWTHelper.validate(token));
        }
        catch (Exception e){
            return response.SetFailed("SE-0001", e.getMessage());
        }
    }

}
