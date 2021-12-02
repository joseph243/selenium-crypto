package automation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CoinAnalyze {

	public static boolean ratioVolumeCap() {

		Map<String, Double> symbolRatio = new HashMap<String, Double>();
		List<String> bestKeys = new ArrayList<>();
		List<Double> bestRatios = new ArrayList<>();

		for (int i = 1; i < Coin.assets.size() + 1; i++) {
			// calculate ratios for each symbol on coin base ,  also ignore USDT
			if (Coin.assets.get(i).isOnCoinbase() && !Coin.assets.get(i).getSymbol().equalsIgnoreCase("USDT")) {
				symbolRatio.put(Coin.assets.get(i).getSymbol(),
						Coin.assets.get(i).getOneDayVolume() / Coin.assets.get(i).getMarketCap());
			}
		}

		for (int i = 0; i < 5; i++) {
			// decide highest ratio
			double max = Collections.max(symbolRatio.values());
			// save and remove highest ratio
			for (Entry<String, Double> entry : symbolRatio.entrySet()) {
				if (entry.getValue() == max) {
					bestKeys.add(entry.getKey());
					bestRatios.add(max);
					symbolRatio.remove(entry.getKey());
					break;
				}
			}
		}
		System.out.println(bestKeys.size() + " Best Trading Volume / Market Cap Ratios:");
		System.out.println(bestKeys.get(0) + ": " + bestRatios.get(0));
		System.out.println(bestKeys.get(1) + ": " + bestRatios.get(1));
		System.out.println(bestKeys.get(2) + ": " + bestRatios.get(2));
		System.out.println(bestKeys.get(3) + ": " + bestRatios.get(3));
		System.out.println(bestKeys.get(4) + ": " + bestRatios.get(4));

		return !bestKeys.isEmpty();
	}
}
