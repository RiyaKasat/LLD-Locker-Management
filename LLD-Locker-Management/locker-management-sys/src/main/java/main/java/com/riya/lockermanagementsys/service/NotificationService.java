package main.java.com.riya.lockermanagementsys.service;


import lombok.NonNull;
import main.java.com.riya.lockermanagementsys.entitites.LockUser;
import main.java.com.riya.lockermanagementsys.entitites.Slot;

public interface NotificationService {

    public void notifyUser(@NonNull final LockUser user, @NonNull final String passcode, @NonNull final Slot slot);
        
       
    
}
