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
        Machine m2 = new Machine();
        c1.addComponent(m1);
        c1.addComponent(m2);
        c2.addComponent(c1);
        //test1(c1,m1,m2);
        test2(c1,c2,m1,m2);
    }

    private static void test2(MachineComposite c1, MachineComposite c2, Machine m1, Machine m2) {
        m1.setBroken();
        System.out.println("M1: " + m1.isBroken());
        System.out.println("M2: " + m2.isBroken());
        System.out.println("C1: " + c1.isBroken());
        System.out.println("C2: " + c2.isBroken());
        System.out.println("\n Set broken c2 "+ "\n" + "--------------------------------");
        c2.setBroken();
        System.out.println("M1: " + m1.isBroken());
        System.out.println("M2: " + m2.isBroken());
        System.out.println("C1: " + c1.isBroken());
        System.out.println("C2: " + c2.isBroken() + "\n");
        System.out.println("\n Repair m1 "+ "\n" + "--------------------------------");
        m1.repair();
        System.out.println("M1: " + m1.isBroken());
        System.out.println("M2: " + m2.isBroken());
        System.out.println("C1: " + c1.isBroken());
        System.out.println("C2: " + c2.isBroken() + "\n");
        System.out.println("\n Repair c2 and broke c1 "+ "\n" + "--------------------------------");
        c2.repair();
        c1.setBroken();
        System.out.println("M1: " + m1.isBroken());
        System.out.println("M2: " + m2.isBroken());
        System.out.println("C1: " + c1.isBroken());
        System.out.println("C2: " + c2.isBroken() + "\n");
        System.out.println("\n Repair c1 "+ "\n" + "--------------------------------");
        c1.repair();
        System.out.println("M1: " + m1.isBroken());
        System.out.println("M2: " + m2.isBroken());
        System.out.println("C1: " + c1.isBroken());
        System.out.println("C2: " + c2.isBroken() + "\n");
    }

    private static void test1(MachineComposite c1, Machine m1, Machine m2) {
        m1.setBroken();
        System.out.println("M1: " + m1.isBroken());
        System.out.println("M2: " + m2.isBroken());
        System.out.println("C1: " + c1.isBroken() + "\n");
        System.out.println("Try to repair c1 with a broken component \n" + "--------------------------------");
        c1.setBroken();
        System.out.println("M1: " + m1.isBroken());
        System.out.println("M2: " + m2.isBroken());
        System.out.println("C1: " + c1.isBroken() + "\n");
        System.out.println("Repair m1\n" + "--------------------------------");
        m1.repair();
        System.out.println("M1: " + m1.isBroken());
        System.out.println("M2: " + m2.isBroken());
        System.out.println("C1: " + c1.isBroken() + "\n");
        System.out.println("Try to repair c1 with no broken components \n" +"--------------------------------");
        c1.repair();
        System.out.println("M1: " + m1.isBroken());
        System.out.println("M2: " + m2.isBroken());
        System.out.println("C1: " + c1.isBroken());
    }
}
