package lab03;

/**
 * Lab 03
 * Three tasks in one file, each implemented as a static inner class.
 *
 * @author MahshirKesher
 */
public class lab03 
{
	/**
     * ========== GLOBAL MAIN ==========
     * Runs all three tasks consecutively with basic sample arguments.
     */
	public static void main(String[] args) 
	{
		Task1 test = new Task1();

		System.out.println("=== Running Task 1 ===");
		test.printResults(2, 8, 5);	
		test.printResults(1, 4, 30);	
		
		System.out.println("\n=== Running Task 2 ===");
		Task2.printResults(5, 3);
		Task2.printResults(4, 2);
		
		System.out.println("\n=== Running Task 3 ===");
		Task3.printResults(1e-3);
		Task3.printResults(1e-6);
	}

/**
* ========== TASK 1 ==========
* Sum:
*   S = Σ sqrt(a * i * sqrt(b / i)), i=1..k , k <= 30
*/
	public static class Task1 
	{
		public static void main(String[] args) 
		{
			printResults(2, 8, 5);   // normal case
			printResults(1, 4, 30);  // upper bound
			printResults(1, 4, 31);  // exception, k > 30
			printResults(-1, 4, 10); // exception, a < 0
			printResults(2, -3, 10); // exception, b < 0
		}
	
		private static double calculateSum(double a, double b, int k) 
		{
			if (a < 0 || b < 0 || k <= 0 || k > 30) 
			{
				throw new IllegalArgumentException("Invalid arguments: a=" + a + ", b=" + b + ", k=" + k);
			}

			double sum = 0;
			for (int i = 1; i <= k; i++) 
			{
				sum += Math.sqrt(a * i * Math.sqrt(b / i));
			}
			return sum;
		}

		public static void printResults(double a, double b, int k) 
		{
			System.out.print("Task1 -> a:" + a + " b:" + b + " k:" + k + " result: ");
		
			try
			{
				System.out.println(calculateSum(a, b, k));
			}
			
			catch (IllegalArgumentException e) 
			{
				System.out.println("EXCEPTION! " + e.getMessage());
			}
		}
	}

/**
* ========== TASK 2 ==========
* Function:
*   x(t,l) = Σ (sqrt(t*l), if l odd; l/sqrt(t), if l even), i=1..t
*/
	public static class Task2 
	{
		public static void main(String[] args) 
		{
			printResults(5, 3);   // odd l
			printResults(4, 2);   // even l
			printResults(0, 2);   // exception, t <= 0
			printResults(3, -1);  // exception, l <= 0
		}
	
		public static double x(int t, int l) 
		{
			if (t <= 0 || l <= 0) 
			{
				throw new IllegalArgumentException("Invalid arguments: t=" + t + ", l=" + l);
			}
	
			double term;
			if (l % 2 == 1) 
			{
				term = Math.sqrt(t * l); //odd l
			} 
			else 
			{
				term = l / Math.sqrt(t); //even l
			}
	
			double sum = 0;
			for (int i = 1; i <= t; i++) 
			{
				sum += term;
			}
			return sum;
	}
	
		static void printResults(int t, int l) 
		{
			System.out.print("Task2 -> t:" + t + " l:" + l + " result: ");
			try 
			{
				System.out.println(x(t, l));
			} 
			
			catch (IllegalArgumentException e) 
			{
				System.out.println("EXCEPTION! " + e.getMessage());
			}
		}
	}
	
/**
* ========== TASK 3 ==========
* Infinite sum:
*   S = Σ [ (-2)^i / (i!(i+1)) ], i=0..∞
* Stop when |next term| < epsilon
*/
	public static class Task3 
	{
		public static void main(String[] args) 
		{
			printResults(1e-3);
			printResults(1e-6);
			printResults(1e-10);
			printResults(-0.5); // exception, epsilon <= 0
		}
	
		public static double infiniteSum(double epsilon) 
		{
			if (epsilon <= 0) 
			{
				throw new IllegalArgumentException("Epsilon must be > 0, got " + epsilon);
			}
	
			double sum = 0;
			int i = 0;
			while (true) 
			{
				double term = Math.pow(-2, i) / (factorial(i) * (i + 1));
				if (Math.abs(term) < epsilon) break;
				sum += term;
				i++;
			}
			return sum;
		}

		private static double factorial(int n)
		{
			double result = 1;
			for (int i = 2; i <= n; i++)
			{
				result *= i;
			}
			return result;
		}

		static void printResults(double epsilon)
		{
			System.out.print("Task3 -> epsilon:" + epsilon + " result: ");
			try
			{
				System.out.println(infiniteSum(epsilon));
			}

			catch (IllegalArgumentException e)
			{
				System.out.println("EXCEPTION! " + e.getMessage());
			}
		}
	}
}
