package Heroes;

import Items.Item;
import Items.Weapon;
import Items.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RogueTest {

    Hero hero;
    @BeforeEach
    void setup() {
        hero = new Rogue("Dagger Rogue");
    }

    @Test
    void getHeroName_AfterCreation_shouldReturnHeroName(){
        String expected = "Dagger Rogue";
        String actual = hero.getHeroName();

        assertEquals(expected, actual);
    }

    @Test
    void levelUp_fiveTimesAndShowAttributes_shouldBeLevelFiveStats() {
        for(int i = 0; i < 5; i++) {
            hero.levelUp();
        }
        String expectedAfterLevelUp2 = "Strength: 7, Dexterity: 26, Intelligence: 6";
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
        int expected = 42;

        Item weapon = new Weapon("Dirk", WeaponType.DAGGER, 1,40);
        hero.equipWeapon(weapon);
        int actual = hero.getHeroDamage();

        assertEquals(expected, actual);
    }
}
