package com.crescentine.trajanstanks.entity.tanks.t34;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class T34Renderer extends GeoEntityRenderer<T34Entity> {
    public T34Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new T34Model());
        this.shadowRadius = 0.7F;
    }
}