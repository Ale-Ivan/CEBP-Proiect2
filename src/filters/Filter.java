package filters;
import events.Event;

public interface Filter {

	boolean apply(Event event);

}
