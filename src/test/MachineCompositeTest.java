import main.Machine;
import main.MachineComposite;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MachineCompositeTest {
    private Machine m1;
    private Machine m2;
    private MachineComposite c1;
    private MachineComposite c2;

    @Before
    public void prepareMachines(){
        m1 = new Machine();
        m2 = new Machine();
        c1 = new MachineComposite();
        c2 = new MachineComposite();
    }

    @Test
    public void testMachineBrokeWorks(){
        assertFalse(m1.isBroken());
        m1.setBroken();
        assertTrue(m1.isBroken());
    }

    @Test
    public void testMachineRepairWorks(){
        m1.setBroken();
        assertTrue(m1.isBroken());
        m1.repair();
        assertFalse(m1.isBroken());
    }

    @Test
    public void testAddBrokenComponent(){
        m1.setBroken();
        c1.addComponent(m1);
        assertTrue(c1.isBroken());
    }

    @Test
    public void testMachineNotifies(){
        c1.addComponent(m1);
        m1.setBroken();
        assertTrue(c1.isBroken());
    }

    @Test
    public void testMachineCompositeNotifies(){
        c1.addComponent(m1);
        c1.addComponent(m2);
        c2.addComponent(c1);
        c1.setBroken();
        assertTrue(c2.isBroken());
    }

    @Test
    public void testCompositeCantRepairWithBrokenChilds(){
        c1.addComponent(m1);
        m2.setBroken();
        c1.addComponent(m2);
        c1.setBroken();
        assertTrue(c1.isBroken());
        c1.repair();
        assertTrue(c1.isBroken());
    }

    @Test
    public void testRepairedChildsDontFixComposite(){
        m1.setBroken();
        m2.setBroken();
        c1.setBroken();
        c1.addComponent(m1);
        c1.addComponent(m2);
        assertTrue(c1.isBroken());
        m1.repair();
        m2.repair();
        assertTrue(c1.isBroken());
    }
}
