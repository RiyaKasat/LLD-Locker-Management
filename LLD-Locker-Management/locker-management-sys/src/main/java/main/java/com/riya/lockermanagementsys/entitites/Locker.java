package main.java.com.riya.lockermanagementsys.entitites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="locker")
@Getter
@Setter
@NoArgsConstructor
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lockerId;


    @OneToMany(mappedBy="locker", cascade = CascadeType.ALL)
    private List<Slot> slots = new ArrayList<>();

    
    public void addSlot(@NonNull final Slot newSlot) {
        this.slots.add(newSlot);
    }

    // @NonNull
    // public List<Slot> getAvailableSlots() {
    //     final List<Slot> result = new ArrayList<>();
    //     for (Slot slot : this.slots) {
    //         if (slot.isAvailable()) {
    //             result.add(slot);
    //         }
    //     }
    //     return result;
    // }
}


