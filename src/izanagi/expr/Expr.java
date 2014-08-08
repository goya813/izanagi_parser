package izanagi.expr;

import izanagi.expr.parser.*;
import java.io.*;

public class Expr implements ExprParserVisitor
{
	public static void main(String[] args) throws ParseException, IOException 
	{
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(in);
		String line;
		while ((line = reader.readLine()) != null){
			ExprParser parser = new ExprParser(new StringReader(line));
			Expr visitor = new Expr();
			ASTStart start = parser.Start();
			System.out.println(start.jjtAccept(visitor, null));
		}
	}

	public Object visit(SimpleNode node, Object data)
	{
		return (null);
	}

	public Object visit(ASTStart node, Object data)
	{
		return (node.jjtGetChild(0).jjtAccept(this, null));
	}

	public Object visit(ASTEq node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Boolean && right instanceof Boolean){
			Boolean bleft = new Boolean(left.toString());
			Boolean bright = new Boolean(right.toString());
			return (bleft.equals(bright));
		}
		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (fleft.equals(fright));
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft.equals(iright));
	}

	public Object visit(ASTNEq node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Boolean && right instanceof Boolean){
			Boolean bleft = new Boolean(left.toString());
			Boolean bright = new Boolean(right.toString());
			return (!bleft.equals(bright));
		}
		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (!fleft.equals(fright));
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (!ileft.equals(iright));
	}

	public Object visit(ASTGe node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (fleft >= fright);
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft >= iright);
	}
	public Object visit(ASTGt node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (fleft > fright);
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft > iright);
	}
	public Object visit(ASTLe node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (fleft <= fright);
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft <= iright);
	}
	public Object visit(ASTLt node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (fleft < fright);
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft < iright);
	}

	public Object visit(ASTAdd node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);
		
		System.out.println("left  = " + left + " " + left.getClass().getName());
		System.out.println("right = " + right + " " + right.getClass().getName());

		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (fleft + fright);
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft + iright);
	}

	public Object visit(ASTSub node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (fleft - fright);
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft - iright);
	}

	public Object visit(ASTMul node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (fleft * fright);
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft * iright);
	}

	public Object visit(ASTDiv node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (fleft / fright);
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft / iright);
	}

	public Object visit(ASTMod node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (fleft % fright);
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft % iright);
	}

	public Object visit(ASTPower node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		if (left instanceof Float || right instanceof Float){
			Float fleft = new Float(left.toString());
			Float fright = new Float(right.toString());
			return (Math.pow(fleft, fright));
		}

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return ((int)Math.pow(ileft, iright));
	}

	public Object visit(ASTAnd node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft & iright);
	}

	public Object visit(ASTOr node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft | iright);
	}

	public Object visit(ASTNot node, Object data)
	{
		Object left = node.jjtGetChild(0).jjtAccept(this, null);
		Object right = node.jjtGetChild(1).jjtAccept(this, null);

		Integer ileft = new Integer(left.toString());
		Integer iright = new Integer(right.toString());

		return (ileft ^ iright);
	}

	public Object visit(ASTUniExpr node, Object data)
	{
		String value = node.nodeValue;
		Object left = node.jjtGetChild(0).jjtAccept(this, null);

		if (value.equals("-")){
			if (left instanceof Float){
				Float fleft = new Float(left.toString());
				return (-1 * fleft);
			}

			Integer ileft = new Integer(left.toString());
			return (-1 * ileft);
		}

		return (left);
	}

	public Object visit(ASTInteger node, Object data)
	{
		String value = node.nodeValue;
		return (Integer.valueOf(value));
	}

	public Object visit(ASTFloat node, Object data)
	{
		String value = node.nodeValue;
		return (Float.valueOf(value));
	}

}
