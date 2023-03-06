package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderFallingSand2 extends Render {
	private RenderBlocks blocks2 = new RenderBlocks();

	public RenderFallingSand2() {
		this.shadowSize = 0.5F;
	}

	public void doRenderFallingSand2(EntityFallingSand2 entityFallingSand2, double d2, double d4, double d6, float f8, float f9) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d2, (float)d4, (float)d6);
		this.loadTexture("/DumbStorageTextures/FallingBlock2.png");
		Block block10;
		switch (entityFallingSand2.md) {
			default: block10 = Block.blocksList[1];
			break;
			case 1: block10 = Block.blocksList[3];
			break;
			case 2: block10 = Block.blocksList[4];
				break;
			case 3: block10 = Block.blocksList[5];
				break;
			case 4: block10 = Block.blocksList[45];
				break;
			case 5: block10 = Block.blocksList[7];
				break;
			case 6: block10 = Block.blocksList[12];
				break;
			case 7: block10 = Block.blocksList[13];
				break;
			case 8: block10 = Block.blocksList[6];
				break;
			case 9: block10 = Block.blocksList[14];
				break;
			case 10: block10 = Block.blocksList[15];
				break;
			case 11: block10 = Block.blocksList[16];
				break;
			case 12: block10 = Block.blocksList[48];
				break;
			case 13: block10 = Block.blocksList[49];
				break;
			case 14: block10 = Block.blocksList[57];
				break;
			case 15: block10 = Block.blocksList[41];
				break;
		}
		World world11 = entityFallingSand2.getWorld();
		GL11.glDisable(GL11.GL_LIGHTING);
		this.blocks2.renderBlockFallingSand(block10, world11, MathHelper.floor_double(entityFallingSand2.posX), MathHelper.floor_double(entityFallingSand2.posY), MathHelper.floor_double(entityFallingSand2.posZ));
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	public void doRender(Entity entity1, double d2, double d4, double d6, float f8, float f9) {
		this.doRenderFallingSand2((EntityFallingSand2)entity1, d2, d4, d6, f8, f9);
	}
}
