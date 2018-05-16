
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
                setChanged();
                notifyObservers();
            }
        }
    }

    @Override
    public void setBroken() {
        if(!isBroken() && !broken){
            broken = true;
            setChanged();
            notifyObservers();
        }else{
            broken = true;
        }
    }

    @Override
    public void repair() {
        if(isBroken() && broken){
            broken = false;
            setChanged();
            notifyObservers();
        }else{
            broken = false;
        }
    }
    
    @Override
    public boolean isBroken() {
       if(broken) return true;

       if(!brokenComponents.isEmpty()) return true;
       
       return false;
    }
    
    @Override
    public void update(Observable o, Object arg) {

        MachineComponent mc = (MachineComponent) o;
        boolean isBrokenComponent = mc.isBroken();
        boolean brokenBeforeProcess = isBroken();

        if(isBrokenComponent){
            brokenComponents.add(mc);
            if(!brokenBeforeProcess) {
                setChanged();
                notifyObservers();
            }
        } else {
            brokenComponents.remove(mc);
            if(brokenBeforeProcess) {
                setChanged();
                notifyObservers();
            }
        }
    }
    
}
