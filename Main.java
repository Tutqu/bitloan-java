import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

class uInfo {


	public final String[] province = {"Alberta", "British Columbia", "Manitoba",
	                                  "New Brunswick", "Newfoundland and Labrador",
	                                  "Nova Scotia", "Ontario", "Prince Edward Island",
	                                  "Saskatchewan"//All provinces except Quebec due to loan system variations
	                                 };

	public final double [] tution = {7734, 6607, 5534, 9470, 3727, 9762, 8514,7728,5445};

	public final double [] loan_in = {4.45,0,0,0,0,0,5.45,0,6.45};



	public final double[] fincome = {80000, 100000, 120000, 190000};
	public final double[] pCon = {100, 200, 300, 500};
	public final String[] careers = {"Scientist", "Accountant", "English Teacher", "Engineer"};
	public String[] programs = {"Science", "Commerce", "Arts", "Engineering"};

	private String userP;
	private double userT;
	private double inc;
	private static double savings;
	private int age = 14;
	private String name = "";
	private String career;
	private String program;
	private String gender = "";


    //getter method: returns savings 
	public double getSavings() {
		return savings;
	}
	
	
	/**
	 * Method that sets double parameter's sum with savings as new savings
	 * @param amount The added quantity to savings
	 * @return None
	 */
	public void setSavings(double amount) {
		savings += amount;
	}

    //Method sets savings as zero and returns the value of savings
	public double resetSavings() {
		savings = 0;
		return savings;
	}

    //getter method: returns age 
	public int getAge() {
		return age;
	}
	
	
	/**
	 * Method that increments age by parameter
	 * @param add_age Value that gets added to age
	 * @return age Variable with updated age
	 */
	public void setAge(int add_age) {
		age += add_age;
	}
	
	//getter method: returns name 
	public String getName() {
		return name;
	}
	
	
	/**
	 * Method that sets name variable to String parameter
	 * @param new_name The String that will replace name value
	 * @return None
	 */
	public void setName(String new_name) {
		name = new_name;
	}
	
	
	//getter method: returns gender
	public String getGender() {
		return gender;
	}
	
	
	/**
	 * Method that sets gender variable to string parameter
	 * @param gen The String value of the new gender
	 * @return gen The updated gender
	 */
	public void setGender(String gen) {
		gender = gen;
	}


	//getter method: returns province
	public String getP() {
		return userP;
	}


    //getter method: returns tuition
	public double getT() {
		return userT;
	}

    
    /**
	 * Method that sets tuition variable to double parameter
	 * @param t The value of the tuition
	 * @return None
	 */
	public void setT(double t) {
		userT= t;
	}
	
	
    /**
	 * Method that sets province variable as String parameter 
	 * @param userP The person's province
	 * @return None
	 */
	public void setP(String userP) {
		this.userP = userP; // use this when using same variable name so that
		//object attribute updates to parameter
	}


    /**
	 * Method that sets career variable, c to String parameter 
	 * @param c The new String career value
	 * @return None
	 */
	public void setC(String c) {
		career = c;
	}

    //getter method: returns career
	public String getC() {
		return career;
	}

    
    /**
	 * Method that sets program variable to String parameter 
	 * @param pro The new String program value
	 * @return None
	 */
	public void setPro(String pro) {
		program = pro;
	}

    //getter method: returns program
	public String getPro() {
		return program;
	}

	//getter method: returns family income
	public double getInc() {
		return inc;
	}


    /**
	 * Method that sets income variable, inc to String parameter 
	 * @param inc The new double value of income 
	 * @return None
	 */
	public void setInc(double inc) {
		this.inc=inc;
	}

}

class Academic extends uInfo {

	public int counter = 0;
	public ArrayList<String> clubs = new ArrayList<>(Arrays.asList("Debate", "Model UN", "BioMed", "HOSA", "DECA", "Physics"));


