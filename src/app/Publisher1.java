package app;
import eventService.EventService;
import eventService.IPublish;
import events.Event;

public class Publisher1 implements IPublish {

	private EventService eventService = EventService.instance();

	@Override
	public void publish(Event event) {
		System.out.print("publishing: " + event.getType()+"\n");
		eventService.publish(event);

	}
}
