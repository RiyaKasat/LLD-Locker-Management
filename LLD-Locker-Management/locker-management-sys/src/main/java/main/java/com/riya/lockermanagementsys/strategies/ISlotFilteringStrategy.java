package main.java.com.riya.lockermanagementsys.strategies;

import lombok.NonNull;
import main.java.com.riya.lockermanagementsys.entitites.LockerItem;
import main.java.com.riya.lockermanagementsys.entitites.Slot;

import java.util.List;
public interface ISlotFilteringStrategy {
    
    @NonNull
    List<Slot> filterSlots(@NonNull List<Slot> slots, @NonNull LockerItem lockerItem);
}

