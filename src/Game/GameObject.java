/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Tyler Bohl
 */
public abstract class GameObject implements Drawable {
    protected int xPosition;
    protected int yPosition;
    protected Color color;

    
    public GameObject(int xPosition, int yPosition, Color color)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }
    
    public abstract Rectangle getBounds();
    
    public int getXPosition()
    {
        return xPosition;
    }
    public void setXPosition(int xPosition)
    {
        this.xPosition = xPosition;
    }
    
    public int getYPosition()
    {
        return yPosition;
    }
    public void setYPosition(int yPosition)
    {
        this.yPosition = yPosition;
    }
    
    public Color getColor()
    {
        return color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public boolean isColliding(GameObject other)
    {
        return (this.getBounds().intersects(other.getBounds()));
   
    }
}
