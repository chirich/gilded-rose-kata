package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testQualityDegrades2xAfterSellin() {
        Item[] items = new Item[] { new Item("bar", 2, 20)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 4; i++) {
            app.updateQuality();
        }
        assertEquals(14, app.items[0].quality);
    }

    @Test
    void testQualityCannotBeNegative() {
        Item[] items = new Item[] { new Item("bar", 5, 2)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 3; i++) {
            app.updateQuality();
        }
        assertTrue(app.items[0].quality >= 0);
    }

    @Test
    void testAgedBrieQualityIncrease() {
        Item[] items = new Item[] { new Item(GildedRose.AGED_BRIE, 5, 2)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 3; i++) {
            app.updateQuality();
        }
        assertEquals(5, app.items[0].quality);
    }

    @Test
    void testQualityMax50() {
        Item[] items = new Item[] { new Item(GildedRose.AGED_BRIE, 5, 48)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 4; i++) {
            app.updateQuality();
        }
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testSulfurasQualityConstant() {
        Item[] items = new Item[] { new Item(GildedRose.SULFURAS, 5, 20)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 4; i++) {
            app.updateQuality();
        }
        assertEquals(20, app.items[0].quality);
    }

    @Test
    void testBackstagePassQualityIncrease() {
        Item[] items = new Item[] { new Item(GildedRose.BACKSTAGE_PASS, 5, 20)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 4; i++) {
            app.updateQuality();
        }
        assertEquals(32, app.items[0].quality);
    }

    @Test
    void testBackstagePassQualityDrop() {
        Item[] items = new Item[] { new Item(GildedRose.BACKSTAGE_PASS, 5, 20)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 6; i++) {
            app.updateQuality();
        }
        assertEquals(0, app.items[0].quality);
    }
}
