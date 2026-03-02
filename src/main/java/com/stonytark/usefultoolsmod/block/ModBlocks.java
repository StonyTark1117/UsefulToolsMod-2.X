package com.stonytark.usefultoolsmod.block;

import com.stonytark.usefultoolsmod.UsefultoolsMod;
import com.stonytark.usefultoolsmod.block.custom.SpectralInfuserBlock;
import com.stonytark.usefultoolsmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UsefultoolsMod.MOD_ID);

    public static final RegistryObject<Block> RGOLDBLOCK = registerBlock("rgoldblock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> HRBLOCK = registerBlock("hrblock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));

    public static final RegistryObject<Block> RGOLDORE = registerBlock("rgoldore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> RGOLD_NETHER_ORE = registerBlock("rgold_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE)));

    public static final RegistryObject<Block> RGOLD_END_ORE = registerBlock("rgold_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.ROOTED_DIRT)));

    public static final RegistryObject<Block> RGOLD_DEEPSLATE_ORE = registerBlock("rgold_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> SEMBLOCK = registerBlock("semblock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> SOBLOCK = registerBlock("soblock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> LBLOCK = registerBlock("lblock",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> SPECTRAL_INFUSER = registerBlock("spectral_infuser",
            () -> new SpectralInfuserBlock(BlockBehaviour.Properties.of()
                    .strength(3.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
                    .lightLevel(state -> state.getValue(SpectralInfuserBlock.LIT) ? 13 : 0)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
