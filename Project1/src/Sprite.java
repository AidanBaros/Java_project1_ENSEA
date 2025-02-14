import java.awt.Graphics;
import java.awt.Image;

public class Sprite implements Displayable{
    protected Image image;
    protected int height;
    protected int width;
    protected int x;
    protected int y;

    public Sprite(Image image, int height, int width, int x, int y){
        this.image = image;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g){
        g.drawImage(image,x,y,width,height,null);
    }
}
