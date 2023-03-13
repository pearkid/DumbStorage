package net.minecraft.src;

import java.util.Random;


public class BlockMagnet extends Block {
	public static final String[] magnetnames = new String[]{"base", "X", "Y", "Z"};
	public static boolean fallInstantly = false;
	public static int dmg;
	private static int damage;
	public BlockMagnet(int i1) {
		super(i1, 14, Material.iron);
		this.setLightOpacity(255);
	}


	public int getBlockTextureFromSideAndMetadata(int i1, int i2) {
		return i2 == 0 ? mod_DumbStorage.magtex1 : i2 == 1 ? (i1 == 4 ? mod_DumbStorage.magtex4 : (i1 == 5 ? mod_DumbStorage.magtex3 : (i1 == 2 ? mod_DumbStorage.magtex5 : mod_DumbStorage.magtex6))) : i2 == 2 ? (i1 == 0 ? mod_DumbStorage.magtex4 : (i1 == 1 ? mod_DumbStorage.magtex3 : mod_DumbStorage.magtex2)) : (i1 == 2 ? mod_DumbStorage.magtex3 : (i1 == 3 ? mod_DumbStorage.magtex4 : i1 == 1 || i1 == 0 ? mod_DumbStorage.magtex2 : i1 == 5 ? mod_DumbStorage.magtex6 : mod_DumbStorage.magtex5));
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
	public void onBlockAdded(World world1, int i2, int i3, int i4) {
		world1.scheduleBlockUpdate(i2, i3, i4, this.blockID, this.tickRate());
	}

	public void onNeighborBlockChange(World world1, int i2, int i3, int i4, int i5) {
		world1.scheduleBlockUpdate(i2, i3, i4, this.blockID, this.tickRate());
	}

	public void updateTick(World world1, int i2, int i3, int i4, Random random5) {
		dmg = world1.getBlockMetadata(i2, i3, i4);
		if (dmg == 1) {
			boolean direction1 = true;
			boolean start = false;
			for(int x = -8; x < 0; ++x) {
				if (world1.getBlockId(i2 + x, i3, i4) == Block.blockSteel.blockID || world1.getBlockId(i2 - x, i3, i4) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2 + x, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 - x, i3, i4) != Block.blockSteel.blockID){
						direction1 = true;
					}
					if (world1.getBlockId(i2 - x, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 + x, i3, i4) != Block.blockSteel.blockID) {
						direction1 = false;
					}
				}
			}
			if (start == true) {
				if (direction1 == true) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 2);
				}
				if (direction1 == false) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 3);
				}
			}
		}
		if (dmg == 2) {
			boolean direction1 = true;
			boolean start = false;
			for(int y = -8; y < 0; ++y) {

				if (world1.getBlockId(i2, i3 - y, i4) == Block.blockSteel.blockID || world1.getBlockId(i2, i3 + y, i4) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2, i3 + y, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 - y, i4) != Block.blockSteel.blockID){
						direction1 = true;
					}
					if (world1.getBlockId(i2, i3 - y, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 + y, i4) != Block.blockSteel.blockID) {
						direction1 = false;
					}
				}


			}
			if (start == true) {
				if (direction1 == true) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 0);
				}
				if (direction1 == false) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 1);
				}
			}


		}
		if (dmg == 3) {
			boolean direction1 = true;
			boolean start = false;
			for(int x = -8; x < 0; ++x) {
				if (world1.getBlockId(i2, i3, i4 + x) == Block.blockSteel.blockID || world1.getBlockId(i2, i3, i4 - x) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2, i3, i4 + x) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 - x) != Block.blockSteel.blockID){
						direction1 = true;
					}
					if (world1.getBlockId(i2, i3, i4 - x) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 + x) != Block.blockSteel.blockID) {
						direction1 = false;
					}
				}
			}
			if (start == true) {
				if (direction1 == true) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 4);
				}
				if (direction1 == false) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 5);
				}
			}
		}
		if(dmg == 0) {
			byte direction = 0;
			boolean start = false;
			for(int p = -8; p < 0; ++p) {
				if(world1.getBlockId(i2, i3, i4 + p) == Block.blockSteel.blockID || world1.getBlockId(i2, i3, i4 - p) == Block.blockSteel.blockID || world1.getBlockId(i2, i3 - p, i4) == Block.blockSteel.blockID || world1.getBlockId(i2, i3 + p, i4) == Block.blockSteel.blockID || world1.getBlockId(i2 - p, i3, i4) == Block.blockSteel.blockID || world1.getBlockId(i2 + p, i3, i4) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2, i3 + p, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 - p, i4) != Block.blockSteel.blockID){
						direction = 0;
					}
					if (world1.getBlockId(i2, i3 - p, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 + p, i4) != Block.blockSteel.blockID) {
						direction = 1;
					}
					if (world1.getBlockId(i2 + p, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 - p, i3, i4) != Block.blockSteel.blockID){
						direction = 2;
					}
					if (world1.getBlockId(i2 - p, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 + p, i3, i4) != Block.blockSteel.blockID) {
						direction = 3;
					}
					if (world1.getBlockId(i2, i3, i4 + p) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 - p) != Block.blockSteel.blockID){
						direction = 4;
					}
					if (world1.getBlockId(i2, i3, i4 - p) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 + p) != Block.blockSteel.blockID) {
						direction = 5;
					}
				}
			}
			if (start == true) {
				if (direction == 0) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 0);
				}
				if (direction == 1) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 1);
				}
				if (direction == 2) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 2);
				}
				if (direction == 3) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 3);
				}
				if (direction == 4) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 4);
				}
				if (direction == 5) {
					this.tryToSlide(world1, i2, i3, i4, dmg, (byte) 5);
				}
			}
		}

	}
	private boolean tryToSlide(World world1, int i2, int i3, int i4, int damage, byte direction) {
		if(canFallBelow(world1, i2, i3 - 1, i4) && i3 >= 0 && direction == 0) {
			byte b8 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - b8, i3 - b8, i4 - b8, i2 + b8, i3 + b8, i4 + b8)) {
				EntityFallingSand2 entityFallingSand9 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), this.blockID, damage, direction);
				world1.entityJoinedWorld(entityFallingSand9);
				return true;
			} else {
				world1.setBlockAndMetadataWithNotify(i2, i3, i4, 0, 0);

				while(canFallBelow(world1, i2, i3 - 1, i4) && i3 > 0) {
					--i3;
				}

				if(i3 > 0) {
					world1.setBlockAndMetadataWithNotify(i2, i3, i4, this.blockID, dmg);
				}
			}
		}
		if(canFallAbove(world1, i2, i3 + 1, i4) && i3 < 128 && direction == 1) {
			byte byte0 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - byte0, i3 - byte0, i4 - byte0, i2 + byte0, i3 + byte0, i4 + byte0)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), this.blockID, damage, direction);
				world1.entityJoinedWorld(floating);
				return true;
			} else {
				world1.setBlockWithNotify(i2, i3, i4, 0);

				while(canFallAbove(world1, i2, i3 + 1, i4) && i3 < 128) {
					++i3;
				}

				if(i3 > 0) {
					world1.setBlockWithNotify(i2, i3, i4, this.blockID);
				}
			}
		}
		if(canFallAbove(world1, i2 - 1, i3, i4) && i3 < 128 && direction == 2) {
			byte byte0 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - byte0, i3 - byte0, i4 - byte0, i2 + byte0, i3 + byte0, i4 + byte0)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), this.blockID, damage, direction);
				world1.entityJoinedWorld(floating);
				return true;
			} else {
				world1.setBlockWithNotify(i2, i3, i4, 0);

				while(canFallAbove(world1, i2 - 1, i3, i4) && i3 < 128) {
					--i2;
				}

				if(i3 > 0) {
					world1.setBlockWithNotify(i2, i3, i4, this.blockID);
				}
			}
		}
		if(canFallAbove(world1, i2 + 1, i3, i4) && i3 < 128 && direction == 3) {
			byte byte0 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - byte0, i3 - byte0, i4 - byte0, i2 + byte0, i3 + byte0, i4 + byte0)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), this.blockID, damage, direction);
				world1.entityJoinedWorld(floating);
				return true;
			} else {
				world1.setBlockWithNotify(i2, i3, i4, 0);

				while(canFallAbove(world1, i2 + 1, i3, i4) && i3 < 128) {
					++i2;
				}

				if(i3 > 0) {
					world1.setBlockWithNotify(i2, i3, i4, this.blockID);
				}
			}
		}
		if(canFallAbove(world1, i2, i3, i4 - 1) && i3 < 128 && direction == 4) {
			byte byte0 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - byte0, i3 - byte0, i4 - byte0, i2 + byte0, i3 + byte0, i4 + byte0)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), this.blockID, damage, direction);
				world1.entityJoinedWorld(floating);
				return true;
			} else {
				world1.setBlockWithNotify(i2, i3, i4, 0);

				while(canFallAbove(world1, i2, i3, i4 - 1) && i3 < 128) {
					--i2;
				}

				if(i3 > 0) {
					world1.setBlockWithNotify(i2, i3, i4, this.blockID);
				}
			}
		}
		if(canFallAbove(world1, i2, i3, i4 + 1) && i3 < 128 && direction == 5) {
			byte byte0 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - byte0, i3 - byte0, i4 - byte0, i2 + byte0, i3 + byte0, i4 + byte0)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), this.blockID, damage, direction);
				world1.entityJoinedWorld(floating);
				return true;
			} else {
				world1.setBlockWithNotify(i2, i3, i4, 0);

				while(canFallAbove(world1, i2, i3, i4 + 1) && i3 < 128) {
					++i2;
				}

				if(i3 > 0) {
					world1.setBlockWithNotify(i2, i3, i4, this.blockID);
				}
			}
		}
		return false;
	}

	public int tickRate() {
		return 3;
	}

	public static boolean canFallBelow(World world0, int i1, int i2, int i3) {
		int i4 = world0.getBlockId(i1, i2, i3);
		if(i4 == 0) {
			return true;
		} else if(i4 == Block.fire.blockID) {
			return true;
		} else {
			Material material5 = Block.blocksList[i4].blockMaterial;
			return material5 == Material.water ? true : material5 == Material.lava;
		}
	}
	public static boolean canFallAbove(World world, int i, int j, int k) {
		int l = world.getBlockId(i, j, k);
		if(l == 0) {
			return true;
		} else if(l == Block.fire.blockID) {
			return true;
		} else {
			Material material = Block.blocksList[l].blockMaterial;
			return material == Material.water ? true : material == Material.lava;
		}
	}
}
