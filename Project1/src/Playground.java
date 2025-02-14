import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Playground {
    private ArrayList<Sprite> environment = new ArrayList<>();
    public Playground (String pathName){
    try{
        final Image imageTree = ImageIO.read(new File("Project1/resources/tree.png"));
        final Image imageGrass = ImageIO.read(new File("Project1/resources/grass.png"));
        final Image imageRock = ImageIO.read(new File("Project1/resources/rock.png"));
        final Image imageTrap = ImageIO.read(new File("Project1/resources/trap.png"));
        final int imageTreeWidth = imageTree.getWidth(null);
        final int imageTreeHeight = imageTree.getHeight(null);
        final int imageGrassWidth = imageGrass.getWidth(null);
        final int imageGrassHeight = imageGrass.getHeight(null);
        final int imageRockWidth = imageRock.getWidth(null);
        final int imageRockHeight = imageRock.getHeight(null);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathName));
        String line=bufferedReader.readLine();
        int lineNumber = 0;
        int columnNumber = 0;
        while (line!= null){
            for (byte element : line.getBytes(StandardCharsets.UTF_8)){
                switch (element){
                    case 'T' : environment.add(new SolidSprite(imageTree, imageTreeWidth, imageTreeHeight, columnNumber*imageTreeWidth,
                        lineNumber*imageTreeHeight));
                        break;
                    case ' ' : environment.add(new Sprite(imageGrass, imageGrassWidth, imageGrassHeight, columnNumber*imageGrassWidth,
                        lineNumber*imageGrassHeight));
                        break;
                    case 'R' : environment.add(new SolidSprite(imageRock, imageRockWidth, imageRockHeight, columnNumber*imageRockWidth,
                        lineNumber*imageRockHeight));
                        break;
                    }
                columnNumber++;
                }
            columnNumber =0;
            lineNumber++;
            line=bufferedReader.readLine();
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
    }

    public ArrayList<Sprite> getSolidSpriteList() {
        ArrayList<Sprite> solidSpriteArrayList = new ArrayList<>();
        for (Sprite sprite : environment) {
            if (sprite instanceof SolidSprite) {
                solidSpriteArrayList.add(sprite);
            }
        }
        return solidSpriteArrayList;
    }

    public ArrayList<Displayable> getSpriteList(){
        ArrayList <Displayable> displayableArrayList = new ArrayList<>();
        for (Sprite sprite : environment){
            displayableArrayList.add((Displayable) sprite);
        }
        return displayableArrayList;
    }
}