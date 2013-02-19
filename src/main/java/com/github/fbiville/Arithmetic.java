package com.github.fbiville;

import static java.lang.Math.log;

public class Arithmetic {

   public static double log2(double d) {
      return log(d) * 1.4426950408889634D;
   }

   public static boolean isPowerOf2(double d) {
      double powerOf2 = log2(d);
      return (powerOf2 - (long) powerOf2) == 0;
   }
}
