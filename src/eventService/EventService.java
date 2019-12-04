package eventService;
import java.util.Vector;

import events.Event;

public class EventService implements IPublish, ISubscribe {

	static private EventService singleton = null;

	private Vector<Subscription> subscriptions;

	private EventService() {
		subscriptions = new Vector<>();
	}

	static public EventService instance() {
		if (singleton == null)
			singleton = new EventService();
		return singleton;
	}

	@Override
	public void publish(Event event) {
		for(Subscription subscription: subscriptions){
			if (subscription.getEventType() == event.getClass()){
				subscription.getSubscriber().inform(event);
			}
		}
	}

	public void subscribe(Class eventType, Subscriber subscriber)
	{
		// Prevent duplicate subscriptions
		Subscription subscription = new Subscription(eventType, subscriber);
		if (!subscriptions.contains(subscription)){
			System.out.println(subscriber.getName() + " subscribed to " + eventType.getSimpleName());
			subscriptions.add(subscription);
			subscriber.addEventType(eventType);
		}
	}

	public void unsubscribe(Class eventType, Subscriber subscriber)
	{
		Subscription sub = null;
		for(Subscription subscription: subscriptions){
			if (subscription.getEventType() == eventType && subscription.getSubscriber() == subscriber){
				sub = subscription;
				break;
			}
		}
		if(sub != null){
			System.out.println(subscriber.getName() + " unsubscribed from " + eventType.getSimpleName());
			subscriptions.remove(sub);
			subscriber.removeEventType(eventType);
		}

	}
}
