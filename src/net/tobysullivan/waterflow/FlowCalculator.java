package net.tobysullivan.waterflow;

public final class FlowCalculator {
	private FlowCalculator() throws InstantiationException {
		throw new InstantiationException("This class cannon be instantiated.");
	}
	
	public static float calcRateOfFlow(SampleMeasurement[] samples) {
		if(samples == null) {
			throw new IllegalArgumentException("A provided sample is null");
		}
		
		float total = 0.0f;
		for(int i = 0; i < samples.length; i++) {
			total += calcRateForSample(samples[i]);
		}
		
		return total;
	}
	
	private static float calcRateForSample(SampleMeasurement sample) {
		if(sample == null) {
			throw new IllegalArgumentException("A provided sample is null");
		}
		
		return sample.getWidth() * sample.getDepth() * sample.getVelocity();
	}
}
