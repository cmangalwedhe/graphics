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
    private int bodyX,  bodyY,  tireOneX,  tireOneY, width, height, tireTwoX, tireTwoY;

    /**
     * Animates the car to move forward on the highway
     */
    public void animateCar() {

        // sets initial values of car's movement
        bodyX = 450;
        bodyY = 500;
        tireOneX = 475;
        tireOneY = 585;
        tireTwoX = 600;
        tireTwoY = 585;
        width = 200;
        height = 100;


        for (int i = 0; i < 500; i += 10) {
            // delays movement of the car to show it moving
            try {
                Thread.sleep(300);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            // changes the position of the car for it to move
            width -= 1;
            height -= 1;
            bodyY -= 14;
            tireOneX += .1 * width;
            tireOneY -= 14 / height;
            tireTwoX -= .1;
            tireTwoY -= 14;
            repaint();
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // call methods
        drawGround(g, new int[] {0, 400, 0}, new int[] {600, 0, 0});
        drawGround(g, new int[] {800, 400, 800}, new int[] {600, 0, 0});
        drawRoadSign(g);
        drawRamp(g);
        drawSun(g);
        welcomeSign(g);
        drawRoad(g, new int[]{0, 400, 800}, new int[]{600, 0, 600});
        drawRoadDivider(g);
        drawNames(g);
        drawCar(g);

    }

    // that method right there is where I animate it
    // so what do you recommend?
    //

    /**
     * Draws the road as a triangle to show perspective and a little bit o
     * f 3D art
     * @param g a reference to the graphics container
     * @param xPts an array of x coordinates to draw the road
     * @param yPts an array of y coordinates to draw the road
     */
    public void drawRoad(Graphics g, int[] xPts, int[] yPts) {
        g.setColor(roadColor);

        Polygon mainRoad = new Polygon(xPts, yPts, 3);
        g.fillPolygon(mainRoad);
    }

    /**
     * Draws the road divider for the road to distinguish the lanes
     * @param g a reference to the graphics container
     */

    public void drawRoadDivider(Graphics g) {
        // make road divider color yellow and draw divider
        g.setColor(new Color(177, 169, 50));
        for (int i = 10; i < 585; i+= 30) {
            g.fillRect(398, i, 5, 12);
        }
    }

    /**
     * @param g a reference to the graphics container
     */
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
        g.fillArc(25, -50, 100, 100, 0, -180);

        // draw the sun lining
        g.setColor(new Color(255, 129, 0));
        g.drawArc(25, -50, 100, 100, 0, -180);
    }

    public void welcomeSign(Graphics g) {
        // draws Welcome to US sign
        g.setColor(signColor);
        g.fillRect(10, 125, 210, 150);

        g.setColor(Color.BLACK);
        g.drawLine(115,275, 115, 350);

        // set font to write text
        g.setColor(Color.WHITE);
        g.setFont(new Font("Clearview", Font.BOLD, 9));
        g.drawString("Welcome to the United States of America!", 20, 150);
        g.drawString("Please continue straight towards immigration", 10, 170);
        g.drawString("Exit 12B is last stop before entering USA", 25, 190);

        // draws nearby cities and directions
        g.setFont(new Font("Clearview", Font.BOLD, 12));
        g.drawString("New York, NY: 90mi", 60, 220);
        g.drawString("Trenton, NJ: 270mi", 60, 240);
        g.drawString("Houston, TX: 2,724mi", 55, 260);
    }

    public void drawNames(Graphics nameWriter) {
        // creates new space to write them
        nameWriter.setColor(new Color(204, 225, 177));
        nameWriter.fillRoundRect(100, 50, 200, 70, 90, 20);

        // write our names
        nameWriter.setColor(Color.BLACK);
        nameWriter.drawString("Chinmay Mangalwedhe - Period 6", 110, 70);
        nameWriter.drawString("Allen Romo - Period 6", 140, 90);
        nameWriter.drawString("Braeden Drosche - Period 6", 120, 110);
    }

    /**
     * Draws the car on one lane of the highway, entering the United States
     * @param carDrawer reference to graphics container
     */


    public void drawCar(Graphics carDrawer) {

        carDrawer.setColor(new Color(179, 222, 192));

        // draws the car
        carDrawer.fillRect(bodyX, bodyY, width, height);

        carDrawer.setColor(Color.BLACK);
        carDrawer.drawOval(tireOneX, tireOneY, 10, 20);
        carDrawer.drawOval(tireTwoX, tireTwoY, 10, 20);
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

        component.animateCar();
    }
}