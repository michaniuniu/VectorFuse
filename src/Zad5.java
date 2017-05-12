import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class DifferentVectorSizeException extends Exception {
	public DifferentVectorSizeException() {
		System.out.println("Ró¿na d³ugoœæ wektorów, podaj d³ugoœci jeszcze raz.");
	}
}

public class Zad5 {
	public static Scanner scanner;

	public static void main(String[] args) throws Exception {
		
		Vector[] vector = new Vector[2];
		int parmX, parmY;
		boolean ifEnd = true;
		Scanner scanner = new Scanner(System.in);
		
		do {
			for (int i = 0; i < vector.length; i++) {
				System.out.println("Podaj " + (i + 1) + ". wektor");
				parmX = ScannerInt();
				parmY = ScannerInt();
				vector[i] = new Vector(parmX, parmY);
			}

			try {
				if (vector[0].lengthVector(vector[0].getX(), vector[0].getY()) != vector[1]
						.lengthVector(vector[1].getX(), vector[1].getY())) {
					throw new DifferentVectorSizeException();
				} else {
					ifEnd = false;
					double suma = vector[0].lengthVector(vector[0].getX(), vector[0].getY())
							+ vector[1].lengthVector(vector[1].getX(), vector[1].getY());
					suma *= 100;
					suma = Math.round(suma);
					suma /= 100;
					System.out.println(suma);
					PushToFile(suma);
				}

			} catch (DifferentVectorSizeException e) {

			}

		} while (ifEnd);

		for (int i = 0; i < vector.length; i++) {
			System.out.println("D³ugoœæ wektora " + (i + 1) + ". to: "
					+ vector[i].lengthVector(vector[i].getX(), vector[i].getY()));
		}

		scanner.close();
	}

	public static class Vector {
		private int x;
		private int y;

		public Vector(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void setX(int X) {
			this.x = X;
		}

		public void setY(int Y) {
			this.y = Y;
		}

		int getX() {
			return this.x;
		}

		int getY() {
			return this.y;
		}

		public double lengthVector(int x, int y) {
			return Math.sqrt(x * x + y * y);
		}
	}

	public static int ScannerInt() {
		scanner = new Scanner(System.in);
		do {
			if (scanner.hasNextInt()) {
				return scanner.nextInt();
			} else {
				System.out.println("Podaj liczbê ca³kowit¹!");
				scanner.next();
			}
		} while (true);
	}

	public static void PushToFile(double suma) throws IOException {
		System.out.println("Podaj nazwê pliku w którym chcesz zapisaæ wynik.");
		scanner = new Scanner(System.in);
		String fileName = scanner.next();

		FileWriter fw = new FileWriter(fileName, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw);

		out.println("Suma wektorów to: " + suma + "\r\n");
		out.close();
		System.out.print("Wynik zapisano w pliku: " + fileName + "\n");

	};
}