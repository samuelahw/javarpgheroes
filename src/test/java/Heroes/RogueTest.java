package Heroes;

import Items.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    Hero hero;

    @BeforeEach
    void setup() {
        hero = new Rogue("Sneaky Rogue");
    }

    @Test
    void getHeroName_AfterCreation_shouldReturnHeroName(){
        String expected = "Sneaky Rogue";
        String actual = hero.getHeroName();

        assertEquals(expected, actual);
    }
    @Test
    void showHeroAttributes_atTheBeginning_shouldBeLevelOneStats() {
        String expected = "Strength: 2, Dexterity: 6, Intelligence: 1";
        String actual = hero.showAttributes();

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
    void equipArmorToItemSlotSuccessfully_shouldBeNotNull() {
        Item armor = new Armor("Test-helmet",ArmorType.LEATHER,0,ItemSlot.HEAD,1,1,1);
        try {
            hero.equipArmor(armor);
        } catch (Exception e){}
        assertNotNull(hero.getEquipment().get(ItemSlot.HEAD));
    }

    @Test
    void equipTooHigHLevelArmor_shouldThrowInvalidArmorException() {
        Item armor = new Armor("Test-helmet",ArmorType.LEATHER,5,ItemSlot.HEAD,1,1,1);

        String expected = "Hero is too low lvl : Hero must be level 5 to equip this item";

        Exception exception = assertThrows(InvalidArmorException.class,
                () -> hero.equipArmor(armor));

        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void equipWrongTypeArmor_shouldThrowInvalidArmorException() {
        Item armor = new Armor("Test-helmet",ArmorType.PLATE,1,ItemSlot.HEAD,1,1,1);

        String expected = "Wrong armor type for class: Rogue";

        Exception exception = assertThrows(InvalidArmorException.class,
                () -> hero.equipArmor(armor));

        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void equipArmorWithWrongTypeObject_shouldThrowInvalidArmorException() {
        Item armor = new Weapon("Test-hammer", WeaponType.HAMMER, 1,5);

        String expected = "Object is not armor";

        Exception exception = assertThrows(InvalidArmorException.class,
                () -> hero.equipArmor(armor));

        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }
    @Test
    void equipWeaponSuccessfully_shouldBeNotNull() {
        Item weapon = new Weapon("Test-sword", WeaponType.SWORD, 0,5);
        try {
            hero.equipWeapon(weapon);
        } catch (Exception e){}
        assertNotNull(hero.getEquipment().get(ItemSlot.WEAPON));
    }
    @Test
    void equipTooHighLevelWeapon_shouldThrowInvalidWeaponException() {
        Item weapon = new Weapon("Test-sword", WeaponType.SWORD, 10,35);

        String expected = "Hero is too low lvl";

        Exception exception = assertThrows(InvalidWeaponException.class,
                () -> hero.equipWeapon(weapon));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void equipWrongTypeWeapon_shouldThrowInvalidWeaponException() {
        Item weapon = new Weapon("Test-hammer", WeaponType.HAMMER, 1,5);

        String expected = "Weapon is wrong type for class : Rogue";

        Exception exception = assertThrows(InvalidWeaponException.class,
                () -> hero.equipWeapon(weapon));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void equipWeaponWithWrongObject_shouldThrowInvalidWeaponException() {
        Item weapon = new Armor("Test-body",ArmorType.PLATE,0,ItemSlot.BODY,1,1,1);

        String expected = "Object is not weapon : Cant equip on weapon slot";

        Exception exception = assertThrows(InvalidWeaponException.class,
                () -> hero.equipWeapon(weapon));
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    void displayHero_shouldReturnStringOfHeroDetails() {
        String expected = "Name: Sneaky Rogue, Class: Rogue, Level: 1, Total strength: 2, Total dexterity: 6, Total intelligence: 1, Hero damage: 2";
        String actual = hero.displayHero();

        assertEquals(expected, actual);
    }

    @Test
    void getHeroDamage_shouldReturnDamage() {
        int expected = 2;
        int actual = hero.getHeroDamage();

        assertEquals(expected, actual);
    }

    @Test
    void heroDamageWithWeapon_shouldReturnDamageWithWeapon() {
        Item weapon = new Weapon("Test-sword", WeaponType.SWORD, 1,5);

        int expected = 5;

        try{
            hero.equipWeapon(weapon);
        } catch (Exception e){}

        int actual = hero.getHeroDamage();

        assertEquals(expected, actual);
    }

    @Test
    void getTotalAttributesStrength_shouldReturnInt() {
        int expected = 2;
        int actual = hero.totalAttributes(HeroAttributeNames.STRENGTH);

        assertEquals(expected, actual);
    }
    @Test
    void getTotalAttributesDexterity_shouldReturnInt() {
        int expected = 6;
        int actual = hero.totalAttributes(HeroAttributeNames.DEXTERITY);

        assertEquals(expected, actual);
    }
    @Test
    void getTotalAttributesIntelligence_shouldReturnInt() {
        int expected = 1;
        int actual = hero.totalAttributes(HeroAttributeNames.INTELLIGENCE);

        assertEquals(expected, actual);
    }

    @Test
    void totalAttributesWithOneArmorPiece_shouldReturnSumOfAttributes() {
        String expected = "3, 7, 2";

        Item helmet = new Armor("Test-helmet",ArmorType.LEATHER,0,ItemSlot.HEAD,1,1,1);
        try {
            hero.equipArmor(helmet);
        } catch (Exception e){}

        String actual = hero.totalAttributes(HeroAttributeNames.STRENGTH) + ", " + hero.totalAttributes(HeroAttributeNames.DEXTERITY) + ", " + hero.totalAttributes(HeroAttributeNames.INTELLIGENCE);
        assertEquals(expected, actual);
    }
    @Test
    void totalAttributesWithTwoArmorPiece_shouldReturnSumOfAttributes() {
        String expected = "5, 10, 3";

        Item helmet = new Armor("Test-helmet",ArmorType.LEATHER,0,ItemSlot.HEAD,1,1,1);
        Item body = new Armor("Test-body",ArmorType.LEATHER,0,ItemSlot.BODY,2,3,1);
        try {
            hero.equipArmor(helmet);
            hero.equipArmor(body);
        } catch (Exception e){}

        String actual = hero.totalAttributes(HeroAttributeNames.STRENGTH) + ", " + hero.totalAttributes(HeroAttributeNames.DEXTERITY) + ", " + hero.totalAttributes(HeroAttributeNames.INTELLIGENCE);
        assertEquals(expected, actual);
    }
    @Test
    void totalAttributesWithThreeArmorPiece_shouldReturnSumOfAttributes() throws InvalidArmorException{

        String expected = "6, 13, 4";

        Item helmet = new Armor("Test-helmet",ArmorType.LEATHER,0,ItemSlot.HEAD,1,1,1);
        Item body = new Armor("Test-body",ArmorType.LEATHER,0,ItemSlot.BODY,2,3,1);
        Item legs = new Armor("Test-legs",ArmorType.LEATHER,0,ItemSlot.LEGS,1,3,1);

        hero.equipArmor(helmet);
        hero.equipArmor(body);
        hero.equipArmor(legs);

        String actual = hero.totalAttributes(HeroAttributeNames.STRENGTH) + ", " + hero.totalAttributes(HeroAttributeNames.DEXTERITY) + ", " + hero.totalAttributes(HeroAttributeNames.INTELLIGENCE);


        assertEquals(expected, actual);
    }

    @Test
    void totalAttributesWithChangedArmorPiece_shouldReturnSumOfAttributes() {
        String expected = "7, 11, 6";

        Item helmet = new Armor("Test-helmet",ArmorType.LEATHER,0,ItemSlot.HEAD,1,1,1);
        try {
            hero.equipArmor(helmet);
        } catch (Exception e){}
        Item newHelmet = new Armor("Better-Test-helmet",ArmorType.LEATHER,1,ItemSlot.HEAD,5,5,5);
        try {
            hero.equipArmor(newHelmet);
        } catch (Exception e){}

        String actual = hero.totalAttributes(HeroAttributeNames.STRENGTH) + ", " + hero.totalAttributes(HeroAttributeNames.DEXTERITY) + ", " + hero.totalAttributes(HeroAttributeNames.INTELLIGENCE);
        assertEquals(expected, actual);
    }

    @Test
    void getHeroDamageWithChangedWeapon_shouldReturnDamage() throws InvalidWeaponException{
        Item weapon = new Weapon("Test-sword", WeaponType.SWORD, 1,5);

        int expected = 53;

        hero.equipWeapon(weapon);

        Item megaWeapon = new Weapon("Mega Sword", WeaponType.SWORD, 1,50);

        hero.equipWeapon(megaWeapon);

        int actual = hero.getHeroDamage();

        assertEquals(expected, actual);
    }

    @Test
    void getHeroDamageWithWeaponAndArmor_shouldReturnDamage() throws InvalidWeaponException, InvalidArmorException{
        int expected = 56;

        Item megaWeapon = new Weapon("Mega Sword", WeaponType.SWORD, 1,50);
        Item helmet = new Armor("Test-helmet",ArmorType.LEATHER,0,ItemSlot.HEAD,1,1,1);
        Item body = new Armor("Test-body",ArmorType.LEATHER,0,ItemSlot.BODY,2,3,1);
        Item legs = new Armor("Test-legs",ArmorType.LEATHER,0,ItemSlot.LEGS,1,3,1);

        hero.equipArmor(helmet);
        hero.equipArmor(body);
        hero.equipArmor(legs);
        hero.equipWeapon(megaWeapon);

        int actual = hero.getHeroDamage();

        assertEquals(expected, actual);
    }
}