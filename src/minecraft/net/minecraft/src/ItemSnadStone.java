package net.minecraft.src;

public class ItemSnadStone extends ItemBlock {
	public ItemSnadStone(int id) {
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public int getIconFromDamage(int i1) {
		return mod_DumbStorage.snadStone.getBlockTextureFromSideAndMetadata(2, i1);
	}

	public int getPlacedBlockMetadata(int damage) {
		return damage;
	}

	public String getItemNameIS(ItemStack itemStack1) {
		return super.getItemName() + "." + BlockSnadStone.sandstonenames[itemStack1.getItemDamage()];
	}
}
