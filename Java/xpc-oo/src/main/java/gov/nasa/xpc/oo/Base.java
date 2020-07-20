package gov.nasa.xpc.oo;

import gov.nasa.xpc.XPlaneConnect;

public abstract class Base {
	
	protected XPlaneConnect xpc;

	public Base(XPlaneConnect xpc) {
		super();
		this.xpc = xpc;
	}
}
