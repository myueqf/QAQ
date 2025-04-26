package name.modid;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class FallDamagePreventer {
    public FallDamagePreventer() {
        ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
    }
    // 无摔伤～
    private void onClientTick(MinecraftClient client) {
        if (client.player == null) return;
        //忽略创造玩家～
        if (client.player.isCreative()) return;
        // 忽略不造成伤害的～
        if (client.player.fallDistance > 2) {
            // 发包～
            client.player.networkHandler.sendPacket(
                    new PlayerMoveC2SPacket.OnGroundOnly(true)
            );
        }
    }
}