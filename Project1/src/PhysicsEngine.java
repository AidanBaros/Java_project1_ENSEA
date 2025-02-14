import java.util.ArrayList;

public class PhysicsEngine implements Engine{
    ArrayList<DynamicSprite> movingSpriteList;
    ArrayList<Sprite> environment;

    public PhysicsEngine() {
        this.movingSpriteList = new ArrayList<DynamicSprite>();
        this.environment = new ArrayList<Sprite>();
    }

    @Override
    public void update(){
        for (DynamicSprite sprite:movingSpriteList){
            sprite.moveIfPossible(environment);
        }
    }

    public void addToMovingSpriteList(DynamicSprite sprite){
        this.movingSpriteList.add(sprite);
    }

    public void setEnvironment(ArrayList<Sprite> environment) {
        this.environment = environment;
    }
}
