package processmanagement;

public class Main {

	
	    public static void main(String[] args) {
	        ProcessManager processManager = new ProcessManager();

	        Process p1 = new Process(1, "Process1", "Pending");
	        Process p2 = new Process(2, "Process2", "Running");
	        Process p3 = new Process(3, "Process3", "Completed");

	        processManager.addProcess(p1);
	        processManager.addProcess(p2);
	        processManager.addProcess(p3);

	        System.out.println("All Processes:");
	        for (Process process : processManager.ListAllProcesses()) {
	            System.out.println(process);
	        }

	        System.out.println("\nSearch Process ID 2:");
	        System.out.println(processManager.searchProcess(2));

	        System.out.println("\nUpdate Process ID 2 to Completed:");
	        processManager.updateProcessStatus(2, "Completed");

	        System.out.println("\nAll Processes After Update:");
	        for (Process process : processManager.ListAllProcesses()) {
	            System.out.println(process);
	        }

	        System.out.println("\nPending Processes History:");
	        for (Process process : processManager.getPendingProcessesHistory()) {
	            System.out.println(process);
	        }

	        System.out.println("\nCompleted Processes History:");
	        for (Process process : processManager.getCompletedProcessHistory()) {
	            System.out.println(process);
	        }

	        System.out.println("\nRemove Process ID 1:");
	        processManager.removeProcess(1);

	        System.out.println("\nAll Processes After Removal:");
	        for (Process process : processManager.ListAllProcesses()) {
	            System.out.println(process);
	        }
	    }
	
}
