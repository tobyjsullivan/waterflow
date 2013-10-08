package net.tobysullivan.waterflow.test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.tobysullivan.waterflow.FlowCalculator;
import net.tobysullivan.waterflow.SampleMeasurement;

import org.junit.Test;

public class FlowCalculatorTestSuite {

	@Test
	public void testCalcRateOfFlow_SingleMeasurement() {
		float width = 1.2f;
		float depth = 2.4f;
		float velocity = 3.2f;
		
		float expectedResult = 9.216f;
		
		SampleMeasurement m = new SampleMeasurement(width, depth, velocity);
		
		float result = FlowCalculator.calcRateOfFlow(new SampleMeasurement[] {m});
		
		assertEquals(expectedResult, result, 0.0001);
	}

	@Test
	public void testCalcRateOfFlow_TwoMeasurements() {
		SampleMeasurement m1 = new SampleMeasurement(1.2f, 2.4f, 3.2f);
		SampleMeasurement m2 = new SampleMeasurement(1.8f, 3.2f, 2.9f);
		
		float expectedResult = 25.920f;
		
		float result = FlowCalculator.calcRateOfFlow(new SampleMeasurement[] {m1, m2});
		
		assertEquals(expectedResult, result, 0.0001);
	}

	@Test
	public void testCalcRateOfFlow_NoMeasurements() {
		
		float result = FlowCalculator.calcRateOfFlow(new SampleMeasurement[] { });
		
		assertEquals(0.0f, result, 0.0001);
	}
	
	/**
	 * This test checks that an exception is thrown when null is passed in
	 * instead of the array of samples
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCalcRateOfFlow_NullSampleArray() {
		SampleMeasurement[] samples = null;
		
		FlowCalculator.calcRateOfFlow(samples);
	}
	
	/**
	 * This test checks that an exception is thrown when one of the provided samples is null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCalcRateOfFlow_OneNullSample() {
		SampleMeasurement[] samples = new SampleMeasurement[] {
				new SampleMeasurement(0.3f, 1.2f, 4.3f),
				null,
				new SampleMeasurement(0.93f, 3.3f, 4.0f)
			};
		
		FlowCalculator.calcRateOfFlow(samples);
	}
	
	@Test
	public void testCalcTotalWidth_OneMeasurement() {
		SampleMeasurement m = new SampleMeasurement(4.3f, 2.2f, 6.4f);
		
		float result = FlowCalculator.calcTotalWidth(new SampleMeasurement[] { m });
		
		assertEquals(4.3f, result, 0.0001);
	}
	
	@Test
	public void testCalcTotalWidth_TwoMeasurements() {
		SampleMeasurement m1 = new SampleMeasurement(4.3f, 2.2f, 6.4f);
		SampleMeasurement m2 = new SampleMeasurement(2.6f, 3.3f, 0.0f);
		
		float result = FlowCalculator.calcTotalWidth(new SampleMeasurement[] { m1, m2 });
		
		assertEquals(6.9f, result, 0.0001);
	}
	
	@Test
	public void testCalcTotalWidth_NoMeasurements() {
		float result = FlowCalculator.calcTotalWidth(new SampleMeasurement[] {  });
		
		assertEquals(0.0f, result, 0.0001);
	}
	
	/**
	 * This test checks that an exception is thrown when null is passed in
	 * instead of the array of samples
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCalcTotalWidth_NullSampleArray() {
		SampleMeasurement[] samples = null;
		
		FlowCalculator.calcTotalWidth(samples);
	}
	
	/**
	 * This test checks that an exception is thrown when one of the provided samples is null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCalcTotalWidth_OneNullSample() {
		SampleMeasurement[] samples = new SampleMeasurement[] {
				new SampleMeasurement(0.3f, 1.2f, 4.3f),
				null,
				new SampleMeasurement(0.93f, 3.3f, 4.0f)
			};
		
		FlowCalculator.calcTotalWidth(samples);
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
