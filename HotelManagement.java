package task4;

import java.util.Scanner;

class Customer {
    String name;
    int id;
    long phoneNo;
    String cnic;
    double bill;
    
    public Customer(String name, int id, long pno, double bill) {
    	this.name=name;
    	this.id=id;
    	this.phoneNo=pno;
    	this.bill=bill;
    }
    public Customer() {
    	this.name=null;
    	this.id=0;
    	this.phoneNo=0;
    	this.bill=0.0;
    }
}

public class HotelManagement {
	
	

	static Scanner input = new Scanner(System.in);

	static Customer[] customers = new Customer[20];
	static int i = 0;
	static int totalRooms = 20;
	static int availableRooms = 20;
	static int bookedRooms = 0;
	static int singleBedRooms = 13;
	static int doubleBedRooms = 5;
	static int suites = 2;
	static int singleRoomPrice = 6000;
	static int doubleRoomPrice = 8000;
	static int suitePrice = 12000;
	static int roomclean = 500;
	static int spa = 800;
	static int gym = 1000;

	public static void menu() {
		System.out.println(
				"\n\t\t**************************\n\t\t  WELCOME TO ELITE HOTEL \n\t\t**************************");

		System.out.println("\n1. Add Customer");
		System.out.println("2. Add Services");
		System.out.println("3. Available/Booked Room Details");
		System.out.println("4. Search Room");
		System.out.println("5. Customer Details");
		System.out.println("6. Generate Bill");
		System.out.println("7. Update");
		System.out.println("8. Delete");
		System.out.println("0. Exit");
		System.out.print("\nEnter your choice: ");
	}

