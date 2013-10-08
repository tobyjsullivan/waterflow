package net.tobysullivan.waterflow;

/**
 * This class provides static methods for computing the rate of flow of a body of water
 * based on sample data collected from the field.
 */
public final class FlowCalculator {
	/**
	 * This method calculates the rate of flow of a body of water based on
	 * measurement data from a series of samples from a cross-section of the water body.
	 * @param samples An array of samples that span the full section for which flow is being
	 * calculated. Usually these will span the full width of the body of water
	 * @return The rate of flow
	 */
	public static float calcRateOfFlow(SampleMeasurement[] samples) {
		if(samples == null) {
			throw new IllegalArgumentException("A provided sample is null");
		}
		
		// The rate of flow is the sum of the flows of each sample
		float total = 0.0f;
		for(int i = 0; i < samples.length; i++) {
			// Calculate the rate of flow for the current sample and add it to the total
			total += calcRateForSample(samples[i]);
		}
		
		return total;
	}
	
	private static float calcRateForSample(SampleMeasurement sample) {
		if(sample == null) {
			throw new IllegalArgumentException("A provided sample is null");
		}
		
		// Rate of flow is calculated as AREA x VELOCITY
		return sample.getWidth() * sample.getDepth() * sample.getVelocity();
	}

	/**
	 * We don't want people instantiating this class as that is not intended
	 * @throws InstantiationException
	 */
	private FlowCalculator() throws InstantiationException {
		throw new InstantiationException("This class cannon be instantiated.");
	}
}
