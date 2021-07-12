package com.jmm.brsap.countries.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;

import java.io.Serializable;
import java.util.List;

//@Entity(tableName = "countries")
public class Country implements Parcelable {
	private double area;
	private String nativeName;
	private String capital;
	private String demonym;
	private String flag;
	private String alpha2Code;
	private List<Language> languages;
	private List<String> borders;
	private String subregion;
	private List<String> callingCodes;
	private List<RegionalBloc> regionalBlocs;
	private double gini;
	private int population;
	private String numericCode;
	private String alpha3Code;
	private List<String> topLevelDomain;
	private List<String> timezones;
	private String cioc;
	private Translation translations;
	private String name;
	private List<String> altSpellings;
	private String region;
	private List<Double> latlng;
	private List<Currency> currencies;

	protected Country(Parcel in) {
		area = in.readDouble();
		nativeName = in.readString();
		capital = in.readString();
		demonym = in.readString();
		flag = in.readString();
		alpha2Code = in.readString();
		borders = in.createStringArrayList();
		subregion = in.readString();
		callingCodes = in.createStringArrayList();
		gini = in.readDouble();
		population = in.readInt();
		numericCode = in.readString();
		alpha3Code = in.readString();
		topLevelDomain = in.createStringArrayList();
		timezones = in.createStringArrayList();
		cioc = in.readString();
		name = in.readString();
		altSpellings = in.createStringArrayList();
		region = in.readString();
	}

	public static final Creator<Country> CREATOR = new Creator<Country>() {
		@Override
		public Country createFromParcel(Parcel in) {
			return new Country(in);
		}

		@Override
		public Country[] newArray(int size) {
			return new Country[size];
		}
	};

	public double getArea(){
		return area;
	}

	public String getNativeName(){
		return nativeName;
	}

	public String getCapital(){
		return capital;
	}

	public String getDemonym(){
		return demonym;
	}

	public String getFlag(){
		return flag;
	}

	public String getAlpha2Code(){
		return alpha2Code;
	}

	public List<Language> getLanguages(){
		return languages;
	}

	public List<String> getBorders(){
		return borders;
	}

	public String getSubregion(){
		return subregion;
	}

	public List<String> getCallingCodes(){
		return callingCodes;
	}

	public List<RegionalBloc> getRegionalBlocs(){
		return regionalBlocs;
	}

	public double getGini(){
		return gini;
	}

	public int getPopulation(){
		return population;
	}

	public String getNumericCode(){
		return numericCode;
	}

	public String getAlpha3Code(){
		return alpha3Code;
	}

	public List<String> getTopLevelDomain(){
		return topLevelDomain;
	}

	public List<String> getTimezones(){
		return timezones;
	}

	public String getCioc(){
		return cioc;
	}

	public Translation getTranslations(){
		return translations;
	}

	public String getName(){
		return name;
	}

	public List<String> getAltSpellings(){
		return altSpellings;
	}

	public String getRegion(){
		return region;
	}

	public List<Double> getLatlng(){
		return latlng;
	}

	public List<Currency> getCurrencies(){
		return currencies;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeDouble(area);
		dest.writeString(nativeName);
		dest.writeString(capital);
		dest.writeString(demonym);
		dest.writeString(flag);
		dest.writeString(alpha2Code);
		dest.writeStringList(borders);
		dest.writeString(subregion);
		dest.writeStringList(callingCodes);
		dest.writeDouble(gini);
		dest.writeInt(population);
		dest.writeString(numericCode);
		dest.writeString(alpha3Code);
		dest.writeStringList(topLevelDomain);
		dest.writeStringList(timezones);
		dest.writeString(cioc);
		dest.writeString(name);
		dest.writeStringList(altSpellings);
		dest.writeString(region);
	}
}