import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class DynamicSprite extends SolidSprite {
    Boolean isWalking;
    Double speed;
    final int spriteSheetNumberOfColumn;
    int timeBetweenFrame;
    Direction direction;
    int index;
    int attitude;

    public DynamicSprite(Image image, int height, int width, int x, int y,
                         double speed, int timeBetweenFrame, Direction direction) {
        super(image, height, width, x, y);
        this.isWalking = false;
        this.speed = speed;
        this.spriteSheetNumberOfColumn = 10;
        this.timeBetweenFrame = timeBetweenFrame;
        this.direction = direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
        isWalking = true;
        //System.out.println("walking");
    }

    private void move(){
        if (!isWalking) return;
        switch (this.direction) {
            case NORTH -> {
                this.y -= speed;
            }
            case SOUTH -> {
                this.y += speed;
            }
            case EAST -> {
                this.x += speed;
            }
            case WEST -> {
                this.x -= speed;
            }
        }
    }

    public void stopMoving() {
        isWalking = false;
    }

    private boolean isMovingPossible(ArrayList<Sprite> environment) {
        double hitBoxX = this.x;
        double hitBoxY = this.y;
    
        switch (direction) {
            case NORTH -> hitBoxY -= speed;
            case SOUTH -> hitBoxY += speed;
            case EAST -> hitBoxX += speed;
            case WEST -> hitBoxX -= speed;
        }
    
        Rectangle2D.Double hitBox = new Rectangle2D.Double(hitBoxX, hitBoxY, width, height);
    
        for (Sprite sprite : environment) {
            if (sprite instanceof SolidSprite && sprite != this) {
                Rectangle2D.Double solidBounds = new Rectangle2D.Double(sprite.x, sprite.y, sprite.width, sprite.height);
    
                if (hitBox.intersects(solidBounds)) {
                    return false;
                }
            }
        }
    
        return true;
    }

    public void moveIfPossible(ArrayList<Sprite>environment){
        if (!isMovingPossible(environment)) {
            isWalking = false;
            return;
        }
        move();
    }

    @Override
    public void draw(Graphics g) {

        this.index = (int) ((System.currentTimeMillis() / timeBetweenFrame) % spriteSheetNumberOfColumn);
        this.attitude = direction.getFrameLineNumber();

        int frameWidth = this.image.getWidth(null) / spriteSheetNumberOfColumn;
        int frameHeight = this.image.getHeight(null) / 4;

        g.drawImage(
            this.image,
            x, y, x + frameWidth, y + frameHeight,
            this.index * frameWidth, this.attitude * frameHeight,
            (this.index + 1) * frameWidth, (this.attitude + 1) * frameHeight,
            null
        );
    }
}
