/**
 * @author Chinmay Mangalwedhe, Allen Romo, Braeden Drosche
 *
 */

import java.awt.*;
import javax.swing.*;

public class Picture extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // call methods
        drawRoad(g, new int[]{0, 400, 800}, new int[]{600, 0, 600});
        drawGround(g, new int[] {0, 400, 0}, new int[] {600, 0, 0});
        drawGround(g, new int[] {800, 400, 800}, new int[] {600, 0, 0});
        drawRamp(g, new int[]{548, 100, 518, 50});
        drawRoadDivider(g);
        drawRoadSign(g);
        drawSun(g);

    }

    public void drawRoad(Graphics g, int[] xPts, int[] yPts) {

        g.setColor(new Color(79, 78, 78));


        Polygon mainRoad = new Polygon(xPts, yPts, 3);
        g.fillPolygon(mainRoad);
    }

    public void drawRoadDivider(Graphics g) {
        // make road divider color yellow and draw divider
        g.setColor(new Color(177, 169, 50));
        for (int i = 10; i < 585; i+= 30) {
            g.fillRect(398, i, 5, 13);
        }
    }

    public void drawRamp(Graphics g, int[] coordinates) {
        Polygon ramp = new Polygon();
    }

    public void drawGround(Graphics g, int[] xPos, int[] yPos) {
        // draws remaining shapes as the color of the ground
        g.setColor(new Color(152, 182, 142));

        Polygon ground = new Polygon(xPos, yPos, 3);
        g.fillPolygon(ground);
    }

    public void drawRoadSign(Graphics g) {
        Graphics2D thickLineDrawer = (Graphics2D) g;
        // draws the road sign for the exit ramp
        g.setColor(new Color(77, 101, 72));
        g.fillRect(600, 175, 170, 75);
        g.drawLine(675, 175, 675, 350);

        // exit sign
        g.setColor(Color.WHITE);
        g.setFont(new Font("Highway Gothic", Font.BOLD, 20));
        g.drawString("Exit 12B in 0.2mi", 605, 200);

        // draw road sign heading towards the ramp
        int[] xPoints = {710, 720, 680};
        int[] yPoints = {210, 230, 220};

        Polygon triangle = new Polygon(xPoints, yPoints, 3);
        g.fillPolygon(triangle);

        thickLineDrawer.setStroke(new BasicStroke(3));
        thickLineDrawer.drawLine(700, 220, 680, 240);
    }

    public void drawSun(Graphics g) {
        // draw the sun
        g.setColor(new Color(241, 197, 109));
        g.fillArc(20, -50, 100, 100, 0, -180);

        // draw the sun lining
        g.setColor(new Color(255, 129, 0));
        g.drawArc(20, -50, 100, 100, 0, -180);

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Picture Project: Highway Chinmay Mangalwedhe Allen Romo Braeden Drosche");
        frame.setVisible(true);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Picture component = new Picture();
        component.setPreferredSize(new Dimension(800, 600));

        frame.add(component);

        frame.pack();
        frame.setLocationRelativeTo(null); // centers the frame
    }
}