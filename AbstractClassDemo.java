abstract class Shape
{
	String shapetype;
	Shape(String shapetype)
	{
		this.shapetype=shapetype;
	}
	String dispShape()
	{
		return "Shape Type: " + shapetype;
	}
	abstract double area();
}
class Square extends Shape
{
	double side;
	Square(String shapetype,double side)
	{
		super(shapetype);
		this.side=side;
	}
	String dispShape()
	{
		return super.dispShape();
	}
	double area()
	{
		return side*side;
	}
}
class Circle extends Shape
{
	double radius;
	Circle(String shapetype,double radius)
	{
		super(shapetype);
		this.radius=radius;
	}
	String dispShape()
	{
		return super.dispShape();
	}
	double area()
	{
		return 3.14*radius*radius;
	}
}
class AbstractClassDemo
{
	public static void main(String[] args)
	{
		Square sq = new Square("SQUARE",12.5);
		Circle c = new Circle("CIRCLE",3.5);
		System.out.println(sq.dispShape() + " Area: " + sq.area());
		System.out.println(c.dispShape() + " Area: " + c.area());
	}
}


