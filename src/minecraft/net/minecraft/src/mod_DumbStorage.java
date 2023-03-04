package net.minecraft.src;

public class mod_DumbStorage extends BaseMod {
    public boolean testenabled = true;
    public static int texture0 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/MissingTexture.png");
    public static int texture1 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/soloDirts.png");
    public static int texture2 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/DuoDirts.png");
    public static int texture3 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/SnadStone.png");
    public static int texture4 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/trioDirts.png");
    public static int texture5 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/quadDirts.png");
    @MLProp
    public static int snadStoneID = 255;
    @MLProp
    public static int dirtsID = 254;
    @MLProp
    public static int testID = 253;

    public static Block snadStone;
    public static Block dirts;
    public static Block test;
    public String Version () {
        return "DumbStoragev1";
    }
    public mod_DumbStorage(){

        snadStone = (new BlockSnadStone(snadStoneID, texture3)).setStepSound(Block.soundStoneFootstep).setHardness(0.8F).setBlockName("snadStone");
        dirts = (new BlockDirts(dirtsID)).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setBlockName("dirts");
        test = (new BlockTest(testID)).setHardness(0.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setBlockName("test");

        ModLoader.RegisterBlock(snadStone);
        ModLoader.RegisterBlock(dirts, ItemDirts.class);
        ModLoader.RegisterBlock(test, ItemTest.class);

        ModLoader.AddLocalization("tile.dirts.name", "Dirts");
        ModLoader.AddLocalization("tile.snadStone.name", "Snadstone");
        ModLoader.AddLocalization("tile.test.one.name", "Test 1");
        ModLoader.AddLocalization("tile.test.two.name", "Test 2");
        ModLoader.AddLocalization("tile.test.three.name", "Test 3");
        ModLoader.AddLocalization("tile.test.four.name", "Test 4");
        ModLoader.AddLocalization("tile.dirts.solo.name", "Dirts");
        ModLoader.AddLocalization("tile.dirts.duo.name", "Nonuple Dirts");
        ModLoader.AddLocalization("tile.dirts.trio.name", "Unoctogintuple Dirts");
        ModLoader.AddLocalization("tile.dirts.quad.name", "Duoviginseptingentuple Dirts");


        ModLoader.AddRecipe(new ItemStack(Block.lockedChest, 4), new Object[]{"X", Character.valueOf('X'), Block.chest});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.sand});

        ModLoader.AddRecipe(new ItemStack(dirts, 1, 0), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.dirt});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 2), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 3), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 2)});

        ModLoader.AddRecipe(new ItemStack(Block.sand, 4), new Object[]{"X", Character.valueOf('X'), Block.sandStone});
        ModLoader.AddRecipe(new ItemStack(Block.sand, 9), new Object[]{"X", Character.valueOf('X'), snadStone});
        ModLoader.AddRecipe(new ItemStack(Block.dirt, 9), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 0), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 1), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 2), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 3)});

        if (testenabled == true) {
            ModLoader.AddRecipe(new ItemStack(test, 9, 0), new Object[]{"X", Character.valueOf('X'), Block.stone});
            ModLoader.AddRecipe(new ItemStack(test, 9, 1), new Object[]{"X", Character.valueOf('X'), Block.cobblestone});
            ModLoader.AddRecipe(new ItemStack(test, 9, 2), new Object[]{"X", Character.valueOf('X'), new ItemStack(test, 1, 1)});
            ModLoader.AddRecipe(new ItemStack(test, 1, 3), new Object[]{"X", Character.valueOf('X'), new ItemStack(test, 1, 2)});
            ModLoader.AddRecipe(new ItemStack(dirts, 1, 3), new Object[]{"X", Character.valueOf('X'), Block.dirt});
        }
    }

}
