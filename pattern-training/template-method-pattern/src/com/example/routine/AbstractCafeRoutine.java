package com.example.routine;

import com.example.cafe.Cafe;
import com.example.client.Client;

public abstract class AbstractCafeRoutine {

    protected abstract void enter(Cafe cafe);
    protected abstract
//    protected abstract
//    protected abstract
//    protected abstract

    public void cafeProcess(Client client) {
        enter(client.getCafe());

    }
}
