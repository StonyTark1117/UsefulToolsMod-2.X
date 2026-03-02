package com.stonytark.usefultoolsmod.item.custom;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

/**
 * Utility for reading and writing the ectoplasm-infused state stored in an
 * ItemStack's CustomData component.  Infused weapons can damage ghosts.
 */
public final class EctoplasmInfusionHelper {

    private static final String TAG_KEY = "ectoplasm_infused";

    private EctoplasmInfusionHelper() {}

    public static boolean isInfused(ItemStack stack) {
        if (stack.isEmpty()) return false;
        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        if (data.isEmpty()) return false;
        return data.copyTag().getBoolean(TAG_KEY);
    }

    public static void setInfused(ItemStack stack, boolean infused) {
        if (stack.isEmpty()) return;

        CustomData existing = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        CompoundTag tag = existing.copyTag();

        if (infused) {
            tag.putBoolean(TAG_KEY, true);
            stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        } else {
            tag.remove(TAG_KEY);
            if (tag.isEmpty()) {
                stack.remove(DataComponents.CUSTOM_DATA);
            } else {
                stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
            }
        }
    }
}
