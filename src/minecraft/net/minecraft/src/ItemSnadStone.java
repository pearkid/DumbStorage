package net.minecraft.src;

public class ItemSnadStone extends ItemBlock {
	public ItemSnadStone(int i1) {
		super(i1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public int getIconFromDamage(int i1) {
		return mod_DumbStorage.snadStone.getBlockTextureFromSideAndMetadata(2, i1);
	}

	public int getPlacedBlockMetadata(int i1) {
		return i1;
	}

	public String getItemNameIS(ItemStack itemStack1) {
		return super.getItemName() + "." + BlockSnadStone.sandstonenames[itemStack1.getItemDamage()];
	}
}
