/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssh5
 */
public class MainClass {
    public static void main(String[] args) {
        MachineComposite c1 = new MachineComposite();
        MachineComposite c2 = new MachineComposite();
        Machine m1 = new Machine();
        m1.setBroken();
        System.out.println(m1.isBroken());
        Machine m2 = new Machine();
        c1.addComponent(m1);
        c1.addComponent(m2);
        c2.addComponent(c1);
        System.out.println(c2.isBroken());
        
    }
}
