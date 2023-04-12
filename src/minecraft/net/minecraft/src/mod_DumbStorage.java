package net.minecraft.src;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Random;

public class mod_DumbStorage extends BaseMod {
    @Override
    public void AddRenderer(@SuppressWarnings("rawtypes") Map map) {
        map.put(EntityFallingSand2.class, new RenderMovingBlock());
    }
    /*@Override
    public void ModsLoaded(){
        Block.class.getDeclaredField(ModLoader.isModLoaded("net.minecraft.src.mod_DumbStorage") ? "redstoneWire" : "aw");

    }
    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Block.class.getDeclaredField("aw");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }
    public static void main(String args[]) throws Exception {
        setFinalStatic(BlockRedstoneWire.class.getField("aw"), (new BlockProxyRedstoneWire(55, 164)).setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setBlockName("redstoneDust").disableStats().disableNeighborNotifyOnMetadataChange());

        System.out.format("Everything is %s", false); // "Everything is true"
    }*/
    public static int nulltex = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/MissingTexture.png");
    public static int dirttex1 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/soloDirts.png");
    public static int dirttex2 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/DuoDirts.png");
    public static int snadtex1 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/SnadStone.png");
    public static int dirttex3 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/trioDirts.png");
    public static int dirttex4 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/quadDirts.png");
    public static int snadtex2 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/twoSnadstone.png");
    public static int snadtex3 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/threeSnadstone.png");
    public static int snadtex4 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/fourSnadstone.png");
    public static int garvtex1 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/oneGarvel.png");
    public static int garvtex2 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/twoGarvel.png");
    public static int garvtex3 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/threeGarvel.png");
    public static int garvtex4 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/fourGarvel.png");
    public static int stonetex1 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/stone1.png");
    public static int stonetex2 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/stone2.png");
    public static int stonetex3 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/stone3.png");
    public static int stonetex4 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/stone4.png");
    public static int claytex1 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/clay1.png");
    public static int claytex2 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/clay2.png");
    public static int claytex3 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/clay3.png");
    public static int claytex4 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/clay4.png");
    public static int magtex1 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/mag1.png");
    public static int magtex2 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/mag2.png");
    public static int magtex3 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/mag3.png");
    public static int magtex4 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/mag4.png");
    public static int magtex5 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/mag5.png");
    public static int magtex6 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/mag6.png");
    public static int monmagtex1 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/monmag1.png");
    public static int monmagtex2 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/monmag2.png");
    public static int monmagtex3 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/monmag3.png");
    public static int monmagtex4 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/monmag4.png");
    public static int monmagtex5 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/monmag5.png");
    public static int monmagtex6 = ModLoader.addOverride("/terrain.png", "/DumbStorageTextures/monmag6.png");
    public static int redblocktex = ModLoader.addOverride("/terrain.png","/DumbStorageTextures/RedstoneBlock.png");

    /*public static int texture0 = 0;
    public static int texture1 = 1;
    public static int texture2 = 2;
    public static int texture3 = 3;
    public static int texture4 = 4;
    public static int texture5 = 5;
    public static int texture6 = 6;
    public static int texture7 = 7;
    public static int texture8 = 8;
    public static int texture9 = 9;
    public static int texture10 = 10;
    public static int texture11 = 11;
    public static int texture12 = 12;*/

    @MLProp
    public static int snadStoneID = 255;
    @MLProp
    public static int dirtsID = 254;
    @MLProp
    public static int stonesID = 253;
    @MLProp
    public static int magnetID = 252;
    @MLProp
    public static int redstoneID = 251;
    @MLProp
    public static int FSid = 50;


