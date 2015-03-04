package edu.washburn.DaubechiesWaveletTransform;

import static java.lang.Math.sqrt;

/**
 *
 * @author Rob
 */
public class DaubWaveTrans {
private static final double SQRT3 = sqrt(3);

    public static double[] DaubWaveTrans(double[] input) {
// This function assumes that input.length=2^n, n>1
        double[] interp = new double[input.length];
        double[] diff = new double[input.length];
        //First step interpolates between even and odd elements of the series.
        for (int i = 0; i < (input.length)/2; i++) {
            interp[i]=input[2*i] + SQRT3 +input[2*i+1];
            }
        //Calculate difference between interpolation and actual value.
        diff[0] = input[1]-SQRT3/4*interp[0]-(SQRT3-2)/4 * interp[input.length/2-1];
        
        
        }
    }

}
