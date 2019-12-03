package app;
import eventService.EventService;
import eventService.Subscriber;
import events.Event;
import events.HistoryBookRelease;

public class Subscriber1 implements Subscriber {

	private String name;

	public Subscriber1(String name){
		this.name = name;
	}

	@Override
	public void inform(Event event) {
		if(event.getClass().getSimpleName().equals("HistoryBookRelease"))
			System.out.println("ReadingFan1 is informed of event: "+ event.getType());
	}

	@Override
	public String getName() {
		return this.name;
	}

}
