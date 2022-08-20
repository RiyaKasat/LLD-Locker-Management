package main.java.com.riya.lockermanagementsys.entitites;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class LockerItemByUSer implements LockerItem {

    private final int id;
    private final Size size;

    public LockerItemByUSer(@NonNull final Integer id, @NonNull final Size size) {
        this.id = id;
        this.size = size;
    }
}
