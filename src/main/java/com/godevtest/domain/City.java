package main.java.com.godevtest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"id", "name"})
public class City {
	
	private final String STRING_SEPARATOR = ",";
	
	@JsonProperty("_id")
	private int id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("geo_position")
	private GeoPosition geoPosition;

	@JsonProperty("type")
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GeoPosition getGeoPosition() {
		return geoPosition;
	}
	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(this.id);
		stringBuilder.append(STRING_SEPARATOR);

		if(this.name != null){
			stringBuilder.append(this.name);
			stringBuilder.append(STRING_SEPARATOR);
		}
		
		if(this.type != null){
			stringBuilder.append(this.type);
			stringBuilder.append(STRING_SEPARATOR);
		}
		
		if (this.geoPosition != null) {
			stringBuilder.append(this.geoPosition.getLatitude());
			stringBuilder.append(STRING_SEPARATOR);
			stringBuilder.append(this.geoPosition.getLongitude());
		}

		return stringBuilder.toString();
	}

}
