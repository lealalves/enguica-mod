package com.enguica.mod.item.custom;

import com.enguica.mod.EnguicaMod;
import com.enguica.mod.block.SalsichaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class SalsichaDetectorItem extends Item {

    public SalsichaDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if(isValuableBlock(state)){
                    outputVariableCoordinates(positionClicked.down(i), player, state.getBlock());

                    foundBlock = true;
                    break;
                }
            }

            if(!foundBlock) {
                player.sendMessage(Text.literal("Nenhuma salsicha encontrada"));
            }
        }

        context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputVariableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Achou " +block.asItem().getName().getString()+" em "
                + "(" +blockPos.getX() + ", "
                + blockPos.getY()
                + ", " + blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(SalsichaBlocks.SALSICHA_BLOCK);
    }
}
