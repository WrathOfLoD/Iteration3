package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Items.*;
import com.wrathOfLoD.Models.Items.ConsumableItems.ConsumableItem;
import com.wrathOfLoD.Models.Items.ConsumableItems.PermanentConsumable;
import com.wrathOfLoD.Models.Items.ConsumableItems.TemporaryConsumable;
import com.wrathOfLoD.Models.Items.EquippableItems.Armor;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.FistWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.OneHandWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.TwoHandWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SneakWeapons.RangedWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SummonerWeapons.StaffWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;

import java.awt.font.NumericShaper;

/**
 * Created by icavitt on 4/12/2016.
 */
public interface ItemVisitor {

    void visitItem(Item item);
    void visitTakeable(TakeableItem takeableItem);
    void visitOneshotItem(OneShotItem oneShotItem);
    void visitObstacle(ObstacleItem obstacleItem);
    void visitInteractiveItem(InteractiveItem interactiveItem);
    void visitConsumableItem(ConsumableItem consumableItem);
    void visitTemporaryConsumableItem(TemporaryConsumable temporaryConsumable);
    void visitPermanentConsumable(PermanentConsumable permanentConsumable);
    void visitEquippable(EquippableItem equippableItem);
    void visitArmor(Armor armor);
    void visitWeapon(Weapon weapon);
    void visitOneHandWeapon(OneHandWeapon oneHandWeapon);
    void visitFistWeapon(FistWeapon fistWeapon);
    void visitTwoHandWeapon(TwoHandWeapon twoHandWeapon);
    void visitRangedWeapon(RangedWeapon rangedWeapon);
    void visitStaffWeapon(StaffWeapon staffWeapon);


}
