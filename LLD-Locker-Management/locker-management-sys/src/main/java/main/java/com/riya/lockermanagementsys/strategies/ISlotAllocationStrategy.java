package main.java.com.riya.lockermanagementsys.strategies;
import lombok.NonNull;
import main.java.com.riya.lockermanagementsys.entitites.Locker;
import main.java.com.riya.lockermanagementsys.entitites.Slot;

import java.util.List;
import java.util.Optional;
public interface ISlotAllocationStrategy {

  
        Optional<Slot> allocateSlot( List<Slot> filteredSlots);
    
}