    /**
	 * Method that asks users questions with 2d array answer keys and validates, by if statements, output messages and savePoints method calls with object p
	 * 
	 * @return None
	 */
	public void study () {

		Scanner sc = new Scanner(System.in);
		final String[][] quiz = {
			{"(2/2)+3^(2+1)", "What is the powerhouse of the cell?", "What force acts upon all objects?"},
			{"What is the capital of Japan?", "What is the chemical formula of water", "Whats the opposite of an integral?"}
		};

		final String [][]answerKey = {
			{"28", "MITOCHONDRIA", "GRAVITY"},
			{"TOKYO", "H2O", "DERIVATIVE"}
		};

		int p1 = (int)(Math.random()*2);
		int p2 = (int)(Math.random()*3);
		String popQ = (quiz[p1][p2]).toUpperCase();
		String popA = (answerKey[p1][p2]).toUpperCase();

		System.out.println("\nYou chose to be productive and study...\nYou look at the sheet. The question reads:");
		System.out.println("\n"+quiz[p1][p2]);
		System.out.print("\nWhat's your answer?\t");
		String answerInput = sc.next().toUpperCase();


		if (answerInput.equals(popA)) {
			System.out.println();
			System.out.println("Correct!");
			Points p = new Points();
			p.savePoints(2);
			System.out.println("It shows that you've been consistently studying. Keep it up!");
		} else {
			System.out.println("You're incorrect. You've been prioritizing other things. Study more next time in order to gain points!");
		}

	}

    
    /**
	 * Method that prints a statement about user hanging out with friends
	 * 
	 * @return None
	 */
	public void friends () {
		System.out.println("\nYou chose to hang out with your friends!\nEnjoyable for the present, but perhaps detrimental to your future...");

	}



    /**
	 * Method that gets user input of club choice based on a menu, and calls method savePoints with object p
	 * 
	 * @return None
	 */
	public void extra() {
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i <= 5-counter; i++) {
			System.out.print((i + 1) + ".[" + clubs.get(i) + "]  ");
		}
		System.out.println();
		System.out.print("\nPick the club you want to join by entering a number: ");
		int club = sc.nextInt();
		System.out.println("\nYou chose to join " + clubs.get(club-1) + " club.");
		clubs.remove(clubs.get(club-1));
		counter ++;
		Points p = new Points();
		p.savePoints(2);
	}

    /**
	 * Method that prints a statement about user skipping class
	 * 
	 * @return None
	 */
	public void skip() {
		System.out.println("\nYou chose to skip! That's not very good...");
		System.out.println("You miss an important lesson and do bad on your test the next day.");
	}
	
	
    /**
	 * Method that prints a statement about user getting a part time job and calls methods, savePoints with object p, and method setSavings
	 * 
	 * @return None
	 */
	public void job() {
		System.out.println("You get a part-time job. Time to make money!");
		Points p = new Points();
		p.savePoints(3);
		setSavings(110);
		System.out.printf("%s $%.2f","\nYour current savings are: ",getSavings(),"\n");

		if (getSavings()>500) {
			Money m2 = new Money(getSavings()*0.10);
			m2.taxes();
		}

	}

}

class University extends Academic {
	Scanner sc = new Scanner(System.in);


    /**
	 * Method that asks users university level randomly generated questions with 2d array answer keys and validates, by if statements, output messages and saveUniPoints method calls with object p and fail method
	 * 
	 * @return None
	 */
	public void studyUni() {
		final String[][] quiz2 = {
			{"What's the only metal liquid at room temp?", "What's the most abundant element on Earth?", "What is the capital of Italy?"},
			{"Who is the author of the text, To be or not to be?", "What measures electrical resistance?", "Whats the basic unit of digital info?"}
		};

		final String [][]answerKey2 = {
			{"MERCURY", "HYDROGEN", "ROME"},
			{"SHAKESPEARE", "OHMS", "BIT"}
		};

		int p1 = (int)(Math.random()*2);
		int p2 = (int)(Math.random()*3);
		String popQ2 = (quiz2[p1][p2]).toUpperCase();
		String popA2 = (answerKey2[p1][p2]).toUpperCase();

		System.out.println("\nYou chose to be productive and study... You look at the sheet. The question reads:");
		System.out.println(quiz2[p1][p2]);
		System.out.print("\nWhat's your answer?: \t");
		String answerInput2 = sc.next().toUpperCase();


		if (answerInput2.equals(popA2)) {

			System.out.println("Correct!");
			System.out.println("It shows that you've been consistently studying. Keep it up!");
			UniPoints unip = new UniPoints();
			unip.saveUniPoints(2);
		} else {
			System.out.println("You've been too busy with other tasks. Money and Happiness are important but you need to study more!");
			fail();
		}
	}
	
	
	/**
	 * Method that prints a statement about user partying
	 * 
	 * @return None
	 */
	public void party() {
		System.out.println("You decide to go party...");
		System.out.println("It ended up not even being that fun... You feel tired the next day and fell behind on class work.");

	}
	
	
	/**
	 * Method that prints a statement about user failing, calls method setSavings with negative parameter and prints getSavings value
	 * 
	 * @return None
	 */
	public void fail() {
		System.out.println("Because of your lack of studying... You failed your course!");
		System.out.println("You just got the notice... Retaking the course cost you $800");
		setSavings(-800.00);
		System.out.println("Your current savings are:" + getSavings());

	}


