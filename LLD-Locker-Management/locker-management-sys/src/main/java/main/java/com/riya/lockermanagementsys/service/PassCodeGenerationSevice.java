package main.java.com.riya.lockermanagementsys.service;

import main.java.com.riya.lockermanagementsys.entitites.LockUser;
import main.java.com.riya.lockermanagementsys.entitites.Locker;
import main.java.com.riya.lockermanagementsys.entitites.Slot;

public interface PassCodeGenerationSevice {

    public String generatePassCode(Slot slot,  Locker locker, LockUser user);
    public boolean validatePassCode(Slot slot, Locker locker, LockUser user, String passcode);
    
}
