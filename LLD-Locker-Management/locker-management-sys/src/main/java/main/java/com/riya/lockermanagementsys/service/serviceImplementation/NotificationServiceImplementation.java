package main.java.com.riya.lockermanagementsys.service.serviceImplementation;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import main.java.com.riya.lockermanagementsys.entitites.LockUser;
import main.java.com.riya.lockermanagementsys.entitites.Slot;
import main.java.com.riya.lockermanagementsys.service.NotificationService;

@Service
public class NotificationServiceImplementation implements NotificationService{

    @Override
    public void notifyUser(@NonNull LockUser user, @NonNull String passcode, @NonNull Slot slot) {
        System.out.println("Sending notification of passcode: " + passcode + " to: " + user + " for slot: " + slot);
    }
    
}
