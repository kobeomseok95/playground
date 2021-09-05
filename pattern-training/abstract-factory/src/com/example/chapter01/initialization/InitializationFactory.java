package com.example.chapter01.initialization;

import com.example.chapter01.building.Building;
import com.example.chapter01.worker.Worker;

import java.util.List;

public abstract class InitializationFactory {

    abstract public Building createBuilding();
    abstract public List<Worker> createWorkers();
}
