package net.minecraft.src;

import java.util.Map;
import java.util.Random;

public class mod_DumbStorage extends BaseMod {
    @Override
    public void AddRenderer(@SuppressWarnings("rawtypes") Map map) {
        map.put(EntityFallingSand2.class, new RenderFallingSand2());
    }

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
    public static int testID = 253;

    @MLProp
    public static int FSid = 50;


    public String Version () {
        return "DumbStorage 0.2.0";
    }
    public mod_DumbStorage(){

        new DumbSBlocks();

        ModLoader.RegisterEntityID(EntityFallingSand2.class, "fallingsand2",FSid);

    }
    public void GenerateSurface (World world, Random random, int i, int j) {
        int [] arr = {1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, -1, 2, -2, 3, -4};
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
            (new DumbSGenTest(Block.blockClay.blockID, Block.stone.blockID, arr[random.nextInt(arr.length)], true)).generate(world, random, posX, posY, posZ);
        }

    }
    World world;


}
