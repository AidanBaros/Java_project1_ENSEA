import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Main {

    JFrame displayZoneFrame;
    RenderEngine renderEngine;
    GameEngine gameEngine;
    PhysicsEngine physicsEngine;
    DynamicSprite hero;
    BufferedImage heroImage;
    Playground playground;

    public Main() throws Exception{
        displayZoneFrame = new JFrame("Java Labs");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        heroImage = ImageIO.read(new File("Project1/resources/heroTileSheetLowRes.png"));
        hero = new DynamicSprite(heroImage, 48, 50, 100, 300);

        renderEngine = new RenderEngine();
        physicsEngine = new PhysicsEngine();
        gameEngine = new GameEngine(hero);

        playground = new Playground("Project1/resources/level1.txt");
        renderEngine.setRenderList(playground.getSpriteList());
        physicsEngine.setEnvironment(playground.getSolidSpriteList());

        Timer renderTimer = new Timer(50,(time)-> renderEngine.update());
        Timer gameTimer = new Timer(50,(time)-> gameEngine.update());
        Timer physicsTimer = new Timer(50,(time)-> physicsEngine.update());

        renderTimer.start();
        gameTimer.start();
        physicsTimer.start();

        displayZoneFrame.getContentPane().add(renderEngine);
        displayZoneFrame.addKeyListener(gameEngine);
        displayZoneFrame.setVisible(true);

        renderEngine.addToRenderList(hero);
        physicsEngine.addToMovingSpriteList(hero);

        ArrayList<Sprite> solidSprites = playground.getSolidSpriteList();

        physicsEngine.setEnvironment(solidSprites);
        for (Sprite sprite : solidSprites) {
            renderEngine.addToRenderList(sprite);
        }
    }
    /*
    public Main() throws Exception{
        displayZoneFrame = new JFrame("Java Labs");
        displayZoneFrame.setSize(400,600);
        displayZoneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        heroImage = ImageIO.read(new File("Project1/resources/heroTileSheetLowRes.png"));
        hero = new DynamicSprite(heroImage, 200, 300, 48, 50);

        renderEngine = new RenderEngine();
        gameEngine = new GameEngine(hero);

        renderEngine.addToRenderList(hero);

        renderTimer = new Timer(50,(time)-> renderEngine.update());
        gameTimer = new Timer(50,(time)-> gameEngine.update());

        renderTimer.start();
        displayZoneFrame.getContentPane().add(renderEngine);
        displayZoneFrame.addKeyListener(gameEngine);
        displayZoneFrame.setVisible(true);
    }
     */
    
    public static void main(String[] args) throws Exception {
        System.out.println("Starting...");
        Main main = new Main();
        
    }
}