    /**
	 * Method that gets user to decide between job positions via a list, gets user input, and calls method saveUniPoints with object unip
	 * 
	 * @return None
	 */
	public void job() { 
		final String[] positions = {"Software Developer Intern", "Finance Intern", "Research Assistant Intern", "Science Laboratory Intern"};
		for(int i=1; i <=4; i++) {
			System.out.print(i + ".[" + positions[i-1] + "]\n");
		}
		System.out.print("\nPick which position you want above by entering a number: ");
		int pos = sc.nextInt();
		System.out.println("\nYou got an internship position as a: " + positions[pos-1]);

		UniPoints unip = new UniPoints();
		unip.saveUniPoints(5);

	}
}


class Money extends uInfo {
	public double spent;
	public double tax;
	
	//Constructor of Money class without parameters
	Money() {
		spent = -1*(int)(Math.random()*61);
		//Randomly generated spending
	}


    //Constructor of Money class with parameters
	Money (double taxl) {
		tax = 1*(Math.random()*taxl);
	}


    /**
	 * Method that prints a statement about user chosing to be an entreneur, providing a list for user selection, randomizing income from a 1d array, and calling getSavings 
	 * 
	 * @return None
	 */
	public void ep() {
		System.out.println("\nYou started a business. Nice decision, entrepreneur!");

		final String[] jobEnt = {"Website", "Ecommerce", "Etsy", "Tutoring service", "Media commisions", "Digital Freelance"};
		final int[] jobPay = {20, 40, 15, 45, 30, 65};
		int jobRand = (int)(Math.random()*6);

		System.out.println("\n\tYou set up your business: A(n) " + jobEnt[jobRand]);
		System.out.println("\tYou made: $" + jobPay[jobRand]);
		setSavings(jobPay[jobRand]); //Adding income to savings
		System.out.printf("%s $%.2f","\nYour current savings are: ",getSavings(),"\n");

		Points p = new Points();
		p.savePoints(5);

	}


    /**
	 * Method that prints a statement about user spending, and randomizes both the scenario and spent amount, calling setSavings to update savings and getSavings to show user savings
	 * 
	 * @return None
	 */
	public void spend() {
		final String[] shopping = {"You got some new clothes!", "You spent some money to go to Downtown!", "You went out for lunch!", "You got a new membership!", "You went to a concert!", "You bought some study books!"};
		int jobRand = (int)(Math.random()*6);
		System.out.println("\t" + shopping[jobRand]);

		System.out.println("\tYou spent: $" + spent);
		setSavings(spent);
		System.out.printf("%s $%.2f","\nYour current savings are: ",getSavings(),"\n");

		
	}


    /**
	 * Method that prints statements about user getting taxed and adds decrement to setSavings method 
	 * 
	 * @return None
	 */
	public void taxes() {
		System.out.println("\nYou have been charged tax on your salary becuse your earnings are over 500!");
		System.out.printf("%s $%.2f","\tYou have been taxed: ",tax );
		setSavings((-1*tax));
		System.out.printf("%s $%.2f","\nYour current savings are: ",getSavings(),"\n");

	}
}


class Application extends uInfo {
	Scanner sc = new Scanner(System.in);

