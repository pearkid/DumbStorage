package net.minecraft.src;

import java.util.Random;

import static java.lang.Math.abs;

public class DumbSGenSecretDoor extends DumbSGenStructures {
    private int BlockID1;
    private int BlockID2;
    private int meta1;
    private int meta2;
    private int meta3;
    private int meta4;
    private int size;
    private int size2;
    private int n;
    private boolean finished;
    private boolean flat;
    private boolean trap;

    public DumbSGenSecretDoor(int i, int j, boolean flag, boolean trap) {
        this.BlockID1 = i;
        this.BlockID2 = j;
        this.flat = flag;
        this.finished = false;
        this.trap = trap;
    }

    public boolean generate(World world, Random random, int i, int j, int k) {
        this.replaceAir = true;
        this.replaceSolid = true;
        this.n = 0;



        if (world.isAirBlock(i, j, k) && ((BlockDeadBush) Block.blocksList[32]).canBlockStay(world, i, j, k) && !world.isAirBlock(i + 8, j - 1, k - 8) || world.isAirBlock(i, j, k) && ((BlockTallGrass) Block.blocksList[31]).canBlockStay(world, i, j, k) && !world.isAirBlock(i + 8, j - 1, k - 8)) {
            if (world.isAirBlock(i, j, k) && ((BlockDeadBush) Block.blocksList[32]).canBlockStay(world, i, j, k) && !world.isAirBlock(i + 8, j - 1, k - 8)) {
                this.setBlocks(Block.sand.blockID, Block.grass.blockID, 10);
                world.setBlockAndMetadata(i, j - 1, k, Block.sand.blockID, 3);
            } else {
                this.setBlocks(Block.grass.blockID, Block.gravel.blockID, 10);
                world.setBlockAndMetadata(i, j - 1, k, Block.grass.blockID, 3);
            }

            this.addSolidBox(world, random, i - 4, j - 4, k - 6, 15, 4, 10);
            this.setBlocks(this.BlockID1, this.BlockID2, 20);
            this.setMetadata(this.meta1, this.meta2);
            world.setBlockAndMetadata(i, j, k, Block.lever.blockID, 5);
            world.setBlockAndMetadata(i, j - 2, k, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadata(i + 1, j - 2, k, Block.glass.blockID, 0);
            world.setBlockAndMetadata(i - 1, j - 2, k, Block.cloth.blockID, 0);
            world.setBlockAndMetadata(i - 2, j - 2, k, Block.torchRedstoneActive.blockID, 2);
            world.setBlockAndMetadata(i - 2, j - 2, k - 1, Block.redstoneRepeaterIdle.blockID, 1);
            this.addLineZ(world, random, i - 3, j - 2, k - 1, 3);
            this.addLineZ(world, random, i - 2, j - 2, k + 1, 2);
            this.addLineZ(world, random, i - 1, j - 2, k - 5, 5);
            this.addLineX(world, random, i - 2, j - 2, k + 2, 5);
            this.addLineX(world, random, i - 1, j - 2, k - 5, 4);
            this.addLineX(world, random, i + 5, j - 2, k - 5, 4);
            this.addLineX(world, random, i + 5, j - 2, k + 2, 4);
            this.addLineZ(world, random, i + 8, j - 2, k - 5, 8);
            world.setBlockAndMetadata(i + 6, j - 2, k + 2, Block.redstoneRepeaterIdle.blockID, 1);
            world.setBlockAndMetadata(i, j - 2, k - 1, Block.redstoneRepeaterIdle.blockID, 13);
            world.setBlockAndMetadata(i, j - 2, k - 2, Block.redstoneRepeaterIdle.blockID, 13);
            world.setBlockAndMetadata(i + 7, j - 2, k - 1, Block.redstoneRepeaterIdle.blockID, 15);
            world.setBlockAndMetadata(i + 7, j - 2, k - 2, Block.redstoneRepeaterIdle.blockID, 15);
            world.setBlockAndMetadata(i + 6, j - 2, k - 2, Block.pistonStickyBase.blockID, 4);
            world.setBlockAndMetadata(i + 6, j - 2, k - 1, Block.pistonStickyBase.blockID, 4);
            world.setBlockAndMetadata(i + 6, j - 3, k - 2, Block.pistonStickyBase.blockID, 4);
            world.setBlockAndMetadata(i + 6, j - 3, k - 1, Block.pistonStickyBase.blockID, 4);
            world.setBlockAndMetadata(i + 1, j - 2, k - 2, Block.pistonStickyBase.blockID, 5);
            world.setBlockAndMetadata(i + 1, j - 2, k - 1, Block.pistonStickyBase.blockID, 5);
            world.setBlockAndMetadata(i + 1, j - 3, k - 2, Block.pistonStickyBase.blockID, 5);
            world.setBlockAndMetadata(i + 1, j - 3, k - 1, Block.pistonStickyBase.blockID, 5);
            world.setBlockAndMetadata(i + 2, j - 3, k - 2, Block.pistonStickyBase.blockID, 1);
            world.setBlockAndMetadata(i + 2, j - 3, k - 1, Block.pistonStickyBase.blockID, 1);
            world.setBlockAndMetadata(i + 5, j - 3, k - 2, Block.pistonStickyBase.blockID, 1);
            world.setBlockAndMetadata(i + 5, j - 3, k - 1, Block.pistonStickyBase.blockID, 1);
            world.setBlockAndMetadata(i + 3, j - 3, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 3, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 3, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 3, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 2, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 2, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 2, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 2, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 1, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 1, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 1, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 4, j - 1, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 3, j, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 3, j, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 4, j, k - 2, 0, 0);
            world.setBlockAndMetadata(i + 4, j, k - 1, 0, 0);
            world.setBlockAndMetadata(i + 3, j - 3, k + 1, Block.redstoneRepeaterIdle.blockID, 0);
            world.setBlockAndMetadata(i + 4, j - 3, k + 1, Block.redstoneRepeaterIdle.blockID, 0);
            world.setBlockAndMetadata(i + 3, j - 3, k + 2, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadata(i + 4, j - 3, k + 2, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadataWithNotify(i + 3, j - 2, k + 2, Block.glass.blockID, 0);
            world.setBlockAndMetadataWithNotify(i + 4, j - 2, k + 2, Block.glass.blockID, 0);
            world.setBlockAndMetadata(i + 3, j - 3, k - 4, Block.redstoneRepeaterIdle.blockID, 2);
            world.setBlockAndMetadata(i + 4, j - 3, k - 4, Block.redstoneRepeaterIdle.blockID, 2);
            world.setBlockAndMetadata(i + 3, j - 3, k - 5, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadata(i + 4, j - 3, k - 5, Block.redstoneWire.blockID, 0);
            world.setBlockAndMetadataWithNotify(i + 3, j - 2, k - 5, Block.glass.blockID, 0);
            world.setBlockAndMetadataWithNotify(i + 4, j - 2, k - 5, Block.glass.blockID, 0);
            world.setBlockAndMetadata(i, j, k, Block.lever.blockID, 5);
            world.setBlockAndMetadataWithNotify(i - 2, j - 2, k, Block.torchRedstoneActive.blockID, 2);
            if (trap == true) {
                this.setBlocks(0,0,0);
                this.addSolidBox(world, random, i + 3, j - 64, k - 2, 2, 61, 2);
            }
            if (trap == false) {
                this.setBlocks(Block.planks.blockID, Block.bookShelf.blockID, 10);
                this.addSolidBox(world, random, i + 3, j - 7, k, 2, 5, 1);
                this.addSolidBox(world, random, i + 3, j - 7, k - 3, 2, 5, 1);
                this.addSolidBox(world, random, i + 2, j - 7, k - 2, 1, 4, 2);
                this.addSolidBox(world, random, i + 5, j - 7, k - 2, 1, 4, 2);
                this.addHollowBox(world, random, i, j - 10, k - 3, 20, 5, 10);
                this.setBlocks(0,0,0);
                this.addSolidBox(world, random, i + 3, j - 11, k - 2, 2, 8, 2);
                this.setBlocks(Block.planks.blockID, Block.bookShelf.blockID, 10);
                this.addSolidBox(world, random, i + 3, j - 11, k, 2, 2, 1);
                this.addSolidBox(world, random, i + 3, j - 11, k - 3, 2, 2, 1);
                this.addSolidBox(world, random, i + 2, j - 11, k - 2, 1, 2, 2);
                this.addSolidBox(world, random, i + 5, j - 11, k - 2, 1, 2, 2);
                this.addSolidBox(world, random, i + 3, j - 12, k - 2, 2, 1, 2);
                this.setBlocks(Block.waterStill.blockID, Block.waterStill.blockID, 10);
                this.addSolidBox(world, random, i + 3, j - 11, k - 2, 2, 2, 2);
                world.setBlockAndMetadataWithNotify(i + 18, j - 9, k - 1, Block.chest.blockID, 0);
                world.setBlockAndMetadataWithNotify(i + 18, j - 9, k - 2, Block.chest.blockID, 0);
                TileEntityChest chest = (TileEntityChest)((TileEntityChest)world.getBlockTileEntity(i + 18, j - 9, k - 2));
                TileEntityChest chest2 = (TileEntityChest)((TileEntityChest)world.getBlockTileEntity(i + 18, j - 9, k - 1));
                world.setBlockAndMetadataWithNotify(i + 18, j - 9, k + 1, Block.chest.blockID, 0);
                world.setBlockAndMetadataWithNotify(i + 18, j - 9, k + 2, Block.chest.blockID, 0);
                TileEntityChest chest3 = (TileEntityChest)((TileEntityChest)world.getBlockTileEntity(i + 18, j - 9, k + 1));
                TileEntityChest chest4 = (TileEntityChest)((TileEntityChest)world.getBlockTileEntity(i + 18, j - 9, k + 2));
                world.setBlockAndMetadataWithNotify(i + 18, j - 9, k + 4, Block.chest.blockID, 0);
                world.setBlockAndMetadataWithNotify(i + 18, j - 9, k + 5, Block.chest.blockID, 0);
                TileEntityChest chest5 = (TileEntityChest)((TileEntityChest)world.getBlockTileEntity(i + 18, j - 9, k + 4));
                TileEntityChest chest6 = (TileEntityChest)((TileEntityChest)world.getBlockTileEntity(i + 18, j - 9, k + 5));
                world.setBlock(i + 18, j - 7, k - 2, Block.torchWood.blockID);
                world.setBlock(i + 18, j - 7, k + 5, Block.torchWood.blockID);
                world.setBlock(i + 10, j - 7, k - 2, Block.torchWood.blockID);
                world.setBlock(i + 10, j - 7, k + 5, Block.torchWood.blockID);
                world.setBlock(i + 1, j - 7, k - 2, Block.torchWood.blockID);
                world.setBlock(i + 1, j - 7, k + 5, Block.torchWood.blockID);

                int p;
                for(p = 0; p < 3 + random.nextInt(5); ++p) {
                    ItemStack q = this.getNormalLoot(random);
                    chest.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), q);
                    q = this.getNormalLoot(random);
                    chest2.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), q);
                    q = this.getNormalLoot(random);
                    chest3.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), q);
                    q = this.getNormalLoot(random);
                    chest4.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), q);
                    q = this.getNormalLoot(random);
                    chest5.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), q);
                    q = this.getNormalLoot(random);
                    chest6.setInventorySlotContents(random.nextInt(chest.getSizeInventory()), q);
                }
            }

        }
        return true;

    }
    private ItemStack getNormalLoot(Random random) {
        int item = random.nextInt(37);
        switch(item) {
            case 0:
                return new ItemStack(DumbSBlocks.magnet.blockID, 1, random.nextInt(3));
            case 1:
                return new ItemStack(DumbSBlocks.dirts.blockID, 1, random.nextInt(7));
            case 2:
                return new ItemStack(DumbSBlocks.stones.blockID, 1, 3 + random.nextInt(3));
            case 3:
                return new ItemStack(DumbSBlocks.snadStone.blockID, 1, random.nextInt(7));
            case 4:
                return new ItemStack(Item.appleGold);
            case 5:
                return new ItemStack(Item.dyePowder, random.nextInt(16), random.nextInt(15));
            case 6:
                return new ItemStack(Item.painting);
            case 7:
                return new ItemStack(Item.porkCooked);
            case 8:
                return new ItemStack(Item.cookie, random.nextInt(8));
            case 9:
                return new ItemStack(Block.snow, random.nextInt(24));
            case 10:
                return new ItemStack(Block.ice, random.nextInt(10));
            case 11:
                return new ItemStack(Block.grass, random.nextInt(16));
            case 12:
                if(random.nextInt(4) == 0) {
                    return new ItemStack(Item.pocketSundial);
                }
                break;
            case 13:
                if(random.nextInt(10) == 0) {
                    return new ItemStack(Block.sponge);
                }
                break;
            case 14:
                return new ItemStack(Item.cake);
            case 15:
                return new ItemStack(Item.helmetChain);
            case 16:
                return new ItemStack(Item.bootsChain);
            case 17:
                return new ItemStack(Item.legsChain);
            case 18:
                return new ItemStack(Item.plateChain);
            case 19:
                return new ItemStack(Item.bootsLeather);
            case 20:
                return new ItemStack(Item.legsLeather);
            case 21:
                return new ItemStack(Item.plateLeather);
            case 22:
                return new ItemStack(Item.helmetLeather);
            case 23:
                return new ItemStack(Item.bootsGold);
            case 24:
                return new ItemStack(Item.plateGold);
            case 25:
                return new ItemStack(Item.legsGold);
            case 26:
                return new ItemStack(Item.helmetGold);
            case 27:
                return new ItemStack(Item.slimeBall);
            case 28:
                return new ItemStack(Item.appleRed);
            case 29:
                return new ItemStack(Block.web, random.nextInt(16));
            case 30:
                return new ItemStack(Item.book, random.nextInt(24));
            case 31:
                return new ItemStack(Block.oreDiamond, random.nextInt(2));
            case 32:
                return new ItemStack(Block.oreCoal, random.nextInt(16));
            case 33:
                return new ItemStack(Block.oreIron, random.nextInt(8));
            case 34:
                return new ItemStack(Block.oreLapis, random.nextInt(4));
            case 35:
                return new ItemStack(Block.oreRedstone, random.nextInt(6));
            case 36:
                return new ItemStack(Block.oreGold, random.nextInt(4));
        }

        return new ItemStack(Item.brick, random.nextInt(16));
    }
}

