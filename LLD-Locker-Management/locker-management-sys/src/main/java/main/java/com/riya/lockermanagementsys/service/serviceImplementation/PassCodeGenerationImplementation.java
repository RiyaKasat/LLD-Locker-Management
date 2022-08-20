package main.java.com.riya.lockermanagementsys.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.riya.lockermanagementsys.entitites.LockUser;
import main.java.com.riya.lockermanagementsys.entitites.Locker;
import main.java.com.riya.lockermanagementsys.entitites.Slot;
import main.java.com.riya.lockermanagementsys.service.PassCodeGenerationSevice;
import main.java.com.riya.lockermanagementsys.strategies.RandomPassCodeGenerationStrategy;

@Service
public class PassCodeGenerationImplementation implements PassCodeGenerationSevice{

    @Autowired
    private RandomPassCodeGenerationStrategy passcodeGenerator;
    @Override
    public String generatePassCode(Slot slot, Locker locker, LockUser user) {
        final String passcode = this.passcodeGenerator.generatePasscode();
        slot.setPasscode(passcode);
    
        locker.addSlot(slot);
        return passcode;
    }

    @Override
    public boolean validatePassCode(Slot slot, Locker locker, LockUser user, String passcode) {
        final String savedPassCode = passcodeGenerator.generatePasscode();
        return savedPassCode != null && savedPassCode.equals(passcode);
    }
    

   
}