    //atributes associated with loan method
	public double grant;
	public double loan;
	public double loanf;
	public double loanp;
	public double total;

    
    /**
	 * Method that prints university options, get user to pick, and uses randomly generated arrays to display which university they got into
	 * 
	 * @return None
	 */
	public void uni () {
		final String[] unis = {"UWaterloo", "YorkU", "UofT", "UBC", "UAlberta", "UManitoba", "USask", "McGill", "Dalhousie"};
		System.out.println("\nYou're applying to University!");
		System.out.println("Which option from the list do you want to apply to?");
		System.out.println("\n\n\tOption\t\tUniversity");
		System.out.println("------------------------------------------------");
		int uni_option1;
		int uni_option2;
		int uni_option3;
		for(int i = 0; i<unis.length; i++) {
			System.out.print("\t"+(i+1) + "\t\t" + unis[i] + "\n");
		}

		do {
			System.out.println();
			System.out.print("Enter your first option number:\t");
			uni_option1 = sc.nextInt()-1;
		}   while (uni_option1 <0 || uni_option1>8);


		do {
			System.out.print("Enter your second option number: ");
			uni_option2 = sc.nextInt()-1;
		}   while (uni_option2 <0 || uni_option2>8);

		do {
			System.out.print("Enter your third option number:\t");
			uni_option3 = sc.nextInt()-1;
		}   while (uni_option3 <0 || uni_option3>8);

		int [] uni_options = {uni_option1,uni_option2,uni_option3};
		int auni =(int)(Math.random()*3);
		int cuni = uni_options[auni];
		System.out.println("You have been accepted to: "+ unis[cuni]);

	}


