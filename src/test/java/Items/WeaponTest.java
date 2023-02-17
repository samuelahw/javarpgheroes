package Items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    Item weapon;
    @BeforeEach
    void setup() {
        weapon = new Weapon("Common Axe", WeaponType.AXE, 1,2);
    }

    @Test
    void getWeaponType() {
        WeaponType expected = WeaponType.AXE;
        WeaponType actual = ((Weapon)weapon).getWeaponType();

        assertEquals(expected,actual);
    }

    @Test
    void getName() {
        String expected = "Common Axe";
        String actual = weapon.getName();

        assertEquals(expected, actual);
    }

    @Test
    void getWeaponDamage() {
        int expected = 2;
        int actual = ((Weapon)weapon).getWeaponDamage();

        assertEquals(expected,actual);
    }

    @Test
    void getLevel() {
        int expected = 1;
        int actual = weapon.getLevel();

        assertEquals(expected, actual);
    }

    @Test
    void getItemType() {
        ItemSlot expected = ItemSlot.WEAPON;
        ItemSlot actual = weapon.getSlot();

        assertEquals(expected, actual);
    }
}