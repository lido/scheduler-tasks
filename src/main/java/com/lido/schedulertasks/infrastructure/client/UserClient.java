package com.lido.schedulertasks.infrastructure.client;

import com.lido.schedulertasks.business.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user", url = "${user.url}")
public interface UserClient {

    @GetMapping("/user")
    UserDTO findUserByEmail(@RequestParam("email") String email,
                            @RequestParam("Authorization") String token);
}
