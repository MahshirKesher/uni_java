public class test
{
	public static void main(String[] args)
	{
		test checkout = new test();

		checkout.sum_print(2, 8, 5);
	}

	private double sum_addElement(double a, double b, int i)
	{
		double element = Math.sqrt(a * i * Math.sqrt(b / i));
		return element;
	}

	private double sum_calculate(double a, double b, int k)
	{
		if (a < 0 || b < 0 || k <= 0 || k > 30)
		{
			throw new IllegalArgumentException("Invalid arguments: a=" + a + ", b=" + b + ", k=" + k);
		}
		
		double sum = 0;
		for(int i = 1; i < k; i++)
		{
			sum += sum_addElement(a, b, i);
		}
		return sum;
	}

	public void sum_print(double a, double b, int k)
	{
		System.out.print("Task1: a = " + a + " b = " + b + " k = " + k + " result: ");
			try
		{
			System.out.print(sum_calculate(a, b, k));
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("EXCEPTION!" + e.getMessage());
		}
	}
}	

