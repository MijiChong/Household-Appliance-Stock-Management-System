package application;

import java.util.ArrayList;

public class StockManagement {

	public static ArrayList<Product> list = new ArrayList<Product>();
	public static UserInfo user = new UserInfo();

	public static void addRefrigerator(Refrigerator r) {
		list.add(r);
	}

	public static void addTV(TV tv) {
		list.add(tv);
	}

	public static void addMicrowave(Microwave m) {
		list.add(m);
	}

}
