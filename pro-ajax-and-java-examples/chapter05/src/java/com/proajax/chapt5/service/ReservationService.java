package com.proajax.chapt5.service;

import com.proajax.chapt5.exception.ReservationNotAvailableException;
import java.util.Date;
import java.util.Random;

public class ReservationService {
    private static Random random = new Random();
    
    public boolean isReservationAvailable(Date arrival, Date departure
            , boolean isSmoking) {
        
        //Of course a real implementation would actually check if the desired
        //reservation was available. Here, just do it randomly so the 
        //reservation is unavailable about 1/3 of the time.
        
        return ! ((random.nextInt(100) % 3) == 0);
    }
    
    public void saveReservation(Date arrival, Date departure
            , boolean isSmoking, String requests
            , String name, String telephone) 
            throws ReservationNotAvailableException {
        
        if(!isReservationAvailable(arrival, departure, isSmoking)) {
            throw new ReservationNotAvailableException();
        }
        
        // Logic to actually save the reservation goes here.
    }
}
