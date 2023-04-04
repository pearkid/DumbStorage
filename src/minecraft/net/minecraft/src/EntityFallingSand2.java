package net.minecraft.src;

import java.util.List;

public class EntityFallingSand2 extends Entity {
	public int blockID;
	public int fallTime = 0;
	public int md = 2;
	public byte thing = 1;
	public byte direction;
	public float splode;
	public String texture = "/DumbStorageTextures/MissingTexture.png";

	public EntityFallingSand2(World world1) {
		super(world1);
	}

	public EntityFallingSand2(World world1, double d2, double d4, double d6, int i8, int i5, byte dir) {
		super(world1);
		this.blockID = i8;
		this.preventEntitySpawning = true;
		this.setSize(0.98F, 0.98F);
		this.yOffset = this.height / 2.0F;
		this.setPosition(d2, d4, d6);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = d2;
		this.prevPosY = d4;
		this.prevPosZ = d6;
		thing = (byte) i5;
		md = i5;
		direction = dir;
	}

	protected boolean canTriggerWalking() {
		return false;
	}

	protected void entityInit() {
		this.dataWatcher.addObject(31, 2);
	}
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	public void onUpdate() {
		if(this.blockID == 0) {
			this.setEntityDead();
		} else {
			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;
			++this.fallTime;
			switch(direction) {
				case 0: this.motionY -= (double)0.04F;
				break;
				case 1: this.motionY += (double)0.04F;
					break;
				case 2: this.motionX -= (double)0.04F;
					break;
				case 3: this.motionX += (double)0.04F;
					break;
				case 4: this.motionZ -= (double)0.04F;
					break;
				case 5: this.motionZ += (double)0.04F;
					break;
			}

			this.moveEntity(this.motionX, this.motionY, this.motionZ);
			this.motionX *= (double)0.98F;
			this.motionY *= (double)0.98F;
			this.motionZ *= (double)0.98F;
			int i1 = MathHelper.floor_double(this.posX);
			int i2 = MathHelper.floor_double(this.posY);
			int i3 = MathHelper.floor_double(this.posZ);
			if(this.worldObj.getBlockId(i1, i2, i3) == this.blockID) {
				this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, 0, 0);
			}



			if(this.isCollided) {
				this.motionX *= (double)0.7F;
				this.motionZ *= (double)0.7F;
				this.motionY *= -0.5D;
				if((this.worldObj.getBlockId(i1 + 1, i2, i3) == Block.blockSteel.blockID || this.worldObj.getBlockId(i1 + 1, i2, i3) == mod_DumbStorage.magnetID) || (this.worldObj.getBlockId(i1 - 1, i2, i3) == Block.blockSteel.blockID || this.worldObj.getBlockId(i1 - 1, i2, i3) == mod_DumbStorage.magnetID) || (this.worldObj.getBlockId(i1, i2 + 1, i3) == Block.blockSteel.blockID || this.worldObj.getBlockId(i1, i2 + 1, i3) == mod_DumbStorage.magnetID)|| (this.worldObj.getBlockId(i1, i2 - 1, i3) == Block.blockSteel.blockID || this.worldObj.getBlockId(i1, i2 - 1, i3) == mod_DumbStorage.magnetID)|| (this.worldObj.getBlockId(i1, i2, i3 + 1) == Block.blockSteel.blockID || this.worldObj.getBlockId(i1, i2, i3 + 1) == mod_DumbStorage.magnetID) || (this.worldObj.getBlockId(i1, i2, i3 - 1) == Block.blockSteel.blockID || this.worldObj.getBlockId(i1, i2, i3 - 1) == mod_DumbStorage.magnetID) || motionX == 0 && motionY == 0 && motionZ == 0) {
					this.setEntityDead();
					if(direction == 0) {
						if((!this.worldObj.canBlockBePlacedAt(this.blockID, i1, i2, i3, true, 1) || BlockSand.canFallBelow(this.worldObj, i1, i2 - 1, i3) || !this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing)) && !this.worldObj.multiplayerWorld) {
							if(this.worldObj.getBlockId(i1, i2, i3) == Block.stairSingle.blockID && this.blockID != Block.stairSingle.blockID) {
								splode = 2F;
							} else {
								splode = 0.1F;
							}
							this.worldObj.createExplosion((Entity)null, i1, i2, i3, splode);
							if (this.blockID == Block.redstoneWire.blockID || this.blockID == Block.redstoneRepeaterActive.blockID || this.blockID == Block.redstoneRepeaterIdle.blockID) {
								this.worldObj.setBlockWithNotify(i1, i2, i3, 0);
							} else {
								this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing);
							}
						}
					}
					if(direction == 1) {
						if((!this.worldObj.canBlockBePlacedAt(this.blockID, i1, i2, i3, true, 1) || BlockMagnet.canFallAbove(this.worldObj, i1, i2 + 1, i3) || !this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing)) && !this.worldObj.multiplayerWorld) {
							//this.dropItem(this.blockID, 1);
							if (this.blockID == Block.redstoneWire.blockID || this.blockID == Block.redstoneRepeaterActive.blockID || this.blockID == Block.redstoneRepeaterIdle.blockID) {
								this.worldObj.setBlockWithNotify(i1, i2, i3, 0);
							} else {
								this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing);
							}
						}
					}
					if(direction == 2) {
						if((!this.worldObj.canBlockBePlacedAt(this.blockID, i1, i2, i3, true, 1) || BlockMagnet.canFallAbove(this.worldObj, i1 - 1, i2, i3) || !this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing)) && !this.worldObj.multiplayerWorld) {
							//this.dropItem(this.blockID, 1);
							if (this.blockID == Block.redstoneWire.blockID || this.blockID == Block.redstoneRepeaterActive.blockID || this.blockID == Block.redstoneRepeaterIdle.blockID) {
								this.worldObj.setBlockWithNotify(i1, i2, i3, 0);
							} else {
								this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing);
							}
						}
					}
					if(direction == 3) {
						if((!this.worldObj.canBlockBePlacedAt(this.blockID, i1, i2, i3, true, 1) || BlockMagnet.canFallAbove(this.worldObj, i1 + 1, i2, i3) || !this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing)) && !this.worldObj.multiplayerWorld) {
							//this.dropItem(this.blockID, 1);
							if (this.blockID == Block.redstoneWire.blockID || this.blockID == Block.redstoneRepeaterActive.blockID || this.blockID == Block.redstoneRepeaterIdle.blockID) {
								this.worldObj.setBlockWithNotify(i1, i2, i3, 0);
							} else {
								this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing);
							}
						}
					}
					if(direction == 4) {
						if((!this.worldObj.canBlockBePlacedAt(this.blockID, i1, i2, i3, true, 1) || BlockMagnet.canFallAbove(this.worldObj, i1, i2, i3 - 1) || !this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing)) && !this.worldObj.multiplayerWorld) {
							//this.dropItem(this.blockID, 1);
							if (this.blockID == Block.redstoneWire.blockID || this.blockID == Block.redstoneRepeaterActive.blockID || this.blockID == Block.redstoneRepeaterIdle.blockID) {
								this.worldObj.setBlockWithNotify(i1, i2, i3, 0);
							} else {
								this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing);
							}
						}
					}
					if(direction == 5) {
						if((!this.worldObj.canBlockBePlacedAt(this.blockID, i1, i2, i3, true, 1) || BlockMagnet.canFallAbove(this.worldObj, i1, i2, i3 + 1) || !this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing)) && !this.worldObj.multiplayerWorld) {
							//this.dropItem(this.blockID, 1);
							if (this.blockID == Block.redstoneWire.blockID || this.blockID == Block.redstoneRepeaterActive.blockID || this.blockID == Block.redstoneRepeaterIdle.blockID) {
								this.worldObj.setBlockWithNotify(i1, i2, i3, 0);
							} else {
								this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing);
							}
						}
					}
				}

			} else if(this.fallTime >= 21 /*&& !this.worldObj.multiplayerWorld*/ && this.blockID != mod_DumbStorage.snadStoneID || this.fallTime >= 21 && this.blockID == mod_DumbStorage.snadStoneID && direction != 0) {
				//this.dropItem(this.blockID, 1);
				this.setEntityDead();
				if (this.blockID == Block.redstoneWire.blockID || this.blockID == Block.redstoneRepeaterActive.blockID || this.blockID == Block.redstoneRepeaterIdle.blockID) {
					this.worldObj.setBlockWithNotify(i1, i2, i3, 0);
				} else {
					this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing);
				}
			}
			if(this.onGround) {
				this.motionX *= (double)0.7F;
				this.motionZ *= (double)0.7F;
				this.motionY *= -0.5D;
				if (this.blockID == mod_DumbStorage.snadStoneID) {
					this.setEntityDead();
				}
				if((!this.worldObj.canBlockBePlacedAt(this.blockID, i1, i2, i3, true, 1) || BlockSand.canFallBelow(this.worldObj, i1, i2 - 1, i3) || !this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing)) && !this.worldObj.multiplayerWorld) {
					//this.dropItem(this.blockID, 1);
					if (this.blockID == Block.redstoneWire.blockID || this.blockID == Block.redstoneRepeaterActive.blockID || this.blockID == Block.redstoneRepeaterIdle.blockID) {
						this.worldObj.setBlockWithNotify(i1, i2, i3, 0);
					} else {
						this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing);
					}
				}
			} else if(this.fallTime >= 21 /*&& !this.worldObj.multiplayerWorld*/ && this.blockID != mod_DumbStorage.snadStoneID || this.fallTime >= 21 && this.blockID == mod_DumbStorage.snadStoneID && direction != 0) {
				//this.dropItem(this.blockID, 1);
				this.setEntityDead();
				if (this.blockID == Block.redstoneWire.blockID || this.blockID == Block.redstoneRepeaterActive.blockID || this.blockID == Block.redstoneRepeaterIdle.blockID) {
					this.worldObj.setBlockWithNotify(i1, i2, i3, 0);
				} else {
					this.worldObj.setBlockAndMetadataWithNotify(i1, i2, i3, this.blockID, thing);
				}
			}

		}
	}

	protected void writeEntityToNBT(NBTTagCompound nBTTagCompound1) {
		nBTTagCompound1.setByte("Tile", (byte)this.blockID);
	}

	protected void readEntityFromNBT(NBTTagCompound nBTTagCompound1) {
		this.blockID = nBTTagCompound1.getByte("Tile") & 255;
	}

	public float getShadowSize() {
		return 0.0F;
	}

	public World getWorld() {
		return this.worldObj;
	}
}
