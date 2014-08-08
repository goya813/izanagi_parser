package izanagi.expr.shell;

public class ShellValue
{
	public static final int TYPE_NONE = 0;
	public static final int TYPE_INTEGER = 1;
	public static final int TYPE_FLOAT = 2;
	public static final int TYPE_STRING = 3;
	public static final int TYPE_BOOLEAN = 4;

	private String mValue;
	private int mType;

	public ShellValue()
	{
		this(null, TYPE_NONE);
	}

	public ShellValue(String value, int type)
	{
		mValue = value;
		mType = type;
	}

	public ShellValue(ShellValue v)
	{
		this(v.getValue(), v.getType());
	}

	public String getValue()
	{
		return (mValue);
	}
	public void setValue(String value)
	{
		mValue = value;
	}

	public int getType()
	{
		return (mType);
	}
	public void setType(int type)
	{
		mType = type;
	}

	public boolean isNone()
	{
		return (mType == TYPE_NONE);
	}
	public boolean isInteger()
	{
		return (mType == TYPE_INTEGER);
	}
	public boolean isFloat()
	{
		return (mType == TYPE_FLOAT);
	}
	public boolean isString()
	{
		return (mType == TYPE_STRING);
	}
	public boolean isBOOLEAN()
	{
		return (mType == TYPE_BOOLEAN);
	}

	public void minus()
	{
		if (isFloat()){
			Float value = Float.valueOf(getValue());
			float result = value * (-1);
			setValue("" + result);
			return;
		}

		Integer value = Integer.valueOf(getValue());
		int result = value * (-1);
		setValue("" + result);
	}

	public void add(ShellValue v)
	{
		if (isString() || v.isString()){
			setType(TYPE_STRING);
			setValue(getValue() + v.getValue());
			return;
		}
		else if (isFloat() || v.isFloat()){
			setType(TYPE_FLOAT);
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			float result = left + right;
			setValue("" + result);
			return;
		}
		
		setType(TYPE_INTEGER);
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		int result = left + right;
		setValue("" + result);
	}

	public void sub(ShellValue v)
	{
		if (isFloat() || v.isFloat()){
			setType(TYPE_FLOAT);
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			float result = left - right;
			setValue("" + result);
			return;
		}
		
		setType(TYPE_INTEGER);
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		int result = left - right;
		setValue("" + result);
	}

