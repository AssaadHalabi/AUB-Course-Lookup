package Cmps252;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public interface ParseSchedule {
	Map<String, Icourse> parseAllFiles() throws IOException;
}
