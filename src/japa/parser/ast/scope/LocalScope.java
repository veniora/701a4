package japa.parser.ast.scope;

/**
 * Created with IntelliJ IDEA.
 * User: michael
 * Date: 8/06/13
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class LocalScope extends BaseScope {
    public LocalScope(Scope parent) { super(parent); }
    public String getScopeName() { return "local"; }
}
