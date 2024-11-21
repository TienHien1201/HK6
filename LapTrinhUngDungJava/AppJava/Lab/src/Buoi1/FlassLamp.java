package Buoi1;

class FlashLamp
{
    private Battery battery;
    public boolean status=false; /*den tắt*/
    
    public void setBattery(Battery battery)
    {
        this.battery=battery;
    }
    public Battery getBattery()
    {
        return this.battery;
    }
    
    public void light()
    {
        if ((battery!=null)&&(battery.getEnergy()>0))
        {
        status=true;
        battery.decreaseEnergy();
        }
    }
    
    public void TurnOn()
    {
        if (status==false)
        light();
        
    }
    public void TurnOff()
    {
        status=false;
    }
    
}
