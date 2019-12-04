package app;
import java.util.ArrayList;

import eventService.Subscriber;
import events.Event;

public class ReadingFan implements Subscriber {

	private String name;
	private ArrayList<Class> eventClasses;


	public ReadingFan(String name){
		this.name = name;
		eventClasses = new ArrayList<>();
	}

	@Override
	public void inform(Event event) {
		if(eventClasses.contains(event.getClass())){
			System.out.println(this.name + " is informed of event: "+ event.getType());
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void addEventType(Class eventType){
		eventClasses.add(eventType);
	}

	public void removeEventType(Class eventType){
		eventClasses.remove(eventType);
	}

}
