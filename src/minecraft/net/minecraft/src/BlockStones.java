package net.minecraft.src;

import java.util.Random;

public class BlockStones extends Block {
	public static final String[] stonesnames = new String[]{"x", "two", "three", "four", "sone", "stwo", "sthree", "sfour"};

	public BlockStones(int i1) {
		super(i1, Material.rock);
		this.setLightOpacity(255);
	}
	public boolean canProvidePower() {
		return true;
	}



	public void onBlockAdded(World world1, int i, int j, int k) {
		world1.scheduleBlockUpdate(i, j, k, this.blockID, this.tickRate());
		world1.notifyBlocksOfNeighborChange(i, j - 1, k, this.blockID);
		world1.notifyBlocksOfNeighborChange(i, j + 1, k, this.blockID);
		world1.notifyBlocksOfNeighborChange(i - 1, j, k, this.blockID);
		world1.notifyBlocksOfNeighborChange(i + 1, j, k, this.blockID);
		world1.notifyBlocksOfNeighborChange(i, j, k - 1, this.blockID);
		world1.notifyBlocksOfNeighborChange(i, j, k + 1, this.blockID);
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
			return 181;
		}
		if (i2 == 1) {
			return this.blockIndexInTexture = mod_DumbStorage.redblocktex;
		}
		if (i2 == 2) {
			return this.blockIndexInTexture = mod_DumbStorage.nulltex;
		}
		if (i2 == 3) {
			return this.blockIndexInTexture = mod_DumbStorage.nulltex;
		}
		if (i2 == 4) {
			return this.blockIndexInTexture = mod_DumbStorage.stonetex1;
		}
		if (i2 == 5) {
			return this.blockIndexInTexture = mod_DumbStorage.stonetex2;
		}
		if (i2 == 6) {
			return this.blockIndexInTexture = mod_DumbStorage.stonetex3;
		}
		if (i2 == 7) {
			return this.blockIndexInTexture = mod_DumbStorage.stonetex4;
		}
		return this.blockIndexInTexture;

	}



	public int getBlockTextureFromSide(int i1) {
		return this.getBlockTextureFromSideAndMetadata(i1, 0);
	}


	public int idDropped(int i1, Random random2) {
		return DumbSBlocks.stones.blockID;
	}

	protected int damageDropped(int i1) {
		return i1;
	}

}
