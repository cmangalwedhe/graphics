/**
 * @author Chinmay Mangalwedhe, Allen Romo, Braeden Drosche
 * @version v2.9
 * @since 01/31/2022
 */

import java.awt.*;
import javax.swing.*;

public class Picture extends JPanel {

    private static final Color groundColor = new Color(152, 182, 142);
    private static final Color roadColor = new Color(79, 78, 78);
    private static final Color signColor = new Color(77, 101, 72);

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // call methods
        drawRoad(g, new int[]{0, 400, 800}, new int[]{600, 0, 600});
        drawGround(g, new int[] {0, 400, 0}, new int[] {600, 0, 0});
        drawGround(g, new int[] {800, 400, 800}, new int[] {600, 0, 0});
        drawRoadDivider(g);
        drawRoadSign(g);
        drawRamp(g);
        drawSun(g);
        welcomeSign(g);

    }

    public void drawRoad(Graphics g, int[] xPts, int[] yPts) {

        g.setColor(roadColor);


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

    public void drawRamp(Graphics g) {
        // draws exit 12b ramp
        g.setColor(roadColor);
        g.fillOval(410, 40, 400, 125);

        // cover green oval to cover gray oval for ramp
        g.setColor(groundColor);
        g.fillOval(480, 95, 350, 80);
    }

    public void drawGround(Graphics g, int[] xPos, int[] yPos) {
        // draws remaining shapes as the color of the ground
        g.setColor(groundColor);

        Polygon ground = new Polygon(xPos, yPos, 3);
        g.fillPolygon(ground);
    }

    public void drawRoadSign(Graphics g) {

        Graphics2D thickLineDrawer = (Graphics2D) g;
        thickLineDrawer.setStroke(new BasicStroke(3));

        // draws the road sign for the exit ramp
        g.setColor(signColor);
        g.fillRect(600, 175, 170, 75);

        g.setColor(Color.BLACK);
        g.drawLine(675, 250, 675, 350);

        // exit sign
        g.setColor(Color.WHITE);
        g.setFont(new Font("Highway Gothic", Font.BOLD, 20));
        g.drawString("Exit 12B in 0.2mi", 605, 200);

        // draw road sign heading towards the ramp
        int[] xPoints = {710, 720, 680};
        int[] yPoints = {210, 230, 220};

        Polygon triangle = new Polygon(xPoints, yPoints, 3);
        g.fillPolygon(triangle);

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

    public void welcomeSign(Graphics g) {
        // draws Welcome in English, Kannada, and Japanese
        g.setColor(signColor);
        g.fillRect(10, 125, 200, 150);

        g.setColor(Color.BLACK);
        g.drawLine(100, 275, 100, 350);

        // set font to write text
        g.setFont(new Font("Clearview", Font.BOLD, 10));
        g.drawString("National Highway Authorities of India", 15, 150);
        g.drawString("Nelamangala-Bengaluru Toll Road", 20, 170);

    }

    public static void main(String[] args) {
        // basic frame configuration
        JFrame frame = new JFrame();
        frame.setTitle("Picture Project: Highway - Chinmay Mangalwedhe, Allen Romo, and Braeden Drosche");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates component
        Picture component = new Picture();
        component.setPreferredSize(new Dimension(800, 600));

        // adds component to frame and packs it
        frame.add(component);
        frame.pack();

        // centers the frame
        frame.setLocationRelativeTo(null);
    }
}