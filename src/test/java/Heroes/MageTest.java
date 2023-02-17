package Heroes;

import Items.Item;
import Items.Weapon;
import Items.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    Hero hero;
    @BeforeEach
    void setup() {
        hero = new Mage("Fire Mage");
    }

    @Test
    void getHeroName_AfterCreation_shouldReturnHeroName(){
        String expected = "Fire Mage";
        String actual = hero.getHeroName();

        assertEquals(expected, actual);
    }

    @Test
    void levelUp_fiveTimesAndShowAttributes_shouldBeLevelFiveStats() {
        for(int i = 0; i < 5; i++) {
            hero.levelUp();
        }

        String expectedAfterLevelUp2 = "Strength: 6, Dexterity: 6, Intelligence: 33";
        String actualAfterLevelUp2 = hero.showAttributes();

        assertEquals(expectedAfterLevelUp2, actualAfterLevelUp2);
    }

    @Test
    void getHeroDamageWithWeaponAndArmor_shouldReturnDamage() {
        int expected = 2;
        int actual = hero.getHeroDamage();

        assertEquals(expected, actual);
    }

    @Test
    void getHeroDamageWithWeapon_shouldReturnDamage() throws InvalidWeaponException{
        int expected = 54;

        Item weapon = new Weapon("Magic Staff", WeaponType.STAFF, 1,50);
        hero.equipWeapon(weapon);
        int actual = hero.getHeroDamage();

        assertEquals(expected, actual);
    }
}