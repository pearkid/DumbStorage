package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderFallingSand2 extends Render {
	private RenderBlocks field_197_d = new RenderBlocks();

	public RenderFallingSand2() {
		this.shadowSize = 0.5F;
	}

	public void doRenderFallingSand2(EntityFallingSand2 entityFallingSand2, double d2, double d4, double d6, float f8, float f9) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d2, (float)d4, (float)d6);
		this.loadTexture("/DumbStorageTextures/FallingBlock2.png");
		Block block10 = Block.blocksList[entityFallingSand2.thing];
		World world11 = entityFallingSand2.getWorld();
		GL11.glDisable(GL11.GL_LIGHTING);
		this.field_197_d.renderBlockFallingSand(block10, world11, MathHelper.floor_double(entityFallingSand2.posX), MathHelper.floor_double(entityFallingSand2.posY), MathHelper.floor_double(entityFallingSand2.posZ));
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	public void doRender(Entity entity1, double d2, double d4, double d6, float f8, float f9) {
		this.doRenderFallingSand2((EntityFallingSand2)entity1, d2, d4, d6, f8, f9);
	}
}
