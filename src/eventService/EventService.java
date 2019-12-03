package eventService;
import java.util.Enumeration;
import java.util.Vector;

import events.Event;
import events.InvalidEventTypeException;
import filters.Filter;

public class EventService implements IPublish, ISubscribe {

	static private EventService singleton = null;

	private Class eventClass;
	protected Vector subscriptions;

	private EventService() {
		eventClass = Event.class;
		subscriptions = new Vector();
	}

	// Provides well-known access point to singleton EventService
	static public EventService instance() {
		if (singleton == null)
			singleton = new EventService();
		return singleton;
	}

	@Override
	public void publish(Event event) {
		for (Enumeration elems = subscriptions.elements(); elems.hasMoreElements(); ) {
			Subscription subscription = (Subscription) elems.nextElement();
			if (subscription.eventType.isAssignableFrom(event.getClass())
					&& (subscription.filter == null || subscription.filter.apply(event)))
				subscription.subscriber.inform(event);
		}
	}

	public void subscribe(Class eventType, Filter filter, Subscriber subscriber)
			throws InvalidEventTypeException {
		if (!eventClass.isAssignableFrom(eventType))
			throw new InvalidEventTypeException();

		// Prevent duplicate subscriptions
		Subscription subscription = new Subscription(eventType, filter, subscriber);
		if (!subscriptions.contains(subscription))
			subscriptions.addElement(subscription);
	}

	public void unsubscribe(Class eventType, Filter filter, Subscriber subscriber)
			throws InvalidEventTypeException {
		if (!eventClass.isAssignableFrom(eventType))
			throw new InvalidEventTypeException();
		subscriptions.removeElement(new Subscription(eventType, filter, subscriber));
	}
}
