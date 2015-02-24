/**
 * Created by Christian Alexander on 10/26/14.
 */
import java.awt.Point;
import java.awt.Dimension;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.geom.*;
import java.awt.Stroke;
import java.awt.BasicStroke;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Task4CADriver extends JPanel{
    A_Container _root;
    boolean mode; //True = Draw by points; False = Draw by paths

    private static A_Container init()
    {
        ContainerWindow root = new ContainerWindow("Root", new Point(0,0), new Dimension(500, 500));
            ContainerWindow secondary = new ContainerWindow("Secondary", new Point(100,100), new Dimension(300,300));
                root.addEntity(secondary);
                ShapeDot dot2 = new ShapeDot("Dot Two", new Point(40,0));
                    secondary.addEntity(dot2);
                ContainerWindow third = new ContainerWindow("Third", new Point(20, 20), new Dimension(200, 200));
                    secondary.addEntity(third);
                    ContainerWindow fourth = new ContainerWindow("Fourth", new Point(50, 20), new Dimension(100, 100));
                        third.addEntity(fourth);
                        ShapeCircle circleInFourth = new ShapeCircle("Circle within Fourth", new Point(75, 15), 20.0);
                            fourth.addEntity(circleInFourth);
                ShapeCircle circle = new ShapeCircle("Circle One", new Point(150,150), 50.0);
                    secondary.addEntity(circle);
                ShapeDot dot3 = new ShapeDot("Dot Three", new Point(5,1));
                    secondary.addEntity(dot3);
                ShapeCircle circle4 = new ShapeCircle("Circle Four", new Point(0,0), 100.0);
                    secondary.addEntity(circle4);

            ContainerWindow within = new ContainerWindow("Within", new Point(20,0), new Dimension(50,75));
            root.addEntity(within);
                ShapeDot dot = new ShapeDot("Dot", new Point(4,4));
                    within.addEntity(dot);
                ShapeDot dotty = new ShapeDot("Dotty", new Point(-1, 4));
                    within.addEntity(dotty);

            ShapeCircle circle2 = new ShapeCircle("Circle Two", new Point(150,150), 75);
                root.addEntity(circle2);
            ShapeCircle circle3 = new ShapeCircle("Circle Three", new Point(0,0), 50.0);
                root.addEntity(circle3);
                
                
            //circle3.setCenter(null);
            circle3.setCenter( new Point(525, 250));
            //ShapeCircle outCircle = new ShapeCircle("Out Circle", new Point(100, 100), 75.0);
            //secondary.addEntity(outCircle);
            dotty.setOrigin(new Point(20, 20));

        return root;
    }

    public static void main(String[] args)
    {
        A_Container root = init();

        //Create first window
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Task 4 Driver (All Points As 1x1 rects)");
        f.setSize(root.getSize().width + 30, root.getSize().height + 50);
        f.getContentPane().add(new Task4CADriver(root, true));
        f.setVisible(true);

        //Create second window
        JFrame f2 = new JFrame();
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setTitle("Task 4 Driver (Traverse for circle paths)");
        f2.setSize(root.getSize().width + 30, root.getSize().height + 50);
        f2.getContentPane().add(new Task4CADriver(root, false));
        f2.setLocation(root.getSize().width + 80, 0);
        f2.setVisible(true);
    }

    private Task4CADriver(A_Container root, boolean mode)
    {
        _root = root;
        this.mode = mode;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        Stroke solid = new BasicStroke(1);
        g2.setStroke(solid);
        g2.setColor(Color.black);

        if(mode)
            drawByAllPoints(g2);
        else
            drawByTraversal(g2, _root);

        g2.setColor(Color.red);
        recDrawBorders(g2, _root);

        g2.setColor(Color.black);
    }

    private void drawByAllPoints(Graphics2D g2)
    {
        for(Point p : _root.update()) {
            int i = 1;
            g2.drawRect(p.x, p.y, 1, 1);
        }
    }

    private void drawByTraversal(Graphics2D g2, A_Entity entity)
    {
        if(entity instanceof A_Container)
        {
            for(A_Entity e : ((A_Container)entity).getEntities())
            {
                drawByTraversal(g2, e);
            }
        }
        else if(entity instanceof ShapeCircle)
        {
            drawCircle(g2, (ShapeCircle)entity);
        }
        else if(entity instanceof ShapeDot)
        {
            if(((ShapeDot)entity).update().size() > 0)
                g2.drawRect(((ShapeDot)entity).update().get(0).x, ((ShapeDot)entity).update().get(0).y, 1, 1);
        }
    }

    private void drawCircle(Graphics2D g2, ShapeCircle circle)
    {
        List<Point> points = circle.update();
        for(int i = 0; i < points.size() - 1; i++)
        {
            g2.drawLine(points.get(i).x, points.get(i).y, points.get(i+1).x, points.get(i+1).y);
        }
    }

    private void recDrawBorders(Graphics2D g2, A_Container entity)
    {
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);

        g2.setColor(Color.red);
        g2.setStroke(dashed);
        if(entity.hasContainer())
            g2.drawRect(entity.getContainer().calculatePointAbsolute(entity.getOrigin()).x,
                    entity.getContainer().calculatePointAbsolute(entity.getOrigin()).y,
                    entity.getSize().width, entity.getSize().height);
        else
            g2.drawRect(entity.getOrigin().x, entity.getOrigin().y, entity.getSize().width, entity.getSize().height);

        for(A_Entity e : entity.getEntities())
        {
            if(e instanceof A_Container)
                recDrawBorders(g2, (A_Container)e);
        }
    }
}
