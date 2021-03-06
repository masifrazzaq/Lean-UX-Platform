package com.uclab.ER.audio.featureExtraction;

import java.util.Arrays;

/**
 * This Class is statistical function for extract statistical features such as mean, stddev, etc.
 * @author Jaehun Bang
 *
 */

public class StatisticalFunction  {
	
	/**
	 * No Define
	 */
	public Object extractFeature(Object input) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/***
	 * Extract Average
	 * @param doubles
	 * @return double
	 */
	
	public double getMean(double[] doubles) {
		double result = 0;
		for (int i = 0; i < doubles.length; i++) {
			result = result + doubles[i];
		}
		result = result / doubles.length;
		return result;
	}
	public double getSum(double[] doubles) {
		double result = 0;
		for (int i = 0; i < doubles.length; i++) {
			result = result + doubles[i];
		}
		return result;
	}
	/**
	 * Normalize Data
	 * @param doubles
	 * @return double[]
	 */

	public double[] normalization(double[] doubles) {
		double[] result = new double[doubles.length];
		double mean = getMean(doubles);
		double diff = 0;
		double sum = 0;
		double Var = 0;
		for (int i = 0; i < doubles.length; i++) {
			diff = doubles[i] - mean;
			sum += (diff * diff);
		}
		Var = sum / doubles.length;

		for (int i = 0; i < doubles.length; i++) {
			result[i] = (doubles[i] - mean) / Var;
		}
		return result;
	}
	/**
	 * Extract Standard Deviation
	 * @param doubles
	 * @return double
	 */

	public double getStdDev(double[] doubles) {
		double result = 0;
		double mean = getMean(doubles);
		double diff = 0;
		double sum = 0;
		for (int i = 0; i < doubles.length; i++) {
			diff = doubles[i] - mean;
			sum += (diff * diff);
		}
		result = Math.sqrt(sum / doubles.length - 0);
		return result;
	}
	
	/**
	 * Extract Range
	 * @param doubles
	 * @return
	 */
	
	public double getRange(double[] doubles){
		
		return getMax(doubles) - getMin(doubles);
	}
	
	/**
	 * Extract Minimum
	 * @param doubles
	 * @return double
	 */

	public double getMin(double[] doubles) {
		Arrays.sort(doubles);
		return doubles[0];
	}
	/**
	 * Extract Maximum
	 * @param doubles
	 * @return double
	 */

	public double getMax(double[] doubles) {
		Arrays.sort(doubles);
		return doubles[doubles.length - 1];
	}
	
	/**
	 * Extract Energy
	 * @param doubles
	 * @return double[]
	 */

	public double[] getEnergy(double[] doubles) {
		double[] result = new double[doubles.length];
		for (int i = 0; i < doubles.length; i++) {
			result[i] = (doubles[i] * doubles[i]);
		}
		return result;
	}
	/**
	 * Extract Energy Average
	 * @param doubles
	 * @return double
	 */

	public double getEnergyMean(double[] doubles) {
		double[] energy = getEnergy(doubles);
		return getMean(energy);
	}
	public double getEnergySum(double[] doubles) {
		double[] energy = getEnergy(doubles);
		return getSum(energy);
	}
	/**
	 * Extract Energy Standard Deviation
	 * @param doubles
	 * @return double
	 */

	public double getEnergyStdDev(double[] doubles) {
		double[] energy = getEnergy(doubles);
		return getStdDev(energy);
	}
	/**
	 * Extract Energy Maximum
	 * @param doubles
	 * @return double
	 */

	public double getEnergyMax(double[] doubles) {
		double[] energy = getEnergy(doubles);
		Arrays.sort(energy);
		return energy[energy.length - 1];
	}

	/**
	 * Extract Energy Median
	 * @param doubles
	 * @return double
	 */
	public double getEnergyMedian(double[] doubles) {
		double[] energy = getEnergy(doubles);
		return getMedian(energy);

	}
	/**
	 * Extract Median
	 * @param doubles
	 * @return double
	 */

	public double getMedian(double[] doubles) {
		if (doubles.length == 0)
			return Double.NaN;
		int center = doubles.length / 2;

		if (doubles.length % 2 == 1) {
			return doubles[center];
		} else {
			return (doubles[center - 1] + doubles[center]) / 2.0;
		}
	}
	public double getCorrelation(double[] signalA, double[] signalB, int len)
	{
		double meanX = 0;
		double meanY = 0;
		double stdX = 0;
		double stdY = 0;
		double corr = 0;
		for (int i = 0;i < len;i++)
		{
			meanX += signalA[i];
			meanY += signalB[i];
		}
		meanX /= len;
		meanY /= len;
		for (int i = 0;i < len;i++)
		{
			stdX += (signalA[i] - meanX) * (signalA[i] - meanX);
			stdY += (signalB[i] - meanY) * (signalB[i] - meanY);
		}		
		stdX /= (len - 1);
		stdY /= (len - 1);
		stdX = Math.sqrt(stdX);
		stdY = Math.sqrt(stdY);
		for (int i = 0;i < len;i++)
		{
			corr += (signalA[i] - meanX) * (signalB[i] - meanY);
		}
		corr /= len;
		corr /= stdX * stdY;
		return corr;
	}
	 
	public double getMeanCrossing(double[] signal) {
	      double crossing = 0;
	      double mean = 0;
	      mean = getMean(signal);
	      for (int i = 0; i < signal.length - 1; i++) {
	         if ((signal[i] - mean) * (signal[i + 1] - mean) < 0)
	            crossing += 1;
	      }
	      crossing /= signal.length;

	      return crossing;
	   }
	public double getZeroCrossing(double[] signal) {
	      double crossing = 0;
	      double mean = 0;
	      for (int i = 0; i < signal.length - 1; i++) {
	         if ((signal[i] - mean) * (signal[i + 1] - mean) < 0)
	            crossing += 1;
	      }
	      crossing /= signal.length;

	      return crossing;
	   }

	

}
