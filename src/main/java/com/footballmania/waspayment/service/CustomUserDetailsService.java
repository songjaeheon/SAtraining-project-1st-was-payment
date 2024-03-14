package com.footballmania.waspayment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.footballmania.waspayment.config.CustomUserDetails;
import com.footballmania.waspayment.entity.User;
import com.footballmania.waspayment.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService {
    @Autowired
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        CustomUserDetails customUserDetails = new CustomUserDetails();
        
        user =  userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        customUserDetails.setId(user.getId());
        customUserDetails.setUuid(user.getUuid());
        customUserDetails.setName(user.getName());
        customUserDetails.setEmail(user.getEmail());
        customUserDetails.setPassword(user.getPassword());

        return customUserDetails;
    }
}
