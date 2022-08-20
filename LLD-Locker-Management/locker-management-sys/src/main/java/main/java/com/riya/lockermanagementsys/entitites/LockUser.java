package main.java.com.riya.lockermanagementsys.entitites;

import lombok.AllArgsConstructor;

import javax.persistence.OneToOne;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
public abstract class LockUser {

    private UserDetails user;
    
   
    @OneToOne(mappedBy="user")
    private Slot slot;
}