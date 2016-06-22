OO题

设计一个形状类Shape,方法:求周长和求面积
  形状类的子类:Rect(矩形),Circle(圆形)
  Rect类的子类:Square(正方形)
  不同的子类会有不同的计算周长和面积的方法
  创建三个不同的形状对象,放在Shape类型的数组里,分别打印出每个对象的周长和面积
 
 
package day0419;
public abstract class Shape {
 public abstract double getZhouChang();
 
 public abstract double getMianJi();
 
}
 
package day0419;
public class Rect extends Shape {
 private double length;
 private double width;
 // 构造方法
 public Rect(double length, double width) {
  this.length = length;
  this.width = width;
 }
 public Rect() {
 }
 public double getZhouChang() {
  return (length + width) * 2;
 }
 public double getMianJi() {
  return length * width;
 }
 public double getLength() {
  return length;
 }
 public double getWidth() {
  return width;
 }
 public void setLength(double length) {
  this.length = length;
 }
 public void setWidth(double width) {
  this.width = width;
 }
}
package day0419;
public class Circle extends Shape {
 private double banjing;
 
 public Circle(double banjing) {
  this.banjing = banjing;
 }
 public Circle(){
  
 }
 public double getBanJing() {
 
  return banjing;
 }
 public void setBanJing(double banjing) {
  this.banjing = banjing;
 }
 public double getZhouChang() {
  
  return Math.PI*banjing*2;
 }
 public double getMianJi() {
 
  return Math.PI*banjing*banjing;
 }
}
 
 
 
package day0419;
public class Square extends Rect {
 public Square(double len) {
  // 调用父类构造方法
  super (len,len);
 }
 public Square() {
  
  super ();
 }
}
package day0419;
public class ShapeTest {
 public static void main(String args[]) {
  Shape[] ss = new Shape[3];
  Rect r = new Rect();
  r.setLength(3);
  r.setWidth(2);
  // ss[0] = new Rect(3,2);
  ss[0] = r;
  ss[1] = new Circle(2);
  ss[2] = new Square(4);
  for (int i = 0; i < ss.length; i++) {
   System.out.println(ss[i].getZhouChang());
   System.out.println(ss[i].getMianJi());
  }
 }
}