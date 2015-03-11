/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.washburn.DaubechiesWaveletTransform;

import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Rob
 */
public class DaubWaveTransTest {
    
    public DaubWaveTransTest() {
    }

    /**
     * Test of DaubWaveTrans method, of class DaubWaveTrans.
     */
    @Test
    public void testDaubWaveTrans() {
        System.out.println("DaubWaveTrans");
        double[] input = {1,5,3,9,10,4,2,8};
        int limit = 3;
        double[] expResult = {14.849242404917478, -1.7423829615966238, 4.281088913245536, 0.08493649053890852, 3.630268251423492, 3.0872461698487106, -4.027788004768038, 4.381341395361317};
        double[] result = DaubWaveTrans.DaubWaveTrans(input, limit);
        Assert.assertArrayEquals(expResult, result,.001);
    }

    /**
     * Test of getCoeffs method, of class DaubWaveTrans.
     */
    @Test
    public void testGetCoeffs() {
        System.out.println("getCoeffs");
        
        double[] input = {1,5,3,9,10,4,2,8};
        int limit = 3;
        double[] expResult = {14.849242404917478};
        double[] result = DaubWaveTrans.getCoeffs(input, limit);
        Assert.assertArrayEquals(expResult, result,.001);

    }
    
}
