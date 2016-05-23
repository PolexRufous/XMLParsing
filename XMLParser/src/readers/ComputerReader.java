package readers;

import entities.Computer;

public interface ComputerReader {
	
	Computer generateCompInstance(String xmlFileName);
	Computer getCompInstanse();
	
}
