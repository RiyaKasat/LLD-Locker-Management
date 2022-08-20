package main.java.com.riya.lockermanagementsys.strategies;


import net.bytebuddy.utility.RandomString;

public class RandomPassCodeGenerationStrategy implements IPassCodeGenerationStrategy{

   
    @Override
    public String generatePasscode() {

        int length = 12;
        // boolean useLtter= true;
        // boolean useNumber = true;

        String generatedString = RandomString.make(length);
        return generatedString;
        
    }
    
}
