package Buoi1;
class Battery
{
    private int energy=0;
    public int getEnergy()
    {
        return this.energy;
    }
    
    public void setEnergy(int energy1)
    {
        this.energy=energy1;
    }
    public void decreaseEnergy()
    {
        if (energy>0)
        energy=energy-10;
        System.out.println(energy);
    }
    public Battery()
    {
        this.energy=100;
    }
}