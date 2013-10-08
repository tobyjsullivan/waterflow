package net.tobysullivan.waterflow.example;

import java.util.ArrayList;

import net.tobysullivan.waterflow.FlowCalculator;
import net.tobysullivan.waterflow.SampleMeasurement;

public class BasicUsageExample {
	public static void main(String[] args) {
		// It is up to you to determine units and be consistent.
		// For this example we will use metric measurements in meters
		
		// Input the sample measurements
		ArrayList<SampleMeasurement> samples = new ArrayList<SampleMeasurement>();
		
		// This represents a sample we took. Sample slice widths were 0.40m and this one
		// measured 0.32m deep and had a velocity of 3.1m/s
		SampleMeasurement m1 = new SampleMeasurement(0.40f, 0.32f, 2.7f);
		samples.add(m1);
		
		// The other 14 samples, including a group of 8 sub-samples for one area
		samples.add(new SampleMeasurement(0.40f, 0.46f, 2.9f));
		samples.add(new SampleMeasurement(0.40f, 0.86f, 3.1f));
		samples.add(new SampleMeasurement(0.40f, 1.20f, 3.2f));
		samples.add(new SampleMeasurement(0.40f, 1.10f, 3.1f));

		samples.add(new SampleMeasurement(0.050f, 1.00f, 3.3f));
		samples.add(new SampleMeasurement(0.050f, 0.94f, 3.8f));
		samples.add(new SampleMeasurement(0.050f, 0.81f, 3.4f));
		samples.add(new SampleMeasurement(0.050f, 0.70f, 3.0f));
		samples.add(new SampleMeasurement(0.050f, 0.62f, 2.6f));
		samples.add(new SampleMeasurement(0.050f, 0.58f, 2.4f));
		samples.add(new SampleMeasurement(0.050f, 0.62f, 2.7f));
		samples.add(new SampleMeasurement(0.050f, 0.56f, 3.2f));
		
		samples.add(new SampleMeasurement(0.40f, 0.43f, 3.1f));
		samples.add(new SampleMeasurement(0.40f, 0.29f, 2.8f));
		
		// Build an array of our samples
		SampleMeasurement[] sampleArray = new SampleMeasurement[samples.size()];
		samples.toArray(sampleArray);
		
		float rateOfFlow = FlowCalculator.calcRateOfFlow(sampleArray);
		
		System.out.println("The computed rate of flow is " + rateOfFlow + " cubic meters per second");
	}
}
