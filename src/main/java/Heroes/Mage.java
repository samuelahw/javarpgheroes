package Heroes;

import Items.ArmorType;
import Items.ItemSlot;
import Items.Weapon;
import Items.WeaponType;

public class Mage extends Hero{
    public Mage(String name) {
        super(name);
        strength = new HeroAttribute(1);
        dexterity = new HeroAttribute(1);
        intelligence = new HeroAttribute(8);

        validArmor.add(ArmorType.CLOTH);
        validWeapons.add(WeaponType.STAFF);
        validWeapons.add(WeaponType.WAND);
    }

    @Override
    public void levelUp() {
        level++;
        strength.addStat(1);
        dexterity.addStat(1);
        intelligence.addStat(5);
    }

    @Override
    public int getHeroDamage() {
        if(equipment.get(ItemSlot.WEAPON) != null){
            double x = ((Weapon)equipment.get(ItemSlot.WEAPON)).getWeaponDamage() * (1 + (double)totalAttributes(HeroAttributeNames.INTELLIGENCE) / 100);
            return (int) Math.round(x) ;
        } else {
            return 1 + (1 + intelligence.returnStat() / 100);
        }
    }
}
