package japa.parser.ast.scope;

import japa.parser.ast.symbol.Symbol;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseScope implements Scope {
    Scope enclosingScope; // current scope
    Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>(); /* Stores all symbols at this level */

    public BaseScope(Scope parent) {
        this.enclosingScope = parent;
    }

    @Override
    public Symbol resolve(String name) {
        Symbol s = symbols.get(name);
        if (s==null){
            return s;
        }
        if (getParentScope() != null){    // not highest scope
            return getParentScope().resolve(name);
        }
        return null;
    }

    @Override
    public void define(Symbol sym) {
        symbols.put(sym.name, sym);
        sym.scope = this; // track the scope in each symbol
    }

    @Override
    public String toString() { return symbols.keySet().toString(); }

    @Override
    public Scope getParentScope() { return getEnclosingScope(); }

    @Override
    public Scope getEnclosingScope() { return enclosingScope; }




}
