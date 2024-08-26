package IO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

import Logger.Logger;

public class Input {
	
    public static String getPhoneNumber() {
    	final String PHONE_PATTERN = "^[0-9]+$";
        String phoneNumber = "";
        boolean rep;
        do {
            rep = false;
            Logger.log("Enter your phone number: ");
            phoneNumber = ScannerProvider.getScanner().nextLine();
            if (!phoneNumber.matches(PHONE_PATTERN)) {
                rep = true;
                Logger.error("The phone number must contain only digits\nTry Again:\n");
            }
        } while (rep);
        return phoneNumber;
    }
	
    public static String getName(String fieldName) {
        String name = "";
        final String NAME_PATTERN = "^[a-zA-Z ]+$";
        boolean rep;
        do {
            rep = false;
            Logger.log("Enter your "+ fieldName + ": ");
            name = ScannerProvider.getScanner().nextLine();
            if (!name.matches(NAME_PATTERN)) {
                rep = true;
                Logger.error(" The name must contain only alphabetic characters and spaces\nTry Again:\n");
            }
        } while (rep);
        return name;
    }
	
	public static int getInt() { 
		
		int number = 0;
		boolean rep;
		do {
			rep = false;
			try {
				number = ScannerProvider.getScanner().nextInt();
			} catch (InputMismatchException ex) { 
				rep = true;
				Logger.error(" The input must be an Integer\nTry Again:\n");
				ScannerProvider.getScanner().nextLine();
			} catch (Exception ex) {
				Logger.log(ex.getMessage());
			}
		} while (rep);
		ScannerProvider.getScanner().nextLine();
		return number;
	}
	
	public static int getNumberInRange(int from, int to) {
		int num = 0;
		boolean rep;
		do {
			rep = false;
			try {
				num = ScannerProvider.getScanner().nextInt();
				
				if (num < from || num > to) {
					rep = true;
					ScannerProvider.getScanner().nextLine();
					Logger.error(" number out of range, you have to choose a number between "+ from + " - " + to + "\nTry Again:\n");
				}
				
			} catch(InputMismatchException ex) {
				rep = true;
				Logger.error(" The input must be an Integer\nTry Again:\n");
				ScannerProvider.getScanner().nextLine();
			} catch (Exception ex) {
				Logger.log(ex.getMessage());
			}
			
		}while (rep);
		ScannerProvider.getScanner().nextLine();
		return num;
	}
	
	public static int getNumberInRange(int from, int to, String msg) {
		int num = 0;
		boolean rep;
		do {
			Logger.log(msg + ": ");
			rep = false;
			try {
				num = ScannerProvider.getScanner().nextInt();
				
				if (num < from || num > to) {
					rep = true;
					ScannerProvider.getScanner().nextLine();
					Logger.error(" number out of range, you have to choose a number between "+ from + " - " + to + "\nTry Again:\n");
				}
				
			} catch(InputMismatchException ex) {
				rep = true;
				Logger.error(" The input must be an Integer\nTry Again:\n");
				ScannerProvider.getScanner().nextLine();
			} catch (Exception ex) {
				Logger.log(ex.getMessage());
			}
			
		}while (rep);
		ScannerProvider.getScanner().nextLine();
		return num;
	}
	
    public static int getIDFromUser() {
        int num = 0;
        boolean rep;
        do {
            rep = false;
            Logger.log("Enter your ID (a 9-digit number): ");
            try {
                num = ScannerProvider.getScanner().nextInt();
                
                // Check if the number has exactly 9 digits
                if (String.valueOf(num).length() != 9) {
                    rep = true;
                    ScannerProvider.getScanner().nextLine(); // Clear the buffer
                    Logger.error(" The number must have exactly 9 digits\nTry Again:\n");
                }
                
            } catch (InputMismatchException ex) {
                rep = true;
                Logger.error(" The input must be an Integer\nTry Again:\n");
                ScannerProvider.getScanner().nextLine(); // Clear the buffer
            } catch (Exception ex) {
                Logger.log(ex.getMessage());
            }
            
        } while (rep);
        ScannerProvider.getScanner().nextLine(); // Clear the buffer
        return num;
    }
    
