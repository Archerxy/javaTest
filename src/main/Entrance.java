package main;

import leetCodeMiddle.*;
import interview.*;
import leetcode.*;
import leetCodeEasy.*;
import classTest.*;
import crypto.*;
import OtherTopic.*;
import sorts.*;
import threads.*;
import anotation.*;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

public class Entrance{
    public static void main(String[] args){
    	double n = 1473253.12345d;
    	System.out.println(Double.doubleToLongBits(n));
    	
    	RandomNum r1 = new RandomNum();
    	CLGRandom r2 = new CLGRandom();
    	int range = 1000000;
    	long t1, t2;
    	t1 = System.nanoTime();
    	for(int i = 0; i < range; ++i) {
    		r1.nextInt(range);
//    		System.out.print(r1.nextInt(100)+"\t");
    	}
    	t2 = System.nanoTime();
		System.out.print("原生耗时"+(t2-t1)+"ns \n");
    	t1 = System.nanoTime();
    	for(int i = 0; i < range; ++i) {
    		r2.nextInt(range);
//    		System.out.print(r2.nextInt(100)+"\t");
    	}
    	t2 = System.nanoTime();
		System.out.print("CLG耗时"+(t2-t1)+"ns \n");
    }
}