    /**
	 * Method that prints loan statement information and informs user of loans and grant information relative to their data with the use of many getter and setter methods from uInfo
	 * @param person Object of type class uInfo that allows the method to use information such as person's province, income, savings, etc
	 * @return None
	 */
	public void loans(uInfo person) {
		System.out.println();

		System.out.println("\n========== STUDENT LOAN APPLICATION ==========\n");

        System.out.println("You are applying for student loans.");
        System.out.println("You need to use the calculator to determine eligibility.");
        
        System.out.println("\nPERSONAL INFORMATION");

		System.out.println();
		System.out.println("After entering your personal info: \n\t1.Name \n\t2.D.O.B \n\t3.Address \n\t4.Citizenship status \n\t5.Social Insurance Number (SIN)");


		System.out.println("\nYou start with entering for a Bachelors of " +person.getPro()+ " full time.");

		System.out.println("Your program's tuition: $"+person.getT());
		System.out.println();

		System.out.println("You proceed... Entering your parents' marital status & your dependents.\n");
		System.out.println("\tYou look at the applicant form... You enter your province, assets, and family income:");
		System.out.println("\tBased on your province, " + person.getP() + "and your assets: " + person.getSavings() + " and your family income: $" + person.getInc() +"\n");

		System.out.println("You proceed... You enter line 15000 and line 43500 from your parents' notice of assesment from the CRA.");
		System.out.println("These lines provide the parent's gross income and their tax payable respectivley ");

		System.out.println("\nLOADING>>>");
		System.out.println();



		if (person.getInc() == 80000) {
			grant = 0.40*person.getT();
			loan = 0.60*person.getT();
			loanf = loan*0.70;
			loanp= loan*0.30;
			total = grant+loan;

			System.out.print(person.getName() + " you have been approved for a student loan application:");
			System.out.println();
			System.out.printf("\n%s $%.2f","Calculated: ",total);
			System.out.printf("\n%s $%.2f","Grant: ",grant);
			System.out.printf("\n%s $%.2f","Loan: ",loan);
			System.out.printf("\n%s $%.2f","Federal portion of Loan: ",loanf);
			System.out.printf("\n%s $%.2f","Provincial portion of Loan: ",loanp);


			System.out.println("\nYour finacial assistance covers the cost of your yearly tution!");
		}


		else if (person.getInc() == 100000) {
			grant = 0.30*person.getT();
			loan = 0.60*person.getT();
			loanf = loan*0.70;
			loanp= loan*0.30;
			total = grant+loan;

			System.out.print(person.getName() + " you have been approved for a student loan application:");
			System.out.println();
			System.out.printf("\n%s $%.2f","Calculated: ",total);
			System.out.printf("\n%s $%.2f","Grant: ",grant);
			System.out.printf("\n%s $%.2f","Loan: ",loan);
			System.out.printf("\n%s $%.2f","Federal portion of Loan: ",loanf);
			System.out.printf("\n%s $%.2f","Provincial portion of Loan: ",loanp);

			System.out.println("\nYour finacial assistance does NOT cover the cost of your yearly tution :(");
		}

		else if (person.getInc() == 120000) {
			grant = 0.20*person.getT();
			loan = 0.55*person.getT();
			loanf = loan*0.70;
			loanp= loan*0.30;
			total = grant+loan;

			System.out.print(person.getName() + " you have been approved for a student loan application:");
			System.out.println();
			System.out.printf("\n%s $%.2f","Calculated: ",total);
			System.out.printf("\n%s $%.2f","Grant: ",grant);
			System.out.printf("\n%s $%.2f","Loan: ",loan);
			System.out.printf("\n%s $%.2f","Federal portion of Loan: ",loanf);
			System.out.printf("\n%s $%.2f","Provincial portion of Loan: ",loanp);

			System.out.println("\nYour finacial assistance does NOT cover the cost of your yearly tution :(");
		}

		else if (person.getInc() == 190000) {
			grant = 0.15*person.getT();
			loan = 0.50*person.getT();
			loanf = loan*0.70;
			loanp= loan*0.30;
			total = grant+loan;

			System.out.print(person.getName() + " yearlyou have been approved for a student loan application:");
			System.out.println();
			System.out.printf("\n%s $%.2f","Calculated: ",total);
			System.out.printf("\n%s $%.2f","Grant: ",grant);
			System.out.printf("\n%s $%.2f","Loan: ",loan);
			System.out.printf("\n%s $%.2f","Federal portion of Loan: ",loanf);
			System.out.printf("\n%s $%.2f","Provincial portion of Loan: ",loanp);

			System.out.println("\nYour finacial assistance does NOT cover the cost of your yearly tution :(");
		}



		System.out.println("\nYou just need to send proof of enrollment & submit.");
		System.out.print("Do you confirm the data above? y/n: ");
		Scanner sc = new Scanner(System.in);

		String submitAns = sc.next();
		while (!submitAns.toUpperCase().equals("Y")) {
			System.out.print("Review your information again.");
			System.out.print("Do you confirm the data above? y/n: ");
			submitAns = sc.next();
		}
		String sign ="";
		while (!(sign.equals(person.getName()))) {
			System.out.print("\nThank you for reviewing. Please sign your name to confirm: ");
			sign = sc.next();
			System.out.println("Student Loan Application Complete.");
			System.out.println("Your getting closer to your career goal of becoming a(n) "+person.getC());

		}

	}

}




class Points {
	public int points;

    /**
     * Method uses FileWriter imported to create a file to update loadPoints() method with an integer value and write that sum onto the file; try catch for errors
     * @param s The integer value that will be added to the currently existing value on the file
     * @return None
     */
	public void savePoints(int s) {
		try {
			int ans = loadPoints() + s;

			FileWriter fileWriter = new FileWriter("savePts.txt");
			fileWriter.write(String.valueOf(ans));
			fileWriter.close();

			System.out.println("\nProgress made!");

		} catch (IOException e) {
			System.out.println("An error occurred while trying to save the file.");
		}
	}


    /**
     * Method uses FileReader imported to read file, check for end of file, eliminate whitespace, and return the integer value of the contents of the file 
     * 
     * @return integer value of file, or 0 if errors met
     */
	public int loadPoints() {

		try {
			FileReader fileReader = new FileReader("savePts.txt");

			String data = "";
			int character;

			while ((character = fileReader.read()) != -1) {
				data += (char) character;
			}

			fileReader.close();

			data = data.trim();

			if (data.equals("")) {
				return 0;
			}

			return Integer.parseInt(data);

		} catch (IOException e) {
			return 0;
		}


	}
}

class UniPoints {
	public int Unipoints;

