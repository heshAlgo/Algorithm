package com.baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StackInfo {
	int index, height;
	
	public StackInfo(int index, int height) {
		this.index = index;
		this.height = height;
	}
}

public class Main {
	static int N;
	static int[] height;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());	// ?μ κ°μ
    	List<Integer> answer = new ArrayList<Integer>();
    	// ?μ ?μ΄ ?λ³΄ ?λ ₯
    	String[] input = br.readLine().split(" ");
    	height = new int[N];					
    	for (int i = 0; i < N; i++) {
    		height[i] = Integer.parseInt(input[i]);
    	}
    	Stack<StackInfo> stack = new Stack<StackInfo>();
    	stack.add(new StackInfo(1, height[0]));
    	// λ§??Όμͺ½???μ? ?μ λ°μ κ³³μ΄ ?κΈ° ?λ¬Έ??0???
    	answer.add(0);
    	boolean flag = true;
    	
    	
    	for (int i = 1; i < N; i++) {
    		while (!stack.isEmpty()) {
    			StackInfo info = stack.peek();
    			// ?€ν???€μ΄?λ ?μ ?μ΄λ³΄λ€ ?μ¬ ?Έλ±?€μ ?μ ?μ΄κ° ?μ? κ²½μ°
    			if (info.height <= height[i]) {
    				stack.pop();
    				flag = true;
    			} else {
    				// λ°λ??Έκ²½???€ν???€μ΄?λ ?μ΄ ?μΉ?λ ?Έλ±?????
    				answer.add(info.index);
    				stack.push(new StackInfo(i + 1, height[i]));
    				flag = false;
    				break;
    			}
    			
    		}
    		
     		if (flag) {
     			answer.add(stack.size());
     			stack.push(new StackInfo(i + 1, height[i]));
     		}
    		
    	}

    	for (int i = 0; i < N; i++) {
    		System.out.print(answer.get(i) + " ");
    	}	
    	
	}

}
