package eventService;
import events.Event;

public interface Subscriber {

	void inform(Event event);

	String getName();

	void addEventType(Class eventType);

	void removeEventType(Class eventType);

}
