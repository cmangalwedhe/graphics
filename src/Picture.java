/**
 * @author Chinmay Mangalwedhe, Allen Romo, Braeden Drosche
 */

// import statements needed for project
import java.awt.*;
import javax.swing.*;

public class Picture extends JPanel {

    private static final Color groundColor = new Color(152, 182, 142);
    private static final Color roadColor = new Color(79, 78, 78);
    private static final Color signColor = new Color(77, 101, 72);

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

    }

    /**
     * Draws the road as a triangle to show perspective and a little bit of 3D art
     * @param roadDrawer a reference to the graphics container
     * @param xPts an array of x coordinates to draw the road
     * @param yPts an array of y coordinates to draw the road
     */

    public void drawRoad(Graphics roadDrawer, int[] xPts, int[] yPts) {
        // draws the road as a triangle and sets the color of the road
        roadDrawer.setColor(roadColor);

        Polygon mainRoad = new Polygon(xPts, yPts, 3);
        roadDrawer.fillPolygon(mainRoad);
    }

    /**
     * Draws the road divider for the road to distinguish the lanes
     * @param roadDividerDrawer a reference to the graphics container
     */

    public void drawRoadDivider(Graphics roadDividerDrawer) {
        // make road divider color yellow and draw divider
        roadDividerDrawer.setColor(new Color(177, 169, 50));
        for (int i = 10; i < 585; i+= 30) {
            roadDividerDrawer.fillRect(398, i, 5, 12);
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

    /**
     * Draws the ground
     * @param g The graphics reference to the container
     * @param xPos An array of x points for the ground to be drawn
     * @param yPos An array of y points for the ground to be drawn
     */
    public void drawGround(Graphics g, int[] xPos, int[] yPos) {
        // draws remaining shapes as the color of the ground
        g.setColor(groundColor);

        Polygon ground = new Polygon(xPos, yPos, 3);
        g.fillPolygon(ground);
    }

    /**
     * Draws the road sign showing the exit
     * @param g The reference variable from the graphics container
     */
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

    /**
     * Draws the sun and the lining of the sun
     * @param g The reference variable from the graphics variable
     */

    public void drawSun(Graphics g) {
        // draw the sun
        g.setColor(new Color(241, 197, 109));
        g.fillArc(25, -50, 100, 100, 0, -180);

        // draw the sun lining
        g.setColor(new Color(255, 129, 0));
        g.drawArc(25, -50, 100, 100, 0, -180);
    }

    /**
     * Draws a welcome to the US sign
     * @param g A reference to the graphics container
     */
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
        g.drawString("Please continue straight towards customs", 20, 170);
        g.drawString("Exit 12B is last stop before entering USA", 25, 190);

        // draws nearby cities and directions
        g.setFont(new Font("Clearview", Font.BOLD, 12));
        g.drawString("New York, NY: 90 mi", 60, 220);
        g.drawString("Boston, MA: 270 mi", 60, 240);
        g.drawString("Houston, TX: 2,724 mi", 55, 260);
    }

    /**
     * Writes the name of all people in the group on the screen
     * @param nameWriter a reference to the graphics container
     */

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