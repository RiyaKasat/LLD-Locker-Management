package main.java.com.riya.lockermanagementsys.service.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.riya.lockermanagementsys.entitites.LockUser;
import main.java.com.riya.lockermanagementsys.entitites.Locker;
import main.java.com.riya.lockermanagementsys.entitites.LockerItem;
import main.java.com.riya.lockermanagementsys.entitites.Size;
import main.java.com.riya.lockermanagementsys.entitites.Slot;
import main.java.com.riya.lockermanagementsys.entitites.UserDetails;
import main.java.com.riya.lockermanagementsys.exceptions.NoSlotsAvailableException;
import main.java.com.riya.lockermanagementsys.exceptions.ResourceNotFoundException;
import main.java.com.riya.lockermanagementsys.repository.LockerRepository;
import main.java.com.riya.lockermanagementsys.repository.SlotReposirory;
import main.java.com.riya.lockermanagementsys.service.LockerService;
import main.java.com.riya.lockermanagementsys.strategies.RandomSlotAllocationSTrategy;
import main.java.com.riya.lockermanagementsys.strategies.SizeBasedFilterSlot;

@Service
public class LockerServiceImpl implements LockerService{


    @Autowired
    private LockerRepository lockerRepo;

    @Autowired
    private SlotReposirory slotReposirory;


    @Autowired
    private SizeBasedFilterSlot sizeBasedFilteringSlotStrategy;

    @Autowired
    private RandomSlotAllocationSTrategy ramdomSlotAllocationSTrategy;

    @Override
    public void createLocker(Locker locker) {
        this.lockerRepo.save(locker);
        
    }

    @Override
    public void createSlots(Locker locker, Slot slot, Size size) {
        Locker fetchedLocker = this.lockerRepo.findById(locker.getLockerId()).orElseThrow(()-> new ResourceNotFoundException("Locker", "lockerId", locker.getLockerId()));
        slot.setSize(size);
        fetchedLocker.addSlot(slot);

        this.lockerRepo.save(locker);
        
    }

    @Override
    public List<Slot> getAvailableSlots() {
        
        List<Slot> slotList = this.slotReposirory.findAll();
        List<Slot> availableSlots= new ArrayList<>();
        for(Slot s: slotList)
        {
           if(s.isAvailable())
           availableSlots.add(s);
        }

        return availableSlots;
    }

    @Override
    public Slot allocateSlot(LockUser user, LockerItem item) {
        
        
        List<Slot> allAvailableSlots = getAvailableSlots();
        final List<Slot> filteredSlots = this.sizeBasedFilteringSlotStrategy.filterSlots(allAvailableSlots, item);
        final Optional<Slot> finalAllocatedSlot = this.ramdomSlotAllocationSTrategy.allocateSlot(filteredSlots);

        
        if(!finalAllocatedSlot.isPresent())
        throw new NoSlotsAvailableException();

        final Slot selectedSlot= finalAllocatedSlot.get();
        selectedSlot.allocateLockerItem(item);
        return selectedSlot;
        
    }

    @Override
    public void deallocateSlot(Slot slot) {
      slot.deallocateSlot();
        
    }
    
}
