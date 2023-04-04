package net.minecraft.src;

import java.util.Arrays;
import java.util.Random;


public class BlockMagnet extends Block {
	public static final String[] magnetnames = new String[]{"base", "X", "Y", "Z", "mbase", "mX", "mY", "mZ"};
	public static boolean fallInstantly = false;
	public static int dmg;
	private static int damage;
	public int bid1;
	public int bid2;
	public int bid3;
	public int bid4;
	public int bid5;
	public int bid6;
	public int bid7;
	public int bid8;
	public byte bmd1;
	public byte bmd2;
	public byte bmd3;
	public byte bmd4;
	public byte bmd5;
	public byte bmd6;
	public byte bmd7;
	public boolean bs1;
	public boolean bs2;
	public boolean bs3;
	public boolean bs4;
	public boolean bs5;
	public boolean bs6;
	public boolean bs7;

	public int [] oBs = {0, Block.bedrock.blockID, Block.dispenser.blockID, Block.pistonMoving.blockID, Block.blockSteel.blockID, Block.obsidian.blockID, Block.mobSpawner.blockID, Block.stoneOvenIdle.blockID, Block.stoneOvenActive.blockID};
	public int [] vOL = {Block.blockBed.blockID};
	public int [] hOL = {Block.doorWood.blockID, Block.doorSteel.blockID};

	public BlockMagnet(int i1) {
		super(i1, 14, Material.iron);
		this.setLightOpacity(255);
	}


	public int getBlockTextureFromSideAndMetadata(int i1, int i2) {
		return i2 == 0 ? mod_DumbStorage.magtex1 : i2 == 1 ? (i1 == 4 ? mod_DumbStorage.magtex4 : (i1 == 5 ? mod_DumbStorage.magtex3 : (i1 == 2 ? mod_DumbStorage.magtex5 : mod_DumbStorage.magtex6))) : i2 == 2 ? (i1 == 0 ? mod_DumbStorage.magtex4 : (i1 == 1 ? mod_DumbStorage.magtex3 : mod_DumbStorage.magtex2)) : i2 == 3 ? (i1 == 2 ? mod_DumbStorage.magtex3 : (i1 == 3 ? mod_DumbStorage.magtex4 : i1 == 1 || i1 == 0 ? mod_DumbStorage.magtex2 : i1 == 5 ? mod_DumbStorage.magtex6 : mod_DumbStorage.magtex5)) : i2 == 4 ? mod_DumbStorage.monmagtex1 : i2 == 5 ? (i1 == 4 ? mod_DumbStorage.monmagtex4 : (i1 == 5 ? mod_DumbStorage.monmagtex3 : (i1 == 2 ? mod_DumbStorage.monmagtex5 : mod_DumbStorage.monmagtex6))) : i2 == 6 ? (i1 == 0 ? mod_DumbStorage.monmagtex4 : (i1 == 1 ? mod_DumbStorage.monmagtex3 : mod_DumbStorage.monmagtex2)) : (i1 == 2 ? mod_DumbStorage.monmagtex3 : (i1 == 3 ? mod_DumbStorage.monmagtex4 : i1 == 1 || i1 == 0 ? mod_DumbStorage.monmagtex2 : i1 == 5 ? mod_DumbStorage.monmagtex6 : mod_DumbStorage.monmagtex5));
	}

	public int getBlockTextureFromSide(int i1) {
		return this.getBlockTextureFromSideAndMetadata(i1, 0);
	}


	public int idDropped(int i1, Random random2) {
		return DumbSBlocks.magnet.blockID;
	}

	protected int damageDropped(int i1) {
		if (i1 == 0) {
			return i1;
		}
		if (i1 == 1 || i1 == 2 || i1 == 3) {
			return 2;
		}
		if (i1 == 5 || i1 == 6 || i1 == 7) {
			return 6;
		}
		return i1;
	}

	public void onBlockPlacedBy(World world1, int i2, int i3, int i4, EntityLiving entityLiving5) {
		byte md = (byte) world1.getBlockMetadata(i2, i3, i4);
		if (md == 0) {
			world1.setBlockMetadataWithNotify(i2, i3, i4, 0);
		}
		if (md == 1 || md == 2 || md == 3) {
			if (world1.getBlockMetadata(i2, i3, i4) == 2) {
				int pmd = getPlayerDirection(i2, i3, i4, 0, (EntityPlayer) entityLiving5);
				world1.setBlockMetadataWithNotify(i2, i3, i4, pmd);
			}
		}
		if (md == 5 || md == 6 || md == 7) {
			if (world1.getBlockMetadata(i2, i3, i4) == 6) {
				int pmd = getPlayerDirection(i2, i3, i4, 1, (EntityPlayer) entityLiving5);
				world1.setBlockMetadataWithNotify(i2, i3, i4, pmd);
			}
		}
	}

