package processmanagement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProcessManager {
	
	private ArrayList<Process> processList = new ArrayList<>();
	private LinkedList<Process> pendingProcesses = new LinkedList<>();
	private LinkedList<Process> completedProcesses = new LinkedList<>();
	
	public void addProcess(Process process) {
		processList.add(process);
		if("Pending".equals(process.getStatus())) {
			addPendingProcess(process);
		}
		else if("Completed".equals(process.getStatus())) {
			addCompletedProcess(process);
		}
	}
	
	public boolean removeProcess(int processId) {
		Process processToRemove = null;
		for(Process process : processList) {
			if(process.getProcessId() == processId) {
				processToRemove = process;
			}
		}
		if (processToRemove != null) {
			processList.remove(processToRemove);
			if("Pending".equals(processToRemove.getStatus())) {
				pendingProcesses.remove(processToRemove);
			}else if
			("Completed".equals(processToRemove.getStatus())) {
				completedProcesses.remove(processToRemove);
			}
			return true;
		}
		return false;
	}
	
	public Process searchProcess(int processId) {
		for(Process process : processList) {
			if(process.getProcessId() == processId) {
				return process;
			}
		}
		return null;
	}
	
	public List<Process> ListAllProcesses(){
		return new ArrayList<>(processList);
	}
	
	public boolean updateProcessStatus(int processId, String newStatus) {
		for(Process process : processList) {
			if(process.getProcessId() == processId) {
				String oldStatus = process.getStatus();
				process.setStatus(newStatus);
				if("Pending".equals(oldStatus)) {
					pendingProcesses.remove(process);
				}else if("Completed". equals(oldStatus)) {
					completedProcesses.remove(process);
				}
				if("Pending".equals(newStatus)) {
					addPendingProcess(process);
				}else if ("Completed".equals(newStatus)) {
					addCompletedProcess(process);
				}
				return true;
			}
		}
		return false;
	}
	
	

	private void addCompletedProcess(Process process) {
		// TODO Auto-generated method stub
		completedProcesses.add(process);
		
	}

	private void addPendingProcess(Process process) {
		// TODO Auto-generated method stub
		pendingProcesses.add(process);
	}
	
	public List<Process> getPendingProcessesHistory(){
		return new LinkedList<>(pendingProcesses);
	}
	
	public List<Process> getCompletedProcessHistory(){
		return new LinkedList<>(completedProcesses);
	}

}



