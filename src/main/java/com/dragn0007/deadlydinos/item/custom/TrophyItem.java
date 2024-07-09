package com.dragn0007.deadlydinos.item.custom;

import com.dragn0007.deadlydinos.item.util.DDDItemGroup;
import com.dragn0007.deadlydinos.util.config.DeadlyDinosCommonConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;

public class TrophyItem extends Item {

    public MobEffectInstance[] effectInstances;

    public TrophyItem( MobEffectInstance... effectInstances) {
        super(new Item.Properties().durability(DeadlyDinosCommonConfig.TROPHYITEM_DURABILITY.get()).tab(DDDItemGroup.DDD_GROUP));
        this.effectInstances = effectInstances;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerEntity, InteractionHand hand) {
        if(!level.isClientSide) {
            for(int i = 0; i < effectInstances.length; i++) {
                playerEntity.addEffect(effectInstances[i]);
            }
            ItemStack itemStack = playerEntity.getItemInHand(hand);
            itemStack.hurtAndBreak(2, playerEntity, deez -> deez.broadcastBreakEvent(hand));
        }
        return super.use(level, playerEntity, hand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player) livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) player, itemStack);
        }

        if (!level.isClientSide) {
            for (MobEffectInstance effectInstance : PotionUtils.getMobEffects(itemStack)) {
                if (effectInstance.getEffect().isInstantenous()) {
                    effectInstance.getEffect().applyInstantenousEffect(player, player, livingEntity, effectInstance.getAmplifier(), 1.0D);
                } else {
                    livingEntity.addEffect(new MobEffectInstance(effectInstance));
                }
            }
        }
        level.gameEvent(livingEntity, GameEvent.EAT, livingEntity.eyeBlockPosition());
        return itemStack;
    }

    @Override
    public int getUseDuration(ItemStack p_43001_) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_42997_) {
        return UseAnim.BOW;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(itemStack, level, tooltip, flag);

        for (MobEffectInstance effectInstance : effectInstances) {
            String effectName = effectInstance.getEffect().getDisplayName().getString();
            String amplifier = String.format(" Level %d", effectInstance.getAmplifier() + 1);
            String text = effectName + amplifier;

            tooltip.add(new TextComponent(text).withStyle(ChatFormatting.GOLD));
        }
    }
}

