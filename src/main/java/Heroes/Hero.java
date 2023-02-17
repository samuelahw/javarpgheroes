package Heroes;

import Items.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class Hero {

    protected HeroAttribute dexterity;
    protected HeroAttribute intelligence;
    protected HeroAttribute strength;
    protected int level;
    protected String heroName;

    protected Set<WeaponType> validWeapons = new HashSet<>();
    protected Set<ArmorType> validArmor = new HashSet<>();

    protected HashMap<ItemSlot, Item> equipment;

    public abstract void levelUp();

    public Hero(String name){
        this.heroName = name;
        this.level = 1;
        equipment = new HashMap<>();

        equipment.put(ItemSlot.WEAPON, null);
        equipment.put(ItemSlot.HEAD, null);
        equipment.put(ItemSlot.BODY, null);
        equipment.put(ItemSlot.LEGS, null);
    }

    public String getHeroName() {
        return heroName;
    }
    public void equipArmor(Item armor) throws InvalidArmorException{

            if (armor instanceof Armor) {
                if (validArmor.contains(((Armor) armor).getArmorType())) {
                    if (armor.getLevel() <= level) {
                        equipment.put(armor.getSlot(), armor);
                    } else {
                        throw new InvalidArmorException("Hero is too low lvl : Hero must be level " + armor.getLevel() + " to equip this item");
                    }
                } else {
                    throw new InvalidArmorException("Wrong armor type for class: " + this.getClass().getSimpleName());
                }
            } else throw new InvalidArmorException("Object is not armor");

    }

    public void equipWeapon(Item weapon) throws InvalidWeaponException{

            if(weapon instanceof Weapon){
                if(validWeapons.contains(((Weapon) weapon).getWeaponType())) {
                    if(weapon.getLevel() <= level) {
                        equipment.put(ItemSlot.WEAPON, weapon);
                    } else {
                        throw new InvalidWeaponException("Hero is too low lvl");
                    }
                } else {
                    throw new InvalidWeaponException("Weapon is wrong type for class : " + this.getClass().getSimpleName());
                }

            } else {
                throw new InvalidWeaponException("Object is not weapon : Cant equip on weapon slot");
            }

    }

    public String showAttributes() {
        return "Strength: " + strength.returnStat() + ", Dexterity: " + dexterity.returnStat()+ ", Intelligence: " + intelligence.returnStat();
    }

    public String displayHero(){
        return  "Name: "+ heroName +
                ", Class: " + this.getClass().getSimpleName() +
                ", Level: " + level +
                ", Total strength: " + totalAttributes(HeroAttributeNames.STRENGTH) +
                ", Total dexterity: " + totalAttributes(HeroAttributeNames.DEXTERITY) +
                ", Total intelligence: " + totalAttributes(HeroAttributeNames.INTELLIGENCE) +
                ", Hero damage: " + getHeroDamage();
    }

    public int totalAttributes(HeroAttributeNames attribute) {
        int stat = 0;
        for(Item slot : equipment.values()) {
            if(slot != null) {
                if(slot instanceof Armor) stat += ((Armor) slot).getArmorStatByAttribute(attribute);
            }
        }
        switch (attribute) {
            case STRENGTH -> {
                return strength.returnStat() + stat;
            }
            case DEXTERITY -> {
                return dexterity.returnStat() + stat;
            }
            case INTELLIGENCE -> {
                return intelligence.returnStat() + stat;
            }
        }
        return stat;
    }

    public HashMap<ItemSlot, Item> getEquipment() {
        return equipment;
    }

    public abstract int getHeroDamage();
}
