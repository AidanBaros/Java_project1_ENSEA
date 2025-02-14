import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;

public class RenderEngine extends JPanel implements Engine {
    private ArrayList<Displayable> renderList;

    public RenderEngine() {
        renderList = new ArrayList<>();
    }

    public void update() {
        repaint();
    }

    public void setRenderList(ArrayList<Displayable> renderList) {
        this.renderList = renderList;
    }

    public void addToRenderList(Displayable displayable) {
        this.renderList.add(displayable);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.clearRect(0, 0, getWidth(), getHeight());

        for (Displayable d : renderList) {
            if (!(d instanceof DynamicSprite)) {
                d.draw(g);
            }
        }

        for (Displayable d : renderList) {
            if (d instanceof DynamicSprite) {
                d.draw(g);
            }
        }
    }
}