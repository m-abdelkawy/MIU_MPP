package week3.lab8_streams_lamda.level2.lab3_mailingservice_redo.dtos;

public class PackageLowestPriceDto {
	public Double price;
	public String provider;
	
	public PackageLowestPriceDto(Double price, String provider){
		this.price = price;
		this.provider = provider;
	}
}
