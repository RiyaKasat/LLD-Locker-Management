package main.java.com.riya.lockermanagementsys.strategies;

import java.util.List;
import java.util.Optional;

import main.java.com.riya.lockermanagementsys.entitites.Locker;
import main.java.com.riya.lockermanagementsys.entitites.Slot;

public class RandomSlotAllocationSTrategy implements ISlotAllocationStrategy{

    @Override
    public Optional<Slot> allocateSlot(List<Slot> filteredSlots) {
        return filteredSlots.stream().filter(slot -> slot.isAvailable()).findAny();
    }
    
}
