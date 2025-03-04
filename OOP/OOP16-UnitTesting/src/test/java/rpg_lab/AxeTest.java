package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int HEALTH = 50;
    private static final int EXPERIENCE = 10;

    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(ATTACK, DURABILITY);
        this.brokenAxe = new Axe(ATTACK, 0);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void testAttackReduceWeaponDurability() {
        axe.attack(dummy);
        int expected = DURABILITY - 1;
        assertEquals(expected, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testBrokenWeaponCantAttack() {
        brokenAxe.attack(dummy);
    }

    @Test
    public void testAttackPoints() {

        assertEquals(ATTACK, axe.getAttackPoints());

    }
}
