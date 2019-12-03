package app;
import eventService.EventService;
import eventService.Subscriber;
import events.HistoryBookRelease;

public class Main {

	public static void main(String[] args) {

		EventService eventService = EventService.instance();

		HistoryBookRelease historyBookRelease = new HistoryBookRelease();
		Subscriber subscriber1 = new Subscriber1("1");
		Publisher1 publisher1 = new Publisher1();

		eventService.subscribe(historyBookRelease.getClass(), null, subscriber1);
		publisher1.publish(historyBookRelease);


	}
}
