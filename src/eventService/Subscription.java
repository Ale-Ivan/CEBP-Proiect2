package eventService;

public class Subscription {

	private Class eventType;
	private Subscriber subscriber;

	public Subscription(Class anEventType, Subscriber aSubscriber) {
		eventType = anEventType;
		subscriber = aSubscriber;
	}

	public Class getEventType(){
		return eventType;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}
}
