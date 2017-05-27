import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class myVector {
	
		private Vector<Integer>firstVector;
		private Vector<Integer>secondVector;
		private Vector<Integer>outVector;
		private Scanner scanner;
		private String buffer;
		private String [] split;
		private FileWriter pushToFile;

		public myVector() {
			this.firstVector = new Vector<Integer>();
			this.secondVector = new Vector<Integer>();
			this.outVector = new Vector<Integer>();
		}
		
		public void addingVector() {
			scanner = new Scanner(System.in);
			this.setFirstVector();
			this.setSecondVector();
			this.fuseVector();
		}
		
		private void setFirstVector()
		{
			System.out.println("First Vector: ");
			buffer  = scanner.nextLine();
			split = buffer.split(" ");
			
			for(String x : split)
				firstVector.addElement(Integer.parseInt(x));
		}
		
		private void setSecondVector()
		{
			System.out.println("Second Vector: ");
			buffer  = scanner.nextLine();
			split = buffer.split(" ");
			
			for(String x : split)
				secondVector.addElement(Integer.parseInt(x));
		}
		
		private void fuseVector(){
			try{
				if(firstVector.size() != secondVector.size())
					throw new DifferentVectorSizeException();
				
				for(int i=0;i<firstVector.size();i++)
					outVector.addElement(firstVector.get(i)+secondVector.get(i));
				
				this.savingData();
				
			}catch(DifferentVectorSizeException e){
				do{
					
					System.out.println("Length of first vector was: " 
							+ firstVector.size());
					this.setFirstVector();
					
					System.out.println("Length of second vector was: " 
							+ secondVector.size());		
					this.setSecondVector();
					
				}while(firstVector.size()!=secondVector.size());
			}catch(IOException e){
				
			}
		}
		
		private void savingData() throws IOException{
			String file = "Vector.txt";
			pushToFile = new FileWriter(file);
			pushToFile.write(outVector.toString());
			pushToFile.close();
		}
		
		
	}