package japa.parser.ast.stmt;

import japa.parser.ast.visitor.GenericVisitor;
import japa.parser.ast.visitor.VoidVisitor;

/**
 * This is the custom statement type
 */
public final class ReadLineStmt extends Statement {

    @Override
    public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
