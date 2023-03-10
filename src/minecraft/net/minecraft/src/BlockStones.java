package net.minecraft.src;

import java.util.Random;

public class BlockStones extends Block {
	public static final String[] stonesnames = new String[]{"one", "two", "three", "four", "x"};

	public BlockStones(int i1) {
		super(i1, 14, Material.rock);
		this.setLightOpacity(255);
	}


	public int getBlockTextureFromSideAndMetadata(int i1, int i2) {
		if(i2 == 0) {
			return this.blockIndexInTexture = mod_DumbStorage.stonetex1;
		}
		if (i2 == 1) {
			return this.blockIndexInTexture = mod_DumbStorage.stonetex2;
		}
		if (i2 == 2) {
			return this.blockIndexInTexture = mod_DumbStorage.stonetex3;
		}
		if (i2 == 3) {
			return this.blockIndexInTexture = mod_DumbStorage.stonetex4;
		}
		if (i2 == 4) {
			return 181;
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
