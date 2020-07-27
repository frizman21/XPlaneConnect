package gov.nasa.xpc.oo;

import gov.nasa.xpc.XPlaneConnect;

public abstract class Base {
	
	protected XPlaneConnect xpc;
	protected Aircraft aircraft;

	public Base(XPlaneConnect xpc, Aircraft aircraft) {
		super();
		this.xpc = xpc;
		this.aircraft = aircraft;
	}
}
