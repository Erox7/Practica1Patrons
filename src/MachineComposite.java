
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
        if(mc.isBroken() && !broken ){
            brokenComponents.add(mc);
            setBroken();
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void setBroken() {
        if(!isBroken()){
            broken = true;
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void repair() {
        if(isBroken()){
            broken = true;
            setChanged();
            notifyObservers();
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

        if(isBrokenComponent){
            if(brokenComponents.isEmpty() && !broken) {
                brokenComponents.add(mc);
                setBroken();
                setChanged();
                notifyObservers();
            }
        } else {
            if(!brokenComponents.isEmpty() && broken) {
                brokenComponents.remove(mc);
                repair();
                if(!isBroken()){
                    setChanged();
                    notifyObservers();
                }
            }
        }
    }
    
}
