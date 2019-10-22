package com.etc.designPatterns;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Decorate {
	public static void main(String[] args) {
		Phone p = new IPhone();
		p.call();
		System.out.println("------------");

		// 需求：我想在接电话前，听彩铃
		PhoneDecorate pd = new RingPhoneDecorate(p);
		pd.call();
		System.out.println("------------");

		// 需求：我想在接电话后，听音乐
		pd = new MusicPhoneDecorate(p);
		pd.call();
		System.out.println("------------");

		// 需求：我要想手机在接前听彩铃，接后听音乐
		// 自己提供装饰类，在打电话前听彩铃，打电话后听音乐
		// 或者以下方式
		pd = new RingPhoneDecorate(new MusicPhoneDecorate(p));
		pd.call();
		System.out.println("----------");
		// 想想我们在IO流中的使用
		// InputStream is = System.in;
		// InputStreamReader isr = new InputStreamReader(is);
		// BufferedReader br = new BufferedReader(isr);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

		Scanner sc = new Scanner(System.in);
	}
}

/*
 * 手机接口
 */
interface Phone {
	public abstract void call();
}

/*
 * iphone手机
 */
class IPhone implements Phone {

	@Override
	public void call() {
		System.out.println("手机可以打电话了");
	}

}

/*
 * 装饰抽象类
 */
abstract class PhoneDecorate implements Phone {

	private Phone p;

	public PhoneDecorate(Phone p) {
		this.p = p;
	}

	@Override
	public void call() {
		this.p.call();
	}
}

/*
 * 装饰01，打电话之前响铃
 */
class RingPhoneDecorate extends PhoneDecorate {

	public RingPhoneDecorate(Phone p) {
		super(p);
	}

	@Override
	public void call() {
		System.out.println("手机可以听彩铃");
		super.call();
	}
}

/*
 * 装饰02，打完电话后放音乐
 */
class MusicPhoneDecorate extends PhoneDecorate {

	public MusicPhoneDecorate(Phone p) {
		super(p);
	}

	@Override
	public void call() {
		super.call();
		System.out.println("手机可以听音乐");
	}
}


