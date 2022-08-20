package main.java.com.riya.lockermanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.riya.lockermanagementsys.entitites.Slot;

public interface SlotReposirory extends JpaRepository<Slot, Integer> {
    
}
