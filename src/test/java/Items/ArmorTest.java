package Items;

import Heroes.HeroAttributeNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    Item armor;
    @BeforeEach
    void setup() {
        armor = new Armor("Common Plate Chest", ArmorType.PLATE, 1, ItemSlot.BODY, 1,0,0);
    }

    @Test
    void getArmorType() {
        ArmorType expected = ArmorType.PLATE;
        ArmorType actual = ((Armor)armor).getArmorType();

        assertEquals(expected, actual);
    }

    @Test
    void getArmorStatByAttributeStrength() {
        int expected = 1;
        int actual = ((Armor)armor).getArmorStatByAttribute(HeroAttributeNames.STRENGTH);

        assertEquals(expected, actual);
    }

    @Test
    void getArmorStatByAttributeDexterity() {
        int expected = 0;
        int actual = ((Armor)armor).getArmorStatByAttribute(HeroAttributeNames.DEXTERITY);

        assertEquals(expected, actual);
    }

    @Test
    void getArmorStatByAttributeIntelligence() {
        int expected = 1;
        int actual = ((Armor)armor).getArmorStatByAttribute(HeroAttributeNames.INTELLIGENCE);

        assertEquals(expected, actual);
    }

    @Test
    void getName() {
        String expected = "Common Plate Chest";
        String actual = armor.getName();

        assertEquals(expected, actual);
    }

    @Test
    void getLevel() {
        int expected = 1;
        int actual = armor.getLevel();

        assertEquals(expected, actual);
    }

    @Test
    void getSlot() {
        ItemSlot expected = ItemSlot.BODY;
        ItemSlot actual = armor.getSlot();

        assertEquals(expected, actual);
    }
}