package main.java.com.riya.lockermanagementsys.service;

import java.util.List;

import main.java.com.riya.lockermanagementsys.entitites.LockUser;
import main.java.com.riya.lockermanagementsys.entitites.Locker;
import main.java.com.riya.lockermanagementsys.entitites.LockerItem;
import main.java.com.riya.lockermanagementsys.entitites.Size;
import main.java.com.riya.lockermanagementsys.entitites.Slot;
import main.java.com.riya.lockermanagementsys.entitites.UserDetails;

public interface LockerService {
    
    public void createLocker(Locker locker);
    public void createSlots(Locker locker, Slot slot, Size size);
    public List<Slot> getAvailableSlots();
    public Slot allocateSlot(LockUser user, LockerItem item);
    public void deallocateSlot(Slot slot);
    
}
