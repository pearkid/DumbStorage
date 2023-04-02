package net.minecraft.src;

import java.util.Random;

public class BlockStones extends Block {
	public static final String[] stonesnames = new String[]{"x", "two", "three", "four", "sone", "stwo", "sthree", "sfour"};

	public BlockStones(int i1) {
		super(i1, 14, Material.rock);
		this.setLightOpacity(255);
	}


	public int getBlockTextureFromSideAndMetadata(int i1, int i2) {
		if (i2 == 0) {
			return 181;
		}
		if (i2 == 1) {
			return this.blockIndexInTexture = mod_DumbStorage.nulltex;
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
	public void onBlockAdded(World world1, int i2, int i3, int i4){
		int md = world1.getBlockMetadata(i2, i3, i4);
		if(md == 1) {
			world1.setBlockAndMetadataWithNotify(i2, i3, i4, pistonBase.blockID, 6);
		}
		if(md == 2) {
			world1.setBlockAndMetadataWithNotify(i2, i3, i4, pistonStickyBase.blockID, 6);
		}
		if(md == 3) {


			for (int  f = 0; f < 15; ++f) {
				world1.setBlockAndMetadata(i2, i3, i4 + (2 * f), 2, f);
			}

		}
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
