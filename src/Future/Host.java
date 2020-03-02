package Future;

public class Host {

	public Data request(final int count , final char c) {
		System.out.println("	request (" + count + ", " + c + ") BEGIN");
		
		// (1) 创建 FutureData 实例
		final FutureData future = new FutureData();
		
		// (2) 创建 RealData 实例
		new Thread() {
			public void run() {
				RealData realData = new RealData(count, c);
				future.setRealData(realData);
			};
		}.start();

		System.out.println("	request (" + count + ", " + c + ") END");
		
		// 返回 FutureData 实例
		return future;
	}
}
