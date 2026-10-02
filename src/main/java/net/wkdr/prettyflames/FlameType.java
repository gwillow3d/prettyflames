package net.wkdr.prettyflames;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum FlameType implements StringRepresentable {
    Normal("normal"),
    Soul("soul"),
    Copper("copper");

    private final String name;
    FlameType(String name) { this.name = name; }

    @Override
    public String getSerializedName() { return name; }

    public static final Codec<FlameType> CODEC = StringRepresentable.fromEnum(FlameType::values);
}
