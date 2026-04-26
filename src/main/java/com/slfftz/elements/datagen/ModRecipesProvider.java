package com.slfftz.elements.datagen;

import com.slfftz.elements.Elements;
import com.slfftz.elements.items.ModItems;
import com.slfftz.elements.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesProvider extends FabricRecipeProvider {
    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    public static final List<ItemConvertible> LITHIUM_POWDER = List.of(ModBlocks.SPODUMENE_ORE,ModBlocks.AMBLYGONITE_ORE,ModBlocks.LEPIDOLITE_ORE,ModBlocks.DEEPSLATE_SPODUMENE_ORE,ModBlocks.DEEPSLATE_AMBLYGONITE_ORE);
    public static final List<ItemConvertible> LITHIUM_INGOT = List.of(ModItems.LITHIUM_INGOT_BILLET);

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, LITHIUM_POWDER, RecipeCategory.MISC, ModItems.LITHIUM_POWDER, 0.8f, 210, "lithium_powder");
        offerSmelting(exporter, LITHIUM_INGOT, RecipeCategory.MISC, ModItems.LITHIUM_INGOT, 0.8f, 160, "lithium_ingot");

        offerBlasting(exporter, LITHIUM_POWDER, RecipeCategory.MISC, ModItems.LITHIUM_POWDER, 0.8f, 110, "lithium_powder");
        offerBlasting(exporter, LITHIUM_INGOT, RecipeCategory.MISC, ModItems.LITHIUM_INGOT, 0.8f, 80, "lithium_ingot");


        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SPODUMENE,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPODUMENE_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.AMBLYGONITE,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMBLYGONITE_BLOCK);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LITHIUM_ORE_POWDER, 3)
                .input(ModItems.SPODUMENE)
                .criterion(hasItem(ModItems.SPODUMENE), conditionsFromItem(ModItems.SPODUMENE))
                .offerTo(exporter, new Identifier(Elements.MOD_ID, "lithium_ore_powder_from_spodumene_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LITHIUM_ORE_POWDER, 3)
                .input(ModItems.AMBLYGONITE)
                .criterion(hasItem(ModItems.AMBLYGONITE), conditionsFromItem(ModItems.AMBLYGONITE))
                .offerTo(exporter, new Identifier(Elements.MOD_ID, "lithium_ore_powder_from_amblygonite_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LITHIUM_POWDER, 1)
                .input(ModItems.LEPIDOLITE_SHARD)
                .criterion(hasItem(ModItems.LEPIDOLITE_SHARD), conditionsFromItem(ModItems.LEPIDOLITE_SHARD))
                .offerTo(exporter, new Identifier(Elements.MOD_ID, "lithium_powder_from_lepidolite_shard_crafting"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LITHIUM_INGOT_BILLET, 1)
                .input(ModItems.LITHIUM_POWDER)
                .input(ModItems.LITHIUM_POWDER)
                .input(ModItems.LITHIUM_POWDER)
                .input(ModItems.LITHIUM_POWDER)
                .criterion(hasItem(ModItems.LITHIUM_POWDER), conditionsFromItem(ModItems.LITHIUM_POWDER))
                .offerTo(exporter, new Identifier(Elements.MOD_ID, "lithium_ingot_billet_from_lithium_powder_crafting"));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEPIDOLITE_BLOCK, 1)
                .pattern("##")
                .pattern("##")
                .input('#', ModItems.LEPIDOLITE_SHARD)
                .criterion(hasItem(ModItems.LEPIDOLITE_SHARD), conditionsFromItem(ModItems.LEPIDOLITE_SHARD))
                .offerTo(exporter, new Identifier(Elements.MOD_ID, "lepidolite_block_from_lepidolite_shard_crafting"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LITHIUM_POWDER, 3)
                .pattern("###")
                .pattern("#@#")
                .pattern("###")
                .input('#', ModItems.LITHIUM_ORE_POWDER)
                .input('@', Items.WATER_BUCKET)
                .criterion(hasItem(ModItems.LITHIUM_ORE_POWDER), conditionsFromItem(ModItems.LITHIUM_ORE_POWDER))
                .offerTo(exporter, new Identifier(Elements.MOD_ID, "lithium_powder_from_lithium_ore_powder_crafting_with_water_bucket"));


        // 原木 → 木板
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MULBERRY_PLANKS, 4)
                .input(ModBlocks.MULBERRY_LOG)
                .offerTo(exporter, "mulberry_planks_from_log");

        // 木板 → 楼梯
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MULBERRY_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', ModBlocks.MULBERRY_PLANKS)
                .offerTo(exporter, "mulberry_stairs");

        // 木板 → 台阶
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MULBERRY_SLAB, 6)
                .pattern("###")
                .input('#', ModBlocks.MULBERRY_PLANKS)
                .offerTo(exporter, "mulberry_slab");

        // 栅栏
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.MULBERRY_FENCE, 3)
                .pattern("#W#")
                .pattern("#W#")
                .input('#', ModBlocks.MULBERRY_PLANKS)
                .input('W', Items.STICK)
                .offerTo(exporter, "mulberry_fence");

        // 栅栏门
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MULBERRY_FENCE_GATE)
                .pattern("W#W")
                .pattern("W#W")
                .input('#', ModBlocks.MULBERRY_PLANKS)
                .input('W', Items.STICK)
                .offerTo(exporter, "mulberry_fence_gate");

        // 门
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MULBERRY_DOOR, 3)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.MULBERRY_PLANKS)
                .offerTo(exporter, "mulberry_door");

        // 活板门
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MULBERRY_TRAPDOOR, 2)
                .pattern("###")
                .pattern("###")
                .input('#', ModBlocks.MULBERRY_PLANKS)
                .offerTo(exporter, "mulberry_trapdoor");

        // 按钮
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MULBERRY_BUTTON)
                .input(ModBlocks.MULBERRY_PLANKS)
                .offerTo(exporter, "mulberry_button");

        // 压力板
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MULBERRY_PRESSURE_PLATE)
                .pattern("##")
                .input('#', ModBlocks.MULBERRY_PLANKS)
                .offerTo(exporter, "mulberry_pressure_plate");
    }
}