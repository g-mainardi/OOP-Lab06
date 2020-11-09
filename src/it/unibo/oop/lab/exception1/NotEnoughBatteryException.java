package it.unibo.oop.lab.exception1;

/**
 * Represents an exception occurring when a robot overcomes the capacity of
 * its battery.
 * 
 */
public class NotEnoughBatteryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -288979685441144222L;

    /**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "Can not move, battery is completely exhausted";
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
