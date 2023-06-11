import java.util.Scanner;

class Max
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Elements: ");
        int numElements = 0;
        try {
            numElements = sc.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        }

        int[] elements = new int[numElements];

        for(int i = 0; i < numElements; i++)
        {
            System.out.print("Element " + i + ": ");
            elements[i] = sc.nextInt();
            System.out.println(elements[i]);
        }

        int maxValue = getMax(elements);
        System.out.println("The max value is: " + maxValue);

        sc.close();
    }

    static int getMax(int[] elements)
    {
        int max = elements[0];
        int elementsLength = elements.length;

        for(int i = 1; i < elementsLength; i++)
        {
            if(elements[i] > max)
            {
                max = elements[i];
            }
        }

        return max;
    }
}