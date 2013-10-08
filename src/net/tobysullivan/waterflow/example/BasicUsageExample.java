package net.tobysullivan.waterflow.example;

import net.tobysullivan.waterflow.FlowCalculator;
import net.tobysullivan.waterflow.SampleMeasurement;

public class BasicUsageExample {
	public static void main(String[] args) throws Exception{
		// It is up to you to determine units and be consistent.
		// For this example we will use metric measurements in meters and meters/second
	
		// This represents a sample we took. Sample slice widths were 0.40m and this one
		// measured 0.32m deep and had a velocity of 3.1m/s
		SampleMeasurement m1 = new SampleMeasurement(0.40f, 0.32f, 0.74f);
	
		// Build an array of sample measurements
		SampleMeasurement[] samples = new SampleMeasurement[] {
				// Add the sample we defined above
				m1,
				// The other 14 samples, including a group of 8 sub-samples for one area (identifiable by their smaller width)
				new SampleMeasurement(0.40f, 0.46f, 0.9f),
				new SampleMeasurement(0.40f, 0.86f, 1.1f),
				new SampleMeasurement(0.40f, 1.20f, 1.2f),
				new SampleMeasurement(0.40f, 1.10f, 1.1f),
				
				new SampleMeasurement(0.050f, 1.00f, 1.3f),
				new SampleMeasurement(0.050f, 0.94f, 1.8f),
				new SampleMeasurement(0.050f, 0.81f, 1.4f),
				new SampleMeasurement(0.050f, 0.70f, 1.0f),
				new SampleMeasurement(0.050f, 0.62f, 0.63f),
				new SampleMeasurement(0.050f, 0.58f, 0.45f),
				new SampleMeasurement(0.050f, 0.62f, 0.72f),
				new SampleMeasurement(0.050f, 0.56f, 1.2f),
				
				new SampleMeasurement(0.40f, 0.43f, 1.1f),
				new SampleMeasurement(0.40f, 0.29f, 0.84f)
			};
		
		// Before doing the actual rate of flow calculation, it is best practice to perform a sanity check on our samples.
		// The total width of our samples should add up to the known width of our body of water. In our example, the body of 
		// water was 3.2 meters at the sample site.
		// The complicated comparison here accounts for the bad rounding errors prevalent in java floats.
		if(Math.abs(FlowCalculator.calcTotalWidth(samples) - 3.2f) > 0.00001f) {
			throw new Exception("Bad sample width. Probably a sample was missed.");
		}
		
		// The actual rate calculation can be done in a single call
		float rateOfFlow = FlowCalculator.calcRateOfFlow(samples);
		
		System.out.println("The computed rate of flow is " + rateOfFlow + " cubic meters per second");
	}
}
