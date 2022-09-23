package com.example.agr004.Auth;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser>selectApplicationUserEmail(String email);
}
