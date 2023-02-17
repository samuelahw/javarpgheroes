package Heroes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    Hero hero;
    @BeforeEach
    void setup() {
        hero = new Ranger("The Archer");
    }

    @Test
    void getHeroName_AfterCreation_shouldReturnHeroName(){
        String expected = "The Archer";
        String actual = hero.getHeroName();

        assertEquals(expected, actual);
    }

    @Test
    void showAttributes() {
        String expected = "Strength: 1, Dexterity: 7, Intelligence: 1";
        String actual = hero.showAttributes();

        assertEquals(expected, actual);
    }

    @Test
    void levelUp_fiveTimesAndShowAttributes_shouldBeLevelFiveStats() {
        for(int i = 0; i < 5; i++) {
            hero.levelUp();
        }
        String expectedAfterLevelUp2 = "Strength: 6, Dexterity: 32, Intelligence: 6";
        String actualAfterLevelUp2 = hero.showAttributes();

        assertEquals(expectedAfterLevelUp2, actualAfterLevelUp2);
    }

    @Test
    void getHeroDamageWithWeaponAndArmor_shouldReturnDamage() {
        int expected = 2;
        int actual = hero.getHeroDamage();

        assertEquals(expected, actual);
    }
}