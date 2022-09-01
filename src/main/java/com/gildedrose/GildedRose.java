package com.gildedrose;

class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_PREFIX = "Conjured ";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            checkMinMaxQuality(item);
            updateItemSellIn(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (item.name.startsWith(CONJURED_PREFIX)) {
            item.quality -= 2;
            return;
        }
        switch (item.name) {
            case AGED_BRIE:
                item.quality++;
                break;
            case SULFURAS:
                break;
            case BACKSTAGE_PASS:
                updateBackstagePassQuality(item);
                break;
            default:
                item.quality = item.sellIn <= 0 ? item.quality - 2 : item.quality - 1;
                break;
        }
    }

    private void checkMinMaxQuality(Item item) {
        // max quality = 50
        if (item.quality > 50) {
            item.quality = 50;
        }

        // min quality = 0
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    private void updateBackstagePassQuality(Item item) {
        int delta;
        if (item.sellIn <= 0) {
            delta = -item.quality;
        } else if (item.sellIn <= 5) {
            delta = 3;
        } else if (item.sellIn <= 10) {
            delta = 2;
        } else {
            delta = 1;
        }
        item.quality += delta;
    }

    private void updateItemSellIn(Item item) {
        if (!SULFURAS.equals(item.name)) {
            item.sellIn--;
        }
    }

}
