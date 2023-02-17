package Heroes;

import Items.Item;
import Items.Weapon;
import Items.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Hero hero;
    @BeforeEach
    void setup() {
        hero = new Warrior("Heavy Warrior");
    }

    @Test
    void getHeroName_AfterCreation_shouldReturnHeroName(){
        String expected = "Heavy Warrior";
        String actual = hero.getHeroName();

        assertEquals(expected, actual);
    }

    @Test
    void showAttributes() {
        String expected = "Strength: 5, Dexterity: 2, Intelligence: 1";
        String actual = hero.showAttributes();

        assertEquals(expected, actual);
    }

    @Test
    void levelUp_fiveTimesAndShowAttributes_shouldBeLevelFiveStats() {
        for(int i = 0; i < 5; i++) {
            hero.levelUp();
        }
        String expectedAfterLevelUp2 = "Strength: 20, Dexterity: 12, Intelligence: 6";
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
        int expected = 84;

        Item weapon = new Weapon("Giant Hammer", WeaponType.HAMMER, 1,80);
        hero.equipWeapon(weapon);
        int actual = hero.getHeroDamage();

        assertEquals(expected, actual);
    }
}