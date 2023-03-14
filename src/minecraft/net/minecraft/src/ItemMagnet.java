package net.minecraft.src;

public class ItemMagnet extends ItemBlock {
	public ItemMagnet(int i1) {
		super(i1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public int getIconFromDamage(int i1) {
		return DumbSBlocks.magnet.getBlockTextureFromSideAndMetadata(2, i1);
	}

	public int getPlacedBlockMetadata(int i1) {
		if(i1 == 1) {
			return 2;
		}
		if(i1 == 3) {
			return 2;
		}
		if(i1 == 5) {
			return 6;
		}
		if(i1 == 7) {
			return 6;
		}
		return i1;
	}

	public String getItemNameIS(ItemStack itemStack1) {
		return super.getItemName() + "." + BlockMagnet.magnetnames[itemStack1.getItemDamage()];
	}
}
