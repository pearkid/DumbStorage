package net.minecraft.src;

import java.util.Map;
import java.util.Random;

public class mod_DumbStorage extends BaseMod {
    @Override
    public void AddRenderer(@SuppressWarnings("rawtypes") Map map) {
        map.put(EntityFallingSand2.class, new RenderFallingSand2());
    }

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
    public static int FSid = 50;


    public String Version () {
        return "DumbStorage 0.2.2";
    }
    public mod_DumbStorage(){

        new DumbSBlocks();

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
