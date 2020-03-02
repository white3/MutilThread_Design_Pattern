package Future;

public class FutureData implements Data {
	private boolean ready = false;
	private RealData realData = null;

	public synchronized void setRealData(RealData realData) {
		if (ready)
			return;	// balk
		this.realData = realData;
		ready = true;
		notifyAll();
	}

	@Override
	public synchronized String getContent() {
		while(!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData.getContent();
	}

}
