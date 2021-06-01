import java.text.*;
import java.util.*;
public class Prog4
{
  //This method asks the user for input on status of filing
public static void main(String[] args)
{

  //Below is the declaration of variables.
  int filing;  
  Scanner keyboard = new Scanner(System.in);

  //These statements initialize the income and updatedIncome variable.

  //Below asks the user for input to determine status of filing
System.out.println("Enter the status of filing.");
System.out.println("1 represents filing as a single resident;");
System.out.println("2 represents married filing jointly;");
System.out.println("3 represents filing as a surviving spouse;");
System.out.println("4 represents married filing separately;");
System.out.println("5 represents filing as the head of a household;");
filing = keyboard.nextInt();

  //The following creates a while loop to validate the input.
  while (filing < 1 || filing > 5)
{
System.out.println("Invalid! Try again!");
filing = keyboard.nextInt();
}

double income = calcTotalIncome(); 
double federalIncome = calcFedAdjustedIncome(income,filing);
double incomeTax = calcIncomeTax(federalIncome);
outputResults(income,federalIncome,incomeTax);
}



  //The following method creates a while group for input of the incomes.
public static double calcTotalIncome()
{
	Scanner keyboard = new Scanner(System.in);
	double income = 1;
	double updatedIncome = 0;
while (income > 0)
{    
System.out.println("Enter income: ");
income = keyboard.nextDouble();
if (income > 0)
updatedIncome = updatedIncome + income;
}
return updatedIncome;
}





  //The next method is a switch statement to find the federalIncome.
public static double calcFedAdjustedIncome(double updatedIncome,int filing) 
{
double federalIncome = 0;
int deduction = 0;
switch (filing)
{
  case 1: deduction = 12200;
        break;
  case 2: deduction = 24400;
        break;
  case 3: deduction = 24400;
        break;
  case 4: deduction = - 12200;
        break;
  case 5: deduction = 18350;
        break;
  default: deduction = 0;
}

    //The method intitalizes the federal adjusted income.
if (updatedIncome > deduction)
federalIncome = updatedIncome - deduction;
else
federalIncome = 0;
return federalIncome;
}

    //This method finds the income tax.
public static double calcIncomeTax(double federalIncome)
{
double incomeTax= 0;
incomeTax = federalIncome * .15;
return incomeTax;
}

    //This method gives the users the appropriate outputs.
public static void outputResults(double totalIncome,double federalIncome,double incomeTax) {
DecimalFormat moneyStyle = new DecimalFormat("$0.00");
System.out.println("Total incomes: " + moneyStyle.format(totalIncome));
System.out.println("Federal adjusted income: " + moneyStyle.format(federalIncome));
System.out.println("Income tax: " + moneyStyle.format(incomeTax));
}
}