package eventService;
import filters.Filter;

public class Subscription {

	public Class eventType;
	public Filter filter;
	public Subscriber subscriber;

	public Subscription(Class anEventType, Filter aFilter, Subscriber aSubscriber) {
		eventType = anEventType;
		filter = aFilter;
		subscriber = aSubscriber;
	}

}
