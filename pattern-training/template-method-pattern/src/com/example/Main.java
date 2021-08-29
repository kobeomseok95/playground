package com.example;

import com.example.client.Client;
import com.example.routine.AbstractCafeRoutine;
import com.example.routineImpl.SeatCafeRoutine;
import com.example.routineImpl.TakeOutCafeRoutine;

public class Main {

    public static void main(String[] args) {

        // 좌석이 있는 카페
        AbstractCafeRoutine seatCafeRoutine = new SeatCafeRoutine();
        Client client = new Client("고범석");
        seatCafeRoutine.cafeProcess(client);

        AbstractCafeRoutine takeOutCafeRoutine = new TakeOutCafeRoutine();
        takeOutCafeRoutine.cafeProcess(client);
    }
}
