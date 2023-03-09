package net.minecraft.src;

import java.util.Random;

public class DumbSGenTest extends DumbSGenStructures {
    private int corridorMeta1;
    private int corridorMeta2;
    private int lockedBlockID1;
    private int lockedBlockID2;
    private int wallBlockID1;
    private int wallBlockID2;
    private int corridorBlockID1;
    private int corridorBlockID2;
    private int numRooms;
    private int n;
    private boolean finished;
    private boolean flat;

    public DumbSGenTest(int i, int j, int k, int l, int m, int m1, int o, int o1, int p, boolean flag) {
        this.lockedBlockID1 = i;
        this.lockedBlockID2 = j;
        this.wallBlockID1 = k;
        this.wallBlockID2 = l;
        this.corridorBlockID1 = m;
        this.corridorMeta1 = m1;
        this.corridorBlockID2 = o;
        this.corridorMeta2 = o1;
        this.numRooms = p;
        this.flat = flag;
        this.finished = false;
    }

    public boolean generate(World world, Random random, int i, int j, int k) {
        this.replaceAir = true;
        this.replaceSolid = true;
        this.n = 0;

        if (world.isAirBlock(i, j, k) && ((BlockDeadBush) Block.blocksList[32]).canBlockStay(world, i, j, k) && !world.isAirBlock(i + 5, j, k + 8)) {
            this.setBlocks(this.lockedBlockID1, this.lockedBlockID2, 20);
            this.addSolidBox(world, random, i + 1, j, k, 4, 1, 5);
            this.addSolidBox(world, random, i + 1, j + 1, k, 5, 1, 5);
            this.addSolidBox(world, random, i + 2, j + 2, k, 4, 2, 5);
            this.addSolidBox(world, random, i + 3, j + 4, k, 4, 2, 5);
            this.addSolidBox(world, random, i + 3, j + 6, k, 5, 2, 5);
            this.addSolidBox(world, random, i, j, k + 1, 1, 1, 3);
            this.addSolidBox(world, random, i + 2, j + 7, k + 1, 1, 1, 3);
            this.addSolidBox(world, random, i + 3, j + 8, k + 1, 5, 1, 3);
            this.addSolidBox(world, random, i + 4, j + 8, k, 3, 1, 5);
            this.addSolidBox(world, random, i + 5, j, k + 1, 1, 1, 3);
            this.addSolidBox(world, random, i + 6, j + 1, k + 1, 1, 3, 3);
            this.addSolidBox(world, random, i + 7, j + 4, k + 1, 1, 2, 3);
            world.setBlockAndMetadata(i + 1, j + 2, k, this.lockedBlockID1, 1);
            world.setBlockAndMetadata(i, j + 3, k + 2, this.lockedBlockID1, 1);
            world.setBlockAndMetadata(i + 1, j + 2, k + 4, this.lockedBlockID1, 1);
            this.addSolidBox(world, random, i + 1, j + 3, k + 1, 1, 1, 3);
            this.addSolidBox(world, random, i + 1, j + 4, k + 2, 2, 2, 1);
            this.addSolidBox(world, random, i + 2, j + 4, k, 1, 1, 5);
            this.addSolidBox(world, random, i + 2, j + 6, k, 1, 1, 5);

        }
        return true;
    }
}

