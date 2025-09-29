public class lab02
{
	public static void main(String[] args) 
	{
		// --- Equation 1 (index #4) ---
		double a4 = 3.56;
		double b4 = 1.02;
		double c4 = 3.0;
		double d4 = 2.43;

		double y4 = Math.cbrt(Math.tan(a4)) /
		(1 + (Math.sinh(b4) / Math.log(Math.abs(d4 + c4))));

		// --- Equation 2 (index #5) ---
		double a5 = 2.54;
		double b5 = 1.23;
		double c5 = -2.14;
		double d5 = -0.23;

		double y5 = 2 * Math.cos(Math.pow(a5, b5)) +
		Math.abs(Math.acos(-Math.sqrt(c5 / d5)));

		// --- Equation 3 (index #6) ---
		double a6 = -1.23;
		double b6 = -0.34;
		double c6 = 0.707;
		double d6 = 2.312;

		double y6 = 3 * ((Math.log10(Math.abs(b6 / a6))) +
		(Math.sqrt(Math.sin(c6) + Math.exp(d6))));

		// --- Results ---	
		System.out.println("Equation 1 (y4): " + y4);
		System.out.println("Equation 2 (y5): " + y5);
		System.out.println("Equation 3 (y6): " + y6);
	}
}

