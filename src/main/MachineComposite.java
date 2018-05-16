package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssh5
 */
public class MachineComposite extends MachineComponent implements Observer{
    
    private List<MachineComponent> components = new ArrayList<>();
    private List<MachineComponent> brokenComponents = new ArrayList<>();
    
    public void addComponent(MachineComponent mc){

        mc.addObserver(this);
        components.add(mc);
        checkIfBroken(mc);
    }

    private void checkIfBroken(MachineComponent mc) {
        if(mc.isBroken()){
            brokenComponents.add(mc);
            if(!broken){
                setChangesAndNotify();
            }
        }
    }

    @Override
    public void setBroken() {
        if(!isBroken() && !broken){
            broken = true;
            setChangesAndNotify();
        }else{
            broken = true;
        }
    }

    @Override
    public void repair() {
        if(isBroken() && broken){
            broken = false;
            setChangesAndNotify();
        }else{
            broken = false;
        }
    }
    
    @Override
    public boolean isBroken() {
       return broken || !brokenComponents.isEmpty();
    }
    
    @Override
    public void update(Observable o, Object arg) {

        MachineComponent mc = (MachineComponent) o;
        boolean isBrokenComponent = mc.isBroken();
        boolean brokenBeforeProcess = isBroken();

        if(isBrokenComponent){
            brokenComponents.add(mc);
            if(!brokenBeforeProcess) {
                setChangesAndNotify();
            }
        } else {
            brokenComponents.remove(mc);
            if(brokenBeforeProcess) {
                setChangesAndNotify();
            }
        }
    }

    private void setChangesAndNotify() {
        setChanged();
        notifyObservers();
    }

}
