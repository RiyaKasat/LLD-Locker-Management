package main.java.com.riya.lockermanagementsys.entitites;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import main.java.com.riya.lockermanagementsys.exceptions.SlotAlreadyOccupiedException;

@Entity
@Table(name="slots")
@Getter
@Setter
@NoArgsConstructor
public class Slot {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int slotId;

    @Column(name="passcode", nullable=false, length=100)
    private String passcode;

    private Size size;

    @ManyToOne
    @JoinColumn(name = "locker")
    private Locker locker;


    @OneToOne
    @JoinColumn(name = "user")
    private LockUser user;

    private LockerItem currentLockerItem;

    synchronized public void allocateLockerItem(@NonNull final LockerItem newLockerItem) {
        if (this.currentLockerItem != null) {
            throw new SlotAlreadyOccupiedException();
        }
        this.depositDate = new Date();
        this.currentLockerItem = newLockerItem;
    }

    private boolean isAvailable;

    private Date depositDate;

    public void deallocateSlot() {
        this.currentLockerItem = null;
    }

}
