/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instigatemobile.wargame;

import java.awt.Point;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author areg.gareginyan
 */
public class GameObjectTest {
    
    Point position = new Point(20, 20);
    Point velocity = new Point(10, 10);
    int size = 10;
    private GameObject object;
    
    private void initialize() {
        object = new GameObject(position, velocity, size);
    }
    
    @Test
    public void testConstructor() {
        initialize();
        assertEquals(position, object.getPosition());
        assertEquals(velocity, object.getVelocity());
        assertEquals(size, object.getSize());
    }
    
    @Test
    public void testMove() {
        initialize();
        object.move(10);
        Point expectedPosition = new Point(120, 120);
        assertEquals(expectedPosition, object.getPosition());
    }
    
    @Test
    public void testNoMove() {
        initialize();
        object.move(0);
        assertEquals(position, object.getPosition());
    }
}
