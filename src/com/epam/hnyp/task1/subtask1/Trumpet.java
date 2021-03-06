package com.epam.hnyp.task1.subtask1;

public class Trumpet extends WindInstrument {
	public Trumpet() {
	}
	
	public Trumpet(String vendor, int year, String material) {
		super(vendor, year, material);
	}
	
	@Override
	public void play() {
		System.out.println("trumpet : turum turuuum tuum");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj instanceof Trumpet) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", trumpet";
	}
}
