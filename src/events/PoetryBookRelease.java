package events;
public class PoetryBookRelease extends Event {

	public PoetryBookRelease(){
		super("PoetryBookRelease");
	}

	@Override
	public String getType() {
		return this.type;
	}
}
