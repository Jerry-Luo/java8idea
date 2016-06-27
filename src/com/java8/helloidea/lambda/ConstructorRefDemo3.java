package com.java8.helloidea.lambda;

interface MyFuncT<R, T>{
	R func(T n);
}

class MyClass<T>{
	private T val;

	MyClass(T v){ val = v;}

	MyClass(){ val = null; }

	T getVal() { return val; }
}

class MyClass2{
	String str;

	MyClass2(String s) { str = s; }

	MyClass2(){str = ""; }

	String getVal(){return str;}

}

interface MyArrayCreator<T>{
	T func(int n);
}

class ConstructorRefDemo3{
	static <R,T> R myClassFactory(MyFuncT<R, T> cons, T v){
		return cons.func(v);
	}

	public static void main(String[] args) {
		MyFuncT<MyClass<Double>, Double> myClassCons = MyClass<Double>::new;
		MyClass<Double> mc = myClassFactory(myClassCons, 100.1);
		System.out.println("val in mc is :" + mc.getVal());

		MyFuncT<MyClass2,String> myClassCons2 = MyClass2::new;
		MyClass2 mc2 = myClassFactory(myClassCons2, "lambda");
		System.out.println("str in mc2 is " + mc2.getVal());

		MyArrayCreator<MyClass[]> mcArrayCons = MyClass[]::new;
		MyClass[] a = mcArrayCons.func(2);
		for (MyClass c : a ) {
			System.out.println(c.getVal());
		}

	}
}