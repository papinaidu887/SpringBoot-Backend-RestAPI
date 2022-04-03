package com.medhansh;

import java.util.ArrayList;

public class test {
	
	public static void main(String[] args) {
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(13);
		list.add(20);
		list.add(10);
		list.add(15);
		list.add(10);
		list.add(22);
		list.add(32);
		
		for(Integer listElements: list)
		{
			System.out.print(listElements+" ");
		}
		//System.out.println();
		list.forEach(a -> {System.out.println(a+" ");});
		
		
		System.out.println("====================================");
		
		
		
		
	}

}
