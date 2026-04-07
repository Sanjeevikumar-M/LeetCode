class Robot {

    int width, height;
    int perimeter;
    int pos;
    boolean moved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
        this.pos = 0;
        this.moved = false;
    }

    public void step(int num) {

        int move = num % perimeter;

        if (num > 0) moved = true;

        pos = (pos + move) % perimeter;
    }

    public int[] getPos() {
        int x, y;

        if (pos < width) {
            x = pos;
            y = 0;
        } 
        else if (pos < width + height - 1) {
            x = width - 1;
            y = pos - (width - 1);
        } 
        else if (pos < 2 * width + height - 2) {
            x = (width - 1) - (pos - (width + height - 2));
            y = height - 1;
        } 
        else {
            x = 0;
            y = (height - 1) - (pos - (2 * width + height - 3));
        }

        return new int[]{x, y};
    }

    public String getDir() {

        if (pos == 0) {
            return moved ? "South" : "East";
        }

        if (pos < width) return "East";
        else if (pos < width + height - 1) return "North";
        else if (pos < 2 * width + height - 2) return "West";
        else return "South";
    }
}