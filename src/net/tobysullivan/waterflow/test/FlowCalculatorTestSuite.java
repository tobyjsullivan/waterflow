package net.tobysullivan.waterflow.test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.tobysullivan.waterflow.FlowCalculator;
import net.tobysullivan.waterflow.SampleMeasurement;

import org.junit.Test;

public class FlowCalculatorTestSuite {

	@Test
	public void testSingleMeasurement() {
		float width = 1.2f;
		float depth = 2.4f;
		float velocity = 3.2f;
		
		float expectedResult = 9.216f;
		
		SampleMeasurement m = new SampleMeasurement(width, depth, velocity);
		
		float result = FlowCalculator.calcRateOfFlow(new SampleMeasurement[] {m});
		
		assertEquals("1.2 * 2.4 * 3.2 must be 9.216", expectedResult, result, 0.0001);
	}

	@Test
	public void testTwoMeasurements() {
		SampleMeasurement m1 = new SampleMeasurement(1.2f, 2.4f, 3.2f);
		SampleMeasurement m2 = new SampleMeasurement(1.8f, 3.2f, 2.9f);
		
		float expectedResult = 25.920f;
		
		float result = FlowCalculator.calcRateOfFlow(new SampleMeasurement[] {m1, m2});
		
		assertEquals("The resulting rate of flow must be 25.920", expectedResult, result, 0.0001);
	}
	
	/**
	 * This test checks that an exception is thrown when null is passed in
	 * instead of the array of samples
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullSampleArray() {
		SampleMeasurement[] samples = null;
		
		FlowCalculator.calcRateOfFlow(samples);
	}
	
	/**
	 * This test checks that an exception is thrown when one of the provided samples is null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testOneNullSample() {
		SampleMeasurement[] samples = new SampleMeasurement[] {
				new SampleMeasurement(0.3f, 1.2f, 4.3f),
				null,
				new SampleMeasurement(0.93f, 3.3f, 4.0f)
			};
		
		FlowCalculator.calcRateOfFlow(samples);
	}
	
	@Test(expected = InvocationTargetException.class)
	public void testClassNotInstantiable() throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
		final Class<?> cls = FlowCalculator.class;
	    final Constructor<?> c = cls.getDeclaredConstructors()[0];
	    c.setAccessible(true);

	    try {
	    c.newInstance();
	    } catch (InvocationTargetException ex) {
	    	assertEquals(InstantiationException.class, ex.getCause().getClass());
	    	throw ex;
	    }
	}
}
