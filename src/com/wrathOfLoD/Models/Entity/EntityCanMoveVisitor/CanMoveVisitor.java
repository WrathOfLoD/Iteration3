package com.wrathOfLoD.Models.Entity.EntityCanMoveVisitor;

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
import com.wrathOfLoD.Models.Map.Terrain.*;
import com.wrathOfLoD.Models.Map.Tile;
import com.wrathOfLoD.Models.Map.Trap;
import com.wrathOfLoD.VisitorInterfaces.ItemVisitor;
import com.wrathOfLoD.VisitorInterfaces.TileVisitor;

/**
 * Created by luluding on 4/16/16.
 */
public abstract class CanMoveVisitor implements TileVisitor, ItemVisitor{
    private boolean canMove = true;

    public boolean canMove(){
        return canMove;
    }

    public void setCanMove(boolean canMove){
        this.canMove = canMove;
    }

    @Override
    public void visitTile(Tile tile) {
        setCanMove(true);
        if(tile.getEntitiesArray().length > 0){
            setCanMove(false);
        }

        tile.getTerrain().accept(this);

        //trap, AE don't care here

        for (Item i : tile.getItems()){
            i.accept(this);
        }
    }



    @Override
    public void visitObstacle(ObstacleItem obstacleItem) {
        setCanMove(false);
    }

    @Override
    public void visitSkyTerrain(Sky sky) {

    }

    @Override
    public void visitGroundTerrain(Ground ground) {

    }

    @Override
    public void visitWaterTerrain(Water water) {

    }

    @Override
    public void visitNullTerrain(NullTerrain terrain) {

    }

    @Override
    public void visitTerrain(Terrain terrain) {

    }

    @Override
    public void visitTrap(Trap trap) {

    }

    @Override
    public void visitItem(Item item) {

    }

    @Override
    public void visitTakeable(TakeableItem takeableItem) {

    }

    @Override
    public void visitOneshotItem(OneShotItem oneShotItem) {

    }

    @Override
    public void visitInteractiveItem(InteractiveItem interactiveItem) {

    }

    @Override
    public void visitConsumableItem(ConsumableItem consumableItem) {

    }

    @Override
    public void visitTemporaryConsumableItem(TemporaryConsumable temporaryConsumable) {

    }

    @Override
    public void visitPermanentConsumable(PermanentConsumable permanentConsumable) {

    }

    @Override
    public void visitEquippable(EquippableItem equippableItem) {

    }

    @Override
    public void visitArmor(Armor armor) {

    }

    @Override
    public void visitWeapon(Weapon weapon) {

    }

    @Override
    public void visitOneHandWeapon(OneHandWeapon oneHandWeapon) {

    }

    @Override
    public void visitFistWeapon(FistWeapon fistWeapon) {

    }

    @Override
    public void visitTwoHandWeapon(TwoHandWeapon twoHandWeapon) {

    }

    @Override
    public void visitRangedWeapon(RangedWeapon rangedWeapon) {

    }

    @Override
    public void visitStaffWeapon(StaffWeapon staffWeapon) {

    }



}
