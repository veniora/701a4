package japa.parser.ast.visitor;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.*;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.scope.Scope;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.type.Type;
import japa.parser.ast.symbol.VariableSymbol;

/**
 * Second visitor
 * This visitor will identify all variable and field declarations and add them to the correct scopes
 */
public final class DefinitionVisitor extends VoidVisitorAdapter{

    Scope currentScope;

    /* First four visits set scope for subsequent ones */

    @Override
    public void visit(CompilationUnit n, Object arg) {
        currentScope = (Scope) n.getData();
        super.visit(n, arg);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
        currentScope = (Scope) n.getData();
        super.visit(n, arg);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        currentScope = (Scope) n.getData();
        super.visit(n, arg);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void visit(BlockStmt n, Object arg) {
        currentScope = (Scope) n.getData();
        super.visit(n, arg);
        currentScope = currentScope.getEnclosingScope();
    }
    /* End scope setters */


    @Override
    public void visit(Parameter n, Object arg) {
        VariableSymbol symbol = new VariableSymbol(n.getId().getName(), null);
        currentScope.define(symbol);
        super.visit(n, arg);
    }


    @Override
    public void visit(FieldDeclaration n, Object arg) {

        for (VariableDeclarator var: n.getVariables()){
            /* TODO to the max - resolve the wtf-ery of conflicting Types and remove the null */
            VariableSymbol symbol = new VariableSymbol(var.getId().getName(), null);
            currentScope.define(symbol);
        }
        super.visit(n, arg);
    }

    @Override
    public void visit(VariableDeclarationExpr n, Object arg) {
        for (VariableDeclarator var: n.getVars()){
            VariableSymbol symbol = new VariableSymbol(var.getId().getName(), null);
            currentScope.define(symbol);
        }
        super.visit(n, arg);
    }
}
