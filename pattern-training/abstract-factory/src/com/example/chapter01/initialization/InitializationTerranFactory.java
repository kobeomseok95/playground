package com.example.chapter01.initialization;

import com.example.chapter01.building.Building;
import com.example.chapter01.building.TerranCommandCenter;
import com.example.chapter01.worker.TerranScv;
import com.example.chapter01.worker.Worker;

import java.util.ArrayList;
import java.util.List;

public class InitializationTerranFactory extends InitializationFactory{
    @Override
    public Building createBuilding() {
        return new TerranCommandCenter();
    }

    @Override
    public List<Worker> createWorkers() {

        List<Worker> scvList = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            scvList.add(new TerranScv());
        }
        return scvList;
    }
}
