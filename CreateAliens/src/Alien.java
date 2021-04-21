public abstract class Alien
{
    protected int eyes;
    protected int limbs;
    protected String name;

    public Alien(int eyes, int limbs, String name)
    {
        this.eyes = eyes;
        this.limbs = limbs;
        this.name = name;
    }

    public String toString()
    {
        return "Alien " + name + " has " + eyes + " eyes and " + limbs + " limbs.";
    }
}