	public static void addCustomer() {
		Customer customer = new Customer();
		System.out.println("\nEnter Customer Information.\n");
		input.nextLine();
		System.out.print("Enter Name: ");
		customer.name = input.nextLine();

		System.out.print("Enter ID: ");
		while (true) {
			try {
				customer.id = Integer.parseInt(input.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.print("Invalid ID. Please enter a valid integer: ");
			}
		}
		System.out.print("Enter phone number: ");
		while (true) {
			try {
				customer.phoneNo = Long.parseLong(input.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.print("Invalid phone number. Please enter a valid integer: ");
			}
		}

		System.out.print("Enter CNIC: ");
		customer.cnic = input.nextLine();

		char roomType;
		System.out.println();
		System.out.println("Type of room? (S for single, D for double, X for suite): ");
		roomType = input.next().charAt(0);

		if (roomType == 'S' || roomType == 's') {
			singleBedRooms--;
			availableRooms--;
			bookedRooms++;
			customer.bill += singleRoomPrice;
			System.out.println("1 Single bedroom booked successfully");
		} else if (roomType == 'D' || roomType == 'd') {
			doubleBedRooms--;
			availableRooms--;
			bookedRooms++;
			customer.bill += doubleRoomPrice;
			System.out.println("1 Double bedroom booked successfully");
		} else if (roomType == 'X' || roomType == 'x') {
			suites--;
			availableRooms--;
			bookedRooms++;
			customer.bill += suitePrice;
			System.out.println("1 Suite booked successfully");
		} else
			System.out.println("Invalid entry!");
		System.out.println();

		customers[i] = customer;
		i++;

		char response;
		System.out.println("-----------------------------\t\nWould you like to book another room? (y/n): ");
		response = input.next().charAt(0);

		if (response == 'y' || response == 'Y')
			addCustomer();
		else if (response == 'N' || response == 'n')
			System.out.println("*****************************\n\tThank you for booking at our hotel.\n");
		else
			System.out.println("Invalid entry!");

	}

	public static void addServices() {
		int serviceChoice;
		System.out.println("\nPress\n1. Room cleaning\n2. Spa\n3. Gym");
		serviceChoice = input.nextInt();

		if (serviceChoice == 1) {
			customers[i - 1].bill += roomclean;
			System.out.println("Room Cleaning service added to bill");
		} else if (serviceChoice == 2) {
			customers[i - 1].bill += spa;
			System.out.println("Spa service added to bill");
		} else if (serviceChoice == 3) {
			customers[i - 1].bill += gym;
			System.out.println("Gym service added to bill");
		}
		System.out.println();
		char response;
		System.out.println("-----------------------------\t\nWould you like other services? (y/n): ");
		response = input.next().charAt(0);

		if (response == 'y' || response == 'Y') {
			addServices();
		} else if (response == 'N' || response == 'n') {
			System.out.println("\t\nThank you for using our services.");
		}
	}

	public static void roomDetails() {
		System.out.println("Total available bedrooms: " + totalRooms);
		System.out.println("Available Single bedrooms: " + singleBedRooms + "/13");
		System.out.println("Available Double bedrooms: " + doubleBedRooms + "/5");
		System.out.println("Available suites: " + suites + "/2");
		System.out.println("BookedRooms: " + bookedRooms);
	}

	public static void searchRoom() {

		System.out.print("Enter customer ID to search: ");
		int id = input.nextInt();
		System.out.println();

		for (int j = 0; j < i; j++) {
			if (customers[j].id == id) {
				System.out.println("Customer found!");
				System.out.println("Name: " + customers[j].name);
				System.out.println("Phone Number: " + customers[j].phoneNo);
				System.out.println("Bill: " + customers[j].bill);
				return;
			}
		}

		System.out.println("Customer not found!");
	}

	public static void update() {

		System.out.print("Enter customer ID to update: ");

		int id = input.nextInt();

		for (int j = 0; j < i; j++) {
			if (customers[j].id == id) {
				input.nextLine();
				System.out.print("Enter new name: ");
				customers[j].name = input.nextLine();
				System.out.print("Enter new phone number: ");
				while (true) {
					try {
						customers[j].phoneNo = Long.parseLong(input.nextLine());
						break;
					} catch (NumberFormatException e) {
						System.out.print("Invalid phone number. Please enter a valid integer: ");
					}
				}
				System.out.print("Enter CNIC: ");
				customers[j].cnic = input.nextLine();
				System.out.println("Customer updated successfully!");
				return;
			}

		}

		System.out.println("Customer not found!");
	}

	public static void delete() {

		System.out.print("Enter customer ID to delete: ");
		int id = input.nextInt();

		for (int j = 0; j < i; j++) {
			if (customers[j].id == id) {
				customers[j] = null;
				i--;
				System.out.println("Customer deleted successfully!\n");
				return;
			}
		}

		System.out.println("Customer not found!");
	}

	public static void showBookingDetails() {
		System.out.println("\nBooking Details:");
		int found = 0;
		for (int j = 0; j < i; j++) {
			System.out.println("Customer Name: \t" + customers[j].name);
			System.out.println("Customer ID: \t" + customers[j].id);
			System.out.println("Customer CNIC: \t" + customers[j].cnic);
			System.out.println("Phone Number: \t" + customers[j].phoneNo);
			System.out.println();

			System.out.println("Bill: \t" + customers[j].bill);

			System.out.println();
			found++;
		}
		if (found == 0) {
			System.out.println();
			System.out.println("No Customer details to show.");
		}
	}

	public static void generateBill() {

		System.out.print("Enter customer ID to generate Bill: ");
		int id = input.nextInt();

		for (int j = 0; j < i; j++) {
			if (customers[j].id == id) {

				System.out.println("\nBill for id \"" + customers[j].id + "\" under customer name \""
						+ customers[j].name + "\"is: ");

				System.out.println("Customer Bill: \t" + customers[j].bill);
				System.out.println();
				return;
			}
		}
		System.out.println("Customer id not found");

	}

	public void exit() {
		System.out.println("\n\t-------------------------------------" + "\n\t THANKYOU FOR USING OUR SERVICES! :)"
				+ " \n\t-------------------------------------");
		System.exit(0);
	}

	public void RunMain() {
		int choice;

		do {
			menu();
			choice = input.nextInt();

			switch (choice) {
			case 1:
				addCustomer();
				break;
			case 2:
				addServices();
				break;
			case 3:
				roomDetails();
				break;
			case 4:
				searchRoom();
				break;
			case 5:
				showBookingDetails();
				break;
			case 6:
				generateBill();
				break;
			case 7:
				update();
				break;
			case 8:
				delete();
				break;
			case 0:
				exit();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
	}



	 public static void main(String[] args) {
	        HotelManagement hm= new HotelManagement();
	        hm.RunMain();
	 }
}