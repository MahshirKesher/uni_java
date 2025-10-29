package lab05;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/*
 * Lab05. Variant #4.
 * Everything implemented as separate inner classes.
 */

public class Lab05
{
	public static void main(String[] args)
	{
		// Just a placeholder main
		System.out.println("Run Method1 or Method2 to test sorting.");
	}

	public static class Method1
	{
		public static void main(String[] args)
		{
			Random obj_rand = new Random();
			Scanner obj_scan = new Scanner(System.in);
			System.out.print("Enter required array length: ");
			int length = obj_scan.nextInt();

			float[] array = new float[length]; // allocate memory!

			System.out.print("Your array is: | ");
			for (int i = 0; i < length; i++)
			{
				array[i] = obj_rand.nextFloat() % 1; // generate random float 0-100
				System.out.printf("%.2f | ", array[i]);
			}
			System.out.println();

			selectionSort_descend(array);

			System.out.println("Sorted (descending) array:");
			printArray(array);
		}

		public static void selectionSort_descend(float[] array)
		{
			for (int i = 0; i < array.length - 1; i++)
			{
				int maxIdx = i;
				for (int j = i + 1; j < array.length; j++)
				{
					if (array[j] > array[maxIdx])
						maxIdx = j;
				}

				// Swap array[i] and array[maxIdx]
				float temp = array[i];
				array[i] = array[maxIdx];
				array[maxIdx] = temp;
			}
		}

		private static void printArray(float[] array)
		{
			System.out.print("| ");
			for (float f : array)
			{
				System.out.printf("%.2f | ", f);
			}
			System.out.println();
		}
	}

	public static class Method2
	{
		public static void main(String[] args)
		{
			Random obj_rand = new Random();
			Scanner obj_scan = new Scanner(System.in);
			System.out.print("Enter required array length: ");
			int length = obj_scan.nextInt();

			float[] array = new float[length];

			System.out.print("Your array is: | ");
			for (int i = 0; i < length; i++)
			{
				array[i] = obj_rand.nextFloat() % 1;
				System.out.printf("%.2f | ", array[i]);
			}
			System.out.println();

			bubbleSort_descend(array);

			System.out.println("Sorted (descending) array:");
			printArray(array);
		}

		public static void bubbleSort_descend(float[] array)
		{
			boolean swapped;
			for (int i = 0; i < array.length - 1; i++)
			{
				swapped = false;
				for (int j = 0; j < array.length - i - 1; j++)
				{
					if (array[j] < array[j + 1])
					{
						float temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
						swapped = true;
					}
				}
				if (!swapped) break; // Optimization: stop if sorted early
			}
		}

		private static void printArray(float[] array)
		{
			System.out.print("| ");
			for (float f : array)
			{
				System.out.printf("%.2f | ", f);
			}
			System.out.println();
		}
	}
}
