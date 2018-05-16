package main;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssh5
 */
public class Machine extends MachineComponent{
    
    @Override
    public void setBroken() {
        if(!broken)
            broken = true;
        setChangesAndNotify();
    }

    @Override
    public void repair() {
        if(broken){
            broken = false;
            setChangesAndNotify();
        }
    }

    private void setChangesAndNotify() {
        setChanged();
        notifyObservers();
    }

    @Override
    public boolean isBroken() {
        return broken;
    }
}
