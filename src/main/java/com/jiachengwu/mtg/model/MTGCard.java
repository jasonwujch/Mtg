package com.jiachengwu.mtg.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="MTGCard")
public class MTGCard {
	@Id
	@Column(name = "cardId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer				cardId;
	private String				layout;
	private String				name;
	@Transient
	private ArrayList<String>	names;
	private String				manaCost;	
	private Integer				cmc;
	@Transient
	private ArrayList<String>	colors;
	private String				type;
	@Transient
	private ArrayList<String>	supertypes;
	@Transient
	private ArrayList<String>	types;
	@Transient
	private ArrayList<String>	subtypes;
	private String				rarity;
	private String				text;
	private String				flavor;
	private String				artist;
	private String				number;
	private String				power;
	private String				toughness;
	private Integer				loyalty;
	private Integer				multiverseid;
	@Transient
	private ArrayList<String>	variations;
	private String				imageName;
	private String				border;
	private String				watermark;
	
	// Derived entries to store in database
	private String				namesString;
	private String				colorsString;
	private String 				supertypesString;
	private String				typesString;
	private String				subtypesString;
	private String				variationsString;
	
	// Not part of JSON, will be set later
	private String				setCode;
	private String				setName;
	
	public MTGCard() {
	}
	
	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getLayout()
	{
		return layout;
	}
	public void setLayout(String layout)
	{
		this.layout = layout;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public ArrayList<String> getNames()
	{
		return names;
	}
	public void setNames(ArrayList<String> names)
	{
		this.names = names;
	}
	public String getManaCost()
	{
		return manaCost;
	}
	public void setManaCost(String manaCost)
	{
		this.manaCost = manaCost;
	}
	public Integer getCmc()
	{
		return cmc;
	}
	public void setCmc(Integer cmc)
	{
		this.cmc = cmc;
	}
	public ArrayList<String> getColors()
	{
		return colors;
	}
	public void setColors(ArrayList<String> colors)
	{
		this.colors = colors;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public ArrayList<String> getSupertypes()
	{
		return supertypes;
	}
	public void setSupertypes(ArrayList<String> supertypes)
	{
		this.supertypes = supertypes;
	}
	public ArrayList<String> getTypes()
	{
		return types;
	}
	public void setTypes(ArrayList<String> types)
	{
		this.types = types;
	}
	public ArrayList<String> getSubtypes()
	{
		return subtypes;
	}
	public void setSubtypes(ArrayList<String> subtypes)
	{
		this.subtypes = subtypes;
	}
	public String getRarity()
	{
		return rarity;
	}
	public void setRarity(String rarity)
	{
		this.rarity = rarity;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	public String getFlavor()
	{
		return flavor;
	}
	public void setFlavor(String flavor)
	{
		this.flavor = flavor;
	}
	public String getArtist()
	{
		return artist;
	}
	public void setArtist(String artist)
	{
		this.artist = artist;
	}
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public String getPower()
	{
		return power;
	}
	public void setPower(String power)
	{
		this.power = power;
	}
	public String getToughness()
	{
		return toughness;
	}
	public void setToughness(String toughness)
	{
		this.toughness = toughness;
	}
	public Integer getLoyalty()
	{
		return loyalty;
	}
	public void setLoyalty(Integer loyalty)
	{
		this.loyalty = loyalty;
	}
	public Integer getMultiverseid()
	{
		return multiverseid;
	}
	public void setMultiverseid(Integer multiverseid)
	{
		this.multiverseid = multiverseid;
	}
	public ArrayList<String> getVariations()
	{
		return variations;
	}
	public void setVariations(ArrayList<String> variations)
	{
		this.variations = variations;
	}
	public String getImageName()
	{
		return imageName;
	}
	public void setImageName(String imageName)
	{
		this.imageName = imageName;
	}
	public String getBorder()
	{
		return border;
	}
	public void setBorder(String border)
	{
		this.border = border;
	}
	public String getWatermark()
	{
		return watermark;
	}
	public void setWatermark(String watermark)
	{
		this.watermark = watermark;
	}
	public String getSetName()
	{
		return setName;
	}
	public void setSetName(String setName)
	{
		this.setName = setName;
	}
	public String getSetCode()
	{
		return setCode;
	}
	public void setSetCode(String setCode)
	{
		this.setCode = setCode;
	}
	
	public String getNamesString() {
		return namesString;
	}
	public void setNamesString(String namesString) {
		this.namesString = namesString;
	}
	public String getColorsString() {
		return colorsString;
	}
	public void setColorsString(String colorsString) {
		this.colorsString = colorsString;
	}
	public String getSupertypesString() {
		return supertypesString;
	}
	public void setSupertypesString(String supertypesString) {
		this.supertypesString = supertypesString;
	}
	public String getTypesString() {
		return typesString;
	}
	public void setTypesString(String typesString) {
		this.typesString = typesString;
	}
	public String getSubtypesString() {
		return subtypesString;
	}
	public void setSubtypesString(String subtypesString) {
		this.subtypesString = subtypesString;
	}
	public String getVariationsString() {
		return variationsString;
	}
	public void setVariationsString(String variationsString) {
		this.variationsString = variationsString;
	}
	@Override
	public String toString() {
		String string = "name:"+"     "+getName()+"\n\n"+
	
						"manaCost:"+"     "+getManaCost()+"\n"+
						"cmc:"+"     "+getCmc()+"\n"+
						"colors:"+"     "+getColors()+"\n\n"+
				
						"type:"+"     "+getType()+"\n"+
						"supertypes:"+"     "+getSupertypes()+"\n"+
						"types:"+"     "+getTypes()+"\n"+
						"subtypes:"+"     "+getSubtypes()+"\n\n"+
						
						"rarity:"+"     "+getRarity()+"\n\n"+
						
						"text:"+"     "+getText()+"\n\n"+

						"flavor:"+"     "+getFlavor()+"\n\n"+

						"artist:"+"     "+getArtist()+"\n"+
						"number:"+"     "+getNumber()+"\n\n"+

						"power:"+"     "+getPower()+"\n"+
						"toughness:"+"     "+getToughness()+"\n\n"+
						
						"layout:"+"     "+getLayout()+"\n"+
						"multiverseid:"+"     "+getMultiverseid()+"\n"+
						"imageName:"+"     "+getImageName();

		return string;
	}
}
