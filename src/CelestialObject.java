/*
* Celestial Objects represent either a star or comet in the simulation.
* Each object has position, size, and velocity.
*/

public class CelestialObject {
    int x, y;
    int size;
    int dx, dy;

    /**
     * Constructs a CelestialObject within the specified parameters.
     *
     * @param x     the x-coordinate of the object
     * @param y     the y-coordinate of the object
     * @param size  the size of the object
     * @param dx    the velocity in the x-direction
     * @param dy    the velocity in the y-direction
     */
    public CelestialObject(int x, int y, int size, int dx, int dy){
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = dx;
        this.dy = dy;
    }
}
