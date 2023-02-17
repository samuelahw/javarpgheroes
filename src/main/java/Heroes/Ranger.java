package Heroes;

import Items.ArmorType;
import Items.ItemSlot;
import Items.Weapon;
import Items.WeaponType;

public class Ranger extends Hero{
    public Ranger(String name) {
        super(name);
        strength = new HeroAttribute(1);
        dexterity = new HeroAttribute(7);
        intelligence = new HeroAttribute(1);

        validArmor.add(ArmorType.LEATHER);
        validArmor.add(ArmorType.MAIL);
        validWeapons.add(WeaponType.BOW);
    }

    @Override
    public void levelUp() {
        level++;
        strength.addStat(1);
        dexterity.addStat(5);
        intelligence.addStat(1);
    }

    @Override
    public int getHeroDamage() {
        if(equipment.get(ItemSlot.WEAPON) != null){
            double x = ((Weapon)equipment.get(ItemSlot.WEAPON)).getWeaponDamage() * (1 + (double)totalAttributes(HeroAttributeNames.DEXTERITY) / 100);
            return (int) Math.round(x) ;
        } else {
            return 1 + (1 + dexterity.returnStat() / 100);
        }
    }
}
