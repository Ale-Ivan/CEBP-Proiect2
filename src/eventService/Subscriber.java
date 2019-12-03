package eventService;
import events.Event;

public interface Subscriber {

	void inform(Event event);

	String getName();

}
