package main.java.com.riya.lockermanagementsys.strategies;

import lombok.NonNull;

public interface IPassCodeGenerationStrategy {
    @NonNull
    String generatePasscode();
}
