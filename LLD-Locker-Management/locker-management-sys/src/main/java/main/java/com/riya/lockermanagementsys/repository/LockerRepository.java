package main.java.com.riya.lockermanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.riya.lockermanagementsys.entitites.Locker;

public interface LockerRepository extends JpaRepository<Locker, Integer>{
    
}
