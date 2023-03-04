package net.minecraft.src;

import java.util.Random;

import static net.minecraft.src.mod_DumbStorage.texture0;

public class BlockDirts extends Block {
	public static final String[] dirtsnames = new String[]{"solo", "duo", "trio", "quad"};

	public BlockDirts(int i1) {
		super(i1, 14, Material.ground);
		this.setLightOpacity(255);
	}


	public int getBlockTextureFromSideAndMetadata(int i1, int i2) {
		if(i2 == 0) {
			return this.blockIndexInTexture = mod_DumbStorage.texture1;
		}
		if (i2 == 1) {
			return this.blockIndexInTexture = mod_DumbStorage.texture2;
		}
		if (i2 == 2) {
			return this.blockIndexInTexture = mod_DumbStorage.texture4;
		}
		if (i2 == 3){
			return this.blockIndexInTexture = mod_DumbStorage.texture5;
		}
		return this.blockIndexInTexture;

	}

	public int getBlockTextureFromSide(int i1) {
		return this.getBlockTextureFromSideAndMetadata(i1, 0);
	}


	public int idDropped(int i1, Random random2) {
		return mod_DumbStorage.dirts.blockID;
	}

	protected int damageDropped(int i1) {
		return i1;
	}

}
