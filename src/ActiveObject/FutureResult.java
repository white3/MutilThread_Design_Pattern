package ActiveObject;

class FutureResult<T> extends Result<T> {

	private Result<T> result;
	private boolean ready = false;

	public synchronized void setResult(Result<T> result) {
		this.ready = true;
		this.result = result;
		notifyAll();
	}
	
	@Override
	public synchronized T getResultValue() {
		while(!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		return result.getResultValue();
	}
}
