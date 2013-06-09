package japa.parser.ast.visitor;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;

/**
 * First visitor
 * Finds classes and methods and sets their scopes
 */
public class TypingVisitor extends VoidVisitorAdapter {
    @Override
    public void visit(CompilationUnit n, Object arg) {
        System.out.println("visit comp unit in typing visitor");
        super.visit(n, arg);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        super.visit(n, arg);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
        super.visit(n, arg);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
