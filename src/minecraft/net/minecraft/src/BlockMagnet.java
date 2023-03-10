package net.minecraft.src;

import java.util.Random;


public class BlockMagnet extends Block {
	public static final String[] magnetnames = new String[]{"base", "X", "Y", "Z"};
	public BlockMagnet(int i1) {
		super(i1, 14, Material.iron);
		this.setLightOpacity(255);
	}


	public int getBlockTextureFromSideAndMetadata(int i1, int i2) {
		return i2 == 0 ? mod_DumbStorage.magtex1 : i2 == 1 ? (i1 == 4 ? mod_DumbStorage.magtex4 : (i1 == 5 ? mod_DumbStorage.magtex3 : (i1 == 2 ? mod_DumbStorage.magtex5 : mod_DumbStorage.magtex6))) : i2 == 2 ? (i1 == 0 ? mod_DumbStorage.magtex4 : (i1 == 1 ? mod_DumbStorage.magtex3 : mod_DumbStorage.magtex2)) : (i1 == 2 ? mod_DumbStorage.magtex3 : (i1 == 3 ? mod_DumbStorage.magtex4 : i1 == 1 || i1 == 0 ? mod_DumbStorage.magtex2 : mod_DumbStorage.magtex6));
	}

	public int getBlockTextureFromSide(int i1) {
		return this.getBlockTextureFromSideAndMetadata(i1, 0);
	}


	public int idDropped(int i1, Random random2) {
		return DumbSBlocks.magnet.blockID;
	}

	protected int damageDropped(int i1) {
		return i1;
	}

}
