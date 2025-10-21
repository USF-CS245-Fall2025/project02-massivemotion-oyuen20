import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class MassiveMotion extends JPanel implements ActionListener {

    protected Timer tm;
    protected List<CelestialObject> objects; //Celestial Objects List.

    private int windowSizeX, windowSizeY; //Dimensions of Canvas
    private double genX, genY;
    private int bodySize, bodyVelocity;
    private Random rand = new Random();

    /*
     * The configuration from the properties file is read, and the list of celestial objects initialized, timer starts
     * @param String propFile for properties file
     */
    // public MassiveMotion(String propfile) {
    public MassiveMotion(String propFile) {
        Properties properties = new Properties();
        try(FileInputStream inputStream = new FileInputStream(propFile)){
            properties.load(inputStream);
        } catch (IOException e){
            System.out.println("Error loading properties.");
        }

        tm = new Timer(75, this); // TODO: Replace the first argument with delay with value from config file.

        String listType = properties.getProperty("list", "arraylist");

        // determines the correct List implementation to use based on property
        if (listType.equalsIgnoreCase("arraylist")){
            objects = new ArrayList<>();
        } else if (listType.equalsIgnoreCase("single")){
            objects = new LinkedList<>();
        } else if (listType.equalsIgnoreCase("double")){
            objects = new DoublyLinkedList<>();
        } else if (listType.equalsIgnoreCase("dummyhead")){
            objects = new DummyHeadLinkedList<>();
        } else{
            objects = new ArrayList<>();
        }

        // reading the values from properties file
        windowSizeX = Integer.parseInt(properties.getProperty("window_size_x", "1024"));
        windowSizeY = Integer.parseInt(properties.getProperty("window_size_y", "768"));
        genX = Double.parseDouble(properties.getProperty("gen_x", "0.06"));
        genY = Double.parseDouble(properties.getProperty("gen_y", "0.06"));
        bodySize = Integer.parseInt(properties.getProperty("body_size", "10"));
        bodyVelocity = Integer.parseInt(properties.getProperty("body_velocity", "3"));

        int starX = Integer.parseInt(properties.getProperty("star_position_x", "512"));
        int starY = Integer.parseInt(properties.getProperty("star_position_y", "384"));
        int starSize = Integer.parseInt(properties.getProperty("star_size", "30"));
        int starDx = Integer.parseInt(properties.getProperty("star_velocity_x", "0"));
        int starDy = Integer.parseInt(properties.getProperty("star_velocity_y", "0"));

        // The First Celestial Object in List is the star
        CelestialObject star = new CelestialObject(starX, starY, starSize, starDx, starDy);
        objects.add(star);

        int delay = Integer.parseInt(properties.getProperty("time_delay", "75"));
        tm = new Timer(delay, this);
        tm.start();
    }

    /*
     * The celestial objects are painted, with the star being red and comets black.
     * @param Graphics g for drawing
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i <objects.size(); i++){
            CelestialObject obj = objects.get(i);
            if(i == 0){ // Star
                g.setColor(Color.RED);
            } else { // Comets
                g.setColor(Color.BLACK);
            }
            g.fillOval(obj.x, obj.y, obj.size, obj.size);

        }
        tm.start();
    }

    /*
     * The position of celestial objects are changed by velocity.
     * If an object moves beyond the canvas boundaries, it's removed
     * @param actionevent for timer
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for(int i = 0; i < objects.size(); i++){
            CelestialObject obj = objects.get(i);
            obj.x += obj.dx;
            obj.y += obj.dy;
        }

        for(int i = 0; i < objects.size(); i++){
            CelestialObject obj = objects.get(i);
            if(obj.x < 0 || obj.x > windowSizeX || obj.y < 0 || obj.y > windowSizeY){
                objects.remove(i);
                i--;
            }
        }

        // randomizing new objects along the top and bottom of canvas
        if (rand.nextDouble() < genX) {
            int x = rand.nextInt(windowSizeX);
            int y;
            if (rand.nextBoolean()) {
                y = 0;
            } else {
                y = windowSizeY;
            }

            int dx = rand.nextInt(2 * bodyVelocity + 1) - bodyVelocity;
            int dy = rand.nextInt(2 * bodyVelocity + 1) - bodyVelocity;
            if (dx == 0) dx = 1;
            if (dy == 0) dy = 1;

            objects.add(new CelestialObject(x, y, bodySize, dx, dy));
        }

        // randomizing new objects along the left and right of canvas
        if (rand.nextDouble() < genY) {
            int y = rand.nextInt(windowSizeY);
            int x;
            if (rand.nextBoolean()) {
                x = 0;
            } else {
                x = windowSizeX;
            }

            int dx = rand.nextInt(2 * bodyVelocity + 1) - bodyVelocity;
            int dy = rand.nextInt(2 * bodyVelocity + 1) - bodyVelocity;
            if (dx == 0) dx = 1;
            if (dy == 0) dy = 1;

            objects.add(new CelestialObject(x, y, bodySize, dx, dy));
        }

        repaint();
    }

    /*
     * Main method initializes the simulation and reads file either from command line or from default properties file
     * @param String[] args for command-line argument
     */
    public static void main(String[] args) {
        System.out.println("Massive Motion starting...");

        if(args.length == 0){
            args = new String[]{"MassiveMotion.txt"};
        }
        // MassiveMotion mm = new MassiveMotion(args[0]);
        MassiveMotion mm = new MassiveMotion(args[0]);

        JFrame jf = new JFrame();
        jf.setTitle("Massive Motion");
        jf.setSize(mm.windowSizeX, mm.windowSizeY); // size from configuration
        jf.add(mm);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
