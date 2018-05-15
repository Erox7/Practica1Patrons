
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
        components.add(mc);
    }

    @Override
    public void setBroken() {
        if(!isBroken()){
            broken = true;
            notifyObservers();
        }
    }

    @Override
    public void repair() {
        if(isBroken()){
            broken = true;
            notifyObservers();
        }
    }
    
    @Override
    public boolean isBroken() {
       if(broken) return true;
       
       for(MachineComponent mc : components){
           if(mc.isBroken()) return true;
       }
       
       return false;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        boolean isBrokenComponent = (boolean) arg;
        
        if(isBrokenComponent){ 
            brokenComponents.add((MachineComponent) o);
        } else {
            brokenComponents.remove((MachineComponent) o);
        }
    }
    
}
