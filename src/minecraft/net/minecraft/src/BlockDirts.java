package net.minecraft.src;

import java.util.Random;

public class BlockDirts extends Block {
	public static final String[] dirtsnames = new String[]{"solo", "duo", "trio", "quad", "clay1", "clay2", "clay3", "clay4"};

	public BlockDirts(int i1) {
		super(i1, 14, Material.ground);
		this.setLightOpacity(255);
	}


	public int getBlockTextureFromSideAndMetadata(int i1, int i2) {
		if(i2 == 0) {
			return this.blockIndexInTexture = mod_DumbStorage.dirttex1;
		}
		if (i2 == 1) {
			return this.blockIndexInTexture = mod_DumbStorage.dirttex2;
		}
		if (i2 == 2) {
			return this.blockIndexInTexture = mod_DumbStorage.dirttex3;
		}
		if (i2 == 3){
			return this.blockIndexInTexture = mod_DumbStorage.dirttex4;
		}
		if (i2 == 4) {
			return this.blockIndexInTexture = mod_DumbStorage.claytex1;
		}
		if (i2 == 5) {
			return this.blockIndexInTexture = mod_DumbStorage.claytex2;
		}
		if (i2 == 6) {
			return this.blockIndexInTexture = mod_DumbStorage.claytex3;
		}
		if (i2 == 7) {
			return this.blockIndexInTexture = mod_DumbStorage.claytex4;
		}
		return this.blockIndexInTexture;

	}

	public int getBlockTextureFromSide(int i1) {
		return this.getBlockTextureFromSideAndMetadata(i1, 0);
	}


	public int idDropped(int i1, Random random2) {
		return DumbSBlocks.dirts.blockID;
	}

	protected int damageDropped(int i1) {
		return i1;
	}

}
