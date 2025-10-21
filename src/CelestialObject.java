/*
* Celestial Objects represent either a star or comet in the simulation.
* Each object has position, size, and velocity.
*/

public class CelestialObject {
    int x, y;
    int size;
    int dx, dy;

    public CelestialObject(int x, int y, int size, int dx, int dy){
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = dx;
        this.dy = dy;
    }
}
