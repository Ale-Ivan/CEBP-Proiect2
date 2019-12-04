package app;
import eventService.EventService;
import eventService.Subscriber;
import events.HistoryBookRelease;
import events.PoetryBookRelease;

public class Main {

	public static void main(String[] args) {

		EventService eventService = EventService.instance();

		HistoryBookRelease historyBookRelease = new HistoryBookRelease();
		PoetryBookRelease poetryBookRelease = new PoetryBookRelease();

		Subscriber subscriber1 = new ReadingFan("1");
		Subscriber subscriber2 = new ReadingFan("2");
		Subscriber subscriber3 = new ReadingFan("3");

		Author publisher1 = new Author("a"); //for history
		Author publisher2 = new Author("b"); //for poetry

		eventService.subscribe(historyBookRelease.getClass(), subscriber1);
		eventService.subscribe(poetryBookRelease.getClass(), subscriber1);

		eventService.subscribe(historyBookRelease.getClass(), subscriber2);

		eventService.subscribe(poetryBookRelease.getClass(), subscriber3);

		publisher1.publish(historyBookRelease);

		publisher2.publish(poetryBookRelease);

		eventService.unsubscribe(historyBookRelease.getClass(), subscriber1);
		publisher1.publish(historyBookRelease);
	}
}
