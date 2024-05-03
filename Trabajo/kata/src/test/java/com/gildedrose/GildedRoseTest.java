package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;

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
    
    @ParameterizedTest (name = "{4} SellIn: {0} Quality: {1} -> Sellin: {2} Quality: {3}")
    @CvsSource(value = {"2, 1, 1, 0, Item1", "-2, 3, -3, 1, Item4"})
    @DisplayName("Casos de prueba de los items normales")
    void ItemsNormales(int sellIn, int quality, int sellInResult, int qualityResult, String name)
    {
    	Item[] items = new Item[] { new Item(name, sellIn, quality) };
    	GildedRose app = new GildedRose(items);
 	   app.updateQuality();
 	   
 	   assertNotNull(items);
 	   
 	   assertAll("Propiedades",
 			   
 			   () -> assertEquals(name , app.items[0].name, "name"),
 			   () -> assertEquals(sellInResult , app.items[0].sellIn, "sellIn"),
 			   () -> assertEquals(qualityResult , app.items[0].quality, "quality")
 			  
 			   );
    }
    
    
    
   @Test  /* Si quality = 0 */
   void surfuras() {
	   Item[] items = new Item[] { new Item("Sulfuras", 22, 80) };
	   GildedRose app = new GildedRose(items);
	   app.updateQuality();
	   assertEquals("Sulfuras", app.items[0].name, "name");
	   assertEquals(22, app.items[0].sellIn, "SellIn");
	   assertEquals(80, app.items[0].quality, "Quality");   
   }
   
   @Test  /* Si quality != 0 */
   void surfuras2() {
	   Item[] items = new Item[] { new Item("Sulfuras2", 1, 1) };
	   GildedRose app = new GildedRose(items);
	   app.updateQuality();
	   assertEquals("Sulfuras2", app.items[0].name, "name");
	   assertEquals(1, app.items[0].sellIn, "SellIn");
	   assertEquals(80, app.items[0].quality, "Quality");   
   }
   
   @Test  /* Si es mayor que la fecha recomendada y la calidad final es menor que 50*/
   void brie() {
	   Item[] items = new Item[] { new Item("brie", 2, 49) };
	   GildedRose app = new GildedRose(items);
	   app.updateQuality();
	   assertEquals("brie", app.items[0].name, "name");
	   assertEquals(1, app.items[0].sellIn, "SellIn");
	   assertEquals(50, app.items[0].quality, "Quality");   
   }
   
   @Test  /* Si es mayor que la fecha recomendada y la calidad final no es menor que 50*/
   void brie2() {
	   Item[] items = new Item[] { new Item("brie2", 2, 2) };
	   GildedRose app = new GildedRose(items);
	   app.updateQuality();
	   assertEquals("brie2", app.items[0].name, "name");
	   assertEquals(1, app.items[0].sellIn, "SellIn");
	   assertEquals(3, app.items[0].quality, "Quality");   
   }
   
   @Test  /* Si no es mayor que la fecha recomendada y la calidad final es menor que 50*/
   void brie3() {
	   Item[] items = new Item[] { new Item("brie3", -1, 49) };
	   GildedRose app = new GildedRose(items);
	   app.updateQuality();
	   assertEquals("brie3", app.items[0].name, "name");
	   assertEquals(-2, app.items[0].sellIn, "SellIn");
	   assertEquals(50, app.items[0].quality, "Quality");   
   }
   
   @Test  /* Si no es mayor que la fecha recomendada y la calidad final no es menor que 50*/
   void brie4() {
	   Item[] items = new Item[] { new Item("brie4", 0, 5) };
	   GildedRose app = new GildedRose(items);
	   app.updateQuality();
	   assertEquals("brie4", app.items[0].name, "name");
	   assertEquals(-1, app.items[0].sellIn, "SellIn");
	   assertEquals(7, app.items[0].quality, "Quality");   
   }

}
