package com.enguica.mod.item;

import com.enguica.mod.EnguicaMod;
import com.enguica.mod.block.SalsichaBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SalsichaItemsGroups {
    public static final ItemGroup SALSICHA_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EnguicaMod.MOD_ID, "salsicha"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.salsicha"))
                    .icon(() -> new ItemStack(SalsichaItems.SALSICHA)).entries((displayContext, entries) -> {
                        entries.add(SalsichaItems.SALSICHA);

                        entries.add(SalsichaBlocks.SALSICHA_BLOCK);

                        entries.add(SalsichaItems.SALSICHA_SWORD);
                        entries.add(SalsichaItems.SALSICHA_DETECTOR);
                    }).build());


    public static void registerItemsGroups() {
        EnguicaMod.LOGGER.info("Registrando Grupo de items para " + EnguicaMod.MOD_ID);
    }
}