    public String Version () {
        return "DumbStorage 0.4.1";
    }
    public mod_DumbStorage(){

        new DumbSBlocks();

        Block.blocksList[55] = null;
        Block redstoneDust = (new BlockProxyRedstoneWire(55, 164)).setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setBlockName("redstoneDust").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[50] = null;
        Block torchWood = (new BlockProxyTorch(50, 80)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setBlockName("torch").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[75] = null;
        Block torchRedstoneIdle = (new BlockProxyRedstoneTorch(75, 115, false)).setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setBlockName("notGate").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[76] = null;
        Block torchRedstoneActive = (new BlockProxyRedstoneTorch(76, 99, true)).setHardness(0.0F).setLightValue(0.5F).setStepSound(Block.soundWoodFootstep).setBlockName("notGate").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[93] = null;
        Block redstoneRepeaterIdle = (new BlockProxyRedstoneRepeater(93, false)).setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setBlockName("diode").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[94] = null;
        Block redstoneRepeaterActive = (new BlockProxyRedstoneRepeater(94, true)).setHardness(0.0F).setLightValue(0.625F).setStepSound(Block.soundWoodFootstep).setBlockName("diode").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[77] = null;
        Block button = (new BlockProxyButton(77, Block.stone.blockIndexInTexture)).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("button").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[96] = null;
        Block trapdoor = (new BlockProxyTrapDoor(96, Material.wood)).setHardness(3.0F).setStepSound(Block.soundWoodFootstep).setBlockName("trapdoor").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[70] = null;
        Block pressurePlateStone = (new BlockProxyPressurePlate(70, Block.stone.blockIndexInTexture, EnumMobType.mobs, Material.rock)).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("pressurePlate").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[72] = null;
        Block pressurePlatePlanks = (new BlockProxyPressurePlate(72, Block.planks.blockIndexInTexture, EnumMobType.everything, Material.wood)).setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setBlockName("pressurePlate").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[71] = null;
        Block doorSteel = (new BlockProxyDoor(71, Material.iron)).setHardness(5.0F).setStepSound(Block.soundMetalFootstep).setBlockName("doorIron").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[64] = null;
        Block doorWood = (new BlockProxyDoor(64, Material.wood)).setHardness(3.0F).setStepSound(Block.soundWoodFootstep).setBlockName("doorWood").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[69] = null;
        Block lever = (new BlockProxyLever(69, 96)).setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setBlockName("lever").disableNeighborNotifyOnMetadataChange();

        Item.itemsList[Item.redstone.shiftedIndex] = null;
        Item redstone = (new ItemProxyRedstone(Item.redstone.shiftedIndex - 256)).setIconCoord(8, 3).setItemName("redstone");
        Item.itemsList[Item.redstoneRepeater.shiftedIndex] = null;
        Item redstoneRepeater = (new ItemReed(100, Block.redstoneRepeaterIdle)).setIconCoord(6, 5).setItemName("diode");
        Item.itemsList[Item.doorWood.shiftedIndex] = null;
        Item doorProxyWood = (new ItemProxyDoor(68, Material.wood)).setIconCoord(11, 2).setItemName("doorWood");
        Item.itemsList[Item.doorSteel.shiftedIndex] = null;
        Item doorProxySteel = (new ItemProxyDoor(74, Material.iron)).setIconCoord(12, 2).setItemName("doorIron");

        ModLoader.RegisterEntityID(EntityFallingSand2.class, "fallingsand2",FSid);

    }
    public void GenerateSurface (World world, Random random, int i, int j) {
        int [] arr = {1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 2, -2, 3, -4};
        int [] meta1 = {4, 4, 5};
        int [] meta2 = {4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7};
        int [] BlockID1 = {Block.blockClay.blockID, Block.blockClay.blockID, Block.stone.blockID, dirtsID, dirtsID, stonesID, stonesID};
        int [] BlockID2 = {Block.stone.blockID, Block.stone.blockID, Block.stone.blockID, stonesID, stonesID, dirtsID, Block.blockClay.blockID};
        for (int a = 0; a < 40; a ++) {
            int posX = i + random.nextInt(16);
            int posY = random.nextInt(128);
            int posZ = j + random.nextInt(16);
            (new WorldGenGarvel(4)).generate(world, random, posX, posY, posZ);
        }
        for(int a = 0; a < 3; ++a) {
            int posX = i + random.nextInt(16);
            int posY = 64 + random.nextInt(58);
            int posZ = j + random.nextInt(16);
            (new DumbSGenMoai(BlockID1[random.nextInt(BlockID1.length)], BlockID2[random.nextInt(BlockID2.length)], meta1[random.nextInt(meta1.length)], meta2[random.nextInt(meta2.length)], arr[random.nextInt(arr.length)], true)).generate(world, random, posX, posY, posZ);
        }
        for(int a = 0; a < 4; ++a) {
            int posX = i + random.nextInt(16);
            int posY = 64 + random.nextInt(64);
            int posZ = j + random.nextInt(16);
            (new DumbSGenSecretDoor(Block.redstoneWire.blockID, Block.redstoneWire.blockID, true, random.nextBoolean())).generate(world, random, posX, posY, posZ);
        }

    }
    World world;


}
