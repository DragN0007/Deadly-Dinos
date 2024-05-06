package com.dragn0007.deadlydinos.entity;

import net.minecraft.sounds.SoundSource;

import javax.annotation.Nullable;

public interface Bannered {
    boolean isBannerable();

    void equipBanner(@Nullable SoundSource soundSource);

    boolean isBannered();

}
