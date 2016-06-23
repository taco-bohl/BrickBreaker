/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Controls.KeyboardController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Tyler Bohl
 */
public class Paddle extends GameObject implements Moveable {
    private int width;
    private int height;
    private int speed;
    private Color color;
    private KeyboardController controller;
    
    public Paddle(int xPosition, int yPosition, int width, int height, int speed, Color color, KeyboardController controller)
    {
        super(xPosition, yPosition, color);
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
        this.controller = controller;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
        
    }
    
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    public Rectangle getBounds()
    {
         Rectangle bounds = new Rectangle(xPosition, yPosition, height, width);
         return bounds;
    }
    
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(xPosition, yPosition, height, width);
        
    }
    
    public void move()
    {
        
        if(controller.getKeyStatus(KeyEvent.VK_LEFT))
        {
            xPosition = xPosition - speed;
        }
        else if(controller.getKeyStatus(KeyEvent.VK_RIGHT))
        {
            xPosition = xPosition + speed;
        }
        
        
    }
}
