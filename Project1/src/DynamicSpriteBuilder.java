import java.awt.Image;

public class DynamicSpriteBuilder {
    private Image image;
    private int height;
    private int width;
    private int x;
    private int y;
    private double speed = 5.0;
    private int timeBetweenFrame = 200;
    private Direction direction = Direction.SOUTH;

    public DynamicSpriteBuilder setImage(Image image) {
        this.image = image;
        return this;
    }

    public DynamicSpriteBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public DynamicSpriteBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public DynamicSpriteBuilder setX(int x) {
        this.x = x;
        return this;
    }

    public DynamicSpriteBuilder setY(int y) {
        this.y = y;
        return this;
    }

    public DynamicSpriteBuilder setSpeed(double speed) {
        this.speed = speed;
        return this;
    }

    public DynamicSpriteBuilder setTimeBetweenFrame(int timeBetweenFrame) {
        this.timeBetweenFrame = timeBetweenFrame;
        return this;
    }

    public DynamicSpriteBuilder setDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public DynamicSprite build() {
        return new DynamicSprite(image, height, width, x, y, speed, timeBetweenFrame, direction);
    }
}