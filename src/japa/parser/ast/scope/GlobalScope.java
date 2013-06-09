package japa.parser.ast.scope;

import japa.parser.ast.symbol.BuiltInTypeSymbol;

public class GlobalScope extends BaseScope {
    public GlobalScope() {
        super(null);
        define(new BuiltInTypeSymbol("int"));
        define(new BuiltInTypeSymbol("String"));
    }
    public String getScopeName() { return "global"; }
}
