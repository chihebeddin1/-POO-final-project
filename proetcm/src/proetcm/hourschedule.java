package proetcm;


public class hourschedule {
	
	private int startHour;
	private int starMin;
    private int endHour;
	private int endMin;
	public hourschedule(int startHour, int starMin, int endHour, int endMin) {
		this.startHour = startHour;
		this.starMin = starMin;
		this.endHour = endHour;
		this.endMin = endMin;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getStarMin() {
		return starMin;
	}
	public void setStarMin(int starMin) {
		this.starMin = starMin;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public int getEndMin() {
		return endMin;
	}
	public void setEndMin(int endMin) {
		this.endMin = endMin;
	}
	@Override
	public String toString() {
		return "hourschedule [startHour=" + startHour + ", starMin=" + starMin + ", endHour=" + endHour + ", endMin="
				+ endMin + "]";
	}
}
	

    
    