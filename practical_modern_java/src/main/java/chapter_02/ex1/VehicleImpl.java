package chapter_02.ex1;

public class VehicleImpl implements Vehicle {

    @Override
    public int getSpeedLimit() {
        return Vehicle.SPEED_LIMIT;
    }
}
