/** 
*The purpose of this program is to allow the user to edit and modify a list of shopping
*items. The user has the ability to add items, remove items, and print information about the items.
*
*Lo Phillips
*10/15/19
*Pledged!
*/
import java.util.*;
import java.text.*;
public class Prog2{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		int pointer = 1;
		DecimalFormat money = new DecimalFormat ("$0.00");
		CList<Item> list = new CList<Item>();
		//Beginning of while 
		while(pointer != 0){
			Menu();
			pointer = keyboard.nextInt();
			keyboard.nextLine();
			String name;
			int quantity;
			double price;
			boolean additionalItem;//Need this variable to detect an additional item in the list
			//Beginning of switch
			switch(pointer){
			case 0: //Quit
				System.out.println("You have quit the menu.");
				break;
	
			case 1://Adds an item to the cart, if there is already that same item, it increases the quantity.
				additionalItem = false;
				list.moveToStart();
				System.out.println("Enter the item name: ");
				name = keyboard.nextLine();
				System.out.println("Enter the quanity of the item: ");
				quantity = keyboard.nextInt();
				System.out.println("Enter the price of the item: ");
				price = keyboard.nextDouble();
				if(list.length() == 0) {
					list.insert(new Item(quantity, name, price));
				break; }//if
				for(int i = 0; i < list.length(); i++) {
					if(list.getValue().getName().compareToIgnoreCase(name) == 0) {
						list.getValue().setQuantity(quantity + list.getValue().getQuantity());
						additionalItem = true;
					break;}//if
				list.next();}//for
				if(!additionalItem)
					list.append(new Item(quantity, name, price));
				System.out.println("The item has been added to the shopping cart");
				break;
	
			case 2://Removes an item from the cart 
				if(list.length() == 0){
					System.out.println("Can't remove an item, the shopping cart is empty.");
				break;}//if
				additionalItem = false;
				list.moveToStart();
				System.out.println("Please enter the name of the item you wish to remove: ");
				name = keyboard.nextLine();
				System.out.println("Enter the quantity of the item you wish to remove: ");
				quantity = keyboard.nextInt();
				for(int i = 0; i < list.length(); i++) {
					if(list.getValue().getName().compareToIgnoreCase(name) == 0) {
						if(list.getValue().getQuantity() <= quantity) {
							list.remove();
							System.out.println("The item has been removed from the cart.");
						additionalItem = true;}//if
						else{
							list.getValue().setQuantity(list.getValue().getQuantity() - quantity);
							System.out.println("There is " + list.getValue().getQuantity() + " of " + name + "items.");
						additionalItem = true; }//else
					break; }//if
					list.next();
				}//for
	
				if(!additionalItem){
				System.out.println("The item " + name + " was not found in the cart.");}//if
				break;
   
			case 3://Prints all the items in the cart
				if(list.length() == 0){
					System.out.println("The cart is empty.");
				break;}
				list.moveToStart();
				System.out.println("Quanity  Name  Price");
				for(int i = 0; i < list.length(); i++){
					System.out.println(list.getValue().toString());
				list.next();}//for
				break;
			case 4://Prints a specific item 
				list.moveToStart();
				if(list.length() == 0){
					System.out.println("The cart is empty.");
					break;}//if
					additionalItem = false;
					System.out.println("Enter the name of the item: ");
					name = keyboard.nextLine();
					for(int i = 0; i < list.length(); i++){
						if(list.getValue().getName().compareToIgnoreCase(name) == 0){
							System.out.println("Quantity  Name  Price");
							System.out.println(list.getValue().toString()); 
							additionalItem = true;
							break;}//if
						list.next();
					}//for
					if(!additionalItem)
						System.out.println("The item is not in the cart.");
				break;
			case 5: //Prints the amount of unique items in the cart
				System.out.println("There is " + list.length() + " many items in the cart.");
				break;
			case 6://Prints the total cost of all items in the cart
				list.moveToStart();
				double total = 0.0;
				for(int i = 0; i < list.length(); i++)
				{
					total = total + list.getValue().findTotal();
					list.next();
				}//for
				System.out.println("The total cost of all the items in the cart is: " + money.format(total) + ".");
				break;
			case 7://Determines if the cart is empty and prints the amount of items otherwise
				if(list.length() == 0)
					System.out.println("The cart is empty.");
				else 
					System.out.println("The amount of items in the cart is: " + list.length() + ".");
				break;
			case 8://Clears all the items in the cart
				list.moveToStart();
				list.clear();
				System.out.println("All items have been cleared from the shopping cart.");
				break;
			default: System.out.println("Invalid input, enter an integer from 0-8.");
			}//switch
		}//while
	}//main
	
//Our menu method to be displayed to the user
public static void Menu(){
System.out.println("Press 1 to add an item to the list"); 
System.out.println("Press 2 to remove an item from the list");
System.out.println("Press 3 to print each item in the list");
System.out.println("Press 4 to search for a item in the list");
System.out.println("Press 5 to recieve the total number of items in the list");
System.out.println("Press 6 to calculate the total cost of the items in the list");
System.out.println("Press 7 to determine whether the list is empty");
System.out.println("Press 8 to clear the list");
System.out.println("Press 0 to quit");
}//Menu
}//Prog2
