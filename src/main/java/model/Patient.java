package model;

import java.time.LocalTime;

public class Patient implements Comparable<Patient>{
	
	public enum ColorCode {
	
		NEW, //in triage
		WHITE, YELLOW, RED, BLACK, //in sala d'attesa
		TREATING, //dentro studio medico
		OUT //a casa oppure curato 
	};
	
	private LocalTime arrivalTime;
	private ColorCode color;
	private int num;
	
	
	public Patient(LocalTime arrivalTime, ColorCode color, int num) {
		super();
		this.arrivalTime = arrivalTime;
		this.color = color;
		this.num=num;
	}


	public LocalTime getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public ColorCode getColor() {
		return color;
	}


	public void setColor(ColorCode color) {
		this.color = color;
	}
	
	public String toString() {
		return "Tempo di arrivo: "+arrivalTime+ " Colore: "+ color+ " "+ "Numero: "+num;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		return true;
	}


	@Override
	public int compareTo(Patient other) {
		
		//implementazione della priorità in base al colore
		
		if(this.color.equals(other.color)) //se stesso colore , vince chi è arrivato prima
			return this.arrivalTime.compareTo(other.arrivalTime); 
		
		//se uno dei due è rosso
		else if(this.color.equals(Patient.ColorCode.RED))
			return -1;
		else if(other.color.equals(Patient.ColorCode.RED))
			return +1;
		
		//non ci sono più rossi , solo Yellow o White
		
		else if(this.color.equals(Patient.ColorCode.YELLOW))
			return -1;
		else
			return +1;
		
		
	}
	
	
	
	

}
