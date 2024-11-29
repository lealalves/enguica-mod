package com.enguica.mod;

import com.enguica.mod.item.SalsichaItems;
import com.enguica.mod.item.SalsichaItemsGroups;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnguicaMod implements ModInitializer {
	public static final String MOD_ID = "enguica-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SalsichaItems.registerSalsichaItems();
		SalsichaItemsGroups.registerItemsGroups();
	}

}