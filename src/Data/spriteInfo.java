package Data;

public class spriteInfo {
    // Fields
    private Vector2D v2d; // Private field to store x, y coordinates
    private String tag;   // Private field to store the tag

    // Constructor
    public spriteInfo(Vector2D v2d, String tag) {
        this.v2d = v2d;
        this.tag = tag;
    }

    // Methods
    public String getTag() {
        return tag;
    }

    public Vector2D getCoords() {
        return v2d;
    }

    public void setTag(String newTag) {
        this.tag = newTag; // Update the value of tag
    }

    public void setCoords(Vector2D newV2D) {
        this.v2d = newV2D; // Update the value of v2d
    }

    public void setCoords(int x, int y) {
        this.v2d = new Vector2D(x, y); // Overloaded method to set coordinates
    }

    public String toString() {
        // Return a formatted string representation of the object
        return "[" + v2d.getX() + ", " + v2d.getY() + ", " + tag + "]";
    }
}
