import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Bullet {
    requires Common;
    requires CommonBullet;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.BulletLagFix;
}