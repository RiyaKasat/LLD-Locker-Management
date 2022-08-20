package main.java.com.riya.lockermanagementsys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import main.java.com.riya.lockermanagementsys.entitites.LockUser;
import main.java.com.riya.lockermanagementsys.entitites.Locker;
import main.java.com.riya.lockermanagementsys.entitites.Size;
import main.java.com.riya.lockermanagementsys.entitites.Slot;
import main.java.com.riya.lockermanagementsys.service.LockerService;
import main.java.com.riya.lockermanagementsys.service.PassCodeGenerationSevice;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/locker")
public class LockerCOntroller {

    @Autowired
    private  LockerService lockerService;

    @Autowired
    private  PassCodeGenerationSevice passCodeService;

   
    @PostMapping("/createLocker")
    public ResponseEntity createLocker(@Valid @RequestBody Locker locker) {
        this.lockerService.createLocker(locker);
        return ResponseEntity.ok("Locker created");
    }

    @PostMapping("/createSlot")
    public ResponseEntity createSlot(@Valid @RequestBody Locker locker, @Valid @RequestBody Size slotSize, @Valid @RequestBody Slot slot) {
         this.lockerService.createSlots(locker, slot, slotSize);
         return ResponseEntity.ok("Slot created of locker");
    }


    @GetMapping("/getAvailableSlots")
    public ResponseEntity<List<Slot>> getAvailableSlots() {
       
        return ResponseEntity.ok(this.lockerService.getAvailableSlots());
    }

    public boolean unlockSlot(@NonNull final Slot slot, @NonNull final String passcode, Locker locker, LockUser user) {
        return this.passCodeService.validatePassCode(slot, locker, user, passcode);
        
        // Post validation of otp, some physical entity will open the actual slot.
    }

    public void deallocateSlot(@NonNull final Slot slot) {
        lockerService.deallocateSlot(slot);
    }
}

