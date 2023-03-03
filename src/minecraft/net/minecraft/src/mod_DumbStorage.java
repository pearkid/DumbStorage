package net.minecraft.src;

public class mod_DumbStorage extends BaseMod {
    public boolean testenabled = true;
    public static int texture0 = ModLoader.addOverride("/terrain.png", "/DumbStorage/MissingTexture.png");
    public static int texture1 = ModLoader.addOverride("/terrain.png", "/DumbStorage/Dirts1.png");
    public static int texture2 = ModLoader.addOverride("/terrain.png", "/DumbStorage/NonupalDirts.png");
    public static int texture3 = ModLoader.addOverride("/terrain.png", "/DumbStorage/SnadStone.png");
    @MLProp(name="snadStone", info="The blockId for gravityBlock - snadStone", min=0, max=255)
    public static final Block snadStone = (new BlockSnadStone(255, texture3)).setStepSound(Block.soundStoneFootstep).setHardness(0.8F).setBlockName("snadStone");
    @MLProp(name="dirts", info="The blockId for block - dirts", min=0, max=255)
    public static final Block dirts = (new BlockDirts(254, texture1)).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setBlockName("dirts");
    @MLProp(name="test", info="The blockId for block - test", min=0, max=255)
    public static final Block test = (new BlockTest(253)).setHardness(0.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setBlockName("test");
    public String Version () {
        return "DumbStoragev1";
    }
    public mod_DumbStorage(){

        ModLoader.RegisterBlock(snadStone);
        ModLoader.RegisterBlock(dirts);
        ModLoader.RegisterBlock(test, ItemTest.class);

        ModLoader.AddLocalization("tile.dirts.name", "Dirts");
        ModLoader.AddLocalization("tile.snadStone.name", "Snadstone");
        ModLoader.AddLocalization("tile.test.one.name", "Test 1");
        ModLoader.AddLocalization("tile.test.two.name", "Test 2");
        ModLoader.AddLocalization("tile.test.three.name", "Test 3");
        ModLoader.AddLocalization("tile.test.four.name", "Test 4");
        ModLoader.AddLocalization("tile.test.four.desc", "Why?");

        ModLoader.AddRecipe(new ItemStack(Block.sand, 4), new Object[]{"X", Character.valueOf('X'), Block.sandStone});
        ModLoader.AddRecipe(new ItemStack(Block.lockedChest, 4), new Object[]{"X", Character.valueOf('X'), Block.chest});
        ModLoader.AddRecipe(new ItemStack(snadStone, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.sand});
        ModLoader.AddRecipe(new ItemStack(Block.sand, 9), new Object[]{"X", Character.valueOf('X'), snadStone});
        ModLoader.AddRecipe(new ItemStack(dirts, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), Block.dirt});
        ModLoader.AddRecipe(new ItemStack(Block.dirt, 9), new Object[]{"X", Character.valueOf('X'), dirts});

        if (testenabled == true) {
            ModLoader.AddRecipe(new ItemStack(test, 9, 0), new Object[]{"X", Character.valueOf('X'), Block.dirt});
            ModLoader.AddRecipe(new ItemStack(test, 9, 1), new Object[]{"X", Character.valueOf('X'), Block.cobblestone});
            ModLoader.AddRecipe(new ItemStack(test, 9, 2), new Object[]{"X", Character.valueOf('X'), new ItemStack(test, 1, 1)});
            ModLoader.AddRecipe(new ItemStack(test, 1, 3), new Object[]{"X", Character.valueOf('X'), new ItemStack(test, 1, 2)});
        }
    }

}