    public static int getIDFromUser(String msg) {
        int num = 0;
        boolean rep;
        do {
            rep = false;
            Logger.log(msg + " (a 9-digit number): ");
            try {
                num = ScannerProvider.getScanner().nextInt();
                
                // Check if the number has exactly 9 digits
                if (String.valueOf(num).length() != 9) {
                    rep = true;
                    ScannerProvider.getScanner().nextLine(); // Clear the buffer
                    Logger.error(" The number must have exactly 9 digits\nTry Again:\n");
                }
                
            } catch (InputMismatchException ex) {
                rep = true;
                Logger.error(" The input must be an Integer\nTry Again:\n");
                ScannerProvider.getScanner().nextLine(); // Clear the buffer
            } catch (Exception ex) {
                Logger.log(ex.getMessage());
            }
            
        } while (rep);
        ScannerProvider.getScanner().nextLine(); // Clear the buffer
        return num;
    }
    
    public static LocalDate getPastDate(String description) {
        LocalDate birthdate = null;
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        boolean rep;
        do {
            rep = false;
            Logger.log("Enter your "+ description + " (dd-MM-yyyy): ");
            String input = ScannerProvider.getScanner().nextLine();
            try {
                birthdate = LocalDate.parse(input, formatter);
                if (birthdate.getYear() > LocalDate.now().getYear())
                {
                	Logger.error(" Invalid date. Please Try Again:\n");
                	rep = true;
                }
                
            } catch (DateTimeParseException ex) {
                rep = true;
                Logger.error(" The input must be a valid date in the format dd-MM-yyyy. Please Try Again: ");
            } catch (Exception ex) {
                Logger.log(ex.getMessage());
            }
            
        } while (rep);
        return birthdate;
    }
    
    public static LocalDate getDate(String dateDescription) {
        LocalDate date = null;
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        boolean rep;
        do {
            rep = false;
            Logger.log("Enter "+ dateDescription + " (dd-MM-yyyy): ");
            String input = ScannerProvider.getScanner().nextLine();
            try {
                date = LocalDate.parse(input, formatter);
                if (date.getYear() > LocalDate.now().getYear())
                {
                	Logger.error(" Invalid date. Please Try Again:\n");
                	rep = true;
                }
                
            } catch (DateTimeParseException ex) {
                rep = true;
                Logger.error(" The input must be a valid date in the format dd-MM-yyyy. Please Try Again:\n ");
            } catch (Exception ex) {
                Logger.log(ex.getMessage());
            }
            
        } while (rep);
        return date;
    }
    
    
	
	public static boolean getBoolean() {
		boolean rep;
		boolean val = false;
		do {
			rep = false;
			try {
				val = ScannerProvider.getScanner().nextBoolean();
			} catch (InputMismatchException ex) {
				rep = true;
				Logger.error(" invalid input\nPlease Enter 'True' or 'False':");
				ScannerProvider.getScanner().nextLine();
			} catch (Exception ex) {
				Logger.error(ex.getMessage());
			}
		} while (rep);
		
		return val;
	}
	
    
    public static String getString(String prompt) {
        Logger.log("Please enter " + prompt + ":");
        return ScannerProvider.getScanner().nextLine();
    }
    
    public static LocalTime getTime(String timeDescription) {
        LocalTime time = null;
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        boolean rep;
        do {
            rep = false;
            Logger.log("Enter " + timeDescription + " (HH:mm): ");
            String input = ScannerProvider.getScanner().nextLine();
            try {
                time = LocalTime.parse(input, formatter);
            } catch (DateTimeParseException ex) {
                rep = true;
                Logger.error(" The input must be a valid time in the format HH:mm. Please Try Again:\n ");
            } catch (Exception ex) {
                Logger.log(ex.getMessage());
            }
            
        } while (rep);
        return time;
    }
    

}
