package events;

public class HistoryBookRelease extends Event {

	public HistoryBookRelease(){
		super("HistoryBookRelease");
	}

	public String getType() {
		return this.type;
	}
}
