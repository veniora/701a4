package japa.parser.ast.symbol;

import japa.parser.ast.scope.Scope;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: michael
 * Date: 8/06/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class MethodSymbol extends ScopedSymbol {
    Map<String, Symbol> orderedArgs = new LinkedHashMap<String, Symbol>();

    public MethodSymbol(String name, Type retType, Scope parent) {
        super(name, retType, parent);
    }

    public Map<String, Symbol> getMembers() { return orderedArgs; }

    public String getName() {
        return name+"("+stripBrackets(orderedArgs.keySet().toString())+")";
    }
}
