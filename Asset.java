package automation;

//1 = rank
//2 = name / symbol
//3 = price
//4 = 24hr
//5 = 7day
//6 = market cap
//7 = 24hr volume

public class Asset {
	private String symbol;
	private String name;
	private int rank;
	private double price;
	private double oneDayChange;
	private double sevenDayChange;
	private double marketCap;
	private double oneDayVolume;
	private boolean onCoinbase = false;

	public Asset(String inRank, String inSymbolName, String inPrice, String inOneDayChange, String inSevenDayChange,
			String inMarketCap, String inOneDayVolume) {
		this.setRank(inRank);
		this.setName(inSymbolName.split("\n")[0]);
		this.setSymbol(inSymbolName.split("\n")[1]);
		this.setOneDayChange(inOneDayChange);
		this.setSevenDayChange(inSevenDayChange);
		this.setMarketCap(inMarketCap);
		this.setOneDayVolume(inOneDayVolume);
		// System.out.println(this.rank + ": New Asset Record Created - " + this.symbol + ", " + this.name);
	}
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = Integer.valueOf(rank);
	}

	public double getOneDayChange() {
		return oneDayChange;
	}

	public void setOneDayChange(String oneDayChange) {
		oneDayChange = oneDayChange.substring(0, oneDayChange.length()-1); // remove percent symbol
		this.oneDayChange = Double.parseDouble(oneDayChange);
	}

	public double getSevenDayChange() {
		return sevenDayChange;
	}

	public void setSevenDayChange(String sevenDayChange) {
		sevenDayChange = sevenDayChange.substring(0, sevenDayChange.length()-1); // remove percent symbol
		this.sevenDayChange = Double.parseDouble(sevenDayChange);
	}

	public double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = convertMoneyString(marketCap);
	}

	public double getOneDayVolume() {
		return oneDayVolume;
	}

	public void setOneDayVolume(String oneDayVolume) {
		this.oneDayVolume = convertMoneyString(oneDayVolume.split("\n")[0]);
	}
	
	public double convertMoneyString(String inMoney)
	{
		StringBuilder value = new StringBuilder(inMoney);
		value.deleteCharAt(0); //delete $
		while (value.indexOf(",") != -1) // remove all commas,
		{
			value.deleteCharAt(value.indexOf(","));
		}
		return Double.valueOf(value.toString());
	}
	
	@Override
	public String toString()
	{
		return 	symbol + name + rank + "$" + price + ".  1,7 change = " + oneDayChange + "," + sevenDayChange + "," + marketCap + "," + oneDayVolume + "coinbase =" + onCoinbase;		
	}

	public boolean isOnCoinbase() {
		return onCoinbase;
	}

	public void setOnCoinbase(boolean onCoinbase) {
		this.onCoinbase = onCoinbase;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = convertMoneyString(price);
	}
}
