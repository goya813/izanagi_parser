/* Generated By:JJTree: Do not edit this line. ASTNot.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=izanagi.expr.BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package izanagi.expr.parser;

public
class ASTNot extends SimpleNode {
  public ASTNot(int id) {
    super(id);
  }

  public ASTNot(ExprParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(ExprParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=f31953c4dfa3f553c65439b64594cf9e (do not edit this line) */
