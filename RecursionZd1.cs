using System;

class Program
{
    static void PrintNumbers(int M, int N)
    {
        if (M <= N)
        {
            Console.WriteLine(M);
            PrintNumbers(M + 1, N);
        }
    }

    static void Main()
    {
        int M = 1;
        int N = 10;

        Console.WriteLine($"Натуральные числа от {M} до {N}:");
        PrintNumbers(M, N);
    }
}
