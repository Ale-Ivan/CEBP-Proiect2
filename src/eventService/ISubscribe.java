package eventService;

public interface ISubscribe {

	void subscribe(Class eventType, Subscriber subscriber);

	void unsubscribe(Class eventType, Subscriber subscriber);

}
