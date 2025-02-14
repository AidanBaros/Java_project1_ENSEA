import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GameEngine implements Engine, KeyListener{
    private final DynamicSprite hero;

    public GameEngine(DynamicSprite hero){
        this.hero = hero;
    }

    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                hero.setDirection(Direction.NORTH);
                break;
            case KeyEvent.VK_DOWN:
                hero.setDirection(Direction.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                hero.setDirection(Direction.WEST);
                break;
            case KeyEvent.VK_RIGHT:
                hero.setDirection(Direction.EAST);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        hero.stopMoving();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public void update(){
        
    }
}
