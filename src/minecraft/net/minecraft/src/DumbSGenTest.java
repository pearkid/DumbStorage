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
    private int size;
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
        this.size = p;
        this.flat = flag;
        this.finished = false;
    }

    public boolean generate(World world, Random random, int i, int j, int k) {
        this.replaceAir = true;
        this.replaceSolid = true;
        this.n = 0;

        if (world.isAirBlock(i, j, k) && ((BlockDeadBush) Block.blocksList[32]).canBlockStay(world, i, j, k) && !world.isAirBlock(i + 5 * (size), j, k + 8 * (size))) {
            this.setBlocks(this.lockedBlockID1, this.lockedBlockID2, 20);
            this.addSolidBox(world, random, i + 1 * (size), j, k, 4 * (size), 1 * (size), 5 * (size));
            this.addSolidBox(world, random, i + 1 * (size), j + 1 * (size), k, 5 * (size), 1 * (size), 5 * (size));
            this.addSolidBox(world, random, i + 2 * (size), j + 2 * (size), k, 4 * (size), 2 * (size), 5 * (size));
            this.addSolidBox(world, random, i + 3 * (size), j + 4 * (size), k, 4 * (size), 2 * (size), 5 * (size));
            this.addSolidBox(world, random, i + 3 * (size), j + 6 * (size), k, 5 * (size), 2 * (size), 5 * (size));
            this.addSolidBox(world, random, i, j, k + 1 * (size), 1 * (size), 1 * (size), 3 * (size));
            this.addSolidBox(world, random, i + 2 * (size), j + 7 * (size), k + 1 * (size), 1 * (size), 1 * (size), 3 * (size));
            this.addSolidBox(world, random, i + 3 * (size), j + 8 * (size), k + 1 * (size), 5 * (size), 1 * (size), 3 * (size));
            this.addSolidBox(world, random, i + 4 * (size), j + 8 * (size), k, 3 * (size), 1 * (size), 5 * (size));
            this.addSolidBox(world, random, i + 5 * (size), j, k + 1 * (size), 1 * (size), 1 * (size), 3 * (size));
            this.addSolidBox(world, random, i + 6 * (size), j + 1 * (size), k + 1 * (size), 1 * (size), 3 * (size), 3 * (size));
            this.addSolidBox(world, random, i + 7 * (size), j + 4 * (size), k + 1 * (size), 1 * (size), 2 * (size), 3 * (size));
            this.addSolidBox(world, random,i + 1 * (size), j + 2 * (size), k, 1 * (size), 1 * (size), 1 * (size));
            this.addSolidBox(world, random,i, j + 3 * (size), k + 2 * (size), 1 * (size), 1 * (size), 1 * (size));
            this.addSolidBox(world, random,i + 1 * (size), j + 2 * (size), k + 4 * (size), 1 * (size), 1 * (size), 1 * (size));
            this.addSolidBox(world, random, i + 1 * (size), j + 3 * (size), k + 1 * (size), 1 * (size), 1 * (size), 3 * (size));
            this.addSolidBox(world, random, i + 1 * (size), j + 4 * (size), k + 2 * (size), 2 * (size), 2 * (size), 1 * (size));
            this.addSolidBox(world, random, i + 2 * (size), j + 4 * (size), k, 1 * (size), 1 * (size), 5 * (size));
            this.addSolidBox(world, random, i + 2 * (size), j + 6 * (size), k, 1 * (size), 1 * (size), 5 * (size));

        }
        return true;
    }
}

