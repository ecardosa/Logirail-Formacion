package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    
   @Test
   void surfuras() {
	   Item[] items = new Item[] { new Item("Sulfuras", 22, 80) };
	   GildedRose app = new GildedRose(items);
	   app.updateQuality();
	   assertEquals("Sulfuras", app.items[0].name, "name");
	   assertEquals(22, app.items[0].sellIn, "SellIn");
	   assertEquals(80, app.items[0].quality, "Quality");   
   }
   
   @Test
   void quesobrie() {
	   Item[] items = new Item[] { new Item("Queso Brie", 2, 49) };
	   GildedRose app = new GildedRose(items);
	   app.updateQuality();
	   
	   assertAll("Properties", 
			   
	  () -> assertEquals("Queso Brie", app.items[0].name, "name"),
	  () -> assertEquals(1, app.items[0].sellIn, "SellIn"),
	  () -> assertEquals(50, app.items[0].quality, "Quality")
	  
	  );
   }

}
