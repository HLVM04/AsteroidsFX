package dk.sdu.mmmi.cbse;


import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletLagFix implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        int displayWidth = gameData.getDisplayWidth();
        int displayHeight = gameData.getDisplayHeight();

        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX * 3);
            bullet.setY(bullet.getY() + changeY * 3);


            if (bullet.getX() < 0 || bullet.getX() > displayWidth) {
                world.removeEntity(bullet);
                System.out.println(bullet.getX() + " " + bullet.getY() + " " + bullet.getRotation());
            }
            if (bullet.getY() < 0 || bullet.getY() > displayHeight) {
                world.removeEntity(bullet);
                System.out.println(bullet.getX() + " " + bullet.getY() + " " + bullet.getRotation());
            }
        }
    }
}
