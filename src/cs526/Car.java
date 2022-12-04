package cs526;
public class Car {
 
   private String make;
   private int year;
   private int price;
   
   public Car() {
   }

//   public Car(String make, int year, int price) {
     public Car(String make, int year, int price) {
	   this.make = make;
	   this.year = year;
	   this.price = price;
   }

   public String getMake() { return make; }
   public int getYear() { return year; }
   public int getPrice() { return price; }
 
   public void setMake(String make) {        
	   this.make = make ; 
   }             
   public void setYear(int year){
	   this.year = year;
   }
   public void setPrice(int price){
	   this.price = price;
   }
   
   public String toString() {
	   String c =
				"\tMake = " + make +
	            "\tYear = " + year +
	            "\tPrice = " + price;
	   return c;
   }

 }
