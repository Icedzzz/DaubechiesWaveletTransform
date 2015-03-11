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
        double[] output = new double[input.length];

        while(input.length > 1)  {
            double[] interp = new double[input.length / 2];
            double[] diff = new double[input.length / 2];
            //First step does interpolation between pairs of sequential elelments.
            //1,2; 2,3; 4,5 etc.
            for (int i = 0; i < input.length / 2; i++) {
                interp[i] = input[2 * i] + SQRT3 * input[2 * i + 1];
            }

            //Calculate weighted difference between input previous 2 interp values.
            //The pre-for loop line handles index 0 by wrapping around. 
            diff[0] = input[1] - SQRT3 / 4.0 * interp[0] - (SQRT3 - 2) / 4.0 * interp[input.length / 2 - 1];
            for (int i = 1; i < input.length / 2; i++) {
                diff[i] = input[2 * i + 1] - SQRT3 / 4.0 * interp[i] - (SQRT3 - 2) / 4.0 * interp[i - 1];
            }

            //Adjust interpolations towards the next difference value. (Correction)
            for (int i = 0; i < input.length / 2 - 1; i++) {
                interp[i] = interp[i] - diff[i + 1];
            }
            //Deal with final element correct by wrapping around. 
            //Overwrites previous entry.
            interp[input.length / 2 - 1] = interp[input.length / 2 - 1] - diff[0];

            //Normalize vectors.
            for (int i = 0; i < input.length / 2; i++) {
                interp[i] = (SQRT3 - 1) / SQRT2 * interp[i];
            }
            for (int i = 0; i < input.length / 2; i++) {
                diff[i] = (SQRT3 + 1) / SQRT2 * diff[i];
            }
//        System.out.println();
//        System.out.println(Arrays.toString(interp));
//        System.out.println(Arrays.toString(diff));
            System.arraycopy(interp, 0, output, 0, input.length / 2);
            System.arraycopy(diff, 0, output, input.length / 2, input.length / 2);

            //Set input equal to the remaining coefficients for next round.
            input = interp;

        }
        return output;

    }
}
