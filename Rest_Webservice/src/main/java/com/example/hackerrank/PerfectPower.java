package com.example.hackerrank;

import java.util.Scanner;

public class PerfectPower {
	
	public static void main(String[] args)
	{
		System.out.print("Enter Number");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int x = Math.abs(input);
        int y = x;
        int p = 1;
        for (int i = (int)Math.sqrt(x); i > 0; i--) {
            for (int exp = 2; exp < 32; exp++) {
                if ((int)Math.pow(i, exp) == x) {
                    if (exp > p) {
                        y = i;
                        p = exp;
                    }
                    break;
                } else if ((int)Math.pow(i, exp) >= x) {
                    break;
                }
            }
        }
        System.out.println("Perfect Square is :");
        System.out.println(p);
	} 
}
