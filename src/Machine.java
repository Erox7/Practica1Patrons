/*
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
            setChanged();
            notifyObservers();
    }

    @Override
    public void repair() {
        if(broken){
            broken = false;
            setChanged();
            notifyObservers();
        }
    }
    
    @Override
    public boolean isBroken() {
        return broken;
    }
}
