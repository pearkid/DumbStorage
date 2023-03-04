package net.minecraft.src;

public class mod_DumbStorage extends BaseMod {
    public boolean testenabled = true;
    public static int texture0 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/MissingTexture.png");
    public static int texture1 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/soloDirts.png");
    public static int texture2 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/DuoDirts.png");
    public static int texture3 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/SnadStone.png");
    public static int texture4 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/trioDirts.png");
    public static int texture5 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/quadDirts.png");
    public static int texture6 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/twoSnadstone.png");
    public static int texture7 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/threeSnadstone.png");
    public static int texture8 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/fourSnadstone.png");
    public static int texture9 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/oneGarvel.png");
    public static int texture10 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/twoGarvel.png");
    public static int texture11 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/threeGarvel.png");
    public static int texture12 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/fourGarvel.png");

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
        return "DumbStorage 0.1.1";
    }
    public mod_DumbStorage(){

        snadStone = (new BlockSnadStone(snadStoneID)).setStepSound(Block.soundStoneFootstep).setHardness(0.8F).setBlockName("snadStone");
        dirts = (new BlockDirts(dirtsID)).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setBlockName("dirts");
        test = (new BlockTest(testID)).setHardness(0.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setBlockName("test");

        ModLoader.RegisterBlock(snadStone, ItemSnadStone.class);
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
        ModLoader.AddLocalization("tile.dirts.quad.name", "Nonaduoviginseptingentuple Dirts");
        ModLoader.AddLocalization("tile.snadStone.sone.name", "Snadstone");
        ModLoader.AddLocalization("tile.snadStone.stwo.name", "Snadstones");
        ModLoader.AddLocalization("tile.snadStone.sthree.name", "Nonuple Snadstones");
        ModLoader.AddLocalization("tile.snadStone.sfour.name", "Unoctogintuple Snadstones");
        ModLoader.AddLocalization("tile.snadStone.gone.name", "Garvel");
        ModLoader.AddLocalization("tile.snadStone.gtwo.name", "Garvels");
        ModLoader.AddLocalization("tile.snadStone.gthree.name", "Nonuple Garvels");
        ModLoader.AddLocalization("tile.snadStone.gfour.name", "Unoctogintuple Garvels");

        ModLoader.AddRecipe(new ItemStack(Block.lockedChest, 4), new Object[]{"X", Character.valueOf('X'), Block.chest});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.sand});

        ModLoader.AddRecipe(new ItemStack(dirts, 1, 0), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.dirt});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 2), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(dirts, 1, 3), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(dirts, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 0), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.sand});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 2), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 3), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 4), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.gravel});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 5), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 4)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 6), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 5)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1, 7), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(snadStone, 1, 6)});

        ModLoader.AddRecipe(new ItemStack(Block.sand, 4), new Object[]{"X", Character.valueOf('X'), Block.sandStone});
        ModLoader.AddRecipe(new ItemStack(Block.sand, 9), new Object[]{"X", Character.valueOf('X'), snadStone});
        ModLoader.AddRecipe(new ItemStack(Block.dirt, 9), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 0), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 1), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(dirts, 9, 2), new Object[]{"X", Character.valueOf('X'), new ItemStack(dirts, 1, 3)});
        ModLoader.AddRecipe(new ItemStack(Block.sand, 9), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 0)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 0), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 1)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 1), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 2)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 2), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 3)});
        ModLoader.AddRecipe(new ItemStack(Block.gravel, 9), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 4)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 4), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 5)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 5), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 6)});
        ModLoader.AddRecipe(new ItemStack(snadStone, 9, 6), new Object[]{"X", Character.valueOf('X'), new ItemStack(snadStone, 1, 7)});

        if (testenabled == true) {
            ModLoader.AddRecipe(new ItemStack(test, 9, 0), new Object[]{"X", Character.valueOf('X'), Block.stone});
            ModLoader.AddRecipe(new ItemStack(test, 9, 1), new Object[]{"X", Character.valueOf('X'), Block.cobblestone});
            ModLoader.AddRecipe(new ItemStack(test, 9, 2), new Object[]{"X", Character.valueOf('X'), new ItemStack(test, 1, 1)});
            ModLoader.AddRecipe(new ItemStack(test, 1, 3), new Object[]{"X", Character.valueOf('X'), new ItemStack(test, 1, 2)});
            ModLoader.AddRecipe(new ItemStack(dirts, 1, 3), new Object[]{"X", Character.valueOf('X'), Block.dirt});
            ModLoader.AddRecipe(new ItemStack(snadStone, 1, 3), new Object[]{"XX", Character.valueOf('X'), Block.sand});
            ModLoader.AddRecipe(new ItemStack(snadStone, 1, 7), new Object[]{"XX", Character.valueOf('X'), Block.gravel});
        }
    }

}
