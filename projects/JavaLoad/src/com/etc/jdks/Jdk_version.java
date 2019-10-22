package com.etc.jdks;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Jdk_version {
	public static void main(String[] args) {
		String arch = System.getProperty("sun.arch.data.model");
		System.out.println(arch+"-bit");
	}
}

