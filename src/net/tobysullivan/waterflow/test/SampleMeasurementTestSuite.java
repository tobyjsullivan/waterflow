package net.tobysullivan.waterflow.test;

import net.tobysullivan.waterflow.SampleMeasurement;

import org.junit.Test;

public class SampleMeasurementTestSuite {

	@Test
	public void testGetWidth() {
		float inWidth = 3.0f;
		
		SampleMeasurement m = new SampleMeasurement(inWidth, 0.0f, 0.0f);
		float outWidth = m.getWidth();
		
		assert(inWidth == outWidth);
	}

	@Test
	public void testGetDepth() {
		float inDepth = 0.54f;
		
		SampleMeasurement m = new SampleMeasurement(0.0f, inDepth, 0.0f);
		float outDepth = m.getWidth();
		
		assert(inDepth == outDepth);
	}
	
	@Test
	public void testGetVelocity() {
		float inVelocity = 3.2f;
		
		SampleMeasurement m = new SampleMeasurement(0.0f, 0.0f, inVelocity);
		float outVelocity = m.getVelocity();
		
		assert(inVelocity == outVelocity);
	}

}
