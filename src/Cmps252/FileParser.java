package Cmps252;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public interface FileParser {
	Map<String, Icourse> Parse(String fileName) throws IOException;
}
