package gov.nasa.xpc.oo;

public class Position {
	public double x,y,z;
	
	public Position(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Position(double[] posi) {
		this(posi[0],posi[1],posi[2]);
	}
	
	public double distance(Position pos) {
        double x1 = Math.toRadians(this.x);
        double y1 = Math.toRadians(this.y);
        double x2 = Math.toRadians(pos.x);
        double y2 = Math.toRadians(pos.y);

       /*************************************************************************
        * Compute using Haversine formula
        *************************************************************************/
        double a = Math.pow(Math.sin((x2-x1)/2), 2)
                 + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2-y1)/2), 2);

        // great circle distance in radians
        double angle2 = 2 * Math.asin(Math.min(1, Math.sqrt(a)));

        // convert back to degrees
        angle2 = Math.toDegrees(angle2);

        // each degree on a great circle of Earth is 60 nautical miles
        double distance2 = 60 * angle2;

        System.out.println(distance2 + " nautical miles");
        
        return distance2;
	}
	
    /**
     * Copied from OpenMap function by the same name.
     * 
     * Calculate spherical azimuth between two points with double precision.
     * <p>
     * Computes the azimuth `Az' east of north from phi1, lambda0 bearing toward
     * phi and lambda. (5-4b). (-PI &lt;= Az &lt;= PI).
     * <p>
     * 
     * @param phi1 latitude in radians of start point
     * @param lambda0 longitude in radians of start point
     * @param phi latitude in radians of end point
     * @param lambda longitude in radians of end point
     * @return float azimuth east of north `Az'
     * 
     */
    final public static double sphericalAzimuth(double phi1, double lambda0, double phi,
                                                double lambda) {
        double ldiff = lambda - lambda0;
        double cosphi = Math.cos(phi);

        return Math.atan2(cosphi * Math.sin(ldiff), (Math.cos(phi1) * Math.sin(phi) - Math.sin(phi1)
                * cosphi * Math.cos(ldiff)));
    }
	
	public double bearing(Position pos) {
		
		double brng = Math.toDegrees(
				 sphericalAzimuth(
				   Math.toRadians(this.x),
				   Math.toRadians(this.y),
				   Math.toRadians(pos.x),
				   Math.toRadians(pos.y)
				 )
			   );	
		brng = (brng + 360) % 360;
		return brng;
	}
}
