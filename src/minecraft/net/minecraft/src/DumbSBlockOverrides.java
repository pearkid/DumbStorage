package net.minecraft.src;

public class DumbSBlockOverrides {
    public void override(){
        Block.blocksList[55] = null;
        Block redstoneDust = (new BlockProxyRedstoneWire(55, 164)).setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setBlockName("redstoneDust").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[50] = null;
        Block torchWood = (new BlockProxyTorch(50, 80)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setBlockName("torch").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[75] = null;
        Block torchRedstoneIdle = (new BlockProxyRedstoneTorch(75, 115, false)).setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setBlockName("notGate").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[76] = null;
        Block torchRedstoneActive = (new BlockProxyRedstoneTorch(76, 99, true)).setHardness(0.0F).setLightValue(0.5F).setStepSound(Block.soundWoodFootstep).setBlockName("notGate").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[93] = null;
        Block redstoneRepeaterIdle = (new BlockProxyRedstoneRepeater(93, false)).setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setBlockName("diode").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[94] = null;
        Block redstoneRepeaterActive = (new BlockProxyRedstoneRepeater(94, true)).setHardness(0.0F).setLightValue(0.625F).setStepSound(Block.soundWoodFootstep).setBlockName("diode").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[77] = null;
        Block button = (new BlockProxyButton(77, Block.stone.blockIndexInTexture)).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("button").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[96] = null;
        Block trapdoor = (new BlockProxyTrapDoor(96, Material.wood)).setHardness(3.0F).setStepSound(Block.soundWoodFootstep).setBlockName("trapdoor").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[70] = null;
        Block pressurePlateStone = (new BlockProxyPressurePlate(70, Block.stone.blockIndexInTexture, EnumMobType.mobs, Material.rock)).setHardness(0.5F).setStepSound(Block.soundStoneFootstep).setBlockName("pressurePlate").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[72] = null;
        Block pressurePlatePlanks = (new BlockProxyPressurePlate(72, Block.planks.blockIndexInTexture, EnumMobType.everything, Material.wood)).setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setBlockName("pressurePlate").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[71] = null;
        Block doorSteel = (new BlockProxyDoor(71, Material.iron)).setHardness(5.0F).setStepSound(Block.soundMetalFootstep).setBlockName("doorIron").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[64] = null;
        Block doorWood = (new BlockProxyDoor(64, Material.wood)).setHardness(3.0F).setStepSound(Block.soundWoodFootstep).setBlockName("doorWood").disableStats().disableNeighborNotifyOnMetadataChange();
        Block.blocksList[69] = null;
        Block lever = (new BlockProxyLever(69, 96)).setHardness(0.5F).setStepSound(Block.soundWoodFootstep).setBlockName("lever").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[27] = null;
        Block railPowered = (new BlockProxyRail(27, 179, true)).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setBlockName("goldenRail").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[28] = null;
        Block railDetector = (new BlockProxyDetectorRail(28, 195)).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setBlockName("detectorRail").disableNeighborNotifyOnMetadataChange();
        Block.blocksList[66] = null;
        Block rail = (new BlockProxyRail(66, 128, false)).setHardness(0.7F).setStepSound(Block.soundMetalFootstep).setBlockName("rail").disableNeighborNotifyOnMetadataChange();
    }
}
