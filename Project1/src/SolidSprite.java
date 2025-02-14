import java.awt.Image;
import java.awt.Graphics;

public class SolidSprite extends Sprite{
    public SolidSprite(Image image, Integer height, Integer width, Integer x, Integer y){
        super(image, height, width, x, y);
    }

    public void draw(Graphics g){
        super.draw(g);
    }
}
