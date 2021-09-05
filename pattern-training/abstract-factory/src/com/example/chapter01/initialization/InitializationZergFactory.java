package com.example.chapter01.initialization;

import com.example.chapter01.building.Building;
import com.example.chapter01.building.ZergHatchery;
import com.example.chapter01.worker.Worker;
import com.example.chapter01.worker.ZergDrone;

import java.util.ArrayList;
import java.util.List;

public class InitializationZergFactory extends InitializationFactory {

    @Override
    public Building createBuilding() {
        return new ZergHatchery();
    }

    @Override
    public List<Worker> createWorkers() {

        List<Worker> workers = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            workers.add(new ZergDrone());
        }
        return workers;
    }
}
