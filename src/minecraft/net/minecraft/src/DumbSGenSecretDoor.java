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
    private boolean trap;

    public DumbSGenSecretDoor(int i, int j, boolean flag, boolean trap) {
        this.BlockID1 = i;
        this.BlockID2 = j;
        this.flat = flag;
        this.finished = false;
        this.trap = trap;
    }

    public boolean generate(World world, Random random, int i, int j, int k) {
        this.replaceAir = true;
        this.replaceSolid = true;
        this.n = 0;



        if (world.isAirBlock(i, j, k) && ((BlockDeadBush) Block.blocksList[32]).canBlockStay(world, i, j, k) && !world.isAirBlock(i + 8, j - 1, k - 8)) {
            this.setBlocks(Block.sand.blockID, Block.grass.blockID, 10);
            this.addSolidBox(world, random, i - 4, j - 4, k - 6, 15, 4, 10);
            this.setBlocks(this.BlockID1, this.BlockID2, 20);
            this.setMetadata(this.meta1, this.meta2);
            world.setBlockAndMetadata(i, j, k, Block.lever.blockID, 5);
            world.setBlockAndMetadata(i, j - 1, k, Block.sand.blockID, 3);
            world.setBlockAndMetadata(i, j - 2, k, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadata(i + 1, j - 2, k, Block.glass.blockID, 0);
            world.setBlockAndMetadata(i - 1, j - 2, k, Block.cloth.blockID, 0);
            world.setBlockAndMetadata(i - 2, j - 2, k, Block.torchRedstoneActive.blockID, 2);
            world.setBlockAndMetadata(i - 2, j - 2, k - 1, Block.redstoneRepeaterIdle.blockID, 1);
            this.addLineZ(world, random, i - 3, j - 2, k - 1, 3);
            this.addLineZ(world, random, i - 2, j - 2, k + 1, 2);
            this.addLineZ(world, random, i - 1, j - 2, k - 5, 5);
            this.addLineX(world, random, i - 2, j - 2, k + 2, 5);
            this.addLineX(world, random, i - 1, j - 2, k - 5, 4);
            this.addLineX(world, random, i + 5, j - 2, k - 5, 4);
            this.addLineX(world, random, i + 5, j - 2, k + 2, 4);
            this.addLineZ(world, random, i + 8, j - 2, k - 5, 8);
            world.setBlockAndMetadata(i + 6, j - 2, k + 2, Block.redstoneRepeaterIdle.blockID, 1);
            world.setBlockAndMetadata(i, j - 2, k - 1, Block.redstoneRepeaterIdle.blockID, 13);
            world.setBlockAndMetadata(i, j - 2, k - 2, Block.redstoneRepeaterIdle.blockID, 13);
            world.setBlockAndMetadata(i + 7, j - 2, k - 1, Block.redstoneRepeaterIdle.blockID, 15);
            world.setBlockAndMetadata(i + 7, j - 2, k - 2, Block.redstoneRepeaterIdle.blockID, 15);
            world.setBlockAndMetadata(i + 6, j - 2, k - 2, Block.pistonStickyBase.blockID, 4);
            world.setBlockAndMetadata(i + 6, j - 2, k - 1, Block.pistonStickyBase.blockID, 4);
            world.setBlockAndMetadata(i + 6, j - 3, k - 2, Block.pistonStickyBase.blockID, 4);
            world.setBlockAndMetadata(i + 6, j - 3, k - 1, Block.pistonStickyBase.blockID, 4);
            world.setBlockAndMetadata(i + 1, j - 2, k - 2, Block.pistonStickyBase.blockID, 5);
            world.setBlockAndMetadata(i + 1, j - 2, k - 1, Block.pistonStickyBase.blockID, 5);
            world.setBlockAndMetadata(i + 1, j - 3, k - 2, Block.pistonStickyBase.blockID, 5);
            world.setBlockAndMetadata(i + 1, j - 3, k - 1, Block.pistonStickyBase.blockID, 5);
            world.setBlockAndMetadata(i + 2, j - 3, k - 2, Block.pistonStickyBase.blockID, 1);
            world.setBlockAndMetadata(i + 2, j - 3, k - 1, Block.pistonStickyBase.blockID, 1);
            world.setBlockAndMetadata(i + 5, j - 3, k - 2, Block.pistonStickyBase.blockID, 1);
            world.setBlockAndMetadata(i + 5, j - 3, k - 1, Block.pistonStickyBase.blockID, 1);
            world.setBlockAndMetadata(i + 3, j - 3, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 3, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 3, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 3, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 2, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 2, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 2, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 2, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 1, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 1, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 1, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 1, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 3, j, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 3, j, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 4, j, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 4, j, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 3, k + 1, Block.redstoneRepeaterIdle.blockID, 0);
            world.setBlockAndMetadata(i + 4, j - 3, k + 1, Block.redstoneRepeaterIdle.blockID, 0);
            world.setBlockAndMetadata(i + 3, j - 3, k + 2, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadata(i + 4, j - 3, k + 2, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadataWithNotify(i + 3, j - 2, k + 2, Block.glass.blockID, 0);
            world.setBlockAndMetadataWithNotify(i + 4, j - 2, k + 2, Block.glass.blockID, 0);
            world.setBlockAndMetadata(i + 3, j - 3, k - 4, Block.redstoneRepeaterIdle.blockID, 2);
            world.setBlockAndMetadata(i + 4, j - 3, k - 4, Block.redstoneRepeaterIdle.blockID, 2);
            world.setBlockAndMetadata(i + 3, j - 3, k - 5, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadata(i + 4, j - 3, k - 5, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadataWithNotify(i + 3, j - 2, k - 5, Block.glass.blockID, 0);
            world.setBlockAndMetadataWithNotify(i + 4, j - 2, k - 5, Block.glass.blockID, 0);
            world.setBlockAndMetadata(i, j, k, Block.lever.blockID, 5);
            world.setBlockAndMetadataWithNotify(i - 2, j - 2, k, Block.torchRedstoneActive.blockID, 2);
            if (trap == true) {
                this.setBlocks(0,0,0);
                this.addSolidBox(world, random, i + 3, j - 64, k - 2, 2, 60, 2);
            }
            if (trap == false) {
                this.setBlocks(Block.planks.blockID, Block.bookShelf.blockID, 10);
                this.addSolidBox(world, random, i + 3, j - 7, k, 2, 6, 1);
                this.addSolidBox(world, random, i + 3, j - 7, k - 3, 2, 6, 1);
                this.addSolidBox(world, random, i + 2, j - 7, k - 2, 1, 4, 2);
                this.addSolidBox(world, random, i + 5, j - 7, k - 2, 1, 4, 2);
                this.addHollowBox(world, random, i, j - 10, k - 3, 20, 5, 10);
                this.setBlocks(0,0,0);
                this.addSolidBox(world, random, i + 3, j - 10, k - 2, 2, 6, 2);
            }

        }
        return true;
    }
}

