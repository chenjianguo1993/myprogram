package cn.itcast.test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class demo
{
	public static void main(String[] args){
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
	}
}
