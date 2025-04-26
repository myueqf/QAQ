package name.modid;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

public class JetpackHandler {
    public JetpackHandler() {
        ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
    }
    // 轻功水上飘～
    private void onClientTick(MinecraftClient client) {
        ClientPlayerEntity player = client.player;
        if (player != null && client.options.jumpKey.isPressed()) {
            player.jump();
            ParticleSpawner.spawnAroundPlayer(player);  // 生成粒子～
        }
    }
}