package main.java.com.riya.lockermanagementsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import main.java.com.riya.lockermanagementsys.entitites.LockUser;
import main.java.com.riya.lockermanagementsys.entitites.Locker;
import main.java.com.riya.lockermanagementsys.entitites.LockerItem;
import main.java.com.riya.lockermanagementsys.entitites.Slot;
import main.java.com.riya.lockermanagementsys.service.LockerService;
import main.java.com.riya.lockermanagementsys.service.NotificationService;
import main.java.com.riya.lockermanagementsys.service.PassCodeGenerationSevice;

public class AllocateLockerCOntroller {
    
    @Autowired
    private PassCodeGenerationSevice passcodeService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private LockerService lockerService;


    @PostMapping("/allocateLocker")
    public ResponseEntity allocateLocker(LockUser user,  LockerItem lockerItem, Locker locker ) {
         Slot slot= this.lockerService.allocateSlot(user, lockerItem);
        final String passcode = passcodeService.generatePassCode(slot, locker, user);
        notificationService.notifyUser(user, passcode, slot);
        return ResponseEntity.ok("");
    }
}


