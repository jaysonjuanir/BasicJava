import java.util.*;
public class ActivityBasicJava{
	static Random rnd = new Random();
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	public static void main(String []args)throws Exception{
 		Scanner sc = new Scanner(System.in);
 		String arrayDeclare [][][]=new String[0][0][0];// = new String[2][3][2];
 		/*arrayList[0][0][0] = "q";
 		arrayList[0][0][1] = "w";
 		arrayList[0][1][0] = "e";
 		arrayList[0][1][1] = "r";
 		arrayList[0][2][0] = "t";
 		arrayList[0][2][1] = "y";
 		arrayList[1][0][0] = "u";
 		arrayList[1][0][1] = "i";
 		arrayList[1][1][0] = "o";
 		arrayList[1][1][1] = "p";
 		arrayList[1][2][0] = "a";
 		arrayList[1][2][1] = "s";
		*/int iSetRows=0;
		int iSetColumns=0;
		int iSetArrayValue;

		boolean indicatorForRowsAndColumns = true;
 		boolean indicator = true;
 		int inputNumber = 0;
		
		
		while(indicatorForRowsAndColumns){
			try{
				System.out.println("Enter number of Rows to generate");
				iSetRows = sc.nextInt();
				arrayDeclare = new String[iSetRows][][];
				System.out.println("Enter number of Columns to generate");
				iSetColumns = sc.nextInt();
				
				if(iSetRows==0 || iSetColumns ==0){
					throw new Exception("Invalid input");
				}	
				for(int forRow=0;forRow<iSetRows;forRow++){
					arrayDeclare[forRow] = new String[iSetColumns][];
					for(int forColumn=0;forColumn<iSetColumns;forColumn++){
						iSetArrayValue=1+(int) (Math.random()*3);
						arrayDeclare[forRow][forColumn] = new String[iSetArrayValue];
						for(int forValue=0;forValue<iSetArrayValue;forValue++){
							arrayDeclare[forRow][forColumn][forValue] = randomString(1+ (int) (Math.random()*3));
						}
					}
				}
				indicatorForRowsAndColumns=false;
				
				print(arrayDeclare);
			}
			catch(Exception ex){
				System.out.println("Try Again: "+ ex.getMessage());
				sc = new Scanner(System.in);
			}
		}
		String arrayList[][][] = arrayDeclare;
 		while(indicator){
			
			try{
				System.out.println("Enter Number");
				System.out.println("1.Add");
				System.out.println("2.Edit");
				System.out.println("3.Print");
				System.out.println("4.Exit");
				
				inputNumber = sc.nextInt();
				switch(inputNumber){
					case 1:
						System.out.println("Enter number of row");
						int numRow = sc.nextInt()-1;
						System.out.println("Enter number of column");
						int numColumn = sc.nextInt()-1;
						System.out.println("Enter new Value");
						String newInput = sc.next();
						if(numRow<0||numRow>arrayList.length || numColumn<0 || numColumn>arrayList[numRow].length){
							System.out.println("Out of Bounds"); 
							break;
						}
						arrayList = addArray(arrayList,numRow,numColumn,newInput);
						print(arrayList);
						break;
					case 2: 
						System.out.println("Enter number of row");
						int arrayX = sc.nextInt() -1;
						System.out.println("Enter number of column");
						int arrayY = sc.nextInt() -1;
						System.out.println("Enter number of arrangement");
						int arrayZ = sc.nextInt() -1;
						if(arrayX<0||arrayX>arrayList.length || 
						 	arrayY<0||arrayY>arrayList[arrayX].length ||
							arrayZ<0||arrayZ>arrayList[arrayX][arrayY].length){
							System.out.println("Out of Bounds");
							break;
						}
						System.out.print("Change " + arrayList[arrayX][arrayY][arrayZ] + " to: ");
						String editedNumber = sc.next();
						arrayList[arrayX][arrayY][arrayZ]=editedNumber;
						System.out.println("Edit Done!");
						print(arrayList);
						break;
					case 3:
						print(arrayList);
						break;
					case 4:
						indicator = false;
						break;
					default:
						System.err.println("Not in the Choices");
						break;
					
				}
			}
			catch(Exception ex){
				System.out.println("Error: " + ex.getMessage());
				sc = new Scanner(System.in);
			}
			
 		}   
	}
	public static boolean checkInputInteger(String input){
		try{
			Integer.parseInt(input);
			return true;
		}
		catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}
		return false;
	}
	public static void print(String [][][]arrayList){
		try{
		for(int x = 0;x<arrayList.length;x++){	
			for(int y = 0;y<arrayList[x].length;y++){
				System.out.print("[ ");
				for(int z = 0;z<arrayList[x][y].length;z++){
					System.out.print(arrayList[x][y][z] + " ");
				}
				System.out.print("]");
			}
			System.out.println();
		}
		}catch(Exception ex){
			System.out.println("qwewqwewqwewqwewqwe");
		}
	}
	

	static String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
		  sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	public static String[][][] addArray(String [][][] givenArray, int row, int column, String addedValue) {
		String newValue = addedValue;
		int r= row;
		int c = column;
		String oldArray[][][] = givenArray;
		String[][][] newArray = new String[oldArray.length][oldArray[r].length][oldArray[r][c].length + 1];
		try{			
			for (int i = 0; i < oldArray[r][c].length; i++){
				newArray[r][c][i] = oldArray[r][c][i];
			}
			newArray[r][c][newArray[r][c].length-1] = newValue;
			
			oldArray[r][c] = newArray[r][c];
		}catch(Exception exx){
			System.out.println("error "+exx.getMessage());
		}
		return oldArray;
    }
}
