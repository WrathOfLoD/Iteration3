package com.wrathOfLoD.SaveLoad;

import com.wrathOfLoD.Models.Ability.AbilityManager;
import com.wrathOfLoD.Models.Entity.Character.Avatar;
import com.wrathOfLoD.Models.Entity.Character.Character;
import com.wrathOfLoD.Models.Entity.Character.NPC;
import com.wrathOfLoD.Models.Entity.Character.Pet;
import com.wrathOfLoD.Models.Entity.Entity;
import com.wrathOfLoD.Models.Entity.Mount;
import com.wrathOfLoD.Models.Inventory.Equipment;
import com.wrathOfLoD.Models.Inventory.Inventory;
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
import com.wrathOfLoD.Models.Map.*;
import com.wrathOfLoD.Models.Map.AreaEffect.*;
import com.wrathOfLoD.Models.Map.Map;
import com.wrathOfLoD.Models.Map.Terrain.*;
import com.wrathOfLoD.Models.Occupation.Occupation;
import com.wrathOfLoD.Models.Skill.SkillManager;
import com.wrathOfLoD.Models.Stats.Stats;
import com.wrathOfLoD.Utility.Position;
import com.wrathOfLoD.VisitorInterfaces.*;
import javafx.geometry.Pos;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;

/**
 * Created by icavitt on 4/12/2016.
 */

public class XMLSaver implements Saver,EntityPropertyVisitor,EntityVisitor,HeldItemVisitor,ItemVisitor,MapVisitor,TileVisitor, AreaEffectVisitor {
    private String fileName;

    @Override
    public void visitGainExpAreaEffect(GainExpAreaEffect gainExpAreaEffect) {

    }

    @Override
    public void visitHealDamageAreaEffect(HealDamageAreaEffect healDamageAreaEffect) {

    }

    @Override
    public void visitInstantDeathAreaEffect(InstantDeathAreaEffect instantDeathAreaEffect) {

    }

    @Override
    public void visitTakeDamageAreaEffect(TakeDamageAreaEffect takeDamageAreaEffect) {

    }

    private Document doc;
    private Position currentPostion = new Position();
    public XMLSaver(){

    }

    @Override
    public void save(String fileName) {
        this.fileName = fileName + ".xml";
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("your save failed to create the doc builder");
            e.printStackTrace();
        }
        doc = docBuilder.newDocument();
        //want to add an attribute to the root element that says what level(string that correspionds to level factory string) this is
        Element root = doc.createElement("YourSavedGame");
        doc.appendChild(root);
        Map.getInstance().accept(this);
        completeSave();
    }

    public void completeSave(){
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileName));
        try {
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        System.out.println("File saved!");
    }

    @Override
    public void visitStats(Stats stats) {

    }

    @Override
    public void visitSkillManager(SkillManager skillManager) {

    }

    @Override
    public void visitAbilityManager(AbilityManager abilityManager) {

    }

    @Override
    public void visitOccupation(Occupation occupation) {

    }

    @Override
    public void visitEntity(Entity entity) {

    }

    @Override
    public void visitCharacter(Character character) {

    }

    @Override
    public void visitAvatar(Avatar avatar) {

    }

    @Override
    public void visitNPC(NPC npc) {

    }

    @Override
    public void visitPet(Pet pet) {

    }

    @Override
    public void visitMount(Mount mount) {

    }

    @Override
    public void visitInventory(Inventory inventory) {

    }

    @Override
    public void visitEquipment(Equipment equipment) {

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
    public void visitObstacle(ObstacleItem obstacleItem) {

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

    @Override
    public void visitMap(Map map) {
        for(MapArea ma : map.getMapAreas()){
            ma.accept(this);
        }
    }

    @Override
    public void visitMapArea(MapArea mapArea) {
        /**
         * write something to the document to identify mapArea
         * probably going to be its name
         */
        HashMap<Position, TilePillar> tilePillarMap= mapArea.getTilePillarMap();
        for(Position position : tilePillarMap.keySet()){
            currentPostion = position;
            TilePillar currentTilePillar = tilePillarMap.get(currentPostion);
            currentTilePillar.accept(this);
        }
    }

    @Override
    public void visitTileColumn(TilePillar tilePillar) {
        /**
         * write something to the doc to identify tile pillar
         * probably just gonna be its position
         */
        Position pos2D = currentPostion.get2DProjection();
        for(int h = 0; h != 10; ++h){
            tilePillar.getTile(pos2D).accept(this);
        }
    }

    @Override
    public void visitTile(Tile tile) {
        /**
         * may not have anything to identify tiles unqiuely
         * will just know that they are recorded bottom to top in tile pillar
         * minor connascence of algorithm if i do that but its within a single class so a very minor violation
         */
        Entity[] entities = tile.getEntitiesArray();
        Item[] items = tile.getItems();
        AreaEffect[] areaEffect = tile.getAreaEffects();

        for(Entity e : entities){
            e.accept(this);
        }

        for(Item i : items){
            i.accept(this);
        }

        for(AreaEffect ae : areaEffect){
            ae.accept(this);
        }

        tile.getTerrain().accept(this);
    }

    @Override
    public void visitTerrain(Terrain terrain) {
        System.out.println("In Visit Terrain: huh shouldnt be visiting super classes in save");
    }

    @Override
    public void visitAreaEffect(AreaEffect areaEffect) {
    }

    @Override
    public void visitTrap(Trap trap) {

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
}
