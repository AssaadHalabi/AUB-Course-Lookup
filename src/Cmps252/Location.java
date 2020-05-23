package Cmps252;

public interface Location {
	Building getBuilding();
	Room getRoom();
	boolean equals(Object o);
	int hashCode();
}
