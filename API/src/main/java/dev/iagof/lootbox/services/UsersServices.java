package dev.iagof.lootbox.services;

import dev.iagof.lootbox.helpers.RequestResponse;
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


    public UsersServices(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
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

}
