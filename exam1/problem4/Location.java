class Location
{
    private int x;
    private int y;

    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void shift(int x, int y)
    {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public Location clone() { return new Location(this.x, this.y); }

    public int getX() { return x; }
    public int getY() { return y; }
}