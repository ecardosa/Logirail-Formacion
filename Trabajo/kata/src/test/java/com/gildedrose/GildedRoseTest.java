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
    
    @Test /* Mayor a la fecha recomendada y calidad menor que 0 */
    void item1() {
 	   Item[] items = new Item[] { new Item("Item1", 2, 1) };
 	   GildedRose app = new GildedRose(items);
 	   app.updateQuality();
 	   
 	   assertAll("Properties", 
 			   
 	  () -> assertEquals("Item1", app.items[0].name, "name"),
 	  () -> assertEquals(1, app.items[0].sellIn, "SellIn"),
 	  () -> assertEquals(0, app.items[0].quality, "Quality")
 	  
 	  );
    }
    
    @Test /* Mayor a la fecha recomendada y calidad mayor que 0 */
    void item2() {
 	   Item[] items = new Item[] { new Item("Item2", 3, 3) };
 	   GildedRose app = new GildedRose(items);
 	   app.updateQuality();
 	   
 	   assertAll("Properties", 
 			   
 	  () -> assertEquals("Item2", app.items[0].name, "name"),
 	  () -> assertEquals(2, app.items[0].sellIn, "SellIn"),
 	  () -> assertEquals(2, app.items[0].quality, "Quality")
 	  
 	  );
    }
    
    @Test /* Menor a la fecha recomendada y calidad menor que 0 */
    void item3() {
 	   Item[] items = new Item[] { new Item("Item3", -1, 1) };
 	   GildedRose app = new GildedRose(items);
 	   app.updateQuality();
 	   
 	   assertAll("Properties", 
 			   
 	  () -> assertEquals("Item3", app.items[0].name, "name"),
 	  () -> assertEquals(-2, app.items[0].sellIn, "SellIn"),
 	  () -> assertEquals(0, app.items[0].quality, "Quality")
 	  
 	  );
    }
    
    @Test /* Menor a la fecha recomendada y calidad mayor que 0 */
    void item4() {
 	   Item[] items = new Item[] { new Item("Item4", -2, 3) };
 	   GildedRose app = new GildedRose(items);
 	   app.updateQuality();
 	   
 	   assertAll("Properties", 
 			   
 	  () -> assertEquals("Item4", app.items[0].name, "name"),
 	  () -> assertEquals(-3, app.items[0].sellIn, "SellIn"),
 	  () -> assertEquals(1, app.items[0].quality, "Quality")
 	  
 	  );
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

}
