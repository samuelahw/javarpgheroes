package Items;

import Heroes.HeroAttribute;
import Heroes.HeroAttributeNames;

import java.util.HashMap;

public class Armor extends Item{

    private ArmorType armorType;


    private HashMap<HeroAttributeNames, HeroAttribute> armorAttributes = new HashMap<>();

    public Armor(String name, ArmorType type, int level, ItemSlot slot, int str, int dex, int intel) {
        itemName = name;
        armorType = type;
        requiredLevel = level;
        itemSlot = slot;
        armorAttributes.put(HeroAttributeNames.STRENGTH, new HeroAttribute(str));
        armorAttributes.put(HeroAttributeNames.DEXTERITY, new HeroAttribute(dex));
        armorAttributes.put(HeroAttributeNames.INTELLIGENCE, new HeroAttribute(intel));
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public int getArmorStatByAttribute(HeroAttributeNames attribute) {
        return armorAttributes.get(attribute).returnStat();
    }
}
