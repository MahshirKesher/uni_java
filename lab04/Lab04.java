package lab04;

import java.util.Arrays;
import java.util.Random;
/*
*	Lab 04 - tasks #4, #34, #64
*	Three tasks in one file, each implemented as a static inner class.
*
*	@author MahshirKesher
*/


public class Lab04
{
	public static void main(String[] args)
	{
		Random obj = new Random();

		int[] array = new int[16];
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = obj.nextInt(100);
		}
		
		System.out.println(Arrays.toString(array));
	}

	public static class Task4
	{
		public static void main(String[] args)
		{
			int[] array = {40, -37, 71, -52, -3, -9, 17};

			printArray(array);
			System.out.println("\nArray has " + countNegatives(array) + " negative elements");
		}

		public static void printArray(int[] array)
		{
			for(int i : array)
			{
				System.out.print(i + " | ");
			}
		}

		private static int countNegatives(int[] array)
		{
			int neg_count = 0;
			for(int i = 0; i < array.length; i++)
			{
				if(array[i] < 0) neg_count++;
			}
			return neg_count;
		}
	}

	public static class Task34
	{
		public static void main(String[] args)
		{
			int[] array = {40, -37, 71, -52, -3, -9, 17};

			printArray(array);
			biggestAbs(array);
		}

		public static void printArray(int[] array)
		{
			for(int i : array)
			{
				System.out.print(i + " | ");
			}
		}

		public static void biggestAbs(int[] array)
		{
			int max_abs = 0;
			int max_idx = 0;
			for(int i = 0; i < array.length; i++)
			{
				if(Math.abs(array[i]) > max_abs)
				{
					max_abs = Math.abs(array[i]);
					max_idx = i;
				}
			}
			System.out.println("Element #" + (max_idx + 1) + " (" + max_abs + ") has the biggest abs.");
		}
	}
	
	public static class Task64
	{
		public static void main(String[] args)
		{
			int[] array = {40, -37, 0, 71, -52, -3, -9, 17, 0};

			printArray(array);
			int[] new_array = reformatArray(array);
			System.out.print("\nReformatted array looks like this: | ");
			printArray(new_array);
		}

		public static void printArray(int[] array)
		{
			for(int i : array)
			{
				System.out.print(i + " | ");
			}
		}

		public static int[] reformatArray(int[] array)
		{
			int n = array.length;

			int[] new_array = new int[n]; 
			for(int i = 0; i < array.length; i++)
			{
				if(array[i] < 0) new_array[i] = array[i] * -1;
				else if(array[i] > 0) new_array[i] = array[i] - 3;
				else if(array[i] == 0) new_array[i] = -2;
			}
			return new_array;
		}
	}
}