    /**
     * Method uses FileWriter imported to create a file to update loadUniPoints method with "integer", tell user of progress and write that sum onto the file; try catch for errors
     * @param s The integer value that will be added to the currently existing value on the file
     * @return None
     */
	public void saveUniPoints(int s) {
		try {
			int ans = loadUniPoints() + s;

			FileWriter fileWriter = new FileWriter("saveUniPts.txt");
			fileWriter.write(String.valueOf(ans));
			fileWriter.close();

			System.out.println("\nProgress made!");

		} catch (IOException e) {
			System.out.println("An error occurred while trying to save the file.");
		}
	}


     /**
     * Method uses FileReader imported to read file, check for end of file, eliminate whitespace, and return the integer value of the contents of the file 
     * 
     * @return integer value of file, or 0 if errors met
     */
	public int loadUniPoints() {

		try {
			FileReader fileReader = new FileReader("saveUniPts.txt");

			String data = "";
			int character;

			while ((character = fileReader.read()) != -1) {
				data += (char) character;
			}

			fileReader.close();

			data = data.trim();

			if (data.equals("")) {
				return 0;
			}

			return Integer.parseInt(data);

		} catch (IOException e) {
			return 0;
		}


	}
}


public class Main {

     /**
     * Method resets files relatred to points and university poiunts by writing value of 0 and uses try catch to catch errors
     * 
     * @return None
     */
	public static void reset() {
		try {
			FileWriter fw = new FileWriter("savePts.txt");
			fw.write("0");
			fw.close();

			FileWriter fw2 = new FileWriter("saveUniPts.txt");
			fw2.write("0");
			fw2.close();

			System.out.println("Game data reset.");

		} catch (IOException e) {
			System.out.println("Error resetting game data.");
		}

	}
	
