package main.java.com.riya.lockermanagementsys.entitites;


import javax.persistence.Column;

import lombok.Getter;
import lombok.*;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="size")
@Getter
@Setter
@NoArgsConstructor
public class Size {

    @Column(name = "width", nullable= false, length= 10)
    private  Double width;

    @Column(name = "height", nullable= false, length= 10)
    private  Double height;

    
    public boolean canAccommodateItem(@NonNull final Size sizeToAccommodate) {
        return this.width >= sizeToAccommodate.width && this.height >= sizeToAccommodate.height;
    }
}
