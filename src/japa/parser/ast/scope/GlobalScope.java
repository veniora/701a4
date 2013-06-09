package japa.parser.ast.scope;

/**
 * Created with IntelliJ IDEA.
 * User: michael
 * Date: 8/06/13
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class GlobalScope extends BaseScope {
    public GlobalScope() { super(null); }
    public String getScopeName() { return "global"; }
}
