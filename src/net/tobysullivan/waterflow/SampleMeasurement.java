package net.tobysullivan.waterflow;

public class SampleMeasurement {
	/**
	 * This class represents a sample measurement as recorded from the field. Be sure to keep
	 * units consistent across inputs (this shouldn't be difficult if you are following standards)
	 * 
	 * @param width The width of this slice. These can vary from slice to slice.
	 * @param depth The measured depth for this sample slice
	 * @param velocity The measured velocity for this sample
	 */
	public SampleMeasurement(float width, float depth, float velocity) {
		this._width = width;
		this._depth = depth;
		this._velocity = velocity;
	}
	
	private float _width;
	public float getWidth() {
		return this._width;
	}
	
	private float _depth;
	public float getDepth() {
		return this._depth;
	}
	
	private float _velocity;
	public float getVelocity() {
		return this._velocity;
	}
}
