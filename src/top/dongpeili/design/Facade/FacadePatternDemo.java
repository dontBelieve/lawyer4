package top.dongpeili.design.Facade;

/**
 * @summary 使用外观类画出各种形状
 * @date 2017年12月20日
 * @author dpl
 */
public class FacadePatternDemo {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}
