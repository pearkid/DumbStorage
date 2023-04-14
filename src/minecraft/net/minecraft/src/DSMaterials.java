package net.minecraft.src;

public class DSMaterials extends Material{
    public DSMaterials(MapColor mapColor1) {
        super(mapColor1);
    }
    public static final DSMaterials power = (DSMaterials) (new DSMaterials(MapColor.tntColor)).setIsTranslucent();

    private boolean canBurn;
    private boolean groundCover;
    private boolean isOpaque;
    private boolean canHarvest = true;
    private int mobilityFlag;

    public boolean getIsLiquid() {
        return false;
    }

    public boolean isSolid() {
        return true;
    }

    public boolean getCanBlockGrass() {
        return false;
    }

    public boolean getIsSolid() {
        return true;
    }

    private Material setIsTranslucent() {
        this.isOpaque = true;
        return this;
    }

    private Material setNoHarvest() {
        this.canHarvest = false;
        return this;
    }

    private Material setBurning() {
        this.canBurn = true;
        return this;
    }

    public boolean getBurning() {
        return this.canBurn;
    }

    public Material setIsGroundCover() {
        this.groundCover = true;
        return this;
    }

    public boolean getIsGroundCover() {
        return this.groundCover;
    }

    public boolean getIsTranslucent() {
        return this.isOpaque ? false : this.getIsSolid();
    }

    public boolean getIsHarvestable() {
        return this.canHarvest;
    }

    public int getMaterialMobility() {
        return this.mobilityFlag;
    }

    protected Material setNoPushMobility() {
        this.mobilityFlag = 1;
        return this;
    }

    protected Material setImmovableMobility() {
        this.mobilityFlag = 2;
        return this;
    }
}
