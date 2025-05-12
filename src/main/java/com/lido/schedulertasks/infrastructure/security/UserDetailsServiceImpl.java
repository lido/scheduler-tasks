package com.lido.schedulertasks.infrastructure.security;


import com.lido.schedulertasks.business.dto.UserDTO;
import com.lido.schedulertasks.infrastructure.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    // Repositório para acessar dados de usuário no banco de dados
    @Autowired
    private UserClient userClient;


    public UserDetails loadUserData(String email, String token){
        UserDTO userDTO = userClient.findUserByEmail(email, token);

        return User
                .withUsername(userDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(userDTO.getPassword()) // Define a senha do usuário
                .build();
    }
}
