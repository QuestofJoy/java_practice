import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static String[] listOfTasks = new String[100];
	static int lineNum = 0;
	public static final String CURRENT_DIR = System.getProperty("user.dir");
	public static final File file = new File(CURRENT_DIR, "task.txt");
	public static final String FILE_PATH = file.getPath(); 

	// loads file and data. also creates the file if the file is not detected.
	static void loadFile() {
		try {
			File file = new File(FILE_PATH);
			if (file.createNewFile()) {
				System.out.println("Required file created: " + file.getName());
			}
		} catch (IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}

	static void loadTask() {
		try (
			FileReader rof = new FileReader(FILE_PATH);
			BufferedReader brof = new BufferedReader(rof)) {
			String line;
			lineNum=0;

			while ((line = brof.readLine()) != null) {
				listOfTasks[lineNum] = line;
				lineNum++;
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
	}

	static void writeToFile(String task) {
		try (
			FileWriter wtf = new FileWriter(FILE_PATH, true);
			BufferedWriter bw = new BufferedWriter(wtf)) {
			bw.write(task);
			bw.newLine();
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			e.printStackTrace();
		}

	}

	static void readFromFile(String FILE_PATH) {
		loadTask();
		System.out.println("\n\nYour List of Tasks");
		System.out.println("----------------------");
		for (int i = 0; i < lineNum; i++) {
			System.out.printf("%d. %s\n",i+1, listOfTasks[i]);
		}
		System.out.println("----------------------\n\n");
	}

	////
	static void deleteTask (int deleteLine) {
		lineNum = 0;
		try (
			FileReader rof = new FileReader(FILE_PATH);
			BufferedReader brof = new BufferedReader(rof)) {
			String line;
			int currentLine=0;

			while ((line = brof.readLine()) != null) {
				if(currentLine == deleteLine - 1) {
					currentLine++;
					continue;
				}
				listOfTasks[lineNum] = line;
				lineNum++;
				currentLine++;
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}


		try (FileWriter fw = new FileWriter(FILE_PATH, false)) {

		} catch (IOException e) {
			System.err.println("Error clearing file: " + e.getMessage());
		}

		try (
			FileWriter wtf = new FileWriter(FILE_PATH, true);
			BufferedWriter bw = new BufferedWriter(wtf)) {
			for(int i = 0; i < lineNum; i++) {
			bw.write(listOfTasks[i]);
			bw.newLine();
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Task deleted Successfully!!!");
	}


	public static void main(String[] args) {
		loadFile();
		loadTask();

		Scanner scan = new Scanner(System.in);
		boolean running = true;
		int inp;

		while (running) {
			System.out.println("\n===============");
			System.out.println("  To-do-list");
			System.out.println("===============");
			System.out.println("1. Add Tasks");
			System.out.println("2. Delete Tasks");
			System.out.println("3. View Tasks");
			System.out.println("4. Exit");
			System.out.println("---------------\n");
			System.out.printf("Enter an option: ");

			inp = scan.nextInt();
			scan.nextLine();

			switch (inp) {
				case 1:
					System.out.printf("Enter task: ");
					String task = scan.nextLine();
					writeToFile(task);
					System.out.printf("New task added!!!\n\n");
					break;
				case 2:
					System.out.printf("Enter the task you want to delete: ");
					int deleteLine = scan.nextInt();
					deleteTask(deleteLine);
					break;
				case 3:
					readFromFile(FILE_PATH);
					break;
				case 4:
					running = false;
					break;

				default:
					System.out.printf("Please enter a valid number!!!\n");
					break;
			}

		}
		scan.close();
	}
}
