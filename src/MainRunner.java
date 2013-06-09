import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.visitor.DumpVisitor;

import java.io.*;


public class MainRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
            String fileInput = "./Test1.javax";
            String fileOutput = fileInput.substring(0, fileInput.length()-1);

            InputStream sr = new FileInputStream(new File(fileInput));

			CompilationUnit tree = JavaParser.parse(sr);

			DumpVisitor visitor = new DumpVisitor();
			tree.accept(visitor, null);

            String output = visitor.getSource();
            // Save to *.java file
            PrintStream out = new PrintStream(new FileOutputStream(fileOutput));
            out.flush();
            out.println(output);
            System.setOut(out);
            out.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

