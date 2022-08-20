package main.java.com.riya.lockermanagementsys.strategies;

import lombok.NonNull;
import main.java.com.riya.lockermanagementsys.entitites.LockerItem;
import main.java.com.riya.lockermanagementsys.entitites.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class SizeBasedFilterSlot implements ISlotFilteringStrategy {

    
    @Override
    public @NonNull List<Slot> filterSlots(@NonNull List<Slot> slots, @NonNull LockerItem lockerItem) {
        return slots.stream()
        .filter(slot -> slot.getSize().canAccommodateItem(lockerItem.getSize()))
        .collect(Collectors.toList());
    }
}