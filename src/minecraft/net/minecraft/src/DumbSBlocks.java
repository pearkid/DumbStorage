package net.minecraft.src;

import java.util.Arrays;


public class DumbSBlocks {
    public boolean testenabled = false;
    public static Block snadStone;
    public static Block dirts;
    public static Block stones;
    public static Block magnet;


    public DumbSBlocks() {
        snadStone = (new BlockSnadStone(mod_DumbStorage.snadStoneID)).setStepSound(Block.soundStoneFootstep).setHardness(0.8F).setBlockName("snadStone");
        dirts = (new BlockDirts(mod_DumbStorage.dirtsID)).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setBlockName("dirts");
        stones = (new BlockStones(mod_DumbStorage.stonesID)).setHardness(0.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setBlockName("stones");
        magnet = (new BlockMagnet(mod_DumbStorage.magnetID)).setHardness(0.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setBlockName("magnet");

        ModLoader.RegisterBlock(snadStone, ItemSnadStone.class);
        ModLoader.RegisterBlock(dirts, ItemDirts.class);
        ModLoader.RegisterBlock(stones, ItemStones.class);
        ModLoader.RegisterBlock(magnet, ItemMagnet.class);

        ModLoader.AddLocalization("tile.dirts.name", "Dirts");
        ModLoader.AddLocalization("tile.snadStone.name", "Snadstone");
        ModLoader.AddLocalization("tile.stones.sone.name", "Stones");
        ModLoader.AddLocalization("tile.stones.stwo.name", "Nonuple Stones");
        ModLoader.AddLocalization("tile.stones.sthree.name", "Unoctogintuple Stones");
        ModLoader.AddLocalization("tile.stones.sfour.name", "Nonaduoviginseptingentuple Stones");
        ModLoader.AddLocalization("tile.stones.x.name", "X-Ray Block");
        ModLoader.AddLocalization("tile.dirts.clay1.name", "Clays");
        ModLoader.AddLocalization("tile.dirts.clay2.name", "Nonuple Clays");
        ModLoader.AddLocalization("tile.dirts.clay3.name", "Unoctogintuple Clays");
        ModLoader.AddLocalization("tile.dirts.clay4.name", "Nonaduoviginseptingentuple Clays");
        ModLoader.AddLocalization("tile.dirts.solo.name", "Dirts");
        ModLoader.AddLocalization("tile.dirts.duo.name", "Nonuple Dirts");
        ModLoader.AddLocalization("tile.dirts.trio.name", "Unoctogintuple Dirts");
        ModLoader.AddLocalization("tile.dirts.quad.name", "Nonaduoviginseptingentuple Dirts");
        ModLoader.AddLocalization("tile.snadStone.sone.name", "Snadstone");
        ModLoader.AddLocalization("tile.snadStone.stwo.name", "Snadstones");
        ModLoader.AddLocalization("tile.snadStone.sthree.name", "Nonuple Snadstones");
        ModLoader.AddLocalization("tile.snadStone.sfour.name", "Unoctogintuple Snadstones");
        ModLoader.AddLocalization("tile.snadStone.gone.name", "Garvel");
        ModLoader.AddLocalization("tile.snadStone.gtwo.name", "Garvels");
        ModLoader.AddLocalization("tile.snadStone.gthree.name", "Nonuple Garvels");
        ModLoader.AddLocalization("tile.snadStone.gfour.name", "Unoctogintuple Garvels");
        ModLoader.AddLocalization("tile.magnet.base.name", "Universal Magnet");
        ModLoader.AddLocalization("tile.magnet.X.name", "Bi-directional Magnet");
        ModLoader.AddLocalization("tile.magnet.Y.name", "Bi-directional Magnet");
        ModLoader.AddLocalization("tile.magnet.Z.name", "Bi-directional Magnet");

        ModLoader.AddRecipe(new ItemStack(Block.lockedChest, 4), new Object[]{"X", Character.valueOf('X'), Block.chest});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.sand});

        ModLoader.AddRecipe(new ItemStack(dirts, 1, 0), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.dirt});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 2), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 3), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 4), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.blockClay});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 5), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 4)});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 6), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 5)});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 7), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 6)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 0), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.sand});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 2), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 3), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 4), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.gravel});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 5), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 4)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 6), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 5)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 7), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 6)});
        ModLoader.AddRecipe(new ItemStack(stones, 1, 0), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.stone});
        ModLoader.AddRecipe(new ItemStack(stones, 1, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(stones, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(stones, 1, 2), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(stones, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(stones, 1, 3), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(stones, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(magnet, 1, 0), new Object[]{"XXX", "XDX", "XXX", Character.valueOf('X'), new ItemStack(Item.ingotIron, 1), Character.valueOf('D'), new ItemStack(Item.redstone, 1)});
        ModLoader.AddRecipe(new ItemStack(magnet, 1, 2), new Object[]{"XDX", "XXX", "XDX", Character.valueOf('X'), new ItemStack(Item.ingotIron, 1), Character.valueOf('D'), new ItemStack(Item.redstone, 1)});

        ModLoader.AddRecipe(new ItemStack(Block.sand, 4), new Object[]{"X", Character.valueOf('X'), Block.sandStone});
        ModLoader.AddRecipe(new ItemStack(Block.dirt, 9), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 0), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 1), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 2), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 3)});
        ModLoader.AddRecipe(new ItemStack(Block.blockClay, 9), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 4)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 4), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 5)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 5), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 6)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 6), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 7)});
        ModLoader.AddRecipe(new ItemStack(Block.sand, 9), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 0), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 1), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 2), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 3)});
        ModLoader.AddRecipe(new ItemStack(Block.gravel, 9), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 4)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 4), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 5)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 5), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 6)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 6), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 7)});
        ModLoader.AddRecipe(new ItemStack(Block.stone, 9), new Object[]{"X", Character.valueOf('X'), new ItemStack(stones, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(stones, 9, 0), new Object[]{"X", Character.valueOf('X'), new ItemStack(stones, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(stones, 9, 1), new Object[]{"X", Character.valueOf('X'), new ItemStack(stones, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(stones, 9, 2), new Object[]{"X", Character.valueOf('X'), new ItemStack(stones, 1, 3)});


        if (testenabled == true) {
            ModLoader.AddRecipe(new ItemStack(stones, 9, 0), new Object[]{"X", Character.valueOf('X'), Block.stone});
            ModLoader.AddRecipe(new ItemStack(stones, 9, 1), new Object[]{"X", Character.valueOf('X'), Block.cobblestone});
            ModLoader.AddRecipe(new ItemStack(stones, 9, 2), new Object[]{"X", Character.valueOf('X'), new ItemStack(stones, 1, 1)});
            ModLoader.AddRecipe(new ItemStack(stones, 1, 3), new Object[]{"X", Character.valueOf('X'), new ItemStack(stones, 1, 2)});
            ModLoader.AddRecipe(new ItemStack(dirts, 1, 3), new Object[]{"X", Character.valueOf('X'), Block.dirt});
            ModLoader.AddRecipe(new ItemStack(snadStone, 1, 3), new Object[]{"XX", Character.valueOf('X'), Block.sand});
            ModLoader.AddRecipe(new ItemStack(snadStone, 1, 7), new Object[]{"XX", Character.valueOf('X'), Block.gravel});
        }
    }
}