	private static int getPlayerDirection(int i1, int i2, int i3, int type, EntityPlayer entityPlayer4) {
		if (MathHelper.abs((float) entityPlayer4.posX - (float) i1) < 2.0F && MathHelper.abs((float) entityPlayer4.posZ - (float) i3) < 2.0F) {
			double d5 = entityPlayer4.posY + 1.82D - (double) entityPlayer4.yOffset;
			if (d5 - (double) i2 > 2.0D) {
				return type == 0 ? 2 : 6;
			}

			if ((double) i2 - d5 > 0.0D) {
				return type == 0 ? 2 : 6;
			}
		}

		int i7 = MathHelper.floor_double((double) (entityPlayer4.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if (type == 0) {
			return i7 == 0 ? 3 : (i7 == 1 ? 1 : (i7 == 2 ? 3 : (i7 == 3 ? 1 : 2)));
		}
		return i7 == 0 ? 7 : (i7 == 1 ? 5 : (i7 == 2 ? 7 : (i7 == 3 ? 5 : 6)));
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
			for (int x = -8; x < 0; ++x) {
				if (world1.getBlockId(i2 + x, i3, i4) == Block.blockSteel.blockID || world1.getBlockId(i2 - x, i3, i4) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2 + x, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 - x, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 + x, i3, i4) != true || world1.getBlockId(i2 - x, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 + x, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 - x, i3, i4) == true) {
						direction1 = true;
					}
					if (world1.getBlockId(i2 - x, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 + x, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 - x, i3, i4) != true || world1.getBlockId(i2 + x, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 - x, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 + x, i3, i4) == true) {
						direction1 = false;
					}
				}
			}
			if (start == true) {
				if (direction1 == true) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 2);
				}
				if (direction1 == false) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 3);
				}
			}
		}
		if (dmg == 2) {
			boolean direction1 = true;
			boolean start = false;
			for (int y = -8; y < 0; ++y) {

				if (world1.getBlockId(i2, i3 - y, i4) == Block.blockSteel.blockID || world1.getBlockId(i2, i3 + y, i4) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2, i3 + y, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 - y, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 + y, i4) != true || world1.getBlockId(i2, i3 - y, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 + y, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 - y, i4) == true) {
						direction1 = true;
					}
					if (world1.getBlockId(i2, i3 - y, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 + y, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 - y, i4) != true || world1.getBlockId(i2, i3 + y, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 - y, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 + y, i4) == true) {
						direction1 = false;
					}
				}


			}
			if (start == true) {
				if (direction1 == true) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 0);
				}
				if (direction1 == false) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 1);
				}
			}


		}
		if (dmg == 3) {
			boolean direction1 = true;
			boolean start = false;
			for (int x = -8; x < 0; ++x) {
				if (world1.getBlockId(i2, i3, i4 + x) == Block.blockSteel.blockID || world1.getBlockId(i2, i3, i4 - x) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2, i3, i4 + x) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 - x) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 + x) != true || world1.getBlockId(i2, i3, i4 - x) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 + x) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 - x) == true) {
						direction1 = true;
					}
					if (world1.getBlockId(i2, i3, i4 - x) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 + x) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 - x) != true || world1.getBlockId(i2, i3, i4 + x) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 - x) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 + x) == true) {
						direction1 = false;
					}
				}
			}
			if (start == true) {
				if (direction1 == true) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 4);
				}
				if (direction1 == false) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 5);
				}
			}
		}
		if (dmg == 0) {
			byte direction = 7;
			boolean start = false;
			for (int p = -8; p < 0; ++p) {
				if (world1.getBlockId(i2, i3, i4 + p) == Block.blockSteel.blockID || world1.getBlockId(i2, i3, i4 - p) == Block.blockSteel.blockID || world1.getBlockId(i2, i3 - p, i4) == Block.blockSteel.blockID || world1.getBlockId(i2, i3 + p, i4) == Block.blockSteel.blockID || world1.getBlockId(i2 - p, i3, i4) == Block.blockSteel.blockID || world1.getBlockId(i2 + p, i3, i4) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2, i3 + p, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 - p, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 + p, i4) != true || world1.getBlockId(i2, i3 - p, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 + p, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 - p, i4) == true) {
						direction = 0;
					}
					if (world1.getBlockId(i2, i3 - p, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 + p, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 - p, i4) != true || world1.getBlockId(i2, i3 + p, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 - p, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 + p, i4) == true) {
						direction = 1;
					}
					if (world1.getBlockId(i2 + p, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 - p, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 + p, i3, i4) != true || world1.getBlockId(i2 - p, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 + p, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 - p, i3, i4) == true) {
						direction = 2;
					}
					if (world1.getBlockId(i2 - p, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 + p, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 - p, i3, i4) != true || world1.getBlockId(i2 + p, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 - p, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 + p, i3, i4) == true) {
						direction = 3;
					}
					if (world1.getBlockId(i2, i3, i4 + p) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 - p) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 + p) != true || world1.getBlockId(i2, i3, i4 - p) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 + p) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 - p) == true) {
						direction = 4;
					}
					if (world1.getBlockId(i2, i3, i4 - p) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 + p) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 - p) != true || world1.getBlockId(i2, i3, i4 + p) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 - p) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 + p) == true) {
						direction = 5;
					}
				}
			}
			if (start == true) {
				if (direction == 0) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 0);
				}
				if (direction == 1) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 1);
				}
				if (direction == 2) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 2);
				}
				if (direction == 3) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 3);
				}
				if (direction == 4) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 4);
				}
				if (direction == 5) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 5);
				}
			}
		}
		if (dmg == 5) {
			boolean direction1 = true;
			boolean start = false;
			for (int x = -8; x < 0; ++x) {
				if (world1.getBlockId(i2 + x, i3, i4) == Block.blockSteel.blockID || world1.getBlockId(i2 - x, i3, i4) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2 + x, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 - x, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 + x, i3, i4) != true || world1.getBlockId(i2 - x, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 + x, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 - x, i3, i4) == true) {
						direction1 = true;
					}
					if (world1.getBlockId(i2 - x, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 + x, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 - x, i3, i4) != true || world1.getBlockId(i2 + x, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 - x, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 + x, i3, i4) == true) {
						direction1 = false;
					}
				}
			}
			if (start == true) {
				if (direction1 == true) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 2);
				}
				if (direction1 == false) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 3);
				}
			}
		}
		if (dmg == 6) {
			boolean direction1 = true;
			boolean start = false;
			for (int y = -8; y < 0; ++y) {

				if (world1.getBlockId(i2, i3 - y, i4) == Block.blockSteel.blockID || world1.getBlockId(i2, i3 + y, i4) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2, i3 + y, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 - y, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 + y, i4) != true || world1.getBlockId(i2, i3 - y, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 + y, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 - y, i4) == true) {
						direction1 = true;
					}
					if (world1.getBlockId(i2, i3 - y, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 + y, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 - y, i4) != true || world1.getBlockId(i2, i3 + y, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 - y, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 + y, i4) == true) {
						direction1 = false;
					}
				}


			}
			if (start == true) {
				if (direction1 == true) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 0);
				}
				if (direction1 == false) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 1);
				}
			}


		}
		if (dmg == 7) {
			boolean direction1 = true;
			boolean start = false;
			for (int x = -8; x < 0; ++x) {
				if (world1.getBlockId(i2, i3, i4 + x) == Block.blockSteel.blockID || world1.getBlockId(i2, i3, i4 - x) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2, i3, i4 + x) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 - x) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 + x) != true || world1.getBlockId(i2, i3, i4 - x) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 + x) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 - x) == true) {
						direction1 = true;
					}
					if (world1.getBlockId(i2, i3, i4 - x) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 + x) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 - x) != true || world1.getBlockId(i2, i3, i4 + x) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 - x) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 + x) == true) {
						direction1 = false;
					}
				}
			}
			if (start == true) {
				if (direction1 == true) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 4);
				}
				if (direction1 == false) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 5);
				}
			}
		}
		if (dmg == 4) {
			byte direction = 7;
			boolean start = false;
			for (int p = -8; p < 0; ++p) {
				if (world1.getBlockId(i2, i3, i4 + p) == Block.blockSteel.blockID || world1.getBlockId(i2, i3, i4 - p) == Block.blockSteel.blockID || world1.getBlockId(i2, i3 - p, i4) == Block.blockSteel.blockID || world1.getBlockId(i2, i3 + p, i4) == Block.blockSteel.blockID || world1.getBlockId(i2 - p, i3, i4) == Block.blockSteel.blockID || world1.getBlockId(i2 + p, i3, i4) == Block.blockSteel.blockID) {
					start = true;
					if (world1.getBlockId(i2, i3 + p, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 - p, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 + p, i4) != true || world1.getBlockId(i2, i3 - p, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 + p, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 - p, i4) == true) {
						direction = 0;
					}
					if (world1.getBlockId(i2, i3 - p, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 + p, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 - p, i4) != true || world1.getBlockId(i2, i3 + p, i4) == Block.blockSteel.blockID && world1.getBlockId(i2, i3 - p, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3 + p, i4) == true) {
						direction = 1;
					}
					if (world1.getBlockId(i2 + p, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 - p, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 + p, i3, i4) != true || world1.getBlockId(i2 - p, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 + p, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 - p, i3, i4) == true) {
						direction = 2;
					}
					if (world1.getBlockId(i2 - p, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 + p, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 - p, i3, i4) != true || world1.getBlockId(i2 + p, i3, i4) == Block.blockSteel.blockID && world1.getBlockId(i2 - p, i3, i4) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2 + p, i3, i4) == true) {
						direction = 3;
					}
					if (world1.getBlockId(i2, i3, i4 + p) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 - p) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 + p) != true || world1.getBlockId(i2, i3, i4 - p) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 + p) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 - p) == true) {
						direction = 4;
					}
					if (world1.getBlockId(i2, i3, i4 - p) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 + p) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 - p) != true || world1.getBlockId(i2, i3, i4 + p) == Block.blockSteel.blockID && world1.getBlockId(i2, i3, i4 - p) != Block.blockSteel.blockID && world1.isBlockGettingPowered(i2, i3, i4 + p) == true) {
						direction = 5;
					}
				}
			}
			if (start == true) {
				if (direction == 0) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 0);

				}

				if (direction == 1) {
					this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 1);

				}
			}
			if (direction == 2) {
				this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 2);

			}
			if (direction == 3) {
				this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 3);
				/*bid1 = world1.getBlockId(i2 + 1, i3, i4);
				bid2 = world1.getBlockId(i2 + 2, i3, i4);
				bid3 = world1.getBlockId(i2 + 3, i3, i4);
				bid4 = world1.getBlockId(i2 + 4, i3, i4);
				bid5 = world1.getBlockId(i2 + 5, i3, i4);
				bid6 = world1.getBlockId(i2 + 6, i3, i4);
				bid7 = world1.getBlockId(i2 + 7, i3, i4);
				bmd1 = (byte) world1.getBlockMetadata(i2 + 1, i3, i4);
				bmd2 = (byte) world1.getBlockMetadata(i2 + 2, i3, i4);
				bmd3 = (byte) world1.getBlockMetadata(i2 + 3, i3, i4);
				bmd4 = (byte) world1.getBlockMetadata(i2 + 4, i3, i4);
				bmd5 = (byte) world1.getBlockMetadata(i2 + 5, i3, i4);
				bmd6 = (byte) world1.getBlockMetadata(i2 + 6, i3, i4);
				bmd7 = (byte) world1.getBlockMetadata(i2 + 7, i3, i4);

				if (bid1 != 0 && bid1 != Block.dispenser.blockID && bid1 != Block.pistonExtension.blockID && bid1 != Block.pistonMoving.blockID && bid1 != Block.blockSteel.blockID && bid1 != Block.obsidian.blockID && bid1 != Block.mobSpawner.blockID && bid1 != Block.stoneOvenIdle.blockID && bid1 != Block.stoneOvenActive.blockID && bid1 != Block.doorWood.blockID && bid1 != Block.doorSteel.blockID && bid1 != Block.trapdoor.blockID) {
					this.tryToSlide(world1, i2 + 1, i3, i4, bid1, bmd1, (byte) 3);
					if (bid2 != 0 && bid2 != Block.dispenser.blockID && bid2 != Block.pistonExtension.blockID && bid2 != Block.pistonMoving.blockID && bid2 != Block.blockSteel.blockID && bid2 != Block.obsidian.blockID && bid2 != Block.mobSpawner.blockID && bid2 != Block.stoneOvenIdle.blockID && bid2 != Block.stoneOvenActive.blockID && bid2 != Block.doorWood.blockID && bid2 != Block.doorSteel.blockID && bid2 != Block.trapdoor.blockID) {
						world1.scheduleBlockUpdate(i2, i3, i4, this.blockID, this.tickRate());
						this.tryToSlide(world1, i2 + 2, i3, i4, bid2, bmd2, (byte) 3);
						if (bid3 != 0 && bid3 != Block.dispenser.blockID && bid3 != Block.pistonExtension.blockID && bid3 != Block.pistonMoving.blockID && bid3 != Block.blockSteel.blockID && bid3 != Block.obsidian.blockID && bid3 != Block.mobSpawner.blockID && bid3 != Block.stoneOvenIdle.blockID && bid3 != Block.stoneOvenActive.blockID && bid3 != Block.doorWood.blockID && bid3 != Block.doorSteel.blockID && bid3 != Block.trapdoor.blockID) {
							world1.scheduleBlockUpdate(i2, i3, i4, this.blockID, this.tickRate());
							this.tryToSlide(world1, i2 + 3, i3, i4, bid3, bmd3, (byte) 3);
							if (bid4 != 0 && bid4 != Block.dispenser.blockID && bid4 != Block.pistonExtension.blockID && bid4 != Block.pistonMoving.blockID && bid4 != Block.blockSteel.blockID && bid4 != Block.obsidian.blockID && bid4 != Block.mobSpawner.blockID && bid4 != Block.stoneOvenIdle.blockID && bid4 != Block.stoneOvenActive.blockID && bid4 != Block.doorWood.blockID && bid4 != Block.doorSteel.blockID && bid4 != Block.trapdoor.blockID) {
								world1.scheduleBlockUpdate(i2, i3, i4, this.blockID, this.tickRate());
								this.tryToSlide(world1, i2 + 4, i3, i4, bid4, bmd4, (byte) 3);
								if (bid5 != 0 && bid5 != Block.dispenser.blockID && bid5 != Block.pistonExtension.blockID && bid5 != Block.pistonMoving.blockID && bid5 != Block.blockSteel.blockID && bid5 != Block.obsidian.blockID && bid5 != Block.mobSpawner.blockID && bid5 != Block.stoneOvenIdle.blockID && bid5 != Block.stoneOvenActive.blockID && bid5 != Block.doorWood.blockID && bid5 != Block.doorSteel.blockID && bid5 != Block.trapdoor.blockID) {
									world1.scheduleBlockUpdate(i2, i3, i4, this.blockID, this.tickRate());
									this.tryToSlide(world1, i2 + 5, i3, i4, bid5, bmd5, (byte) 3);
									if (bid6 != 0 && bid6 != Block.dispenser.blockID && bid6 != Block.pistonExtension.blockID && bid6 != Block.pistonMoving.blockID && bid6 != Block.blockSteel.blockID && bid6 != Block.obsidian.blockID && bid6 != Block.mobSpawner.blockID && bid6 != Block.stoneOvenIdle.blockID && bid6 != Block.stoneOvenActive.blockID && bid6 != Block.doorWood.blockID && bid6 != Block.doorSteel.blockID && bid6 != Block.trapdoor.blockID) {
										world1.scheduleBlockUpdate(i2, i3, i4, this.blockID, this.tickRate());
										this.tryToSlide(world1, i2 + 6, i3, i4, bid6, bmd6, (byte) 3);
										if (bid7 != 0 && bid7 != Block.dispenser.blockID && bid7 != Block.pistonExtension.blockID && bid7 != Block.pistonMoving.blockID && bid7 != Block.blockSteel.blockID && bid7 != Block.obsidian.blockID && bid7 != Block.mobSpawner.blockID && bid7 != Block.stoneOvenIdle.blockID && bid7 != Block.stoneOvenActive.blockID && bid7 != Block.doorWood.blockID && bid7 != Block.doorSteel.blockID && bid7 != Block.trapdoor.blockID) {
											world1.scheduleBlockUpdate(i2, i3, i4, this.blockID, this.tickRate());
											this.tryToSlide(world1, i2 + 7, i3, i4, bid7, bmd7, (byte) 3);
										}
									}
								}
							}
						}
					}
				} */
			}

			if (direction == 4) {
				this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 4);
			}
			if (direction == 5) {
				this.tryToSlide(world1, i2, i3, i4, this.blockID, dmg, (byte) 5);
			}
		}
	}

	private void tryToSlide(World world1, int i2, int i3, int i4, int bid, int damage, byte direction) {
		if(canFallBelow(world1, i2, i3 - 1, i4) && i3 >= 0 && direction == 0) {
			byte b8 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - b8, i3 - b8, i4 - b8, i2 + b8, i3 + b8, i4 + b8)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
				world1.entityJoinedWorld(floating);


			} else {
				world1.setBlockAndMetadataWithNotify(i2, i3, i4, 0, 0);

				while(canFallBelow(world1, i2, i3 - 1, i4) && i3 > 0) {
					--i3;
				}

				if(i3 > 0) {
					world1.setBlockAndMetadataWithNotify(i2, i3, i4, bid, dmg);
				}
			}
		}
		if(canFallAbove(world1, i2, i3 + 1, i4) && i3 < 128 && direction == 1) {
			byte byte0 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - byte0, i3 - byte0, i4 - byte0, i2 + byte0, i3 + byte0, i4 + byte0)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
				world1.entityJoinedWorld(floating);

			} else {
				world1.setBlockWithNotify(i2, i3, i4, 0);

				while(canFallAbove(world1, i2, i3 + 1, i4) && i3 < 128) {
					++i3;
				}

				if(i3 > 0) {
					world1.setBlockWithNotify(i2, i3, i4, bid);
				}
			}
		}
		if(canFallAbove(world1, i2 - 1, i3, i4) && i3 < 128 && direction == 2) {
			byte byte0 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - byte0, i3 - byte0, i4 - byte0, i2 + byte0, i3 + byte0, i4 + byte0)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
				world1.entityJoinedWorld(floating);

			} else {
				world1.setBlockWithNotify(i2, i3, i4, 0);

				while(canFallAbove(world1, i2 - 1, i3, i4) && i3 < 128) {
					--i2;
				}

				if(i3 > 0) {
					world1.setBlockWithNotify(i2, i3, i4, bid);
				}
			}
		}
		if(canFallAbove(world1, i2 + 1, i3, i4) && i3 < 128 && direction == 3) {
			byte byte0 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - byte0, i3 - byte0, i4 - byte0, i2 + byte0, i3 + byte0, i4 + byte0)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
				world1.entityJoinedWorld(floating);

			} else {
				world1.setBlockWithNotify(i2, i3, i4, 0);

				while(canFallAbove(world1, i2 + 1, i3, i4) && i3 < 128) {
					++i2;
				}

				if(i3 > 0) {
					world1.setBlockWithNotify(i2, i3, i4, bid);
				}
			}
		}
		if(canFallAbove(world1, i2, i3, i4 - 1) && i3 < 128 && direction == 4) {
			byte byte0 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - byte0, i3 - byte0, i4 - byte0, i2 + byte0, i3 + byte0, i4 + byte0)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
				world1.entityJoinedWorld(floating);

			} else {
				world1.setBlockWithNotify(i2, i3, i4, 0);

				while(canFallAbove(world1, i2, i3, i4 - 1) && i3 < 128) {
					--i2;
				}

				if(i3 > 0) {
					world1.setBlockWithNotify(i2, i3, i4, bid);
				}
			}
		}
		if(canFallAbove(world1, i2, i3, i4 + 1) && i3 < 128 && direction == 5) {
			byte byte0 = 32;
			if(!fallInstantly && world1.checkChunksExist(i2 - byte0, i3 - byte0, i4 - byte0, i2 + byte0, i3 + byte0, i4 + byte0)) {
				EntityFallingSand2 floating = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
				world1.entityJoinedWorld(floating);

			} else {
				world1.setBlockWithNotify(i2, i3, i4, 0);

				while(canFallAbove(world1, i2, i3, i4 + 1) && i3 < 128) {
					++i2;
				}

				if(i3 > 0) {
					world1.setBlockWithNotify(i2, i3, i4, bid);
				}
			}
		}
		byte b8 = 32;
		if(world1.checkChunksExist(i2 - b8, i3 - b8, i4 - b8, i2 + b8, i3 + b8, i4 + b8)) {
			if(bid == mod_DumbStorage.magnetID && damage == 4 && direction == 0 || bid == mod_DumbStorage.magnetID && damage == 6 && direction == 0) {
				bid1 = world1.getBlockId(i2, i3 - 1, i4);
				bid2 = world1.getBlockId(i2, i3 - 2, i4);
				bid3 = world1.getBlockId(i2, i3 - 3, i4);
				bid4 = world1.getBlockId(i2, i3 - 4, i4);
				bid5 = world1.getBlockId(i2, i3 - 5, i4);
				bid6 = world1.getBlockId(i2, i3 - 6, i4);
				bid7 = world1.getBlockId(i2, i3 - 7, i4);
				bid8 = world1.getBlockId(i2, i3 - 8, i4);
				bmd1 = (byte) world1.getBlockMetadata(i2, i3 - 1, i4);
				bmd2 = (byte) world1.getBlockMetadata(i2, i3 - 2, i4);
				bmd3 = (byte) world1.getBlockMetadata(i2, i3 - 3, i4);
				bmd4 = (byte) world1.getBlockMetadata(i2, i3 - 4, i4);
				bmd5 = (byte) world1.getBlockMetadata(i2, i3 - 5, i4);
				bmd6 = (byte) world1.getBlockMetadata(i2, i3 - 6, i4);
				bmd7 = (byte) world1.getBlockMetadata(i2, i3 - 7, i4);
				bs1 = false;
				bs2 = false;
				bs3 = false;
				bs4 = false;
				bs5 = false;
				bs6 = false;
				bs7 = false;


				if(canFallBelow(world1, i2, i3 - 2, i4) && i3 >= 0 || canFallBelow(world1, i2, i3 - 3, i4) && i3 >= 0 || canFallBelow(world1, i2, i3 - 4, i4) && i3 >= 0|| canFallBelow(world1, i2, i3 - 5, i4) && i3 >= 0 || canFallBelow(world1, i2, i3 - 6, i4) && i3 >= 0 || canFallBelow(world1, i2, i3 - 7, i4) && i3 >= 0 || canFallBelow(world1, i2, i3 - 8, i4) && i3 >= 0) {
					if(bid1 != 0 && bid1 != Block.dispenser.blockID && bid1 != Block.pistonMoving.blockID && bid1 != Block.blockSteel.blockID && bid1 != Block.obsidian.blockID && bid1 != Block.mobSpawner.blockID && bid1 != Block.stoneOvenIdle.blockID && bid1 != Block.stoneOvenActive.blockID && bid1 != Block.chest.blockID && bid1 != Block.pistonExtension.blockID){
						if(bid2 == mod_DumbStorage.magnetID && bmd1 == 4 || bid2 == mod_DumbStorage.magnetID && bmd1 == 6) {
							bs1 = false;
						} else {
							bs1 = true;
						}
					}
					if(bid2 != 0 && bid2 != Block.dispenser.blockID && bid2 != Block.pistonMoving.blockID && bid2 != Block.blockSteel.blockID && bid2 != Block.obsidian.blockID && bid2 != Block.mobSpawner.blockID && bid2 != Block.stoneOvenIdle.blockID && bid2 != Block.stoneOvenActive.blockID && bid2 != Block.chest.blockID && bid2 != Block.pistonExtension.blockID){
						bs2 = true;
					}
					if(bid3 != 0 && bid3 != Block.dispenser.blockID && bid3 != Block.pistonMoving.blockID && bid3 != Block.blockSteel.blockID && bid3 != Block.obsidian.blockID && bid3 != Block.mobSpawner.blockID && bid3 != Block.stoneOvenIdle.blockID && bid3 != Block.stoneOvenActive.blockID && bid3 != Block.chest.blockID && bid3 != Block.pistonExtension.blockID){
						bs3 = true;
					}
					if(bid4 != 0 && bid4 != Block.dispenser.blockID && bid4 != Block.pistonMoving.blockID && bid4 != Block.blockSteel.blockID && bid4 != Block.obsidian.blockID && bid4 != Block.mobSpawner.blockID && bid4 != Block.stoneOvenIdle.blockID && bid4 != Block.stoneOvenActive.blockID && bid4 != Block.chest.blockID && bid4 != Block.pistonExtension.blockID){
						bs4 = true;
					}
					if(bid5 != 0 && bid5 != Block.dispenser.blockID && bid5 != Block.pistonMoving.blockID && bid5 != Block.blockSteel.blockID && bid5 != Block.obsidian.blockID && bid5 != Block.mobSpawner.blockID && bid5 != Block.stoneOvenIdle.blockID && bid5 != Block.stoneOvenActive.blockID && bid5 != Block.chest.blockID && bid5 != Block.pistonExtension.blockID){
						bs5 = true;
					}
					if(bid6 != 0 && bid6 != Block.dispenser.blockID && bid6 != Block.pistonMoving.blockID && bid6 != Block.blockSteel.blockID && bid6 != Block.obsidian.blockID && bid6 != Block.mobSpawner.blockID && bid6 != Block.stoneOvenIdle.blockID && bid6 != Block.stoneOvenActive.blockID && bid6 != Block.chest.blockID && bid6 != Block.pistonExtension.blockID){
						bs6 = true;
					}
					if(bid7 != 0 && bid7 != Block.dispenser.blockID && bid7 != Block.pistonMoving.blockID && bid7 != Block.blockSteel.blockID && bid7 != Block.obsidian.blockID && bid7 != Block.mobSpawner.blockID && bid7 != Block.stoneOvenIdle.blockID && bid7 != Block.stoneOvenActive.blockID && bid7 != Block.chest.blockID && bid7 != Block.pistonExtension.blockID){
						bs7 = true;
					}
				}

				if (bs7 && bs6 && bs5 && bs4 && bs3 && bs2 && bs1 && canFallBelow(world1, i2, i3 - 8, i4) && i3 >= 0) {
					EntityFallingSand2 moving7 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 6.5F), (double)((float)i4 + 0.5F), bid7, bmd7, direction);
					world1.entityJoinedWorld(moving7);
					EntityFallingSand2 moving6 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 5.5F), (double)((float)i4 + 0.5F), bid6, bmd6, direction);
					world1.entityJoinedWorld(moving6);
					EntityFallingSand2 moving5 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 4.5F), (double)((float)i4 + 0.5F), bid5, bmd5, direction);
					world1.entityJoinedWorld(moving5);
					EntityFallingSand2 moving4 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 3.5F), (double)((float)i4 + 0.5F), bid4, bmd4, direction);
					world1.entityJoinedWorld(moving4);
					EntityFallingSand2 moving3 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 2.5F), (double)((float)i4 + 0.5F), bid3, bmd3, direction);
					world1.entityJoinedWorld(moving3);
					EntityFallingSand2 moving2 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 1.5F), (double)((float)i4 + 0.5F), bid2, bmd2, direction);
					world1.entityJoinedWorld(moving2);
					EntityFallingSand2 moving1 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 0.5F), (double)((float)i4 + 0.5F), bid1, bmd1, direction);
					world1.entityJoinedWorld(moving1);
					EntityFallingSand2 moving = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
					world1.entityJoinedWorld(moving);
				} else if (bs6 && bs5 && bs4 && bs3 && bs2 && bs1 && canFallBelow(world1, i2, i3 - 7, i4) && i3 >= 0) {
					EntityFallingSand2 moving6 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 5.5F), (double)((float)i4 + 0.5F), bid6, bmd6, direction);
					world1.entityJoinedWorld(moving6);
					EntityFallingSand2 moving5 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 4.5F), (double)((float)i4 + 0.5F), bid5, bmd5, direction);
					world1.entityJoinedWorld(moving5);
					EntityFallingSand2 moving4 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 3.5F), (double)((float)i4 + 0.5F), bid4, bmd4, direction);
					world1.entityJoinedWorld(moving4);
					EntityFallingSand2 moving3 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 2.5F), (double)((float)i4 + 0.5F), bid3, bmd3, direction);
					world1.entityJoinedWorld(moving3);
					EntityFallingSand2 moving2 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 1.5F), (double)((float)i4 + 0.5F), bid2, bmd2, direction);
					world1.entityJoinedWorld(moving2);
					EntityFallingSand2 moving1 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 0.5F), (double)((float)i4 + 0.5F), bid1, bmd1, direction);
					world1.entityJoinedWorld(moving1);
					EntityFallingSand2 moving = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
					world1.entityJoinedWorld(moving);
				} else if ( bs5 && bs4 && bs3 && bs2 && bs1 && canFallBelow(world1, i2, i3 - 6, i4) && i3 >= 0) {
					EntityFallingSand2 moving5 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 4.5F), (double)((float)i4 + 0.5F), bid5, bmd5, direction);
					world1.entityJoinedWorld(moving5);
					EntityFallingSand2 moving4 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 3.5F), (double)((float)i4 + 0.5F), bid4, bmd4, direction);
					world1.entityJoinedWorld(moving4);
					EntityFallingSand2 moving3 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 2.5F), (double)((float)i4 + 0.5F), bid3, bmd3, direction);
					world1.entityJoinedWorld(moving3);
					EntityFallingSand2 moving2 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 1.5F), (double)((float)i4 + 0.5F), bid2, bmd2, direction);
					world1.entityJoinedWorld(moving2);
					EntityFallingSand2 moving1 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 0.5F), (double)((float)i4 + 0.5F), bid1, bmd1, direction);
					world1.entityJoinedWorld(moving1);
					EntityFallingSand2 moving = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
					world1.entityJoinedWorld(moving);
				} else if (bs4 && bs3 && bs2 && bs1 && canFallBelow(world1, i2, i3 - 5, i4) && i3 >= 0) {
					EntityFallingSand2 moving4 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 3.5F), (double)((float)i4 + 0.5F), bid4, bmd4, direction);
					world1.entityJoinedWorld(moving4);
					world1.setBlockWithNotify(i2, i3 - 4, i4, 0);
					EntityFallingSand2 moving3 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 2.5F), (double)((float)i4 + 0.5F), bid3, bmd3, direction);
					world1.entityJoinedWorld(moving3);
					EntityFallingSand2 moving2 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 1.5F), (double)((float)i4 + 0.5F), bid2, bmd2, direction);
					world1.entityJoinedWorld(moving2);
					EntityFallingSand2 moving1 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 0.5F), (double)((float)i4 + 0.5F), bid1, bmd1, direction);
					world1.entityJoinedWorld(moving1);
					EntityFallingSand2 moving = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
					world1.entityJoinedWorld(moving);
				} else if (bs3 && bs2 && bs1 && canFallBelow(world1, i2, i3 - 4, i4) && i3 >= 0) {
					EntityFallingSand2 moving3 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 2.5F), (double)((float)i4 + 0.5F), bid3, bmd3, direction);
					world1.entityJoinedWorld(moving3);
					EntityFallingSand2 moving2 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 1.5F), (double)((float)i4 + 0.5F), bid2, bmd2, direction);
					world1.entityJoinedWorld(moving2);
					EntityFallingSand2 moving1 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 0.5F), (double)((float)i4 + 0.5F), bid1, bmd1, direction);
					world1.entityJoinedWorld(moving1);
					EntityFallingSand2 moving = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
					world1.entityJoinedWorld(moving);
				} else if (bs2 == true && bs1 == true && canFallBelow(world1, i2, i3 - 3, i4) && i3 >= 0) {
					EntityFallingSand2 moving2 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 1.5F), (double)((float)i4 + 0.5F), bid2, bmd2, direction);
					world1.entityJoinedWorld(moving2);
					EntityFallingSand2 moving1 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 0.5F), (double)((float)i4 + 0.5F), bid1, bmd1, direction);
					world1.entityJoinedWorld(moving1);
					EntityFallingSand2 moving = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
					world1.entityJoinedWorld(moving);
				} else if(bs1 == true && canFallBelow(world1, i2, i3 - 2, i4) && i3 >= 0) {
					EntityFallingSand2 moving1 = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 - 0.5F), (double)((float)i4 + 0.5F), bid1, bmd1, direction);
					world1.entityJoinedWorld(moving1);
					EntityFallingSand2 moving = new EntityFallingSand2(world1, (double)((float)i2 + 0.5F), (double)((float)i3 + 0.5F), (double)((float)i4 + 0.5F), bid, damage, direction);
					world1.entityJoinedWorld(moving);
				}

			}
		}

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
