package com.wrathOfLoD.VisitorInterfaces;

import com.wrathOfLoD.Models.Items.*;
import com.wrathOfLoD.Models.Items.ConsumableItems.ConsumableItem;
import com.wrathOfLoD.Models.Items.EquippableItems.Armor;
import com.wrathOfLoD.Models.Items.EquippableItems.EquippableItem;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.SmasherWeapons.OneHandWeapon;
import com.wrathOfLoD.Models.Items.EquippableItems.Weapons.Weapon;

/**
 * Created by icavitt on 4/12/2016.
 */
public interface ItemVisitor {

    public void visitItem(Item item);
    public void visitTakeable(TakeableItem takeableItem);
    public void visitOneshotItem(OneShotItem oneShotItem);
    public void visitObstacle(ObstacleItem obstacleItem);
    public void visitInteractiveItem(InteractiveItem interactiveItem);
    public void visitConsumableItem(ConsumableItem consumableItem);
    public void visitEquippable(EquippableItem equippableItem);
    public void visitArmor(Armor armor);
    public void visitWeapon(Weapon weapon);
}
