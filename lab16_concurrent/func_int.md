```java
Supplier<String> supplier = new Supplier<String>() {
	@Override
	public String get() {
		return "String";
	}
};
Consumer<String> consumer = new Consumer<String>() {
	@Override
	public void accept(String s) {
		System.out.println(s);
	}
};
Function<String, Integer> converter = new Function<String, Integer>() {
	@Override
	public Integer apply(String s) {
		return Integer.valueOf(s);
	}
};
```