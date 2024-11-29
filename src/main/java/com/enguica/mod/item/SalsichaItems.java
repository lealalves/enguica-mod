package com.enguica.mod.item;

import com.enguica.mod.EnguicaMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SalsichaItems {

    public static final Item SALSICHA = registerItem("salsicha", new Item(new FabricItemSettings()));

    public static final Item SALSICHA_SWORD = registerItem("salsicha_sword",
            new SwordItem(SalsichaToolMaterial.SALSICHA, 8, 4f, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EnguicaMod.MOD_ID, name), item);
    }

    public static void registerSalsichaItems() {
        EnguicaMod.LOGGER.info("Registrando itens para " + EnguicaMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(SalsichaItems::addItemsToIngredientTabItemGroup);
    }

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(SALSICHA);
    }
}
