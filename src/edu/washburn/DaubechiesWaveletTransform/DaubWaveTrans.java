package edu.washburn.DaubechiesWaveletTransform;

import static java.lang.Math.sqrt;
import java.util.Arrays;

/**
 *
 * @author Rob
 */
public class DaubWaveTrans {

    private static final double SQRT3 = sqrt(3);
    private static final double SQRT2 = sqrt(2);

    public static double[] DaubWaveTrans(double[] input) {
// This function assumes that input.length=2^n, n>1
        int size = input.length;
        double[] interp = new double[size];
        double[] diff = new double[size];
        //First step does interpolation between pairs of sequential elelments.
        //1,2; 2,3; 4,5 etc.
        for (int i = 0; i < size / 2; i++) {
            interp[i] = input[2 * i] + SQRT3 * input[2 * i + 1];
        }

        //Calculate weighted difference between input previous 2 interp values.
        //The pre-for loop line handles index 0 by wrapping around. 
        diff[0] = input[1] - SQRT3 / 4.0 * interp[0] - (SQRT3 - 2) / 4.0 * interp[size / 2 - 1];
        for (int i = 1; i < size / 2; i++) {
            diff[i] = input[2 * i + 1] - SQRT3 / 4.0 * interp[i] - (SQRT3 - 2) / 4.0 * interp[i - 1];
        }

        //Adjust interpolations towards the next difference value. (Correction)
        for (int i = 0; i < size / 2 - 1; i++) {
            interp[i] = interp[i] - diff[i + 1];
        }
        //Deal with final element correct by wrapping around. 
        //Overwrites previous entry.
        interp[size / 2 - 1] = interp[size / 2 - 1] - diff[0];

        //Normalize vectors.
        for (int i = 0; i < size / 2; i++) {
            interp[i] = (SQRT3 - 1) / SQRT2 * interp[i];
        }
        for (int i = 0; i < size / 2; i++) {
            diff[i] = (SQRT3 + 1) / SQRT2 * diff[i];
        }
        System.out.println();
        System.out.println(Arrays.toString(interp));
        System.out.println(Arrays.toString(diff));
        double[] retarr = new double[size];
        System.arraycopy(interp, 0, retarr, 0, size / 2);
        System.arraycopy(diff, 0, retarr, size / 2, size / 2);
        System.out.println(Arrays.toString(retarr));

        return retarr;

    }

}