    //Main method that contains welcome statements, critical swicth case statements, and variables to give the game the ability to be replayed
	public static void main(String args[]) {
		boolean play;

		Scanner sc = new Scanner(System.in);

		System.out.println("BITLOAN");
		System.out.println("Main Menu");
		System.out.print("Play y/n:\t");
		String choice = sc.next().toLowerCase();

		while (!choice.equals("y") && !choice.equals("n")) {
			System.out.print("Invalid input. Play y/n:\t");
			choice = sc.next().toLowerCase();
		}

        //User decided to play
		if (choice.equals("y")) {
			System.out.println();
			play = true;
			uInfo person = new uInfo();
			System.out.printf("Enter your name: ");
			person.setName(sc.next());
			do {
			    System.out.print("Enter your gender: girl/boy: ");
				person.setGender(sc.next());
			} while (!(person.getGender().toUpperCase().equals("GIRL") || person.getGender().toUpperCase().equals("BOY")));

			//Generate province, set tution rate, and interest rate for loanp
			int prov=(int)(Math.random()*9);
			String pprovince = person.province[prov];
			person.setP(pprovince);
			double t = person.tution[prov];
			person.setT(t);
			double loan_ir = person.loan_in[prov];


			//Generate family income and contribution
			int fnum=(int)(Math.random()*4);
			double income = person.fincome[fnum];
			person.setInc(income);
			double con = person.pCon[fnum];


			//Generate career and program
			int cnum=(int)(Math.random()*4);
			String job = person.careers[cnum];
			person.setC(job);
			String pro = person.programs[cnum];
			person.setPro(pro);

			//Welcome Statement and brief message.
			System.out.println("\nWelcome to BITLOAN, "+person.getName()+ " 👋 \nYou are a 14-year-old " + person.getGender() + ", and have just entered highschool.");
			System.out.println("\nYour mission: To become a(n) " + job);

            //Print user's info including randomly generated values
			System.out.printf("\n---------------------------------------------------------------");
			System.out.printf("\n%27s\n","Your Personal Info");
			System.out.printf("\nProvince where you live:\t\t %s", pprovince);
			System.out.printf("\nYour family Income:\t\t\t $%.2f", income);
			System.out.printf("\nYour family contribution:\t\t $%.2f", con);
			System.out.printf("\nYour career goal:\t\t\t %s", job);

			System.out.printf("\n---------------------------------------------------------------");
			System.out.printf("\n%27s","Let's get started!");

			int con_c =0; // Control number of yearly parent contributions in highschool
			
			//Controls while loop
			boolean decision = true;
			boolean decision_u = false;
			
			//Creates objects of needed classes
			Money m = new Money();
			Academic a = new Academic();
		
			while (decision && play) { //Controls printing of highschool main menu

				Points p = new Points();

                //If highschool points are or exceed 20, person is promoted to university 
				if (p.loadPoints() >= 20) {
					decision = false;
					decision_u = true;
					System.out.printf("\n---------------------------------------------------------------");
					System.out.printf("\nYay " + person.getName() + "! You just turned 18! Time for University Life!");
					break;
				}

				if (p.loadPoints()%5==0 && p.loadPoints()>0 && con_c<4) {
					person.setSavings(person.pCon[fnum]);
					con_c++;

				}

				System.out.printf("\n---------------------------------------------------------------");
				System.out.print("\n\n1.[Academics]   2.[Money]   3.[Quit]\n");
				System.out.printf("\nPick an option above by entering a number: ");
				int option = sc.nextInt();

				switch (option) {//Controls printing sub menus 
				case 1:
					System.out.println("\n1.[Study]  2.[Friends]  3.[Skip]  4.[Part-time]  5.[Join Extracurricular]\n");
					System.out.print("Pick an option above by entering a number: ");
					int c = sc.nextInt();

					switch (c) { //Controls the access to the method user chooses from sub menu
					case 1:
						a.study();
						break;
					case 2:
						a.friends();
						break;
					case 3:
						a.skip();
						break;
					case 4:
						a.job();
						break;
					case 5:
						a.extra();

					}
					break;

				case 2:
					System.out.print("\n1.[Spend]  2.[Start a Business]\n");
					System.out.print("\nPick an option above by entering a number: ");
					int d = sc.nextInt();
					switch (d) {
					case 1:
						m.spend();
						break;
					case 2:
						m.ep();
						break;
					}
					break;

				case 3://Quits game by breaking out of while loop
					decision = false;
					play = false;
					System.out.printf("\n----------------------------------------------\n");
					System.out.println("Goodbye.");
					break;

				}
			}




            //University related object creation
			University u = new University();
			Application app = new Application();
			
			int option;//User's main menu choice
			
			//Control user's stage in game and manages conditions for ifs and while loop
			boolean applied = false;
			boolean grad = false;
			boolean uniApplied = false;
			boolean loansApplied = false;
			
			while(decision_u && play) {

				UniPoints unip = new UniPoints();

				if (unip.loadUniPoints() >= 20) {// Makes user garduate if point = or excceed 20
					decision_u = false;
					grad = true;
					System.out.printf("\n----------------------------------------------");
					System.out.printf("\nYay " + person.getName() + "! You graduated! Time for Career hunting!!\n");
					break;
				}

				System.out.printf("\n---------------------------------------------------------------");
				if (!(uniApplied && loansApplied)) {
					System.out.print("\n\n1.[University]   2.[Spend]   3.[Applications]   4.[Quit]\n");
					System.out.print("\nPick an option above by entering a number: ");
					option = sc.nextInt();
				}
				else {
					System.out.print("\n\n1.[University]   2.[Spend]   4.[Quit]\n");
					System.out.print("\nPick an option above by entering a number: ");
					option = sc.nextInt();
				}

				switch (option) {
				case 1:
					if (applied) { //University menu after user has applied 

						System.out.println("\n1.[Study]  2.[Party]  3.[Internship]\n");
						System.out.print("Pick an option above by entering a number: ");
						int c = sc.nextInt();

						switch (c) {
						case 1:
							u.studyUni();
							break;
						case 2:
							u.party();
							break;
						case 3:
							u.job();
							break;
						}

					}
					else {
						System.out.print("Apply to University first! Choose 'Applications'");
					}
					break;


				case 2:
					m.spend(); //Acesses spend method from money class object previously made 
					break;

				case 3:

					if (uniApplied && loansApplied) { //Stops user from accessing applications 
						System.out.println("You have already completed all applications.");
						break;
					}

					System.out.print("\n1.[Apply to University]  2.[Apply for Student Loans]\n");
					System.out.print("\nPick an option above by entering a number: ");
					int e = sc.nextInt();

					switch (e) { //Checks application status for loan and uni

					case 1:

						if (!uniApplied) {
							app.uni();
							applied = true;
							uniApplied = true;
						}
						else {
							System.out.println("You have already applied to university.");
						}

						break;

					case 2:

						if (!loansApplied) {
							app.loans(person);
							loansApplied = true;
						}
						else {
							System.out.println("You have already applied for student loans.");
						}

						break;
					}

					break;


				case 4://Quits game by exiting the university while loop
					decision_u = false;
					play = false;
					System.out.printf("\n----------------------------------------------\n");
					System.out.println("Goodbye. Thanks for playing :)");
					break;

				}

			}

            //Person has graduated from university: Applying for a job
			if(grad) {
			    System.out.println("\n==============================================");
                System.out.println("               CAREER SEARCH");
                System.out.println("==============================================");
				System.out.println("Apply to your desired career.");

				int months=0;
				boolean career=false;

				do { //Month counter, Job search
					System.out.println("MONTH: " + months);
					System.out.println("You open Indeed and search up your job position: " + job);
					System.out.print("APPLY? y/n:\t");
					String applyAns = sc.next().toUpperCase();
					System.out.println();
					int jobDecision = 0;

                    //Applies for job position
					if(applyAns.equals("Y")) {
						System.out.println("You click send... You've sent out your application for several job positions.");
						System.out.println("A couple days later, you check your email:");
						jobDecision = (int)(Math.random() * 2);

                        //Got the job
						if (jobDecision==0) {
							career=true;
							System.out.println("-----------SUCCESS!-----------");
							months = 6;
							System.out.print("\tYou landed the job! You have the position of: " + job);
						} else {
						    //Didn't get the job, months increment
							career=false;
							months++;
							System.out.print("\tYou got rejected :( It's okay. You have the next month to send out another series of applications!"+"\n");
						}
					}

				} while(grad && career==false || months<6); //Conditions for still being in a job hunt

				if (months==6 && career==false) { //If person doesn't land a job until 6 months...
					career=true;
					months = 6;
					System.out.print("\n\tYou landed the job! You have the position of a(n): " + job);
				}


                //Final messages to user about job, loans, and info:
				System.out.print("\n\nCONGRATULATIONS on becoming a " + job+"\n");
				System.out.println("You still got student loans to pay off though...\nBelow is the breakdown:");
				System.out.println("STUDENT LOANS ACCUMULATED OVER 4 YEARS");
				System.out.printf("\n%s $%.2f %s","Federal loan:",(4*app.loanf),"*interest free portion");
				System.out.println();
				System.out.printf("%s $%.2f","Provincial loan:",(4*app.loanp));
				System.out.println();
				double ia = 0.0;
				if (loan_ir== 0.0){
				    System.out.println("\nYour province "+pprovince+" has no interest on student loans!!");
				}
				else {
				    	System.out.println("\tInterest rate on student loan is: "+loan_ir);
				    	System.out.println();
        				ia = loan_ir*(4*app.loanp);
        				System.out.printf("\t%s $%.2f","Interest that will accumulate after six month grace period:", ia);
				}
			
				double loangt = ia + (4*app.loanp)+ (4*app.loanf);
				System.out.printf("\n%s $%.2f","LOAN GRAND TOTAl:",loangt,"\n");
				System.out.println();
				System.out.println("\nThe amount of time taken to payback your loan will vary...");
				System.out.println("The average amount of time is 9.5 years and this can be extened to 14.5 years depending on circumsatnces");
				System.out.println();
				System.out.println("Good Luck paying back the loans :)!!");
				System.out.println("Thanks for playing BIT LOAN!!!");
				System.out.print("\nPlay again? (y/n): ");
				String again = sc.next();

                //Play again condition:
				if (again.equalsIgnoreCase("y")) {
					reset();
					person.resetSavings();
					main(args);
				} else {
					System.out.printf("\n----------------------------------------------\n");
					System.out.println("Goodbye.)");
				}



			}

		} //Person does not want to play:
		else if (choice.equals("n")) {
			play = false;
			System.out.printf("\n----------------------------------------------\n");
			System.out.println("Goodbye :)");

		}
	}

}

