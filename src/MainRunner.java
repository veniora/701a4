import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.visitor.DefinitionVisitor;
import japa.parser.ast.visitor.DumpVisitor;
import japa.parser.ast.visitor.ResolvingVisitor;
import japa.parser.ast.visitor.TypingVisitor;

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

            /* Find all of the classes and methods */
            TypingVisitor vType = new TypingVisitor();
            tree.accept(vType, null);

            /* Find all variables */
            DefinitionVisitor vDef = new DefinitionVisitor();
            tree.accept(vDef, null);

            /* Resolve symbols*/
            ResolvingVisitor vRes = new ResolvingVisitor();
            tree.accept(vRes, null);

            /* Print out the contents of the java file */
            DumpVisitor vDump = new DumpVisitor();
            tree.accept(vDump, null);

            String output = vDump.getSource();
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

