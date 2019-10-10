package com.gildedrose;

class GildedRose {

	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	static final int MAX_QUALITY = 50;
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}
	
	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			GildedRoseItem gildedRoseItem;
			if (item.name.equals(AGED_BRIE)) {
				gildedRoseItem = new AgedBrieItem(item);
				gildedRoseItem.updateQuality();
			} else if (item.name.equals(BACKSTAGE_PASSES)) {
				gildedRoseItem = new BackstagePassItem(item);
				gildedRoseItem.updateQuality();
			} else if (item.name.equals(SULFURAS)) {
				gildedRoseItem = new SulfurasItem(item);
				gildedRoseItem.updateQuality();
			} else {
				gildedRoseItem = new NormalItem(item);
				gildedRoseItem.updateQuality();
			}

			if (item.name.equals(SULFURAS)) {
			} else {
				item.sellIn = item.sellIn - 1;
			}
		}
	}
}
