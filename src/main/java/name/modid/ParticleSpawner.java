package name.modid;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
// 好康的花瓣粒子捏～
public class ParticleSpawner {
    private static final double RADIUS = 1.2; // 扩散半径
    private static final int COUNT = 5; // 数量
    private static final float HEIGHT_OFFSET = 1.5f; // 粒子生成高度

    public static void spawnAroundPlayer(PlayerEntity player) {
        ClientWorld world = (ClientWorld) player.getWorld();
        Vec3d pos = player.getPos();

        for (int i = 0; i < COUNT; i++) {
            Vec3d offset = createCircularOffset().add(0, Math.random() * 1.5, 0);
            Vec3d spawnPos = pos.add(offset).add(0, HEIGHT_OFFSET, 0);

            world.addParticle(
                    ParticleTypes.CHERRY_LEAVES,
                    spawnPos.x,
                    spawnPos.y,
                    spawnPos.z,
                    (Math.random() - 0.5) * 0.1,
                    -0.05,
                    (Math.random() - 0.5) * 0.1
            );
        }
    }

    private static Vec3d createCircularOffset() {
        double angle = Math.random() * Math.PI * 2;
        double r = Math.random() * RADIUS;
        return new Vec3d(
                Math.cos(angle) * r,
                0,
                Math.sin(angle) * r
        );
    }
}