	public void mul(ShellValue v)
	{
		if (isFloat() || v.isFloat()){
			setType(TYPE_FLOAT);
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			float result = left * right;
			setValue("" + result);
			return;
		}
		
		setType(TYPE_INTEGER);
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		int result = left * right;
		setValue("" + result);
	}
	public void div(ShellValue v)
	{
		if (isFloat() || v.isFloat()){
			setType(TYPE_FLOAT);
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			float result = left / right;
			setValue("" + result);
			return;
		}
		
		setType(TYPE_INTEGER);
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		int result = left / right;
		setValue("" + result);
	}
	public void mod(ShellValue v)
	{
		if (isFloat() || v.isFloat()){
			setType(TYPE_FLOAT);
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			float result = left % right;
			setValue("" + result);
			return;
		}
		
		setType(TYPE_INTEGER);
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		int result = left % right;
		setValue("" + result);
	}
	public void power(ShellValue v)
	{
		if (isFloat() || v.isFloat()){
			setType(TYPE_FLOAT);
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			float result = (float)Math.pow(left, right);
			setValue("" + result);
			return;
		}
		
		setType(TYPE_INTEGER);
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		int result = (int)Math.pow(left, right);
		setValue("" + result);
	}
	public void and(ShellValue v)
	{
		setType(TYPE_INTEGER);
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		int result = left & right;
		setValue("" + result);
	}
	public void or(ShellValue v)
	{
		setType(TYPE_INTEGER);
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		int result = left | right;
		setValue("" + result);
	}
	public void not(ShellValue v)
	{
		setType(TYPE_INTEGER);
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		int result = left ^ right;
		setValue("" + result);
	}
	public boolean EQ(ShellValue v)
	{
		setType(TYPE_BOOLEAN);

		if (getType() == TYPE_BOOLEAN && v.getType() == TYPE_BOOLEAN){
			Boolean left = Boolean.valueOf(getValue());
			Boolean right = Boolean.valueOf(v.getValue());
			if (left.equals(right)){
				setValue("" + true);
			}
			else {
				setValue("" + false);
			}
			return (Boolean.valueOf(getValue()));
		}
		else if (isFloat() || v.isFloat()){
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			if (left.equals(right)){
				setValue("" + true);
			}
			else {
				setValue("" + false);
			}
			return (Boolean.valueOf(getValue()));
		}
		
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		if (left.equals(right)){
			setValue("" + true);
		}
		else {
			setValue("" + false);
		}
		return (Boolean.valueOf(getValue()));
	}
	public boolean NEQ(ShellValue v)
	{
		setType(TYPE_BOOLEAN);

		if (getType() == TYPE_BOOLEAN && v.getType() == TYPE_BOOLEAN){
			Boolean left = Boolean.valueOf(getValue());
			Boolean right = Boolean.valueOf(v.getValue());
			if (!left.equals(right)){
				setValue("" + true);
			}
			else {
				setValue("" + false);
			}
			return (Boolean.valueOf(getValue()));
		}
		if (isFloat() || v.isFloat()){
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			if (!left.equals(right)){
				setValue("" + true);
			}
			else {
				setValue("" + false);
			}
			return (Boolean.valueOf(getValue()));
		}
		
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		if (!left.equals(right)){
			setValue("" + true);
		}
		else {
			setValue("" + false);
		}
		return (Boolean.valueOf(getValue()));
	}
	public boolean GE(ShellValue v)
	{
		setType(TYPE_BOOLEAN);

		if (isFloat() || v.isFloat()){
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			if (left >= right){
				setValue("" + true);
			}
			else {
				setValue("" + false);
			}
			return (Boolean.valueOf(getValue()));
		}
		
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		if (left >= right){
			setValue("" + true);
		}
		else {
			setValue("" + false);
		}
		return (Boolean.valueOf(getValue()));
	}
	public boolean GT(ShellValue v)
	{
		setType(TYPE_BOOLEAN);

		if (isFloat() || v.isFloat()){
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			if (left > right){
				setValue("" + true);
			}
			else {
				setValue("" + false);
			}
			return (Boolean.valueOf(getValue()));
		}
		
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		if (left > right){
			setValue("" + true);
		}
		else {
			setValue("" + false);
		}
		return (Boolean.valueOf(getValue()));
	}
	public boolean LE(ShellValue v)
	{
		setType(TYPE_BOOLEAN);

		if (isFloat() || v.isFloat()){
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			if (left <= right){
				setValue("" + true);
			}
			else {
				setValue("" + false);
			}
			return (Boolean.valueOf(getValue()));
		}
		
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		if (left <= right){
			setValue("" + true);
		}
		else {
			setValue("" + false);
		}
		return (Boolean.valueOf(getValue()));
	}
	public boolean LT(ShellValue v)
	{
		setType(TYPE_BOOLEAN);

		if (isFloat() || v.isFloat()){
			Float left = Float.valueOf(getValue());
			Float right = Float.valueOf(v.getValue());
			if (left < right){
				setValue("" + true);
			}
			else {
				setValue("" + false);
			}
			return (Boolean.valueOf(getValue()));
		}
		
		Integer left = Integer.valueOf(getValue());
		Integer right = Integer.valueOf(v.getValue());
		if (left < right){
			setValue("" + true);
		}
		else {
			setValue("" + false);
		}
		return (Boolean.valueOf(getValue()));
	}

	@Override
	public String toString()
	{
		return ("value = " + mValue + ", " + "type = " + mType);
	}
}
