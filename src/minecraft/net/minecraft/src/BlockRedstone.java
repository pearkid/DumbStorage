package net.minecraft.src;

import java.util.Random;

public class BlockRedstone extends Block {
    public static final String[] redstonenames = new String[]{"power"};

    public BlockRedstone(int i1) {
        super(i1, DSMaterials.power);
    }


    public boolean canProvidePower() {
        return true;
    }

    public boolean isPoweringTo(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return true;
    }

    public boolean isIndirectlyPoweringTo(World world, int i, int j, int k, int l) {
        return this.isPoweringTo(world, i, j, k, l);
    }

    public void onBlockAdded(World world1, int i, int j, int k) {
        world1.scheduleBlockUpdate(i, j, k, this.blockID, this.tickRate());
        world1.notifyBlocksOfNeighborChange(i, j - 1, k, this.blockID);
        world1.notifyBlocksOfNeighborChange(i, j + 1, k, this.blockID);
        world1.notifyBlocksOfNeighborChange(i - 1, j, k, this.blockID);
        world1.notifyBlocksOfNeighborChange(i + 1, j, k, this.blockID);
        world1.notifyBlocksOfNeighborChange(i, j, k - 1, this.blockID);
        world1.notifyBlocksOfNeighborChange(i, j, k + 1, this.blockID);
        //world1.isBlockNormalCube(i, j, k);
    }

    public void onBlockRemoval(World world1, int i, int j, int k) {
        world1.scheduleBlockUpdate(i, j, k, this.blockID, this.tickRate());
        world1.notifyBlocksOfNeighborChange(i, j - 1, k, this.blockID);
        world1.notifyBlocksOfNeighborChange(i, j + 1, k, this.blockID);
        world1.notifyBlocksOfNeighborChange(i - 1, j, k, this.blockID);
        world1.notifyBlocksOfNeighborChange(i + 1, j, k, this.blockID);
        world1.notifyBlocksOfNeighborChange(i, j, k - 1, this.blockID);
        world1.notifyBlocksOfNeighborChange(i, j, k + 1, this.blockID);
    }

    public int getBlockTextureFromSideAndMetadata(int i1, int i2) {
        if (i2 == 0) {
            return this.blockIndexInTexture = mod_DumbStorage.redblocktex;
        }
        return this.blockIndexInTexture;

    }



    public int getBlockTextureFromSide(int i1) {
        return this.getBlockTextureFromSideAndMetadata(i1, 0);
    }


    public int idDropped(int i1, Random random2) {
        return DumbSBlocks.redstone.blockID;
    }

    protected int damageDropped(int i1) {
        return i1;
    }

}
