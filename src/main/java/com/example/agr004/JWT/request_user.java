package com.example.agr004.JWT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class request_user {
    private String username;
    private String password;
}
