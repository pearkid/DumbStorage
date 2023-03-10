package net.minecraft.src;

import java.util.Random;

import static java.lang.Math.abs;

public class DumbSGenMoai extends DumbSGenStructures {
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

    public DumbSGenMoai(int i, int j, int k, int l, int p, boolean flag) {
        this.BlockID1 = i;
        this.BlockID2 = j;
        this.meta1 = k;
        this.meta2 = l;
        this.size = p;
        this.size2 = abs(p);
        this.flat = flag;
        this.finished = false;
    }

    public boolean generate(World world, Random random, int i, int j, int k) {
        this.replaceAir = true;
        this.replaceSolid = true;
        this.n = 0;


        if (size == 1 || size == 2 || size == 3 || size == 4) {
            if (world.isAirBlock(i, j, k) && ((BlockDeadBush) Block.blocksList[32]).canBlockStay(world, i, j, k) && !world.isAirBlock(i + 5 * (size2), j, k + 8 * (size2))) {
                this.setBlocks(this.BlockID1, this.BlockID2, 20);
                this.setMetadata(this.meta1, this.meta2);
                this.addSolidBox(world, random, i + 1 * (size2), j, k, 4 * (size2), 1 * (size2), 5 * (size2));
                this.addSolidBox(world, random, i + 1 * (size2), j + 1 * (size2), k, 5 * (size2), 1 * (size2), 5 * (size2));
                this.addSolidBox(world, random, i + 2 * (size2), j + 2 * (size2), k, 4 * (size2), 2 * (size2), 5 * (size2));
                this.addSolidBox(world, random, i + 3 * (size2), j + 4 * (size2), k, 4 * (size2), 2 * (size2), 5 * (size2));
                this.addSolidBox(world, random, i + 3 * (size2), j + 6 * (size2), k, 5 * (size2), 2 * (size2), 5 * (size2));
                this.addSolidBox(world, random, i, j, k + 1 * (size2), 1 * (size2), 1 * (size2), 3 * (size2));
                this.addSolidBox(world, random, i + 2 * (size2), j + 7 * (size2), k + 1 * (size2), 1 * (size2), 1 * (size2), 3 * (size2));
                this.addSolidBox(world, random, i + 3 * (size2), j + 8 * (size2), k + 1 * (size2), 5 * (size2), 1 * (size2), 3 * (size2));
                this.addSolidBox(world, random, i + 4 * (size2), j + 8 * (size2), k, 3 * (size2), 1 * (size2), 5 * (size2));
                this.addSolidBox(world, random, i + 5 * (size2), j, k + 1 * (size2), 1 * (size2), 1 * (size2), 3 * (size2));
                this.addSolidBox(world, random, i + 6 * (size2), j + 1 * (size2), k + 1 * (size2), 1 * (size2), 3 * (size2), 3 * (size2));
                this.addSolidBox(world, random, i + 7 * (size2), j + 4 * (size2), k + 1 * (size2), 1 * (size2), 2 * (size2), 3 * (size2));
                this.addSolidBox(world, random,i + 1 * (size2), j + 2 * (size2), k, 1 * (size2), 1 * (size2), 1 * (size2));
                this.addSolidBox(world, random,i, j + 3 * (size2), k + 2 * (size2), 1 * (size2), 1 * (size2), 1 * (size2));
                this.addSolidBox(world, random,i + 1 * (size2), j + 2 * (size2), k + 4 * (size2), 1 * (size2), 1 * (size2), 1 * (size2));
                this.addSolidBox(world, random, i + 1 * (size2), j + 3 * (size2), k + 1 * (size2), 1 * (size2), 1 * (size2), 3 * (size2));
                this.addSolidBox(world, random, i + 1 * (size2), j + 4 * (size2), k + 2 * (size2), 2 * (size2), 2 * (size2), 1 * (size2));
                this.addSolidBox(world, random, i + 2 * (size2), j + 4 * (size2), k, 1 * (size2), 1 * (size2), 5 * (size2));
                this.addSolidBox(world, random, i + 2 * (size2), j + 6 * (size2), k, 1 * (size2), 1 * (size2), 5 * (size2));
                }

            }
        if (size == -1 || size == -2 || size == -3 || size == -4) {
            if (world.isAirBlock(i, j, k) && ((BlockDeadBush) Block.blocksList[32]).canBlockStay(world, i, j, k) && !world.isAirBlock(i - 5 * (size2), j, k - 8 * (size2))) {
                this.setBlocks(this.BlockID1, this.BlockID2, 20);
                this.setMetadata(this.meta1, this.meta2);
                this.addSolidBoxnegx(world, random, i - 1 * (size2), j, k, -4 * (size2), 1 * (size2), 5 * (size2));
                this.addSolidBoxnegx(world, random, i - 1 * (size2), j + 1 * (size2), k, -5 * (size2), 1 * (size2), 5 * (size2));
                this.addSolidBoxnegx(world, random, i - 2 * (size2), j + 2 * (size2), k, -4 * (size2), 2 * (size2), 5 * (size2));
                this.addSolidBoxnegx(world, random, i - 3 * (size2), j + 4 * (size2), k, -4 * (size2), 2 * (size2), 5 * (size2));
                this.addSolidBoxnegx(world, random, i - 3 * (size2), j + 6 * (size2), k, -5 * (size2), 2 * (size2), 5 * (size2));
                this.addSolidBoxnegx(world, random, i, j, k + 1 * (size2), -1 * (size2), 1 * (size2), 3 * (size2));
                this.addSolidBoxnegx(world, random, i - 2 * (size2), j + 7 * (size2), k + 1 * (size2), -1 * (size2), 1 * (size2), 3 * (size2));
                this.addSolidBoxnegx(world, random, i - 3 * (size2), j + 8 * (size2), k + 1 * (size2), -5 * (size2), 1 * (size2), 3 * (size2));
                this.addSolidBoxnegx(world, random, i - 4 * (size2), j + 8 * (size2), k, -3 * (size2), 1 * (size2), 5 * (size2));
                this.addSolidBoxnegx(world, random, i - 5 * (size2), j, k + 1 * (size2), -1 * (size2), 1 * (size2), 3 * (size2));
                this.addSolidBoxnegx(world, random, i - 6 * (size2), j + 1 * (size2), k + 1 * (size2), -1 * (size2), 3 * (size2), 3 * (size2));
                this.addSolidBoxnegx(world, random, i - 7 * (size2), j + 4 * (size2), k + 1 * (size2), -1 * (size2), 2 * (size2), 3 * (size2));
                this.addSolidBoxnegx(world, random,i - 1 * (size2), j + 2 * (size2), k, -1 * (size2), 1 * (size2), 1 * (size2));
                this.addSolidBoxnegx(world, random,i, j + 3 * (size2), k + 2 * (size2), -1 * (size2), 1 * (size2), 1 * (size2));
                this.addSolidBoxnegx(world, random,i - 1 * (size2), j + 2 * (size2), k + 4 * (size2), -1 * (size2), 1 * (size2), 1 * (size2));
                this.addSolidBoxnegx(world, random, i - 1 * (size2), j + 3 * (size2), k + 1 * (size2), -1 * (size2), 1 * (size2), 3 * (size2));
                this.addSolidBoxnegx(world, random, i - 1 * (size2), j + 4 * (size2), k + 2 * (size2), -2 * (size2), 2 * (size2), 1 * (size2));
                this.addSolidBoxnegx(world, random, i - 2 * (size2), j + 4 * (size2), k, -1 * (size2), 1 * (size2), 5 * (size2));
                this.addSolidBoxnegx(world, random, i - 2 * (size2), j + 6 * (size2), k, -1 * (size2), 1 * (size2), 5 * (size2));
            }

        }
        return true;
    }
}

