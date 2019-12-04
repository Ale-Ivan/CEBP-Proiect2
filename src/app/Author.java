package app;
import eventService.EventService;
import eventService.IPublish;
import events.Event;

public class Author implements IPublish {

	private EventService eventService = EventService.instance();
	private String name;

	public Author(String name){
		this.name = name;
	}

	@Override
	public void publish(Event event) {
		System.out.print(this.name + " published: " + event.getType()+"\n");
		eventService.publish(event);

	}
}
