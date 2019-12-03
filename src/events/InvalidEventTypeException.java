package events;
public class InvalidEventTypeException extends RuntimeException  {

	public InvalidEventTypeException(){
		System.out.println("There is no such type of event!");
	}
}
