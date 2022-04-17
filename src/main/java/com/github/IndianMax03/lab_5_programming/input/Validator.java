package com.github.indianMax03.lab_5_programming.input;

import com.github.indianMax03.lab_5_programming.base.Coordinates;

import java.time.ZonedDateTime;
import java.util.Arrays;

public class Validator {

	protected Long checkIdValid(String input){
		long id;
		try {
			id = Long.parseLong(input);
		} catch (NumberFormatException e){
			return null;
		}
		return id;
	}

	protected String checkNameValid(String name){
		if (name.isEmpty()){
			return null;
		} else {
			return name;
		}
	}

	protected Coordinates checkCoordinatesValid(String input){
		String[] coordinates = input.trim().split(";");
		if (coordinates.length != 2){
			return null;
		}
		System.out.println(Arrays.toString(coordinates));
		String xstring = coordinates[0];
		String ystring = coordinates[1];
		double x, y;
		try {
			x = Double.parseDouble(xstring);
			y = Double.parseDouble(ystring);
			if (y <= -628){
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e){
			return null;
		}
		return new Coordinates(x, y);
	}

	protected ZonedDateTime checkDataValid(String input){
		ZonedDateTime dateTime;
		try {
			dateTime = ZonedDateTime.parse(input);
		} catch (Exception e){
			return null;
		}
		return dateTime;
	}

	protected Float checkAreaValid(String areaString){
		float area;
		try{
			area = Float.parseFloat(areaString);
			if (area <= 0){
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e){
			return null;
		}

		return area;
	}

	protected Integer checkPopulationValid(String input){
		int population;
		try{
			population = Integer.parseInt(input);
			if (population <= 0){
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e){
			return null;
		}
		return population;
	}

	protected Float checkMASLValid(String input){
		float masl;
		try{
			masl = Float.parseFloat(input);
		} catch (NumberFormatException e){
			return null;
		}
		return masl;
	}

}
