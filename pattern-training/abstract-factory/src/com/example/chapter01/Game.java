package com.example.chapter01;

import com.example.chapter01.behavior.Gatherable;
import com.example.chapter01.building.Building;
import com.example.chapter01.initialization.InitializationFactory;
import com.example.chapter01.initialization.InitializationTerranFactory;
import com.example.chapter01.initialization.InitializationZergFactory;
import com.example.chapter01.worker.Worker;
import com.example.chapter01.worker.ZergDrone;

import java.util.List;

public class Game {

    public void main() {
        InitializationFactory zerg = new InitializationZergFactory();
        Building hatchery = zerg.createBuilding();
        List<Worker> droneList = zerg.createWorkers();
        droneList.forEach(Gatherable::gather);
        hatchery.createWorker();
        Worker drone = droneList.get(0);
        drone.printInfo();

        InitializationFactory terran = new InitializationTerranFactory();
        Building commandCenter = terran.createBuilding();
        List<Worker> scvList = terran.createWorkers();
        scvList.forEach(Gatherable::gather);
        commandCenter.createWorker();
        Worker scv = scvList.get(0);
        scv.printInfo();
    }
}
