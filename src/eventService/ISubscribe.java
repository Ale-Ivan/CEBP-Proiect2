package eventService;
import filters.Filter;

public interface ISubscribe {

	void subscribe(Class eventType, Filter filter, Subscriber subscriber);

	void unsubscribe(Class eventType, Filter filter, Subscriber subscriber);

}
