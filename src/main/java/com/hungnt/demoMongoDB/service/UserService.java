package com.hungnt.demoMongoDB.service;

import com.hungnt.demoMongoDB.dto.request.UserRequest;
import com.hungnt.demoMongoDB.dto.request.UserUpdateRequest;
import com.hungnt.demoMongoDB.dto.response.UserResponse;
import com.hungnt.demoMongoDB.model.User;
import com.hungnt.demoMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponse saveUser(UserRequest userRequest){
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUserName(user.getUserName());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());

        return userResponse;
    }

    public List<UserResponse> findAllUsers(){
        List<UserResponse> userResponses = new ArrayList<>();

        List<User> users = userRepository.findAll();
        for (User user: users){
            UserResponse userResponse = new UserResponse();

            userResponse.setId(user.getId());
            userResponse.setUserName(user.getUserName());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());

            userResponses.add(userResponse);
        }

        return userResponses;
    }

    public UserResponse updateUser(String id, UserUpdateRequest userUpdateRequest) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));
        user.setFirstName(userUpdateRequest.getFirstName());
        user.setLastName(userUpdateRequest.getLastName());

        userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUserName(user.getUserName());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());

        return userResponse;
    }

    public String deleteUser(String id){
        userRepository.deleteById(id);
        String message = "User has been deleted";
        return  message;
    }
}
