package net.minecraft.src;

import java.util.Random;

import static java.lang.Math.abs;

public class DumbSGenSecretDoor extends DumbSGenStructures {
    private int BlockID1;
    private int BlockID2;
    private int meta1;
    private int meta2;
    private int meta3;
    private int meta4;
    private int size;
    private int size2;
    private int n;
    private boolean finished;
    private boolean flat;

    public DumbSGenSecretDoor(int i, int j, boolean flag) {
        this.BlockID1 = i;
        this.BlockID2 = j;
        this.flat = flag;
        this.finished = false;
    }

    public boolean generate(World world, Random random, int i, int j, int k) {
        this.replaceAir = true;
        this.replaceSolid = true;
        this.n = 0;



        if (world.isAirBlock(i, j, k) && ((BlockDeadBush) Block.blocksList[32]).canBlockStay(world, i, j, k)) {
            this.setBlocks(this.BlockID1, this.BlockID2, 20);
            this.setMetadata(this.meta1, this.meta2);
            world.setBlockAndMetadata(i, j, k, Block.lever.blockID, 5);
            world.setBlockAndMetadata(i, j - 1, k, mod_DumbStorage.magnetID, 3);
            world.setBlockAndMetadata(i, j - 2, k, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadata(i + 1, j - 2, k, Block.glass.blockID, 0);
            world.setBlockAndMetadata(i - 1, j - 2, k, Block.cloth.blockID, 0);
            world.setBlockAndMetadata(i - 2, j - 2, k, Block.torchRedstoneActive.blockID, 2);
            world.setBlockAndMetadataWithNotify(i - 2, j - 2, k - 1, Block.redstoneRepeaterIdle.blockID, 1);
            this.addLineZ(world, random, i - 3, j - 2, k - 1, 3);
            this.addLineZ(world, random, i - 2, j - 2, k, 2);
            this.addLineZ(world, random, i - 1, j - 2, k - 5, 5);

        }
        return true;
    }
}

